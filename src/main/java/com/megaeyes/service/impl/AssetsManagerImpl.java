/**   
* @Title: AssetsManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-5 上午8:39:31 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpAssetsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRAssetsVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AccessServerExample;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;
import com.megaeyes.persistence.ibatis.model.EpAssets;
import com.megaeyes.persistence.ibatis.model.EpAssetsExample;
import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.model.EpDeviceExample;
import com.megaeyes.persistence.ibatis.model.EpRAssetsVic;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputServerExample;
import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AsssetsManager;

/** 
 * @ClassName: AssetsManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-5 上午8:39:31 
 *  
 */
public class AssetsManagerImpl extends BaseManagerImpl implements AsssetsManager {

	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpAssetsDAOiBatis epAssetsDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpRAssetsVicDAOiBatis epRAssetsVicDAO;
	@Autowired
	EpDeviceDAOiBatis epDeviceDAO;
	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	
	
	public String createEpAssets(String name, BigDecimal type, BigDecimal useTime,
			BigDecimal expirationTime, BigDecimal significantLevel,
			String note, String deviceNumber, String organId,String installLocation)throws BusinessException{
		
		if(StringUtils.isNotBlank(organId)){
			OrganExample oExample = new OrganExample();  
			oExample.createCriteria().andIdEqualTo(organId);
			int count = organDAO.countByExample(oExample);
			if(count==0){
				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
			}//判断传入的机构ID是否对的，错了就抛个异常
		}
		
//		if(StringUtils.isNotBlank(deviceNumber)){
//			EpAssetsExample eaExample = new EpAssetsExample();
//			EpAssetsExample.Criteria criteria = eaExample.createCriteria();
//			criteria.andDeviceNumberEqualTo(deviceNumber);
//			int count = epAssetsDAO.countByExample(eaExample);
//			if (count > 0) {
//				throw new BusinessException("deviceNumber",
//						ErrorCode.DEVICE_NUMBER_DUPLICATE);
//			}
//		}else{
//			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
//		}
		
		if(StringUtils.isNotBlank(name)){
			EpDeviceExample edExample = new EpDeviceExample();
			EpDeviceExample.Criteria criteria = edExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			int count = epDeviceDAO.countByExample(edExample);
			if (count > 0) {
				throw new BusinessException("name",
						ErrorCode.NAME_EXIST);
			}
		}
		
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		String id = sequenceDAO.getEpDeviceSeq();
		System.out.println("id:"+id);
		EpDevice ed = new EpDevice();
		ed.setId(id);
		ed.setName(name);
		ed.setNote(note);
		ed.setOrganId(organId);
		ed.setParentId("");
		ed.setType(new BigDecimal(1));
		epDeviceDAO.insert(ed);
		
		EpAssets ea = new EpAssets();
		ea.setId(id);
		ea.setDeviceNumber(deviceNumber);
		ea.setExpirationTime(expirationTime);
		ea.setSignificantLevel(significantLevel);
		ea.setType(type);
		ea.setInstallLocation(installLocation);
		ea.setUseTime(useTime);
		
		epAssetsDAO.insert(ea);
		return id;
	}

	
	public void deleteEpAssets(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String str_array[] = id.split(",");
		for(int i=0;i<str_array.length;i++){
			try{
				//删除资产管理时先删除关系表记录
				EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
				EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
				criteria.andDeviceIdEqualTo(str_array[i]);
				epRMonitorDeviceDAO.deleteByExample(ermdExample);
				epDeviceDAO.deleteByPrimaryKey(str_array[i]);
			
				epAssetsDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
		
	}

	
	public List<EpAssetsAndDeviceVO> listEpAssets() throws BusinessException {
		return epAssetsDAO.listEpAssets();
	}

	
	public List<EpAssetsAndDeviceVO> listEAByOrganId(String organId) throws BusinessException {
		if(StringUtils.isNotBlank(organId)){
			OrganExample oExample = new OrganExample();  
			oExample.createCriteria().andIdEqualTo(organId);
			int count = organDAO.countByExample(oExample);
			if(count==0){
				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
			}//判断传入的机构ID是否对的，错了就抛个异常
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epAssetsDAO.listEAByOrganId(organId);
	}

	
	public void updateEpAssets(String id, String name, BigDecimal type,
			BigDecimal useTime, BigDecimal expirationTime,
			BigDecimal significantLevel, String note,
			String deviceNumber, String organId,String installLocation)throws BusinessException {
		
		if(StringUtils.isNotBlank(organId)){
			OrganExample oExample = new OrganExample();  
			oExample.createCriteria().andIdEqualTo(organId);
			int count = organDAO.countByExample(oExample);
			if(count==0){
				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
			}//判断传入的机构ID是否对的，错了就抛个异常
		}else{
			throw new BusinessException("organId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		
//		if(StringUtils.isNotBlank(deviceNumber)){
//			EpAssetsExample eaExample = new EpAssetsExample();
//			EpAssetsExample.Criteria criteria = eaExample.createCriteria();
//			criteria.andDeviceNumberEqualTo(deviceNumber);
//			List<EpAssets> list = epAssetsDAO.selectByExample(eaExample);
//			if (list.size() > 0) {
//				if (!id.equals(list.get(0).getId())) {
//					if (deviceNumber.equals(list.get(0).getDeviceNumber()))
//						throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
//				}
//			}
//		}else{
//			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
//		}
		
		if(StringUtils.isNotBlank(name)){
			EpDeviceExample edExample = new EpDeviceExample();
			EpDeviceExample.Criteria criteria = edExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			List<EpDevice> list = epDeviceDAO.selectByExample(edExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (name.equals(list.get(0).getName()))
						throw new BusinessException("name",ErrorCode.NAME_EXIST);
				}
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(type.equals("")||type==null){
			throw new BusinessException("type",ErrorCode.PARAMETER_NOT_FOUND);	
		}
		EpDevice ed = new EpDevice();
		ed.setId(id);
		ed.setName(name);
		ed.setNote(note);
		ed.setOrganId(organId);
		ed.setParentId("");
		ed.setType(new BigDecimal(1));
		epDeviceDAO.updateByPrimaryKeySelective(ed);
		
		EpAssets ea = new EpAssets();
		ea.setId(id);
		ea.setType(type);
		ea.setUseTime(useTime);
		ea.setExpirationTime(expirationTime);
		ea.setSignificantLevel(significantLevel);
		ea.setDeviceNumber(deviceNumber);
		ea.setInstallLocation(installLocation);
		epAssetsDAO.updateByPrimaryKeySelective(ea);
	}

	public void addOrUpdateEpRAssetsVic(String jsonString)
			throws BusinessException, JSONException {
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		JSONObject jsonObject = new JSONObject(jsonString);
		String assetsId = jsonObject.getString("assetsId");
		epRAssetsVicDAO.deleteByAssetsId(assetsId);
		JSONArray jsonArray = jsonObject.getJSONArray("vicIds");
		if(jsonArray.length()>0){
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
				String vicId = jsonObj.getString("vicId");
				String id = sequenceDAO.getEpRAssetsSeq();
				EpRAssetsVic rpv = new EpRAssetsVic();
				rpv.setAssetsId(assetsId);
				rpv.setId(id);
				rpv.setVicId(vicId);
				epRAssetsVicDAO.insert(rpv);
			}
		}
	}
	
	
	public List<ListVicVO> listVicByAssetsId(String assetsId) {
		if(StringUtils.isBlank(assetsId)){
			throw new BusinessException("assetsId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epAssetsDAO.listVicByAssetsId(assetsId);
	}



	
}
