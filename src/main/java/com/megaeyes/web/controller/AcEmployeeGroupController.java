package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcEmployeeGroup;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeeGroupManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListEmployeeGroupResponse;


/**
 * 
 * @Title: AcEmployeeGroupController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: 员工组接口类
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-7 上午03:12:27 
 * @version V1.0
 */
@Controller
public class AcEmployeeGroupController extends BaseController{
	@Autowired
	AcEmployeeGroupManager employeeGroupManager;	
	
	@ControllerDescription(description = "创建员工组", isLog = true, isCheckSession = true)
	@RequestMapping("/createEmployeeGroup.json")
	public void createEmployeeGroup(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String name = (String)request.getAttribute("name");
		String organId = (String)request.getAttribute("organId");
		String note = (String)request.getAttribute("note");
		String sessionId = (String)request.getAttribute("sessionId");
		
		try {
			String id = employeeGroupManager.createEmployeeGroup(organId, name, note,sessionId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "修改员工组", isLog = true, isCheckSession = true)
	@RequestMapping("/updateEmployeeGroup.json")
	public void updateEmployeeGroup(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		String name = (String)request.getAttribute("name");
		String note = (String)request.getAttribute("note");
		
		try {
			employeeGroupManager.updateEmployeeGroup(id, name, note);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "删除员工组", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEmployeeGroup.json")
	public void deleteEmployeeGroup(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		
		try {
			employeeGroupManager.deleteEmployeeGroup(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "员工-员工组绑定", isLog = true, isCheckSession = true)
	@RequestMapping("/bindEmployeesToGroup.json")
	public void bindEmployeesToGroup(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String jsonString = (String)request.getAttribute("jsonString");
		
		try {
			employeeGroupManager.bindEmployeesToGroup(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据机构ID查询员工组列表", isLog = true, isCheckSession = true)
	@RequestMapping("/getGroupListByOrganId.json")
	public void getGroupListByOrganId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		ListEmployeeGroupResponse resp = new ListEmployeeGroupResponse();
		String organId = (String)request.getAttribute("organId");
		
		try {
			List<AcEmployeeGroup> groupList = employeeGroupManager.getGroupListByOrganId(organId);
			resp.setGroups(groupList);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writeDateJSONPageNoZip(response, resp, 2);
	}
	
	@ControllerDescription(description = "根据排班ID查询员工组列表", isLog = true, isCheckSession = true)
	@RequestMapping("/getGroupListByScheduleId.json")
	public void getGroupListByScheduleId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		ListEmployeeGroupResponse resp = new ListEmployeeGroupResponse();
		String scheduleId = (String)request.getAttribute("scheduleId");
		
		try {
			List<AcEmployeeGroup> groupList = employeeGroupManager.getGroupListByScheduleId(scheduleId);
			resp.setGroups(groupList);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writeDateJSONPageNoZip(response, resp, 2);
	}
}
