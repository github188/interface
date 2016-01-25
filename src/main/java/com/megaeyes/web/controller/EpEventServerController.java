/**   e.
 * @Title: EpEventSe.erverController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-19 上午5:52:11 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.model.EpEventServer;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpClientGatewayManager;
import com.megaeyes.service.iface.EpEventServerManager;
import com.megaeyes.service.iface.InterConnectManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpEventServerResponse;
import com.megaeyes.web.response.ListEpEventServerResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * @ClassName: EpEventServerController
 * @Description: 事件服务器
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-19 上午5:52:11
 * 
 */
@Controller
public class EpEventServerController extends BaseController {
	@Autowired
	EpEventServerManager epEventServerManager;
	@Autowired
	InterConnectManager interConnectManager;
	@Autowired
	private EpClientGatewayManager epClientGatewayManager;

	/**
	 * @Title: createEpEventServer
	 * @Description: 创建事件服务器
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 *             设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "创建事件服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/createEES.json")
	public void createEpEventServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String installLocation = (String) request
				.getAttribute("installLocation");
		String ip1 = (String) request.getAttribute("ip1");
		String ip2 = (String) request.getAttribute("ip2");
		String note = (String) request.getAttribute("note");
		String portstr = (String) request.getAttribute("port");
		String heartbeatCyclestr = (String) request
				.getAttribute("heartbeatCycle");
		Integer heartbeatCycle = 120;
		String alarmFrequencyString = (String) request
				.getAttribute("alarmFrequency");
		Short alarmFrequency = null;
		if (!StringUtils.isBlank(alarmFrequencyString)) {
			try {
				alarmFrequency = Short.valueOf(alarmFrequencyString);
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("alarmFrequency");
		}
		if (!StringUtils.isBlank(heartbeatCyclestr)) {
			try {
				heartbeatCycle = Integer.parseInt(heartbeatCyclestr);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		Long port = null;
		if (StringUtils.isNotBlank(portstr)) {
			try {
				port = Long.parseLong(portstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("port");
			}
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = epEventServerManager.createEpEventServer(name,
						naming, deviceNumber, installLocation, ip1, ip2, note,
						port, heartbeatCycle, alarmFrequency);
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
	 * @Title: deleteEpEventServer
	 * @Description: 删除事件服务器
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除事件服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEES.json")
	public void deleteEpEventServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			epEventServerManager.deleteEpEventServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	/**
	 * @Title: listAccessServer
	 * @Description: 返回事件服务器列表
	 * @param @param request
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "事件服务器列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listEES.json")
	public void listAccessServer(HttpServletRequest request,
			HttpServletResponse response) {
		ListEpEventServerResponse resp = new ListEpEventServerResponse();
		try {
			List<EpEventServer> ees = epEventServerManager.listEpEventServer();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpEventServer(ees);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: getEpEventServerById
	 * @Description: 根据ID查询事件服务器
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据ID查询事件服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/getEES.json")
	public void getEpEventServerById(HttpServletRequest request,
			HttpServletResponse response) {
		EpEventServerResponse resp = new EpEventServerResponse();
		String id = (String) request.getAttribute("id");
		try {
			EpEventServer ees = epEventServerManager.getByEpEventServerId(id);
			resp.setCode(ErrorCode.SUCCESS);
			if (ees != null) {
				resp.setName(ees.getName());
				resp.setDeviceNumber(ees.getDeviceNumber());
				resp.setId(ees.getId());
				resp.setInstallLocation(ees.getInstallLocation());
				resp.setIp1(ees.getIp1());
				resp.setIp2(ees.getIp2());
				resp.setNaming(ees.getNaming());
				resp.setNote(ees.getNote());
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: updateEpEventServer
	 * @Description: 更新事件服务器
	 * @param request
	 * @param response
	 * @param @throws UnsupportedEncodingException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "更新事件服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/updateEES.json")
	public void updateEpEventServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String installLocation = (String) request
				.getAttribute("installLocation");
		String ip1 = (String) request.getAttribute("ip1");
		String ip2 = (String) request.getAttribute("ip2");
		String note = (String) request.getAttribute("note");
		String heartbeatCyclestr = (String) request
				.getAttribute("heartbeatCycle");
		String alarmFrequencyString = (String) request
				.getAttribute("alarmFrequency");
		Short alarmFrequency = null;
		if (!StringUtils.isBlank(alarmFrequencyString)) {
			try {
				alarmFrequency = Short.valueOf(alarmFrequencyString);
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			}
		} else {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("alarmFrequency");
		}
		Integer heartbeatCycle = null;
		if (!StringUtils.isBlank(heartbeatCyclestr)) {
			try {
				heartbeatCycle = Integer.parseInt(heartbeatCyclestr);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		String portstr = (String) request.getAttribute("port");
		Long port = null;
		if (StringUtils.isNotBlank(portstr)) {
			try {
				port = Long.parseLong(portstr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("port");
			}
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				epEventServerManager.updateEpEventServer(id, name, naming,
						deviceNumber, installLocation, ip1, ip2, note, port,
						heartbeatCycle, alarmFrequency);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "事件服务器注册", isLog = false, isCheckSession = false)
	@RequestMapping("/eventServerRegister.xml")
	public void eventServerRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		EpEventServer epEventServer = null;
		String deviceNumber = request.getParameter("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}
		String ip1 = request.getParameter("lanIp");
		if (StringUtils.isBlank(ip1)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [lanIp] !");
		}
		String ip2 = request.getParameter("wanIp");

		String portstr = request.getParameter("port");
		Long port = null;
		if (!StringUtils.isBlank(portstr)) {
			try {
				port = Long.valueOf(portstr);
			} catch (NumberFormatException e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [port=" + portstr + "] invalid !");
			}
		} else {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [port] !");
		}
		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				epEventServer = epEventServerManager.eventServerRegister(
						deviceNumber, ip1, ip2, port);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e.getMessage());
			}
		}
		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}
		Element epEventServerElement = new Element("EventServer");
		epEventServerElement.setAttribute("Id", epEventServer == null ? ""
				: epEventServer.getId());
		epEventServerElement.setAttribute("HeartbeatCycle",
				epEventServer == null ? "" : epEventServer.getHeartbeatCycle()
						.toString());
		epEventServerElement.setAttribute("AlarmFrequency",
				epEventServer == null ? "" : epEventServer.getAlarmFrequency()
						.toString());
		root.addContent(epEventServerElement);

		writePageWithContentLength(response, doc);

	}
	
	@ControllerDescription(description = "获取客户端网关信息", isLog = false, isCheckSession = false)
	@RequestMapping("/listClientGateway.xml")
	public void listClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseXMLResponse resp = new BaseXMLResponse();
		List<EpClientGateway> list = new ArrayList<EpClientGateway>();
		try {
			list = epClientGatewayManager.listEpClientGateway();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setReason(e.getMessage());
			resp.setSuccess(BaseXMLResponse.FAIL);
		}
		
		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		if (!BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			Element reason = new Element("Reason");
			reason.setText(resp.getReason());
			root.addContent(reason);
		}
		Element clientGateways = new Element("ClientGateways");
		root.addContent(clientGateways);
		for (EpClientGateway ecg : list){
			if (StringUtils.isBlank(ecg.getIp1()) || null == ecg.getPort()){
				continue;
			}
			Element item = new Element("Item");
			item.setAttribute("Id", ecg.getId());
			item.setAttribute("LanIp", ecg.getIp1());
			item.setAttribute("Port", ecg.getPort().toString());
			clientGateways.addContent(item);
		}
		
		writePageWithContentLength(response, doc);
	}
}
