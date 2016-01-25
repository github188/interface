package com.megaeyes.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.IvuTask;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.IvuTaskManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.IVMResponse;
import com.megaeyes.web.response.IvuTaskResponse;

@Controller
public class IvuTaskController extends BaseController {
	@Autowired
	IvuTaskManager ivuTaskManager;

	@ControllerDescription(description = "创建智能监控", isLog = true, isCheckSession = true)
	@RequestMapping("/createIvuTask.json")
	public void createIvuTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String ivuTaskIdString = request.getParameter("ivuTaskId");
		BigDecimal ivuTaskId = null;
		if (!StringUtils.isBlank(ivuTaskIdString)) {
			try {
				ivuTaskId = new BigDecimal(ivuTaskIdString);
			} catch (Exception e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("ivuTaskId");
			}
		}
		String cmsAccount = request.getParameter("cmsAccount");
		String taskId = request.getParameter("taskId");
		String cmsAccountPassword = request.getParameter("cmsAccountPassword");
		String ivuCode = request.getParameter("ivuCode");
		String algCodeString = request.getParameter("algCode");
		Long algCode = null;
		if (!StringUtils.isBlank(algCodeString)) {
			try {
				algCode = Long.valueOf(algCodeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("ivuTaskId");
			}
		}
		String algSupplierCodeString = request.getParameter("algSupplierCode");
		Long algSupplierCode = null;
		if (!StringUtils.isBlank(algSupplierCodeString)) {
			try {
				algSupplierCode = Long.valueOf(algSupplierCodeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("algSupplierCode");
			}
		}
		String videoSourceString = request.getParameter("videoSource");
		Long videoSource = null;
		if (!StringUtils.isBlank(videoSourceString)) {
			try {
				videoSource = Long.valueOf(videoSourceString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("videoSource");
			}
		}
		String rtsp = request.getParameter("rtsp");
		String http = request.getParameter("http");
		String customerUserName = request.getParameter("customerUserName");
		String customerUserPassword = request
				.getParameter("customerUserPassword");
		String cmsIp = request.getParameter("cmsIp");
		String cmsPortString = request.getParameter("cmsPort");
		Long cmsPort = null;
		if (!StringUtils.isBlank(cmsPortString)) {
			try {
				cmsPort = Long.valueOf(cmsPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("cmsPort");
			}
		}
		String cmsGuid = request.getParameter("cmsGuid");
		String resultUpTypeString = request.getParameter("resultUpType");
		Long resultUpType = null;
		if (!StringUtils.isBlank(resultUpTypeString)) {
			try {
				resultUpType = Long.valueOf(resultUpTypeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("resultUpType");
			}
		}
		String resultUpUrl = request.getParameter("resultUpUrl");
		String resultUpIp = request.getParameter("resultUpIp");
		String resultUpPortString = request.getParameter("resultUpPort");
		Long resultUpPort = null;
		if (!StringUtils.isBlank(resultUpPortString)) {
			try {
				resultUpPort = Long.valueOf(resultUpPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("resultUpPort");
			}
		}
		String picDataUpIp = request.getParameter("picDataUpIp");
		String picDataUpPortString = request.getParameter("picDataUpPort");

		Long picDataUpPort = null;
		if (!StringUtils.isBlank(picDataUpPortString)) {
			try {
				picDataUpPort = Long.valueOf(picDataUpPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("picDataUpPort");
			}
		}
		String algPolicy = request.getParameter("algPolicy");
		String taskStatus = request.getParameter("taskStatus");
		String actionType = request.getParameter("actionType");
		String cameraId = request.getParameter("cameraId");
		String organId = request.getParameter("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = ivuTaskManager.createIvuTask(ivuTaskId, cmsAccount,
						taskId, cmsAccountPassword, ivuCode, algCode,
						algSupplierCode, videoSource, rtsp, http,
						customerUserName, customerUserPassword, cmsIp, cmsPort,
						cmsGuid, resultUpType, resultUpUrl, resultUpIp,
						resultUpPort, picDataUpIp, picDataUpPort, algPolicy,
						taskStatus, actionType, cameraId, organId);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除智能监控", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteIvuTask.json")
	public void deleteIvuTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = request.getParameter("id");
		if (StringUtils.isBlank(id)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("id");
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				ivuTaskManager.deleteIvuTask(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询智能监控", isLog = true, isCheckSession = true)
	@RequestMapping("/listIvuTask.json")
	public void listIvuTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		IvuTaskResponse resp = new IvuTaskResponse();
		String organId = request.getParameter("organId");
		if (StringUtils.isBlank(organId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("organId");
		}
		resp.setCode(ErrorCode.SUCCESS);
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<IvuTask> list = ivuTaskManager.listIvuTask(organId);
				resp.setList(list);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新智能监控", isLog = true, isCheckSession = true)
	@RequestMapping("/updateIvuTask.json")
	public void updateIvuTask(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = request.getParameter("id");
		String ivuTaskIdString = request.getParameter("ivuTaskId");
		BigDecimal ivuTaskId = null;
		if (!StringUtils.isBlank(ivuTaskIdString)) {
			try {
				ivuTaskId = new BigDecimal(ivuTaskIdString);
			} catch (Exception e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("ivuTaskId");
			}
		}
		String cmsAccount = request.getParameter("cmsAccount");
		String taskId = request.getParameter("taskId");
		String cmsAccountPassword = request.getParameter("cmsAccountPassword");
		String ivuCode = request.getParameter("ivuCode");
		String algCodeString = request.getParameter("algCode");
		Long algCode = null;
		if (!StringUtils.isBlank(algCodeString)) {
			try {
				algCode = Long.valueOf(algCodeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("ivuTaskId");
			}
		}
		String algSupplierCodeString = request.getParameter("algSupplierCode");
		Long algSupplierCode = null;
		if (!StringUtils.isBlank(algSupplierCodeString)) {
			try {
				algSupplierCode = Long.valueOf(algSupplierCodeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("algSupplierCode");
			}
		}
		String videoSourceString = request.getParameter("videoSource");
		Long videoSource = null;
		if (!StringUtils.isBlank(videoSourceString)) {
			try {
				videoSource = Long.valueOf(videoSourceString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("videoSource");
			}
		}
		String rtsp = request.getParameter("rtsp");
		String http = request.getParameter("http");
		String customerUserName = request.getParameter("customerUserName");
		String customerUserPassword = request
				.getParameter("customerUserPassword");
		String cmsIp = request.getParameter("cmsIp");
		String cmsPortString = request.getParameter("cmsPort");
		Long cmsPort = null;
		if (!StringUtils.isBlank(cmsPortString)) {
			try {
				cmsPort = Long.valueOf(cmsPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("cmsPort");
			}
		}
		String cmsGuid = request.getParameter("cmsGuid");
		String resultUpTypeString = request.getParameter("resultUpType");
		Long resultUpType = null;
		if (!StringUtils.isBlank(resultUpTypeString)) {
			try {
				resultUpType = Long.valueOf(resultUpTypeString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("resultUpType");
			}
		}
		String resultUpUrl = request.getParameter("resultUpUrl");
		String resultUpIp = request.getParameter("resultUpIp");
		String resultUpPortString = request.getParameter("resultUpPort");
		Long resultUpPort = null;
		if (!StringUtils.isBlank(resultUpPortString)) {
			try {
				resultUpPort = Long.valueOf(resultUpPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("resultUpPort");
			}
		}
		String picDataUpIp = request.getParameter("picDataUpIp");
		String picDataUpPortString = request.getParameter("picDataUpPort");

		Long picDataUpPort = null;
		if (!StringUtils.isBlank(picDataUpPortString)) {
			try {
				picDataUpPort = Long.valueOf(picDataUpPortString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("picDataUpPort");
			}
		}
		String algPolicy = request.getParameter("algPolicy");
		String taskStatus = request.getParameter("taskStatus");
		String actionType = request.getParameter("actionType");
		String cameraId = request.getParameter("cameraId");
		String organId = request.getParameter("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				ivuTaskManager.updateIvuTask(id, ivuTaskId, cmsAccount, taskId,
						cmsAccountPassword, ivuCode, algCode, algSupplierCode,
						videoSource, rtsp, http, customerUserName,
						customerUserPassword, cmsIp, cmsPort, cmsGuid,
						resultUpType, resultUpUrl, resultUpIp, resultUpPort,
						picDataUpIp, picDataUpPort, algPolicy, taskStatus,
						actionType, cameraId, organId);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "获取初始化智能监控部分信息", isLog = true, isCheckSession = true)
	@RequestMapping("/getIVMNews.json")
	public void getIVMNews(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		IVMResponse resp = new IVMResponse();
		InputStream in = null;
		try {
			String filePath = "/WEB-INF/ivm.properties";
			// 把文件读入文件输入流

			System.out.println(request.getSession().getServletContext()
					.getRealPath("")
					+ filePath);
			FileInputStream inputStream = new FileInputStream(new File(request
					.getSession().getServletContext().getRealPath("")
					+ filePath));
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("--------------:"
					+ properties.getProperty("ivm.account"));
			String ivmAccount = properties.getProperty("ivm.account");
			String ivmAccountPwd = properties.getProperty("ivm.account.pwd");
			String cmsIp = properties.getProperty("cms_ip");
			String cmsPort = properties.getProperty("cms_port");
			String imageUrl = properties.getProperty("ivu.image.url");
			resp.setCode(ErrorCode.SUCCESS);
			resp.setIvmAccount(ivmAccount);
			resp.setIvmAccountPwd(ivmAccountPwd);
			resp.setCmsIp(cmsIp);
			resp.setCmsPort(cmsPort);
			resp.setImageUrl(imageUrl);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		writePageNoZip(response, resp);
	}
}
