/**   
 * @Title: EpEventServerManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-13 上午5:52:39 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpEventServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpEventServer;
import com.megaeyes.persistence.ibatis.model.EpEventServerExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpEventServerManager;

/**
 * @ClassName: EpEventServerManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-13 上午5:52:39
 * 
 */
public class EpEventServerManagerImpl extends BaseManagerImpl implements
		EpEventServerManager {

	@Autowired
	EpEventServerDAOiBatis epEventServerDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;

	public String createEpEventServer(String name, String naming,
			String deviceNumber, String installLocation, String ip1,
			String ip2, String note, Long port, Integer heartbeatCycle,
			Short alarmFrequency) throws BusinessException {
		if (StringUtils.isNotBlank(deviceNumber)) {
			EpEventServerExample eesExample = new EpEventServerExample();
			EpEventServerExample.Criteria criteria = eesExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int count = epEventServerDAO.countByExample(eesExample);
			if (count > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			EpEventServerExample eesExample = new EpEventServerExample();
			EpEventServerExample.Criteria criteria = eesExample.createCriteria();
			criteria.andNameEqualTo(name);
			int count = epEventServerDAO.countByExample(eesExample);
			if(count>0){
				throw new BusinessException("name",ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
	
		EpEventServer ees = new EpEventServer();
		String id = sequenceDAO.getEpEventServerSeq();
		ees.setId(id);
		ees.setName(name);
		ees.setNaming(naming);
		ees.setDeviceNumber(deviceNumber);
		ees.setInstallLocation(installLocation);
		ees.setIp1(ip1);
		ees.setIp2(ip2);
		ees.setNote(note);
		ees.setPort(port);
		ees.setHeartbeatCycle(heartbeatCycle);
		ees.setAlarmFrequency(alarmFrequency);
		epEventServerDAO.insert(ees);
		return id;
	}

	public void deleteEpEventServer(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				epEventServerDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	public List<EpEventServer> listEpEventServer() throws BusinessException {
		return epEventServerDAO.listEpEventServer();
	}

	public EpEventServer getByEpEventServerId(String id)
			throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epEventServerDAO.selectByPrimaryKey(id);
	}

	public void updateEpEventServer(String id, String name, String naming,
			String deviceNumber, String installLocation, String ip1,
			String ip2, String note, Long port, Integer heartbeatCycle,
			Short alarmFrequency) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			EpEventServerExample eesExample = new EpEventServerExample();
			EpEventServerExample.Criteria criteria = eesExample
					.createCriteria();
			criteria.andNameEqualTo(name);
			List<EpEventServer> list = epEventServerDAO
					.selectByExample(eesExample);
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

		if (StringUtils.isNotBlank(deviceNumber)) {
			EpEventServerExample eesExample = new EpEventServerExample();
			EpEventServerExample.Criteria criteria = eesExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<EpEventServer> list = epEventServerDAO
					.selectByExample(eesExample);
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
		EpEventServer ees = new EpEventServer();
		ees.setId(id);
		ees.setName(name);
		ees.setNaming(naming);
		ees.setDeviceNumber(deviceNumber);
		ees.setInstallLocation(installLocation);
		ees.setIp1(ip1);
		ees.setIp2(ip2);
		ees.setHeartbeatCycle(heartbeatCycle);
		ees.setNote(note);
		ees.setPort(port);
		ees.setAlarmFrequency(alarmFrequency);
		epEventServerDAO.updateByPrimaryKeySelective(ees);

	}

	public EpEventServer eventServerRegister(String deviceNumber, String ip1,
			String ip2, Long port) {
		EpEventServerExample example = new EpEventServerExample();
		EpEventServerExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);
		List<EpEventServer> list = epEventServerDAO.selectByExample(example);
		if (list.size() != 1) {
			throw new BusinessException("event server deviceNumber "
					+ deviceNumber + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		EpEventServer epEventServer = list.get(0);

		if (!ip1.equals(epEventServer.getIp1())) {
			throw new BusinessException("lanIp mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (epEventServer.getPort() == null) {
			throw new BusinessException("port mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (port.longValue() != epEventServer.getPort().longValue()) {
			throw new BusinessException("port mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		epEventServer.setIp2(ip2);
		BigDecimal heartbeatTime = new BigDecimal(System.currentTimeMillis());
		epEventServer.setHeartbeatTime(heartbeatTime);
		epEventServerDAO.updateByPrimaryKeySelective(epEventServer);
		return epEventServer;
	}

}
