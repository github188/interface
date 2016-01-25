/**   
 * @Title: AlarmController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-17 下午3:39:05 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.avalon.framework.service.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.InputSource;

import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.model.HistoryVideo;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AlarmManager;
import com.megaeyes.service.iface.OrganManager;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.service.utils.DeviceType;
import com.megaeyes.service.utils.StdIdGenerator;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAlarmEventResponse;
import com.megaeyes.web.response.ListHistoryVideoByEventResp;
import com.megaeyes.web.response.ListSchemeResponse;
import com.megaeyes.web.response.ListSharedDeviceResponse;
import com.megaeyes.web.response.xml.BaseXMLResponse;

/**
 * @ClassName: AlarmController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-17 下午3:39:05
 * 
 */
@Controller
public class AlarmController extends BaseController {
	public static final String TIME_PAD = "000";
	@Autowired
	AlarmManager alarmManager;
	@Autowired
	UserManager userManager;
	@Autowired
	OrganManager organManager;

	@ControllerDescription(description = "获取指定ID的多条预案详细信息", isLog = false, isCheckSession = false)
	@RequestMapping("/getSchemeDetail.xml")
	public void GetSchemeDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String success = BaseXMLResponse.SUCCESS;
		String ids = request.getParameter("ids");
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element successElement = new Element("Success");
		successElement.setText(success);
		root.addContent(successElement);
		if (BaseXMLResponse.SUCCESS.equals(success)) {
			try {
				doc = alarmManager.listSchemesDetail(ids.split(","));
			} catch (ServiceException e) {
				e.printStackTrace();
				successElement.setText(BaseXMLResponse.FAIL);
			} catch (Exception e) {
				e.printStackTrace();
				successElement.setText(BaseXMLResponse.FAIL);
			}
		}
		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "事件服务器心跳", isLog = false, isCheckSession = false)
	@RequestMapping("/eventServerHeartbeat.xml")
	public void EventServerHeartbeat(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseXMLResponse resp = new BaseXMLResponse();
		String lastUpdateTime = "";
		try {
			Long time = alarmManager.getSchemesLastUpdateTime();
			lastUpdateTime = time != null ? time.toString() : "";
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
		Element schemesLastUpdateTime = new Element("SchemesLastUpdateTime");
		schemesLastUpdateTime.setText(lastUpdateTime);
		root.addContent(schemesLastUpdateTime);

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取全部预案", isLog = false, isCheckSession = false)
	@RequestMapping("/listScheme.xml")
	public void ListScheme(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ListSchemeResponse resp = new ListSchemeResponse();
		try {
			List<EpScheme> list = alarmManager.listEpScheme(null);
			resp.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setSuccess(ListSchemeResponse.EXCEPTION);
		}
		// 返回
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element success = new Element("Success");
		success.setText(resp.getSuccess());
		root.addContent(success);
		Element schemes = new Element("Schemes");
		for (EpScheme es : resp.getList()) {
			Element scheme = new Element("Scheme");
			scheme.setAttribute("Id", es.getId());
			scheme.setAttribute("Name", es.getName());
			schemes.addContent(scheme);
		}
		root.addContent(schemes);
		writePageWithContentLength(response, doc);
	}

	// @ControllerDescription(description = "创建报警信息", isLog = false,
	// isCheckSession = false)
	// @RequestMapping("/alarmNotify.xml")
	// public void CreateEpAlarmEvent(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// BaseXMLResponse resp = new BaseXMLResponse();
	//
	// String id = (String) request.getAttribute("id");
	// if (StringUtils.isBlank(id)) {
	// resp.setSuccess(BaseXMLResponse.FAIL);
	// System.out.println("missing parameter [id] !");
	// }
	//
	// String eventNaming = (String) request.getAttribute("eventNaming");
	// if (StringUtils.isBlank(eventNaming)) {
	// resp.setSuccess(BaseXMLResponse.FAIL);
	// System.out.println("missing parameter [eventNaming] !");
	// }
	//
	// String deviceType = (String) request.getAttribute("deviceType");
	// if (StringUtils.isBlank(deviceType)) {
	// resp.setSuccess(BaseXMLResponse.FAIL);
	// System.out.println("missing parameter [deviceType] !");
	// } else {
	// if ("5".equals(deviceType)) {
	// deviceType = DeviceType.DEVICE_TYPE_VIC;
	// } else if ("video_input_channel".equals(deviceType)) {
	// deviceType = DeviceType.DEVICE_TYPE_VIC;
	// } else if ("alarm_input_channel".equals(deviceType)) {
	// deviceType = DeviceType.DEVICE_TYPE_AIC;
	// } else if ("6".equals(deviceType)) {
	// deviceType = DeviceType.DEVICE_TYPE_AIC;
	// }
	// }
	//
	// Long beginTime = null;
	// Long endTime = null;
	// String time = (String) request.getAttribute("time");
	// if (StringUtils.isBlank(time)) {
	// beginTime = System.currentTimeMillis();
	// endTime = System.currentTimeMillis();
	// } else {
	// try {
	// // 如果只精确到秒，毫秒位补0
	// if (time.length() == 10) {
	// time += TIME_PAD;
	// }
	// beginTime = Long.parseLong(time);
	// endTime = Long.parseLong(time);
	// } catch (NumberFormatException e) {
	// e.printStackTrace();
	// resp.setSuccess(BaseXMLResponse.FAIL);
	// }
	// }
	//
	// String threshold = (String) request.getAttribute("threshold");
	//
	// String dataValue = (String) request.getAttribute("dataValue");
	//
	// String note = (String) request.getAttribute("note");
	//
	// String level = (String) request.getAttribute("level");
	//
	// String eventTypeName = (String) request.getAttribute("eventTypeName");
	// if (StringUtils.isNotBlank(eventTypeName)) {
	// eventTypeName = URLDecoder.decode(eventTypeName, "UTF-8");
	// }
	// String seessionId = null;
	// if (BaseXMLResponse.SUCCESS.equals(resp.getSuccess())) {
	// try {
	// if (StringUtils.isBlank(eventTypeName)) {
	// // 获取报警类型
	// eventTypeName = alarmManager.getEventTypeName(eventNaming);
	// }
	//
	// String alarmId = alarmManager.insertEpAlarmEvent(seessionId,
	// id, deviceType, threshold, dataValue, beginTime,
	// endTime, note, eventNaming, eventTypeName, level);
	// } catch (IllegalArgumentException e) {
	// e.printStackTrace();
	// resp.setSuccess(BaseXMLResponse.FAIL);
	// } catch (Exception e) {
	// e.printStackTrace();
	// resp.setSuccess(BaseXMLResponse.EXCEPTION);
	// }
	// }
	// Document doc = new Document();
	// Element root = new Element("Message");
	// doc.setRootElement(root);
	// Element successElement = new Element("Success");
	// successElement.setText(resp.getSuccess());
	// root.addContent(successElement);
	// writePageWithContentLength(response, doc);
	// }

	@ControllerDescription(description = "批量创建报警信息", isLog = false, isCheckSession = false)
	@RequestMapping("/batchAlarmNotify.xml")
	public void BatchCreateEpAlarmEvent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BaseXMLResponse resp = new BaseXMLResponse();
		ServletInputStream in = request.getInputStream();
		int length = request.getContentLength();
		if (length <= 0) {
			System.out.println("Content length is missing !");
			resp.setSuccess(BaseXMLResponse.FAIL);
		}
		ByteBuffer buffer = ByteBuffer.allocate(length);
		byte[] temp = new byte[1024];
		int count = 0;
		int index = 0;
		while ((count = in.read(temp)) >= 0) {
			buffer.put(temp, 0, count);
		}
		buffer.flip();
		byte[] data = buffer.array();
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
			InputStream stream = new ByteArrayInputStream(data);
			doc = builder.build(stream);
		} catch (Exception e) {
			try {
				System.out.println("utf8 parse error ! try to use gbk parse.");
				String xml = new String(data, "gbk");
				StringReader sr = new StringReader(xml);
				InputSource is = new InputSource(sr);
				doc = builder.build(is);
			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
				resp.setReason(e1.getMessage());
			}
		}
		if (null != doc) {
			try {

				Element root = doc.getRootElement();
				List<Element> alarms = root.getChildren("Alarm");
				for (Element alarm : alarms) {
					String eventNaming = alarm.getAttributeValue("EventNaming");
					String id = alarm.getAttributeValue("Id");
					// 如果报警源是外平台的设备，不做存储
					if (StringUtils.isBlank(id) || id.length() <= 20) {
						continue;
					}
					String deviceType = alarm.getAttributeValue("DeviceType");
					if (StringUtils.isBlank(deviceType)) {
						// 根据eventNaming获取真实的deviceType;
						deviceType = alarmManager
								.getDeviceTypeByEventNaming(eventNaming);
					} else {
						if ("5".equals(deviceType)) {
							deviceType = DeviceType.DEVICE_TYPE_VIC;
						} else if ("video_input_channel".equals(deviceType)) {
							deviceType = DeviceType.DEVICE_TYPE_VIC;
						} else if ("alarm_input_channel".equals(deviceType)) {
							deviceType = DeviceType.DEVICE_TYPE_AIC;
						} else if ("6".equals(deviceType)) {
							deviceType = DeviceType.DEVICE_TYPE_AIC;
						}
					}
					Long beginTime = null;
					Long endTime = null;
					String time = alarm.getAttributeValue("Time");
					System.out.println(time);
					
					if (StringUtils.isBlank(time)) {
						beginTime = System.currentTimeMillis();
						endTime = System.currentTimeMillis();
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
						Date date = sdf.parse(time);
						beginTime = date.getTime();
						endTime = date.getTime();
						
					}

					String threshold = alarm.getAttributeValue("Threshold");

					String dataValue = alarm.getAttributeValue("DataValue");
					String eventTypeName = alarm
							.getAttributeValue("EventTypeName");
					if (StringUtils.isBlank(eventTypeName)) {
						// 获取报警类型
						eventTypeName = alarmManager
								.getEventTypeName(eventNaming);
					}
					String note = alarm.getAttributeValue("note");
					
					String level = alarm.getAttributeValue("level");
					String sessionId = null;
					alarmManager.insertEpAlarmEvent(sessionId, id, deviceType,
							threshold, dataValue, beginTime, endTime, note,
							eventNaming, eventTypeName, level);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setSuccess(BaseXMLResponse.FAIL);
			}
		}
		Document documnet = new Document();
		Element root = new Element("Message");
		documnet.setRootElement(root);
		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		writePageWithContentLength(response, documnet);
	}

	@ControllerDescription(description = "获取所有的共享设备列表", isLog = false, isCheckSession = false)
	@RequestMapping("/listSharedDevice.xml")
	public void ListSharedDevice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ListSharedDeviceResponse resp = new ListSharedDeviceResponse();

		int start = 1;
		int limit = 9999;
		try {
			String startString = (String) request.getAttribute("start");
			if (StringUtils.isNotBlank(startString)) {
				start = Integer.parseInt(startString);
			}

			String limitString = (String) request.getAttribute("limit");
			if (StringUtils.isNotBlank(limitString)) {
				limit = Integer.parseInt(limitString);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.setSuccess(ListSharedDeviceResponse.EXCEPTION);
		}

		if (ListSharedDeviceResponse.SUCCESS.equals(resp.getSuccess())) {
			int total = alarmManager.countSharedAlarmDevice();
			List<PlatformResources> list = alarmManager.listSharedAlarmDevice(
					start, limit);

			List<ListSharedDeviceResponse.Device> devices = new ArrayList<ListSharedDeviceResponse.Device>();
			for (PlatformResources pr : list) {
				ListSharedDeviceResponse.Device device = resp.new Device();
				device.setId(pr.getResourceId());
				device.setCode(pr.getSipCode());
				device.setName(pr.getName());
				devices.add(device);
			}
			resp.setDevices(devices);
			resp.setTotal(total);
		}

		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element successElement = new Element("Success");
		successElement.setText(resp.getSuccess());
		root.addContent(successElement);

		Element totalElement = new Element("Total");
		totalElement.setText(resp.getTotal() + "");
		root.addContent(totalElement);

		Element itemsElement = new Element("Items");
		root.addContent(itemsElement);

		for (ListSharedDeviceResponse.Device device : resp.getDevices()) {
			Element item = new Element("Item");
			item.setAttribute("Id", device.getId());
			item.setAttribute("Code", device.getCode());
			item.setAttribute("Name", device.getName());
			itemsElement.addContent(item);
		}

		writePageWithContentLength(response, doc);
	}

	@ControllerDescription(description = "获取信令网关IP和端口", isLog = false, isCheckSession = false)
	@RequestMapping("/getSipServerAddress.xml")
	public void GetSipServerAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String success = BaseXMLResponse.SUCCESS;
		String reason = "";
		String ip = "";
		String port = "";
		try {

			SipServer server = alarmManager.getSipServer();
			ip = server.getLanIp();
			port = server.getMegaPort().toString();
		} catch (Exception e) {
			e.printStackTrace();
			success = BaseXMLResponse.EXCEPTION;
			reason = e.getMessage();
		}
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);
		Element successElement = new Element("Success");
		successElement.setText(success);
		root.addContent(successElement);
		if (!BaseXMLResponse.SUCCESS.equals(success)) {
			Element reasonElement = new Element("Reason");
			reasonElement.setText(reason);
			root.addContent(reasonElement);
		}

		Element addressElement = new Element("Address");
		addressElement.setAttribute("Ip", ip);
		addressElement.setAttribute("Port", port);
		root.addContent(addressElement);
		writePageWithContentLength(response, doc);
	}

	/**
	 * @Title: updateEpAlarmEvent
	 * @Description: 根据naming修改note
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "根据naming修改note", isLog = false, isCheckSession = false)
	@RequestMapping("/updateEpAlarmEvent.json")
	public void updateEpAlarmEvent(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String naming = (String) request.getAttribute("naming");
		String note = (String) request.getAttribute("note");
		String confirmTime = StdIdGenerator.getDate();
		try {
			alarmManager.updateEpAlarmEvent(naming, note, confirmTime);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@RequestMapping("/listHistoryAlarmEvent.json")
	@ControllerDescription(description = "查询报警信息", isLog = false, isCheckSession = true)
	public void listHistoryAlarmEvent(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
		System.out.println(System.currentTimeMillis());
		ListAlarmEventResponse resp = new ListAlarmEventResponse();
		request.setCharacterEncoding("UTF-8");

		Long begin = null;
		String beginString = (String) request.getAttribute("begin");
		if (StringUtils.isNotBlank(beginString)) {
			try {
				begin = Long.parseLong(beginString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("begin: " + beginString);
			}
		}

		Long end = null;
		String endString = (String) request.getAttribute("end");
		if (StringUtils.isNotBlank(endString)) {
			try {
				end = Long.parseLong(endString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("end: " + endString);
			}
		}

		int start = 1;
		int limit = 1000;
		String startString = (String) request.getAttribute("start");
		if (StringUtils.isNotBlank(startString)) {
			try {
				start = Integer.parseInt(startString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("start: " + startString);
			}
		}

		String limitString = (String) request.getAttribute("limit");
		if (StringUtils.isNotBlank(limitString)) {
			try {
				limit = Integer.parseInt(limitString);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("limit: " + limitString);
			}
		}

		String sessionId = (String) request.getAttribute("sessionId");
		if (StringUtils.isBlank(sessionId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("sessionId");
		}

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			// 获取用户所属organId
			UserSessionVO user = userManager.getSessionById(sessionId);

			// 查询用户所属的机构和子机构Id列表
			List<Organ> list = organManager
					.getChildOrganById(user.getOrganId());
			List<String> organIds = new ArrayList<String>();
			organIds.add(user.getOrganId());
			for (Organ o : list) {
				organIds.add(o.getId());
			}

			try {
				List<EpAlarmEvent> alarmEvents = alarmManager
						.listHistoryAlarmEvent(organIds, begin, end, start,
								limit);
				Integer totalCount = alarmManager.countHistoryAlarmEvent(
						organIds, begin, end);
				resp.setAlarms(alarmEvents);
				resp.setTotalCount(totalCount.toString());
			} catch (BusinessException e) {
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage(e.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@RequestMapping("/listHistoryVideoByEvent.json")
	@ControllerDescription(description = "查询报警信息关联的录像列表", isLog = false, isCheckSession = true)
	public void listHistoryVideoByEvent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListHistoryVideoByEventResp resp = new ListHistoryVideoByEventResp();
		String eventId = request.getParameter("eventId");
		if (StringUtils.isBlank(eventId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("eventId");
		}

		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<HistoryVideo> historyVideos = alarmManager
						.listHistoryVideoByEventId(eventId);
				resp.setVideoList(historyVideos);
			} catch (BusinessException e) {
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage(e.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}
	
	public static void main(String[] args){
		//System.out.println((new Date().getTime()));
		//1341456700265
		//1341481804000
		String s = "20120705140852";
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		Date date;
		try {
		date = sdf.parse(s);
			//long l = date.getTime();
			Long l1 = Long.valueOf("1341469193000");
			//System.out.println(l);
			System.out.println(sdf.format(new Date(l1)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
