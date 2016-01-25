/**   
 * @Title: RoleController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 上午10:43:53 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpOperation;
import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByRoleId;
import com.megaeyes.persistence.ibatis.vo.ListOperationByRoleId;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.RoleManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpOperationResponse;
import com.megaeyes.web.response.ListDeviceByRoleIdResponse;
import com.megaeyes.web.response.ListOperationByRoleIdResponse;
import com.megaeyes.web.response.ListRoleResponse;

/**
 * @ClassName: RoleController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 上午10:43:53
 * 
 */
@Controller
public class RoleController extends BaseController {
	@Autowired
	RoleManager roleManager;

	@ControllerDescription(description = "创建角色", isLog = true, isCheckSession = true)
	@RequestMapping("/createRole.json")
	public void createRole(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String isSuspendedstr = (String) request.getAttribute("isSuspended");
		BigDecimal isSuspended = null;
		if (StringUtils.isNotBlank(isSuspendedstr)) {
			try {
				isSuspended = new BigDecimal(isSuspendedstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isSuspended");
			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("isSuspended");
		}
		String createUserName = (String) request.getAttribute("createUserName");
		// String typestr = (String) request.getAttribute("type");
		BigDecimal type = new BigDecimal(2);
		/*
		 * if (StringUtils.isNotBlank(typestr)) { try { type = new
		 * BigDecimal(typestr); } catch (NumberFormatException e) {
		 * resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
		 * resp.setMessage("type"); } } else {
		 * resp.setCode(ErrorCode.PARAMETER_NOT_FOUND); resp.setMessage("type");
		 * }
		 */
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = roleManager.createRole(name, note, organId,
						isSuspended, createUserName, type);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除角色", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteRole.json")
	public void deleteRole(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			roleManager.deleteRole(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询角色列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listRoleByOrganId.json")
	public void listRoleByOrganId(HttpServletRequest request,
			HttpServletResponse response) {
		ListRoleResponse resp = new ListRoleResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<EpRole> list = roleManager.listRoleByOrganId(organId);
			resp.setListrole(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据用户ID查询角色列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listRoleByUserId.json")
	public void listRoleByUserId(HttpServletRequest request,
			HttpServletResponse response) {
		ListRoleResponse resp = new ListRoleResponse();
		String userId = (String) request.getAttribute("userId");
		System.out.println("--------------------:" + userId);
		try {
			List<EpRole> list = roleManager.listRoleByUserId(userId);
			System.out.println(list.size());
			resp.setListrole(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新角色信息", isLog = true, isCheckSession = true)
	@RequestMapping("/updateRole.json")
	public void updateRole(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String isSuspendedstr = (String) request.getAttribute("isSuspended");
		BigDecimal isSuspended = null;
		if (StringUtils.isNotBlank(isSuspendedstr)) {
			try {
				isSuspended = new BigDecimal(isSuspendedstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isSuspended");
			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("isSuspended");
		}
		String createUserName = (String) request.getAttribute("createUserName");
		String typestr = (String) request.getAttribute("type");
		BigDecimal type = null;
		if (StringUtils.isNotBlank(typestr)) {
			try {
				type = new BigDecimal(typestr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("type");
			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("type");
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				roleManager.updateRole(id, name, note, organId, isSuspended,
						createUserName, type);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "增加，删除，修改用户角色", isLog = true, isCheckSession = true)
	@RequestMapping("/updateRoleToUser.json")
	public void updateRoleToUser(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String jsonString = (String) request.getAttribute("jsonString");
		// JSONObject json = null;
		// if (jsonString != null && jsonString.length() != 0) {
		// json = JSONObject.fromObject(jsonString);
		// }
		// String userId = json.getString("userId");
		// String roleIds = json.getString("roleId");
		try {
			roleManager.updateRoleToUser(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询所有操作权限", isLog = false, isCheckSession = true)
	@RequestMapping("/listAllEpOperation.json")
	public void listAllEpOperation(HttpServletRequest request,
			HttpServletResponse response) {
		EpOperationResponse resp = new EpOperationResponse();
		try {
			List<EpOperation> list = roleManager.listAllEpOperation();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "增加、删除、修改角色和权限关联", isLog = true, isCheckSession = true)
	@RequestMapping("/addOrUpdateEpRRoleOperation.json")
	public void addOrUpdateEpRRoleOperation(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String jsonString = (String) request.getAttribute("jsonString");
		System.out.println(jsonString);
		try {
			roleManager.addorupdateEpRRoleOperation(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据角色查询权限", isLog = false, isCheckSession = true)
	@RequestMapping("/listOperationByRoleId.json")
	public void listOperationByRoleId(HttpServletRequest request,
			HttpServletResponse response) {
		ListOperationByRoleIdResponse resp = new ListOperationByRoleIdResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String roleId = (String) request.getAttribute("roleId");
		try {
			List<ListOperationByRoleId> list = roleManager
					.listOperationByRoleId(roleId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "增加、删除、修改角色和设备关联", isLog = true, isCheckSession = true)
	@RequestMapping("/addOrUpdateEpRRoleResource.json")
	public void addOrUpdateEpRRoleResource(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String jsonString = (String) request.getAttribute("jsonString");
		System.out.println(jsonString);
		try {
			roleManager.addorupdateEpRRoleResource(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据角色ID查询设备", isLog = false, isCheckSession = true)
	@RequestMapping("/listDeviceByRoleId.json")
	public void listDeviceByRoleId(HttpServletRequest request,
			HttpServletResponse response) {
		ListDeviceByRoleIdResponse resp = new ListDeviceByRoleIdResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String roleId = (String) request.getAttribute("roleId");
		try {
			List<ListDeviceByRoleId> list = roleManager
					.ListDeviceByRoleId(roleId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
