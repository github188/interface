package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcWorkAttendanceRule;
import com.megaeyes.persistence.ibatis.model.AcWorkRule;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcWorkRuleManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AcWorkAttendanceRuleResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcWorkRuleResponse;

@Controller
public class AcWorkRuleController extends BaseController {
	@Autowired
	AcWorkRuleManager workRuleManager;

	@ControllerDescription(description = "创建班次时间段规则", isLog = true, isCheckSession = true)
	@RequestMapping("/createWorkRule.json")
	public void createWorkRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String sessionId = (String) request.getAttribute("sessionId");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String periodStart = (String) request.getAttribute("periodStart");
		String periodEnd = (String) request.getAttribute("periodEnd");
		String firstStartSigned = (String) request.getAttribute("firstStartSigned");
		String secondStartSigned = (String) request.getAttribute("secondStartSigned");
		String firstEndSigned = (String) request.getAttribute("firstEndSigned");
		String secondEndSigned = (String) request.getAttribute("secondEndSigned");
		String startPermitMinutes = (String) request.getAttribute("startPermitMinutes");
		String endPermitMinutes = (String) request.getAttribute("endPermitMinutes");
		try {
			String id = workRuleManager.createWorkRule(name, organId, periodStart,
					periodEnd, firstStartSigned, secondStartSigned, firstEndSigned, 
					secondEndSigned, startPermitMinutes, endPermitMinutes, sessionId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "修改班次时间段规则", isLog = true, isCheckSession = true)
	@RequestMapping("/modifyWorkRule.json")
	public void modifyWorkRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String sessionId = (String) request.getAttribute("sessionId");
		String name = (String) request.getAttribute("name");
		String id = (String) request.getAttribute("id");
		String periodStart = (String) request.getAttribute("periodStart");
		String periodEnd = (String) request.getAttribute("periodEnd");
		String firstStartSigned = (String) request.getAttribute("firstStartSigned");
		String secondStartSigned = (String) request.getAttribute("secondStartSigned");
		String firstEndSigned = (String) request.getAttribute("firstEndSigned");
		String secondEndSigned = (String) request.getAttribute("secondEndSigned");
		String startPermitMinutes = (String) request.getAttribute("startPermitMinutes");
		String endPermitMinutes = (String) request.getAttribute("endPermitMinutes");
		try {
			workRuleManager.updateWorkRule(id, name, periodStart,periodEnd, firstStartSigned, secondStartSigned,
					firstEndSigned, secondEndSigned, startPermitMinutes,endPermitMinutes, sessionId);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "删除班次时间段规则", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteWorkRule.json")
	public void deleteWorkRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		try {
			workRuleManager.deleteWorkRule(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据机构ID查询时间段规则列表", isLog = true, isCheckSession = true)
	@RequestMapping("/getWorkRuleListByOrganId.json")
	public void getWorkRuleListByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		ListAcWorkRuleResponse resp = new ListAcWorkRuleResponse();
		String organId = (String)request.getAttribute("organId");
		try {
			List<AcWorkRule> list = workRuleManager.getWorkRuleListByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setRules(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "创建考勤制度规则", isLog = true, isCheckSession = true)
	@RequestMapping("/createWorkAttendanceRule.json")
	public void createWorkAttendanceRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String sessionId = (String)request.getAttribute("sessionId");
		String organId = (String)request.getAttribute("organId");
		String startDate = (String)request.getAttribute("startDate");
		String lateOutMinutes = (String)request.getAttribute("lateOutMinutes");
		String leaveOutMinutes = (String)request.getAttribute("leaveOutMinutes");
		String lateStat = (String)request.getAttribute("lateStat");
		String lateStatMinutes = (String)request.getAttribute("lateStatMinutes");
		String leaveStat = (String)request.getAttribute("leaveStat");
		String leaveStatMinutes = (String)request.getAttribute("leaveStatMinutes");
		try {
			String id = workRuleManager.createWorkAttendanceRule(sessionId, organId, startDate, 
					lateOutMinutes, leaveOutMinutes, lateStat, lateStatMinutes, leaveStat, leaveStatMinutes);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "修改考勤制度规则", isLog = true, isCheckSession = true)
	@RequestMapping("/modifyWorkAttendanceRule.json")
	public void modifyWorkAttendanceRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		String startDate = (String)request.getAttribute("startDate");
		String lateOutMinutes = (String)request.getAttribute("lateOutMinutes");
		String leaveOutMinutes = (String)request.getAttribute("leaveOutMinutes");
		String lateStat = (String)request.getAttribute("lateStat");
		String lateStatMinutes = (String)request.getAttribute("lateStatMinutes");
		String leaveStat = (String)request.getAttribute("leaveStat");
		String leaveStatMinutes = (String)request.getAttribute("leaveStatMinutes");
		try {
			workRuleManager.updateWorkAttendanceRule(id, startDate, lateOutMinutes, 
					leaveOutMinutes, lateStat, lateStatMinutes, leaveStat, leaveStatMinutes);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据机构ID查询考勤制度规则", isLog = true, isCheckSession = true)
	@RequestMapping("/getWorkAttendanceRule.json")
	public void getWorkAttendanceRule(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		AcWorkAttendanceRuleResponse resp = new AcWorkAttendanceRuleResponse();
		String organId = (String)request.getAttribute("organId");
		try {
			AcWorkAttendanceRule rule = workRuleManager.getWorkAttendanceRule(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setRule(rule);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writeDateJSONPageNoZip(response, resp, 2);
	}
	
}
