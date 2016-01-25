/**   
 * @Title: EpIntelligentDetectionManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-5-2 上午3:10:22 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpIntelligentDetectionDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.model.EpDeviceExample;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannelExample;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.vo.EpIntelligentDetectionAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByIntelligentVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpIntelligentDetectionManager;

/**
 * @ClassName: EpIntelligentDetectionManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午3:10:22
 * 
 */
public class EpIntelligentDetectionManagerImpl extends BaseManagerImpl
		implements EpIntelligentDetectionManager {

	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpDeviceDAOiBatis epDeviceDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpIntelligentDetectionDAOiBatis epIntelligentDetectionDAO;
	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	@Autowired
	EpProberManagerImpl epProberManager;

	@Override
	public String createEID(String name, String organId, String parentId,
			String note, BigDecimal type,String operation) throws BusinessException {

		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(type==null||type.equals("")){
			throw new BusinessException("type",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(!type.equals(new BigDecimal(3))&&!type.equals(new BigDecimal(4))){
			throw new BusinessException("typeError",ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if(StringUtils.isBlank(operation)){
			throw new BusinessException("operation", ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		String id = sequenceDAO.getEpDeviceSeq();
		EpDevice ed = new EpDevice();
		ed.setId(id);
		ed.setName(name);
		ed.setOrganId(organId);
		ed.setNote(note);
		ed.setType(type);
		ed.setParentId(parentId);
		ed.setOperation(operation);
		epDeviceDAO.insert(ed);
		return id;
	}

	@Override
	public void deleteEID(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				
				EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
				EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
				criteria.andDeviceIdEqualTo(str_array[i]);
				List<EpRMonitorDevice> listERMD = epRMonitorDeviceDAO.selectByExample(ermdExample);
				if(listERMD.size()>0){
					for(int m=0;m<listERMD.size();m++){
						epProberManager.deleteEpProber(listERMD.get(m).getMonitorId());//删除智能监测设备区下的探测器
					}
				}
				//删除智能监测设备区时先删除关系表记录
				epRMonitorDeviceDAO.deleteByExample(ermdExample);
				
				
				//删除智能监测设备时先删除设备区下设备以及设备下的探测器
				EpDeviceExample edExample = new EpDeviceExample();
				EpDeviceExample.Criteria criteria2 = edExample.createCriteria();
				criteria2.andParentIdEqualTo(str_array[i]);
				List<EpDevice> list = epDeviceDAO.selectByExample(edExample);
				if(list.size()>0){
					for(int n=0;n<list.size();n++){
						deleteEID(list.get(n).getId());
					}
				}
			
				epDeviceDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	@Override
	public void updateEID(String id, String name, String organId,
			String parentId, String note, BigDecimal type,String operation)
			throws BusinessException {

		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpDevice ed = epDeviceDAO.selectByPrimaryKey(id);
		ed.setName(name);
		ed.setOperation(operation);
		epDeviceDAO.updateByPrimaryKeySelective(ed);
	}

	@Override
	public List<EpIntelligentDetectionAndDeviceVO> listEIDByOrganId(
			String organId) throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epIntelligentDetectionDAO.listEIDByOrganId(organId);
	}
 	@Override
	public List<EpDevice> listEIDAndDomainByOrganId(String organId)
			throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		EpDeviceExample example2 = new EpDeviceExample();
		EpDeviceExample.Criteria criteria2 = example2.createCriteria();	
		criteria2.andTypeEqualTo(new BigDecimal(3));
		criteria2.andOrganIdEqualTo(organId);
		
		List devices = epDeviceDAO.selectByExample(example2);		
		
		List domains = epDeviceDAO.listDomainsByOrganId(organId);
		
		if(devices!=null){
			domains.addAll(devices);
		}

		return domains;
	}

	@Override
	public List<ListDeviceByIntelligentVO> listDeviceByIntelligentId(String intelligentId,String organId)
			throws BusinessException {
		if(StringUtils.isBlank(intelligentId)){
			throw new BusinessException("intelligentId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epDeviceDAO.listDeviceByIntelligentId(intelligentId,organId);
	}
 	
}
