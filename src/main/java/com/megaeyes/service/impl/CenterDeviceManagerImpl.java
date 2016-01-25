/**   
 * @Title: CenterDeviceManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-20 上午10:44:11 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.persistence.ibatis.iface.MediaGatewayServerDAO;
import com.megaeyes.persistence.ibatis.impl.AcAccessControlsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcAccessServersDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcGatewayDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AccessServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.DispatchServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpIntelligentChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpSchemeCommandDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.IpCameraVisDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.ManufacturerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.MediaGatewayServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.RemoteStorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SipServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.StorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.TUserDAOImpliBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoDisplayDeviceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoOutputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoOutputChannelModelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AcAccessServers;
import com.megaeyes.persistence.ibatis.model.AcAccessServersExample;
import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AcGatewayExample;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.AccessServerExample;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServerExample;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import com.megaeyes.persistence.ibatis.model.RemoteStorageServer;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.model.SipServerExample;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServerExample;
import com.megaeyes.persistence.ibatis.model.TUserExample;
import com.megaeyes.persistence.ibatis.model.VideoInputServerExample;
import com.megaeyes.persistence.ibatis.vo.ListRemoteStorageServerVO;
import com.megaeyes.persistence.ibatis.vo.StorageInfoQueryVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.utils.StdIdGenerator;

/**
 * @ClassName: CenterDeviceManagerImpl
 * @Description: 中心设备管理的实现类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-20 上午10:44:11
 * 
 */

@Controller
public class CenterDeviceManagerImpl extends BaseManagerImpl implements
		CenterDeviceManager {
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcGatewayDAOiBatis acGatewayDAO;
	@Autowired
	AccessServerDAOiBatis accessServerDAO;
	@Autowired
	DispatchServerDAOiBatis dispatchServerDAO;
	@Autowired
	StorageServerDAOiBatis storageServerDAO;
	@Autowired
	RemoteStorageServerDAOiBatis remoteStorageServerDAO;
	@Autowired
	PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	VideoDisplayDeviceDAOiBatis videoDisplayDeviceDAO;
	@Autowired
	OrganDAOiBatis organDAO;
	@Autowired
	VideoOutputChannelDAOiBatis videoOutputChannelDAO;
	@Autowired
	EpSchemeCommandDAOiBatis epSchemeCommandDAO;
	@Autowired
	EpIntelligentChannelDAOiBatis epIntelligentChannelDAO;
	@Autowired
	VideoInputServerDAOiBatis videoInputServerDAO;
	@Autowired
	VideoOutputChannelModelDAOiBatis videoOutputChannelModelDAO;
	@Autowired
	MediaGatewayServerDAOiBatis mediaGatewayServerDAO;
	@Autowired
	ManufacturerDAOiBatis manufacturerDAO;
	@Autowired
	IpCameraVisDAOiBatis ipCameraVisDAO;
	@Autowired
	SipServerDAOiBatis sipServerDAO;
	@Autowired
	UserDAOiBatis userDAO;
	
	@Autowired
	AcAccessServersDAOiBatis acAccessServersDAO;
	@Autowired
	private AcAccessControlsDAOiBatis acAccessControlDAO;
	
	public String createAccessServer(String name, String naming,
			String location, String number, String note, String ip, String ip1) {
		if (StringUtils.isNotBlank(name)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andNameEqualTo(name);
			int count = accessServerDAO.countByExample(asExample);
			if (count > 0) {
				throw new BusinessException("name",
						ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(number)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andDeviceNumberEqualTo(number);
			int count = accessServerDAO.countByExample(asExample);
			if (count > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("number", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(ip)){
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andIpEqualTo(ip);
			int count = accessServerDAO.countByExample(asExample);
			if(count>0){
				throw new BusinessException("ip",
						ErrorCode.IP_EXIST);
			}
		}
		if(StringUtils.isNotBlank(ip1)){
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andIp1EqualTo(ip1);
			int count = accessServerDAO.countByExample(asExample);
			if(count>0){
				throw new BusinessException("ip1",
						ErrorCode.IP_EXIST);
			}
		}
		String stdId = StdIdGenerator.getStdId();
		AccessServer as = new AccessServer();
		String id = sequenceDAO.getAccessServerSeq();
		as.setId(id);
		as.setDeviceNumber(number);
		as.setInstallLocation(location);
		as.setIp(ip);
		as.setIp1(ip1);
		as.setName(name);
		as.setNaming(naming);
		as.setNote(note);
		as.setStdId(stdId);
		as.setOptimisticLock(new BigDecimal(0));
		as.setLastUpdateTime(new BigDecimal(System.currentTimeMillis()));
		accessServerDAO.insert(as);
		return id;

	}

	public void deleteAccessServer(String accessServerId) {
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("accessServerId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			//用户使用接入服务器无法删除
			TUserExample userExample = new TUserExample();
			TUserExample.Criteria criteria = userExample.createCriteria();
			criteria.andAccessServerIdEqualTo(accessServerId);
			if(userDAO.countByExample(userExample)>0){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
			
			accessServerDAO.deleteByPrimaryKey(accessServerId);
			
			
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
		}
	}

	public List<AccessServer> listAccessServer() {
		return accessServerDAO.listAccessServer();
	}

	public void updateAccessServer(String accessServerId, String name,
			String naming, String deviceNumber, String installLocation,
			String ip, String ip1, String stdId, String note) {
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andNameEqualTo(name);
			List<AccessServer> list = accessServerDAO
					.selectByExample(asExample);
			if (list.size() > 0) {
				if (!accessServerId.equals(list.get(0).getId())) {
					if (name.equals(list.get(0).getName())) {
						throw new BusinessException("name",
								ErrorCode.NAME_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<AccessServer> list = accessServerDAO
					.selectByExample(asExample);
			if (list.size() > 0) {
				if (!accessServerId.equals(list.get(0).getId())) {
					if (deviceNumber.equals(list.get(0).getDeviceNumber())) {
						throw new BusinessException("deviceNumber",
								ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(ip)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andIpEqualTo(ip);
			List<AccessServer> list = accessServerDAO
					.selectByExample(asExample);
			if (list.size() > 0) {
				if (!accessServerId.equals(list.get(0).getId())) {
					if (ip.equals(list.get(0).getIp())) {
						throw new BusinessException("ip",
								ErrorCode.IP_EXIST);
					}
				}
			}
		}
		if (StringUtils.isNotBlank(ip1)) {
			AccessServerExample asExample = new AccessServerExample();
			AccessServerExample.Criteria criteria = asExample.createCriteria();
			criteria.andIp1EqualTo(ip1);
			List<AccessServer> list = accessServerDAO
					.selectByExample(asExample);
			if (list.size() > 0) {
				if (!accessServerId.equals(list.get(0).getId())) {
					if (ip1.equals(list.get(0).getIp1())) {
						throw new BusinessException("ip1",
								ErrorCode.IP_EXIST);
					}
				}
			}
		}
		AccessServer as = new AccessServer();
		as.setId(accessServerId);
		as.setName(name);
		as.setNaming(naming);
		as.setDeviceNumber(deviceNumber);
		as.setInstallLocation(installLocation);
		as.setIp(ip);
		as.setIp1(ip1);
		as.setStdId(stdId);
		as.setNote(note);
		as.setLastUpdateTime(new BigDecimal(System.currentTimeMillis()));
		accessServerDAO.updateByPrimaryKeySelective(as);

	}

	public AccessServer getAccessServerById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AccessServer as = accessServerDAO.selectByPrimaryKey(id);
		return as;
	}

	public String createDispatchServer(String name, String naming,
			String deviceNumber, String stdId, Long heartCycle,
			String location, Long maxInputAmount, Long maxOutputAmount,
			Long msgPort, String note, Long reservedOutputAmount,
			String ownerShip, Long videoPort) {
		// deviceNumber exist
		if (StringUtils.isNotBlank(deviceNumber)) {
			DispatchServerExample dispExample = new DispatchServerExample();
			DispatchServerExample.Criteria criteria = dispExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List list = dispatchServerDAO.selectByExample(dispExample);
			if (list.size() > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			DispatchServerExample dsExample = new DispatchServerExample();
			DispatchServerExample.Criteria criteria = dsExample.createCriteria();
			criteria.andNameEqualTo(name);
			int count = dispatchServerDAO.countByExample(dsExample);
			if (count > 0) {
				throw new BusinessException("name",
						ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}

		DispatchServer ds = new DispatchServer();
		String id = sequenceDAO.getDispatchServerSeq();
		ds.setId(id);
		ds.setName(name);
		ds.setNaming(naming);
		ds.setDeviceNumber(deviceNumber);
		ds.setStdId(stdId);
		ds.setHeartCycle(heartCycle);
		ds.setInstallLocation(location);
		ds.setMaxInputAmount(maxInputAmount);
		ds.setMaxOutputAmount(maxOutputAmount);
		ds.setMsgport(msgPort);
		ds.setNote(note);
		ds.setReservedOutputAmount(reservedOutputAmount);
		ds.setOwnerShip(ownerShip);
		ds.setOptimisticLock(new BigDecimal(0));
		ds.setVideoport(videoPort);
		dispatchServerDAO.insert(ds);
		return id;
	}

	public void deleteDispatchServer(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try {
				dispatchServerDAO.deleteByPrimaryKey(str_array[i]);
			} catch (Exception e) {
				throw new BusinessException("resourceBeUsed",
						ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	public List<DispatchServer> listDispatchServer() {
		List<DispatchServer> servers = dispatchServerDAO.listDispatchServer();
		return servers;
	}

	public DispatchServer getDispatchServerById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return dispatchServerDAO.selectByPrimaryKey(id);
	}

	public void updateDispatchServer(String id, String name, String naming,
			String deviceNumber, String stdId, Long heartCycle,
			String location, Long maxInputAmount, Long maxOutputAmount,
			Long msgPort, String note, Long reservedOutputAmount,
			String ownerShip) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			DispatchServerExample dispExample = new DispatchServerExample();
			DispatchServerExample.Criteria criteria = dispExample
					.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<DispatchServer> list = dispatchServerDAO
					.selectByExample(dispExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (deviceNumber.equals(list.get(0).getDeviceNumber()))
						throw new BusinessException("deviceNumber",
								ErrorCode.DEVICE_NUMBER_DUPLICATE);
				}
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(name)) {
			DispatchServerExample dispExample = new DispatchServerExample();
			DispatchServerExample.Criteria criteria = dispExample
					.createCriteria();
			criteria.andNameEqualTo(name);
			List<DispatchServer> list = dispatchServerDAO
					.selectByExample(dispExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (name.equals(list.get(0).getName()))
						throw new BusinessException("name",
								ErrorCode.NAME_EXIST);
				}
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		DispatchServer ds = new DispatchServer();
		ds.setId(id);
		ds.setName(name);
		ds.setNaming(naming);
		ds.setDeviceNumber(deviceNumber);
		ds.setStdId(stdId);
		ds.setHeartCycle(heartCycle);
		ds.setInstallLocation(location);
		ds.setMaxInputAmount(maxInputAmount);
		ds.setMaxOutputAmount(maxOutputAmount);
		ds.setMsgport(msgPort);
		ds.setNote(note);
		ds.setReservedOutputAmount(reservedOutputAmount);
		ds.setOwnerShip(ownerShip);
		dispatchServerDAO.updateByPrimaryKeySelective(ds);

	}

	public String createACGateway(String name, String lanIp, String wanIp,
			String installLocation, String note, String naming, Integer port,
			String organId, String deviceNumber) {
		if (StringUtils.isNotBlank(name)) {
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(name);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				throw new BusinessException("name", ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				throw new BusinessException("deviceNumber",
						ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(port==null||port.equals("")){
			throw new BusinessException("port",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(lanIp)){
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andLanIpEqualTo(lanIp);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				throw new BusinessException("lanIp",
						ErrorCode.IP_EXIST);
			}
		}else{
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(wanIp)){
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andWanIpEqualTo(wanIp);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				throw new BusinessException("wanIp",
						ErrorCode.IP_EXIST);
			}
		}else{
			throw new BusinessException("wanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcGateway record = new AcGateway();
		String id = sequenceDAO.getACGatewaySeq();
		record.setId(id);
		record.setName(name);
		record.setLanIp(lanIp);
		record.setWanIp(wanIp);
		record.setInstallLocation(installLocation);
		record.setNote(note);
		record.setNaming(naming);
		record.setPort(port);
		record.setOrganId(organId);
		record.setDeviceNumber(deviceNumber);
		record.setLastUpdateTime(new BigDecimal(System.currentTimeMillis()));
		acGatewayDAO.insert(record);
		return id;
	}

	public String deleteACGateway(String id) {

		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcGateway record = acGatewayDAO.selectByPrimaryKey(id);
		String name = record.getName();
		try{
			acGatewayDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
		}
		return name;
	}

	public List<AcGateway> listAcGateway() {
		AcGatewayExample example = new AcGatewayExample();
		return acGatewayDAO.selectByExample(example);
	}

	public void updateACGateway(String id, String name, String lanIp, String wanIp, 
			String installLocation, String note, String naming, Integer port, String organId, String deviceNumber) {
		boolean modify = false;
		if (StringUtils.isNotBlank(name)) {
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(name);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if(list.get(0).getName().equals(name)){
						throw new BusinessException("name", ErrorCode.NAME_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if(list.get(0).getDeviceNumber().equals(deviceNumber)){
						throw new BusinessException("deviceNumber", ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}else{
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(lanIp)){
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andLanIpEqualTo(lanIp);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if(list.get(0).getLanIp().equals(lanIp)){
						throw new BusinessException("lanIp", ErrorCode.IP_EXIST);
					}
				}else{
					if(!lanIp.equals(list.get(0).getLanIp())){
						modify = true;
					}
				}
			}
		}else{
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isNotBlank(wanIp)){
			AcGatewayExample example = new AcGatewayExample();
			AcGatewayExample.Criteria criteria = example.createCriteria();
			criteria.andWanIpEqualTo(wanIp);
			List<AcGateway> list = acGatewayDAO.selectByExample(example);
			if (list.size() > 0) {
				if (!list.get(0).getId().equals(id)) {
					if(list.get(0).getWanIp().equals(wanIp)){
						throw new BusinessException("wanIp", ErrorCode.IP_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("wanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(port == null || port.equals("")){
			throw new BusinessException("port",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcGateway record = new AcGateway();
		record.setId(id);
		record.setName(name);
		record.setLanIp(lanIp);
		record.setWanIp(wanIp);
		record.setInstallLocation(installLocation);
		record.setNote(note);
		record.setNaming(naming);
		record.setPort(port);
		record.setOrganId(organId);
		record.setDeviceNumber(deviceNumber);
		record.setLastUpdateTime(new BigDecimal(System.currentTimeMillis()));
		acGatewayDAO.updateByPrimaryKeySelective(record);
		
		//更新门禁主机、门的naming
		AcAccessServersExample aasExample = new AcAccessServersExample();
		AcAccessServersExample.Criteria criteria = aasExample.createCriteria();
		criteria.andGatewayIdEqualTo(id);
		List<AcAccessServers> servers = acAccessServersDAO.selectByExample(aasExample);
		
		for(AcAccessServers server:servers){
			naming = server.getId() + ":" + lanIp + ":010001";
			server.setNaming(naming);
			acAccessServersDAO.updateByPrimaryKey(server);
		}
		List<AcAccessControls> doors = acAccessControlDAO.listAcAccessControlByGatewayId(id);
		for(AcAccessControls door:doors){
			naming = door.getId() + ":" + door.getAccessServerId() +":" + lanIp + ":010001";
			door.setNaming(naming);
			acAccessControlDAO.updateByPrimaryKey(door);
		}
	
	}

	public String createStorageServer(String name, String deviceNumber,
			String stdId, String ip, String ip2, String location,
			long heartCycle, String linkType, long maxInputAmount,
			long maxOutputAmount, long ftpPort, String ftpUserName,
			String ftpPassword, long messagePort, String note, boolean hasVod,
			String epDeviceType) {
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(deviceNumber)) {
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		StorageServerExample rssExample = new StorageServerExample();
		StorageServerExample.Criteria criteria = rssExample.createCriteria();
		criteria.andNameEqualTo(name);

		List listName = storageServerDAO.selectByExample(rssExample);
		if (null != listName && listName.size() > 0) {
			throw new BusinessException("name", ErrorCode.NAME_EXIST);
		}
		// exist divernumber
		StorageServerExample rssExample1 = new StorageServerExample();
		StorageServerExample.Criteria criteria1 = rssExample1.createCriteria();
		criteria1.andDeviceNumberEqualTo(deviceNumber);
		List listDiverNumber = storageServerDAO.selectByExample(rssExample1);
		if (null != listDiverNumber && listDiverNumber.size() > 0) {
			throw new BusinessException("deviceNumber",
					ErrorCode.DEVICE_NUMBER_DUPLICATE);
		}
		StorageServer ss = new StorageServer();
		String id = sequenceDAO.getStorageServerSeq();
		ss.setId(id);
		ss.setName(name);
		ss.setDeviceNumber(deviceNumber);
		ss.setStdId(stdId);
		ss.setIp(ip);
		ss.setIp2(ip2);
		ss.setInstallLocation(location);
		ss.setHeartCycle(heartCycle);
		ss.setLinkType(linkType);
		ss.setMaxInputAmount(maxInputAmount);
		ss.setMaxOutputAmount(maxOutputAmount);
		ss.setFtpPort(ftpPort);
		ss.setFtpUserName(ftpUserName);
		ss.setFtpPassword(ftpPassword);
		ss.setMessagePort(messagePort);
		ss.setNote(note);
		ss.setOptimisticLock(new BigDecimal(0));
		ss.setIsVirtualIp(new BigDecimal(0));
		storageServerDAO.insert(ss);
		RemoteStorageServer rss = new RemoteStorageServer();
		rss.setStorageServerId(id);
		int inthasVod;
		if (hasVod == true) {
			inthasVod = 1;
		} else {
			inthasVod = 0;
		}
		rss.setHasVod((short) inthasVod);
		remoteStorageServerDAO.insert(rss);
		return id;
	}

	public void deleteStorageServer(String id) {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				//删除存储服务器时先删除REMOTE_STORAGE_SERVER表记录
				remoteStorageServerDAO.deleteByPrimaryKey(str_array[i]);
			
				storageServerDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	public void updateStorageServer(String id, String name,
			String deviceNumber, String stdId, String ip, String ip2,
			String location, long heartCycle, String linkType,
			long maxInputAmount, long maxOutputAmount, long ftpPort,
			String ftpUserName, String ftpPassword, long messagePort,
			boolean hasVod, String note, boolean isLocal, String epDeviceType,
			BigDecimal isVirtualIp) {
		StorageServer ss = new StorageServer();
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (!isLocal) {
			if (!StringUtils.isBlank(name)) {
				int count = storageServerDAO.countStorageServer(name, id);
				if (count > 0) {
					throw new BusinessException("name", ErrorCode.NAME_EXIST);
				}
			}
		}
		if(StringUtils.isNotBlank(deviceNumber)){
			StorageServerExample ssExample = new StorageServerExample();
			StorageServerExample.Criteria criteria = ssExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<StorageServer> list = storageServerDAO.selectByExample(ssExample);
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
		ss.setId(id);
		ss.setName(name);
		ss.setDeviceNumber(deviceNumber);
		ss.setStdId(stdId);
		ss.setIp(ip);
		ss.setIp2(ip2);
		ss.setInstallLocation(location);
		ss.setHeartCycle(heartCycle);
		ss.setLinkType(linkType);
		ss.setMaxInputAmount(maxInputAmount);
		ss.setMaxOutputAmount(maxOutputAmount);
		ss.setFtpPort(ftpPort);
		ss.setFtpUserName(ftpUserName);
		ss.setFtpPassword(ftpPassword);
		ss.setMessagePort(messagePort);
		ss.setNote(note);
		storageServerDAO.updateByPrimaryKeySelective(ss);
		RemoteStorageServer rss = new RemoteStorageServer();
		int inthasVod;
		if (hasVod == true) {
			inthasVod = 1;
		} else {
			inthasVod = 0;
		}
		if (!isLocal) {
			rss.setHasVod((short) inthasVod);
			rss.setStorageServerId(id);
			remoteStorageServerDAO.updateByPrimaryKeySelective(rss);
		}
	}

	

	
	public String createEIC(String name, String naming, String installLocation,
			String parentId, Short parentType, String description, String note,
			String company, Short channelId, String organId)
			throws BusinessException {

		if (StringUtils.isNotBlank(parentId)) {
			VideoInputServerExample visExample = new VideoInputServerExample();
			visExample.createCriteria().andIdEqualTo(parentId);
			int count = videoInputServerDAO.countByExample(visExample);
			if (count == 0) {
				throw new BusinessException("parentId",
						ErrorCode.RESOURCE_NOT_FOUND);
			}// 判断传入的视频服务器ID是否对的，错了就抛个异常
		}
		if (StringUtils.isNotBlank(organId)) {
			OrganExample oExample = new OrganExample();
			oExample.createCriteria().andIdEqualTo(organId);
			int count1 = organDAO.countByExample(oExample);
			if (count1 == 0) {
				throw new BusinessException("organId",
						ErrorCode.RESOURCE_NOT_FOUND);
			}// 判断传入的机构ID是否对的，错了就抛个异常
		}
		if (StringUtils.isBlank(parentId)) {
			throw new BusinessException("parentId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (parentType == null || parentType.equals("")) {
			throw new BusinessException("parentType",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpIntelligentChannelSeq();
		EpIntelligentChannel eic = new EpIntelligentChannel();
		eic.setId(id);
		eic.setName(name);
		eic.setNaming(naming);
		eic.setInstallLocation(installLocation);
		eic.setParentId(parentId);
		eic.setParentType(parentType);
		eic.setDescription(description);
		eic.setNote(note);
		eic.setCompany(company);
		eic.setChannelId(channelId);
		eic.setOrganId(organId);
		eic.setOptimisticLock(new BigDecimal(0));
		epIntelligentChannelDAO.insert(eic);

		return id;
	}

	public void deleteEIC(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.SUCCESS);
		}
		String str_array[] = id.split(",");
		for (int i = 0; i < str_array.length; i++) {
			try{
				epIntelligentChannelDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}

	}

	public List<EpIntelligentChannel> listEICByParentId(String parentId)
			throws BusinessException {
		if (StringUtils.isBlank(parentId)) {
			throw new BusinessException("parentId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epIntelligentChannelDAO.listEICByParentId(parentId);
	}

	public void updateEIC(String id, String name, String naming,
			String installLocation, String parentId, Short parentType,
			String description, String note, String company, Short channelId,
			String organId) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(name)) {
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (parentType == null || parentType.equals("")) {
			throw new BusinessException("parentType",
					ErrorCode.PARAMETER_NOT_FOUND);
		}

		if (StringUtils.isNotBlank(parentId)) {
			VideoInputServerExample visExample = new VideoInputServerExample();
			visExample.createCriteria().andIdEqualTo(parentId);
			int count = videoInputServerDAO.countByExample(visExample);
			if (count == 0) {
				throw new BusinessException("parentId",
						ErrorCode.RESOURCE_NOT_FOUND);
			}// 判断传入的视频服务器ID是否对的，错了就抛个异常
		}else{
			throw new BusinessException("parentId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(organId)) {
			OrganExample oExample = new OrganExample();
			oExample.createCriteria().andIdEqualTo(organId);
			int count1 = organDAO.countByExample(oExample);
			if (count1 == 0) {
				throw new BusinessException("organId",
						ErrorCode.RESOURCE_NOT_FOUND);
			}// 判断传入的机构ID是否对的，错了就抛个异常
		}else{
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		EpIntelligentChannel eic = new EpIntelligentChannel();
		eic.setId(id);
		eic.setName(name);
		eic.setNaming(naming);
		eic.setInstallLocation(installLocation);
		eic.setParentId(parentId);
		eic.setParentType(parentType);
		eic.setDescription(description);
		eic.setNote(note);
		eic.setCompany(company);
		eic.setChannelId(channelId);
		eic.setOrganId(organId);
		eic.setOptimisticLock(new BigDecimal(0));

		epIntelligentChannelDAO.updateByPrimaryKeySelective(eic);
	}

	public List<ListRemoteStorageServerVO> ListStorageServer() {
		return storageServerDAO.listRemoteStorageServer();
	}

	

	public List<EpIntelligentChannel> listEICByOrganId(String organId)
			throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epIntelligentChannelDAO.listEICByOrganId(organId);
	}

	public EpIntelligentChannel getEIC(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return epIntelligentChannelDAO.selectByPrimaryKey(id);
	}

	public AcGateway getAcGateway(String id) {

		return acGatewayDAO.selectByPrimaryKey(id);
	}

	public void mediaGatewayServerHeartbeat(String deviceNumber)
			throws BusinessException {
		MediaGatewayServerExample example = new MediaGatewayServerExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<MediaGatewayServer> list = mediaGatewayServerDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("deviceNumber: " + deviceNumber
					+ " not registered !", ErrorCode.RESOURCE_NOT_FOUND);
		}
		MediaGatewayServer record = list.get(0);
		record.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		record.setStatus(new Short("1"));
		mediaGatewayServerDAO.updateByPrimaryKeySelective(record);
	}

	public MediaGatewayServer mediaGatewayServerRegister(String deviceNumber,
			String lanIp, String wanIp, Integer msgPort, Integer heartbeatCycle)
			throws BusinessException {
		MediaGatewayServerExample example = new MediaGatewayServerExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<MediaGatewayServer> list = mediaGatewayServerDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("deviceNumber: " + deviceNumber
					+ " not found !", ErrorCode.RESOURCE_NOT_FOUND);
		}
		MediaGatewayServer record = list.get(0);
		if (!lanIp.equals(record.getLanIp())) {
			throw new BusinessException("lanIp mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (record.getMsgPort() == null
				|| msgPort.intValue() != record.getMsgPort().intValue()) {
			throw new BusinessException("msgPort mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setWanIp(wanIp);
		record.setStatus(new Short("1"));
		record.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		record.setHeartbeatCycle(heartbeatCycle == null ? 120 : heartbeatCycle);
		mediaGatewayServerDAO.updateByPrimaryKeySelective(record);
		return record;
	}

	public AcGateway getAcGatewayByDeviceNumber(String deviceNumber) {
		if (StringUtils.isBlank(deviceNumber)) {
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcGatewayExample example = new AcGatewayExample();
		AcGatewayExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceNumberEqualTo(deviceNumber.trim());
		List<AcGateway> gateways = acGatewayDAO.selectByExample(example);

		AcGateway gateway = gateways.isEmpty() ? null : gateways.get(0);
		return gateway;
	}

	public MediaGatewayServer getMediaGatewayServerById(String id) {
		return mediaGatewayServerDAO.selectByPrimaryKey(id);
	}

	
	public StorageInfoQueryVO getStorageInfoOfCamera(String accessId) {
		return storageServerDAO.getStorageInfoOfCamera(accessId);
	}

	@Override
	public void updateIpCameraVIC(String ipCameraId, String accessId) {
		ipCameraVisDAO.updateIpCameraVIC(ipCameraId);
	}

	@Override
	public String createSipServer(String name, String lanIp, Integer httpPort,
			 String deviceNumber, String registerType,
			String wanIp, Integer sipPort, Integer megaPort,
			String eventServerId, String mediaGatewayServerId) {
		
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			criteria.andNameEqualTo(name);
			int i = sipServerDAO.countByExample(ssExample);
			if(i>0){
				throw new BusinessException("name",ErrorCode.NAME_EXIST);
			}
		}
		if(StringUtils.isBlank(lanIp)){
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			criteria.andLanIpEqualTo(lanIp);
			int i = sipServerDAO.countByExample(ssExample);
			if(i>0){
				throw new BusinessException("lanIp",ErrorCode.IP_EXIST);
			}
		}
		if(httpPort==null||httpPort.equals("")){
			throw new BusinessException("httpPort", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(deviceNumber)){
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int i = sipServerDAO.countByExample(ssExample);
			if(i>0){
				throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}
		if(StringUtils.isBlank(registerType)){
			throw new BusinessException("registerType", ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			//registerType只能存在一个为1的
			if(registerType.equals("1")){
				SipServerExample ssExample = new SipServerExample();
				SipServerExample.Criteria criteria = ssExample.createCriteria();
				criteria.andRegisterTypeEqualTo("1");
				int i = sipServerDAO.countByExample(ssExample);
				if(i>0){
					throw new BusinessException(
							"Only one wan sip server can be registered !",
							ErrorCode.REGISTER_SERVER_EXIST);
				}
			}
		}
		if(StringUtils.isBlank(mediaGatewayServerId)){
			throw new BusinessException("mediaGatewayServerId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getSipServerSeq();
		SipServer ss = new SipServer();
		ss.setId(id);
		ss.setName(name);
		ss.setLanIp(lanIp);
		ss.setHttpPort(httpPort);
		ss.setDeviceNumber(deviceNumber);
		ss.setRegisterType(registerType);
		ss.setWanIp(wanIp);
		ss.setSipPort(sipPort);
		ss.setMegaPort(megaPort);
		ss.setEventServerId(eventServerId);
		ss.setMediaGatewayServerId(mediaGatewayServerId);
		sipServerDAO.insert(ss);
		
		return id;
	}

	@Override
	public void deleteSipServer(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		sipServerDAO.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateSipServer(String id, String name, String lanIp,
			Integer httpPort,  String deviceNumber,
			String registerType, String wanIp, Integer sipPort,
			Integer megaPort, String eventServerId, String mediaGatewayServerId) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			
			criteria.andNameEqualTo(name);
			List<SipServer> list = sipServerDAO.selectByExample(ssExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getName().equals(name)){
						throw new BusinessException("name",ErrorCode.NAME_EXIST);
					}
				}
			}
		}
		if(StringUtils.isBlank(lanIp)){
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			
			criteria.andLanIpEqualTo(lanIp);
			List<SipServer> list = sipServerDAO.selectByExample(ssExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getLanIp().equals(lanIp)){
						throw new BusinessException("lanIp",ErrorCode.IP_EXIST);
					}
				}
			}
		}
		if(httpPort==null||httpPort.equals("")){
			throw new BusinessException("httpPort", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(deviceNumber)){
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			SipServerExample ssExample = new SipServerExample();
			SipServerExample.Criteria criteria = ssExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<SipServer> list = sipServerDAO.selectByExample(ssExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getDeviceNumber().equals(deviceNumber)){
						throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}
		if(StringUtils.isBlank(registerType)){
			throw new BusinessException("registerType", ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			if(registerType.equals("1")){
				SipServerExample ssExample = new SipServerExample();
				SipServerExample.Criteria criteria = ssExample.createCriteria();
				criteria.andRegisterTypeEqualTo("1");
				List<SipServer> list = sipServerDAO.selectByExample(ssExample);
				if(list.size()>0){
					if(!list.get(0).getId().equals(id)){
						if(list.get(0).getRegisterType().equals(registerType)){
							throw new BusinessException(
									"Only one wan sip server can be registered !",
									ErrorCode.REGISTER_SERVER_EXIST);
						}
					}
				}
			}
		}
		if(StringUtils.isBlank(mediaGatewayServerId)){
			throw new BusinessException("mediaGatewayServerId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		SipServer ss = sipServerDAO.selectByPrimaryKey(id);
		ss.setId(id);
		ss.setName(name);
		ss.setLanIp(lanIp);
		ss.setHttpPort(httpPort);
		ss.setDeviceNumber(deviceNumber);
		ss.setRegisterType(registerType);
		ss.setWanIp(wanIp);
		ss.setSipPort(sipPort);
		ss.setMegaPort(megaPort);
		ss.setEventServerId(eventServerId);
		ss.setMediaGatewayServerId(mediaGatewayServerId);
		sipServerDAO.updateByPrimaryKeySelective(ss);
		
	}

	@Override
	public SipServer getSipServerById(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return sipServerDAO.selectByPrimaryKey(id);
	}

	@Override
	public List<SipServer> listSipServer() {
		
		return sipServerDAO.listSipServer();
	}

	@Override
	public String createMediaGatewayServer(String deviceNumber, String lanIp,
			String wanIp, Integer msgPort, Short status, String installLocation,
			Integer heartbeatCycle,String name) {
		if(StringUtils.isBlank(deviceNumber)){
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int i = mediaGatewayServerDAO.countByExample(egsExample);
			if(i>0){
				throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}
		
		if(StringUtils.isBlank(lanIp)){
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andLanIpEqualTo(lanIp);
			int i = mediaGatewayServerDAO.countByExample(egsExample);
			if(i>0){
				throw new BusinessException("lanIp",ErrorCode.IP_EXIST);
			}
		}
		
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andNameEqualTo(name);
			int i = mediaGatewayServerDAO.countByExample(egsExample);
			if(i>0){
				throw new BusinessException("name",ErrorCode.NAME_EXIST);
			}
		}
		String id = sequenceDAO.getMediaGatewayServerSeq();
		MediaGatewayServer mgs = new MediaGatewayServer();
		mgs.setId(id);
		mgs.setDeviceNumber(deviceNumber);
		mgs.setLanIp(lanIp);
		mgs.setWanIp(wanIp);
		mgs.setMsgPort(msgPort);
		mgs.setStatus(status);
		mgs.setInstallLocation(installLocation);
		mgs.setHeartbeatCycle(heartbeatCycle);
		mgs.setName(name);
		mediaGatewayServerDAO.insert(mgs);
		
		return id;
	}

	@Override
	public void deleteMediaGatewayServer(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		mediaGatewayServerDAO.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateMediaGatewayServer(String id, String deviceNumber,
			String lanIp, String wanIp, Integer msgPort,
			 String installLocation,Integer heartbeatCycle, String name) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if(StringUtils.isBlank(deviceNumber)){
			throw new BusinessException("deviceNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<MediaGatewayServer> list = mediaGatewayServerDAO.selectByExample(egsExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getDeviceNumber().equals(deviceNumber)){
						throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}
		
		if(StringUtils.isBlank(lanIp)){
			throw new BusinessException("lanIp",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andLanIpEqualTo(lanIp);
			List<MediaGatewayServer> list = mediaGatewayServerDAO.selectByExample(egsExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getLanIp().equals(lanIp)){
						throw new BusinessException("lanIp",ErrorCode.IP_EXIST);
					}
				}
			}
		}
		
		if(StringUtils.isBlank(name)){
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			MediaGatewayServerExample egsExample = new MediaGatewayServerExample();
			MediaGatewayServerExample.Criteria criteria = egsExample.createCriteria();
			criteria.andNameEqualTo(name);
			List<MediaGatewayServer> list = mediaGatewayServerDAO.selectByExample(egsExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getName().equals(name)){
						throw new BusinessException("name",ErrorCode.NAME_EXIST);
					}
				}
			}
		}
		
		MediaGatewayServer mgs = mediaGatewayServerDAO.selectByPrimaryKey(id);
		mgs.setId(id);
		mgs.setDeviceNumber(deviceNumber);
		mgs.setLanIp(lanIp);
		mgs.setWanIp(wanIp);
		mgs.setMsgPort(msgPort);
		mgs.setInstallLocation(installLocation);
		mgs.setHeartbeatCycle(heartbeatCycle);
		mgs.setName(name);
		mediaGatewayServerDAO.updateByPrimaryKeySelective(mgs);
	}

	@Override
	public List<MediaGatewayServer> listMediaGatewayServer() {
		
		return mediaGatewayServerDAO.listMediaGatewayServer();
	}
}
