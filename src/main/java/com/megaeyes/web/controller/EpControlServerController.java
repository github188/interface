/**   
* @Title: EpControlServerController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-7 上午2:38:24 
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

import com.megaeyes.persistence.ibatis.model.EpControlServer;
import com.megaeyes.persistence.ibatis.model.EpProberType;
import com.megaeyes.persistence.ibatis.vo.ListEpMonitorDeviceAndEpProberVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpControlServerManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListEpMonitorDeviceAndEpProber;
import com.megaeyes.web.response.ListEpProberTypeResponse;
import com.megaeyes.web.response.ListPLCResponse;

/** 
 * @ClassName: EpControlServerController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-7 上午2:38:24 
 *  
 */
@Controller
public class EpControlServerController extends BaseController {
	@Autowired
	EpControlServerManager epControlServerManager;
	
	
	/**
	* @Title: createECS 
	* @Description: 创建太阳能控制器
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "创建太阳能控制器",isLog=true,isCheckSession=true)
	@RequestMapping("/createECS.json")
	public void createECS(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String gatherServerId = (String) request.getAttribute("gatherServerId");
		String name = (String) request.getAttribute("name");
		String position = (String) request.getAttribute("position");
		String organId = (String) request.getAttribute("organId");
		Integer cycle = 10000;
		String cycle1 = (String) request.getAttribute("cycle");
		if(StringUtils.isNotBlank(cycle1)){
			try{
				cycle = Integer.parseInt(cycle1);
			}catch(BusinessException be){
				resp.setMessage("cycle");
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
		}
		String url = (String) request.getAttribute("url");
		Integer isWarn = 0;
		String isWarn1 = (String) request.getAttribute("isWarn");
		if(StringUtils.isNotBlank(isWarn1)){
			try{
				isWarn = Integer.parseInt(isWarn1);
			}catch(BusinessException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isWarn");
			}
		}
		Integer plcIoSaveCycle = 60000;
		String plcIoSaveCycle1 = (String) request.getAttribute("plcIoSaveCycle");
		if(StringUtils.isNotBlank(plcIoSaveCycle1)){
			try{
				plcIoSaveCycle = Integer.parseInt(plcIoSaveCycle1);
			}catch(BusinessException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("plcIoSaveCycle");
			}
		}
		String plcIoSaveType = "SaveWarn";
		String plcIoSaveType1 = (String) request.getAttribute("plcIoSaveType");
		if(StringUtils.isNotBlank(plcIoSaveType1)){
			plcIoSaveType = plcIoSaveType1;
		}
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = epControlServerManager.createECS(gatherServerId,name,position,organId,cycle,url,isWarn,plcIoSaveCycle,plcIoSaveType);
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
	* @Title: createPlcECS 
	* @Description: 创建PLC 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "创建PLC",isLog=true,isCheckSession=true)
	@RequestMapping("/createPlcECS.json")
	public void createPlcECS(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String gatherServerId = (String) request.getAttribute("gatherServerId");
		String name = (String) request.getAttribute("name");
		String position = (String) request.getAttribute("position");
		String organId = (String) request.getAttribute("organId");
		String url = (String) request.getAttribute("url");
	
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = epControlServerManager.createPlcECS(gatherServerId,name,position,organId,url);
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
	* @Title: deletePlcECS 
	* @Description: 删除PLC 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "删除PLC ",isLog=true,isCheckSession=true)
	@RequestMapping("/deletePlcECS.json")
	public void deletePlcECS(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			epControlServerManager.deletePlcECS(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
		
	}
	
	/**
	* @Title: deleteECS 
	* @Description: 删除太阳能控制器
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "删除太阳能控制器",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteECS.json")
	public void deleteECS(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			epControlServerManager.deleteECS(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: updatePlcECS 
	* @Description: 修改PLC 
	* @param request
	* @param response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = " 修改PLC",isLog=false,isCheckSession=true)
	@RequestMapping("/updatePlcECS.json")
	public void updatePlcECS(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String position = (String) request.getAttribute("position");
		String organId = (String) request.getAttribute("organId");
		String url = (String) request.getAttribute("url");
		String gatherServerId = (String) request.getAttribute("gatherServerId");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				epControlServerManager.updatePlcECS(id,name,position,organId,url,gatherServerId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);		
	}
	
	
	/**
	* @Title: updateECS 
	* @Description: 修改太阳能控制器 
	* @param request
	* @param response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "修改太阳能控制器 ",isLog=false,isCheckSession=true)
	@RequestMapping("/updateECS.json")
	public void updateECS(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String position = (String) request.getAttribute("position");
		String organId = (String) request.getAttribute("organId");
		Integer cycle = 10000;
		String cycle1 = (String) request.getAttribute("cycle");
		if(StringUtils.isNotBlank(cycle1)){
			try{
				cycle = Integer.parseInt(cycle1);
			}catch(BusinessException be){
				resp.setMessage("cycle");
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
		}
		String url = (String) request.getAttribute("url");
		Integer isWarn = 0;
		String isWarn1 = (String) request.getAttribute("isWarn");
		if(StringUtils.isNotBlank(isWarn1)){
			try{
				isWarn = Integer.parseInt(isWarn1);
			}catch(BusinessException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isWarn");
			}
		}
		Integer plcIoSaveCycle = 60000;
		String plcIoSaveCycle1 = (String) request.getAttribute("plcIoSaveCycle");
		if(StringUtils.isNotBlank(plcIoSaveCycle1)){
			try{
				plcIoSaveCycle = Integer.parseInt(plcIoSaveCycle1);
			}catch(BusinessException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("plcIoSaveCycle");
			}
		}
		String plcIoSaveType = "SaveWarn";
		String plcIoSaveType1 = (String) request.getAttribute("plcIoSaveType");
		if(StringUtils.isNotBlank(plcIoSaveType1)){
			plcIoSaveType = plcIoSaveType1;
		}
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				epControlServerManager.updateECS(id,name,position,organId,cycle,url,isWarn,plcIoSaveCycle,plcIoSaveType);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: listEMDandEpProber 
	* @Description: 查询太阳能控制器列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "查询太阳能控制器列表 ",isLog=false,isCheckSession=true)
	@RequestMapping("/listEMDandEpProber.json")
	public void listEMDandEpProber(HttpServletRequest request,
			HttpServletResponse response){
		ListEpMonitorDeviceAndEpProber resp = new ListEpMonitorDeviceAndEpProber();
		String deviceId = (String) request.getAttribute("deviceId");
		try{
			List<ListEpMonitorDeviceAndEpProberVO> prober = epControlServerManager.listEMDandEpProber(deviceId);
			resp.setProber(prober);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: listPLCByGatherServerId 
	* @Description: 根据采集服务器ID查询PLC列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据采集服务器ID查询PLC列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listPLC.json")
	public void listPLC(HttpServletRequest request,
			HttpServletResponse response){
		ListPLCResponse resp = new ListPLCResponse();
		try{
			List<EpControlServer> plc = epControlServerManager.listPLC();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setPlc(plc);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: ListProberType 
	* @Description: 查询探测器类型列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "查询探测器类型列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listProberType.json")
	public void listProberType(HttpServletRequest request,
			HttpServletResponse response){
		ListEpProberTypeResponse resp = new ListEpProberTypeResponse();
		try{
			List<EpProberType> ept = epControlServerManager.listProberType();
			resp.setEpProberType(ept);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
}
