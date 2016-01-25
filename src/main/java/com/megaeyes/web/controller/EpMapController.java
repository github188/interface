/**   
 * @Title: EpMapController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-25 上午10:42:10 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpMap;
import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.MapManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListEpMapResponse;
import com.megaeyes.web.response.ListEpRMapDeviceResponse;

/**
 * @ClassName: EpMapController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-25 上午10:42:10
 * 
 */
@Controller
public class EpMapController extends BaseController {
	@Autowired
	MapManager mapManager;

	@ControllerDescription(description = "创建地图",isLog=true,isCheckSession=true)
	@RequestMapping("/uploadMap.json")
	public void CreateEpMap(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			FileUploadException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.RESOURCE_NOT_FOUND);
		String organId = "";
		String name = "";
		String type = "";
		String note = "";
		byte[] image = null;
		// 检查是否是文件上传请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			resp.setCode(ErrorCode.SUCCESS);
			// 解析请求
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				String fieldName = item.getFieldName();
				System.out.println("fieldName:" + fieldName);
				// 简单文本参数部分，得到sessionId,organId,name,type,note参数
				if ("organId".equals(fieldName)) {
					organId = item.getString();
					if (StringUtils.isBlank(organId)) {
						resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
						resp.setMessage("organId");
						break;
					}
				} else if ("name".equals(fieldName)) {
					name = item.getString();
				} else if ("type".equals(fieldName)) {
					type = item.getString();
					if (StringUtils.isBlank(type)) {
						resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
						resp.setMessage("type");
						break;
					}
				} else if ("note".equals(fieldName)) {
					note = item.getString();
				}// 最后是图片流
				else {
					System.out.println(item.getName());
					image = item.get();
				}
			}
			System.out.println(organId + ":" + name + ":" + type + ":" + note
					+ ":" + "------------:" + image.length);
			if (resp.getCode().equals(ErrorCode.SUCCESS)) {
				try {
					String id = mapManager.createEpMap(organId, name, type,
							note, image);
					resp.setMessage(id);
				} catch (BusinessException be) {
					resp.setCode(be.getCode());
					resp.setMessage(be.getMessage());
				}
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除地图",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEpMap.json")
	public void deleteEpMap(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			mapManager.deleteEpMap(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构ID查询地图信息",isLog=false,isCheckSession=true)
	@RequestMapping("/listEpMap.json")
	public void listEpMap(HttpServletRequest request,
			HttpServletResponse response) {
		ListEpMapResponse resp = new ListEpMapResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<EpMap> list = mapManager.listEpMap(organId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "查询地图图片",isLog=false,isCheckSession=true)
	@RequestMapping("/getEpMapImage.json")
	public void getEpMapImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		response.setContentType("image/jpeg");
		try {
			EpMap map = mapManager.getEpMap(id);
			if (map != null) {
				byte[] image = map.getImage();
				for (int i = 0; i < image.length; i++) {
					response.getOutputStream().write(image[i]);
				}
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
			writePageNoZip(response, resp);
		}

	}

	@ControllerDescription(description = "更新地图",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEpMap.json")
	public void updateEpMap(HttpServletRequest request,
			HttpServletResponse response) throws FileUploadException,
			UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.RESOURCE_NOT_FOUND);
		String id = "";
		String organId = "";
		String name = "";
		String type = "";
		String note = "";
		byte[] image = null;
		// 检查是否是文件上传请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			resp.setCode(ErrorCode.SUCCESS);
			// 解析请求
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				String fieldName = item.getFieldName();
				System.out.println("fieldName:" + fieldName);
				// 简单文本参数部分，得到sessionId,organId,name,type,note参数
				if ("id".equals(fieldName)) {
					id = item.getString();
					if (StringUtils.isBlank(id)) {
						resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
						resp.setMessage("id");
						break;
					}
				} else if ("organId".equals(fieldName)) {
					organId = item.getString();
					if (StringUtils.isBlank(organId)) {
						resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
						resp.setMessage("organId");
						break;
					}
				} else if ("name".equals(fieldName)) {
					name = item.getString();
				} else if ("type".equals(fieldName)) {
					type = item.getString();
					if (StringUtils.isBlank(type)) {
						resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
						resp.setMessage("type");
						break;
					}
				} else if ("note".equals(fieldName)) {
					note = item.getString();
				}// 最后是图片流
				else {
					System.out.println(item.getName());
					image = item.get();
				}
			}
			System.out.println(organId + ":" + name + ":" + type + ":" + note
					+ ":" + "------------:" + image.length);
			if (resp.getCode().equals(ErrorCode.SUCCESS)) {
				try {
					mapManager
							.updateEpMap(id, organId, name, type, note, image);
					resp.setCode(ErrorCode.SUCCESS);
				} catch (BusinessException be) {
					resp.setCode(be.getCode());
					resp.setMessage(be.getMessage());
				}
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "创建地图设备关联",isLog=false,isCheckSession=true)
	@RequestMapping("/createEpRMapDevice.json")
	public void createEpRMapDevice(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String epMapId = (String) request.getAttribute("epMapId");
		String deviceId = (String) request.getAttribute("deviceId");
		String deviceTypestr = (String) request.getAttribute("deviceType");
		Short deviceType = null;
		if (!StringUtils.isBlank(deviceTypestr)) {
			try {
				deviceType = Short.parseShort(deviceTypestr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("deviceType");
			}
		}
		String coordinateX = (String) request.getAttribute("coordinateX");
		String coordinateY = (String) request.getAttribute("coordinateY");
		String left = (String) request.getAttribute("left");
		String right = (String) request.getAttribute("right");
		String top = (String) request.getAttribute("top");
		String bottom = (String) request.getAttribute("bottom");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = mapManager.createEpEpRMapDevice(epMapId, deviceId,
						deviceType, coordinateX, coordinateY, left, right, top,
						bottom);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除地图设备关联",isLog=false,isCheckSession=true)
	@RequestMapping("/deleteEpRMapDevice.json")
	public void deleteEpRMapDevice(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			mapManager.deleteEpRMapDevice(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据地图ID查询关联的设备",isLog=false,isCheckSession=true)
	@RequestMapping("/ListEpRMapDeviceByMapId.json")
	public void ListEpRMapDeviceByMapId(HttpServletRequest request,
			HttpServletResponse response) {
		ListEpRMapDeviceResponse resp = new ListEpRMapDeviceResponse();
		String epMapId = (String) request.getAttribute("epMapId");
		try {
			List<EpRMapDevice> list = mapManager
					.ListEpRMapDeviceByMapId(epMapId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新地图与设备关联",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEpRMapDevice.json")
	public void updateEpRMapDevice(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String epMapId = (String) request.getAttribute("epMapId");
		String deviceId = (String) request.getAttribute("deviceId");
		String deviceTypestr = (String) request.getAttribute("deviceType");
		Short deviceType = null;
		if (!StringUtils.isBlank(deviceTypestr)) {
			try {
				deviceType = Short.parseShort(deviceTypestr);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("deviceType");
			}
		}
		String coordinateX = (String) request.getAttribute("coordinateX");
		String coordinateY = (String) request.getAttribute("coordinateY");
		String left = (String) request.getAttribute("left");
		String right = (String) request.getAttribute("right");
		String top = (String) request.getAttribute("top");
		String bottom = (String) request.getAttribute("bottom");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				mapManager.updateEpRMapDevice(id, epMapId, deviceId,
						deviceType, coordinateX, coordinateY, left, right, top,
						bottom);
				resp.setCode(ErrorCode.SUCCESS);
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
}