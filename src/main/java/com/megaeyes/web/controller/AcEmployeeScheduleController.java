package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcEmployeeSchedule;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeeScheduleManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcEmployeeScheduleResponse;

/**
 * 
 * @Title: AcEmployeeScheduleController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: 班次管理 
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-7 上午03:12:32 
 * @version V1.0
 */
@Controller
public class AcEmployeeScheduleController extends BaseController{
	@Autowired
	AcEmployeeScheduleManager employeeScheduleManager;
	
	
	@ControllerDescription(description = "创建班次", isLog = true, isCheckSession = true)
	@RequestMapping("/createEmployeeSchedule.json")
	public void createEmployeeSchedule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String name = (String)request.getAttribute("name");
		String organId = (String)request.getAttribute("organId");
		String startDate = (String)request.getAttribute("startDate");
		String note = (String)request.getAttribute("note");
		String sessionId = (String)request.getAttribute("sessionId");
		
		try {
			String id = employeeScheduleManager.createEmployeeSchedule(name, organId, startDate,note, sessionId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "修改班次信息", isLog = true, isCheckSession = true)
	@RequestMapping("/updateEmployeeSchedule.json")
	public void updateEmployeeSchedule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		String name = (String)request.getAttribute("name");
		String startDate = (String)request.getAttribute("startDate");
		String note = (String)request.getAttribute("note");
		try {
			employeeScheduleManager.updateEmployeeSchedule(name, id, startDate,note);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "删除班次", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEmployeeSchedule.json")
	public void deleteEmployeeSchedule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		
		try {
			employeeScheduleManager.deleteEmployeeSchedule(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "班次-员工组排班", isLog = true, isCheckSession = true)
	@RequestMapping("/bindEmployeeGroupToSchedule.json")
	public void bindEmployeeGroupToSchedule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String jsonString = (String)request.getAttribute("jsonString");
		
		try {
			employeeScheduleManager.bindScheduleGroup(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "班次-时间段规则设置", isLog = true, isCheckSession = true)
	@RequestMapping("/setEmployeeScheduleRule.json")
	public void setEmployeeScheduleRule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String scheduleId = (String)request.getAttribute("scheduleId");
		String ruleId = (String)request.getAttribute("ruleId");
		try {
			employeeScheduleManager.setScheduleWorkRule(scheduleId,ruleId);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询班次列表", isLog = true, isCheckSession = true)
	@RequestMapping("/getScheduleListByOrganId.json")
	public void getScheduleListByOrganId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		ListAcEmployeeScheduleResponse resp = new ListAcEmployeeScheduleResponse();
		String organId = (String)request.getAttribute("organId");
		
		try {
			List<AcEmployeeSchedule> list = employeeScheduleManager.getScheduleListByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setSchedules(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writeDateJSONPageNoZip(response, resp, 2);
	}
	
}
