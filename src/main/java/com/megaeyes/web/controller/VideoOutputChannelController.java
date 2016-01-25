/**   
* @Title: VideoOutputChannelController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-26 上午2:16:37 
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

import com.megaeyes.persistence.ibatis.model.Manufacturer;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.service.iface.VOCManager;
import com.megaeyes.service.utils.StdIdGenerator;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListVOCModelResponse;
import com.megaeyes.web.response.ListVideoOutputChannelResponse;
import com.megaeyes.web.response.VideoOutputChannelResponse;

/** 
 * @ClassName: VideoOutputChannelController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-26 上午2:16:37 
 *  
 */
@Controller
public class VideoOutputChannelController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;
	@Autowired
	VOCManager vocManager;
	
	/**
	* @Title: createVOC 
	* @Description: 创建视频输出通道 
	* @param request
	* @param response
	* @param @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description="创建视频输出通道",isLog=true,isCheckSession=true)
	@RequestMapping("/createVOC.json")
	public void createVOC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String naming =(String) request.getAttribute("naming");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String displayId = (String) request.getAttribute("displayId");
		String modelId = (String) request.getAttribute("modelId");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String organId = (String) request.getAttribute("organId");
		String addressNumber = (String) request.getAttribute("addressNumber");
		Integer isShare = 0;
		String isShare1 = (String) request.getAttribute("isShare");
		if(StringUtils.isNotBlank(isShare1)){
			try{
				isShare = Integer.parseInt(isShare1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isShare");
			}
		}
		String stdId = StdIdGenerator.getStdId();
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try{
				String id = vocManager.createVOC(name, naming, installLocation,
						note, displayId, modelId, dispatchServer, organId, 
						addressNumber, isShare, stdId);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			}catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: deleteVOC 
	* @Description: 删除视频输出通道 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除视频输出通道",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteVOC.json")
	public void deleteVOC(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			vocManager.deleteVOC(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listVoc 
	* @Description: 根据显示服务器ID查询视频输出通道列表 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据显示服务器ID查询视频输出通道列表 ",isLog=false,isCheckSession=true)
	@RequestMapping("/listVocByDisplayId.json")
	public void listVocByDisplayId(HttpServletRequest request,
			HttpServletResponse response){
		ListVideoOutputChannelResponse resp = new ListVideoOutputChannelResponse();
		String displayId = (String) request.getAttribute("displayId");
		try{
			List<VideoOutputChannel> voc = vocManager.listVocByDisplayId(displayId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVideoOutputChannel(voc);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: listVocByOrganId 
	* @Description:  根据机构ID查询视频输出通道列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据机构ID查询视频输出通道列表 ",isLog=false,isCheckSession=true)//没有用到这个
	@RequestMapping("/listVocByOrganId.json")
	public void listVocByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListVideoOutputChannelResponse resp = new ListVideoOutputChannelResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<VideoOutputChannel> voc = vocManager.listVocByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVideoOutputChannel(voc);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: getVOC 
	* @Description: 根据ID查询视频输出通道
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据ID查询视频输出通道 ",isLog=false,isCheckSession=true)
	@RequestMapping("/getVOC.json")
	public void getVOC(HttpServletRequest request,
			HttpServletResponse response){
		VideoOutputChannelResponse resp = new VideoOutputChannelResponse();
		String id = (String) request.getAttribute("id");
		try{
			VideoOutputChannel voc = vocManager.getVOC(id);
			resp.setCode(ErrorCode.SUCCESS);
			if(voc!=null){
				resp.setId(voc.getId());
				resp.setDispatchServerId(voc.getDispatchServerId());
				resp.setVideoDisplayDeviceId(voc.getVideoDisplayDeviceId());
				resp.setInstallLocation(voc.getInstallLocation());
				resp.setVideoOutputChannelModelId(voc.getVideoOutputChannelModelId());
				resp.setName(voc.getName());
				resp.setNaming(voc.getNaming());
				resp.setNote(voc.getNote());
				resp.setOrganId(voc.getOrganId());
				resp.setIsShare(voc.getIsShare());
				resp.setStdId(voc.getStdId());	
				resp.setAddressNumber(voc.getAddressNumber());
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);	
	}
	
	/**
	* @Title: updateVOC 
	* @Description: 更新视频输出通道
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="更新视频输出通道 ",isLog=false,isCheckSession=true)
	@RequestMapping("/updateVOC.json")
	public void updateVOC(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming =(String) request.getAttribute("naming");
		String installLocation = (String) request.getAttribute("installLocation");
		String note = (String) request.getAttribute("note");
		String displayId = (String) request.getAttribute("displayId");
		String modelId = (String) request.getAttribute("modelId");
		String dispatchServer = (String) request.getAttribute("dispatchServer");
		String organId = (String) request.getAttribute("organId");
		String addressNumber = (String) request.getAttribute("addressNumber");
		Integer isShare = 0;
		String isShare1 = (String) request.getAttribute("isShare");
		if(StringUtils.isNotBlank(isShare1)){
			try{
				isShare = Integer.parseInt(isShare1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("isShare");
			}
		}
		
		String stdId = StdIdGenerator.getStdId();
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				vocManager.updateVOC(id,name,naming,
						installLocation,note,displayId,modelId,dispatchServer,
						organId,addressNumber,Integer.valueOf(isShare),stdId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);	
	}
	
	@ControllerDescription(description="查询视频输出类型",isLog=false,isCheckSession=true)
	@RequestMapping("/listVOCModel.json")
	public void listManufacturer(HttpServletRequest request,
			HttpServletResponse response){
		ListVOCModelResponse resp = new ListVOCModelResponse();
		try{
			List<VideoOutputChannelModel> vocModel = vocManager.listVOCModel();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setVocModel(vocModel);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
