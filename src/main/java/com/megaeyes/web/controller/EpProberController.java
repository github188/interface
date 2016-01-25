/**   
* @Title: EpProberController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午9:58:24 
* @version V1.0   
*/ 
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
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

import com.megaeyes.persistence.ibatis.model.EpProber;
import com.megaeyes.persistence.ibatis.vo.ListVicIdVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BindEpRProberVICManager;
import com.megaeyes.service.iface.EpProberManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpProberResponse;
import com.megaeyes.web.response.ListVicByProberIdResponse;

/** 
 * @ClassName: EpProberController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午9:58:24 
 *  
 */
@Controller
public class EpProberController extends BaseController {
	@Autowired
	EpProberManager epProberManager;
	@Autowired
	BindEpRProberVICManager bindEpRProberVICManager;
	
	/**
	* @Title: createEpProber 
	* @Description: 创建探测器
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "创建探测器 ",isLog=true,isCheckSession=true)
	@RequestMapping("/createEpProber.json")
	public void createEpProber(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String controlServerId = (String) request.getAttribute("controlServerId");
		String epProberTypeId = (String) request.getAttribute("epProberTypeId");
		String name = (String) request.getAttribute("name");
		Integer maxLimit = null;
		String maxLimit1 = (String) request.getAttribute("maxLimit");
		if(StringUtils.isNotBlank(maxLimit1)){
			try{
				maxLimit = Integer.parseInt(maxLimit1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxLimit");
			}
		}
		Integer minLimit = null;
		String minLimit1 = (String) request.getAttribute("minLimit");
		if(StringUtils.isNotBlank(minLimit1)){
			try{
				minLimit = Integer.parseInt(minLimit1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("minLimit");
			}
		}
		Integer cycle = null;
		String cycle1 = (String) request.getAttribute("cycle");
		if(StringUtils.isNotBlank(cycle1)){
			try{
				cycle = Integer.parseInt(cycle1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("cycle");
			}
		}
		String address = (String) request.getAttribute("address");
		Integer isWarn = 0;
		String isWarn1 = (String) request.getAttribute("isWarn");
		if(StringUtils.isNotBlank(isWarn1)){
			try{
				isWarn = Integer.parseInt(isWarn1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isWarn");
			}
		}
		Integer boolWarn = 0;
		String boolWarn1 = (String) request.getAttribute("boolWarn");
		if(StringUtils.isNotBlank(boolWarn1)){
			try{
				boolWarn = Integer.parseInt(boolWarn1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("boolWarn");
			}
		}
		String position = (String) request.getAttribute("position");
		Integer registerReverse = null;
		String registerReverse1 = (String) request.getAttribute("registerReverse");
		if(StringUtils.isNotBlank(registerReverse1)){
			try{
				registerReverse = Integer.parseInt(registerReverse1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("registerReverse");
			}
		}
		Integer plcIoSaveCycle = null;
		String plcIoSaveCycle1 = (String) request.getAttribute("plcIoSaveCycle");
		if(StringUtils.isNotBlank(plcIoSaveCycle1)){
			try{
				plcIoSaveCycle = Integer.parseInt(plcIoSaveCycle1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("plcIoSaveCycle");
			}
		}
		String plcIoSaveType = (String) request.getAttribute("plcIoSaveType");
		String organId = (String) request.getAttribute("organId");
		String dataType = (String) request.getAttribute("dataType");
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = epProberManager.createEpProber(controlServerId,epProberTypeId,name,maxLimit,minLimit,cycle,
						address,isWarn,boolWarn,position,registerReverse,plcIoSaveCycle,plcIoSaveType,organId,dataType);
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
	* @Title: deleteEpProber 
	* @Description: 删除探测器
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "删除探测器",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEpProber.json")
	public void deleteEpProber(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			epProberManager.deleteEpProber(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
		
	}
	
	/**
	* @Title: updateEpProber 
	* @Description: 根据ID修改探测器
	* @param request
	* @param response
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "根据ID修改探测器",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEpProber.json")
	public void updateEpProber(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String controlServerId = (String) request.getAttribute("controlServerId");
		String epProberTypeId = (String) request.getAttribute("epProberTypeId");
		String name = (String) request.getAttribute("name");
		Integer maxLimit = null;
		String maxLimit1 = (String) request.getAttribute("maxLimit");
		if(StringUtils.isNotBlank(maxLimit1)){
			try{
				maxLimit = Integer.parseInt(maxLimit1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("maxLimit");
			}
		}
		Integer minLimit = null;
		String minLimit1 = (String) request.getAttribute("minLimit");
		if(StringUtils.isNotBlank(minLimit1)){
			try{
				minLimit = Integer.parseInt(minLimit1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("minLimit");
			}
		}
		Integer cycle = null;
		String cycle1 = (String) request.getAttribute("cycle");
		if(StringUtils.isNotBlank(cycle1)){
			try{
				cycle = Integer.parseInt(cycle1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("cycle");
			}
		}
		String address = (String) request.getAttribute("address");
		Integer isWarn = 0;
		String isWarn1 = (String) request.getAttribute("isWarn");
		if(StringUtils.isNotBlank(isWarn1)){
			try{
				isWarn = Integer.parseInt(isWarn1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isWarn");
			}
		}
		Integer boolWarn = 0;
		String boolWarn1 = (String) request.getAttribute("boolWarn");
		if(StringUtils.isNotBlank(boolWarn1)){
			try{
				boolWarn = Integer.parseInt(boolWarn1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("boolWarn");
			}
		}
		String position = (String) request.getAttribute("position");
		Integer registerReverse = null;
		String registerReverse1 = (String) request.getAttribute("registerReverse");
		if(StringUtils.isNotBlank(registerReverse1)){
			try{
				registerReverse = Integer.parseInt(registerReverse1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("registerReverse");
			}
		}
		Integer plcIoSaveCycle = null;
		String plcIoSaveCycle1 = (String) request.getAttribute("plcIoSaveCycle");
		if(StringUtils.isNotBlank(plcIoSaveCycle1)){
			try{
				plcIoSaveCycle = Integer.parseInt(plcIoSaveCycle1);
			}catch(NumberFormatException b){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("plcIoSaveCycle");
			}
		}
		String plcIoSaveType = (String) request.getAttribute("plcIoSaveType");
		String organId = (String) request.getAttribute("organId");
		String dataType = (String) request.getAttribute("dataType");
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				epProberManager.updateEpProber(id,controlServerId,epProberTypeId,name,maxLimit,minLimit,cycle,
						address,isWarn,boolWarn,position,registerReverse,plcIoSaveCycle,plcIoSaveType,organId,dataType);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);		
	}
	
	/**
	* @Title: getEpProberById 
	* @Description: 根据ID查询探测器 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据ID查询探测器 ",isLog=false,isCheckSession=true)
	@RequestMapping("/getEpProberById.json")
	public void getEpProberById(HttpServletRequest request,
			HttpServletResponse response){
		EpProberResponse resp = new EpProberResponse();
		String id = (String) request.getAttribute("id");
		try{
			EpProber ep = epProberManager.getEpProberById(id);
			resp.setCode(ErrorCode.SUCCESS);
			if(ep!= null){
				resp.setId(ep.getId());
				resp.setControlServerId(ep.getControlServerId());
				resp.setEpProberTypeId(ep.getEpProberTypeId());
				resp.setName(ep.getName());
				resp.setMaxLimit(ep.getMaxLimit());
				resp.setMinLimit(ep.getMinLimit());
				resp.setCycle(ep.getCycle());
				resp.setAddress(ep.getAddress());
				resp.setIsWarn(ep.getIsWarn());
				resp.setBoolWarn(ep.getBoolWarn());
				resp.setDataType(ep.getDataType());
				resp.setPosition(ep.getPosition());
				resp.setRegisterReverse(ep.getRegisterReverse());
				resp.setPlcIoSaveCycle(ep.getPlcIoSaveCycle());
				resp.setPlcIoSaveType(ep.getPlcIoSaveType());
				resp.setPlcIoType(ep.getPlcIoType());
				resp.setOrganId(ep.getOrganId());
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: addOrUpdateEpRProberVIC 
	* @Description: 绑定探测器摄像头 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "绑定探测器摄像头",isLog=false,isCheckSession=true)
	@RequestMapping("/addOrUpdateEpRProberVIC.json")
	public void addOrUpdateEpRProberVIC(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			JSONObject jsonObject = new JSONObject(jsonString);
			String proberId = jsonObject.getString("proberId");
			bindEpRProberVICManager.deleteByProberId(proberId);
			JSONArray jsonArray = jsonObject.getJSONArray("vicIds");
			if(jsonArray.length()>0){
				for(int i=0;i<jsonArray.length();i++){
					JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
					String vicId = jsonObj.getString("vicId");
					bindEpRProberVICManager.bindEpRProberVIC(proberId,vicId);
				}
			}else{
				bindEpRProberVICManager.deleteByProberId(proberId);
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listVicIdByProberId 
	* @Description: 根据探测器ID查询摄像头ID 
	* @param request
	* @param response    设定文件 
	* @return void    
	* @throws
	 */
	@ControllerDescription(description = "根据探测器ID查询摄像头ID",isLog=false,isCheckSession=true)
	@RequestMapping("/listVicIdByProberId.json")
	public void listVicIdByProberId(HttpServletRequest request,
			HttpServletResponse response){
		ListVicByProberIdResponse resp = new ListVicByProberIdResponse();
		String proberId = (String) request.getAttribute("proberId");
		try{
			List<ListVicIdVO> vic = epProberManager.listVicIdByProberId(proberId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVic(vic);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
