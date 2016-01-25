package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcAccessCardsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcAccessControlsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcLogDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcRDoorCardDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.EpRDoorVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.RUserAccontrolDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AcAccessControlsExample;
import com.megaeyes.persistence.ibatis.model.AcLog;
import com.megaeyes.persistence.ibatis.model.AcRDoorCardExample;
import com.megaeyes.persistence.ibatis.model.EpRDoorVic;
import com.megaeyes.persistence.ibatis.model.EpRDoorVicExample;
import com.megaeyes.persistence.ibatis.model.RUserAccontrol;
import com.megaeyes.persistence.ibatis.model.RUserAccontrolExample;
import com.megaeyes.persistence.ibatis.vo.ListControlAndVicVO;
import com.megaeyes.persistence.ibatis.vo.ListDoorAndUserVO;
import com.megaeyes.persistence.ibatis.vo.ListDoorAndVicVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.persistence.ibatis.vo.UserVO;
import com.megaeyes.persistence.ibatis.vo.VideoICVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AccessControllerManager;

/**
 * AccessControllerManagerImpl(类说明)
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 上午09:15:57
 */
public class AccessControllerManagerImpl extends BaseManagerImpl implements
		AccessControllerManager {

	@Autowired
	private AcAccessControlsDAOiBatis acAccessControlDAO;
	@Autowired
	private SequenceDAOiBatis sequenceDAO;
	@Autowired
	private AcLogDAOiBatis acLogDAO;
	@Autowired
	EpRDoorVicDAOiBatis epRDoorVicDAO;
	@Autowired
	AcRDoorCardDAOiBatis acRDoorCardDAO;
	@Autowired
	RUserAccontrolDAOiBatis rUserAccontrolDAO;
	@Autowired
	AcAccessCardsDAOiBatis acAccessCardsDAO;
	@Autowired
	AcAccessCardManagerImpl acAccessCardManager;
	
	public List<UserSessionVO> listDoorNotifyUsers(String id) {
		return acAccessControlDAO.listDoorNotifyUsers(id);
	}

	public String addACLog(String triggerId, String deviceType, String logType,
			String triggerType, String deviceNaming, String note,
			BigDecimal time, String naming) throws BusinessException {
		String id = sequenceDAO.getACLogSeq();
		AcLog record = new AcLog();
		record.setId(id);
		record.setTriggerId(triggerId);
		record.setDeviceType(deviceType);
		record.setLogType(logType);
		record.setTriggerType(triggerType);
		record.setDeviceId(deviceNaming);
		record.setNote(note);
		record.setTime(time);
		record.setNaming(naming);
		acLogDAO.insert(record);
		return id;
	}

	public String createAcAccessControls(String name, String installLocation,
			String deviceNumber, Integer channelId, String note,
			String accessServerId,String remoteOpen) throws BusinessException {
		if (StringUtils.isNotBlank(name)) {
			AcAccessControlsExample aacExample = new AcAccessControlsExample();
			AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andAccessServerIdEqualTo(accessServerId);
			int count = acAccessControlDAO.countByExample(aacExample);
			if(count>0){
				throw new BusinessException("name",ErrorCode.NAME_EXIST);
			}
		}else{
			throw new BusinessException("name",ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			AcAccessControlsExample aacExample = new AcAccessControlsExample();
			AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			int count = acAccessControlDAO.countByExample(aacExample);
			if(count>0){
				throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("accessServerId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (null == channelId || channelId.equals("")) {
			throw new BusinessException("channelId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getAcAccessControlsSeq();
		String organId = acAccessControlDAO
				.getOrganIdByAccessServerId(accessServerId);
		String serversNaming = acAccessControlDAO
				.getNamingByAccessServerId(accessServerId);
		String naming = id + ":" + serversNaming;
		AcAccessControls aac = new AcAccessControls();
		aac.setId(id);
		aac.setName(name);
		aac.setOrganId(organId);
		aac.setNaming(naming);
		aac.setInstallLocation(installLocation);
		aac.setDeviceNumber(deviceNumber);
		aac.setChannelId(channelId);
		aac.setNote(note);
		aac.setDeviceType(1);
		aac.setAccessServerId(accessServerId);
		aac.setStatus(0);
		aac.setRemoteOpen(remoteOpen);
		acAccessControlDAO.insert(aac);

		return id;
	}

	public void deleteAcAccessControls(String id) throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			//删除门的同时把绑定的卡的状态更新为2
			acAccessCardManager.updateStatusByDoorId(id);	
			// 删除门的同时删除门和卡关系表记录
			AcRDoorCardExample arcExample = new AcRDoorCardExample();
			AcRDoorCardExample.Criteria criteria = arcExample.createCriteria();
			criteria.andDoorIdEqualTo(id);
			acRDoorCardDAO.deleteByExample(arcExample);
			// 删除门时同时删除门和摄像头关系表记录
			EpRDoorVicExample erdvExmple = new EpRDoorVicExample();
			EpRDoorVicExample.Criteria criteria1 = erdvExmple.createCriteria();
			criteria1.andDoorIdEqualTo(id);
			epRDoorVicDAO.deleteByExample(erdvExmple);
			// 删除门时同时删除门和用户关系表记录
			RUserAccontrolExample ruaExample = new RUserAccontrolExample();
			RUserAccontrolExample.Criteria criteria3 = ruaExample.createCriteria();
			criteria3.andControlIdEqualTo(id);
			rUserAccontrolDAO.deleteByExample(ruaExample);
			// 删除门
			acAccessControlDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
		}
	}

	public void updateAcAccessControls(String id, String name,
			String installLocation, String deviceNumber, Integer channelId,
			String note, String accessServerId,String remoteOpen) throws BusinessException {
		if (StringUtils.isNotBlank(name)) {
			AcAccessControlsExample aacExample = new AcAccessControlsExample();
			AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andNameEqualTo(name);
			criteria.andAccessServerIdEqualTo(accessServerId);
			List<AcAccessControls> list = acAccessControlDAO.selectByExample(aacExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getName().equals(name)){
						throw new BusinessException("name",ErrorCode.NAME_EXIST);
					}
				}
			}
		}else{
			throw new BusinessException("name", ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isNotBlank(deviceNumber)) {
			AcAccessControlsExample aacExample = new AcAccessControlsExample();
			AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andDeviceNumberEqualTo(deviceNumber);
			List<AcAccessControls> list = acAccessControlDAO.selectByExample(aacExample);
			if(list.size()>0){
				if(!list.get(0).getId().equals(id)){
					if(list.get(0).getDeviceNumber().equals(deviceNumber)){
						throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_DUPLICATE);
					}
				}
			}
		}else{
			throw new BusinessException("deviceNumber",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("accessServerId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		if (null == channelId || channelId.equals("")) {
			throw new BusinessException("channelId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessControls aac = new AcAccessControls();
		aac.setId(id);
		aac.setName(name);
		aac.setInstallLocation(installLocation);
		aac.setDeviceNumber(deviceNumber);
		aac.setChannelId(channelId);
		aac.setNote(note);
		aac.setAccessServerId(accessServerId);
		aac.setRemoteOpen(remoteOpen);
		acAccessControlDAO.updateByPrimaryKeySelective(aac);
	}

	public AcAccessControls getAcAccessControlsById(String id)
			throws BusinessException {
		if (StringUtils.isBlank(id)) {
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return acAccessControlDAO.selectByPrimaryKey(id);
	}

	public List<AcAccessControls> listAcAccessControlsByOrganId(String organId)
			throws BusinessException {
		if (StringUtils.isBlank(organId)) {
			throw new BusinessException("organId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessControlsExample aacExample = new AcAccessControlsExample();
		AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
		criteria.andOrganIdEqualTo(organId);
		return acAccessControlDAO.selectByExample(aacExample);
	}

	public List<AcAccessControls> listAcAccessControlsByAccessServerId(
			String accessServerId) throws BusinessException {
		if (StringUtils.isBlank(accessServerId)) {
			throw new BusinessException("accessServerId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessControlsExample aacExample = new AcAccessControlsExample();
		AcAccessControlsExample.Criteria criteria = aacExample.createCriteria();
		criteria.andAccessServerIdEqualTo(accessServerId);
		return acAccessControlDAO.selectByExample(aacExample);
	}

	public List<AcAccessControls> listAcAccessControlByGatewayId(
			String gatewayId) throws BusinessException {
		if (StringUtils.isBlank(gatewayId)) {
			throw new BusinessException("gatewayId",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		return acAccessControlDAO.listAcAccessControlByGatewayId(gatewayId);
	}

	public void bindDoorAndVic(String jsonString) throws JSONException,
			BusinessException {
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		JSONObject jsonObj = new JSONObject(jsonString);
		String doorId = jsonObj.getString("doorId");
		EpRDoorVicExample erdvExample = new EpRDoorVicExample();
		EpRDoorVicExample.Criteria criteria = erdvExample.createCriteria();
		criteria.andDoorIdEqualTo(doorId);
		epRDoorVicDAO.deleteByExample(erdvExample);
		org.json.JSONArray jsonArray = jsonObj.getJSONArray("vicIds");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
				String vicId = jsonObject.getString("vicId");
				String id = sequenceDAO.getEpRDoorVicSeq();
				EpRDoorVic erdv = new EpRDoorVic();
				erdv.setId(id);
				erdv.setDoorId(doorId);
				erdv.setVicId(vicId);
				erdv.setPresetId("");
				epRDoorVicDAO.insert(erdv);
			}
		} else {
			epRDoorVicDAO.deleteByExample(erdvExample);
		}

	}

	public List<ListControlAndVicVO> listControlAndVic(String organId) {
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.ORGAN_NOT_FOUND);
		}
		List<ListDoorAndVicVO> aac = acAccessControlDAO.listControlAndVic(organId);
		List<ListDoorAndUserVO> aau = acAccessControlDAO.listControlAndUser(organId);
		List<ListControlAndVicVO> list = new ArrayList();
		List<ListControlAndVicVO> list1 = new ArrayList();
		String id = null;
		String doorId = null;
		ListControlAndVicVO cvvo = new ListControlAndVicVO();
		ListControlAndVicVO cuvo = new ListControlAndVicVO();
		List vicList = null;
		List userList = null;
		for (int j = 0; j < aau.size(); j++) {
			ListDoorAndUserVO aauvo = aau.get(j);
			if (!aauvo.getId().equals(doorId)) {
				if (j != 0) {
					cuvo.setUser(userList);
					list1.add(cuvo);
				}
				doorId = aauvo.getId();
				cuvo = new ListControlAndVicVO();
				cuvo.setId(aauvo.getId());
				cuvo.setName(aauvo.getName());
				cuvo.setAccessServerId(aauvo.getAccessServerId());
				cuvo.setChannelId(aauvo.getChannelId());
				cuvo.setDeviceNumber(aauvo.getDeviceNumber());
				cuvo.setDeviceType(aauvo.getDeviceType());
				cuvo.setInstallLocation(aauvo.getInstallLocation());
				cuvo.setNaming(aauvo.getNaming());
				cuvo.setNote(aauvo.getNote());
				cuvo.setOrganId(aauvo.getOrganId());
				cuvo.setPhysicalProtection(aauvo.getPhysicalProtection());
				cuvo.setStatus(aauvo.getStatus());
				cuvo.setTechnicalProtection(aauvo.getTechnicalProtection());
				cuvo.setRemoteOpen(aauvo.getRemoteOpen());
				userList = new ArrayList();
				if (aauvo.getUserId() != "" && aauvo.getUserId() != null) {
					UserVO uvo = new UserVO();
					uvo.setUserName(aauvo.getUserName());
					uvo.setUserId(aauvo.getUserId());
					System.out.println(aauvo.getUserName());
					userList.add(uvo);
				}
			} else {
				if (aauvo.getUserId() != "" && aauvo.getUserId() != null) {
					UserVO uvo = new UserVO();
					uvo.setUserName(aauvo.getUserName());
					uvo.setUserId(aauvo.getUserId());
					userList.add(uvo);
				}
			}
			if (j == aau.size() - 1) {
				cuvo.setUser(userList);
				list1.add(cuvo);
			}
		}

		for (int i = 0; i < aac.size(); i++) {
			ListDoorAndVicVO aacvo = aac.get(i);
			if (!aacvo.getId().equals(id)) {
				if (i != 0) {
					System.out.println("if");
					cvvo.setVic(vicList);
					list.add(cvvo);
				}
				id = aacvo.getId();
				cvvo = new ListControlAndVicVO();
				cvvo.setId(aacvo.getId());
				cvvo.setName(aacvo.getName());
				cvvo.setAccessServerId(aacvo.getAccessServerId());
				cvvo.setChannelId(aacvo.getChannelId());
				cvvo.setDeviceNumber(aacvo.getDeviceNumber());
				cvvo.setDeviceType(aacvo.getDeviceType());
				cvvo.setInstallLocation(aacvo.getInstallLocation());
				cvvo.setNaming(aacvo.getNaming());
				cvvo.setNote(aacvo.getNote());
				cvvo.setOrganId(aacvo.getOrganId());
				cvvo.setPhysicalProtection(aacvo.getPhysicalProtection());
				cvvo.setStatus(aacvo.getStatus());
				cvvo.setTechnicalProtection(aacvo.getTechnicalProtection());
				cvvo.setRemoteOpen(aacvo.getRemoteOpen());
				vicList = new ArrayList();
				if (aacvo.getVicId() != "" && aacvo.getVicId() != null) {
					VideoICVO vvo = new VideoICVO();
					vvo.setId(aacvo.getVicId());
					vvo.setName(aacvo.getVicName());
					vvo.setNaming(aacvo.getVicNaming());
					vicList.add(vvo);
				}
			} else {
				if (aacvo.getVicId() != "" && aacvo.getVicId() != null) {
					VideoICVO vvo = new VideoICVO();
					vvo.setId(aacvo.getVicId());
					vvo.setName(aacvo.getVicName());
					vvo.setNaming(aacvo.getVicNaming());
					vicList.add(vvo);
				}
			}
			if (i == aac.size() - 1) {
				cvvo.setVic(vicList);
				list.add(cvvo);
			}

		}
		for (int k = 0; k < list.size(); k++) {
			list.get(k).setUser(list1.get(k).getUser());
		}

		return list;

	}

	public void bindDoorAndUser(String jsonString) throws BusinessException {
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject
				.fromObject(jsonString);
		String doorId = jsonObject.getString("doorId");
		if (StringUtils.isBlank(doorId)) {
			throw new BusinessException("doorId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		RUserAccontrolExample ruaExample = new RUserAccontrolExample();
		RUserAccontrolExample.Criteria criteria = ruaExample.createCriteria();
		criteria.andControlIdEqualTo(doorId);
		rUserAccontrolDAO.deleteByExample(ruaExample);
		JSONArray jsonArray = jsonObject.getJSONArray("userIds");
		if (jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {
				net.sf.json.JSONObject obj = jsonArray.getJSONObject(i);
				String userId = obj.getString("userId");
				if (StringUtils.isBlank(userId)) {
					throw new BusinessException("userId",
							ErrorCode.PARAMETER_NOT_FOUND);
				}
				RUserAccontrol rua = new RUserAccontrol();
				rua.setControlId(doorId);
				rua.setUserId(userId);
				rUserAccontrolDAO.insert(rua);
			}
		} else {
			rUserAccontrolDAO.deleteByExample(ruaExample);
		}
	}

	public List<String> listDoorBindVics(String doorId)
			throws BusinessException {
		return acAccessControlDAO.listDoorBindVics(doorId);
	}

	@Override
	public void updateRemoteOpen(String doorId, String remoteOpen) {
		if(StringUtils.isBlank(doorId)){
			throw new BusinessException("doorId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessControls aac = acAccessControlDAO.selectByPrimaryKey(doorId);
		aac.setRemoteOpen(remoteOpen);
		acAccessControlDAO.updateByPrimaryKeySelective(aac);
	}

}
