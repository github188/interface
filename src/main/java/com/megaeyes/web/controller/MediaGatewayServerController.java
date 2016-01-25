package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListMediaGatewayServerResponse;
import com.megaeyes.web.response.MediaGatewayServerResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * 媒体网关controller
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-16 下午03:57:22
 */
@Controller
public class MediaGatewayServerController extends BaseController {
	@Autowired
	private CenterDeviceManager centerDeviceManager;
	@ControllerDescription(description = "媒体网关注册",isLog=false,isCheckSession=false)
	@RequestMapping("/mediaGatewayServerRegister.xml")
	public void mediaGatewayServerRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in mediaGatewayServerRegister.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();
		MediaGatewayServer mediaGatewayServer = null;

		// 取参数
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}

		String lanIp = (String) request.getAttribute("lanIp");
		if (StringUtils.isBlank(lanIp)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [lanIp] !");
		}

		String wanIp = (String) request.getAttribute("wanIp");

		Integer msgPort = null;
		String msgPortString = (String) request.getAttribute("msgPort");
		if (StringUtils.isBlank(msgPortString)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [msgPort] !");
		} else {
			try {
				msgPort = Integer.parseInt(msgPortString);
			} catch (NumberFormatException e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [msgPort=" + msgPortString
						+ "] invalid !");
			}
		}

		Integer heartbeatCycle = null;
		String heartbeatString = (String) request.getAttribute("heartbeat");
		if (StringUtils.isNotBlank(heartbeatString)) {
			try {
				heartbeatCycle = Integer.parseInt(heartbeatString);
			} catch (NumberFormatException e) {
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason("parameter [heartbeat=" + heartbeatString
						+ "] invalid !");
			}
		}

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				mediaGatewayServer = centerDeviceManager
						.mediaGatewayServerRegister(deviceNumber, lanIp, wanIp,
								msgPort, heartbeatCycle);
				// TODO 注册成功，启动心跳验证线程
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

		Element mediaGatewayServerElement = new Element("MediaGatewayServer");
		mediaGatewayServerElement.setAttribute("Id",
				mediaGatewayServer == null ? "" : mediaGatewayServer.getId());
		mediaGatewayServerElement.setAttribute("Heartbeat",
				mediaGatewayServer == null ? "" : mediaGatewayServer
						.getHeartbeatCycle().toString());
		root.addContent(mediaGatewayServerElement);

		writePageWithContentLength(response, doc);
	}
	@ControllerDescription(description = "媒体网关心跳",isLog=false,isCheckSession=false)
	@RequestMapping("/mediaGatewayServerHeartbeat.xml")
	public void mediaGatewayServerHeartbeat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in mediaGatewayServerHeartbeat.xml interface...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		// 取参数
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}

		if (resp.getSuccess().equals(BaseXMLResponse.SUCCESS)) {
			try {
				centerDeviceManager.mediaGatewayServerHeartbeat(deviceNumber);
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

		writePageWithContentLength(response, doc);
	}
	
	/**
	 * 
	 * createMediaGatewayServer 创建媒体网关
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@ControllerDescription(description = "创建媒体网关", isLog = true, isCheckSession = true)
	@RequestMapping("/createMediaGatewayServer.json")
	public void createMediaGatewayServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String deviceNumber = (String)request.getAttribute("deviceNumber");
		String lanIp = (String)request.getAttribute("lanIp");
		String wanIp = (String)request.getAttribute("wanIp");
		Integer msgPort = 4603;
		String msgPort1 = (String)request.getAttribute("msgPort");
		if(StringUtils.isNotBlank(msgPort1)){
			try{
				msgPort = Integer.parseInt(msgPort1);
			}catch(NumberFormatException n){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("msgPort");
			}
		}
		
		Short status = -1;
		String status1 = (String)request.getAttribute("status");
		if(StringUtils.isNotBlank(status1)){
			try{
				status = Short.parseShort(status1);
			}catch(NumberFormatException n){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("status");
			}
		}
		String installLocation = (String)request.getAttribute("installLocation");
		Integer heartbeatCycle = 120;
		String heartbeatCycle1 = (String)request.getAttribute("heartbeatCycle");
		if(StringUtils.isNotBlank(heartbeatCycle1)){
			try{
				heartbeatCycle = Integer.parseInt(heartbeatCycle1);
			}catch(NumberFormatException n){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartbeatCycle");
			}
		}
		String name = (String)request.getAttribute("name");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = centerDeviceManager.createMediaGatewayServer(deviceNumber,
						lanIp,wanIp,msgPort,status,installLocation,heartbeatCycle,name);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * deleteMediaGatewayServer 删除媒体网关
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "删除媒体网关", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteMediaGatewayServer.json")
	public void deleteMediaGatewayServer(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		try{
			centerDeviceManager.deleteMediaGatewayServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * updateMediaGatewayServer 更新媒体网关
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@ControllerDescription(description = "更新媒体网关", isLog = true, isCheckSession = true)
	@RequestMapping("/updateMediaGatewayServer.json")
	public void updateMediaGatewayServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String)request.getAttribute("id");
		String deviceNumber = (String)request.getAttribute("deviceNumber");
		String lanIp = (String)request.getAttribute("lanIp");
		String wanIp = (String)request.getAttribute("wanIp");
		Integer msgPort = null;
		String msgPort1 = (String)request.getAttribute("msgPort");
		if(StringUtils.isNotBlank(msgPort1)){
			try{
				msgPort = Integer.parseInt(msgPort1);
			}catch(NumberFormatException n){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("msgPort");
			}
		}
		String installLocation = (String)request.getAttribute("installLocation");
		Integer heartbeatCycle = null;
		String heartbeatCycle1 = (String)request.getAttribute("heartbeatCycle");
		if(StringUtils.isNotBlank(heartbeatCycle1)){
			try{
				heartbeatCycle = Integer.parseInt(heartbeatCycle1);
			}catch(NumberFormatException n){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartbeatCycle");
			}
		}
		String name = (String)request.getAttribute("name");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				centerDeviceManager.updateMediaGatewayServer(id,deviceNumber,
						lanIp,wanIp,msgPort,installLocation,heartbeatCycle,name);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * getMediaGatewayServerById 根据ID查询媒体网关
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据ID查询媒体网关", isLog = true, isCheckSession = true)
	@RequestMapping("/getMediaGatewayServerById.json")
	public void getMediaGatewayServerById(HttpServletRequest request,
			HttpServletResponse response){
		MediaGatewayServerResponse resp = new MediaGatewayServerResponse();
		String id = (String)request.getAttribute("id");
		try{
			MediaGatewayServer mediaGatewayServer = centerDeviceManager.getMediaGatewayServerById(id);
			if(mediaGatewayServer!=null){
				resp.setCode(ErrorCode.SUCCESS);
				resp.setId(mediaGatewayServer.getId());
				resp.setLanIp(mediaGatewayServer.getLanIp());
				resp.setWanIp(mediaGatewayServer.getWanIp());
				resp.setDeviceNumber(mediaGatewayServer.getDeviceNumber());
				resp.setHeartbeatCycle(mediaGatewayServer.getHeartbeatCycle());
				resp.setHeartbeatTime(mediaGatewayServer.getHeartbeatTime());
				resp.setInstallLocation(mediaGatewayServer.getInstallLocation());
				resp.setMsgPort(mediaGatewayServer.getMsgPort());
				resp.setName(mediaGatewayServer.getName());
				resp.setStatus(mediaGatewayServer.getStatus());
			}else{
				throw new BusinessException("mediaGatewayServer", ErrorCode.PARAMETER_NOT_FOUND);
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * listMediaGatewayServer 查询媒体网关列表
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "查询媒体网关列表", isLog = true, isCheckSession = true)
	@RequestMapping("/listMediaGatewayServer.json")
	public void listMediaGatewayServer(HttpServletRequest request,
			HttpServletResponse response){
		ListMediaGatewayServerResponse resp = new ListMediaGatewayServerResponse();
		try{
			List<MediaGatewayServer> mediaGatewayServer = centerDeviceManager.listMediaGatewayServer();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMediaGatewayServer(mediaGatewayServer);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
