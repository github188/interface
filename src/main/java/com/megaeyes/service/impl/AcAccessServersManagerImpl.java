/**   
* @Title: AcAccessServerManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午7:57:37 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcAccessControlsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcAccessServersDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AcAccessControlsExample;
import com.megaeyes.persistence.ibatis.model.AcAccessServers;
import com.megaeyes.persistence.ibatis.model.AcAccessServersExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessServersManager;

/** 
 * @ClassName: AcAccessServerManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午7:57:37 
 *  
 */
public class AcAccessServersManagerImpl extends BaseManagerImpl implements
		AcAccessServersManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcAccessServersDAOiBatis acAccessServersDAO;
	@Autowired
	private AcAccessControlsDAOiBatis acAccessControlDAO;
	
	@Override
	public String createAcAccessServers(String name, String accessPassword,
			String installLocation, String deviceNumber, String ip,
			String note, Integer messagePort, String deviceType,
			String organId, String gatewayId) throws BusinessException {
		if(StringUtils.isNotBlank(name)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			int count = acAccessServersDAO.countByExample(aasExample);
			if(count>0){
				throw new BusinessException("name",ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		if(StringUtils.isNotBlank(deviceNumber)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int count = acAccessServersDAO.countByExample(aasExample);
			if(count>0){
				throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(gatewayId)){
			throw new BusinessException("gatewayId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(ip)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andIpEqualTo(ip);
			int count = acAccessServersDAO.countByExample(aasExample);
			if(count>0){
				throw new BusinessException("ip",ErrorCode.IP_EXIST);
			}
		}else{
			throw new BusinessException("ip",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getAcAccessServersSeq();
		String gatewayIp = acAccessServersDAO.getIpByGateWayId(gatewayId);
		if(StringUtils.isBlank(gatewayIp)){
			throw new BusinessException("gatewayIp",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String naming = id+":"+gatewayIp+":010001";
		AcAccessServers aas = new AcAccessServers();
		aas.setId(id);
		aas.setName(name);
		aas.setNaming(naming);
		aas.setAccessPassword(accessPassword);
		aas.setInstallLocation(installLocation);
		aas.setDeviceNumber(deviceNumber);
		aas.setIp(ip);
		aas.setNote(note);
		aas.setMessagePort(messagePort);
		aas.setDeviceType(deviceType);
		aas.setStatus(0);
		aas.setOrganId(organId);
		aas.setGatewayId(gatewayId);
		aas.setSubaddr(0);
		aas.setModelType((short)1);
		acAccessServersDAO.insert(aas);
		
		return id;
	}

	@Override
	public void deleteAcAccessServers(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			acAccessServersDAO.deleteAcAccessControlsByServersId(id);
		
			acAccessServersDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed", ErrorCode.RESOURCE_BE_USED);
		}
	
	}

	@Override
	public void updateAcAccessServers(String id, String name,
			String accessPassword, String installLocation, String deviceNumber,
			String ip, String note, Integer messagePort, String deviceType,
			String organId, String gatewayId) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(deviceNumber)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<AcAccessServers> list = acAccessServersDAO.selectByExample(aasExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getDeviceNumber().equals(deviceNumber)){
						throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}else{
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(gatewayId)){
			throw new BusinessException("gatewayId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(name)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andOrganIdEqualTo(organId);
			List<AcAccessServers> list = acAccessServersDAO.selectByExample(aasExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getName().equals(name)){
						throw new BusinessException("name",ErrorCode.NAME_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(ip)){
			AcAccessServersExample aasExample = new AcAccessServersExample();
			AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
			criteria.andIpEqualTo(ip);
			List<AcAccessServers> list = acAccessServersDAO.selectByExample(aasExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getIp().equals(ip)){
						throw new BusinessException("ip",ErrorCode.IP_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("ip",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessServers aas = new AcAccessServers();
		aas.setId(id);
		aas.setName(name);
		aas.setAccessPassword(accessPassword);
		aas.setInstallLocation(installLocation);
		aas.setDeviceNumber(deviceNumber);
		aas.setIp(ip);
		aas.setNote(note);
		aas.setMessagePort(messagePort);
		aas.setDeviceType(deviceType);
		aas.setOrganId(organId);
		aas.setGatewayId(gatewayId);
		acAccessServersDAO.updateByPrimaryKeySelective(aas);
		
	}

	@Override
	public List<AcAccessServers> listAcAccessServersByOrganId(String organId)
			throws BusinessException {
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organid",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessServersExample aasExample = new AcAccessServersExample();
		AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
		criteria.andOrganIdEqualTo(organId);
		return acAccessServersDAO.selectByExample(aasExample);
	}

	@Override
	public List<AcAccessServers> listAcAccessServersByGatewayId(String gatewayId)
			throws BusinessException {
		if(StringUtils.isBlank(gatewayId)){
			throw new BusinessException("gatewayId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessServersExample aasExample = new AcAccessServersExample();
		AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
		criteria.andGatewayIdEqualTo(gatewayId);
		return acAccessServersDAO.selectByExample(aasExample);
	}

	public List<AcAccessControls> listDoorByOrganId(String organId) {
		return acAccessControlDAO.listDoorByOrganId(organId);
	}
}
