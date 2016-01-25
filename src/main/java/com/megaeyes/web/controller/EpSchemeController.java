/**   
 * @Title: EpSchemeController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-16 上午2:10:10 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.vo.EpSchemeVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelAndSchemeVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpSchemeManager;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.GetEpSchemeResponse;
import com.megaeyes.web.response.ListEpSchemeResponse;
import com.megaeyes.web.response.ListVICAndSchemeResponse;
import com.megaeyes.web.response.getEpRSchemeAlarmSourceResponse;

/**
 * @ClassName: EpSchemeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-16 上午2:10:10
 * 
 */
@Controller
public class EpSchemeController extends BaseController {
	@Autowired
	EpSchemeManager epSchemeManager;

	@Autowired
	UserManager userManager;

	/**
	 * @throws JSONException
	 * @Title: createES
	 * @Description: 创建预案
	 * @param request
	 * @param response
	 * @param @throws UnsupportedEncodingException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "创建预案", isLog = true, isCheckSession = true)
	@RequestMapping("/createES.json")
	public void createES(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String note = (String) request.getAttribute("note");
		String type = "2";
		String type1 = (String) request.getAttribute("type");
		if (StringUtils.isNotBlank(type1)) {
			type = type1;
		}
		Long lastUpdateTime = System.currentTimeMillis();
		String lastUpdateTimeString = (String) request
				.getAttribute("lastUpdateTime");
		if (StringUtils.isNotBlank(lastUpdateTimeString)) {
			try {
				lastUpdateTime = Long.parseLong(lastUpdateTimeString);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("lastUpdateTime");
			}
		}

		String sessionId = request.getParameter("sessionId");

		String actions = (String) request.getAttribute("actions");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				// 获取创建用户的ID
				UserSessionVO user = userManager.getSessionById(sessionId);

				String id = epSchemeManager.createES(name, organId, note, type,
						lastUpdateTime, actions, user.getUserId());
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
	 * @Title: deleteES
	 * @Description: 删除预案
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除预案", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteES.json")
	public void deleteES(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			epSchemeManager.deleteES(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: listESByOrganId
	 * @Description: 根据机构ID查询预案
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据机构ID查询预案", isLog = false, isCheckSession = true)
	@RequestMapping("/listESByOrganId.json")
	public void listESByOrganId(HttpServletRequest request,
			HttpServletResponse response) {
		ListEpSchemeResponse resp = new ListEpSchemeResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<EpScheme> es = epSchemeManager.listESByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEs(es);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: updateES
	 * @Description: 根据指定ID更新预案
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据指定ID更新预案", isLog = false, isCheckSession = true)
	@RequestMapping("/updateES.json")
	public void updateES(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String note = (String) request.getAttribute("note");
		String type = "2";
		String type1 = (String) request.getAttribute("type");
		if (StringUtils.isNotBlank(type1)) {
			type = type1;
		}
		Long lastUpdateTime = System.currentTimeMillis();
		
		String actions = (String) request.getAttribute("actions");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				epSchemeManager.updateES(id, name, organId, note, type,
						lastUpdateTime, actions);
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
	 * @Title: getEpScheme
	 * @Description: 根据ID查询预案及命令
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据ID查询预案及命令", isLog = false, isCheckSession = true)
	@RequestMapping("/getEpScheme.json")
	public void getEpScheme(HttpServletRequest request,
			HttpServletResponse response) {
		GetEpSchemeResponse resp = new GetEpSchemeResponse();
		String id = (String) request.getAttribute("id");
		try {
			EpSchemeVO es = epSchemeManager.getEpScheme(id);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setScheme(es);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: bindDeviceEpScheme
	 * @Description: 绑定设备作为触发源的预案
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "绑定设备作为触发源的预案", isLog = false, isCheckSession = true)
	@RequestMapping("/bindDeviceEpScheme.json")
	public void bindDeviceEpScheme(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String deviceId = (String) request.getAttribute("deviceId");
		String deviceType = (String) request.getAttribute("deviceType");
		String schemeId = (String) request.getAttribute("schemeId");
		String alarmType = (String) request.getAttribute("alarmType");
		try {
			String id = epSchemeManager.bindDeviceEpScheme(deviceId,
					deviceType, schemeId, alarmType);
			// 修改预案表，保证事件服务器能知道预案反生了改动
			epSchemeManager.updateESTimeById(schemeId);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据设备ID查询绑定的预案", isLog = false, isCheckSession = true)
	@RequestMapping("/getEpRSchemeAlarmSource.json")
	public void getEpRSchemeAlarmSource(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		request.setCharacterEncoding("UTF-8");
		getEpRSchemeAlarmSourceResponse resp = new getEpRSchemeAlarmSourceResponse();
		String sourceIds = (String) request.getAttribute("sourceIds");
		try {
			List list = epSchemeManager.getEpRSchemeAlarmSource(sourceIds);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpRSchemeAlarmSource(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据机构ID查询摄像头以及绑定预案", isLog = false, isCheckSession = true)
	@RequestMapping("/listVICAndSchemeByOrganId.json")
	public void listVICAndSchemeByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		request.setCharacterEncoding("UTF-8");
		ListVICAndSchemeResponse resp = new ListVICAndSchemeResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<VideoInputChannelAndSchemeVO> list = epSchemeManager.listVICAndSchemeByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVicAndShceme(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "移除设备的预案绑定", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteDeviceScheme.json")
	public void deleteDeviceEpScheme(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaseResponse resp = new BaseResponse();
		String deviceId = (String) request.getAttribute("deviceId");
		if (StringUtils.isBlank(deviceId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("deviceId");
		}

		String deviceType = (String) request.getAttribute("deviceType");
		if (StringUtils.isBlank(deviceType)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("deviceType");
		}

		String schemeId = (String) request.getAttribute("schemeId");
		if (StringUtils.isBlank(schemeId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("schemeId");
		}

		String alarmType = (String) request.getAttribute("alarmType");
		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				epSchemeManager.deleteDeviceEpScheme(deviceId, deviceType,
						schemeId, alarmType);
				// 修改预案表，保证事件服务器能知道预案反生了改动
				epSchemeManager.updateESTimeById(schemeId);
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
}
