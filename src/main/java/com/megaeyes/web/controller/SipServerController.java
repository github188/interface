package com.megaeyes.web.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.InputSource;

import com.megaeyes.persistence.ibatis.model.EpEventServer;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.RtpPayload;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;
import com.megaeyes.persistence.ibatis.model.UserSubscribe;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.PlatformVO;
import com.megaeyes.persistence.ibatis.vo.VicStorageServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.iface.EpEventServerManager;
import com.megaeyes.service.iface.InterConnectManager;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.service.utils.DeviceType;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListSipServerResponse;
import com.megaeyes.web.response.SipServerResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;
import com.megaeyes.web.response.xml.LowerPlatformUpdateStatusResponse;
import com.megaeyes.web.response.xml.SipServerHeartbeatResponse;
import com.megaeyes.web.response.xml.SipServerRegisterResponse;

/**
 * SipServerController(类说明)
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-2 上午11:18:16
 */
@Controller
public class SipServerController extends BaseController {
	@Autowired
	InterConnectManager interConnectManager;
	@Autowired
	UserManager userManager;
	@Autowired
	EpEventServerManager epEventServerManager;
	@Autowired
	CenterDeviceManager centerDeviceManager;

	public final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@ControllerDescription(description = "信令网关注册", isLog = false, isCheckSession = false)
	@RequestMapping("/sipRegister.xml")
	public void sipRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In sipRegister.xml interface...");
		request.setCharacterEncoding("UTF-8");

		SipServerRegisterResponse resp = new SipServerRegisterResponse();
		List<PlatformVO> platforms = new ArrayList<PlatformVO>();

		String lanIp = (String) request.getAttribute("lanIp");
		if (StringUtils.isBlank(lanIp)) {
			resp.setSuccess(SipServerRegisterResponse.FAIL);
			resp.setReason("missing parameter [lanIp] !");
		}

		String wanIp = (String) request.getAttribute("wanIp");

		int httpPort = 6002;
		String httpPortString = (String) request.getAttribute("httpPort");
		if (StringUtils.isNotBlank(httpPortString)) {
			try {
				httpPort = Integer.parseInt(httpPortString);
			} catch (NumberFormatException e) {
				resp.setSuccess(SipServerRegisterResponse.FAIL);
				resp.setReason("parameter [httpPort=" + httpPortString
						+ "] invalid !");
			}
		}

		int sipPort = 5060;
		String sipPortString = (String) request.getAttribute("sipPort");
		if (StringUtils.isNotBlank(sipPortString)) {
			try {
				sipPort = Integer.parseInt(sipPortString);
			} catch (NumberFormatException e) {
				resp.setSuccess(SipServerRegisterResponse.FAIL);
				resp.setReason("parameter [sipPort=" + sipPortString
						+ "] invalid !");
			}
		}

		int megaPort = 6001;
		String megaPortString = (String) request.getAttribute("megaPort");
		if (StringUtils.isNotBlank(megaPortString)) {
			try {
				megaPort = Integer.parseInt(megaPortString);
			} catch (NumberFormatException e) {
				resp.setSuccess(SipServerRegisterResponse.FAIL);
				resp.setReason("parameter [megaPort=" + megaPortString
						+ "] invalid !");
			}
		}

		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(SipServerRegisterResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}

		String registerType = (String) request.getAttribute("registerType");
		if (StringUtils.isBlank(registerType)) {
			registerType = "0";
		}

		if (resp.getSuccess().equals(SipServerRegisterResponse.SUCCESS)) {
			try {
				// 注册
				SipServer record = interConnectManager.sipServerRegister(lanIp,
						wanIp, httpPort, sipPort, megaPort, deviceNumber,
						registerType);
				String code = interConnectManager.getPlatformSipCode();
				resp.setCode(code);
				// 获取事件服务器地址信息
				String eventServerId = record.getEventServerId();
				if (StringUtils.isNotBlank(eventServerId)) {
					EpEventServer event = epEventServerManager
							.getByEpEventServerId(eventServerId);
					resp.setEventIp(event.getIp1());
					resp.setEventPort(event.getPort().toString());
				} else {
					throw new BusinessException("event server not created !",
							ErrorCode.RESOURCE_NOT_FOUND);
				}
				// 获取媒体网关地址信息
				String mediaServerId = record.getMediaGatewayServerId();
				if (StringUtils.isNotBlank(mediaServerId)) {
					MediaGatewayServer media = centerDeviceManager
							.getMediaGatewayServerById(mediaServerId);
					resp.setMediaIp(media.getLanIp());
					resp.setMediaPort(media.getMsgPort().toString());
				} else {
					throw new BusinessException("media server not created !",
							ErrorCode.RESOURCE_NOT_FOUND);
				}
				// 如果是信令A的注册，获取上级平台信息，获取上级平台配置信息
				if (record.getRegisterType().equals(
						InterConnectManager.SIP_SERVER_REGISTER_TYPE_WAN)) {
					platforms = interConnectManager.listPlatform();
				}
			} catch (BusinessException e) {
				resp.setSuccess(SipServerRegisterResponse.FAIL);
				resp.setReason(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(SipServerRegisterResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}
		Element code = new Element("Code");
		code.setText(resp.getCode());
		root.addContent(code);

		Element eventServerElement = new Element("EventServer");
		eventServerElement.setAttribute("Ip",
				resp.getEventIp() != null ? resp.getEventIp() : "");
		eventServerElement.setAttribute("Port",
				resp.getEventPort() != null ? resp.getEventPort() : "");
		root.addContent(eventServerElement);

		Element mediaServerElement = new Element("MediaServer");
		mediaServerElement.setAttribute("Ip",
				resp.getMediaIp() != null ? resp.getMediaIp() : "");
		mediaServerElement.setAttribute("Port",
				resp.getMediaPort() != null ? resp.getMediaPort() : "");
		root.addContent(mediaServerElement);

		Element platformsElement = new Element("Platforms");
		for (PlatformVO p : platforms) {
			Element platformElement = new Element("Platform");
			platformElement.setAttribute("Ip", p.getIp() != null ? p.getIp()
					: "");
			platformElement.setAttribute("Port",
					p.getPort() != null ? p.getPort() : "");
			platformElement.setAttribute("Code",
					p.getCode() != null ? p.getCode() : "");
			platformsElement.addContent(platformElement);
		}
		root.addContent(platformsElement);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "信令网关心跳", isLog = false, isCheckSession = false)
	@RequestMapping("/sipServerHeartBeat.xml")
	public void sipServerHeartBeat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In sipServerHeartBeat.xml interface...");
		request.setCharacterEncoding("UTF-8");

		SipServerHeartbeatResponse resp = new SipServerHeartbeatResponse();

		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(SipServerHeartbeatResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}

		if (resp.getSuccess().equals(SipServerHeartbeatResponse.SUCCESS)) {
			try {
				// 接收心跳
				int result = interConnectManager
						.sipServerHeartbeat(deviceNumber);
				if (result <= 0) {
					resp.setSuccess(SipServerHeartbeatResponse.FAIL);
					resp.setReason("deviceNumber[" + deviceNumber
							+ "] sip server not found !");
				}

				// 获取下级平台
				List<ThirdPartyPlatform> platformList = interConnectManager
						.listThirdPartyPlatform();
				resp.setPlatformList(platformList);
			} catch (BusinessException e) {
				resp.setSuccess(SipServerHeartbeatResponse.FAIL);
				resp.setReason(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(SipServerHeartbeatResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		// 下级平台
		Element platformList = new Element("PlatformList");
		List<Element> pList = new ArrayList<Element>();
		for (ThirdPartyPlatform p : resp.getPlatformList()) {
			Element platform = new Element("Platform");
			// platform.setAttribute("Code", p.getSipCode());
			platform.setAttribute("SipUri",
					p.getSipUrl() == null ? "" : p.getSipUrl());
			platform.setAttribute("Status", p.getStatus().toString());
			pList.add(platform);
		}
		platformList.setChildren(pList);
		root.addContent(platformList);

		writePageWithContentLength(response, doc);

	}

	@ControllerDescription(description = "用户报警订阅", isLog = false, isCheckSession = false)
	@RequestMapping("/userSubscribe.xml")
	public void userSubscribe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In userSubscribe.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		// 取参数
		String user = (String) request.getAttribute("user");
		if (StringUtils.isBlank(user)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [user] !");
		}

		String deviceId = (String) request.getAttribute("deviceId");
		if (StringUtils.isBlank(deviceId)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceId] !");
		}

		String s_updateTime = (String) request.getAttribute("updateTime");
		Long updateTime = null;
		if (StringUtils.isNotBlank(s_updateTime)) {
			try {
				updateTime = sdf.parse(s_updateTime).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [updateTime] invalid !");
			}
		}

		String event = (String) request.getAttribute("event");

		String type = (String) request.getAttribute("type");

		String platformCode = (String) request.getAttribute("platformCode");

		String userCode = "";
		String code = "";
		String platform = "";
		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				// 根据sessionId，获得userId
				String userId = userManager.getSessionById(user).getUserId();

				code = interConnectManager.namingToCode(deviceId);

				interConnectManager.userSubscribe(userId, platformCode, code,
						updateTime, event, type);

				userCode = interConnectManager.namingToCode(userId);
				platform = interConnectManager.codeToSipUrl(code);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element ue = new Element("User");
		ue.setText(userCode);
		root.addContent(ue);

		Element item = new Element("Item");
		item.setAttribute("Code", code);
		item.setAttribute("Platform", platform);
		root.addContent(item);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "平台报警订阅", isLog = false, isCheckSession = false)
	@RequestMapping("/platformSubscribe.xml")
	public void platformSubscribe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In platformSubscribe.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		List<String[]> codes = new ArrayList<String[]>();

		// 取参数
		String platformCode = (String) request.getAttribute("platformCode");
		if (StringUtils.isBlank(platformCode)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [platformCode] !");
		}

		String s_updateTime = (String) request.getAttribute("updateTime");
		Long updateTime = null;
		if (StringUtils.isNotBlank(s_updateTime)) {
			try {
				updateTime = sdf.parse(s_updateTime).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [updateTime=" + s_updateTime
						+ "] invalid !");
			}
		}

		String event = (String) request.getAttribute("event");

		String xml = (String) request.getAttribute("xml");

		// 解析xml
		SAXBuilder builder = new SAXBuilder();
		try {
			StringReader reader = new StringReader(xml);
			Document doc = builder.build(new InputSource(reader));
			Element root = doc.getRootElement();
			List<Element> items = root.getChildren("Item");
			for (Element item : items) {
				String itemCode = item.getAttributeValue("Code");
				String type = item.getAttributeValue("Type");
				codes.add(new String[] { itemCode, type });
			}
		} catch (Exception e) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			e.printStackTrace();
			resp.setReason(e.getMessage());
		}

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				for (String[] pair : codes) {
					interConnectManager.platformSubscribe(platformCode,
							pair[0], updateTime, event, pair[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "取消用户报警订阅", isLog = false, isCheckSession = false)
	@RequestMapping("/cancelUserSubscribe.xml")
	public void cancelUserSubscribe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In cancelUserSubscribe.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		// 取参数
		String userId = (String) request.getAttribute("userId");
		if (StringUtils.isBlank(userId)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [userId] !");
		}

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		String event = (String) request.getAttribute("event");

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				interConnectManager.cancelUserSubscribe(userId, code, event);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "取消平台报警订阅", isLog = false, isCheckSession = false)
	@RequestMapping("/cancelPlatformSubscribe.xml")
	public void cancelPlatformSubscribe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In cancelPlatformSubscribe.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		List<String[]> codes = new ArrayList<String[]>();

		// 取参数
		String platformCode = (String) request.getAttribute("platformCode");
		if (StringUtils.isBlank(platformCode)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [platformCode] !");
		}

		String event = (String) request.getAttribute("event");

		String xml = (String) request.getAttribute("xml");
		if (StringUtils.isBlank(xml)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [xml] !");
		} else {
			// 解析xml
			SAXBuilder builder = new SAXBuilder();
			try {
				StringReader reader = new StringReader(xml);
				Document doc = builder.build(new InputSource(reader));
				Element root = doc.getRootElement();
				List<Element> items = root.getChildren("Item");
				for (Element item : items) {
					String itemCode = item.getAttributeValue("Code");
					String type = item.getAttributeValue("Type");
					codes.add(new String[] { itemCode, type });
				}
			} catch (Exception e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				e.printStackTrace();
				resp.setReason(e.getMessage());
			}
		}

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				for (String[] pair : codes) {
					interConnectManager.cancelPlatformSubscribe(platformCode,
							pair[0], pair[1], event);
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取视频编码信息", isLog = false, isCheckSession = false)
	@RequestMapping("/getRtpPayload.xml")
	public void getRtpPayload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In getRtpPayload.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		RtpPayload rtpPayload = null;

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				rtpPayload = interConnectManager.getRtpPayload(code);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		if (null != rtpPayload) {
			Element video = new Element("Video");
			video.setAttribute("Payload", rtpPayload.getPayload());
			video.setAttribute(
					"Decode",
					rtpPayload.getEncodeName() == null ? "" : rtpPayload
							.getEncodeName());
			video.setAttribute(
					"RtpRate",
					rtpPayload.getFrequency() == null ? "" : rtpPayload
							.getFrequency() + "");
			video.setAttribute(
					"FmtpPublic",
					rtpPayload.getFmtpPublic() == null ? "" : rtpPayload
							.getFmtpPublic());
			video.setAttribute(
					"FmtpPrivate",
					rtpPayload.getFmtpPrivate() == null ? "" : rtpPayload
							.getFmtpPrivate());
			root.addContent(video);

			Element base64 = new Element("Base64");
			base64.addContent(rtpPayload.getBase64() == null ? "" : rtpPayload
					.getBase64());
			root.addContent(base64);
		} else {
			Element video = new Element("Video");
			video.setAttribute("Payload", "");
			video.setAttribute("Decode", "");
			video.setAttribute("RtpRate", "");
			video.setAttribute("FmtpPublic", "");
			video.setAttribute("FmtpPrivate", "");
			root.addContent(video);

			Element base64 = new Element("Base64");
			base64.addContent("");
			root.addContent(base64);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取要通知的平台列表", isLog = false, isCheckSession = false)
	@RequestMapping("/listNotifyPlatform.xml")
	public void listNotifyPlatform(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In listNotifyPlatform.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		// 取参数
		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		String event = (String) request.getAttribute("event");
		if (StringUtils.isBlank(event)) {
			event = "alarm";
		}

		Set<String> notifyList = new HashSet<String>();

		try {
			notifyList = interConnectManager.listNotifyPlatform(code, event);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason(e.getMessage());
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element notifyPlatforms = new Element("NotifyPlatforms");
		List<Element> list = new ArrayList<Element>();
		Iterator<String> it = notifyList.iterator();
		while (it.hasNext()) {
			Element platform = new Element("Platform");
			platform.setAttribute("Code", it.next());
			list.add(platform);
		}
		notifyPlatforms.setChildren(list);
		root.addContent(notifyPlatforms);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "地址编码转名称", isLog = false, isCheckSession = false)
	@RequestMapping("/codeToName.xml")
	public void codeToName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In codeToName.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		String name = "";

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				name = interConnectManager.codeToName(code);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element e = new Element("Name");
		e.setText(name);
		root.addContent(e);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "地址编码转Naming", isLog = false, isCheckSession = false)
	@RequestMapping("/codeToNaming.xml")
	public void codeToNaming(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In codeToNaming.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String code = (String) request.getAttribute("code");

		String user = (String) request.getAttribute("user");

		String type = "";
		String naming = "";
		String sessionId = "";
		try {
			// 判断设备是全球眼设备还是接口B设备还是南方电网设备
			// 全球眼设备转成Naming，接口B设备转成sipUri，南方电网设备转成sipUri
			PlatformResources p = interConnectManager.getResourceByCode(code);
			type = p.getStandardType();
			// 全球眼设备
			if (DeviceType.STANDARD_TYPE_MEGA.equals(type)) {
				naming = p.getNaming();
			}
			// 国网标准接口B设备
			else if (DeviceType.STANDARD_TYPE_NATION_POWER.equals(type)) {
				naming = p.getNaming();
			}
			// 南方电网标准设备
			else if (DeviceType.STANDARD_TYPE_SOUTH_POWER.equals(type)) {
				naming = p.getNaming();
			}

			// 目前没有权限，不处理user=上级平台Code的情况
			// 当sessionId为真时，接入控制了权限，因此给个假的，让接入放过权限
			// sessionId = interConnectManager.getSessionIdByUserCode(user);
		} catch (BusinessException e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.EXCEPTION);
			resp.setReason(e.getMessage());
		}

		// 外部进来的用户，目前没有sessionId，暂时给个假的
		if (StringUtils.isNotBlank(user) && StringUtils.isBlank(sessionId)) {
			sessionId = "c4ca4238a0b923820dcc509a6f75849";
			// resp.setSuccess(BaseXMLResponse.SUCCESS);
		}
		// --------

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element ue = new Element("User");
		ue.setText(sessionId);
		root.addContent(ue);

		Element item = new Element("Item");
		item.setAttribute("Type", type);
		item.setText(naming);
		root.addContent(item);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "ID转地址编码", isLog = false, isCheckSession = false)
	@RequestMapping("/idToCode.xml")
	public void idToCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In idToCode.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String user = (String) request.getAttribute("user");

		String deviceId = (String) request.getAttribute("deviceId");

		String userCode = "";
		String code = "";
		String platfrom = "";

		try {
			userCode = interConnectManager.getUserCodeBySessionId(user);

			code = interConnectManager.namingToCode(deviceId);

			platfrom = interConnectManager.codeToSipUrl(code);
		} catch (BusinessException e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.EXCEPTION);
			resp.setReason(e.getMessage());
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element ue = new Element("User");
		ue.setText(userCode);
		root.addContent(ue);

		Element e = new Element("Item");
		e.setAttribute("Code", code);
		e.setAttribute("Platform", platfrom);
		root.addContent(e);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "下级平台上下线", isLog = false, isCheckSession = false)
	@RequestMapping("/lowerPlatformUpdateStatus.xml")
	public void lowerPlatformUpdateStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In lowerPlatformUpdateStatus.xml interface...");
		request.setCharacterEncoding("UTF-8");
		LowerPlatformUpdateStatusResponse resp = new LowerPlatformUpdateStatusResponse();

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		String httpUrl = (String) request.getAttribute("httpUrl");

		String sipUrl = (String) request.getAttribute("sipUrl");

		Short shortStatus = new Short("1");
		String status = (String) request.getAttribute("status");
		if (StringUtils.isBlank(status)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [status] !");
		} else {
			try {
				shortStatus = new Short(status);
			} catch (NumberFormatException e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("Invalid parameter [status=" + status + "] !");
			}
		}

		if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				interConnectManager.platformUpdateStatus(code, shortStatus,
						httpUrl, sipUrl, code, System.currentTimeMillis());

				// 上线消息返回订阅此平台资源的关系
				if ("1".equals(status)) {
					List<UserSubscribe> list = interConnectManager
							.listUserSubscribeByPlatformCode(code);
					List<LowerPlatformUpdateStatusResponse.Item> userSubscribeList = new ArrayList<LowerPlatformUpdateStatusResponse.Item>();
					for (UserSubscribe us : list) {
						LowerPlatformUpdateStatusResponse.Item item = resp.new Item();
						item.setCode(us.getCode());
						item.setUserId(us.getUserId());
						item.setEvent(us.getEvent());
						item.setPlatformCode(us.getPlatformCode());
						item.setType(us.getType());
						item.setUpdateTime(us.getUpdateTime().toString());
						userSubscribeList.add(item);
					}
					resp.setUserSubscribeList(userSubscribeList);
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		// 上线消息返回订阅此平台资源的关系
		if ("1".equals(status)) {
			Element userSubscribeListElement = new Element("UserSubscribeList");
			for (LowerPlatformUpdateStatusResponse.Item i : resp
					.getUserSubscribeList()) {
				Element e = new Element("Item");
				e.setAttribute("UserId", i.getUserId());
				e.setAttribute("PlatformCode", i.getPlatformCode());
				e.setAttribute("Code", i.getCode());
				e.setAttribute("UpdateTime", i.getUpdateTime());
				e.setAttribute("Event", i.getEvent());
				e.setAttribute("Type", i.getType() != null ? i.getType() : "");
				userSubscribeListElement.addContent(e);
			}
			root.addContent(userSubscribeListElement);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取摄像头存储IP地址", isLog = false, isCheckSession = false)
	@RequestMapping("/getVicStorageServerAddress.xml")
	public void getVicStorageServerAddress(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In getVicStorageServerAddress.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		VicStorageServerVO vo = new VicStorageServerVO();

		String id = (String) request.getAttribute("id");
		if (StringUtils.isBlank(id)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [id] !");
		}

		if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				vo = interConnectManager.getVicStorageServer(id);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element planElement = new Element("Plan");
		planElement.setAttribute("Ip",
				vo.getPlanServerIp() != null ? vo.getPlanServerIp() : "");
		planElement.setAttribute("Port",
				vo.getPlanServerPort() != null ? vo.getPlanServerPort() : "");
		root.addContent(planElement);

		Element alarmElement = new Element("Alarm");
		alarmElement.setAttribute("Ip",
				vo.getAlarmServerIp() != null ? vo.getAlarmServerIp() : "");
		alarmElement.setAttribute("Port",
				vo.getAlarmServerPort() != null ? vo.getAlarmServerPort() : "");
		root.addContent(alarmElement);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "推送资源", isLog = false, isCheckSession = false)
	@RequestMapping("/pushThirdPartyResource.xml")
	public void pushThirdPartyResource(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In pushThirdPartyResource.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		ServletInputStream in = request.getInputStream();

		int length = request.getContentLength();
		if (length <= 0) {
			System.out.println("Content length is missing !");
			resp.setSuccess(BaseXMLResponse.FAIL);
		}
		ByteBuffer buffer = ByteBuffer.allocate(length);
		byte[] temp = new byte[1024];
		int count = 0;
		int index = 0;
		while ((count = in.read(temp)) >= 0) {
			buffer.put(temp, 0, count);
		}
		buffer.flip();
		byte[] data = buffer.array();

		SAXBuilder builder = new SAXBuilder();

		Document doc = null;
		// 尝试utf8和gbk两种编码方式解析xml
		try {
			InputStream stream = new ByteArrayInputStream(data);
			doc = builder.build(stream);
		} catch (Exception e) {
			try {
				System.out.println("utf8 parse error ! try to use gbk parse.");
				String xml = new String(data, "gbk");
				StringReader sr = new StringReader(xml);
				doc = builder.build(sr);
			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e1.getMessage());
			}
		}

		if (null != doc) {
			try {
				Element root = doc.getRootElement();
				String eventType = root.getAttributeValue("EventType");
				if (!"Push_Resourse".equals(eventType)) {
					resp.setSuccess(BaseXMLResponse.FAIL);
					resp.setReason("EventType is not suitable !");
				}

				String parentCode = root.getChild("Code").getText();
				// 移除已有的此父节点的数据
				interConnectManager.removeTempResources(parentCode);
				// 如果不采用重新创建资源的方式，可以考虑将此父节点下属资源全部状态设置为下线方式

				// 获取对外信令
				SipServer sipServer = interConnectManager.getSipServer();

				// 插入新的数据
				Element subList = root.getChild("SubList");
				List<Element> items = subList.getChildren("Item");
				for (Element e : items) {
					String childCode = e.getAttributeValue("Code");
					String childName = e.getAttributeValue("Name");
					String childStatus = e.getAttributeValue("Status");
					String childDecoderTag = e.getAttributeValue("DecoderTag");
					String childLongitude = e.getAttributeValue("Longitude");
					String childLatitude = e.getAttributeValue("Latitude");
					String childSubNum = e.getAttributeValue("SubNum");

					// 往temp_resources表中插入数据
					interConnectManager.addThirdPartyResource(childCode,
							childName, new Short(childStatus), childDecoderTag,
							childLongitude, childLatitude,
							Integer.parseInt(childSubNum), parentCode,
							sipServer.getLanIp());
				}
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		Document documnet = new Document();
		Element root = new Element("Message");
		documnet.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		writePageWithContentLength(response, documnet);
	}

	@ControllerDescription(description = "获取视频服务器密码", isLog = false, isCheckSession = false)
	@RequestMapping("/getVisPassword.xml")
	public void getVisPassword(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In getVisPassword.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		String password = "";

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [code] !");
		}

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				password = interConnectManager.getVisPassword(code);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element passwordElement = new Element("Password");
		passwordElement.setText(password);
		root.addContent(passwordElement);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "视频服务器注册", isLog = false, isCheckSession = false)
	@RequestMapping("/terminalRegister.xml")
	public void terminalRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In terminalRegister.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		String id = "";

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setSuccess(BaseXMLResponse.AUTH_FAIL);
			resp.setReason("missing parameter [code] !");
		}

		String password = (String) request.getAttribute("password");

		String algorithm = (String) request.getAttribute("algorithm");

		String sipServerIp = (String) request.getAttribute("sipServerIp");
		if (StringUtils.isBlank(sipServerIp)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [sipServerIp] !");
		}

		String deviceIp = (String) request.getAttribute("deviceIp");
		if (StringUtils.isBlank(deviceIp)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceIp] !");
		}

		Integer sipPort = new Integer(5060);
		String sipPortString = (String) request.getAttribute("sipPort");
		if (StringUtils.isBlank(sipPortString)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [sipPort] !");
		} else {
			try {
				sipPort = Integer.parseInt(sipPortString);
			} catch (NumberFormatException e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [sipPort=" + sipPortString
						+ "] invalid !");
			}
		}

		if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				id = interConnectManager.visRegister(code, password, algorithm,
						sipServerIp, deviceIp, sipPort);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.AUTH_FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element idElement = new Element("Id");
		idElement.setText(id);
		root.addContent(idElement);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "视频服务器资源推送", isLog = false, isCheckSession = false)
	@RequestMapping("/pushResource.xml")
	public void pushResource(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In pushResource.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		ServletInputStream in = request.getInputStream();

		int length = request.getContentLength();
		if (length <= 0) {
			System.out.println("Content length is missing !");
			resp.setSuccess(BaseXMLResponse.FAIL);
		}
		ByteBuffer buffer = ByteBuffer.allocate(length);
		byte[] temp = new byte[1024];
		int count = 0;
		int index = 0;
		while ((count = in.read(temp)) >= 0) {
			buffer.put(temp, 0, count);
		}
		buffer.flip();
		byte[] data = buffer.array();

		SAXBuilder builder = new SAXBuilder();

		Document doc = null;
		// 尝试utf8和gbk两种编码方式解析xml
		try {
			InputStream stream = new ByteArrayInputStream(data);
			doc = builder.build(stream);
		} catch (Exception e) {
			try {
				System.out.println("utf8 parse error ! try to use gbk parse.");
				String xml = new String(data, "gbk");
				StringReader sr = new StringReader(xml);
				InputSource is = new InputSource(sr);
				doc = builder.build(is);
			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e1.getMessage());
			}
		}

		if (null != doc) {
			try {
				Element root = doc.getRootElement();
				String eventType = root.getAttributeValue("EventType");
				if (!"Push_Resourse".equals(eventType)) {
					resp.setSuccess(BaseXMLResponse.FAIL);
					resp.setReason("EventType is not suitable !");
				}

				String parentCode = root.getChild("Code").getText();
				// 查询视频服务器是否存在
				VideoInputServer vis = interConnectManager
						.getVisByDeviceNumber(parentCode);

				Element subList = root.getChild("SubList");
				List<Element> items = subList.getChildren("Item");
				for (Element e : items) {
					String childCode = e.getAttributeValue("Code");
					String childName = e.getAttributeValue("Name");
					String childStatus = e.getAttributeValue("Status");
					String childDecoderTag = e.getAttributeValue("DecoderTag");
					String childLongitude = e.getAttributeValue("Longitude");
					String childLatitude = e.getAttributeValue("Latitude");
					String childSubNum = e.getAttributeValue("SubNum");

					String deviceType = interConnectManager
							.getDeviceTypeByCode(childCode);
					// 处理摄像头资源
					if (DeviceType.DEVICE_TYPE_VIC.equals(deviceType)) {
						interConnectManager.vicRegister(childCode, vis.getId(),
								childStatus, childLongitude, childLatitude,
								vis.getNaming());
					}
					// 处理报警输入资源
					else if (DeviceType.DEVICE_TYPE_AIC.equals(deviceType)) {
						interConnectManager.aicRegister(childCode, vis.getId(),
								childStatus, childLongitude, childLatitude,
								vis.getNaming());
					}
					// 处理报警输出资源
					else if (DeviceType.DEVICE_TYPE_AOC.equals(deviceType)) {

					}
					// 其他
					else {

					}
				}
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}

		Document documnet = new Document();
		Element root = new Element("Message");
		documnet.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		writePageWithContentLength(response, documnet);
	}

	/**
	 * 
	 * createSipServer 创建信令网关
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "创建信令网关", isLog = true, isCheckSession = true)
	@RequestMapping("/createSipServer.json")
	public void createSipServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String lanIp = (String) request.getAttribute("lanIp");
		Integer httpPort = null;
		String httpPort1 = (String) request.getAttribute("httpPort");
		if (StringUtils.isNotBlank(httpPort1)) {
			try {
				httpPort = Integer.parseInt(httpPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("httpPort");
			}
		}
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String registerType = (String) request.getAttribute("registerType");
		String wanIp = (String) request.getAttribute("wanIp");
		Integer sipPort = 5060;
		String sipPort1 = (String) request.getAttribute("sipPort");
		if (StringUtils.isNotBlank(sipPort1)) {
			try {
				sipPort = Integer.parseInt(sipPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("sipPort");
			}
		}
		Integer megaPort = 5060;
		String megaPort1 = (String) request.getAttribute("megaPort");
		if (StringUtils.isNotBlank(megaPort1)) {
			try {
				megaPort = Integer.parseInt(megaPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("megaPort");
			}
		}
		String eventServerId = (String) request.getAttribute("eventServerId");
		String mediaGatewayServerId = (String) request
				.getAttribute("mediaGatewayServerId");

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = centerDeviceManager.createSipServer(name, lanIp,
						httpPort, deviceNumber, registerType, wanIp, sipPort,
						megaPort, eventServerId, mediaGatewayServerId);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);

	}

	/**
	 * 
	 * deleteSipServer 删除信令网关
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "删除信令网关", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteSipServer.json")
	public void deleteSipServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			centerDeviceManager.deleteSipServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * updateSipServer 更新信令网关
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "更新信令网关", isLog = true, isCheckSession = true)
	@RequestMapping("/updateSipServer.json")
	public void updateSipServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String lanIp = (String) request.getAttribute("lanIp");
		Integer httpPort = null;
		String httpPort1 = (String) request.getAttribute("httpPort");
		if (StringUtils.isNotBlank(httpPort1)) {
			try {
				httpPort = Integer.parseInt(httpPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("httpPort");
			}
		}
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String registerType = (String) request.getAttribute("registerType");
		String wanIp = (String) request.getAttribute("wanIp");
		Integer sipPort = null;
		String sipPort1 = (String) request.getAttribute("sipPort");
		if (StringUtils.isNotBlank(sipPort1)) {
			try {
				sipPort = Integer.parseInt(sipPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("sipPort");
			}
		}
		Integer megaPort = null;
		String megaPort1 = (String) request.getAttribute("megaPort");
		if (StringUtils.isNotBlank(megaPort1)) {
			try {
				megaPort = Integer.parseInt(megaPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("megaPort");
			}
		}
		String eventServerId = (String) request.getAttribute("eventServerId");
		String mediaGatewayServerId = (String) request
				.getAttribute("mediaGatewayServerId");

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				centerDeviceManager.updateSipServer(id, name, lanIp, httpPort,
						deviceNumber, registerType, wanIp, sipPort, megaPort,
						eventServerId, mediaGatewayServerId);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * getSipServerById 根据ID查询信令网关
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据ID查询信令网关", isLog = true, isCheckSession = true)
	@RequestMapping("/getSipServerById.json")
	public void getSipServerById(HttpServletRequest request,
			HttpServletResponse response) {
		SipServerResponse resp = new SipServerResponse();
		String id = (String) request.getAttribute("id");
		try {
			SipServer sipServer = centerDeviceManager.getSipServerById(id);
			if (sipServer != null) {
				resp.setCode(ErrorCode.SUCCESS);
				resp.setId(sipServer.getId());
				resp.setName(sipServer.getName());
				resp.setLanIp(sipServer.getLanIp());
				resp.setHttpPort(sipServer.getHttpPort());
				resp.setHeartbeatTime(sipServer.getHeartbeatTime());
				resp.setDeviceNumber(sipServer.getDeviceNumber());
				resp.setRegisterType(sipServer.getRegisterType());
				resp.setWanIp(sipServer.getWanIp());
				resp.setSipPort(sipServer.getSipPort());
				resp.setMegaPort(sipServer.getMegaPort());
				resp.setEventServerId(sipServer.getEventServerId());
				resp.setMediaGatewayServerId(sipServer
						.getMediaGatewayServerId());
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * listSipServer 查询信令网关列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "查询信令网关列表", isLog = true, isCheckSession = true)
	@RequestMapping("/listSipServer.json")
	public void listSipServer(HttpServletRequest request,
			HttpServletResponse response) {
		ListSipServerResponse resp = new ListSipServerResponse();
		try {
			List<SipServer> sipServer = centerDeviceManager.listSipServer();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setSipServer(sipServer);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

}
