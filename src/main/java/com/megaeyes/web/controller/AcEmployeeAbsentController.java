package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.StringUtil;

import com.megaeyes.persistence.ibatis.vo.AcEmployeeAbsentRecordVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeeAbsenceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcEmployeeAbsentResponse;

/**
 * 
 * @Title: AcEmployeeAbsentController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhuanqi@megaeyes.com   
 * @date 2013-1-9 上午03:09:26 
 * @version V2.5
 */
@Controller
public class AcEmployeeAbsentController  extends BaseController{
	
	@Autowired
	AcEmployeeAbsenceManager employeeAbsentManager;
	
	@ControllerDescription(description = "创建员工请假记录", isLog = true, isCheckSession = true)
	@RequestMapping("/createEmployeeAbsent.json")
	public void createEmployeeAbsent(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String sessionId = (String)request.getAttribute("sessionId");
		String type = (String)request.getAttribute("type");
		String organId = (String)request.getAttribute("organId");
		String branchId =(String) request.getAttribute("branchId");
		String employeeId = (String)request.getAttribute("employeeId");
		String startDate = (String)request.getAttribute("startDate");
		String startTime = (String)request.getAttribute("startTime");
		String endDate = (String)request.getAttribute("endDate");
		String endTime = (String)request.getAttribute("endTime");
		String approver = (String)request.getAttribute("approver");
		String note = (String)request.getAttribute("note");
		
		try {
			String id = employeeAbsentManager.createEmployeeAbsent(sessionId, type, employeeId, startTime, endTime, approver, note, branchId, organId, startDate, endDate);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "修改员工请假记录", isLog = true, isCheckSession = true)
	@RequestMapping("/updateEmployeeAbsent.json")
	public void updateEmployeeAbsent(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		String type = (String)request.getAttribute("type");
		String organId = (String)request.getAttribute("organId");
		String branchId =(String) request.getAttribute("branchId");
		String employeeId = (String)request.getAttribute("employeeId");
		String startDate = (String)request.getAttribute("startDate");
		String startTime = (String)request.getAttribute("startTime");
		String endDate = (String)request.getAttribute("endDate");
		String endTime = (String)request.getAttribute("endTime");
		String approver = (String)request.getAttribute("approver");
		String note = (String)request.getAttribute("note");
		
		try {
			employeeAbsentManager.updateEmployeeAbsent(id, type, employeeId, startTime, endTime, approver, note, branchId, organId, startDate, endDate);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "删除员工请假记录", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEmployeeAbsent.json")
	public void deleteEmployeeAbsent(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		
		try {
			employeeAbsentManager.deleteEmployeeAbsent(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据部门ID查询员工请假记录", isLog = true, isCheckSession = true)
	@RequestMapping("/getAbsentListByBranchId.json")
	public void getAbsentListByBranchId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String branchId = (String)request.getAttribute("branchId");
		ListAcEmployeeAbsentResponse resp = new ListAcEmployeeAbsentResponse();
		try {
			if(StringUtil.isNotBlank(branchId)){
				List<AcEmployeeAbsentRecordVO> absents = employeeAbsentManager.getAbsentListByBranchId(branchId);
				resp.setAbsents(absents);
				resp.setCode(ErrorCode.SUCCESS);
			}else{
				throw new BusinessException("部门ID不能为空", ErrorCode.PARAMETER_NOT_FOUND);
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writeDateJSONPageNoZip(response, resp, 2);
	}
}
