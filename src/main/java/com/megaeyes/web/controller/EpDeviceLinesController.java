/**   
* @Title: EpDeviceController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-28 上午7:53:32 
* @version V1.0   
*/ 
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BindEpRMonitorDeviceManager;
import com.megaeyes.service.iface.EpDeviceLinesManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListDeviceByLinesIdResponse;
import com.megaeyes.web.response.ListEpDeviceResponse;

/** 
 * @ClassName: EpDeviceController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-28 上午7:53:32 
 *  
 */
@Controller
public class EpDeviceLinesController extends BaseController {
	@Autowired
	EpDeviceLinesManager epDeviceLinesManager;
	@Autowired
	BindEpRMonitorDeviceManager bindEpRMonitorDeviceManager;
	
	/**
	* @Title: createED 
	* @Description: 创建线路
	* @param request
	* @param response
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description="创建线路" ,isLog=true,isCheckSession=true)
	@RequestMapping("/createEDL.json")
	public void createEDL(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String parentId = (String) request.getAttribute("parentId");
		String note = (String) request.getAttribute("note");
		
		try{
			String id = epDeviceLinesManager.createEDL(name,organId,parentId,note);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: deleteEDL 
	* @Description: 删除线路
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除线路",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEDL.json")
	public void deleteEDL(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();	
		String id = (String) request.getAttribute("id");
		try{
			epDeviceLinesManager.deleteEDL(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: listEDL 
	* @Description: 根据机构ID查询所有线路列表
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据机构ID查询所有线路列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEDLByOrganId.json")
	public void listEDLByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListEpDeviceResponse resp = new ListEpDeviceResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<EpDevice> ed = epDeviceLinesManager.listEDLByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpDevice(ed);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	
	/**
	* @Title: updateEDL 
	* @Description: 根据指定ID修改线路
	* @param request
	* @param response
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description="根据指定ID修改线路",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEDL.json")
	public void updateEDL(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String parentId = (String) request.getAttribute("parentId");
		String note = (String) request.getAttribute("note");
		
		try{
			epDeviceLinesManager.updateEDL(id,name,organId,parentId,note);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: addOrUpdateEIDAndEpRMonitorDevice 
	* @Description: 绑定输电线路监控设备
	* @param @param request
	* @param @param response
	* @param @throws JSONException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description=" 绑定输电线路监控设备",isLog=false,isCheckSession=true)
	@RequestMapping("/addOrUpdateEDLAndEpRMonitorDevice.json")
	public void addOrUpdateEDLAndEpRMonitorDevice(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			BigDecimal deviceType = new BigDecimal(2);
			BigDecimal monitorType = new BigDecimal(2);
			JSONObject jsonObject = new JSONObject(jsonString);
			String deviceId = jsonObject.getString("deviceId");
			bindEpRMonitorDeviceManager.deleteByDevice(deviceId);
			JSONArray jsonArray = jsonObject.getJSONArray("monitorIds");
			if(jsonArray.length()>0){
				for(int i=0;i<jsonArray.length();i++){
					JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
					String monitorId = jsonObj.getString("monitorId");
					bindEpRMonitorDeviceManager.bindEpRMonitorDevice(deviceType,monitorType,deviceId,monitorId);
				}
			}else{
				bindEpRMonitorDeviceManager.deleteByDevice(deviceId);
			}
			resp.setCode(ErrorCode.SUCCESS);
			
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listDeviceByLinesId 
	* @Description: 根据输电线路ID查询监控设备列表 
	* @param @param request
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据输电线路ID查询监控设备列表 ",isLog=false,isCheckSession=true)
	@RequestMapping("/listDeviceByLinesId.json")
	public void listDeviceByLinesId(HttpServletRequest request,
			HttpServletResponse response){
		ListDeviceByLinesIdResponse resp = new ListDeviceByLinesIdResponse();
		String linesId = (String) request.getAttribute("linesId");
		try{
			List<ListVicVO> device = epDeviceLinesManager.listDeviceByLinesId(linesId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setDevice(device);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
