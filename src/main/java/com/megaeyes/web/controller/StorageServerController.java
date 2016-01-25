/**   
 * @Title: StorageServerController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-2-29 下午2:22:02 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.vo.ListRemoteStorageServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListStorageServerResponse;

/**
 * @ClassName: StorageServerController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-2-29 下午2:22:02
 * 
 */
@Controller
public class StorageServerController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: createStorageServer
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "创建存储服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/createStorageServer.json")
	public void createStorageServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String stdId = (String) request.getAttribute("stdId");
		String ip = (String) request.getAttribute("ip");
		String ip2 = (String) request.getAttribute("ip2");
		String location = (String) request.getAttribute("location");
		String heartCyclestr = (String) request.getAttribute("heartCycle");
		long heartCycle = 120;
		if (!StringUtils.isBlank(heartCyclestr)) {
			try {
				heartCycle = Long.parseLong(heartCyclestr);
			} catch (NumberFormatException e1) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("heartCycle");
			}
		}
		String linkType = (String) request.getAttribute("linkType");
		String maxInputAmountstr = (String) request.getAttribute("maxInputAmount");
		long maxInputAmount = 50;
		if (!StringUtils.isBlank(maxInputAmountstr)) {
			try {
				maxInputAmount = Long.parseLong(maxInputAmountstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("maxInputAmount");
			}
		}
		String maxOutputAmountstr = (String) request.getAttribute("maxOutputAmount");
		long maxOutputAmount = 100;
		if (!StringUtils.isBlank(maxOutputAmountstr)) {
			try {
				maxOutputAmount = Long.parseLong(maxOutputAmountstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("maxOutputAmount");
			}
		}
		String ftpPortstr = (String) request.getAttribute("ftpPort");
		long ftpPort = 21;
		if (!StringUtils.isBlank(ftpPortstr)) {
			try {
				ftpPort = Long.parseLong(ftpPortstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("ftpPort");
			}
		}
		String ftpUserName = (String) request.getAttribute("ftpUserName");
		String ftpPassword = (String) request.getAttribute("ftpPassword");
		String messagePortstr = (String) request.getAttribute("messagePort");
		long messagePort = 80;
		if (!StringUtils.isBlank(messagePortstr)) {
			try {
				messagePort = Long.parseLong(messagePortstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("messagePort");
			}
		}
		String note = (String) request.getAttribute("note");
		String hasVodstr = (String) request.getAttribute("hasVod");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		boolean hasVod = "1".equals(hasVodstr);
		try {
			String id = centerDeviceManager.createStorageServer(name,
					deviceNumber, stdId, ip, ip2, location, heartCycle,
					linkType, maxInputAmount, maxOutputAmount, ftpPort,
					ftpUserName, ftpPassword, messagePort, note, hasVod,
					epDeviceType);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException e) {
			resp.setCode(e.getCode());
			resp.setMessage(e.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除存储服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteStorageServer.json")
	public void deleteStorageServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("storageServerId");
		try {
			centerDeviceManager.deleteStorageServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException e) {
			resp.setCode(e.getCode());
			resp.setMessage(e.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询远程存储服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/listRSS.json")
	public void ListStorageServer(HttpServletRequest request,
			HttpServletResponse response) {
		ListStorageServerResponse resp = new ListStorageServerResponse();
		try {
			List<ListRemoteStorageServerVO> list = centerDeviceManager
					.ListStorageServer();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException e) {
			resp.setCode(e.getCode());
			resp.setMessage(e.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新存储服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/updateStorageServer.json")
	public void updateStorageServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String isLocalstr = (String) request.getAttribute("isLocal");
		boolean isLocal = "true".equals(isLocalstr) ? true : false;
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String stdId = (String) request.getAttribute("stdId");
		String ip = (String) request.getAttribute("ip");
		String ip2 = (String) request.getAttribute("ip2");
		String location = (String) request.getAttribute("location");
		String heartCyclestr = (String) request.getAttribute("heartCycle");
		long heartCycle = 120;
		if (!StringUtils.isBlank(heartCyclestr)) {
			try {
				heartCycle = Long.parseLong(heartCyclestr);
			} catch (NumberFormatException e1) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("heartCycle");
			}
		}
		String linkType = (String) request.getAttribute("linkType");
		String maxInputAmountstr = (String) request.getAttribute("maxInputAmount");
		long maxInputAmount = 50;
		if (!StringUtils.isBlank(maxInputAmountstr)) {
			try {
				maxInputAmount = Long.parseLong(maxInputAmountstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("maxInputAmount");
			}
		}
		String maxOutputAmountstr = (String) request.getAttribute("maxOutputAmount");
		long maxOutputAmount = 100;
		if (!StringUtils.isBlank(maxOutputAmountstr)) {
			try {
				maxOutputAmount = Long.parseLong(maxOutputAmountstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("maxOutputAmount");
			}
		}

		String ftpPortstr = (String) request.getAttribute("ftpPort");
		long ftpPort = 21;
		if (!StringUtils.isBlank(ftpPortstr)) {
			try {
				ftpPort = Long.parseLong(ftpPortstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("ftpPort");
			}
		}
		String ftpUserName = (String) request.getAttribute("ftpUserName");
		String ftpPassword = (String) request.getAttribute("ftpPassword");
		String messagePortstr = (String) request.getAttribute("messagePort");
		long messagePort = 80;
		if (!StringUtils.isBlank(messagePortstr)) {
			try {
				messagePort = Long.parseLong(messagePortstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("messagePort");
			}
		}
		String note = (String) request.getAttribute("note");
		String hasVodstr = (String) request.getAttribute("hasVod");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String IsVirtualIpstr = (String) request.getAttribute("isVirtualIp");
		BigDecimal isVirtualIp = null;
		if (!StringUtils.isBlank(IsVirtualIpstr)) {
			try {
				isVirtualIp = new BigDecimal(IsVirtualIpstr);
			} catch (Exception e1) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("isVirtualIp");
			}
		}
		boolean hasVod = "1".equals(hasVodstr);
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				centerDeviceManager.updateStorageServer(id, name, deviceNumber,
						stdId, ip, ip2, location, heartCycle, linkType,
						maxInputAmount, maxOutputAmount, ftpPort, ftpUserName,
						ftpPassword, messagePort, hasVod, note, isLocal,
						epDeviceType, isVirtualIp);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException e) {
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
}
