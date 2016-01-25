/**   
 * @Title: ACGatewayController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-14 下午4:21:54 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.model.AcAccessServers;
import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessServersManager;
import com.megaeyes.service.iface.AccessControllerManager;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AcGatewayResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.GetAcGatewayResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * @ClassName: ACGatewayController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-14 下午4:21:54
 * 
 */
@Controller
public class ACGatewayController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;
	@Autowired
	AccessControllerManager accessControllerManager;
	@Autowired
	AcAccessServersManager acAccessServersManager;

	@ControllerDescription(description = "创建门禁网关",isLog=true,isCheckSession=true)
	@RequestMapping("/createACGateway.json")
	public void createACGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String name = (String) request.getAttribute("name");
		String lanIp = (String) request.getAttribute("lanIp");
		String wanIp = (String) request.getAttribute("wanIp");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String naming = (String) request.getAttribute("naming");
		String portstr = (String) request.getAttribute("port");
		Integer port = null;
		if (!StringUtils.isBlank(portstr)) {
			try {
				port = Integer.parseInt(portstr);
			} catch (Exception e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("port");
			}
		}
		String organId = (String) request.getAttribute("organId");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = centerDeviceManager.createACGateway(name, lanIp,
						wanIp, installLocation, note, naming, port, organId,
						deviceNumber);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除门禁网管",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteACGateway.json")
	public void deleteACGateway(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			centerDeviceManager.deleteACGateway(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询所有门禁网管",isLog=false,isCheckSession=true)
	@RequestMapping("/listAcGateway.json")
	public void listAcGateway(HttpServletRequest request,
			HttpServletResponse response) {
		AcGatewayResponse resp = new AcGatewayResponse();
		try {
			List<AcGateway> list = centerDeviceManager.listAcGateway();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据ID查询门禁网管",isLog=false,isCheckSession=true)
	@RequestMapping("/getAcGateway.json")
	public void getAcGateway(HttpServletRequest request,
			HttpServletResponse response) {
		GetAcGatewayResponse resp = new GetAcGatewayResponse();
		String id = (String) request.getAttribute("id");
		try {

			AcGateway acGateway = centerDeviceManager.getAcGateway(id);
			resp.setId(acGateway.getId());
			resp.setDeviceNumber(acGateway.getDeviceNumber());
			resp.setInstallLocation(acGateway.getInstallLocation());
			resp.setLanIp(acGateway.getLanIp());
			resp.setName(acGateway.getName());
			resp.setNaming(acGateway.getNaming());
			resp.setNote(acGateway.getNote());
			resp.setOrganId(acGateway.getOrganId());
			resp.setPort(acGateway.getPort());
			resp.setWanIp(acGateway.getWanIp());
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新门禁网关",isLog=false,isCheckSession=true)
	@RequestMapping("/updateACGateway.json")
	public void updateACGateway(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");

		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String lanIp = (String) request.getAttribute("lanIp");
		String wanIp = (String) request.getAttribute("wanIp");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String naming = (String) request.getAttribute("naming");
		String portstr = (String) request.getAttribute("port");
		Integer port = null;
		if (!StringUtils.isBlank(portstr)) {
			try {
				port = Integer.parseInt(portstr);
			} catch (Exception e) {
				resp.setCode(ErrorCode.AC_PARAMETER_INVALID);
				resp.setMessage("port");
			}
		}
		String organId = (String) request.getAttribute("organId");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				centerDeviceManager.updateACGateway(id, name, lanIp, wanIp, installLocation, note, naming, port, organId, deviceNumber);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "门禁网关注册",isLog=false,isCheckSession=false)
	@RequestMapping("/EntranceAccessRegister")
	public void entranceAccessRegister(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("in entranceAccessRegister interface...");
		request.setCharacterEncoding("UTF-8");
		// 取参数
		String xmlParam = request.getParameter("xml");
		if (StringUtils.isBlank(xmlParam)) {
			System.out.println("need xml parameter");
			return;
		}
		try {
			SAXBuilder sb = new SAXBuilder(false);
			StringReader read = new StringReader(xmlParam);
			Document doc = sb.build(read);
			Element root = doc.getRootElement();
			String deviceNumber = root.getChild("Device").getAttributeValue(
					"DeviceId");
			AcGateway gateway = centerDeviceManager
					.getAcGatewayByDeviceNumber(deviceNumber);
			if (gateway == null) {
				return;
			}
			String gatewayId = gateway.getId();
			List<AcAccessServers> servers = acAccessServersManager
					.listAcAccessServersByGatewayId(gatewayId);
			System.out.println(servers.size());
			List<AcAccessControls> doors = accessControllerManager
					.listAcAccessControlByGatewayId(gatewayId);

			Document xml = new Document();
			Element respRoot = new Element("Message");
			xml.setRootElement(respRoot);
			for (AcAccessServers server : servers) {

				Element device = new Element("Device");
				device.setAttribute("Id", server.getId());
				device.setAttribute("Naming", server.getNaming());
				device.setAttribute("Type", server.getDeviceType());
				device.setAttribute("IP", server.getIp());
				device.setAttribute("Port", server.getMessagePort().toString());
				device.setAttribute("SubAddr", server.getSubaddr().toString());
				for (AcAccessControls door : doors) {

					if (door.getAccessServerId().equals(server.getId())) {
						Element channel = new Element("Channel");
						channel.setAttribute("Naming", door.getNaming());
						channel.setAttribute("ChannelId", door.getChannelId()
								.toString());
						device.addContent(channel);
					}
				}
				respRoot.addContent(device);
			}
			
			writePageWithContentLength(response, xml);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
