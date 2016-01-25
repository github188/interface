/**   
* @Title: EpAssetsController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-5 上午8:06:00 
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

import com.megaeyes.persistence.ibatis.vo.EpAssetsAndDeviceVO;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AsssetsManager;
import com.megaeyes.service.iface.BindEpRMonitorDeviceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListEpAssetsResponse;
import com.megaeyes.web.response.ListVicByAssetsIdResponse;

/** 
 * @ClassName: EpAssetsController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-5 上午8:06:00 
 *  
 */
@Controller
public class EpAssetsController extends BaseController {
	@Autowired
	AsssetsManager asssetsManager;
	@Autowired
	BindEpRMonitorDeviceManager bindEpRMonitorDeviceManager;
	
	/**
	* @Title: createEpAssets 
	* @Description: 创建资产管理
	* @param request
	* @param response
	* @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型
	 */
	@ControllerDescription(description = "创建资产",isLog=true,isCheckSession=true)
	@RequestMapping("/createEA.json")
	public void createEpAssets(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		BigDecimal type = null;
		String type1 = (String) request.getAttribute("type");
		if(StringUtils.isNotBlank(type1)){
			try {
				type = new BigDecimal(type1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("type");
			}
		}else{
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("type");
		}
		
		BigDecimal useTime = null;
		String useTime1 = (String) request.getAttribute("useTime");
		if(StringUtils.isNotBlank(useTime1)){
			try {
				useTime = new BigDecimal(useTime1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("useTime");
			}
		}
		BigDecimal expirationTime = null;
		String expirationTime1 = (String) request.getAttribute("expirationTime");
		if(StringUtils.isNotBlank(expirationTime1)){
			try {
				expirationTime = new BigDecimal(expirationTime1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("expirationTime");
			}
		}
		BigDecimal significantLevel = null;
		String significantLevel1 = (String) request.getAttribute("significantLevel");
		if(StringUtils.isNotBlank(significantLevel1)){
			try {
				significantLevel = new BigDecimal(significantLevel1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("significantLevel");
			}
		}
		
		String note = (String) request.getAttribute("note");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String organId = (String) request.getAttribute("organId");
		String installLocation = (String) request.getAttribute("installLocation");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				String id = asssetsManager.createEpAssets(name, type,
						 useTime, expirationTime, significantLevel, note, deviceNumber, organId,installLocation);
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
	* @Title: deleteEpAssets 
	* @Description: 删除资产管理
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description = "删除资产",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEA.json")
	public void deleteEpAssets(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			asssetsManager.deleteEpAssets(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listEpAssets 
	* @Description: 查询资产管理列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description = "查询资产列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEA.json")
	public void listEpAssets(HttpServletRequest request,
			HttpServletResponse response){
		ListEpAssetsResponse resp = new ListEpAssetsResponse();
		try{
			List<EpAssetsAndDeviceVO> ea = asssetsManager.listEpAssets();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpAssets(ea);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: getEAByOrganId 
	* @Description: 根据机构ID查询资产管理列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据机构ID查询资产列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEAByOrganId.json")
	public void listEAByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListEpAssetsResponse resp = new ListEpAssetsResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<EpAssetsAndDeviceVO> ea = asssetsManager.listEAByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpAssets(ea);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: updateEpAssets 
	* @Description: 更新资产管理
	* @param request
	* @return void    返回类型 
	* @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description = "更新资产",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEpAssets.json")
	public void updateEpAssets(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		BigDecimal type = null;
		String type1 = (String) request.getAttribute("type");
		if(StringUtils.isNotBlank(type1)){
			try {
				type = new BigDecimal(type1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("type");
			}
		}else{
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("type");
		}
		
		BigDecimal useTime = null;
		String useTime1 = (String) request.getAttribute("useTime");
		if(StringUtils.isNotBlank(useTime1)){
			try {
				useTime = new BigDecimal(useTime1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("useTime");
			}
		}
		BigDecimal expirationTime = null;
		String expirationTime1 = (String) request.getAttribute("expirationTime");
		if(StringUtils.isNotBlank(expirationTime1)){
			try {
				expirationTime = new BigDecimal(expirationTime1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("expirationTime");
			}
		}
		BigDecimal significantLevel = null;
		String significantLevel1 = (String) request.getAttribute("significantLevel");
		if(StringUtils.isNotBlank(significantLevel1)){
			try {
				significantLevel = new BigDecimal(significantLevel1);
			}catch(NumberFormatException e){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("significantLevel");
			}
		}
		
		String note = (String) request.getAttribute("note");
		String deviceNumber = (String) request.getAttribute("deviceNumber");
		String organId = (String) request.getAttribute("organId");
		String installLocation = (String) request.getAttribute("installLocation");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try {
				asssetsManager.updateEpAssets(id,name, type,
						 useTime, expirationTime, significantLevel,
						 note, deviceNumber, organId,installLocation);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
//	/**
//	* @Title: addOrUpdateEpRAssetsVic 
//	* @Description: 更新资产管理摄像头
//	* @param request
//	* @param response
//	* @throws JSONException    设定文件 
//	* @return void    返回类型 
//	 */
//	@ControllerDescription(description = "更新资产管理摄像头")
//	@RequestMapping("/addOrUpdateEpRAssetsVic.json")
//	public void addOrUpdateEpRAssetsVic(HttpServletRequest request,
//			HttpServletResponse response)throws JSONException{
//		BaseResponse resp = new BaseResponse();
//		String jsonString = (String) request.getAttribute("jsonString");
//		try{
//			asssetsManager.addOrUpdateEpRAssetsVic(jsonString);
//			resp.setCode(ErrorCode.SUCCESS);
//		}catch(BusinessException be){
//			resp.setCode(be.getCode());
//			resp.setMessage(be.getMessage());
//		}
//		writePageNoZip(response, resp);
//	}
	
	/**
	* @Title: addOrUpdateEpRMonitorDevice 
	* @Description: 绑定资产监控设备 
	* @param @param request
	* @param @param response
	* @param @throws JSONException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "绑定资产监控设备",isLog=false,isCheckSession=true)
	@RequestMapping("/addOrUpdateEpRMonitorDevice.json")
	public void addOrUpdateEpRMonitorDevice(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			BigDecimal deviceType = new BigDecimal(1);
			BigDecimal monitorType = new BigDecimal(1);
			JSONObject jsonObject = new JSONObject(jsonString);
			String deviceId = jsonObject.getString("deviceId");
			bindEpRMonitorDeviceManager.deleteByDevice(deviceId);
			JSONArray jsonArray = jsonObject.getJSONArray("monitorIds");
			if(jsonArray.length()>0&&jsonArray!=null){
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
	* @Title: listVicByAssetsId 
	* @Description: 根据资产管理ID查询摄像头
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description = "根据资产ID查询摄像头",isLog=false,isCheckSession=true)
	@RequestMapping("/listVicByAssetsId.json")
	public void listVicByAssetsId(HttpServletRequest request,
			HttpServletResponse response){
		ListVicByAssetsIdResponse resp = new ListVicByAssetsIdResponse();
		String assetsId = (String) request.getAttribute("assetsId");
		try{
			List<ListVicVO> vic = asssetsManager.listVicByAssetsId(assetsId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVic(vic);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
