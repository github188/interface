package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.vo.ListControlAndVicVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AccessControllerManager;
import com.megaeyes.service.iface.EpClientGatewayManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AcAccessControlsResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcAccessControlsResponse;
import com.megaeyes.web.response.ListControlAndVicResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;
import com.megaeyes.web.response.xml.GetDoorNotifyUsersResponse;
import com.megaeyes.web.response.xml.ListOnlineUserResponse;

/**
 * 门禁相关接口
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 上午09:45:11
 */
@Controller
public class AcAccessControlController extends BaseController {
	@Autowired
	AccessControllerManager accessControllerManager;
	@Autowired
	EpClientGatewayManager epClientGatewayManager;

	@ControllerDescription(description = "查询门通知用户", isLog = false, isCheckSession = false)
	@RequestMapping("/getDoorNotifyUsers.xml")
	public void getDoorNotifyUsers(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In getDoorNotifyUsers.xml interface...");
		request.setCharacterEncoding("UTF-8");
		GetDoorNotifyUsersResponse resp = new GetDoorNotifyUsersResponse();
		List<String> namings = new ArrayList<String>();

		String id = request.getParameter("id");
		if (StringUtils.isBlank(id)) {
			resp.setSuccess(GetDoorNotifyUsersResponse.FAIL);
			System.out.println("missing parameter [id] !");
		}

		if (GetDoorNotifyUsersResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				List<UserSessionVO> list = accessControllerManager
						.listDoorNotifyUsers(id);
				// 获取要通知的users
				List<GetDoorNotifyUsersResponse.User> users = new ArrayList<GetDoorNotifyUsersResponse.User>();
			
				for (UserSessionVO vo : list) {
					GetDoorNotifyUsersResponse.User user = resp.new User();
					user.setSessionId(vo.getId());
					user.setNaming(vo.getNaming());
					users.add(user);
				}
				resp.setUsers(users);
				List<EpClientGateway> listecg = epClientGatewayManager
						.listEpClientGateway();
				
				for (EpClientGateway ecg : listecg) {
					System.out.println("-----1--------------------"+ecg.getIp1());
					if (!StringUtils.isBlank(ecg.getNaming())) {
					
						resp.setClientGatewayIp(ecg.getIp1());
						resp.setClientGatewayPort(ecg.getPort().toString());
						break;
					}
				}
				// 获取关联的摄像头
	
				namings = accessControllerManager.listDoorBindVics(id);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(GetDoorNotifyUsersResponse.EXCEPTION);
			}

		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		Element usersElement = new Element("Users");

		for (GetDoorNotifyUsersResponse.User u : resp.getUsers()) {
			Element userElement = new Element("User");
			userElement.setAttribute("SessionId", u.getSessionId());
			userElement.setAttribute("Naming", u.getNaming());
			userElement.setAttribute("ClientGatewayIp",
					resp.getClientGatewayIp());
			userElement.setAttribute("ClientGatewayPort",
					resp.getClientGatewayPort());
			usersElement.addContent(userElement);
		}

	
		root.addContent(usersElement);

		Element actionElement = new Element("Action");
		for (String naming : namings) {
			Element deviceElement = new Element("Device");
			deviceElement.setAttribute("Naming", naming);
			deviceElement.setAttribute("Type", "VIC");
			actionElement.addContent(deviceElement);
		}
		root.addContent(actionElement);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "创建门事件日志", isLog = false, isCheckSession = false)
	@RequestMapping("/doorEventLog.xml")
	public void createDoorEventLog(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In doorEventLog.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String eventNaming = request.getParameter("eventNaming");
		if (StringUtils.isBlank(eventNaming)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			System.out.println("missing parameter [eventNaming] !");
		}

		String triggerId = request.getParameter("triggerId");
		if (StringUtils.isBlank(triggerId)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			System.out.println("missing parameter [triggerId] !");
		}

		String triggerType = request.getParameter("triggerType");
		if (StringUtils.isBlank(triggerType)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			System.out.println("missing parameter [triggerType] !");
		}

		String deviceId = request.getParameter("deviceId");
		if (StringUtils.isBlank(deviceId)
				&& resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			deviceId = eventNaming.split("_")[2];
		}

		String deviceType = request.getParameter("deviceType");
		if (StringUtils.isBlank(deviceType)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			System.out.println("missing parameter [deviceType] !");
		}

		String logType = request.getParameter("logType");
		if (StringUtils.isBlank(logType)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			System.out.println("missing parameter [logType] !");
		}

		BigDecimal time = new BigDecimal(System.currentTimeMillis());
		String timeString = request.getParameter("time");
		if (StringUtils.isNotBlank(timeString)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = sdf.parse(timeString);
				time = new BigDecimal(date.getTime());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
			}
		}

		String note = request.getParameter("note");
		if (StringUtils.isNotBlank(note)) {
			note = URLDecoder.decode(note, "utf8");
		}

		if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				accessControllerManager
						.addACLog(triggerId, deviceType, logType, triggerType,
								deviceId, note, time, eventNaming);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.EXCEPTION);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.EXCEPTION);
			}
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		writePageWithContentLength(response, doc);
	}

	/**
	 * createAcAccessControls 创建门
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "创建门", isLog = true, isCheckSession = true)
	@RequestMapping("/createAcAccessControls.json")
	public void createAcAccessControls(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request
				.getAttribute("installLocation");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		Integer channelId = null;
		String channelId1 = (String) request.getAttribute("channelId");
		if (StringUtils.isNotBlank(channelId1)) {
			try {
				channelId = Integer.parseInt(channelId1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("channelId");
			}
		}
		String note = (String) request.getAttribute("note");
		String accessServerId = (String) request.getAttribute("accessServerId");
		String remoteOpen = "false";
		String remoteOpen1 = (String) request.getAttribute("remoteOpen");
		if (StringUtils.isNotBlank(remoteOpen1)) {
			remoteOpen = remoteOpen1;
		}

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = accessControllerManager.createAcAccessControls(
						name, installLocation, deviceNumber, channelId, note,
						accessServerId, remoteOpen);
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
	 * deleteAcAccessControls 删除门
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "删除门", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteAcAccessControls.json")
	public void deleteAcAccessControls(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			accessControllerManager.deleteAcAccessControls(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * updateAcAccessControls 更新门
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "更新门", isLog = false, isCheckSession = true)
	@RequestMapping("/updateAcAccessControls.json")
	public void updateAcAccessControls(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request
				.getAttribute("installLocation");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		Integer channelId = null;
		String channelId1 = (String) request.getAttribute("channelId");
		if (StringUtils.isNotBlank(channelId1)) {
			try {
				channelId = Integer.parseInt(channelId1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("channelId");
			}
		}
		String note = (String) request.getAttribute("note");
		String accessServerId = (String) request.getAttribute("accessServerId");
		String remoteOpen = "false";
		String remoteOpen1 = (String) request.getAttribute("remoteOpen");
		if (StringUtils.isNotBlank(remoteOpen1)) {
			remoteOpen = remoteOpen1;
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				accessControllerManager.updateAcAccessControls(id, name,
						installLocation, deviceNumber, channelId, note,
						accessServerId, remoteOpen);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	/**
	 * getAcAccessControlsById 根据ID查询门
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据ID查询门", isLog = false, isCheckSession = true)
	@RequestMapping("/getAcAccessControlsById.json")
	public void getAcAccessControlsById(HttpServletRequest request,
			HttpServletResponse response) {
		AcAccessControlsResponse resp = new AcAccessControlsResponse();
		String id = (String) request.getAttribute("id");
		try {
			AcAccessControls aac = accessControllerManager
					.getAcAccessControlsById(id);
			if (null != aac) {
				resp.setId(aac.getId());
				resp.setName(aac.getName());
				resp.setOrganId(aac.getOrganId());
				resp.setNaming(aac.getNaming());
				resp.setInstallLocation(aac.getInstallLocation());
				resp.setDeviceNumber(aac.getDeviceNumber());
				resp.setChannelId(aac.getChannelId());
				resp.setNote(aac.getNote());
				resp.setDeviceType(aac.getDeviceType());
				resp.setAccessServerId(aac.getAccessServerId());
				resp.setStatus(aac.getStatus());
				resp.setRemoteOpen(aac.getRemoteOpen());
				resp.setCode(ErrorCode.SUCCESS);

			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * listAcAccessControlsByOrganId 根据机构ID查询门列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据机构ID查询门列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listAcAccessControlsByOrganId.json")
	public void listAcAccessControlsByOrganId(HttpServletRequest request,
			HttpServletResponse response) {
		ListAcAccessControlsResponse resp = new ListAcAccessControlsResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<AcAccessControls> aac = accessControllerManager
					.listAcAccessControlsByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessControls(aac);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * listAcAccessControlsByAccessServerId 根据门禁控制器ID查询门列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据门禁控制器ID查询门列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listAcAccessControlsByAccessServerId.json")
	public void listAcAccessControlsByAccessServerId(
			HttpServletRequest request, HttpServletResponse response) {
		ListAcAccessControlsResponse resp = new ListAcAccessControlsResponse();
		String accessServerId = (String) request.getAttribute("accessServerId");
		try {
			List<AcAccessControls> aac = accessControllerManager
					.listAcAccessControlsByAccessServerId(accessServerId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessControls(aac);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * listAcAccessControlByGatewayId 根据门禁网关ID查询门列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据门禁网关ID查询门列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listAcAccessControlByGatewayId.json")
	public void listAcAccessControlByGatewayId(HttpServletRequest request,
			HttpServletResponse response) {
		ListAcAccessControlsResponse resp = new ListAcAccessControlsResponse();
		String gatewayId = (String) request.getAttribute("gatewayId");
		try {
			List<AcAccessControls> aac = accessControllerManager
					.listAcAccessControlByGatewayId(gatewayId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessControls(aac);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * bindDoorAndVic 绑定门和摄像头
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "绑定门和摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/bindDoorAndVic.json")
	public void bindDoorAndVic(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		try {
			accessControllerManager.bindDoorAndVic(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * listControlAndVic 查询绑定门和摄像头列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "查询绑定门和摄像头列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listControlAndVic.json")
	public void listControlAndVic(HttpServletRequest request,
			HttpServletResponse response) {
		ListControlAndVicResponse resp = new ListControlAndVicResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<ListControlAndVicVO> vicAndControl = accessControllerManager
					.listControlAndVic(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVicAndDoor(vicAndControl);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * bindDoorAndUser 绑定门和用户
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "绑定门和用户", isLog = false, isCheckSession = true)
	@RequestMapping("/bindDoorAndUser.json")
	public void bindDoorAndUser(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		try {
			accessControllerManager.bindDoorAndUser(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * updateRemoteOpen 更新远程开门状态
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "更新远程开门状态", isLog = false, isCheckSession = true)
	@RequestMapping("/updateRemoteOpen.json")
	public void updateRemoteOpen(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String doorId = (String) request.getAttribute("doorId");
		String remoteOpen = (String) request.getAttribute("remoteOpen");
		try {
			accessControllerManager.updateRemoteOpen(doorId, remoteOpen);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
