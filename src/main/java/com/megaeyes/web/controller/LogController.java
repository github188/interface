/**   
 * @Title: LogController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-25 上午10:46:32 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.vo.ListLogAndEmployeeVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.LogManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.EpOperationLogResponse;
import com.megaeyes.web.response.ListLogAndEmployeeResponse;

/**
 * @ClassName: LogController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-25 上午10:46:32
 * 
 */
@Controller
public class LogController extends BaseController {
	@Autowired
	LogManager logManager;

	@ControllerDescription(description = "根据条件查询用户操作日志",isLog=false,isCheckSession=true)
	@RequestMapping("/listEpOperationLog.json")
	public void listEpOperationLog(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		EpOperationLogResponse resp = new EpOperationLogResponse();
		String startTime = (String) request.getAttribute("startTime");
		String endTime = (String) request.getAttribute("endTime");
		String userLoginName = (String) request.getAttribute("userLoginName");
		try {
			List<EpOperationLog> list = logManager.listEpOperationLog(
					startTime, endTime, userLoginName);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setList(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * listEmployeeByDoorId 根据门ID和时间段查询员工信息	
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据门ID和时间段查询员工信息",isLog=false,isCheckSession=true)
	@RequestMapping("/listLogEmployeeByDoorId.json")
	public void listLogEmployeeByDoorId(HttpServletRequest request,
			HttpServletResponse response){
		ListLogAndEmployeeResponse resp = new ListLogAndEmployeeResponse();
		String doorId = (String) request.getAttribute("doorId");
		String startTime = (String) request.getAttribute("startTime");
		String endTime = (String) request.getAttribute("endTime");
		try{
			List<ListLogAndEmployeeVO> logEmployee = logManager.listLogEmployeeByDoorId(doorId,startTime,endTime);
			resp.setLogAndEmployee(logEmployee);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
