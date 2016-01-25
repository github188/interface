/**   
 * @Title: EpGatherServerController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-21 上午7:16:31 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpGatherServerMananger;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpGatherServerResponse;
import com.megaeyes.web.response.ListEpGatherServerResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * @ClassName: EpGatherServerController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-21 上午7:16:31
 * 
 */
@Controller
public class EpGatherServerController extends BaseController {
	@Autowired
	EpGatherServerMananger epGatherServerMananger;

	/**
	 * @Title: createEpGatherServer
	 * @Description: 创建采集服务器
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 *             设定文件
	 * @return void 返回类型
	 */
	@ControllerDescription(description = "创建采集服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/createEGS.json")
	public void createEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");

		String organId = (String) request.getAttribute("organId");
		String ip = (String) request.getAttribute("ip");
		String name = (String) request.getAttribute("name");
		String note = (String) request.getAttribute("note");
		Long heartCycle = null;
		String s_heartCycle = (String) request.getAttribute("heartCycle");
		if (StringUtils.isNotBlank(s_heartCycle)) {
			try {
				heartCycle = new Long(s_heartCycle);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("hearCycle");
			}
		}
		String eventServerId = (String) request.getAttribute("eventServerId");
		String eventPort = (String) request.getAttribute("eventPort");
		String clientPort = (String) request.getAttribute("clientPort");
		String consoleListenerIp = (String) request
				.getAttribute("consoleListenerIp");
		String consoleListenerPort = request
				.getParameter("consoleListenerPort");
		String consolePassword = (String) request
				.getAttribute("consolePassword");
		String clientIp = (String) request.getAttribute("clientIp");
		String eventIp = (String) request.getAttribute("eventIp");
		String deviceNumber = (String) request.getAttribute("deviceNumber");

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = epGatherServerMananger.createEpGatherServer(
						organId, ip, name, note, heartCycle, eventServerId,
						eventPort, clientPort, consoleListenerIp,
						consoleListenerPort, consolePassword, clientIp,
						eventIp, deviceNumber);
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
	 * @Title: deleteEpGatherServer
	 * @Description: 删除采集服务器
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除采集服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEGS.json")
	public void deleteEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");

		try {
			epGatherServerMananger.deleteEpGatherServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * 
	 * deleteForceEpGatherServer 强制删除采集服务器
	 * 
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "强制删除采集服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteForceEGS.json")
	public void deleteForceEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");

		try {
			epGatherServerMananger.deleteForceEpGatherServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: listEpGatherServer
	 * @Description: 查询采集服务器列表
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "查询采集服务器列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listEGS.json")
	public void listEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) {
		ListEpGatherServerResponse resp = new ListEpGatherServerResponse();
		try {
			List<EpGatherServer> epGatherServer = epGatherServerMananger
					.listEpGatherServer();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpGatherServer(epGatherServer);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: getEpGatherServer
	 * @Description: 根据ID查询采集服务器
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据ID查询采集服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/getEGS.json")
	public void getEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) {
		EpGatherServerResponse resp = new EpGatherServerResponse();
		String id = (String) request.getAttribute("id");
		try {
			EpGatherServer egs = epGatherServerMananger.getEpGatherServer(id);
			resp.setCode(ErrorCode.SUCCESS);
			if (egs != null) {
				resp.setId(egs.getId());
				resp.setOrganId(egs.getOrganId());
				resp.setIp(egs.getIp());
				resp.setName(egs.getName());
				resp.setNote(egs.getNote());
				resp.setHeartCycle(egs.getHeartCycle());
				resp.setEventServerId(egs.getEventServerId());
				resp.setEventPort(egs.getEventPort());
				resp.setClientPort(egs.getClientPort());
				resp.setConsoleListenerIp(egs.getConsoleListenerIp());
				resp.setConsoleListenerPort(egs.getConsoleListenerPort());
				resp.setConsolePassword(egs.getConsolePassword());
				resp.setClientIp(egs.getClientIp());
				resp.setEventIp(egs.getEventIp());
				resp.setDeviceNumber(egs.getDeviceNumber());
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: updateEpGatherServer
	 * @Description: 更新采集服务器
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 *             设定文件
	 * @return void 返回类型
	 */
	@ControllerDescription(description = "更新采集服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/updateEGS.json")
	public void updateEpGatherServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");

		String id = (String) request.getAttribute("id");
		String organId = (String) request.getAttribute("organId");
		String ip = (String) request.getAttribute("ip");
		String name = (String) request.getAttribute("name");
		String note = (String) request.getAttribute("note");
		Long heartCycle = null;
		String s_heartCycle = (String) request.getAttribute("heartCycle");
		if (StringUtils.isNotBlank(s_heartCycle)) {
			try {
				heartCycle = new Long(s_heartCycle);
			} catch (NumberFormatException be) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartCycle");
			}
		}
		String eventServerId = (String) request.getAttribute("eventServerId");
		String eventPort = (String) request.getAttribute("eventPort");
		String clientPort = (String) request.getAttribute("clientPort");
		String consoleListenerIp = (String) request
				.getAttribute("consoleListenerIp");
		String consoleListenerPort = request
				.getParameter("consoleListenerPort");
		String consolePassword = (String) request
				.getAttribute("consolePassword");
		String clientIp = (String) request.getAttribute("clientIp");
		String eventIp = (String) request.getAttribute("eventIp");
		String deviceNumber = (String) request.getAttribute("deviceNumber");

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				epGatherServerMananger.updateEpGatherServer(id, organId, ip,
						name, note, heartCycle, eventServerId, eventPort,
						clientPort, consoleListenerIp, consoleListenerPort,
						consolePassword, clientIp, eventIp, deviceNumber);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "采集服务器注册", isLog = false, isCheckSession = false)
	@RequestMapping("/dataServerRegister.xml")
	public void epGatherServerRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In dataServerRegister.xml...");
		request.setCharacterEncoding("UTF-8");
		BaseXMLResponse resp = new BaseXMLResponse();

		String deviceNumber = (String) request.getAttribute("deviceNumber");
		if (StringUtils.isBlank(deviceNumber)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [deviceNumber] !");
		}
		String addr = (String) request.getAttribute("addr");
		if (StringUtils.isBlank(addr)) {
			resp.setSuccess(BaseXMLResponse.FAIL);
			resp.setReason("missing parameter [addr] !");
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText("N");
		root.addContent(successElement);

		if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
			try {
				String id = epGatherServerMananger.epGatherServerRegister(
						deviceNumber, addr);
				// 注册成功
				successElement.setText("Y");

				Element reasonElement = new Element("Reason");
				reasonElement.setText("");
				root.addContent(reasonElement);

				// 获取采集服务器详细信息
				EpGatherServer gs = epGatherServerMananger
						.getEpGatherServer(id);

				Element dataserverElement = new Element("Dataserver");
				dataserverElement.setAttribute("heart_cycle", gs
						.getHeartCycle() != null ? gs.getHeartCycle()
						.toString() : "");
				root.addContent(dataserverElement);

				// 查询控制器列表
				List<EpControlServer> csList = epGatherServerMananger
						.listEpControlServerByGatherServerId(id);
				Element deviceListElement = new Element("Devices");
				root.addContent(deviceListElement);

				for (EpControlServer cs : csList) {
					Element device = new Element("Device");
					device.setAttribute("id", cs.getId());
					if (cs.getType().intValue() == 1)
						device.setAttribute("type", "PLC");
					if (cs.getType().intValue() == 2)
						device.setAttribute("type", "SOLAR");
					device.setAttribute("name",
							cs.getName() != null ? cs.getName() : "");
					device.setAttribute("url",
							cs.getUrl() != null ? cs.getUrl() : "");
					device.setAttribute("position",
							cs.getPosition() != null ? cs.getPosition() : "");

					// 查询所管理的IO
					List<EpProber> proberList = epGatherServerMananger
							.listEpProberByControlServerId(cs.getId());
					for (EpProber prober : proberList) {
						Element deviceIoElement = new Element("Device_io");
						deviceIoElement.setAttribute("id", prober.getId());
						deviceIoElement.setAttribute("name",
								prober.getName() != null ? prober.getName()
										: "");
						deviceIoElement.setAttribute("position", prober
								.getPosition() != null ? prober.getPosition()
								: "");
						deviceIoElement.setAttribute("addr", prober
								.getAddress() != null ? prober.getAddress()
								: "");
						deviceIoElement.setAttribute("type", prober
								.getPlcIoType() != null ? prober.getPlcIoType()
								: "");
						deviceIoElement.setAttribute(
								"dev_type",
								prober.getEpProberTypeId() != null ? prober
										.getEpProberTypeId() : "");
						deviceIoElement.setAttribute("data_type", prober
								.getDataType() != null ? prober.getDataType()
								: "");
						deviceIoElement.setAttribute("register_reverse", prober
								.getRegisterReverse() != null ? prober
								.getRegisterReverse().toString() : "");
						deviceIoElement.setAttribute("is_warn", prober
								.getIsWarn() != null ? prober.getIsWarn()
								.toString() : "");
						deviceIoElement.setAttribute("coil_warn", prober
								.getBoolWarn() != null ? prober.getBoolWarn()
								.toString() : "");
						deviceIoElement.setAttribute("max_limit", prober
								.getMaxLimit() != null ? prober.getMaxLimit()
								.toString() : "");
						deviceIoElement.setAttribute("min_limit", prober
								.getMinLimit() != null ? prober.getMinLimit()
								.toString() : "");
						deviceIoElement.setAttribute("read_cycle", prober
								.getCycle() != null ? prober.getCycle()
								.toString() : "");
						deviceIoElement.setAttribute("save_cycle", prober
								.getPlcIoSaveCycle() != null ? prober
								.getPlcIoSaveCycle().toString() : "");
						deviceIoElement.setAttribute(
								"save_type",
								prober.getPlcIoSaveType() != null ? prober
										.getPlcIoSaveType() : "");
						device.addContent(deviceIoElement);
					}

					deviceListElement.addContent(device);
				}
			} catch (BusinessException e) {
				e.printStackTrace();
				doc = new Document();
				root = new Element("Message");
				doc.setRootElement(root);

				successElement = new Element("Success");
				successElement.setText("N");
				root.addContent(successElement);

				Element reasonElement = new Element("Reason");
				reasonElement.setText(e.getMessage());
				root.addContent(reasonElement);
			}
		}

		writePageWithContentLength(response, doc);
	}
}
