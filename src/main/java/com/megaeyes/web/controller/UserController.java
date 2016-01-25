/**   
 * @Title: UserController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: 用户相关的接口
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-28 下午5:50:14 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.model.EpOperation;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.queryParameter.UserSessionParameter;
import com.megaeyes.persistence.ibatis.vo.ListUserSessionAndUserVO;
import com.megaeyes.persistence.ibatis.vo.TUserVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BaseManager;
import com.megaeyes.service.iface.EpClientGatewayManager;
import com.megaeyes.service.iface.InterConnectManager;
import com.megaeyes.service.iface.RoleManager;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListUserResponse;
import com.megaeyes.web.response.ListUserSessionAndUserResponse;
import com.megaeyes.web.response.ListUserVOResponse;
import com.megaeyes.web.response.UserLogonResponse;
import com.megaeyes.web.response.xml.GetSubscribeNotifyUsersResponse;
import com.megaeyes.web.response.xml.ListOnlineUserResponse;

/**
 * @ClassName: UserController
 * @Description: 用户相关的接口
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-28 下午5:50:14
 * 
 */
@Controller
public class UserController extends BaseController {
	@Autowired
	BaseManager baseManager;
	@Autowired
	EpClientGatewayManager epClientGatewayManager;
	@Autowired
	UserManager userManager;
	@Autowired
	private InterConnectManager interConnectManager;

	@Autowired
	RoleManager roleManager;

	/**
	 * @Title: checkUserSession
	 * @Description: 校验session
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "校验Session", isLog = false, isCheckSession = false)
	@RequestMapping("/checkUserSession.json")
	public void checkUserSession(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String sessionId = (String) request.getAttribute("sessionId");
		try {
			baseManager.checkSessionId(sessionId);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "用户登录", isLog = true, isCheckSession = false)
	@RequestMapping("/login.json")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf8");
		UserLogonResponse resp = new UserLogonResponse();
		// 检查License
		resp.setCode(checkLicence().toString());

		String loginName = (String) request.getAttribute("loginName");
		String password = request.getParameter("password");
		String ip = request.getParameter("ip");
		if (StringUtils.isBlank(ip)) {
			if (request.getHeader("X-Forwarded-For") != null) {
				ip = request.getHeader("X-Forwarded-For");
			} else {
				ip = request.getRemoteAddr();
			}
		}
		UserSessionVO data = new UserSessionVO();
		String platformStatus = "";
		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				data = userManager.logon(loginName, password, ip);

				platformStatus = userManager.getPlatformStatus();
				request.getSession().setAttribute("user", data);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
			if (ErrorCode.SUCCESS.equals(resp.getCode())) {
				List<EpClientGateway> list = epClientGatewayManager
						.listEpClientGateway();
				if (list.size() > 0) {
					// 目前用户不绑定客户端网关，因此取查询到的第一个客户端网关返回
					EpClientGateway ecg = list.get(0);
					// 内网用户返回客户端网关内网IP
					if (data.getIsInnerUser().intValue() == 1) {
						resp.setClientGatewayIp(ecg.getIp1());
					}
					// 外网用户返回客户端网关外网IP
					else {
						resp.setClientGatewayIp(ecg.getIp2());
					}
					resp.setClientGatewayPort(ecg.getPort().toString());
					
				}
				
				resp.setUserId(data.getUserId());
				resp.setOrganId(data.getOrganId());
				resp.setSessionId(data.getId());
				resp.setUserName(data.getUserName());
				resp.setNaming(data.getNaming());
				resp.setPriority(data.getPriority() + "");
				resp.setOrganName(data.getOrganName());
				resp.setIsAdmin(data.getIsAdmin());
				resp.setBranchId(data.getBranchId());
				resp.setIsBranchAdmin(data.getIsBranchAdmin());
				if (!StringUtils.isBlank(resp.getSessionId())) {
					request.getSession().setAttribute("sessionId",
							resp.getSessionId());
				}
				resp.setPlatformStatus(platformStatus);

				List<EpOperation> operations = roleManager
						.listEpOperationByUserId(data.getUserId());

				if (operations != null && !operations.isEmpty()) {
					String[] operationArray = new String[operations.size()];
					for (int i = 0; i < operations.size(); i++) {
						operationArray[i] = operations.get(i)
								.getOperationNumber();
					}
					resp.setOperations(operationArray);
				}
			}
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: createUser
	 * @Description: 创建用户
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "创建用户", isLog = true, isCheckSession = true)
	@RequestMapping("/createUser.json")
	public void createUser(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		// 检查用户License
		resp.setCode(checkUserLicence());

		String logonName = (String) request.getAttribute("logonName");
		String password = (String) request.getAttribute("password");
		String organId = (String) request.getAttribute("organId");
		String accessServerId = (String) request.getAttribute("accessServerId");
		String note = (String) request.getAttribute("note");
		String name = (String) request.getAttribute("name");
		String sex = (String) request.getAttribute("sex");
		Long age = (long) 20;
		String age1 = (String) request.getAttribute("age");
		if (StringUtils.isNotBlank(age1)) {
			try {
				age = Long.parseLong(age1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("age");
			}
		}
		String mobile = (String) request.getAttribute("mobile");
		String phone = (String) request.getAttribute("phone");
		String email = (String) request.getAttribute("email");
		Short isSuspend = 0;
		Long maxSession = (long) 4;
		String maxSession1 = (String) request.getAttribute("maxSession");
		if (StringUtils.isNotBlank(maxSession1)) {
			try {
				maxSession = Long.parseLong(maxSession1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxSession");
			}
		}
		String userAccount = "0";
		Short priority = 1;
		String priority1 = (String) request.getAttribute("priority");
		if (StringUtils.isNotBlank(priority1)) {
			try {
				priority = Short.parseShort(priority1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("priority");
			}
		}
		String sipCode = (String) request.getAttribute("sipCode");
		String dispatchServerId = (String) request
				.getAttribute("dispatchServerId");
		if ("null".equals(dispatchServerId)) {
			dispatchServerId = "";
		}
		// 是否内网用户
		Short isInnerUser = 1;
		String isInnerUserString = request.getParameter("isInnerUser");
		if (StringUtils.isNotBlank(isInnerUserString)) {
			try {
				isInnerUser = Short.parseShort(isInnerUserString);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isInnerUser");
			}
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = userManager.createUser(logonName, password,
						organId, accessServerId, note, name, sex, age, mobile,
						phone, email, isSuspend, maxSession, userAccount,
						priority, sipCode, dispatchServerId, isInnerUser);
				// System.out.println("---------------"+id);
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
	 * @Title: deleteUser
	 * @Description: 删除用户
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除用户", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteUser.json")
	public void deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String ids = (String) request.getAttribute("userIds");
		try {
			userManager.deleteUser(ids);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: listUser
	 * @Description: 返回用户信息
	 * @param request
	 * @param response
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "返回用户信息", isLog = false, isCheckSession = true)
	@RequestMapping("/listUser.json")
	public void listUser(HttpServletRequest request,
			HttpServletResponse response) {
		ListUserResponse resp = new ListUserResponse();
		try {
			List<TUser> user = userManager.listUser();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setUser(user);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: updateUser
	 * @Description: 更新用户列表
	 * @param @param request
	 * @param @param response
	 * @param @throws UnsupportedEncodingException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "修改用户信息", isLog = true, isCheckSession = true)
	@RequestMapping("/updateUser.json")
	public void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("userId");
		String logonName = (String) request.getAttribute("logonName");
		String password = (String) request.getAttribute("password");
		String accessServerId = (String) request.getAttribute("accessServerId");
		String note = (String) request.getAttribute("note");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String sex = (String) request.getAttribute("sex");
		Long age = null;
		String age1 = (String) request.getAttribute("age");
		if (StringUtils.isNotBlank(age1)) {
			try {
				age = Long.parseLong(age1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("age");
			}
		}
		String mobile = (String) request.getAttribute("mobile");
		String phone = (String) request.getAttribute("phone");
		String email = (String) request.getAttribute("email");
		Long maxSession = null;
		String maxSession1 = (String) request.getAttribute("maxSession");
		if (StringUtils.isNotBlank(maxSession1)) {
			try {
				maxSession = Long.parseLong(maxSession1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxSession");
			}
		}
		String userAccount = null;
		Short priority = null;
		String priority1 = (String) request.getAttribute("priority");
		if (StringUtils.isNotBlank(priority1)) {
			try {
				priority = Short.parseShort(priority1);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("priority");
			}
		}
		String sipCode = (String) request.getAttribute("sipCode");
		String dispatchServerId = (String) request
				.getAttribute("dispatchServerId");
		if ("null".equals(dispatchServerId)) {
			dispatchServerId = "";
		}
		// 是否内网用户
		Short isInnerUser = null;
		String isInnerUserString = request.getParameter("isInnerUser");
		if (StringUtils.isNotBlank(isInnerUserString)) {
			try {
				isInnerUser = Short.parseShort(isInnerUserString);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isInnerUser");
			}
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				userManager.updateUser(id, logonName, password, accessServerId,
						note, name, naming, sex, age, mobile, phone, email,
						maxSession, userAccount, priority, sipCode,
						dispatchServerId, isInnerUser);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "根据机构查询用户列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listUserByOrgan.json")
	public void listUserByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ListUserVOResponse resp = new ListUserVOResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<TUserVO> list = userManager.listUserByOrganId(organId);
			resp.setUser(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询该机构以及子机构用户列表", isLog = false, isCheckSession = true)
	@RequestMapping("/getAllChildUsersByOrganId.json")
	public void getAllChildUsersByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ListUserResponse resp = new ListUserResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<TUser> list = userManager.getAllChildUsersByOrganId(organId);
			resp.setUser(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "用户登出", isLog = true, isCheckSession = true)
	@RequestMapping("/userLogoff.json")
	public void userLogoff(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String sessionId = (String) request.getAttribute("sessionId");
		try {
			userManager.logoff(sessionId);
			request.getSession().removeAttribute("sessionId");
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询在线用户", isLog = false, isCheckSession = false)
	@RequestMapping("/listOnlineUser.xml")
	public void listOnlineUserXML(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListOnlineUserResponse resp = new ListOnlineUserResponse();

		try {
			UserSessionParameter param = new UserSessionParameter();
			param.setStart(0);
			param.setLimit(9999);
			List<UserSessionVO> sessions = userManager.listUserSession(param);
			List<ListOnlineUserResponse.User> users = new ArrayList<ListOnlineUserResponse.User>();

			List<EpClientGateway> list = epClientGatewayManager
					.listEpClientGateway();
			for (EpClientGateway ecg : list) {
				if (!StringUtils.isBlank(ecg.getNaming())) {
					resp.setClientGatewayIp(ecg.getIp1());
					resp.setClientGatewayPort(ecg.getPort().toString());
					break;
				}
			}
			for (UserSessionVO us : sessions) {
				ListOnlineUserResponse.User user = resp.new User();
				user.setNaming(us.getNaming());
				user.setSessionId(us.getId());
				users.add(user);
			}

			resp.setUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(ListOnlineUserResponse.EXCEPTION);
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		Element usersElement = new Element("Users");
		root.addContent(usersElement);

		for (ListOnlineUserResponse.User user : resp.getUsers()) {
			Element userElement = new Element("User");
			userElement.setAttribute("SessionId", user.getSessionId());
			userElement.setAttribute("Naming", user.getNaming() == null ? ""
					: user.getNaming());
			userElement.setAttribute("SessionId", user.getSessionId());
			userElement.setAttribute("SessionId", user.getSessionId());
			userElement.setAttribute("ClientGatewayIp",
					resp.getClientGatewayIp());
			userElement.setAttribute("ClientGatewayPort",
					resp.getClientGatewayPort());
			usersElement.addContent(userElement);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "查询订阅报警信息用户列表", isLog = false, isCheckSession = false)
	@RequestMapping("/getSubscribeNotifyUsers.xml")
	public void getSubscribeNotifyUsers(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		GetSubscribeNotifyUsersResponse resp = new GetSubscribeNotifyUsersResponse();

		String code = (String) request.getAttribute("code");
		if (StringUtils.isBlank(code)) {
			resp.setReason("missing parameter [code] !");
			resp.setSuccess(GetSubscribeNotifyUsersResponse.FAIL);
		}

		String event = (String) request.getAttribute("eventType");
		if (StringUtils.isBlank(event)) {
			event = "alarm";
		}

		if (GetSubscribeNotifyUsersResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				// 获取报警订阅的用户列表
				Set<String> ids = interConnectManager.listNotifyUser(code,
						event);
				// 转换Set为List，方便后续的ibatis in条件查询
				List<String> idList = new ArrayList<String>();
				for (String id : ids) {
					idList.add(id);
				}
				List<UserSessionVO> list = interConnectManager
						.listOnlineNotifyUsers(idList);
				List<GetSubscribeNotifyUsersResponse.User> users = new ArrayList<GetSubscribeNotifyUsersResponse.User>();
				for (UserSessionVO u : list) {
					GetSubscribeNotifyUsersResponse.User user = resp.new User();
					user.setNaming(u.getNaming());
					user.setSessionId(u.getId());
					user.setCode(code);
					users.add(user);
				}
				resp.setUsers(users);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(GetSubscribeNotifyUsersResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(GetSubscribeNotifyUsersResponse.EXCEPTION);
				resp.setReason(e.getMessage());
			}
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		if (!GetSubscribeNotifyUsersResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}

		Element usersElement = new Element("Users");
		for (GetSubscribeNotifyUsersResponse.User u : resp.getUsers()) {
			Element userElement = new Element("User");
			userElement.setAttribute("SessionId", u.getSessionId());
			userElement.setAttribute("Naming", u.getNaming());
			userElement.setAttribute("Code", u.getCode());
			usersElement.addContent(userElement);
		}
		root.addContent(usersElement);

		writePageWithContentLength(response, doc);

	}

	/**
	 * 
	 * listUserSessionAndUserLogName 查询在线用户列表
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(isLog = false, isCheckSession = true, description = "查询在线用户列表")
	@RequestMapping("/listUserSessionAndUserLogName.json")
	public void listUserSessionAndUserLogName(HttpServletRequest request,
			HttpServletResponse response) {
		ListUserSessionAndUserResponse resp = new ListUserSessionAndUserResponse();
		try {
			List<ListUserSessionAndUserVO> user = userManager
					.listUserSessionAndUserLogName();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setUser(user);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(isLog = false, isCheckSession = false, description = "客户端心跳")
	@RequestMapping("/checkSession.json")
	public void checkSession(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String sessionId = (String) request.getAttribute("sessionId");
		if (StringUtils.isBlank(sessionId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("sessionId");
		}

		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				baseManager.heartBeat(sessionId);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage(e.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * updatePassword 根据用户ID修改密码
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(isLog = true, isCheckSession = true, description = "根据用户ID修改密码")
	@RequestMapping("/updatePassword.json")
	public void updatePassword(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String userId = (String) request.getAttribute("userId");
		String password = (String) request.getAttribute("password");
		try {
			userManager.updatePassword(userId, password);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
