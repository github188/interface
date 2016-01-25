/**   
 * @Title: EpProberManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-5-10 上午10:01:22 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRProberVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.model.EpRProberVicExample;
import com.megaeyes.persistence.ibatis.vo.EpProberVO;
import com.megaeyes.persistence.ibatis.vo.ListVicIdVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpProberManager;

/**
 * @ClassName: EpProberManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午10:01:22
 * 
 */
public class EpProberManagerImpl extends BaseManagerImpl implements
		EpProberManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpProberDAOiBatis epProberDAO;
	@Autowired
	EpMonitorDeviceDAOiBatis epMonitorDeviceDAO;
	@Autowired
	EpRMonitorDeviceDAOiBatis epRMonitorDeviceDAO;
	@Autowired
	EpRProberVicDAOiBatis epRProberVicDAO;	
	
	
	@Override
	public String createEpProber(String controlServerId, String epProberTypeId,
			String name, Integer maxLimit, Integer minLimit, Integer cycle,
			String address, Integer isWarn, Integer boolWarn, String position,
			Integer registerReverse, Integer plcIoSaveCycle,
			String plcIoSaveType, String organId,String dataType) throws BusinessException {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}
		if(StringUtils.isBlank(epProberTypeId)){
			throw new BusinessException("epProberTypeId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpProberSeq();
		EpProber ep = new EpProber();
		ep.setId(id);
		ep.setControlServerId(controlServerId);
		ep.setEpProberTypeId(epProberTypeId);
		ep.setName(name);
		ep.setMaxLimit(maxLimit);
		ep.setMinLimit(minLimit);
		ep.setCycle(cycle);
		ep.setAddress(address);
		ep.setIsWarn(isWarn);
		ep.setBoolWarn(boolWarn);
		ep.setPosition(position);
		ep.setRegisterReverse(registerReverse);
		ep.setPlcIoSaveCycle(plcIoSaveCycle);
		ep.setPlcIoSaveType(plcIoSaveType);
		ep.setOrganId(organId);
		ep.setDataType(dataType);
		ep.setPlcIoType("PLC_IO");
		epProberDAO.insert(ep);

		EpMonitorDevice emd = new EpMonitorDevice();
		emd.setId(id);
		emd.setName(ep.getName());
		emd.setOrganId(ep.getOrganId());
		emd.setType(new BigDecimal(2));
		epMonitorDeviceDAO.insert(emd);

		return id;
	}

	@Override
	public void deleteEpProber(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				//删除探测器时删除MONITOR表记录
				epMonitorDeviceDAO.deleteByPrimaryKey(str_array[i]);
				//删除探测器时删除探测器和设备关系表记录
				EpRMonitorDeviceExample ermdExample = new EpRMonitorDeviceExample();
				EpRMonitorDeviceExample.Criteria criteria = ermdExample.createCriteria();
				criteria.andMonitorIdEqualTo(str_array[i]);
				epRMonitorDeviceDAO.deleteByExample(ermdExample);
				//删除探测器时删除探测器和摄像头关系表记录
				EpRProberVicExample erpvExample = new EpRProberVicExample();
				EpRProberVicExample.Criteria criteria1 = erpvExample.createCriteria();
				criteria1.andPresetIdEqualTo(str_array[i]);
				epRProberVicDAO.deleteByExample(erpvExample);
				
				epProberDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
			
		}
	}

	@Override
	public void updateEpProber(String id, String controlServerId,
			String epProberTypeId, String name, Integer maxLimit,
			Integer minLimit, Integer cycle, String address, Integer isWarn,
			Integer boolWarn, String position, Integer registerReverse,
			Integer plcIoSaveCycle, String plcIoSaveType, String organId,String dataType)
			throws BusinessException {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(epProberTypeId)){
			throw new BusinessException("epProberTypeId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpProber ep = new EpProber();
		ep.setId(id);
		ep.setControlServerId(controlServerId);
		ep.setEpProberTypeId(epProberTypeId);
		ep.setName(name);
		ep.setMaxLimit(maxLimit);
		ep.setMinLimit(minLimit);
		ep.setCycle(cycle);
		ep.setAddress(address);
		ep.setIsWarn(isWarn);
		ep.setBoolWarn(boolWarn);
		ep.setPosition(position);
		ep.setRegisterReverse(registerReverse);
		ep.setPlcIoSaveCycle(plcIoSaveCycle);
		ep.setPlcIoSaveType(plcIoSaveType);
		ep.setOrganId(organId);
		ep.setDataType(dataType);

		epProberDAO.updateByPrimaryKeySelective(ep);
	}

	@Override
	public EpProber getEpProberById(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epProberDAO.selectByPrimaryKey(id);
	}


	public List<EpProberVO> listProberByOrganId(String organId)
			throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epProberDAO.listProberByOrganId(organId);
	}


	@Override
	public List<ListVicIdVO> listVicIdByProberId(String proberId) {
		if(StringUtils.isBlank(proberId)){
			throw new BusinessException("proberId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epProberDAO.listVicIdByProberId(proberId);
	}


}
