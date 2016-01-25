/**   
* @Title: EpMonitorDeviceManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-27 上午5:44:31 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpMonitorDeviceManager;

/** 
 * @ClassName: EpMonitorDeviceManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-27 上午5:44:31 
 *  
 */
public class EpMonitorDeviceManagerImpl extends BaseManagerImpl implements
		EpMonitorDeviceManager {
	
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpMonitorDeviceDAOiBatis epMonitorDeviceDAO;
	
	@Override
	public String createEMD(String name, BigDecimal type, String naming,
			String organId) throws BusinessException {
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(type.equals("")||type==null){
			throw new BusinessException("type",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpMonitorDeviceSeq();
		EpMonitorDevice emd = new EpMonitorDevice();
		emd.setId(id);
		emd.setName(name);
		emd.setType(type);
		emd.setNaming(naming);
		emd.setOrganId(organId);
		epMonitorDeviceDAO.insert(emd);
		
		return id;
	}


	@Override
	public void deleteEMD(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for(int i=0;i<str_array.length;i++){
			epMonitorDeviceDAO.deleteByPrimaryKey(str_array[i]);
		}
	}


	@Override
	public List<EpMonitorDevice> listEMD() {
		return epMonitorDeviceDAO.listEMD();
	}


	@Override
	public EpMonitorDevice getEMD(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epMonitorDeviceDAO.selectByPrimaryKey(id);
	}

	@Override
	public void updateEMD(String id, String name, BigDecimal type, String naming,
			String organId) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(type.equals("")||type==null){
			throw new BusinessException("type",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpMonitorDevice emd = new EpMonitorDevice();
		emd.setId(id);
		emd.setName(name);
		emd.setType(type);
		emd.setNaming(naming);
		emd.setOrganId(organId);
		
		epMonitorDeviceDAO.updateByPrimaryKeySelective(emd);
	}

}
