/**   
* @Title: AcAccessServerController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午7:52:16 
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

import com.megaeyes.persistence.ibatis.model.AcAccessServers;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessServersManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcAccessServersResponse;

/** 
 * @ClassName: AcAccessServerController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午7:52:16 
 *  
 */
@Controller
public class AcAccessServersController extends BaseController {
	@Autowired
	AcAccessServersManager acAccessServersManager;
	
	/**
	* @Title: createAcAccessServer 
	* @Description: 创建门禁控制器
	* @param  request
	* @param  response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="创建门禁控制器",isLog=true,isCheckSession=true)
	@RequestMapping("/createAcAccessServers.json")
	public void createAcAccessServers(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String accessPassword = (String) request.getAttribute("accessPassword");
		String installLocation = (String) request.getAttribute("installLocation");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip = (String) request.getAttribute("ip");
		String note = (String) request.getAttribute("note");
		Integer messagePort = 4001;
		String messagePort1 = (String) request.getAttribute("messagePort");
		if(StringUtils.isNotBlank(messagePort1)){
			try{
				messagePort = Integer.parseInt(messagePort1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("messagePort");
			}
		}
		String deviceType = "Newabel";
		String deviceType1 = (String) request.getAttribute("deviceType");
		if(StringUtils.isNotBlank(deviceType1)){
			deviceType = deviceType1;
		}
		String organId = (String) request.getAttribute("organId");
		String gatewayId = (String) request.getAttribute("gatewayId");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = acAccessServersManager.createAcAccessServers(name,
						accessPassword, installLocation, deviceNumber, ip,
						note, messagePort, deviceType, organId, gatewayId);
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
	* @Title: deleteAcAccessServers 
	* @Description: 删除门禁控制器 
	* @param  request
	* @param  response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除门禁控制器 ",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteAcAccessServers.json")
	public void deleteAcAccessServers(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();		
		String id = (String) request.getAttribute("id");
		try{
			acAccessServersManager.deleteAcAccessServers(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: updateAcAccessServers 
	* @Description: 更新门禁控制器
	* @param  request
	* @param  response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description=" 更新门禁控制器 ",isLog=false,isCheckSession=true)
	@RequestMapping("/updateAcAccessServers.json")
	public void updateAcAccessServers(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String accessPassword = (String) request.getAttribute("accessPassword");
		String installLocation = (String) request.getAttribute("installLocation");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String ip = (String) request.getAttribute("ip");
		String note = (String) request.getAttribute("note");
		Integer messagePort = 4001;
		String messagePort1 = (String) request.getAttribute("messagePort");
		if(StringUtils.isNotBlank(messagePort1)){
			try{
				messagePort = Integer.parseInt(messagePort1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("messagePort");
			}
		}
		String deviceType = "Newabel";
		String deviceType1 = (String) request.getAttribute("deviceType");
		if(StringUtils.isNotBlank(deviceType1)){
			deviceType = deviceType1;
		}
		String organId = (String) request.getAttribute("organId");
		String gatewayId = (String) request.getAttribute("gatewayId");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				acAccessServersManager.updateAcAccessServers(id,name,
						accessPassword, installLocation, deviceNumber, ip,
						note, messagePort, deviceType, organId, gatewayId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listAcAccessServersByOrganId 
	* @Description: 根据机构ID查询门禁控制器列表 
	* @param  request
	* @param  response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description=" 根据机构ID查询门禁控制器列表  ",isLog=false,isCheckSession=true)
	@RequestMapping("/listAcAccessServersByOrganId.json")
	public void listAcAccessServersByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListAcAccessServersResponse resp = new ListAcAccessServersResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<AcAccessServers> acAccessServers = acAccessServersManager.listAcAccessServersByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessServers(acAccessServers);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
	writePageNoZip(response, resp);	
	}
	
	/**
	 * 
	 * listAcAccessServersByGatewayId 根据门禁网关ID查询门禁控制器列表
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description=" 根据门禁网关ID查询门禁控制器列表  ",isLog=false,isCheckSession=true)
	@RequestMapping("/listAcAccessServersByGatewayId.json")
	public void listAcAccessServersByGatewayId(HttpServletRequest request,
			HttpServletResponse response){
		ListAcAccessServersResponse resp = new ListAcAccessServersResponse();
		String gatewayId = (String) request.getAttribute("gatewayId");
		try{
			List<AcAccessServers> acAccessServers = acAccessServersManager.listAcAccessServersByGatewayId(gatewayId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessServers(acAccessServers);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
}
