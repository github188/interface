/**   
* @Title: EpDeviceLinesManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-28 上午8:01:30 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import bsh.StringUtil;

import com.megaeyes.persistence.ibatis.impl.EpDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.model.EpDeviceExample;
import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpDeviceLinesManager;

/** 
 * @ClassName: EpDeviceLinesManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-28 上午8:01:30 
 *  
 */
public class EpDeviceLinesManagerImpl extends BaseManagerImpl implements EpDeviceLinesManager {
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	EpDeviceDAOiBatis epDeviceDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	@Autowired
	EpControlServerManagerImpl epControlServerManager;
	
	@Override
	public String createEDL(String name, String organId, String parentId,
			String note) throws BusinessException {
//		if(StringUtils.isNotBlank(organId)){
//			OrganExample oExample = new OrganExample();  
//			oExample.createCriteria().andIdEqualTo(organId);
//			int count = organDAO.countByExample(oExample);
//			if(count==0){
//				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
//			}//判断传入的机构ID是否对的，错了就抛个异常
//		}

		
		
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			if(StringUtils.isNotBlank(name)){
				EpDeviceExample edExample = new EpDeviceExample();
				EpDeviceExample.Criteria criteria = edExample.createCriteria();
				criteria.andNameEqualTo(name);
				int count = epDeviceDAO.countByExample(edExample);
				if (count > 0) {
					throw new BusinessException("name",
							ErrorCode.NAME_EXIST);
				}
			}
		}
//		if (StringUtils.isBlank(organId)) {
//			throw new BusinessException("organId", ErrorCode.PARAMETER_NOT_FOUND);
//		}
		
		String id = sequenceDAO.getEpDeviceSeq();
		EpDevice ed = new EpDevice();
		ed.setId(id);
		ed.setName(name);
		ed.setNote(note);
		ed.setOrganId(organId);
		ed.setParentId("");
		ed.setType(new BigDecimal(2));
		epDeviceDAO.insert(ed);
		
		return id;
	}

	@Override
	public void deleteEDL(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for(int i=0;i<str_array.length;i++){
			try{
				//删除输电线路下的太阳能控制器
				EpRMonitorDeviceExample erdExample = new EpRMonitorDeviceExample();
				EpRMonitorDeviceExample.Criteria criteria1 = erdExample.createCriteria();
				criteria1.andDeviceIdEqualTo(str_array[i]);
				List<EpRMonitorDevice> list = epRMonitorDeviceDAO.selectByExample(erdExample);
				for(int n=0;n<list.size();n++){
					epControlServerManager.deleteECS(list.get(n).getMonitorId());
				}
				//删除线路时先删除关系表记录
				EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
				EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
				criteria.andDeviceIdEqualTo(str_array[i]);
				epRMonitorDeviceDAO.deleteByExample(ermdExample);
			
				epDeviceDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed", ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	@Override
	public List<EpDevice> listEDLByOrganId(String organId) {
//		if(StringUtils.isNotBlank(organId)){
//			OrganExample oExample = new OrganExample();  
//			oExample.createCriteria().andIdEqualTo(organId);
//			int count = organDAO.countByExample(oExample);
//			if(count==0){
//				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
//			}//判断传入的机构ID是否对的，错了就抛个异常
//		}
//		if(StringUtils.isBlank(organId)){
//			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
//		}
		return epDeviceDAO.listEDLByOrganId(organId);
	}

	@Override
	public void updateEDL(String id, String name, String organId,
			String parentId, String note) throws BusinessException {
//		if(StringUtils.isNotBlank(organId)){
//			OrganExample oExample = new OrganExample();  
//			oExample.createCriteria().andIdEqualTo(organId);
//			int count = organDAO.countByExample(oExample);
//			if(count==0){
//				throw new BusinessException("organId", ErrorCode.RESOURCE_NOT_FOUND);
//			}//判断传入的机构ID是否对的，错了就抛个异常
//		}
//		
//		if (StringUtils.isBlank(organId)) {
//			throw new BusinessException("organId", ErrorCode.PARAMETER_NOT_FOUND);
//		}
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			if(StringUtils.isNotBlank(name)){
				EpDeviceExample edExample = new EpDeviceExample();
				EpDeviceExample.Criteria criteria = edExample.createCriteria();
				criteria.andNameEqualTo(name);
				List<EpDevice> list = epDeviceDAO.selectByExample(edExample);
				if (list.size() > 0) {
					if (!id.equals(list.get(0).getId())) {
						if (name.equals(list.get(0).getName()))
							throw new BusinessException("name",ErrorCode.NAME_EXIST);
					}
				}
			}
		}
		
		
		EpDevice ed = new EpDevice();
		ed.setId(id);
		ed.setName(name);
		ed.setNote(note);
		ed.setOrganId(organId);
		ed.setParentId("");
		ed.setType(new BigDecimal(2));
		
		epDeviceDAO.updateByPrimaryKeySelective(ed);
	}

	@Override
	public List<ListVicVO> listDeviceByLinesId(String linesId)
			throws BusinessException {
		if(StringUtils.isBlank(linesId)){
			throw new BusinessException("linesId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epDeviceDAO.listDeviceByDeviceId(linesId);
	}

}
