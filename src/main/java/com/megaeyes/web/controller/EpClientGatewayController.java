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

import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.EpClientGateway;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.vo.ClientGatewayHeartbeatVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpClientGatewayManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpClientGatewayResponse;
import com.megaeyes.web.response.GetEpClientGatewayResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;
import com.megaeyes.web.response.xml.GetDoorNotifyUsersResponse;
import com.megaeyes.web.response.xml.ListCenterDeviceInfoResponse;
import com.megaeyes.web.response.xml.GetDoorNotifyUsersResponse.User;

/**
 * EpClientGatewayController(类说明)
 * 
 * @author tangjianyang tangjianyang@megaeyes.com
 *         <p />
 *         2012-12-27 下午3:48:48
 */
@Controller
public class EpClientGatewayController extends BaseController {
	@Autowired
	EpClientGatewayManager epClientGatewayManager;

	@ControllerDescription(description = "创建客户端网管", isLog = true, isCheckSession = true)
	@RequestMapping("/createEpClientGateway.json")
	public void createEpClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip1 = (String) request.getAttribute("ip1");
		String ip2 = (String) request.getAttribute("ip2");
		String naming = (String) request.getAttribute("naming");
		String portstr = (String) request.getAttribute("port");
		String heartbeatCyclestr = (String) request
				.getAttribute("heartbeatCycle");
		Integer heartbeatCycle = null;
		if (StringUtils.isNotBlank(heartbeatCyclestr)) {
			try {
				heartbeatCycle = Integer.parseInt(heartbeatCyclestr);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartbeatCycle");
			}
		}

		String address = (String) request.getAttribute("address");

		Long port = null;
		if (portstr != null) {
			port = Long.parseLong(portstr);
		}
		String note = (String) request.getAttribute("note");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = epClientGatewayManager.createEpClientGateway(name,
						deviceNumber, ip1, ip2, naming, port, note,
						heartbeatCycle, address);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除客户端网管", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEpClientGateway.json")
	public void deleteEpClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			epClientGatewayManager.deleteEpClientGateway(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询客户端网管列表", isLog = true, isCheckSession = true)
	@RequestMapping("/listEpClientGateway.json")
	public void listEpClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		EpClientGatewayResponse resp = new EpClientGatewayResponse();

		try {
			List<EpClientGateway> list = epClientGatewayManager
					.listEpClientGateway();
			resp.setEpClientGateway(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询客户端网管详细信息", isLog = true, isCheckSession = true)
	@RequestMapping("/getEpClientGateway.json")
	public void getEpClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		GetEpClientGatewayResponse resp = new GetEpClientGatewayResponse();

		String id = (String) request.getAttribute("id");
		try {
			EpClientGateway ecg = epClientGatewayManager.getEpClientGateway(id);
			resp.setEpClientGateway(ecg);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "修改客户端网管", isLog = true, isCheckSession = true)
	@RequestMapping("/updateEpClientGateway.json")
	public void updateEpClientGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip1 = (String) request.getAttribute("ip1");
		String ip2 = (String) request.getAttribute("ip2");
		String naming = (String) request.getAttribute("naming");
		String portstr = (String) request.getAttribute("port");
		Long port = null;
		if (portstr != null) {
			port = Long.parseLong(portstr);
		}
		String heartbeatCyclestr = (String) request
				.getAttribute("heartbeatCycle");
		Integer heartbeatCycle = null;
		if (StringUtils.isNotBlank(heartbeatCyclestr)) {
			try {
				heartbeatCycle = Integer.parseInt(heartbeatCyclestr);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartbeatCycle");
			}
		}

		String address = (String) request.getAttribute("address");

		String note = (String) request.getAttribute("note");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				epClientGatewayManager.updateEpClientGateway(id, name,
						deviceNumber, ip1, ip2, naming, port, note,
						heartbeatCycle, address);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "注册客户端网管", isLog = true, isCheckSession = false)
	@RequestMapping("/clientGatewayRegister.xml")
	public void clientGatewayRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseXMLResponse resp = new BaseXMLResponse();
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String lanIp = (String) request.getAttribute("lanIp");
		String wanIp = (String) request.getAttribute("wanIp");
		String portstr = (String) request.getAttribute("port");
		String textStr = null;
		String code = "Y";
		if (StringUtils.isBlank(deviceNumber)) {
			textStr = "deviceNumber not found!";
			code = "N";
		}
		if (StringUtils.isBlank(lanIp)) {
			textStr = "lanIp not found!";
			code = "N";
		}
		if (StringUtils.isBlank(wanIp)) {
			textStr = "wanIp not found!";
			code = "N";
		}
		if (StringUtils.isBlank(portstr)) {
			textStr = "port not found!";
			code = "N";
		}
		Long port = null;
		if (portstr != null) {
			port = Long.parseLong(portstr);
		}
		List<EpClientGateway> list = null;
		if (code.equals("Y")) {
			try {
				list = epClientGatewayManager.clientGatewayRegister(
						deviceNumber, lanIp, wanIp, port);
				if (list.isEmpty()) {
					textStr = "not found data!";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.EXCEPTION);
			}
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(code);
		root.addContent(success);
		Element reason = new Element("Reason");
		reason.setText(textStr);
		root.addContent(reason);
		Element HearbeatCycle = new Element("HearbeatCycle");

		if (code.equals("Y")) {
			if (list.size() > 0) {
				for (EpClientGateway es : list) {
					HearbeatCycle.setText(es.getHeartbeatCycle().toString());

				}
			}
		}
		root.addContent(HearbeatCycle);
		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取中心服务器信息", isLog = true, isCheckSession = false)
	@RequestMapping("/listCenterDeviceInfo.xml")
	public void listCenterDeviceInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ListCenterDeviceInfoResponse resp = new ListCenterDeviceInfoResponse();
		try {
			List<AccessServer> as = epClientGatewayManager.listAccessServer();
			List<ListCenterDeviceInfoResponse.AccessServerXml> accessServers = new ArrayList<ListCenterDeviceInfoResponse.AccessServerXml>();
			for (AccessServer accs : as) {
				ListCenterDeviceInfoResponse.AccessServerXml AccessServer = resp.new AccessServerXml();
				AccessServer.setId(accs.getId());
				AccessServer.setIp(accs.getIp());
				AccessServer.setPort("6001");// 数据库没有port设置一个默认的
				accessServers.add(AccessServer);
			}
			resp.setAccessServer(accessServers);

			List<AcGateway> ag = epClientGatewayManager.listAcGateway();
			List<ListCenterDeviceInfoResponse.AcGatewayXml> acGateways = new ArrayList<ListCenterDeviceInfoResponse.AcGatewayXml>();
			for (AcGateway acway : ag) {
				ListCenterDeviceInfoResponse.AcGatewayXml acGateway = resp.new AcGatewayXml();
				acGateway.setId(acway.getId());
				acGateway.setIp(acway.getLanIp());
				acGateway.setPort(acway.getPort().toString());
				acGateways.add(acGateway);
			}
			resp.setAcGateway(acGateways);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(BaseXMLResponse.EXCEPTION);
		}
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);
		Element reason = new Element("reason");
		reason.setText("");
		root.addContent(reason);

		Element AccessListElement = new Element("AccessList");
		for (ListCenterDeviceInfoResponse.AccessServerXml accXml : resp
				.getAccessServer()) {
			if(accXml.equals(null)){
				break;
			}
			Element AccessElement = new Element("Item");
			AccessElement.setAttribute("Id", accXml.getId()+"");
			AccessElement.setAttribute("Ip", accXml.getIp()+"");
			AccessElement.setAttribute("Port", accXml.getPort()+"");
			AccessListElement.addContent(AccessElement);
		}
		root.addContent(AccessListElement);
		Element doorGatewayListElement = new Element("DoorGatewayList");
		for (ListCenterDeviceInfoResponse.AcGatewayXml doorXml : resp
				.getAcGateway()) {
			if(doorXml.equals(null)){
				break;
			}
			Element doorElement = new Element("Item");
			doorElement.setAttribute("Id", doorXml.getId()+"");
			doorElement.setAttribute("Ip", doorXml.getIp()+"");
			doorElement.setAttribute("Port", doorXml.getPort()+"");
			doorGatewayListElement.addContent(doorElement);
		}
		root.addContent(doorGatewayListElement);

		writePageWithContentLength(response, doc);

	}

	@ControllerDescription(description = "心跳", isLog = true, isCheckSession = false)
	@RequestMapping("/clientGatewayHeartbeat.xml")
	public void clientGatewayHeartbeat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseXMLResponse resp = new BaseXMLResponse();
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String code;
		ClientGatewayHeartbeatVO cgh = null;
		try {
			cgh = epClientGatewayManager.clientGatewayHeartbeat(deviceNumber);
			code = "Y";
		} catch (Exception e) {
			e.printStackTrace();
			code = "N";
			resp.setSuccess(BaseXMLResponse.EXCEPTION);
		}
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(code);
		root.addContent(success);
		Element reason = new Element("Reason");

		root.addContent(reason);
		Element scheme = new Element("CenterDevicesLastUpdateTime");
		if (!cgh.equals(null)) {
			scheme.setText(cgh.getCenterDevicesLastUpdateTime());
		}
		root.addContent(scheme);
		writePageWithContentLength(response, doc);
	}
}
