/**   
* @Title: AccessServerController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-2-29 上午8:01:40 
* @version V1.0   
*/ 
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.utils.StdIdGenerator;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AccessServerResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAccessServerResponse;

/** 
 * @ClassName: AccessServerController 
 * @Description: 接入服务器
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-2-29 上午8:01:40 
 *  
 */
@Controller
public class AccessServerController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;
	
	/**
	 * @throws UnsupportedEncodingException 
	* @Title: createAccessServer 
	* @Description: 创建接入服务器 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="创建接入服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/createAS.json")
	public void createAccessServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String location = (String) request.getAttribute("location");
		String number = (String) request.getAttribute("deviceNumber");
		String note = (String) request.getAttribute("note");
		String ip = (String) request.getAttribute("ip");
		String ip1 = (String) request.getAttribute("ip1");
		try{
			String id=centerDeviceManager.createAccessServer(name, naming,location, number, note, ip, ip1);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		}catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: deleteAccessServer 
	* @Description: 删除接入服务器 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除接入服务器",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteAS.json")
	public void deleteAccessServer(HttpServletRequest request,
			HttpServletResponse response){
		
		BaseResponse resp = new BaseResponse();	
		String id = (String) request.getAttribute("id");
		
		try{
			centerDeviceManager.deleteAccessServer(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listAccessServer 
	* @Description:获取所有接入服务器 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="查询接入列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listAccessServer.json")
	public void listAccessServer(HttpServletRequest request,
			HttpServletResponse response){
		ListAccessServerResponse resp = new ListAccessServerResponse();
		
		try{
			List<AccessServer> accessServer = centerDeviceManager.listAccessServer();
//			for(int i=0;i<accessServer.size();i++){
//				System.out.println("-------------"+accessServer.get(i).getFname());
//			}
			resp.setAccessServer(accessServer);
			resp.setCode(ErrorCode.SUCCESS);
		}catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	* @Title: updateAccessServer 
	* @Description: 更改接入服务器 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="更新接入服务器",isLog=false,isCheckSession=true)
	@RequestMapping("/updateAS.json")
	public void updateAccessServer(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
	//	resp.setMessage(ErrorCode.SUCCESS);
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String installLocation = (String) request.getAttribute("location");
		String stdId = StdIdGenerator.getStdId();
		String ip1 = (String) request.getAttribute("ip1");
		String ip2 = (String) request.getAttribute("ip2");
		String note = (String) request.getAttribute("note");

		try{
			centerDeviceManager.updateAccessServer(id, name, naming,deviceNumber, installLocation, ip1, ip2, stdId, note);
			resp.setCode(ErrorCode.SUCCESS);
		}catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: getAccessServerById 
	* @Description: 获取指定ID接入服务器信息 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="查询单个接入",isLog=false,isCheckSession=true)
	@RequestMapping("/getAS.json")
	public void getAccessServerById(HttpServletRequest request,
			HttpServletResponse response){
		AccessServerResponse resp = new AccessServerResponse();
		String id = (String) request.getAttribute("id");
		try{
			AccessServer as = centerDeviceManager.getAccessServerById(id);
			resp.setCode(ErrorCode.SUCCESS);
			if(as!=null){
				resp.setId(as.getId());
				resp.setName(as.getName());
				resp.setDeviceNumber(as.getDeviceNumber());
				resp.setLocation(as.getInstallLocation());
				resp.setIp1(as.getIp());
				resp.setIp2(as.getIp1());
				resp.setNaming(as.getNaming());
//				resp.setEp_codeid("");
//				resp.setSubdivision_name("");
				resp.setNote(as.getNote());
			}
			
		}catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		
		writePageNoZip(response, resp);
	}
}
