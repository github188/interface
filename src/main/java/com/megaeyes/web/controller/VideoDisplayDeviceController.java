/**   
* @Title: VideoDisplayDeviceController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-22 上午8:19:46 
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

import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.iface.VOCManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListVideoDisplayDeviceResponse;
import com.megaeyes.web.response.VideoDisplayDeviceResponse;

/** 
 * @ClassName: VideoDisplayDeviceController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-22 上午8:19:46 
 *  
 */
@Controller
public class VideoDisplayDeviceController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;
	@Autowired
	VOCManager vocManager;
	
	/**
	* @Title: createVideoDisplayDevice 
	* @Description: 创建显示服务器 
	* @param request
	* @param response
	* @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description="创建显示服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/createVDD.json")
	public void createVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip = (String) request.getAttribute("ip");
		String linkType = (String) request.getAttribute("linkType");
		
		Long heartCycle = null;
		String s_heartCycle = (String) request.getAttribute("heartCycle");
		if (StringUtils.isNotBlank(s_heartCycle)) {
			try{
			heartCycle = new Long(s_heartCycle);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartCycle");
			}
		}
		String rebootTime = (String) request.getAttribute("rebootTime");
		Long rebootCycle = null;
		String rebootCycle1 = (String) request.getAttribute("rebootCycle");
		if(StringUtils.isNotBlank(rebootCycle1)){
			try{
				rebootCycle = Long.parseLong(rebootCycle1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("rebootCycle");
			}
		}
		String organId = (String) request.getAttribute("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try{
				String id = vocManager.createVideoDisplayDevice(name, naming,installLocation,
						note, deviceNumber, ip, linkType, heartCycle, rebootTime, rebootCycle, organId);
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
	* @Title: deleteVideoDisplayDevice 
	* @Description: 删除显示服务器 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除显示服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteVDD.json")
	public void deleteVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			vocManager.deleteVideoDisplayDevice(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listVideoDisplayDevice 
	* @Description: 查询所有显示服务器列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据机构ID查询显示服务器列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listVDDByOrganId.json")
	public void listVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response){
		ListVideoDisplayDeviceResponse resp = new ListVideoDisplayDeviceResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<VideoDisplayDevice> videoDisplayDevice = vocManager.listVideoDisplayDeviceByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVideoDisplayDevice(videoDisplayDevice);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: getVideoDisplayDevice 
	* @Description: 根据ID查询 显示服务器
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="ID查询显示服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/getVDD.json")
	public void getVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response){
		VideoDisplayDeviceResponse resp = new VideoDisplayDeviceResponse();
		String id = (String) request.getAttribute("id");
		try{
			VideoDisplayDevice vdd = vocManager.getVideoDisplayDevice(id);
			resp.setCode(ErrorCode.SUCCESS);
			if(vdd!=null){
				resp.setId(vdd.getId());
				resp.setOptimisticLock(vdd.getOptimisticLock());
				resp.setName(vdd.getName());
				resp.setNaming(vdd.getNaming());
				resp.setInstallLocation(vdd.getInstallLocation());
				resp.setNote(vdd.getNote());
				resp.setDeviceNumber(vdd.getDeviceNumber());
				resp.setIp(vdd.getIp());
				resp.setLinkType(vdd.getLinkType());
				resp.setHeartCycle(vdd.getHeartCycle());
				resp.setRebootTime(vdd.getRebootTime());
				resp.setRebootCycle(vdd.getRebootCycle());
				resp.setVideoIntputAmount(vdd.getVideoIntputAmount());
				resp.setVideoOutputAmount(vdd.getVideoOutputAmount());
				resp.setCompanyId(vdd.getCompanyId());
				resp.setoOrganId(vdd.getoOrganId());
			}

		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	@ControllerDescription(description="查询所有显示服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/listVDD.json")
	public void listAllVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response){
		ListVideoDisplayDeviceResponse resp = new ListVideoDisplayDeviceResponse();
		try{
			List<VideoDisplayDevice> videoDisplayDevice = vocManager.listDDS();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVideoDisplayDevice(videoDisplayDevice);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: updateVideoDisplayDevice 
	* @Description: 更新显示服务器
	* @param request
	* @param response
	* @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description="更新查询显示服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/updateVDD.json")
	public void updateVideoDisplayDevice(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip = (String) request.getAttribute("ip");
		String linkType = (String) request.getAttribute("linkType");
		
		Long heartCycle = null;
		String s_heartCycle = (String) request.getAttribute("heartCycle");
		if (StringUtils.isNotBlank(s_heartCycle)) {
			try{
				heartCycle = new Long(s_heartCycle);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("heartCycle");
			}
		}
		String rebootTime = (String) request.getAttribute("rebootTime");
		Long rebootCycle = null;
		String rebootCycle1 = (String) request.getAttribute("rebootCycle");
		if(StringUtils.isNotBlank(rebootCycle1)){
			try{
				rebootCycle = Long.parseLong(rebootCycle1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("rebootCycle");
			}
		}
		String organId = (String) request.getAttribute("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try{
				vocManager.updateVideoDisplayDevice(id, name, naming,installLocation,
						note, deviceNumber, ip, linkType, heartCycle, rebootTime, rebootCycle, organId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);	
	}
}
