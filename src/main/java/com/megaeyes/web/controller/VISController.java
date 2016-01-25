/**   
 * @Title: VISServerController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-16 下午3:08:52 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.IpVICVO;
import com.megaeyes.persistence.ibatis.vo.Ip_VICVO;
import com.megaeyes.persistence.ibatis.vo.ListVideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VISManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AlarmInputChannelResponse;
import com.megaeyes.web.response.AlarmOutputChannelResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.GeneralVICResponse;
import com.megaeyes.web.response.GetVideoInputServerResponse;
import com.megaeyes.web.response.IpVICResponse;
import com.megaeyes.web.response.ListAlarmInputChannelResponse;
import com.megaeyes.web.response.ListAlarmOutputChannelResponse;
import com.megaeyes.web.response.ListGenVicResponse;
import com.megaeyes.web.response.ListIpVicResponse;
import com.megaeyes.web.response.ListVisByOrganIdResponse;
import com.megaeyes.web.response.ListVisByOrganIdRsponse;
import com.megaeyes.web.response.listAICTypeResponse;
import com.megaeyes.web.response.listAOCTypeResponse;
import com.megaeyes.web.response.listVisModelResponse;

/**
 * @ClassName: VISController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-16 下午3:08:52
 * 
 */
@Controller
public class VISController extends BaseController {

	@Autowired
	VISManager vISManager;

	@ControllerDescription(description = "创建视频服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/batchCreateVIS.json")
	public void createVIS(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// System.out.println("In CreateVISJsonServlet ...");
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String installLocation = (String) request.getAttribute("location");
		String ip = (String) request.getAttribute("ip");
		String linkType = (String) request.getAttribute("linkType");
		String hc = (String) request.getAttribute("heartCycle");
		String password = (String) request.getAttribute("password");
		Long heartCycle = null;
		if (StringUtils.isNotBlank(hc)) {
			try {
				heartCycle = Long.parseLong(hc);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartCycle");
			}
		}
		String rebootTime = (String) request.getAttribute("rebootTime");

		String rc = (String) request.getAttribute("rebootCycle");
		Long rebootCycle = null;
		if (StringUtils.isNotBlank(rc)) {
			try {
				rebootCycle = Long.parseLong(rc);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("rebootCycle");
			}
		}
		String mca = (String) request.getAttribute("maxConnectAmount");
		Long maxConnectAmount = null;
		if (StringUtils.isNotBlank(mca)) {
			try {
				maxConnectAmount = Long.parseLong(mca);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxConnectAmount");
			}
		}
		String videoInputServerModelId = request
				.getParameter("videoInputServerModelId");
		String organId = (String) request.getAttribute("organId");
		String iss = (String) request.getAttribute("isSupportScheme");
		Short isSupportScheme = null;
		if (StringUtils.isNotBlank(iss)) {
			try {
				isSupportScheme = Short.parseShort(iss);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isSupportScheme");
			}
		}
		String note = (String) request.getAttribute("note");
		String type = (String) request.getAttribute("type");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = vISManager.createVIS(name, deviceNumber,
						installLocation, ip, linkType, heartCycle, rebootTime,
						rebootCycle, maxConnectAmount, videoInputServerModelId,
						organId, isSupportScheme, note, type, sipCode,
						longitude, latitude, password);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		// 返回
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除视频服务器", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteVisJson.json")
	public void deleteVis(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		// System.out.println("In deleteVISJsonServlet ...");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			vISManager.DeleteVis(id, false);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构id查询摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/list_vis_byorgan_Id.json")
	public void ListVic(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// System.out.println("In ListVicServlet ...");
		request.setCharacterEncoding("UTF-8");
		ListVisByOrganIdResponse resp = new ListVisByOrganIdResponse();
		String organId = (String) request.getAttribute("organId");
		String isqueryregstr = (String) request.getAttribute("isqueryreg");
		boolean isqueryreg = false;
		try {
			isqueryreg = Boolean.parseBoolean(isqueryregstr);
		} catch (Exception e) {
			resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
			resp.setMessage("isqueryreg");
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<VideoInputChannel> list = vISManager.listVicByOrganId(
						organId, isqueryreg);
				resp.setList(list);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "修改视频服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/updateVisJson.json")
	public void updateVIS(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		// System.out.println("In updateVIS ...");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		// 取参数
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String installLocation = (String) request.getAttribute("location");
		String ip = (String) request.getAttribute("ip");
		String linkType = (String) request.getAttribute("linkType");
		String hc = (String) request.getAttribute("heartCycle");

		// String organId=(String) request.getAttribute("organId");
		Long heartCycle = null;
		if (StringUtils.isNotBlank(hc)) {
			try {
				heartCycle = Long.parseLong(hc);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("heartCycle");
			}
		}
		String rebootTime = (String) request.getAttribute("rebootTime");
		String rc = (String) request.getAttribute("rebootCycle");
		Long rebootCycle = null;
		if (StringUtils.isNotBlank(rc)) {
			try {
				rebootCycle = Long.parseLong(rc);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("rebootCycle");
			}
		}
		String mca = (String) request.getAttribute("maxConnectAmount");
		Long maxConnectAmount = null;
		if (StringUtils.isNotBlank(mca)) {
			try {
				maxConnectAmount = Long.parseLong(mca);
				System.out.println("maxConnectAmount:" + maxConnectAmount);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("maxConnectAmount");
			}
		}
		String videoInputServerModelId = request
				.getParameter("videoInputServerModelId");
		String iss = (String) request.getAttribute("isSupportScheme");
		Short isSupportScheme = null;
		if (StringUtils.isNotBlank(iss)) {
			try {
				isSupportScheme = Short.parseShort(iss);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage("maxConnectAmount");
			}
		}
		String note = (String) request.getAttribute("note");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.updateVIS(id, name, deviceNumber, installLocation,
						ip, linkType, heartCycle, rebootTime, rebootCycle,
						maxConnectAmount, videoInputServerModelId,
						isSupportScheme, note, sipCode, longitude, latitude);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
			writePageNoZip(response, resp);
		}
	}

	@ControllerDescription(description = "根据机构查询视频服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/listVideoInputServerByOrganId.json")
	public void listVideoInputServerByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		GetVideoInputServerResponse resp = new GetVideoInputServerResponse();
		String start = (String) request.getAttribute("start");
		String limit = (String) request.getAttribute("limit");
		String name = (String) request.getAttribute("name");
		String address = (String) request.getAttribute("address");
		String ip = (String) request.getAttribute("ip");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String lineBackFew = (String) request.getAttribute("lineBackFew");
		String towerNumber = (String) request.getAttribute("towerNumber");
		String switchesIp = (String) request.getAttribute("switchesIp");
		String serialServerIp = (String) request.getAttribute("serialServerIp");
		String voltageLevel = (String) request.getAttribute("voltageLevel");
		String areaBelongs = (String) request.getAttribute("areaBelongs");
		String type = (String) request.getAttribute("type");
		if (StringUtils.isBlank(deviceNumber))
			deviceNumber = null;
		String organId = (String) request.getAttribute("organId");
		try {
			List vis = vISManager.getVISByOrganId(start, limit, name, address,
					deviceNumber, lineBackFew, towerNumber, switchesIp,
					serialServerIp, voltageLevel, areaBelongs, type, organId);
			int count = vISManager.getVISByOrganIdCount(name, address,
					deviceNumber, lineBackFew, towerNumber, switchesIp,
					serialServerIp, voltageLevel, areaBelongs, type, organId);
			resp.setVis(vis);
			resp.setTotalCount(count + "");
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "根据用户查询视频服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/listVideoInputServerByUserId.json")
	public void listVideoInputServerByUserId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		GetVideoInputServerResponse resp = new GetVideoInputServerResponse();
		String start = (String) request.getAttribute("start");
		String limit = (String) request.getAttribute("limit");
		String name = (String) request.getAttribute("name");
		String address = (String) request.getAttribute("address");
		String ip = (String) request.getAttribute("ip");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String lineBackFew = (String) request.getAttribute("lineBackFew");
		String towerNumber = (String) request.getAttribute("towerNumber");
		String switchesIp = (String) request.getAttribute("switchesIp");
		String serialServerIp = (String) request.getAttribute("serialServerIp");
		String voltageLevel = (String) request.getAttribute("voltageLevel");
		String areaBelongs = (String) request.getAttribute("areaBelongs");
		String type = (String) request.getAttribute("type");
		if (StringUtils.isBlank(deviceNumber))
			deviceNumber = null;
		String userId = (String) request.getAttribute("userId");
		try {
			List vis = vISManager.getVISByUserId(start, limit, name, address,
					deviceNumber, lineBackFew, towerNumber, switchesIp,
					serialServerIp, voltageLevel, areaBelongs, type, userId);
			int count = vISManager.getVISByUserIdCount(name, address,
					deviceNumber, lineBackFew, towerNumber, switchesIp,
					serialServerIp, voltageLevel, areaBelongs, type, userId);
			resp.setVis(vis);
			resp.setTotalCount(count + "");
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "创建摄像头", isLog = true, isCheckSession = true)
	@RequestMapping("/createGVIC.json")
	public void createvic(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		// 检查摄像头License
		resp.setCode(checkVicLicence());

		String visId = (String) request.getAttribute("visId");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request.getAttribute("location");
		String channelId = (String) request.getAttribute("channelId");
		if (StringUtils.isBlank(channelId)) {
			channelId = "1";
		}
		String hasPan = (String) request.getAttribute("hasPan");
		String storageType = (String) request.getAttribute("storageType");
		String storageServer = (String) request.getAttribute("storageServer");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String note = (String) request.getAttribute("note");
		String isSuspended = (String) request.getAttribute("isSuspended");
		String organId = (String) request.getAttribute("organId");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String isShare = (String) request.getAttribute("isShare");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		// 报警存储ID
		String assId = (String) request.getAttribute("assId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = vISManager.createVic(visId, name, installLocation,
						channelId, hasPan, storageType, storageServer,
						dispatchServer, note, isSuspended, organId,
						epDeviceType, isShare, sipCode, longitude, latitude,
						assId);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据id删除摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/deleteGVIC.json")
	public void deletevic(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		BaseResponse resp = new BaseResponse();
		try {
			vISManager.deleteVic(id, false);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据视频服务器ID查询摄像头列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listGVICByVisId.json")
	public void listVicByVisId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String visId = (String) request.getAttribute("visId");
		ListGenVicResponse resp = new ListGenVicResponse();
		try {
			List<ListVideoInputChannelVO> vics = vISManager
					.listVicByVisId(visId);
			resp.setVics(vics);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "根据摄像头ID查询摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/getGVIC.json")
	public void getVicById(HttpServletRequest request,
			HttpServletResponse response) {
		String vicId = (String) request.getAttribute("visId");
		GeneralVICResponse resp = new GeneralVICResponse();
		try {
			resp = convertModel(vISManager.getVicById(vicId));
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "更改普通视频服务器摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/updateGVIC.json")
	public void updateVic(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String visID = (String) request.getAttribute("visId");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request.getAttribute("location");
		String hasPan = (String) request.getAttribute("hasPan");
		String channelId = (String) request.getAttribute("channelId");
		String storageType = (String) request.getAttribute("storageType");
		String storageServer = (String) request.getAttribute("storageServer");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String note = (String) request.getAttribute("note");
		String isSuspended = (String) request.getAttribute("isSuspended");
		String organId = (String) request.getAttribute("organId");
		String isShare = (String) request.getAttribute("isShare");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		// 报警存储ID
		String assId = (String) request.getAttribute("assId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.updateVic(id, name, installLocation, hasPan,
						channelId, storageType, storageServer, dispatchServer,
						note, isSuspended, organId, visID, isShare, sipCode,
						longitude, latitude, assId);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
			writePageNoZip(response, resp);
		}
	}

	@ControllerDescription(description = "创建IP摄像头", isLog = true, isCheckSession = true)
	@RequestMapping("/createIpVic.json")
	public void createIpVic(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		// 检查摄像头License
		resp.setCode(checkVicLicence());

		String visId = (String) request.getAttribute("visId");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request.getAttribute("location");
		String password = (String) request.getAttribute("password");
		String hasPan = (String) request.getAttribute("hasPan");
		String host = (String) request.getAttribute("host");
		String port = (String) request.getAttribute("port");
		if (StringUtils.isBlank(port)) {
			port = "80";
		}
		String storageType = (String) request.getAttribute("storageType");
		String storageServer = (String) request.getAttribute("storageServer");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String organId = (String) request.getAttribute("organId");
		String isShare = (String) request.getAttribute("isShare");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		String alarmStorageServerId = (String) request.getAttribute("alarmStorageServerId");
		String note = (String) request.getAttribute("note");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = vISManager.createIpVic(visId, name,
						installLocation, password, hasPan, host, port,
						storageType, storageServer, dispatchServer, organId,
						isShare, sipCode, longitude, latitude,alarmStorageServerId,note);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
			writePageNoZip(response, resp);
		}
	}

	@ControllerDescription(description = "删除IP摄像头", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteIpVic.json")
	public void deleteIpVic(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.deleteIpVic(id, false);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据ID查询IP摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/getIpVic.json")
	public void getIpVicById(HttpServletRequest request,
			HttpServletResponse response) {
		IpVICResponse resp = new IpVICResponse();
		String id = (String) request.getAttribute("id");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				resp = convertModel(vISManager.getIpVicById(id));
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据视频服务器ID查询IP摄像头", isLog = false, isCheckSession = true)
	@RequestMapping("/listIpVICByVisId.json")
	public void listRegisteredIpVicByVisId(HttpServletRequest request,
			HttpServletResponse response) {
		ListIpVicResponse resp = new ListIpVicResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String visId = (String) request.getAttribute("visId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<IpVICVO> vics = vISManager.listIpVicByVisId(visId);
				resp.setVics(convertModelvisByipvic(vics));
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "修改IP摄像头", isLog = true, isCheckSession = true)
	@RequestMapping("/updateIpVic.json")
	public void updateIpVic(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		if (StringUtils.isBlank(id)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("id");
		}
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request.getAttribute("location");
		String password = (String) request.getAttribute("password");
		String hasPan = (String) request.getAttribute("hasPan");
		String host = (String) request.getAttribute("host");
		String port = (String) request.getAttribute("port");
		if (StringUtils.isBlank(port)) {
			port = "80";
		}
		String storageType = (String) request.getAttribute("storageType");
		String channelId = (String) request.getAttribute("channelId");
		String storageServer = (String) request.getAttribute("storageServer");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String isShare = (String) request.getAttribute("isShare");
		// String epDeviceType = (String) request.getAttribute("epDeviceType");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		String alarmStorageServerId = (String) request.getAttribute("alarmStorageServerId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.updateIpVic(id, name, installLocation, password,
						hasPan, host, port, storageType, storageServer,
						dispatchServer, organId, isShare, sipCode, longitude,
						latitude, note, channelId,alarmStorageServerId);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "创建报警输入", isLog = true, isCheckSession = true)
	@RequestMapping("/createAIC.json")
	public void createAIC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String visId = (String) request.getAttribute("visId");
		String typeId = (String) request.getAttribute("typeId");
		String location = (String) request.getAttribute("location");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		String channelId = (String) request.getAttribute("channelId");
		String isShare = request.getParameter("isShare");
		if (StringUtils.isBlank(isShare)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("isShare");
		}
		// 调用中心接口
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = vISManager.createAIC(visId, name, typeId, location,
						note, organId, epDeviceType, sipCode, longitude,
						latitude, channelId, isShare);
				resp.setMessage(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除报警输入", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteAIC.json")
	public void deleteAIC(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.deleteAIC(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据ID查询报警输入", isLog = false, isCheckSession = true)
	@RequestMapping("/getAIC.json")
	public void getAIC(HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getAttribute("id");
		AlarmInputChannelResponse resp = new AlarmInputChannelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				AlarmInputChannelVO aic = vISManager.getAIC(id);
				resp.setAic(aic);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新报警输入", isLog = false, isCheckSession = true)
	@RequestMapping("/updateAIC.json")
	public void updateAIC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String name = (String) request.getAttribute("name");
		String id = (String) request.getAttribute("id");
		String typeId = (String) request.getAttribute("typeId");
		String location = (String) request.getAttribute("location");
		String note = (String) request.getAttribute("note");
		String isSupportScheme = (String) request
				.getAttribute("isSupportScheme");
		String organId = (String) request.getAttribute("organId");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		String channelId = (String) request.getAttribute("channelId");
		String isShare = request.getParameter("isShare");
		if (StringUtils.isBlank(isShare)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("isShare");
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.updateAIC(id, name, typeId, location, note,
						isSupportScheme, organId, epDeviceType, sipCode,
						longitude, latitude, channelId, isShare);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据视频服务器ID查询报警输入", isLog = false, isCheckSession = true)
	@RequestMapping("/listAICByVisId.json")
	public void listAICByVisId(HttpServletRequest request,
			HttpServletResponse response) {
		ListAlarmInputChannelResponse resp = new ListAlarmInputChannelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String visId = (String) request.getAttribute("visId");
		if (StringUtils.isBlank(visId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
		}

		// 调用中心接口
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<AlarmInputChannelVO> aics = vISManager
						.listAICByVisId(visId);
				resp.setAics(aics);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "创建报警输出", isLog = true, isCheckSession = true)
	@RequestMapping("/createAOC.json")
	public void createAOC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String name = (String) request.getAttribute("name");
		String visId = (String) request.getAttribute("visId");
		String typeId = (String) request.getAttribute("typeId");
		String location = (String) request.getAttribute("location");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String latitude = (String) request.getAttribute("latitude");
		String channelId = (String) request.getAttribute("channelId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = vISManager.createAOC(visId, name, typeId, location,
						note, organId, epDeviceType, sipCode, longitude,
						latitude, channelId);
				resp.setMessage(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新报警输出", isLog = false, isCheckSession = true)
	@RequestMapping("/updateAOC.json")
	public void updateAOC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String visId = (String) request.getAttribute("visId");
		String typeId = (String) request.getAttribute("typeId");
		String location = (String) request.getAttribute("location");
		String note = (String) request.getAttribute("note");
		String organId = (String) request.getAttribute("organId");
		String epDeviceType = (String) request.getAttribute("epDeviceType");
		String sipCode = (String) request.getAttribute("sipCode");
		String longitude = (String) request.getAttribute("longitude");
		String isSupportScheme = (String) request
				.getAttribute("isSupportScheme");
		String latitude = (String) request.getAttribute("latitude");
		String channelId = (String) request.getAttribute("channelId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.updateAOC(id, name, visId, typeId, location, note,
						isSupportScheme, organId, epDeviceType, sipCode,
						longitude, latitude, channelId);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除报警输出", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteAOC.json")
	public void deleteAOC(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				vISManager.deleteAOC(id);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据ID查询报警输出", isLog = false, isCheckSession = true)
	@RequestMapping("/getAOC.json")
	public void getAOC(HttpServletRequest request, HttpServletResponse response) {
		AlarmOutputChannelResponse resp = new AlarmOutputChannelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				AlarmOutputChannel aoc = vISManager.getAOC(id);
				resp.setAoc(aoc);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询报警输入类型", isLog = false, isCheckSession = true)
	@RequestMapping("/listAICType.json")
	public void listAICType(HttpServletRequest request,
			HttpServletResponse response) {
		listAICTypeResponse resp = new listAICTypeResponse();

		try {
			List<AlarmInputChannelType> list = vISManager.listAICType();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询报警输出类型", isLog = false, isCheckSession = true)
	@RequestMapping("/listAOCType.json")
	public void listAOCType(HttpServletRequest request,
			HttpServletResponse response) {
		listAOCTypeResponse resp = new listAOCTypeResponse();
		try {
			List<AlarmOutputChannelType> list = vISManager.listAOCType();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据视频服务器ID查询报警输出", isLog = false, isCheckSession = true)
	@RequestMapping("/listAOCByVisId.json")
	public void listAOCByVisId(HttpServletRequest request,
			HttpServletResponse response) {
		ListAlarmOutputChannelResponse resp = new ListAlarmOutputChannelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String visId = (String) request.getAttribute("visId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<AlarmOutputChannel> aocs = vISManager
						.listAOCByVisId(visId);
				resp.setAocs(aocs);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询报警输出", isLog = false, isCheckSession = true)
	@RequestMapping("/listAOCByOrganId.json")
	public void listAOCByOrganId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ListAlarmOutputChannelResponse resp = new ListAlarmOutputChannelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String organId = (String) request.getAttribute("organId");
		if (StringUtils.isBlank(organId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("organId");
		}
		int start = 0;
		int length = 26;
		String sStart = (String) request.getAttribute("start");
		if (StringUtils.isNotBlank(sStart)) {
			try {
				start = Integer.parseInt(sStart);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("start");
			}
		}
		String limit = (String) request.getAttribute("limit");
		String name = (String) request.getAttribute("name");
		if (StringUtils.isNotBlank(limit)) {
			try {
				length = Integer.parseInt(limit);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED + "");
				resp.setMessage("limit");
			}
		}
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				Map<Object, Object> queryMap = new HashMap<Object, Object>();
				queryMap.put("organId", organId);
				queryMap.put("start", start);
				queryMap.put("limit", length);
				queryMap.put("name", name);
				List<AlarmOutputChannel> aocs = vISManager
						.listAOCByOrganId(queryMap);
				resp.setAocs(aocs);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询视频服务器", isLog = false, isCheckSession = true)
	@RequestMapping("/listVisByOrganId.json")
	public void listVisByOrganId(HttpServletRequest request,
			HttpServletResponse response) {
		ListVisByOrganIdRsponse resp = new ListVisByOrganIdRsponse();
		resp.setCode(ErrorCode.SUCCESS);
		String organId = (String) request.getAttribute("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				List<VideoInputServerVO> list = vISManager
						.listVisByOrganId(organId);
				resp.setVisList(list);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询设备型号列表", isLog = false, isCheckSession = true)
	@RequestMapping("/listVisModel.json")
	public void listVisModel(HttpServletRequest request,
			HttpServletResponse response) {
		listVisModelResponse resp = new listVisModelResponse();
		resp.setCode(ErrorCode.SUCCESS);
		try {
			List<VideoInputServerModel> list = vISManager.listVisModel();
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新视频存储周期", isLog = false, isCheckSession = true)
	@RequestMapping("/updateStoreScheme.json")
	public void updateStoreScheme(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String vicId = (String) request.getAttribute("vicId");
		String storePlanHourFlag = (String) request
				.getAttribute("storePlanHourFlag");
		String remoteStorePlanHourFlag = request
				.getParameter("remoteStorePlanHourFlag");
		String isfgFlag = (String) request.getAttribute("isfgFlag");
		try {
			vISManager.updateStoreScheme(vicId, storePlanHourFlag,
					remoteStorePlanHourFlag, isfgFlag);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	/**
	 * 将通过数据库直接查询出来的数据模型转换为网络中需要的传输模型（DTO）
	 * 
	 * @param vic
	 * @return
	 */
	private GeneralVICResponse convertModel(VideoInputChannelVO vic) {
		GeneralVICResponse response = new GeneralVICResponse();
		response.setId(vic.getId());
		response.setName(vic.getName());
		response.setInstallLocation(vic.getInstallLocation());
		response.setHasPan(vic.getHasPan().intValue() == 1 ? true : false);
		response.setChannelId(vic.getChannelId().toString());
		response.setStoreType(vic.getStoreType().toString());
		response.setStorageServerId(vic.getRemoteStorageServerId());
		response.setDispatchServerId(vic.getDispatchServerId());
		response.setSuspended(vic.getIsSuspended().intValue() == 1 ? true
				: false);
		response.setNote(vic.getNote());
		response.setStorePlanHourFlag(vic.getStorePlanHourFlag());
		response.setRemoteStorePlanHourFlag(vic.getRemoteStorePlanHourFlag());
		response.setMessage(ErrorCode.SUCCESS);
		response.setOrganId(vic.getOrganId());
		response.setEp_codeid(vic.getEp_codeid());
		response.setSubdivision_name(vic.getSubdivision_name());
		response.setCommunion(vic.isCommunion());
		response.setSipCode(vic.getSipCode());
		response.setLongitude(vic.getLongitude());
		response.setLatitude(vic.getLatitude());
		response.setAssId(vic.getAlarmStorageServerId());
		return response;
	}

	/**
	 * 将通过数据库直接查询出来的数据模型转换为网络中需要的传输模型（DTO）
	 * 
	 * @param vics
	 * @return
	 */
	private List<GeneralVICResponse> convertModel(List<VideoInputChannel> vics) {
		List<GeneralVICResponse> responseVics = new ArrayList<GeneralVICResponse>();
		for (VideoInputChannel vic : vics) {
			GeneralVICResponse response = new GeneralVICResponse();
			response.setId(vic.getId());
			response.setName(vic.getName());
			response.setInstallLocation(vic.getInstallLocation());
			response.setStoreType(vic.getStoreType().toString());
			response.setStorageServerId(vic.getRemoteStorageServerId());
			response.setDispatchServerId(vic.getDispatchServerId());
			response.setHasPan(vic.getHasPan().intValue() == 1 ? true : false);
			response.setChannelId(vic.getChannelId().toString());
			response.setSuspended(vic.getIsSuspended().intValue() == 1 ? true
					: false);
			response.setNote(vic.getNote());
			response.setNaming(vic.getNaming());
			response.setCommunion(vic.getIsShare() == null ? false : vic
					.getIsShare() == 1);
			response.setRemoteStorePlanHourFlag(vic
					.getRemoteStorePlanHourFlag());
			response.setStorePlanHourFlag(vic.getStorePlanHourFlag());
			response.setOrganId(vic.getOrganId());
			response.setOverWirteFlag(String.valueOf(vic.getOverWriteFlag()));
			responseVics.add(response);
		}
		return responseVics;
	}

	/**
	 * 将通过数据库直接查询出来的数据模型转换为网络中需要的传输模型（DTO）
	 * 
	 * @param ipvic
	 * @return
	 */
	private IpVICResponse convertModel(Ip_VICVO ipvic) {
		IpVICResponse response = new IpVICResponse();
		response.setId(ipvic.getId());
		response.setName(ipvic.getName());
		response.setInstallLocation(ipvic.getInstallLocation());
		response.setPassword(ipvic.getPassword());
		response.setHasPan(ipvic.getHasPan().equals("1"));
		response.setHost(ipvic.getHost());
		response.setPort(ipvic.getPort());
		response.setStoreType(ipvic.getStoreType());
		response.setStorageServerId(ipvic.getRemoteStorageServerId());
		response.setDispatchServerId(ipvic.getDispatchServerId());
		response.setNote(ipvic.getNote());
		response.setStoreCycle(ipvic.getStoreCycle());
		response.setRemoteStorePlanHourFlag(ipvic.getRemoteStorePlanHourFlag());
		response.setLocalStoreCycle(ipvic.getLocalStoreCycle());
		response.setStorePlanHourFlag(ipvic.getStorePlanHourFlag());
		response.setOrganId(ipvic.getOrganId());
		response.setCommunion(ipvic.isCommunion());
		response.setEp_codeid(ipvic.getEp_codeid());
		response.setSubdivision_name(ipvic.getSubdivision_name());
		response.setSipCode(ipvic.getSipCode());
		response.setLongitude(ipvic.getLongitude());
		response.setLatitude(ipvic.getLatitude());
		return response;
	}

	/**
	 * 将通过数据库直接查询出来的数据模型转换为网络中需要的传输模型（DTO）
	 * 
	 * @param visbyipvic
	 * @return
	 */
	private List<IpVICResponse> convertModelvisByipvic(List<IpVICVO> vics) {
		List<IpVICResponse> responseVics = new ArrayList<IpVICResponse>();
		for (IpVICVO vic : vics) {
			IpVICResponse response = new IpVICResponse();
			response.setId(vic.getId());
			response.setName(vic.getName());
			response.setInstallLocation(vic.getInstallLocation());
			response.setPassword(vic.getPassword());
			response.setHasPan("1".equals(vic.getHasPan()) ? true : false);
			response.setHost(vic.getHost());
			response.setPort(vic.getPort());
			response.setStoreType(vic.getStoreType());
			response.setStorageServerId(vic.getRemoteStorageServerId());
			response.setDispatchServerId(vic.getDispatchServerId());
			response.setNote(vic.getNote());
			response.setRemoteStorePlanHourFlag(vic.getRemoteStorePlanHourFlag());
			response.setStorePlanHourFlag(vic.getStorePlanHourFlag());
			response.setNaming(vic.getNaming());
			response.setSipCode(vic.getSipCode());
			response.setLatitude(vic.getLatitude());
			response.setLongitude(vic.getLocalStoreCycle());
			response.setOrganId(vic.getOrganId());
			response.setAlarmStorageServerId(vic.getAlarmStorageServerId());
			response.setCommunion(vic.getIsShare() == null ? false : vic
					.getIsShare().equals("1"));
			responseVics.add(response);
		}
		return responseVics;
	}

}
