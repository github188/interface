/**   
 * @Title: DispatchServerController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-2 上午2:05:42 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.utils.StdIdGenerator;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.DispatchServerResponse;
import com.megaeyes.web.response.ListDispatchServerResponse;

/**
 * @ClassName: DispatchServerController
 * @Description: 分发服务器
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-2 上午2:05:42
 * 
 */
@Controller
public class DispatchServerController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: createDispatchServer
	 * @Description: 创建分发服务器
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "创建分发服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/createDS.json")
	public void createDispatchServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		// System.out.println("-----------"+name);
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String stdId = StdIdGenerator.getStdId();// 自动生成 stdId
		Long heartCycle = (long) 120;
		String location = (String) request.getAttribute("location");

		Long maxInputAmount = (long) 50;
		String mia = (String) request.getAttribute("maxInput");
		if (!StringUtils.isBlank(mia)) {
			try {
				maxInputAmount = Long.parseLong(mia);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxInput");
			}
		}

		Long maxOutputAmount = (long) 100;
		String moa = (String) request.getAttribute("maxOutput");
		if (!StringUtils.isBlank(moa)) {
			try {
				maxOutputAmount = Long.parseLong(moa);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxOutput");
			}
		}

		Long msgPort = (long) 0;
		String mp = (String) request.getAttribute("msgPort");
		if (!StringUtils.isBlank(mp)) {
			try {
				msgPort = Long.parseLong(mp);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("msgPort");
			}
		}

		String note = (String) request.getAttribute("note");

		Long reservedOutputAmount = (long) 10;
		String roa = (String) request.getAttribute("reserve");
		if (!StringUtils.isBlank(roa)) {
			try {
				reservedOutputAmount = Long.parseLong(roa);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("reserve");
			}
		}

		String ownerShip = "private";
		String ownerShip1 = (String) request.getAttribute("ownerShip");
		if (!StringUtils.isBlank(ownerShip1)) {
			ownerShip = ownerShip1;
		}
		Long videoPort = 4604L;
		String videoPort1 = (String) request.getAttribute("videoPort");
		if (StringUtils.isNotBlank(videoPort1)) {
			try {
				videoPort = Long.parseLong(videoPort1);
			} catch (NumberFormatException n) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("videoPort");
			}
		}

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = centerDeviceManager.createDispatchServer(name,
						naming, deviceNumber, stdId, heartCycle, location,
						maxInputAmount, maxOutputAmount, msgPort, note,
						reservedOutputAmount, ownerShip, videoPort);
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
	 * @throws UnsupportedEncodingException
	 * @Title: deleteDispatchServer
	 * @Description: 删除分发服务器
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除分发服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteDS.json")
	public void deleteDispatchServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// System.out.println("in deleteDispatchServer ................");
		BaseResponse resp = new BaseResponse();

		String id = (String) request.getAttribute("id");
		try {
			centerDeviceManager.deleteDispatchServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: listDispatchServer
	 * @Description: 查询所有的分发服务器
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "查询分发服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/listDS.json")
	public void listDispatchServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ListDispatchServerResponse resp = new ListDispatchServerResponse();

		try {
			List<DispatchServer> responseServers = centerDeviceManager
					.listDispatchServer();
			resp.setServers(responseServers);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: convertModel
	 * @Description:将通过数据库直接查询出来的数据模型转换为网络中需要的传输模型 (DTO)
	 * @param @param servers
	 * @param @return 设定文件
	 * @return List<DispatchServerResponse> 返回类型
	 * @throws
	 */
	/*
	 * 
	 * public List<DispatchServerResponse> convertModel( List<DispatchServer>
	 * servers) { List<DispatchServerResponse> responseServers = new
	 * ArrayList<DispatchServerResponse>(); for (DispatchServer server :
	 * servers) { DispatchServerResponse response = new
	 * DispatchServerResponse(); response.setId(server.getId());
	 * response.setName(server.getfName());
	 * response.setDeviceNumber(server.getDeviceNumber());
	 * response.setInstallLocation(server.getInstallLocation());
	 * response.setIp1(server.getIp()); response.setIp2(server.getIp2());
	 * response.setMaxInputAmount(server.getMaxInputAmount().toString());
	 * response.setMaxOutputAmount(server.getMaxOutputAmount().toString());
	 * response.setReservedOutputAmount(server.getReservedOutputAmount()
	 * .toString()); response.setHeartCycle(server.getHeartCycle().toString());
	 * response.setOwnerShip(server.getOwnerShip());
	 * response.setNote(server.getNote()); responseServers.add(response); }
	 * return responseServers; }
	 */

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: getDispatchServerById
	 * @Description: 获取指定ID的分发服务器信息
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "查询单个分发服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/getDS.json")
	public void getDispatchServerById(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		DispatchServerResponse resp = new DispatchServerResponse();
		String id = (String) request.getAttribute("id");

		try {
			DispatchServer ds = centerDeviceManager.getDispatchServerById(id);
			resp.setCode(ErrorCode.SUCCESS);
			if (ds != null) {
				resp.setId(ds.getId());
				resp.setDeviceNumber(ds.getDeviceNumber());
				resp.setName(ds.getName());
				resp.setInstallLocation(ds.getInstallLocation());
				resp.setIp1(ds.getIp());
				resp.setIp2(ds.getIp2());
				resp.setHeartCycle(ds.getHeartCycle().toString());
				resp.setMaxInputAmount(ds.getMaxInputAmount().toString());
				resp.setMaxOutputAmount(ds.getMaxOutputAmount().toString());
				resp.setReservedOutputAmount(ds.getReservedOutputAmount()
						.toString());
				resp.setOwnerShip(ds.getOwnerShip());
				resp.setNote(ds.getNote());
				resp.setNaming(ds.getNaming());
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @throws UnsupportedEncodingException
	 * @Title: updateDispatchServer
	 * @Description: 更改分发服务器
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "更新分发服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/updateDS.json")
	public void updateDispatchServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String stdId = StdIdGenerator.getStdId();
		String heartCycleString = (String) request.getAttribute("heartCycle");
		Long heartCycle = null;
		if (!StringUtils.isBlank(heartCycleString)) {
			try {
				heartCycle = Long.valueOf(heartCycleString);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		String location = (String) request.getAttribute("location");

		Long maxInputAmount = null;
		String mia = (String) request.getAttribute("maxInput");
		if (!StringUtils.isBlank(mia)) {
			try {
				maxInputAmount = Long.parseLong(mia);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxInput");
			}
		}

		Long maxOutputAmount = null;
		String moa = (String) request.getAttribute("maxOutput");
		if (!StringUtils.isBlank(moa)) {
			try {
				maxOutputAmount = Long.parseLong(moa);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxOutput");
			}
		}

		Long msgPort = null;
		String mp = (String) request.getAttribute("msgPort");
		if (!StringUtils.isBlank(mp)) {
			try {
				msgPort = Long.parseLong(mp);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("msgPort");
			}
		}

		String note = (String) request.getAttribute("note");

		Long reservedOutputAmount = null;
		String roa = (String) request.getAttribute("reserve");
		if (!StringUtils.isBlank(roa)) {
			try {
				reservedOutputAmount = Long.parseLong(roa);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("reserve");
			}
		}

		String ownerShip = (String) request.getAttribute("ownerShip");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				System.out.println(".........................:" + ownerShip);
				centerDeviceManager.updateDispatchServer(id, name, naming,
						deviceNumber, stdId, heartCycle, location,
						maxInputAmount, maxOutputAmount, msgPort, note,
						reservedOutputAmount, ownerShip);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
}
