/**   
* @Title: EpIntelligentDetectionController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-2 上午3:23:16 
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
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import com.megaeyes.persistence.ibatis.vo.EpIntelligentDetectionAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListDeviceByIntelligentVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BindEpRMonitorDeviceManager;
import com.megaeyes.service.iface.EpIntelligentDetectionManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListDeviceByIntelligentResponse;
import com.megaeyes.web.response.ListEIDAndDomainResponse;
import com.megaeyes.web.response.ListEpIntelligentDetectionResponse;
import com.megaeyes.web.response.organdevicetree.epdevice.DeviceNode;

/** 
 * @ClassName: EpIntelligentDetectionController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午3:23:16 
 *  
 */
@Controller
public class EpIntelligentDetectionController extends BaseController {
	@Autowired
	EpIntelligentDetectionManager epIntelligentDetectionManager;
	@Autowired
	BindEpRMonitorDeviceManager bindEpRMonitorDeviceManager;
	
	/**
	* @Title: createEID 
	* @Description: 创建智能监测设备
	* @param request
	* @param response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "创建智能监测设备",isLog=true,isCheckSession=true)
	@RequestMapping("/createEID.json")
	public void createEID(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String parentId = (String) request.getAttribute("parentId");
		BigDecimal type = null;
		String type1 = (String) request.getAttribute("type");
		if(StringUtils.isNotBlank(type1)){
			try{
				type = new BigDecimal(type1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("typeNotNumber");
			}
		}
		String note = (String) request.getAttribute("note");					
		String operation = (String) request.getAttribute("operation");
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = epIntelligentDetectionManager.createEID(name,organId,parentId,note,type,operation);
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
	* @Title: deleteEID 
	* @Description: 删除智能监测设备
	* @param request 
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "删除智能监测设备",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEID.json")
	public void deleteEID(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			epIntelligentDetectionManager.deleteEID(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: updateEID 
	* @Description: 根据指定ID修改智能监测设备
	* @param @param request
	* @param @param response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据指定ID修改智能监测设备",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEID.json")
	public void updateEID(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String parentId = (String) request.getAttribute("parentId");
		String note = (String) request.getAttribute("note");
		String operation = (String)request.getAttribute("operation");
		
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				epIntelligentDetectionManager.updateEID(id,name,organId,parentId,note,null,operation);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listEIDByOrganId 
	* @Description: 根据机构ID查询智能监测设备列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据机构ID查询智能监测设备列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEIDByOrganId.json")
	public void listEIDByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListEpIntelligentDetectionResponse resp = new ListEpIntelligentDetectionResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<EpIntelligentDetectionAndDeviceVO> eid = epIntelligentDetectionManager.listEIDByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpIntelligentDetection(eid);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: addOrUpdateEIDAndEpRMonitorDevice 
	* @Description: 绑定智能监测设备监控设备
	* @param request
	* @param response
	* @param @throws JSONException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "绑定智能监测设备监控设备",isLog=false,isCheckSession=true)
	@RequestMapping("/addOrUpdateEIDAndEpRMonitorDevice.json")
	public void addOrUpdateEIDAndEpRMonitorDevice(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			BigDecimal deviceType = new BigDecimal(3);
			BigDecimal monitorType = new BigDecimal(3);
			JSONObject jsonObject = new JSONObject(jsonString);
			String deviceId = jsonObject.getString("deviceId");
			//bindEpRMonitorDeviceManager.deleteByDevice(deviceId);
			JSONArray jsonArray = jsonObject.getJSONArray("monitorIds");
			if(jsonArray.length()>0){
				for(int i=0;i<jsonArray.length();i++){
					JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
					String monitorId = jsonObj.getString("monitorId");
					
					bindEpRMonitorDeviceManager.addOrUpdateEIDAndEpRMonitorDevice(deviceType,monitorType,deviceId,monitorId);
				}
			}else{
				throw new BusinessException("monitorId",ErrorCode.PARAMETER_NOT_FOUND);
			}
			resp.setCode(ErrorCode.SUCCESS);
			
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listDeviceByIntelligentId 
	* @Description: 根据智能监测设备ID查询监控设备ID 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据智能监测设备ID查询监控设备",isLog=false,isCheckSession=true)
	@RequestMapping("/listDeviceByIntelligentId.json")
	public void listDeviceByIntelligentId(HttpServletRequest request,
			HttpServletResponse response){
		ListDeviceByIntelligentResponse resp = new ListDeviceByIntelligentResponse();
		String intelligentId = (String) request.getAttribute("intelligentId");
		String organId = (String) request.getAttribute("organId");
		try{
			List<ListDeviceByIntelligentVO> device = epIntelligentDetectionManager.listDeviceByIntelligentId(intelligentId,organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setDevice(device);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	
	@ControllerDescription(description = "查询功能区和智能检测设备树",isLog=false,isCheckSession=true)	
	@RequestMapping("/listEIDAndDomainByOrganId.json")
	public void listEIDAndDomainByOrganId(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		ListEIDAndDomainResponse resp = new ListEIDAndDomainResponse();
		String organId = (String) request.getAttribute("organId");
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			List<EpDevice> devices = epIntelligentDetectionManager.listEIDAndDomainByOrganId(organId);
			DeviceNode root = new DeviceNode();
			for (EpDevice device : devices) {
				if(device.getParentId()==null||device.getParentId().equals("")){
					root.setId(device.getId());
					root.setName(device.getName());
					root.setType(device.getType().toString());	
					root.setOperation(device.getOperation());
				}				
			}
			root.generateTree(devices, root);
			resp.setRoot(root);
			resp.setCode(ErrorCode.SUCCESS);			
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		
		writePageNoZip(response, resp);
	}
}
