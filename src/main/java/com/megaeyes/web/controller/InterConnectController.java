package com.megaeyes.web.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.TempResources;
import com.megaeyes.persistence.ibatis.model.ThirdPartyPlatform;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AlarmManager;
import com.megaeyes.service.iface.InterConnectManager;
import com.megaeyes.service.impl.InterConnectManagerImpl;
import com.megaeyes.service.utils.Configuration;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.ListThirdPartResourceResponse;
import com.megaeyes.web.response.ListThirdPartyPlatformResponse;

/**
 * 平台互联接口Controller
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-11 下午04:19:25
 */
@Controller
public class InterConnectController extends BaseController {

	private SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	private static Integer EXPIRES = 120;// 连接保活时间，暂定为120秒

	@Autowired
	private InterConnectManager interConnectManager;
	@Autowired
	private AlarmManager alarmManager;

	@ControllerDescription(description = "资源推送", isLog = false, isCheckSession = false)
	@RequestMapping("/Request_Resource")
	public void requestResource(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Request_Resource interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(in);
			Element rootReq = doc.getRootElement();
			String requestAction = rootReq.getAttributeValue("EventType");
			if ("Request_Resource".equals(requestAction)) {
				Element parentNode = rootReq.getChild("Item");
				String code = parentNode.getAttributeValue("Code");
				String userCode = parentNode.getAttributeValue("UserCode");
				String s_start = parentNode.getAttributeValue("FromIndex");
				String s_end = parentNode.getAttributeValue("ToIndex");
				int start = Integer.parseInt(s_start);
				int end = Integer.parseInt(s_end);

				// 返回xml
				Document xml = new Document();
				Element root = new Element("HTTP_XML");
				root.setAttribute("EventType", "Response_Resource");
				xml.setRootElement(root);

				List<PlatformResources> list = interConnectManager
						.listResources(code, userCode, start, end);
				int total = interConnectManager.countResources(code, userCode);
				Element subList = new Element("SubList");
				subList.setAttribute("Code", code);
				subList.setAttribute("RealNum", total + "");
				subList.setAttribute("SubNum", list.size() + "");
				subList.setAttribute("FromIndex", s_start);
				subList.setAttribute("ToIndex", (start + list.size()) + "");

				// 生成子节点
				List<Element> items = new LinkedList<Element>();
				for (PlatformResources record : list) {
					Element item = new Element("Item");
					item.setAttribute("Code", record.getSipCode());
					item.setAttribute("Name", record.getName());
					item.setAttribute("Status", record.getStatus().toString());
					// 获取编码信息，首先要保证摄像头所属视频服务器已经正确选择了厂商
					// 如果是沒有注冊的設備，直接跳過
					if ((!record.getType().equals("organ"))
							&& StringUtils.isBlank(record.getNaming())) {
						continue;
					}

					// 摄像头和视频服务器添加平台payload值，从配置文件里面获取得到
					String platformPayload = Configuration.getInstance()
							.getProperties("platform_payload");
					if (record.getType().equals("vic")) {
						item.setAttribute("DecoderTag", platformPayload);
					} else if (record.getType().equals("vis")) {
						item.setAttribute("DecoderTag", platformPayload);
					} else {
						item.setAttribute("DecoderTag", "");
					}

					// //获取真实的payload值，保留
					// if (record.getType().equals("vic")) {
					// RtpPayload payload = interConnectManager
					// .getRtpPayload(record.getSipCode());
					// item.setAttribute("DecoderTag", payload.getPayload());
					// } else if (record.getType().equals("vis")) {
					// String naming =
					// interConnectManager.codeToNaming(record.getSipCode());
					// if (StringUtils.isBlank(naming)) {
					// continue;
					// }
					// String visId = naming.split(":")[0];
					// RtpPayload payload =
					// interConnectManager.getRtpPayloadByVisId(visId);
					// item.setAttribute("DecoderTag", payload.getPayload());
					// } else {
					// item.setAttribute("DecoderTag", "");
					// }

					item.setAttribute(
							"Longitude",
							record.getLongitude() == null ? "" : record
									.getLongitude());
					item.setAttribute(
							"Latitude",
							record.getLatitude() == null ? "" : record
									.getLatitude());
					// 获取子节点数
					int count = 0;
					if (record.getType().equals("organ")
							|| record.getType().equals("vis")) {
						count = interConnectManager.countResources(
								record.getSipCode(), "");
					}
					item.setAttribute("SubNum", count + "");
					items.add(item);
				}

				subList.setContent(items);
				root.addContent(subList);

				response.setHeader("Host", Configuration.getInstance()
						.getJ2eeServerIp());
				response.setHeader("Connection", "Keep-Alive");
				writePageWithContentLength(response, xml);
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();
		} catch (BusinessException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@ControllerDescription(description = "历史报警查询", isLog = false, isCheckSession = false)
	@RequestMapping("/Request_History_Alarm")
	public void requestHistoryAlarm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Request_History_Alarm interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(in);
			Element rootReq = doc.getRootElement();
			String requestAction = rootReq.getAttributeValue("EventType");
			if ("Request_History_Alarm".equals(requestAction)) {
				Element item = rootReq.getChild("Item");
				String code = item.getAttributeValue("Code");
				String userCode = item.getAttributeValue("UserCode");
				String type = item.getAttributeValue("Type");
				String beginTime = item.getAttributeValue("BeginTime");
				String endTime = item.getAttributeValue("EndTime");
				String level = item.getAttributeValue("Level");
				String fromIndex = item.getAttributeValue("FromIndex");
				String toIndex = item.getAttributeValue("ToIndex");

				Long begin = null;
				if (StringUtils.isNotBlank(beginTime)) {
					begin = sdf.parse(beginTime).getTime();
				}
				Long end = null;
				if (StringUtils.isNotBlank(endTime)) {
					end = sdf.parse(endTime).getTime();
				}
				int from = Integer.parseInt(fromIndex);
				if (from < 0) {
					from = 0;
				}
				int to = Integer.parseInt(toIndex);
				if (from >= to) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

				PlatformResources resource = interConnectManager
						.getResourceByCode(code);
				if (null == resource) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					return;
				}
				// 暂时不支持机构级别的报警查询，后续有需要在增加
				if (resource.getType().equals("organ")) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					System.out.println("do not support organ qurey!");
					return;
				}

				// Code需要转换为resource_id(visId,vicId,aicId)查询
				String resourceId = resource.getResourceId();
				// 根据设备ID和其他条件查询报警信息
				// 特别是视频服务器时，查询下方的所有摄像头和报警输入产生的报警
				List<String> sourceIds = new ArrayList<String>();
				if ("vis".equals(resource.getType())) {
					// 查询vis下属的共享摄像头和报警输入产生的报警信息
					sourceIds = interConnectManager
							.listVisSharedChildIds(resourceId);
				}
				// 单个设备产生的报警信息
				else {
					sourceIds.add(resourceId);
				}

				List<String> types = InterConnectManagerImpl
						.int32TypeList(type);
				List<EpAlarmEvent> alarms = alarmManager
						.listEpAlarmEventInDevices(sourceIds, types, begin,
								end, level, from, to - from);
				int count = alarmManager.countEpAlarmEventInDevices(sourceIds,
						types, begin, end, level);

				// 生成返回xml
				Document xml = new Document();
				Element root = new Element("HTTP_XML");
				root.setAttribute("EventType", "Response_History_Alarm");
				xml.setRootElement(root);

				Element subList = new Element("SubList");
				subList.setAttribute("RealNum", count + "");
				subList.setAttribute("SubNum", alarms.size() + "");
				subList.setAttribute("FromIndex", from + "");
				subList.setAttribute("ToIndex", (from + alarms.size()) + "");

				// 生成子节点
				List<Element> items = new LinkedList<Element>();
				for (EpAlarmEvent alarm : alarms) {
					PlatformResources pr = interConnectManager
							.getPlatformResourceByResourceId(alarm
									.getSourceId());
					if (null == pr) {
						continue;
					}
					Element e = new Element("Item");
					e.setAttribute("Code", pr.getSipCode());
					e.setAttribute("BeginTime", sdf.format(new Date(alarm
							.getBeginTime().longValue())));
					e.setAttribute("Status", pr.getStatus().toString());
					e.setAttribute("Type",
							getTypeByName(alarm.getEventTypeName()));
					items.add(e);
				}
				subList.setContent(items);
				root.addContent(subList);

				response.setHeader("Host", Configuration.getInstance()
						.getJ2eeServerIp());
				response.setHeader("Connection", "Keep-Alive");
				writePageWithContentLength(response, xml);
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (BusinessException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@ControllerDescription(description = "录像列表查询", isLog = false, isCheckSession = false)
	@RequestMapping("/Request_History_Video")
	public void requestHistoryVideo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Request_History_Video interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();

		try {
			Document doc = builder.build(in);
			Element rootReq = doc.getRootElement();
			String requestAction = rootReq.getAttributeValue("EventType");
			if ("Request_History_Video".equals(requestAction)) {
				Element item = rootReq.getChild("Item");
				String code = item.getAttributeValue("Code");
				String type = item.getAttributeValue("Type");
				String userCode = item.getAttributeValue("UserCode");
				String s_beginTime = item.getAttributeValue("BeginTime");
				String s_endTime = item.getAttributeValue("EndTime");
				String s_fromIndex = item.getAttributeValue("FromIndex");
				String s_toIndex = item.getAttributeValue("ToIndex");
				long beginTime = sdf.parse(s_beginTime).getTime();
				long endTime = sdf.parse(s_endTime).getTime();
				int from = Integer.parseInt(s_fromIndex);
				int to = Integer.parseInt(s_toIndex);

				if (from < 0) {
					from = 0;
				}
				if (from >= to) {
					System.out.println("Invalid parameter FromIndex[" + from
							+ "] >= ToIndex[" + to + "] !");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

				String body = ""; // 返回xml
				boolean isLocal = true; // 是否本地平台设备

				if (code.length() <= 20) {
					// 判断是否外平台设备
					if (interConnectManager.isThirdPartyResource(code)) {
						isLocal = false;
					} else {
						isLocal = true;
					}
				}
				// code大于20位是内部平台ID，因此肯定是内部设备
				else {
					isLocal = true;
				}
				if (isLocal) {
					body = interConnectManager.listVicHistoryVideo(code, type,
							userCode, beginTime, endTime, from, to);
				}
				// 如果是外平台设备，使用httpclient去查询并返回
				else {
					// 先获取对应平台的请求url
					ThirdPartyPlatform platform = interConnectManager
							.getThirdPartyPlatformByResourceCode(code);
					String url = platform.getHttpUrl();
					url += "/Request_History_Video";
					HttpClient client = new HttpClient();
					client.getParams().setContentCharset("UTF8");
					PostMethod method = new PostMethod(url);
					Document docRequest = new Document();
					Element rootRequest = new Element("HTTP_XML");
					rootRequest.setAttribute("EventType",
							"Request_History_Video");
					docRequest.setRootElement(rootRequest);
					Element itemRequest = new Element("Item");
					itemRequest.setAttribute("Code", code);
					itemRequest.setAttribute("Type", type);
					itemRequest.setAttribute("UserCode", code);
					itemRequest.setAttribute("BeginTime", s_beginTime);
					itemRequest.setAttribute("EndTime", s_endTime);
					itemRequest.setAttribute("FromIndex", s_fromIndex);
					itemRequest.setAttribute("ToIndex", s_toIndex);
					rootRequest.addContent(itemRequest);
					XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
					String bodyRequest = out.outputString(docRequest);

					method.setRequestHeader("Content-Type", "application/xml");
					method.setRequestHeader("Content-Length",
							bodyRequest.length() + "");
					method.setRequestHeader("Connection", "Keep-Alive");
					method.setRequestEntity(new StringRequestEntity(bodyRequest));
					try {
						client.executeMethod(method);
						byte[] rtn = method.getResponseBody();
						body = new String(rtn, "UTF-8");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						method.releaseConnection();
					}
				}
				if (StringUtils.isBlank(body)) {
					Document xml = new Document();
					Element root = new Element("HTTP_XML");
					root.setAttribute("EventType", "Response_History_Video");
					xml.setRootElement(root);

					Element subList = new Element("SubList");
					subList.setAttribute("RealNum", "0");
					subList.setAttribute("SubNum", "0");
					subList.setAttribute("FromIndex", "0");
					subList.setAttribute("ToIndex", "0");
					root.addContent(subList);
					XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
					body = out.outputString(xml);
				}
				response.setHeader("Host", Configuration.getInstance()
						.getJ2eeServerIp());
				response.setHeader("Connection", "Keep-Alive");
				String rtn = new String(body.getBytes("utf8"), "iso-8859-1");
				if (log.isDebugEnabled()) {
					log.debug(rtn);
				}
				response.setContentLength(rtn.length());
				response.setContentType("application/xml");
				response.getWriter().write(rtn);
				response.getWriter().flush();
				response.getWriter().close();
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (BusinessException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@ControllerDescription(description = "平台上下线通知", isLog = false, isCheckSession = false)
	@RequestMapping("/Request_Update_Status")
	public void requestUpdateStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Request_Update_Status interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(in);
			Element rootReq = doc.getRootElement();
			String requestAction = rootReq.getAttributeValue("EventType");
			if ("Request_Update_Status".equals(requestAction)) {
				Element parentNode = rootReq.getChild("Item");
				String from = parentNode.getAttributeValue("From");
				String to = parentNode.getAttributeValue("To");
				Short status = Short.valueOf(parentNode
						.getAttributeValue("Status"));
				String httpURL = parentNode.getAttributeValue("HttpURL");
				String sipURL = parentNode.getAttributeValue("SipURL");
				Long heartbeatTime = new Date().getTime();
				interConnectManager.platformUpdateStatus(from, status, httpURL,
						sipURL, null, heartbeatTime);

				// 返回xml
				Document xml = new Document();
				Element root = new Element("HTTP_XML");
				root.setAttribute("EventType", "Request_Update_Status");
				xml.setRootElement(root);

				Element item = new Element("Item");
				item.setAttribute("From", from);
				item.setAttribute("To", to);
				item.setAttribute("Expires", EXPIRES + "");
				root.addContent(item);

				response.setHeader("Host", Configuration.getInstance()
						.getJ2eeServerIp());
				response.setHeader("Connection", "Keep-Alive");
				writePageWithContentLength(response, xml);
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (BusinessException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@ControllerDescription(description = "资源状态改变", isLog = false, isCheckSession = false)
	@RequestMapping("/Request_Status_Value")
	public void requestStatusValue(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Request_Status_Value interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(in);
			Element rootReq = doc.getRootElement();
			String requestAction = rootReq.getAttributeValue("EventType");
			if ("Request_Status_Value".equals(requestAction)) {
				Element item = rootReq.getChild("Item");
				String code = item.getAttributeValue("Code");
				String userCode = item.getAttributeValue("UserCode");

				// 返回xml
				Document xml = new Document();
				Element root = new Element("HTTP_XML");
				root.setAttribute("EventType", "Response_Status_Value");
				xml.setRootElement(root);

				Element subList = new Element("SubList");
				String parentCode = interConnectManager.getParentCode(code);
				subList.setAttribute("Code", parentCode);
				Element rtnItem = new Element("Item");
				rtnItem.setAttribute("Code", code);
				rtnItem.setAttribute("Status", "1");

				subList.addContent(rtnItem);
				root.addContent(subList);

				response.setHeader("Host", Configuration.getInstance()
						.getJ2eeServerIp());
				response.setHeader("Connection", "Keep-Alive");
				writePageWithContentLength(response, xml);
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (BusinessException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}

	@ControllerDescription(description = "心跳", isLog = false, isCheckSession = false)
	@RequestMapping("/KeepAlive")
	public void keepAlive(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in KeepAlive interface...");
		request.setCharacterEncoding("UTF-8");
		InputStream in = request.getInputStream();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(in);
			Element root = doc.getRootElement();
			String requestAction = root.getAttributeValue("EventType");
			if ("KeepAlive".equals(requestAction)) {
				Element parentNode = root.getChild("Item");
				String from = parentNode.getAttributeValue("From");
				Long heartbeatTime = new Date().getTime();
				interConnectManager.keepAlive(from, heartbeatTime);
			} else {
				System.out.println("Request action is not suitable !");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (JDOMException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (BusinessException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@ControllerDescription(description = "获取下级平台资源", isLog = false, isCheckSession = false)
	@RequestMapping("/listThirdPartyResource.json")
	public void listThirdPartyResource(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ListThirdPartResourceResponse resp = new ListThirdPartResourceResponse();
		// 取参数
		String code = request.getParameter("code");
		if (StringUtils.isBlank(code)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND + "");
			resp.setMessage("code");
		}

		String platformCode = request.getParameter("platformCode");
		if (StringUtils.isBlank(platformCode)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND + "");
			resp.setMessage("platformCode");
		}

		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				List<TempResources> resources = interConnectManager
						.listThirdPartyResource(code, platformCode);
				resp.setResources(resources);
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
	
	@ControllerDescription(description = "获取所有的下级平台", isLog = false, isCheckSession = false)
	@RequestMapping("/listThirdPartyPlatform.json")
	public void listThirdPartyPlatformJsonServlet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ListThirdPartyPlatformResponse resp = new ListThirdPartyPlatformResponse();

		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				resp.setPlatforms(interConnectManager.listThirdPartyPlatform());
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

	public String getTypeByName(String name) {
		if (name.equals("视频丢失告警")) {
			return "1";
		} else if (name.equals("移动侦测告警")) {
			return "2";
		} else if (name.equals("磁盘故障告警")) {
			return "2048";
		} else if (name.equals("定时录像事件")) {
			return "1048576";
		} else {
			return "-1";
		}
	}
}
