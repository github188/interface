/**   
 * @Title: EpGatherServerManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-13 上午6:07:12 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpControlServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpGatherServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpProberDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpControlServerExample;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpGatherServerExample;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.model.EpProberExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpGatherServerMananger;

/**
 * @ClassName: EpGatherServerManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-13 上午6:07:12
 * 
 */
public class EpGatherServerManagerImpl extends BaseManagerImpl implements
		EpGatherServerMananger {

	@Autowired
	EpGatherServerDAOiBatis epGatherServerDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	private EpControlServerDAOiBatis epControlServerDAO;
	@Autowired
	private EpProberDAOiBatis epProberDAO;
	@Autowired
    private EpControlServerManagerImpl epControlServerManager;
	
	public String createEpGatherServer(String organId, String ip, String name,
			String note, Long heartCycle, String eventServerId,
			String eventPort, String clientPort, String consoleListenerIp,
			String consoleListenerPort, String consolePassword,
			String clientIp, String eventIp, String deviceNumber)
			throws BusinessException {
		if (StringUtils.isNotBlank(deviceNumber)) {
			EpGatherServerExample egsExample = new EpGatherServerExample();
			EpGatherServerExample.Criteria criteria = egsExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int count = epGatherServerDAO.countByExample(egsExample);
			if (count > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			EpGatherServerExample egsExample = new EpGatherServerExample();
			EpGatherServerExample.Criteria criteria = egsExample
					.createCriteria();
			criteria.andNameEqualTo(name);
			int count = epGatherServerDAO.countByExample(egsExample);
			if (count > 0) {
				throw new BusinessException("name",
						ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(eventServerId)){
			throw new BusinessException("eventServerId",ErrorCode.PARAMETER_NOT_FOUND);
		}

		EpGatherServer egs = new EpGatherServer();
		String id = sequenceDAO.getEpGatherServerSeq();
		egs.setId(id);
		egs.setOrganId(organId);
		egs.setIp(ip);
		egs.setName(name);
		egs.setNote(note);
		egs.setHeartCycle(heartCycle == null ? heartCycle = (long) 600
				: heartCycle);
		egs.setEventServerId(eventServerId);
		egs.setEventPort(eventPort);
		egs.setClientPort(clientPort);
		egs.setConsoleListenerIp(consoleListenerIp);
		egs.setConsoleListenerPort(consoleListenerPort);
		egs.setConsolePassword(consolePassword);
		egs.setClientIp(clientIp);
		egs.setEventIp(eventIp);
		egs.setDeviceNumber(deviceNumber);

		epGatherServerDAO.insert(egs);
		return id;
	}

	public void deleteEpGatherServer(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			//删除采集服务器时,EP_CONTROL_SERVER表有相关采集服务器ID记录，抛异常给客户端
			EpControlServerExample ecsExample = new EpControlServerExample();
			EpControlServerExample.Criteria criteria = ecsExample.createCriteria();
			criteria.andGatherServerIdEqualTo(str_array[i]);
			int n = epControlServerDAO.countByExample(ecsExample);
			if(n>0){
				throw new BusinessException("resourceBeUsed", ErrorCode.RESOURCE_BE_USED);
			}
			
			try{	
				epGatherServerDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	@Override
	public void deleteForceEpGatherServer(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				//删除采集服务器时强制删除采集服务器下的PLC和控制器
				EpControlServerExample ecsExample = new EpControlServerExample();
				EpControlServerExample.Criteria criteria = ecsExample.createCriteria();
				criteria.andGatherServerIdEqualTo(str_array[i]);
				List<EpControlServer> list = epControlServerDAO.selectByExample(ecsExample);
				if(list.size()>0){
					for(int n=0;n<list.size();n++){
						epControlServerManager.deleteECS(list.get(n).getId());
						epControlServerManager.deletePlcECS(list.get(n).getId());
					}
				}
				epGatherServerDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}
	
	public List<EpGatherServer> listEpGatherServer() throws BusinessException {
		return epGatherServerDAO.listEpGatherServer();
	}

	public EpGatherServer getEpGatherServer(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epGatherServerDAO.selectByPrimaryKey(id);
	}

	public void updateEpGatherServer(String id, String organId, String ip,
			String name, String note, Long heartCycle, String eventServerId,
			String eventPort, String clientPort, String consoleListenerIp,
			String consoleListenerPort, String consolePassword,
			String clientIp, String eventIp, String deviceNumber)
			throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(eventServerId)){
			throw new BusinessException("eventServerId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			EpGatherServerExample egsExample = new EpGatherServerExample();
			EpGatherServerExample.Criteria criteria = egsExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<EpGatherServer> list = epGatherServerDAO
					.selectByExample(egsExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (deviceNumber.equals(list.get(0).getDeviceNumber()))
						;
					{
						throw new BusinessException("deviceNumber",
								ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			EpGatherServerExample egsExample = new EpGatherServerExample();
			EpGatherServerExample.Criteria criteria = egsExample
					.createCriteria();
			criteria.andNameEqualTo(name);
			List<EpGatherServer> list = epGatherServerDAO
					.selectByExample(egsExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (name.equals(list.get(0).getName()))
						;
					{
						throw new BusinessException("name",
								ErrorCode.NAME_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}

		EpGatherServer egs = new EpGatherServer();
		egs.setId(id);
		egs.setOrganId(organId);
		egs.setIp(ip);
		egs.setName(name);
		egs.setNote(note);
		egs.setHeartCycle(heartCycle == null ? heartCycle = (long) 600
				: heartCycle);
		egs.setEventServerId(eventServerId);
		egs.setEventPort(eventPort);
		egs.setClientPort(clientPort);
		egs.setConsoleListenerIp(consoleListenerIp);
		egs.setConsoleListenerPort(consoleListenerPort);
		egs.setConsolePassword(consolePassword);
		egs.setClientIp(clientIp);
		egs.setEventIp(eventIp);
		egs.setDeviceNumber(deviceNumber);

		epGatherServerDAO.updateByPrimaryKeySelective(egs);
	}

	public String epGatherServerRegister(String deviceNumber, String addr)
			throws BusinessException {
		EpGatherServer record = epGatherServerDAO
				.getByDeviceNumber(deviceNumber);
		if (null == record) {
			throw new BusinessException("DeviceNumber not found !",
					ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
		String[] array = addr.split(":");
		if (array.length != 2) {
			throw new BusinessException("parameter [addr=" + addr
					+ "] invalid !", ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setIp(array[0]);
		record.setClientPort(array[1]);
		record.setConsoleListenerPort(array[1]);
		record.setEventPort(array[1]);
		epGatherServerDAO.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	public List<EpControlServer> listEpControlServerByGatherServerId(
			String gatherServerId) {
		EpControlServerExample example = new EpControlServerExample();
		example.createCriteria().andGatherServerIdEqualTo(gatherServerId);
		return epControlServerDAO.selectByExample(example);
	}

	public List<EpProber> listEpProberByControlServerId(String epControlServerId) {
		EpProberExample example = new EpProberExample();
		example.createCriteria().andControlServerIdEqualTo(epControlServerId);
		return epProberDAO.selectByExample(example);
	}

	
}
