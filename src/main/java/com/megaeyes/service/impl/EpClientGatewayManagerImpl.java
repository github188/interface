package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcGatewayDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AccessServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpClientGatewayDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AcGatewayExample;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.AccessServerExample;
import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.model.EpClientGatewayExample;
import com.megaeyes.persistence.ibatis.vo.ClientGatewayHeartbeatVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpClientGatewayManager;

/**
 * EpClientGatewayManagerImpl(类说明)
 * 
 * @author tangjianyang tangjianyang@megaeyes.com
 *         <p />
 *         2012-12-27 下午3:43:43
 */
public class EpClientGatewayManagerImpl extends BaseManagerImpl implements
		EpClientGatewayManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	EpClientGatewayDAOiBatis epClientGatewayDAO;
	@Autowired
	AccessServerDAOiBatis accessServerDAO;
	@Autowired
	AcGatewayDAOiBatis acGatewayDAO;

	public String createEpClientGateway(String name, String deviceNumber,
			String ip1, String ip2, String naming, Long port, String note,
			Integer heartbeatCycle, String address) {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceNumber)) {
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpClientGatewayExample example = new EpClientGatewayExample();
		EpClientGatewayExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);
		int count = epClientGatewayDAO.countByExample(example);
		if (count > 0) {
			throw new BusinessException("PARAMETER_NOT_FOUND",
					ErrorCode.DEVICE_NUMBER_DUPLICATE);
		}
		String id = sequenceDAO.getEpClientGatewaySeq();
		EpClientGateway ecg = new EpClientGateway();
		ecg.setDeviceNumber(deviceNumber);
		ecg.setId(id);
		ecg.setIp1(ip1);
		ecg.setIp2(ip2);
		ecg.setName(name);
		ecg.setNaming(naming);
		ecg.setNote(note);
		ecg.setPort(port);
		ecg.setHeartbeatCycle(heartbeatCycle);
		ecg.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		ecg.setAddress(address);
		epClientGatewayDAO.insert(ecg);
		return id;
	}

	public void deleteEpClientGateway(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		epClientGatewayDAO.deleteByPrimaryKey(id);
	}

	public List<EpClientGateway> listEpClientGateway() {
		EpClientGatewayExample example = new EpClientGatewayExample();
		List<EpClientGateway> list = epClientGatewayDAO
				.selectByExample(example);
		return list;
	}

	public EpClientGateway getEpClientGateway(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpClientGateway ecg = epClientGatewayDAO.selectByPrimaryKey(id);
		return ecg;
	}

	public void updateEpClientGateway(String id, String name,
			String deviceNumber, String ip1, String ip2, String naming,
			Long port, String note, Integer heartbeatCycle, String address) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceNumber)) {
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpClientGatewayExample example = new EpClientGatewayExample();
		EpClientGatewayExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);
		List<EpClientGateway> list = epClientGatewayDAO
				.selectByExample(example);
		if (list.size() > 1) {
			throw new BusinessException("deviceNumber",
					ErrorCode.DEVICE_NUMBER_DUPLICATE);
		}
		if (list.size() == 1) {
			EpClientGateway ecgateway = list.get(0);
			if (!ecgateway.getId().equals(id)) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}
		EpClientGateway ecg = new EpClientGateway();
		ecg.setId(id);
		ecg.setDeviceNumber(deviceNumber);
		ecg.setId(id);
		ecg.setIp1(ip1);
		ecg.setIp2(ip2);
		ecg.setName(name);
		ecg.setNaming(naming);
		ecg.setNote(note);
		ecg.setPort(port);
		ecg.setHeartbeatCycle(heartbeatCycle);
		ecg.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		ecg.setAddress(address);
		epClientGatewayDAO.updateByPrimaryKeySelective(ecg);
	}

	public List<EpClientGateway> clientGatewayRegister(String deviceNumber,
			String lanIp, String wanIp, Long port) {

		EpClientGatewayExample example = new EpClientGatewayExample();
		EpClientGatewayExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);
		criteria.andIp1EqualTo(lanIp);
		criteria.andIp2EqualTo(wanIp);
		criteria.andPortEqualTo(port);
		List<EpClientGateway> list = epClientGatewayDAO
				.selectByExample(example);
		System.out.println("list:-----------------" + list.size());
		if (list.size() > 0) {
			EpClientGateway epClientGateway = list.get(0);
			EpClientGateway ecg = new EpClientGateway();
			ecg.setId(epClientGateway.getId());
			ecg.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
			epClientGatewayDAO.updateByPrimaryKeySelective(ecg);
		}
		return list;
	}

	public List<AccessServer> listAccessServer() {
		AccessServerExample example = new AccessServerExample();

		return accessServerDAO.selectByExample(example);
	}

	public List<AcGateway> listAcGateway() {
		AcGatewayExample example = new AcGatewayExample();

		return acGatewayDAO.selectByExample(example);
	}

	public ClientGatewayHeartbeatVO clientGatewayHeartbeat(String deviceNumber) {
		EpClientGatewayExample example = new EpClientGatewayExample();
		EpClientGatewayExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber);

		List<EpClientGateway> list = epClientGatewayDAO
				.selectByExample(example);
		if (list.size() > 0) {
			EpClientGateway epClientGateway = list.get(0);
			EpClientGateway ecg = new EpClientGateway();
			ecg.setId(epClientGateway.getId());
			ecg.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
			epClientGatewayDAO.updateByPrimaryKeySelective(ecg);
		}
		return epClientGatewayDAO.clientGatewayHeartbeat();
	}

}
