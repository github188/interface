package com.megaeyes.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.iface.PlatformSubscribeDAO;
import com.megaeyes.persistence.ibatis.iface.RtpPayloadDAO;
import com.megaeyes.persistence.ibatis.iface.ThirdPartyPlatformDAO;
import com.megaeyes.persistence.ibatis.iface.UserSubscribeDAO;
import com.megaeyes.persistence.ibatis.impl.AlarmBoxDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AlarmInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.OrganDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.PlatformResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SipServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.StorageServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.TempResourcesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.UserDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputChannelDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputServerDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.VideoInputServerModelDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AlarmBox;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.HistoryVideo;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.PlatformResourcesExample;
import com.megaeyes.persistence.ibatis.model.PlatformSubscribe;
import com.megaeyes.persistence.ibatis.model.PlatformSubscribeExample;
import com.megaeyes.persistence.ibatis.model.RtpPayload;
import com.megaeyes.persistence.ibatis.model.RtpPayloadExample;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.model.SipServerExample;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.TempResources;
import com.megaeyes.persistence.ibatis.model.TempResourcesExample;
import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;
import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatformExample;
import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.persistence.ibatis.model.UserSubscribe;
import com.megaeyes.persistence.ibatis.model.UserSubscribeExample;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.vo.PlatformVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.persistence.ibatis.vo.VicStorageServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.InterConnectManager;
import com.megaeyes.service.utils.Configuration;
import com.megaeyes.service.utils.DeviceType;
import com.megaeyes.service.utils.socket.MegaSocketClient;

/**
 * InterConnectManagerImpl
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 下午02:28:28
 */
public class InterConnectManagerImpl extends BaseManagerImpl implements
		InterConnectManager {
	@Autowired
	private UserSubscribeDAO userSubscribeDAO;
	@Autowired
	private TempResourcesDAOiBatis tempResourceDAO;
	@Autowired
	private SipServerDAOiBatis sipServerDAO;
	@Autowired
	private PlatformResourcesDAOiBatis platformResourcesDAO;
	@Autowired
	private ThirdPartyPlatformDAO thirdPartyPlatformDAO;
	@Autowired
	private SequenceDAOiBatis sequenceDAO;
	@Autowired
	private PlatformSubscribeDAO platformSubscribeDAO;
	@Autowired
	private VideoInputServerDAOiBatis videoInputServerDAO;
	@Autowired
	private VideoInputServerModelDAOiBatis videoInputServerModelDAO;
	@Autowired
	private RtpPayloadDAO rtpPayloadDAO;
	@Autowired
	private VideoInputChannelDAOiBatis VideoInputChannelDAO;
	@Autowired
	private AlarmInputChannelDAOiBatis alarmInputChannelDAO;
	@Autowired
	private AlarmBoxDAOiBatis alarmBoxDAO;
	@Autowired
	private OrganDAOiBatis organDAO;
	@Autowired
	private StorageServerDAOiBatis storageServerDAO;
	@Autowired
	private UserDAOiBatis userDAO;

	public static final String ORGAN = "organ";
	public static final String VIS = "vis";
	public static final String VIC = "vic";
	public static final String AIC = "aic";
	public static final String PROBER = "prober";
	public static final String USER = "user";

	/**
	 * 计划录像类型常量
	 */
	public static final String TYPE_PLAN_RECORD = "1048576";
	/**
	 * 全报警类型常量
	 */
	public static final String TYPE_ALL_RECORD = "-1";

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
	private SimpleDateFormat sdf1 = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	public Set<String> listNotifyUser(String code, String event) {
		Set<String> notifyUsers = new HashSet<String>();

		// 查询直接订阅此设备的用户
		UserSubscribeExample example = new UserSubscribeExample();
		example.createCriteria().andCodeEqualTo(code).andEventEqualTo(event);
		List<UserSubscribe> directList = userSubscribeDAO
				.selectByExample(example);
		for (UserSubscribe us : directList) {
			notifyUsers.add(us.getUserId());
		}

		// 查询订阅了此设备的所有父节点的用户
		// 查询整个父节点树列表
		List<String> parents = tempResourceDAO.listParentTree(code);
		for (String parent : parents) {
			example = new UserSubscribeExample();
			example.createCriteria().andCodeEqualTo(parent)
					.andEventEqualTo(event);
			List<UserSubscribe> parentList = userSubscribeDAO
					.selectByExample(example);
			for (UserSubscribe us : parentList) {
				notifyUsers.add(us.getUserId());
			}
		}
		return notifyUsers;
	}

	public List<UserSessionVO> listOnlineNotifyUsers(List<String> ids) {
		if (ids.size() < 1) {
			return new ArrayList<UserSessionVO>();
		}
		return userSessionDAO.listOnlineUserByIds(ids);
	}

	public SipServer sipServerRegister(String lanIp, String wanIp,
			int httpPort, int sipPort, int megaPort, String deviceNumber,
			String registerType) throws BusinessException {
		SipServerExample example = new SipServerExample();
		example.createCriteria().andDeviceNumberEqualTo(deviceNumber);
		List<SipServer> list = sipServerDAO.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("sip_server.device_number "
					+ deviceNumber + " not found !",
					ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
		// 对外信令服务器只允许存在一个
		if (SIP_SERVER_REGISTER_TYPE_WAN.equals(registerType)) {
			example = new SipServerExample();
			example.createCriteria().andRegisterTypeEqualTo(
					SIP_SERVER_REGISTER_TYPE_WAN);
			List<SipServer> wanServerList = sipServerDAO
					.selectByExample(example);
			if (wanServerList.size() > 0) {
				SipServer wanServer = wanServerList.get(0);
				if (!deviceNumber.equals(wanServer.getDeviceNumber())) {
					throw new BusinessException(
							"Only one wan sip server can be registered !",
							ErrorCode.REGISTER_SERVER_EXIST);
				}
			}
		}

		SipServer record = list.get(0);
		if (!lanIp.equals(record.getLanIp())) {
			throw new BusinessException("lanIp mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (record.getHttpPort() == null
				|| httpPort != record.getHttpPort().intValue()) {
			throw new BusinessException("httpPort mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (record.getSipPort() == null
				|| sipPort != record.getSipPort().intValue()) {
			throw new BusinessException("sipPort mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		if (record.getMegaPort() == null
				|| megaPort != record.getMegaPort().intValue()) {
			throw new BusinessException("megaPort mapping error !",
					ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		record.setWanIp(wanIp);
		record.setHeartbeatTime(new BigDecimal(System.currentTimeMillis()));
		record.setRegisterType(registerType);
		sipServerDAO.updateByPrimaryKeySelective(record);
		return record;
	}

	public String getPlatformSipCode() throws BusinessException {
		PlatformResourcesExample example = new PlatformResourcesExample();
		example.createCriteria().andOrganIdIsNull().andTypeEqualTo(ORGAN);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("no platform code",
					ErrorCode.NO_PLATFORM_CODE);
		}
		return list.get(0).getSipCode();
	}

	public int sipServerHeartbeat(String deviceNumber) {
		return sipServerDAO.heartBeat(deviceNumber);
	}

	public List<ThirdPartyPlatform> listThirdPartyPlatform() {
		ThirdPartyPlatformExample example = new ThirdPartyPlatformExample();
		List<ThirdPartyPlatform> list = thirdPartyPlatformDAO
				.selectByExample(example);
		// 根据上次心跳时间，刷新第三方平台的状态
		for (ThirdPartyPlatform record : list) {
			long time = record.getHeartbeatTime();
			long interval = Long.parseLong(Configuration.getInstance()
					.getProperties("lower_platform_heartbeat_time")) * 1000;
			// 如果平台心跳时间+2倍心跳间隔时间小于当前时间，则认为平台下线
			if ((time + 2 * interval) < System.currentTimeMillis()) {
				// 更新数据库状态
				record.setStatus(new Short("0"));
				thirdPartyPlatformDAO.updateByPrimaryKey(record);
			}
			// 平台上线状态
			else {
				record.setStatus(new Short("1"));
				thirdPartyPlatformDAO.updateByPrimaryKey(record);
			}
		}
		return list;
	}

	public String namingToCode(String naming) throws BusinessException {
		// 按照naming查找
		if (naming.length() > 32) {
			// 首先在本平台查找
			PlatformResourcesExample example = new PlatformResourcesExample();
			example.createCriteria().andNamingEqualTo(naming);
			List<PlatformResources> list = platformResourcesDAO
					.selectByExample(example);
			// 如果没有在外平台查找
			if (list.size() < 1) {
				TempResourcesExample trExample = new TempResourcesExample();
				trExample.createCriteria().andNamingEqualTo(naming);
				List<TempResources> resources = tempResourceDAO
						.selectByExample(trExample);
				if (resources.size() < 1) {
					throw new BusinessException("naming: " + naming
							+ " not found !", ErrorCode.RESOURCE_NOT_FOUND);
				}
				return resources.get(0).getSipCode();
			}
			return list.get(0).getSipCode();
		}
		// 按照ID查找
		else {
			// 先在外平台设备中查找
			TempResourcesExample tempExample = new TempResourcesExample();
			tempExample.createCriteria().andIdEqualTo(naming);
			List<TempResources> resources = tempResourceDAO
					.selectByExample(tempExample);
			if (resources.size() < 1) {
				// 如果没有在本平台中查找
				PlatformResourcesExample prExample = new PlatformResourcesExample();
				prExample.createCriteria().andResourceIdEqualTo(naming);
				List<PlatformResources> list = platformResourcesDAO
						.selectByExample(prExample);
				if (list.size() < 1) {
					throw new BusinessException("id: " + naming
							+ " not found !", ErrorCode.RESOURCE_NOT_FOUND);
				}
				return list.get(0).getSipCode();
			}
			return resources.get(0).getSipCode();
		}
	}

	public void userSubscribe(String userId, String platformCode, String code,
			Long updateTime, String event, String type)
			throws BusinessException {
		// 查询订阅是否已经存在
		UserSubscribeExample example = new UserSubscribeExample();
		example.createCriteria().andUserIdEqualTo(userId).andCodeEqualTo(code)
				.andEventEqualTo(event == null ? "alarm" : event);
		List<UserSubscribe> list = userSubscribeDAO.selectByExample(example);
		// 存在则只修改更新时间
		if (list.size() > 0) {
			UserSubscribe userSubscribe = list.get(0);
			userSubscribe.setUpdateTime(updateTime == null ? System
					.currentTimeMillis() : updateTime.longValue());
			userSubscribeDAO.updateByPrimaryKey(userSubscribe);
		}
		// 不存在，插入新纪录
		else {
			UserSubscribe record = new UserSubscribe();
			String id = sequenceDAO.getUserSubscribeSeq();
			record.setId(id);
			record.setUserId(userId);
			// 如果没有平台Code根据设备递归查找平台Code
			if (StringUtils.isBlank(platformCode)) {
				List<String> parents = tempResourceDAO.listParentTree(code);
				if (parents.size() < 1) {
					throw new BusinessException("code: " + code
							+ " not found !", ErrorCode.RESOURCE_NOT_FOUND);
				}
				platformCode = parents.get(parents.size() - 1);
			}
			record.setPlatformCode(platformCode);
			record.setCode(code);
			record.setUpdateTime(updateTime == null ? System
					.currentTimeMillis() : updateTime.longValue());
			record.setEvent(event == null ? "alarm" : event);
			record.setType(type);
			userSubscribeDAO.insert(record);
		}
	}

	public String codeToSipUrl(String code) throws BusinessException {
		// 递归查询temp_resource得到最上级平台Code
		List<String> parents = tempResourceDAO.listParentTree(code);
		if (parents.size() < 1) {
			return code;
		}
		String platformCode = parents.get(parents.size() - 1);
		// 查询平台SIP_URL
		ThirdPartyPlatformExample pExample = new ThirdPartyPlatformExample();
		pExample.createCriteria().andSipCodeEqualTo(platformCode);
		List<ThirdPartyPlatform> platforms = thirdPartyPlatformDAO
				.selectByExample(pExample);
		if (platforms.size() < 1) {
			return code;
		}
		String sipUrl = platforms.get(0).getSipUrl();
		String urlSuffix = sipUrl.substring(sipUrl.indexOf("@") + 1);

		return "sip:" + code + "@" + urlSuffix;
	}

	public void platformSubscribe(String platformCode, String code,
			Long updateTime, String event, String type)
			throws BusinessException {
		// 查询订阅是否已经存在
		PlatformSubscribeExample example = new PlatformSubscribeExample();
		example.createCriteria().andPlatformCodeEqualTo(platformCode)
				.andCodeEqualTo(code)
				.andEventEqualTo(event == null ? "alarm" : event);
		List<PlatformSubscribe> list = platformSubscribeDAO
				.selectByExample(example);
		// 存在则只修改更新时间
		if (list.size() > 0) {
			PlatformSubscribe platformSubscribe = list.get(0);
			platformSubscribe.setUpdateTime(updateTime == null ? System
					.currentTimeMillis() : updateTime.longValue());
			platformSubscribeDAO.updateByPrimaryKey(platformSubscribe);
		}
		// 不存在，插入新纪录
		else {
			PlatformSubscribe record = new PlatformSubscribe();
			String id = sequenceDAO.getPlatformSubscribeSeq();
			record.setId(id);
			record.setPlatformCode(platformCode);
			record.setCode(code);
			record.setUpdateTime(updateTime == null ? System
					.currentTimeMillis() : updateTime.longValue());
			record.setEvent(event == null ? "alarm" : event);
			record.setType(type);
			platformSubscribeDAO.insert(record);
		}
	}

	public void cancelUserSubscribe(String userId, String code, String event)
			throws BusinessException {
		UserSubscribeExample example = new UserSubscribeExample();
		UserSubscribeExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId).andCodeEqualTo(code);
		if (StringUtils.isNotBlank(event)) {
			criteria.andEventEqualTo(event);
		}
		userSubscribeDAO.deleteByExample(example);
	}

	public void cancelPlatformSubscribe(String platformCode, String code,
			String type, String event) throws BusinessException {
		PlatformSubscribeExample example = new PlatformSubscribeExample();
		PlatformSubscribeExample.Criteria criteria = example.createCriteria();
		criteria.andPlatformCodeEqualTo(platformCode).andCodeEqualTo(code)
				.andTypeEqualTo(type);
		if (StringUtils.isNotBlank(event)) {
			criteria.andEventEqualTo(event);
		}
		platformSubscribeDAO.deleteByExample(example);
	}

	public RtpPayload getRtpPayload(String code) throws BusinessException {
		// 首先在temp_resource表里面获取rtp payload值
		TempResourcesExample example = new TempResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<TempResources> list = tempResourceDAO.selectByExample(example);
		if (list.size() > 0) {
			TempResources vic = list.get(0);
			// 返回下级设备rtp payload
			RtpPayload rtn = new RtpPayload();
			rtn.setPayload(vic.getDecoderTag());
			return rtn;
		} else {
			// 在platform_resource表里面获取摄像头Naming
			PlatformResourcesExample prExample = new PlatformResourcesExample();
			prExample.createCriteria().andSipCodeEqualTo(code);
			List<PlatformResources> prList = platformResourcesDAO
					.selectByExample(prExample);
			if (prList.size() > 0) {
				PlatformResources platformResource = prList.get(0);
				if (StringUtils.isBlank(platformResource.getNaming())) {
					throw new BusinessException("device not registered !",
							ErrorCode.DEVICE_NOT_REGISTERED);
				}
				String visId = platformResource.getNaming().split(":")[1];
				// 或取摄像头所属视频服务器的类型
				VideoInputServer vis = videoInputServerDAO
						.selectByPrimaryKey(visId);
				VideoInputServerModel model = videoInputServerModelDAO
						.selectByPrimaryKey(vis.getVideoInputServerModelId());
				// 获取rtp payload
				RtpPayloadExample rtpExample = new RtpPayloadExample();
				rtpExample.createCriteria().andPayloadEqualTo(
						model.getRtpPayload());
				List<RtpPayload> rtpPayloads = rtpPayloadDAO
						.selectByExample(rtpExample);
				if (rtpPayloads.size() > 0) {
					return rtpPayloads.get(0);
				} else {
					throw new BusinessException("rtp payload not found!",
							ErrorCode.RTP_PAYLOAD_NOT_FOUND);
				}
			} else {
				throw new BusinessException("device not found!",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
		}
	}

	public Set<String> listNotifyPlatform(String code, String event)
			throws BusinessException {
		Set<String> notifyPlatforms = new HashSet<String>();
		// 查询直接订阅此设备的平台
		PlatformSubscribeExample example = new PlatformSubscribeExample();
		example.createCriteria().andCodeEqualTo(code).andEventEqualTo(event);
		List<PlatformSubscribe> directList = platformSubscribeDAO
				.selectByExample(example);
		for (PlatformSubscribe p : directList) {
			notifyPlatforms.add(p.getPlatformCode());
		}

		// 获取改设备资源的详细信息
		PlatformResources resources = platformResourcesDAO.getBySipCode(code);
		if (resources == null) {
			throw new BusinessException("code: " + code + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}

		// 查询订阅此设备的父设备（目前只有vis）的平台
		PlatformResources parent = null;
		String resourceId = resources.getResourceId();
		// 如果是摄像头
		if (resources.getType().equals(VIC)) {
			VideoInputChannel vic = VideoInputChannelDAO
					.selectByPrimaryKey(resourceId);
			parent = platformResourcesDAO.getByResourceId(
					vic.getVideoInputServerId(), VIS);
		}
		// 如果报警输入
		else if (resources.getType().equals(AIC)) {
			AlarmInputChannel aic = alarmInputChannelDAO
					.selectByPrimaryKey(resourceId);
			AlarmBox ab = alarmBoxDAO.selectByPrimaryKey(aic.getAlarmBoxId());
			parent = platformResourcesDAO.getByResourceId(
					ab.getVideoInputServerId(), VIS);
		} else {
			// do nothing
		}
		if (null != parent) {
			example = new PlatformSubscribeExample();
			example.createCriteria().andCodeEqualTo(parent.getSipCode())
					.andEventEqualTo(event);
			List<PlatformSubscribe> parentList = platformSubscribeDAO
					.selectByExample(example);
			for (PlatformSubscribe p : parentList) {
				notifyPlatforms.add(p.getPlatformCode());
			}
		}

		// 查询订阅包涵了此设备的机构的平台
		String organId = resources.getOrganId();
		// 查询设备直属机构的所有上级机构
		Organ o = organDAO.selectByPrimaryKey(organId);
		String path = o.getPath();
		String[] organArray = path.split("/");
		// 查询每个机构的订阅关系，加入到返回结果中
		for (int i = 1; i < organArray.length; i++) {
			PlatformResources organ = platformResourcesDAO.getByResourceId(
					organArray[i], ORGAN);
			example = new PlatformSubscribeExample();
			example.createCriteria().andCodeEqualTo(organ.getSipCode());
			List<PlatformSubscribe> organList = platformSubscribeDAO
					.selectByExample(example);
			for (PlatformSubscribe p : organList) {
				notifyPlatforms.add(p.getPlatformCode());
			}
		}
		return notifyPlatforms;
	}

	public String codeToName(String code) throws BusinessException {
		// 先在platform_resources里面查找
		PlatformResources pr = platformResourcesDAO.getBySipCode(code);
		if (null != pr) {
			return pr.getName();
		}

		// platform_resources里面没有再在temp_resources里面查找
		TempResourcesExample example = new TempResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<TempResources> list = tempResourceDAO.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("code: " + code + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		return list.get(0).getName();
	}

	public PlatformResources getResourceByCode(String code)
			throws BusinessException {
		PlatformResourcesExample example = new PlatformResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new BusinessException("code: " + code + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
	}

	public String getUserCodeBySessionId(String sessionId)
			throws BusinessException {
		if (StringUtils.isBlank(sessionId)) {
			return "";
		}

		UserSession us = userSessionDAO.selectByPrimaryKey(sessionId);
		if (null == us) {
			throw new BusinessException("sessionId: " + sessionId
					+ " not found !", ErrorCode.USER_SESSION_NOT_FOUND);
		}

		PlatformResourcesExample example = new PlatformResourcesExample();
		example.createCriteria().andResourceIdEqualTo(us.getUserId())
				.andTypeEqualTo("user");
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("user.id: " + us.getUserId()
					+ " has not sipCode !", ErrorCode.RESOURCE_NOT_FOUND);
		}
		return list.get(0).getSipCode();
	}

	public void platformUpdateStatus(String sipCode, Short status,
			String httpUrl, String sipUrl, String name, Long heartbeatTime) {
		ThirdPartyPlatformExample example = new ThirdPartyPlatformExample();
		example.createCriteria().andSipCodeEqualTo(sipCode);
		List results = thirdPartyPlatformDAO.selectByExample(example);

		// 如果没有记录就新增
		if (results == null || results.isEmpty()) {
			ThirdPartyPlatform record = new ThirdPartyPlatform();
			String id = sequenceDAO.getThirdPartyPlatformSeq();
			record.setHttpUrl(httpUrl);
			record.setId(id);
			record.setName(sipCode);
			record.setSipCode(sipCode);
			record.setSipUrl(sipUrl);
			record.setStatus(status);
			record.setHeartbeatTime(heartbeatTime);
			thirdPartyPlatformDAO.insert(record);
		} else {// 如果有就修改
			ThirdPartyPlatform record = (ThirdPartyPlatform) results.get(0);
			String id = record.getId();
			record.setId(id);
			record.setHttpUrl(httpUrl);
			record.setName(sipCode);
			record.setSipCode(sipCode);
			record.setSipUrl(sipUrl);
			record.setStatus(status);
			record.setHeartbeatTime(heartbeatTime);
			thirdPartyPlatformDAO.updateByPrimaryKeySelective(record);

			// 同时清空此下级平台temp_resource中的数据
			String platformCodeprefix = sipCode.substring(0, 5);
			TempResourcesExample trExample = new TempResourcesExample();
			trExample.createCriteria().andSipCodeLike(platformCodeprefix + "%");
			tempResourceDAO.deleteByExample(trExample);
		}
	}

	public List<UserSubscribe> listUserSubscribeByPlatformCode(
			String platformCode) {
		UserSubscribeExample example = new UserSubscribeExample();
		example.createCriteria().andPlatformCodeEqualTo(platformCode);
		return userSubscribeDAO.selectByExample(example);
	}

	public VicStorageServerVO getVicStorageServer(String id) {
		VicStorageServerVO vo = new VicStorageServerVO();

		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(id);
		String planId = vic.getRemoteStorageServerId();
		String alarmId = vic.getAlarmStorageServerId();

		if (StringUtils.isNotBlank(planId)) {
			StorageServer ss = storageServerDAO.selectByPrimaryKey(planId);
			vo.setPlanServerIp(ss.getIp());
			vo.setPlanServerPort("9001");
		}

		if (StringUtils.isNotBlank(alarmId)) {
			StorageServer ass = storageServerDAO.selectByPrimaryKey(alarmId);
			vo.setAlarmServerIp(ass.getIp());
			vo.setAlarmServerPort(ass.getMessagePort().toString());
		}

		return vo;
	}

	public void removeTempResources(String parentCode) {
		TempResourcesExample example = new TempResourcesExample();
		if (StringUtils.isNotBlank(parentCode)) {
			example.createCriteria().andParentCodeEqualTo(parentCode);
		}
		tempResourceDAO.deleteByExample(example);
	}

	public SipServer getSipServer() throws BusinessException {
		SipServerExample example = new SipServerExample();
		example.createCriteria().andRegisterTypeEqualTo(
				SIP_SERVER_REGISTER_TYPE_WAN);
		List<SipServer> list = sipServerDAO.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("no sipserver registered",
					ErrorCode.NO_SIP_SERVER_REGISTERED);
		}
		return list.get(0);
	}

	public void addThirdPartyResource(String code, String name, Short status,
			String decodeTag, String longitude, String latitude,
			Integer subNum, String parentCode, String sipServerIp)
			throws BusinessException {
		// 判断code对应的资源是否存在，如果存在只做修改
		TempResourcesExample example = new TempResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<TempResources> list = tempResourceDAO.selectByExample(example);
		if (list.size() > 0) {
			TempResources record = list.get(0);
			record.setDecoderTag(decodeTag);
			record.setLatitude(latitude);
			record.setLongitude(longitude);
			record.setName(name);
			record.setParentCode(parentCode);
			record.setStatus(status);
			record.setSubNum(subNum);
			String naming = record.getId() + ":" + record.getId() + ":"
					+ sipServerIp + ":010001";
			record.setNaming(naming);
			tempResourceDAO.updateByPrimaryKeySelective(record);
		} else {
			TempResources record = new TempResources();
			String id = sequenceDAO.getTempResourcesSeq();
			record.setId(id);
			record.setSipCode(code);
			record.setDeviceType(getDeviceTypeByCode(code));
			record.setDecoderTag(decodeTag);
			record.setLatitude(latitude);
			record.setLongitude(longitude);
			record.setName(name);
			record.setParentCode(parentCode);
			record.setStatus(status);
			record.setSubNum(subNum);
			String naming = id + ":" + id + ":" + sipServerIp + ":010001";
			record.setNaming(naming);
			tempResourceDAO.insert(record);
		}
	}

	public String getDeviceTypeByCode(String code) {
		// 形如180110000003100003
		if (StringUtils.isBlank(code) || code.length() != 18) {
			return "";
		}
		// 高2位类型
		String higherType = code.substring(10, 12);
		// 低2位类型
		String lowerType = code.substring(12, 14);

		// 由于只推送了设备和机构资源，所以只需要转换设备和机构的类型，以后加入了用户等资源在添加
		if (Configuration.getInstance().getPrefix("prefix_device")
				.equals(higherType)) {
			// 视频服务器
			if (Configuration.getInstance().getPrefix("prefix_dvr")
					.equals(lowerType)
					|| Configuration.getInstance().getPrefix("prefix_dvs")
							.equals(lowerType)) {
				return DeviceType.DEVICE_TYPE_VIS;
			}
			// 报警输入
			else if (Configuration.getInstance()
					.getPrefix("prefix_infrared_shoot").equals(lowerType)
					|| Configuration.getInstance()
							.getPrefix("prefix_infrared_identify")
							.equals(lowerType)
					|| Configuration.getInstance()
							.getPrefix("prefix_water_prober").equals(lowerType)
					|| Configuration.getInstance()
							.getPrefix("prefix_smoke_prober").equals(lowerType)
					|| Configuration.getInstance()
							.getPrefix("prefix_temperature_prober")
							.equals(lowerType)) {
				return DeviceType.DEVICE_TYPE_AIC;
			}
			// 其他的都认作是摄像头，有需要在细分
			else {
				return DeviceType.DEVICE_TYPE_VIC;
			}
		} else if (Configuration.getInstance()
				.getPrefix("prefix_station_system").equals(higherType)) {
			return DeviceType.DEVICE_TYPE_ORGAN;
		} else if (Configuration.getInstance().getPrefix("prefix_user")
				.equals(higherType)) {
			return "";
		}
		// 没有解析出来当做机构
		else {
			return DeviceType.DEVICE_TYPE_ORGAN;
		}
	}

	public String getVisPassword(String code) throws BusinessException {
		VideoInputServer vis = videoInputServerDAO.getByDeviceNumber(code);
		if (null == vis) {
			throw new BusinessException("deviceNumber: " + code
					+ " not found !", ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
		return vis.getPassword();
	}

	public String visRegister(String code, String password, String algorithm,
			String sipServerIp, String deviceIp, Integer sipPort)
			throws BusinessException {
		// 修改成code跟vis的device_number对应
		VideoInputServer vis = videoInputServerDAO.getByDeviceNumber(code);
		if (null == vis) {
			throw new BusinessException("deviceNumber: " + code
					+ " not found !", ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}

		// 如果password不为空，验证密码，否则放过
		if (StringUtils.isNotBlank(password)) {
			// 注册成功
			if (password.equals(vis.getPassword())) {

			} else {
				throw new BusinessException("deviceNumber: " + code
						+ " password: " + password + " authorise faild !",
						ErrorCode.AUTHORISE_FAILD);
			}
		}

		vis.setIp(deviceIp);
		vis.setNaming(vis.getId() + ":" + sipServerIp + ":010001");
		vis.setIsRegisterd(new BigDecimal(1));
		vis.setStartOnlineTime(new BigDecimal(System.currentTimeMillis()));
		vis.setSipPort(sipPort);
		videoInputServerDAO.updateByPrimaryKeySelective(vis);
		return vis.getId();
	}

	public VideoInputServer getVisByDeviceNumber(String deviceNumber)
			throws BusinessException {
		VideoInputServer vis = videoInputServerDAO
				.getByDeviceNumber(deviceNumber);
		if (null == vis) {
			throw new BusinessException("deviceNumber: " + deviceNumber
					+ " not found !", ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}
		return vis;
	}

	public void vicRegister(String code, String visId, String status,
			String longitude, String latitude, String visNaming)
			throws BusinessException {
		if (StringUtils.isBlank(visNaming)) {
			throw new BusinessException("parent visId: " + visId
					+ " not registered", ErrorCode.DEVICE_NOT_REGISTERED);
		}

		PlatformResources p = getResourceByCode(code);

		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(p
				.getResourceId());
		// 验证是否是属于对应的视频服务器
		if (!vic.getVideoInputServerId().equals(visId)) {
			throw new BusinessException(code + " not belong to " + visId,
					ErrorCode.PARENT_WRONG);
		}

		// 验证通过，修改摄像头Naming
		vic.setNaming(vic.getId() + ":" + visNaming);
		VideoInputChannelDAO.updateByPrimaryKey(vic);

		// 修改platform_resources相应的经纬度和状态信息
		p.setStatus(new Short(status));
		p.setLatitude(latitude);
		p.setLongitude(longitude);
		p.setStandardType(DeviceType.STANDARD_TYPE_NATION_POWER);
		platformResourcesDAO.updateByPrimaryKeySelective(p);
	}

	public void aicRegister(String code, String visId, String status,
			String longitude, String latitude, String visNaming)
			throws BusinessException {
		if (StringUtils.isBlank(visNaming)) {
			throw new BusinessException("parent visId: " + visId
					+ " not registered", ErrorCode.DEVICE_NOT_REGISTERED);
		}

		PlatformResources p = getResourceByCode(code);

		AlarmInputChannel aic = alarmInputChannelDAO.selectByPrimaryKey(p
				.getResourceId());
		AlarmBox ab = alarmBoxDAO.selectByPrimaryKey(aic.getAlarmBoxId());
		// 验证是否是属于对应的视频服务器
		if (!ab.getVideoInputServerId().equals(visId)) {
			throw new BusinessException(code + " not belong to " + visId,
					ErrorCode.PARENT_WRONG);
		}

		// 验证通过，修改摄像头Naming
		aic.setNaming(aic.getId() + ":" + visNaming);
		alarmInputChannelDAO.updateByPrimaryKey(aic);

		// 修改platform_resources相应的经纬度和状态信息
		p.setStatus(new Short(status));
		p.setLatitude(latitude);
		p.setLongitude(longitude);
		p.setStandardType(DeviceType.STANDARD_TYPE_NATION_POWER);
		platformResourcesDAO.updateByPrimaryKeySelective(p);
	}

	public List<PlatformResources> listResources(String parentCode,
			String userCode, int start, int end) throws BusinessException {
		PlatformResourcesExample prExample = new PlatformResourcesExample();
		prExample.createCriteria().andSipCodeEqualTo(parentCode);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(prExample);
		if (list.size() > 0) {
			PlatformResources parent = list.get(0);
			// 如果是机构
			if (ORGAN.equals(parent.getType()))
				return platformResourcesDAO.listResources(
						parent.getResourceId(), userCode, start, end);
			// 如果是视频服务器
			if (VIS.equals(parent.getType())) {
				List<String> ids = platformResourcesDAO
						.listVisSharedChildrenId(parent.getResourceId());
				prExample = new PlatformResourcesExample();
				List<String> types = new ArrayList<String>();
				types.add(VIC); // 摄像头
				types.add(AIC); // 报警输入
				if (ids.size() > 0) {
					prExample.createCriteria().andResourceIdIn(ids)
							.andTypeIn(types);
					// .andTypeEqualTo(VIC);
					return platformResourcesDAO.selectByExample(prExample);
				}
			}
			// 如果是摄像头
			if (VIC.equals(parent.getType())) {
				throw new BusinessException("vic has no child",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			// 如果是报警输入
			if (AIC.equals(parent.getType())) {
				throw new BusinessException("aic has no child",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			// 如果是探测器
			if (PROBER.equals(parent.getType())) {
				throw new BusinessException("prober has no child",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
		} else {
			throw new BusinessException("code: " + parentCode + " not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		return new ArrayList<PlatformResources>();
	}

	public Integer countResources(String parentCode, String userCode) {
		PlatformResourcesExample prExample = new PlatformResourcesExample();
		prExample.createCriteria().andSipCodeEqualTo(parentCode);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(prExample);
		if (list.size() > 0) {
			PlatformResources parent = list.get(0);
			// 如果是机构
			if (ORGAN.equals(parent.getType()))
				return platformResourcesDAO.countResources(
						parent.getResourceId(), userCode);
			// 如果是视频服务器
			if (VIS.equals(parent.getType())) {
				List<String> ids = platformResourcesDAO
						.listVisSharedChildrenId(parent.getResourceId());
				prExample = new PlatformResourcesExample();
				List<String> types = new ArrayList<String>();
				types.add(VIC); // 摄像头
				types.add(AIC); // 报警输入
				if (ids.size() > 0) {
					prExample.createCriteria().andResourceIdIn(ids)
							.andTypeIn(types);
					return platformResourcesDAO.selectByExample(prExample)
							.size();
				}
			}
			// 如果是摄像头
			if (VIC.equals(parent.getType())) {
				return 0;
			}
			// 如果是报警输入
			if (AIC.equals(parent.getType())) {
				return 0;
			}
			// 如果是探测器
			if (PROBER.equals(parent.getType())) {
				return 0;
			}
		}
		return 0;
	}

	public List<String> listVisSharedChildIds(String visId) {
		return platformResourcesDAO.listVisSharedChildrenId(visId);
	}

	public PlatformResources getPlatformResourceByResourceId(String id) {
		PlatformResourcesExample example = new PlatformResourcesExample();
		example.createCriteria().andResourceIdEqualTo(id);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public boolean isThirdPartyResource(String code) {
		TempResourcesExample example = new TempResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<TempResources> list = tempResourceDAO.selectByExample(example);
		return list.size() > 0;
	}

	public String listVicHistoryVideo(String code, String type,
			String userCode, Long beginTime, Long endTime, int from, int to)
			throws BusinessException {
		// 摄像头ID
		String vicId = "";
		// 如果是本平台客户端查找本平台设备的录像
		if (code.length() > 20) {
			vicId = code;
		}
		// 否则是上级平台查找设备录像
		else {
			// 查询Code对应的资源
			PlatformResourcesExample pExample = new PlatformResourcesExample();
			pExample.createCriteria().andSipCodeEqualTo(code)
					.andTypeEqualTo("vic");
			List<PlatformResources> pList = platformResourcesDAO
					.selectByExample(pExample);
			if (pList.size() < 1) {
				throw new BusinessException("code: " + code + " not found !",
						ErrorCode.RESOURCE_NOT_FOUND);
			}
			PlatformResources resource = pList.get(0);
			vicId = resource.getResourceId();
		}
		VideoInputChannel vic = VideoInputChannelDAO.selectByPrimaryKey(vicId);
		List<HistoryVideo> list = new ArrayList<HistoryVideo>();

		// 判断是否老的全球眼设备
		if (false) {
			// TODO 不是的话抛出非全球眼设备异常
		}
		// 根据录像type，分别去计划存储和报警存储上获取历史列表
		else {
			// 考虑到多个存储结果集的分页难度，不做多计划和报警类型同时存在的查询操作，处理为去报警存储上查询
			List<String> types = int32TypeList(type);
			// if (types.size() >= 2 && types.contains(TYPE_PLAN_RECORD)) {
			// throw new IllegalArgumentException(
			// "Not support plan record and alarm record qurey together! type=["
			// + type + "]");
			// }

			// 如果是计划录像类型，去计划存储（中心存储）上获取列表
			if (types.size() == 1 && types.contains(TYPE_PLAN_RECORD)) {
				if (StringUtils.isBlank(vic.getRemoteStorageServerId())) {
					return null;
				}
				StorageServer ss = storageServerDAO.selectByPrimaryKey(vic
						.getRemoteStorageServerId());
				String ip = ss.getIp();
				int port = 9001;
				int number = 16100;

				// 请求xml内容
				Document reqDoc = new Document();
				Element root = new Element("Action");
				Element query = new Element("Query");

				Element variable = new Element("Variable");
				variable.setText("FileList");
				query.addContent(variable);

				Element indexType = new Element("IndexType");
				indexType.setText("0");
				query.addContent(indexType);

				Element address = new Element("Address");
				address.setText(vicId);
				query.addContent(address);

				Element alarmType = new Element("AlarmType");
				alarmType.setText("0xff");
				query.addContent(alarmType);

				Element begin = new Element("BeginTime");
				begin.setText(sdf.format(new Date(beginTime)));
				query.addContent(begin);

				Element end = new Element("EndTime");
				end.setText(sdf.format(new Date(endTime != null ? endTime
						: System.currentTimeMillis())));
				query.addContent(end);

				Element fromIndex = new Element("FromIndex");
				fromIndex.setText(from + "");
				query.addContent(fromIndex);

				Element toIndex = new Element("ToIndex");
				// 每次查询不得超过25条记录
				// if (to - from > 25) {
				// to = from + 25;
				// }
				toIndex.setText(to + "");
				query.addContent(toIndex);

				root.addContent(query);
				reqDoc.setRootElement(root);
				XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");

				// 向存储发送请求
				try {
					String content = out.outputString(reqDoc);
					MegaSocketClient client = new MegaSocketClient(number,
							null, vicId, content, ip, port);
					SocketChannel channel = client.sendWithResponse();
					int sequence = client.getSeq();
					byte[] resp = client.parseResponse(channel, sequence);
					if (null == resp || resp.length < 10) {
						return null;
					}

					InputStream in = new ByteArrayInputStream(resp);
					// 解析xml数据放到到返回列表中
					SAXBuilder builder = new SAXBuilder();
					Document respDoc = builder.build(in);
					Element response = respDoc.getRootElement();
					String decoderTag = response.getChildText("DecoderTag");
					int realNum = Integer.parseInt(response
							.getChildText("RealNum"));
					// FromIndex必定等于请求中的FromIndex，因此不需要解析
					// int fi = Integer.parseInt(response
					// .getChildText("FromIndex"));
					int ti = Integer.parseInt(response.getChildText("ToIndex"));

					Element sublist = response.getChild("Sublist");
					List<Element> itemList = sublist.getChildren("Item");
					for (Element e : itemList) {
						String fileName = e.getChildText("FileName");
						long videoBeginTime = sdf.parse(
								e.getChildText("BeginTime")).getTime();
						long videoEndTime = sdf
								.parse(e.getChildText("EndTime")).getTime();
						long fileSize = Long.parseLong(e
								.getChildText("FileSize"));
						String playUrl = e.getChildText("FileUrl");

						HistoryVideo record = new HistoryVideo();
						record.setBeginTime(videoBeginTime);
						record.setDecoderTag(decoderTag);
						record.setEndTime(videoEndTime);
						record.setFileName(fileName);
						record.setFileSize(fileSize);
						record.setPlayUrl(playUrl);
						record.setVicId(vicId);
						record.setType(TYPE_PLAN_RECORD);
						list.add(record);
					}

					// 生成返回xml
					Document xml = new Document();
					Element rootRtn = new Element("HTTP_XML");
					rootRtn.setAttribute("EventType", "Response_History_Video");
					xml.setRootElement(rootRtn);
					Element subListRtn = new Element("SubList");
					subListRtn.setAttribute("RealNum", realNum + "");
					subListRtn.setAttribute("SubNum", list.size() + "");
					subListRtn.setAttribute("FromIndex", from + "");
					subListRtn.setAttribute("ToIndex", ti + "");
					for (HistoryVideo video : list) {
						Element e = new Element("Item");
						e.setAttribute("FileName", video.getFileName());
						e.setAttribute("FileUrl", video.getPlayUrl());
						e.setAttribute("BeginTime",
								sdf1.format(new Date(video.getBeginTime())));
						e.setAttribute("EndTime",
								sdf1.format(new Date(video.getEndTime())));
						e.setAttribute("Size", video.getFileSize() + "");
						e.setAttribute("DecoderTag", video.getDecoderTag());
						e.setAttribute("Type", video.getType());
						subListRtn.addContent(e);
					}
					xml.getRootElement().addContent(subListRtn);

					XMLOutputter outRtn = new XMLOutputter("  ", true, "UTF-8");
					String body = outRtn.outputString(xml);
					return body;
				} catch (JDOMParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 其他的都是去报警存储上获取列表
			else {
				if (StringUtils.isBlank(vic.getAlarmStorageServerId())) {
					return null;
				}
				StorageServer ass = storageServerDAO.selectByPrimaryKey(vic
						.getAlarmStorageServerId());
				String ip = ass.getIp();
				int port = 5606;
				int number = 16100;

				// 请求xml内容
				Document reqDoc = new Document();
				Element root = new Element("Action");
				Element query = new Element("Query");

				Element variable = new Element("Variable");
				variable.setText("FileList");
				query.addContent(variable);

				Element indexType = new Element("IndexType");
				indexType.setText("0");
				query.addContent(indexType);

				Element address = new Element("Address");
				address.setText(vicId);
				query.addContent(address);

				Element alarmType = new Element("AlarmType");
				if (StringUtils.isNotBlank(type)
						&& type.equals(TYPE_ALL_RECORD)) {
					alarmType.setText("");
				} else {
					alarmType.setText(type);
				}
				query.addContent(alarmType);

				Element begin = new Element("BeginTime");
				begin.setText(sdf.format(new Date(beginTime)));
				query.addContent(begin);

				Element end = new Element("EndTime");
				end.setText(sdf.format(new Date(endTime != null ? endTime
						: System.currentTimeMillis())));
				query.addContent(end);

				Element fromIndex = new Element("FromIndex");
				fromIndex.setText(from + "");
				query.addContent(fromIndex);

				Element toIndex = new Element("ToIndex");
				// // 每次查询不得超过25条记录
				// if (to - from > 25) {
				// to = from + 25;
				// }
				toIndex.setText(to + "");
				query.addContent(toIndex);

				Element eventId = new Element("EventID");
				// 国标互连中都是按照摄像头查询，因此EventID始终为空
				eventId.setText("");
				query.addContent(eventId);

				root.addContent(query);
				reqDoc.setRootElement(root);
				XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");

				// 向存储发送请求
				try {
					String content = out.outputString(reqDoc);
					MegaSocketClient client = new MegaSocketClient(number,
							null, vicId, content, ip, port);
					SocketChannel channel = client.sendWithResponse();
					int sequence = client.getSeq();
					byte[] resp = client.parseResponse(channel, sequence);
					if (null == resp || resp.length < 10) {
						return null;
					}

					InputStream in = new ByteArrayInputStream(resp);
					// 解析xml数据放到到返回列表中
					SAXBuilder builder = new SAXBuilder();
					Document respDoc = builder.build(in);
					Element response = respDoc.getRootElement();
					String decoderTag = response.getChildText("DecoderTag");
					int realNum = Integer.parseInt(response
							.getChildText("RealNum"));
					// FromIndex必定等于请求中的FromIndex，因此不需要解析
					// int fi = Integer.parseInt(response
					// .getChildText("FromIndex"));
					int ti = Integer.parseInt(response.getChildText("ToIndex"));

					Element sublist = response.getChild("Sublist");
					List<Element> itemList = sublist.getChildren("Item");
					for (Element e : itemList) {
						String id = e.getChildText("Id");
						String fileName = e.getChildText("FileName");
						long videoBeginTime = sdf.parse(
								e.getChildText("BeginTime")).getTime();
						long videoEndTime = sdf
								.parse(e.getChildText("EndTime")).getTime();
						long fileSize = Long.parseLong(e
								.getChildText("FileSize"));
						String playUrl = e.getChildText("FileUrl");
						String recordType = e.getChildText("AlarmType");

						HistoryVideo record = new HistoryVideo();
						record.setVicId(id);
						record.setBeginTime(videoBeginTime);
						record.setDecoderTag(decoderTag);
						record.setEndTime(videoEndTime);
						record.setFileName(fileName);
						record.setFileSize(fileSize);
						record.setPlayUrl(playUrl);
						record.setType(recordType);
						list.add(record);
					}

					// 生成返回xml
					Document xml = new Document();
					Element rootRtn = new Element("HTTP_XML");
					rootRtn.setAttribute("EventType", "Response_History_Video");
					xml.setRootElement(rootRtn);
					Element subListRtn = new Element("SubList");
					subListRtn.setAttribute("RealNum", realNum + "");
					subListRtn.setAttribute("SubNum", list.size() + "");
					subListRtn.setAttribute("FromIndex", from + "");
					subListRtn.setAttribute("ToIndex", ti + "");
					for (HistoryVideo video : list) {
						Element e = new Element("Item");
						e.setAttribute("FileName", video.getFileName());
						e.setAttribute("FileUrl", video.getPlayUrl());
						e.setAttribute("BeginTime",
								sdf1.format(new Date(video.getBeginTime())));
						e.setAttribute("EndTime",
								sdf1.format(new Date(video.getEndTime())));
						e.setAttribute("Size", video.getFileSize() + "");
						e.setAttribute("DecoderTag", video.getDecoderTag());
						e.setAttribute("Type", video.getType());
						subListRtn.addContent(e);
					}
					xml.getRootElement().addContent(subListRtn);

					XMLOutputter outRtn = new XMLOutputter("  ", true, "UTF-8");
					String body = outRtn.outputString(xml);
					return body;
				} catch (JDOMParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public ThirdPartyPlatform getThirdPartyPlatformByResourceCode(String code)
			throws BusinessException {
		List<String> parents = tempResourceDAO.listParentTree(code);
		if (parents.size() < 1) {
			throw new BusinessException("Resource parent not found, code=["
					+ code + "]", ErrorCode.RESOURCE_NOT_FOUND);
		}
		String platformCode = parents.get(parents.size() - 1);

		ThirdPartyPlatformExample example = new ThirdPartyPlatformExample();
		example.createCriteria().andSipCodeEqualTo(platformCode);
		List<ThirdPartyPlatform> list = thirdPartyPlatformDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException(
					"Third party platform not found, code=[" + platformCode
							+ "]", ErrorCode.RESOURCE_NOT_FOUND);
		}

		return list.get(0);
	}

	public String getParentCode(String code) throws BusinessException {
		// 首先在本平台资源查询
		PlatformResourcesExample example = new PlatformResourcesExample();
		example.createCriteria().andSipCodeEqualTo(code);
		List<PlatformResources> list = platformResourcesDAO
				.selectByExample(example);
		if (list.size() > 0) {
			PlatformResources resource = list.get(0);
			if (resource.getType().equals(ORGAN)) {
				String parentId = resource.getOrganId();
				if (StringUtils.isNotBlank(parentId)) {
					return platformResourcesDAO
							.getByResourceId(parentId, ORGAN).getSipCode();
				}
			} else if (resource.getType().equals(VIS)) {
				String parentId = resource.getOrganId();
				if (StringUtils.isNotBlank(parentId)) {
					return platformResourcesDAO.getByResourceId(parentId, VIS)
							.getSipCode();
				}
			} else if (resource.getType().equals(VIC)) {
				VideoInputChannel vic = VideoInputChannelDAO
						.selectByPrimaryKey(resource.getResourceId());
				return platformResourcesDAO.getByResourceId(
						vic.getVideoInputServerId(), VIS).getSipCode();

			} else if (resource.getType().equals(AIC)) {
				AlarmInputChannel aic = alarmInputChannelDAO
						.selectByPrimaryKey(resource.getResourceId());
				AlarmBox ab = alarmBoxDAO.selectByPrimaryKey(aic
						.getAlarmBoxId());
				return platformResourcesDAO.getByResourceId(
						ab.getVideoInputServerId(), VIS).getSipCode();

			} else if (resource.getType().equals(USER)) {
				return platformResourcesDAO.getByResourceId(
						resource.getOrganId(), ORGAN).getSipCode();
			}
		}
		// 去外平台查找
		else {
			TempResourcesExample tExample = new TempResourcesExample();
			tExample.createCriteria().andSipCodeEqualTo(code);
			List<TempResources> trList = tempResourceDAO
					.selectByExample(tExample);
			if (trList.size() > 0) {
				return trList.get(0).getParentCode();
			}
		}
		return "";
	}

	public void keepAlive(String sipCode, Long heartbeatTime)
			throws BusinessException {
		ThirdPartyPlatformExample example = new ThirdPartyPlatformExample();
		example.createCriteria().andSipCodeEqualTo(sipCode);
		List<ThirdPartyPlatform> list = thirdPartyPlatformDAO
				.selectByExample(example);
		if (list.size() < 1) {
			throw new BusinessException("platform: " + sipCode
					+ " not registered!", ErrorCode.NO_PLATFORM_CODE);
		}

		ThirdPartyPlatform record = list.get(0);
		record.setHeartbeatTime(heartbeatTime);
		thirdPartyPlatformDAO.updateByPrimaryKeySelective(record);
	}

	public List<PlatformVO> listPlatform() throws BusinessException {
		List<String> upperPlatform = Configuration.getInstance()
				.getUpperPlatform();
		List<PlatformVO> platforms = new ArrayList<PlatformVO>();
		for (String p : upperPlatform) {
			PlatformVO platform = new PlatformVO();
			// 180110000000000000@http://192.168.50.130:8181
			String[] platformInfo = p.split("@");
			if (platformInfo.length != 2) {
				throw new BusinessException(
						"parse upper_platform.properties error",
						ErrorCode.CONFIG_FILE_PARSE_ERROR);
			}
			platform.setCode(platformInfo[0]);
			String[] address = platformInfo[1].split(":");
			if (address.length != 3) {
				throw new BusinessException(
						"parse upper_platform.properties error",
						ErrorCode.CONFIG_FILE_PARSE_ERROR);
			}
			// 去IP前的"\\"
			platform.setIp(address[1].substring(2));
			platform.setPort(address[2]);
			platforms.add(platform);
		}
		return platforms;
	}

	public List<TempResources> listThirdPartyResource(String parentCode,
			String platformCode) throws BusinessException {
		// 首先查询是否已经获取过数据
		TempResourcesExample oldExample = new TempResourcesExample();
		oldExample.createCriteria().andParentCodeEqualTo(parentCode);
		List<TempResources> dataList = tempResourceDAO
				.selectByExample(oldExample);
		// 如果已经有直接返回
		if (dataList.size() > 0) {
			return dataList;
		}
		// 没有执行获取资源请求
		// 获取请求url
		ThirdPartyPlatformExample pExample = new ThirdPartyPlatformExample();
		pExample.createCriteria().andSipCodeEqualTo(platformCode);
		List<ThirdPartyPlatform> platforms = thirdPartyPlatformDAO
				.selectByExample(pExample);
		if (platforms.size() < 1) {
			throw new BusinessException("platform[" + platformCode
					+ "] not found !", ErrorCode.RESOURCE_NOT_FOUND);
		}
		String url = platforms.get(0).getHttpUrl();
		if (!(url.endsWith("/") || url.endsWith("\\"))) {
			url += "/";
		}
		url = StringUtils.replace(url, "\\", "/");
		url += "Request_Resource";

		int from = 1;
		int to = 9999;

		// 获取注册上来的信令网关IP，用于生成设备Naming
		SipServerExample sipExample = new SipServerExample();
		sipExample.createCriteria().andRegisterTypeEqualTo(
				SIP_SERVER_REGISTER_TYPE_WAN);
		List<SipServer> sipServers = sipServerDAO.selectByExample(sipExample);
		if (sipServers.size() < 1) {
			return new ArrayList<TempResources>();
		}
		String sipServerIp = sipServers.get(0).getLanIp();

		while (true) {
			// 生成请求xml
			Document doc = new Document();
			Element root = new Element("HTTP_XML");
			root.setAttribute("EventType", "Request_Resource");
			doc.setRootElement(root);
			Element item = new Element("Item");
			item.setAttribute("Code", parentCode);
			item.setAttribute("UserCode", "");
			item.setAttribute("FromIndex", from + "");
			item.setAttribute("ToIndex", to + "");
			root.addContent(item);
			XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
			String body = out.outputString(doc);

			// 使用HttpClient请求第三方平台资源获取接口
			byte[] buffer = requestResource(url, body);
			InputStream in = new ByteArrayInputStream(buffer);
			// 解析xml数据存到temp_resources表里面去
			SAXBuilder builder = new SAXBuilder();
			try {
				Document document = builder.build(in);
				Element rootElement = document.getRootElement();
				Element list = rootElement.getChild("SubList");
				int total = Integer.parseInt(list.getAttributeValue("RealNum"));
				int size = Integer.parseInt(list.getAttributeValue("SubNum"));
				int fromIndex = Integer.parseInt(list
						.getAttributeValue("FromIndex"));
				int toIndex = Integer.parseInt(list
						.getAttributeValue("ToIndex"));

				// 每个item就是一个资源，对应temp_resources表中一条记录
				List<Element> items = list.getChildren();
				// 生成naming后缀，为每个外平台资源生成Naming，方便接入路由
				String namingSuffix = ":" + sipServerIp + ":" + "010001";
				for (Element e : items) {
					TempResources record = new TempResources();
					String id = sequenceDAO.getTempResourcesSeq();
					record.setId(id);
					record.setDecoderTag(e.getAttributeValue("DecoderTag"));
					record.setLatitude(e.getAttributeValue("Latitude"));
					record.setLongitude(e.getAttributeValue("Longitude"));
					record.setName(e.getAttributeValue("Name"));
					record.setParentCode(parentCode);
					String code = e.getAttributeValue("Code");
					record.setSipCode(code);
					String deviceType = getDeviceTypeByCode(code);
					// 视频服务器当作机构
					if (deviceType.equals(DeviceType.DEVICE_TYPE_VIS)) {
						deviceType = DeviceType.DEVICE_TYPE_ORGAN;
					}
					record.setDeviceType(deviceType);
					record.setStatus(new Short(e.getAttributeValue("Status")));
					record.setSubNum(Integer.parseInt(e
							.getAttributeValue("SubNum")));
					// 生成naming方便接入路由
					record.setNaming(id + ":" + id + namingSuffix);
					tempResourceDAO.insert(record);
				}
				// 结束行大于总的记录数，已经查询完所有资源
				if (toIndex >= total) {
					break;
				}
				// 还未查询完，修改from和to继续查询
				else {
					from = toIndex + 1;
					to = total - toIndex;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException(e.getMessage(), ErrorCode.ERROR);
			}
		}

		// 从temp_resources里面查询出parent_code为parentCode的数据
		TempResourcesExample tExample = new TempResourcesExample();
		tExample.createCriteria().andParentCodeEqualTo(parentCode);
		return tempResourceDAO.selectByExample(tExample);
	}

	/**
	 * 32位int，转对应位存在（1）的int数组， 比如：0x00000006， 结果为["2","4"]。 0x00000009，
	 * 结果为["1","8"].
	 * 
	 * @param type
	 * @return
	 * @throws NumberFormatException
	 */
	public static List<String> int32TypeList(String type)
			throws NumberFormatException {
		long l = Long.parseLong(type);
		List<String> list = new LinkedList<String>();
		if (l < 0) {
			list.add(TYPE_ALL_RECORD);
			return list;
		}
		for (int i = 0; i < 32; i++) {
			long test = l & (long) Math.pow(2, i);
			if (test > 0) {
				list.add((long) Math.pow(2, i) + "");
			}
		}
		return list;
	}

	/**
	 * 使用HttpClient请求第三方平台资源获取接口
	 * 
	 * @param url
	 *            请求url
	 * @param xml
	 *            请求内容
	 * @return 返回xml
	 * @throws Exception
	 */
	public static byte[] requestResource(String url, String xml) {
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF8");
		PostMethod method = new PostMethod(url);

		byte[] rtn = null;
		try {
			method.setRequestHeader("Content-Type", "application/xml");
			method.setRequestHeader("Content-Length", xml.length() + "");
			method.setRequestEntity(new StringRequestEntity(xml));

			// method.setRequestBody(xml);
			client.executeMethod(method);
			rtn = method.getResponseBody();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return rtn;
	}
}
