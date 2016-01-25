/**   
 * @Title: EpControlServerManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-5-7 上午2:37:49 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpControlServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpMonitorDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberTypeDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpControlServerExample;
import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpProberExample;
import com.megaeyes.persistence.ibatis.model.EpProberType;
import com.megaeyes.persistence.ibatis.vo.ListEpMonitorDeviceAndEpProberVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpControlServerManager;

/**
 * @ClassName: EpControlServerManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-7 上午2:37:49
 * 
 */
public class EpControlServerManagerImpl extends BaseManagerImpl implements
		EpControlServerManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpProberDAOiBatis epProberDAO;
	@Autowired
	EpControlServerDAOiBatis epControlServerDAO;
	@Autowired
	EpMonitorDeviceDAOiBatis epMonitorDeviceDAO;
	@Autowired
	EpProberTypeDAOiBatis epProberTypeDAO;
	@Autowired
	EpProberManagerImpl epProberManager;
	

	@Override
	public String createECS(String gatherServerId, String name,
			String position, String organId, Integer cycle, String url,
			Integer isWarn, Integer plcIoSaveCycle, String plcIoSaveType) {

		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
//			else{
//			// 判断名称不能相同
//			EpControlServerExample example = new EpControlServerExample();
//			example.createCriteria().andNameEqualTo(name);
//			List<EpControlServer> list = epControlServerDAO
//					.selectByExample(example);
//			if (list.size() > 0) {
//				throw new BusinessException("name : " + name + " exist !",
//						ErrorCode.NAME_EXIST);
//			}
//		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}
	
		

		String id = sequenceDAO.getEpControlServerSeq();
		String proberId = sequenceDAO.getEpProberSeq();

		EpControlServer ecs = new EpControlServer();
		ecs.setId(id);
		ecs.setGatherServerId(gatherServerId);
		ecs.setName(name);
		ecs.setPosition(position);
		ecs.setOrganId(organId);
		ecs.setUrl(url);
		ecs.setType((short) 2);
		epControlServerDAO.insert(ecs);

		EpProber ep = new EpProber();
		ep.setId(proberId);
		ep.setControlServerId(id);
		ep.setEpProberTypeId("19");
		ep.setName(name);
		ep.setCycle(cycle);
		ep.setPosition(position);
		ep.setOrganId(organId);
		// ep.setAddress(url);
		ep.setIsWarn(isWarn);
		ep.setPlcIoType("SOLAR_IO");
		ep.setDataType("SOLAR_DATA");
		ep.setPlcIoSaveType(plcIoSaveType);
		ep.setPlcIoSaveCycle(plcIoSaveCycle);
		epProberDAO.insert(ep);

		EpMonitorDevice emd = new EpMonitorDevice();
		emd.setId(proberId);
		emd.setName(ep.getName());
		emd.setOrganId(ep.getOrganId());
		emd.setType(new BigDecimal(2));
		epMonitorDeviceDAO.insert(emd);

		return proberId;
	}

	@Override
	public void deleteECS(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String controlServerId;
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			controlServerId = epProberDAO
					.selectControlServerIdByProberId(str_array[i]);
			try {
				// 删除太阳能控制器时先删除EP_PROBER表记录
				epProberDAO.deleteByPrimaryKey(str_array[i]);
				// 删除MONITOR表里记录
				epMonitorDeviceDAO.deleteByPrimaryKey(str_array[i]);
				epControlServerDAO.deleteByPrimaryKey(controlServerId);
			} catch (Exception e) {
				throw new BusinessException("resourceBeUsed",
						ErrorCode.RESOURCE_BE_USED);
			}

		}

	}

	@Override
	public void updateECS(String id, String name, String position,
			String organId, Integer cycle, String url, Integer isWarn,
			Integer plcIoSaveCycle, String plcIoSaveType) {
		
		String controlServerId = epProberDAO.selectControlServerIdByProberId(id);
		
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
//		else{
//			// 判断名称不能相同
//			EpControlServerExample example = new EpControlServerExample();
//			EpControlServerExample.Criteria criteria = example.createCriteria();
//			criteria.andNameEqualTo(name);
//			List<EpControlServer> list = epControlServerDAO
//					.selectByExample(example);
//			if (list.size() > 0) {
//				if (!list.get(0).getId().equals(controlServerId)) {
//					if(name.equals(list.get(0).getName())){
//						throw new BusinessException("name : " + name + " exist !",
//								ErrorCode.NAME_EXIST);
//					}
//				}
//			}
//		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}
		
		EpProber ep = new EpProber();
		ep.setId(id);
		ep.setName(name);
		ep.setCycle(cycle);
		ep.setPosition(position);
		ep.setOrganId(organId);
		ep.setIsWarn(isWarn);
		ep.setPlcIoSaveCycle(plcIoSaveCycle);
		ep.setPlcIoSaveType(plcIoSaveType);
		epProberDAO.updateByPrimaryKeySelective(ep);

		EpControlServer ecs = epControlServerDAO
				.selectByPrimaryKey(controlServerId);
		ecs.setId(controlServerId);
		ecs.setUrl(url);
		epControlServerDAO.updateECSurlByProberId(ecs);

	}

	@Override
	public List<ListEpMonitorDeviceAndEpProberVO> listEMDandEpProber(
			String deviceId) {
		if (StringUtils.isBlank(deviceId)) {
			throw new BusinessException("deviceId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epProberDAO.listEMDandEpProber(deviceId);
	}

	@Override
	public String createPlcECS(String gatherServerId, String name,
			String position, String organId, String url)
			throws BusinessException {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}

		String id = sequenceDAO.getEpControlServerSeq();
		EpControlServer ecs = new EpControlServer();
		ecs.setId(id);
		ecs.setGatherServerId(gatherServerId);
		ecs.setName(name);
		ecs.setPosition(position);
		ecs.setOrganId(organId);
		ecs.setUrl(url);
		ecs.setType((short) 1);
		epControlServerDAO.insert(ecs);
		return id;
	}

	@Override
	public void updatePlcECS(String id, String name, String position,
			String organId, String url,String gatherServerId) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId", ErrorCode.ORGAN_NOT_FOUND);
		}

		EpControlServer ecs = new EpControlServer();
		ecs.setId(id);
		ecs.setName(name);
		ecs.setPosition(position);
		ecs.setOrganId(organId);
		ecs.setUrl(url);
		ecs.setGatherServerId(gatherServerId);

		epControlServerDAO.updateByPrimaryKeySelective(ecs);

	}

	@Override
	public void deletePlcECS(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try {
				// 先查询PLC挂的探测器
				EpProberExample epExample = new EpProberExample();
				EpProberExample.Criteria criteria = epExample.createCriteria();
				criteria.andControlServerIdEqualTo(str_array[i]);
				List<EpProber> list = epProberDAO.selectByExample(epExample);
				for(int n=0;n<list.size();n++){
					// 删除PLC时先删除它下边的探测器
					epProberManager.deleteEpProber(list.get(0).getId());
				}
				epControlServerDAO.deleteByPrimaryKey(str_array[i]);
			} catch (Exception e) {
				throw new BusinessException("resourceBeUsed",
						ErrorCode.RESOURCE_BE_USED);
			}
		}

	}

	@Override
	public List<EpControlServer> listPLC() {
		EpControlServerExample example = new EpControlServerExample();
		EpControlServerExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(Short.valueOf("1"));
		return epControlServerDAO.selectByExample(example);
	}

	@Override
	public List<EpProberType> listProberType() {
		return epProberTypeDAO.listProberType();
	}

}
