/**   
 * @Title: EpTaskInspectionController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-7 下午5:30:43 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpTaskHistory;
import com.megaeyes.persistence.ibatis.model.EpTaskInspection;
import com.megaeyes.persistence.ibatis.model.EpTaskStepHistory;
import com.megaeyes.persistence.ibatis.vo.EpRTaskEmployeeDetailVO;
import com.megaeyes.persistence.ibatis.vo.EpTaskVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.RoutingInspectionManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpRTaskEmployeeResponse;
import com.megaeyes.web.response.EpTaskHistoryResponse;
import com.megaeyes.web.response.EpTaskInspectionResponse;
import com.megaeyes.web.response.EpTaskResponse;
import com.megaeyes.web.response.EpTaskStepHistoryResponse;
import com.megaeyes.web.response.ListTaskDetailResponse;

/**
 * @ClassName: EpTaskInspectionController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-7 下午5:30:43
 * 
 */
@Controller
public class RoutingInspectionController extends BaseController {

	@Autowired
	RoutingInspectionManager routingInspectionManager;

	@ControllerDescription(description = "查询所有巡查任务", isLog = false, isCheckSession = true)
	@RequestMapping("/listEpTaskInspection.json")
	public void listEpTaskInspection(HttpServletRequest request,
			HttpServletResponse response) {
		EpTaskInspectionResponse resp = new EpTaskInspectionResponse();
		try {
			List<EpTaskInspection> list = routingInspectionManager
					.listEpTaskInspection();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setList(list);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "操作所有巡检任务", isLog = false, isCheckSession = true)
	@RequestMapping("/operateEpTaskInspection.json")
	public void operateEpTaskInspection(HttpServletRequest request,
			HttpServletResponse response) throws JSONException,
			UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String jsonString = (String) request.getAttribute("jsonString");
		try {
			routingInspectionManager.operateEpTaskInspection(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "创建巡检计划", isLog = true, isCheckSession = true)
	@RequestMapping("/createEpTask.json")
	public void createEpTask(HttpServletRequest request,
			HttpServletResponse response) throws JSONException,
			UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String jsonString = (String) request.getAttribute("jsonString");
		try {
			String id = routingInspectionManager.createEpTask(jsonString);
			resp.setMessage(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除巡检计划", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteTask.json")
	public void deleteTask(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String taskId = (String) request.getAttribute("taskId");
		try {
			routingInspectionManager.deleteTask(taskId);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构id查询巡检计划", isLog = false, isCheckSession = true)
	@RequestMapping("/listEpTask.json")
	public void listEpTask(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		EpTaskResponse resp = new EpTaskResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<EpTaskVO> list = routingInspectionManager
					.listEpTaskByOrganId(organId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据巡检计划Id查询详细信息", isLog = false, isCheckSession = true)
	@RequestMapping("/listEpTaskDetail.json")
	public void listTaskDetail(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		ListTaskDetailResponse resp = new ListTaskDetailResponse();
		String taskId = (String) request.getAttribute("taskId");
		try {
			Map map = routingInspectionManager.listTaskDetail(taskId);
			resp.setList(map);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新巡检计划", isLog = false, isCheckSession = true)
	@RequestMapping("/updateEpTask.json")
	public void updateEpTask(HttpServletRequest request,
			HttpServletResponse response) throws JSONException,
			UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		try {
			routingInspectionManager.updateEpTask(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "分配巡检计划", isLog = false, isCheckSession = true)
	@RequestMapping("/createEpRTaskEmployee.json")
	public void createEpRTaskEmployee(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		String taskId = (String) request.getAttribute("taskId");

		String employeeId = (String) request.getAttribute("employeeId");
		String userId = (String) request.getAttribute("userId");
		String allotUserId = (String) request.getAttribute("allotUserId");
		String executeTime = (String) request.getAttribute("executeTime");
		String executeTimeTypestr = (String) request
				.getAttribute("executeTimeType");
		String supportEmployee = (String) request
				.getAttribute("supportEmployee");
		BigDecimal executeTimeType = null;
		if (!StringUtils.isBlank(executeTimeTypestr)) {
			try {
				executeTimeType = new BigDecimal(executeTimeTypestr);
			} catch (Exception e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("executeTimeType");
			}
		}
		String taskTypestr = (String) request.getAttribute("taskType");
		BigDecimal taskType = null;
		if (!StringUtils.isBlank(taskTypestr)) {
			try {
				taskType = new BigDecimal(taskTypestr);
			} catch (Exception e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("taskType");

			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("taskType");
		}
		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				String id = routingInspectionManager.createEpRTaskEmployee(
						taskId, employeeId, userId, allotUserId, executeTime,
						executeTimeType, taskType, supportEmployee);
				resp.setMessage(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除分配好的巡检计划", isLog = false, isCheckSession = true)
	@RequestMapping("/deleteEpRTaskEmployee.json")
	public void deleteEpRTaskEmployee(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			routingInspectionManager.deleteEpRTaskEmployee(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询分配计划任务", isLog = false, isCheckSession = true)
	@RequestMapping("/ListEpRTaskEmployee.json")
	public void ListEpRTaskEmployee(HttpServletRequest request,
			HttpServletResponse response) throws JSONException {
		EpRTaskEmployeeResponse resp = new EpRTaskEmployeeResponse();
		String taskId = (String) request.getAttribute("taskId");
		String employeeId = (String) request.getAttribute("employeeId");
		String userId = (String) request.getAttribute("userId");
		String allotUserId = (String) request.getAttribute("allotUserId");
		String executeTime = (String) request.getAttribute("executeTime");
		try {
			List<EpRTaskEmployeeDetailVO> list = routingInspectionManager
					.ListEpRTaskEmployee(taskId, employeeId, userId,
							allotUserId, executeTime);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "完成计划任务", isLog = false, isCheckSession = true)
	@RequestMapping("/finishTask.json")
	public void finishTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		System.out.println("jsonString:" + jsonString);
		try {
			routingInspectionManager.finishTask(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询完成计划任务", isLog = false, isCheckSession = true)
	@RequestMapping("/listFinishTask.json")
	public void listFinishTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			JSONException {
		EpTaskHistoryResponse resp = new EpTaskHistoryResponse();
		request.setCharacterEncoding("UTF-8");
		String startTime = (String) request.getAttribute("startTime");
		String endTime = (String) request.getAttribute("endTime");
		String taskId = (String) request.getAttribute("taskId");
		String organName = (String) request.getAttribute("organName");
		String branchName = (String) request.getAttribute("branchName");
		String employeeName = (String) request.getAttribute("employeeName");
		String userId = (String) request.getAttribute("userId");
		String allotUserId = (String) request.getAttribute("allotUserId");
		String employeeId = (String) request.getAttribute("employeeId");
		try {
			List<EpTaskHistory> list = routingInspectionManager
					.listEpTaskHistory(startTime, endTime, taskId, organName,
							branchName, employeeName, userId, allotUserId,
							employeeId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询完成计划任务步骤", isLog = false, isCheckSession = true)
	@RequestMapping("/listFinishTaskStep.json")
	public void listFinishTaskStep(HttpServletRequest request,
			HttpServletResponse response) {
		EpTaskStepHistoryResponse resp = new EpTaskStepHistoryResponse();
		String historyTaskId = (String) request.getAttribute("id");
		try {
			List<EpTaskStepHistory> list = routingInspectionManager
					.listEpTaskStepHistory(historyTaskId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
