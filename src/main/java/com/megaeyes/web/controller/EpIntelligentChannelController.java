/**   
* @Title: EpIntelligentChannelController.java 
* @Package com.megaeyes.web.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-29 上午7:33:16 
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

import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.CenterDeviceManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpIntelligentChannelResponse;
import com.megaeyes.web.response.ListEpIntelligentChannelResponse;

/** 
 * @ClassName: EpIntelligentChannelController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-29 上午7:33:16 
 *  
 */
@Controller
public class EpIntelligentChannelController extends BaseController {
	@Autowired
	CenterDeviceManager centerDeviceManager;
	
	/**
	* @Title: createIntelligentChannel 
	* @Description: 创建智能分析单元
	* @param request
	* @param response
	* @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description="创建智能分析单元",isLog=true,isCheckSession=true)
	@RequestMapping("/createEIC.json")
	public void createEpIntelligentChannel(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String installLocation = (String) request.getAttribute("installLocation");
		String parentId = (String) request.getAttribute("parentId");
		Short parentType = new Short("1");
		String sParentType = (String) request.getAttribute("parentType");
		if (StringUtils.isNotBlank(sParentType)) {
			try {
				parentType = Short.parseShort(sParentType);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("parentType");
			}

		} 
		String description = (String) request.getAttribute("description");
		String note = (String) request.getAttribute("note");
		String company = (String) request.getAttribute("company");
		Short channelId = new Short("1");
		String sChannelId = (String) request.getAttribute("channelId");
		if (StringUtils.isNotBlank(sChannelId)) {
			try {
				channelId = Short.parseShort(sChannelId);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("channelId");
			}
		}
		String organId = (String) request.getAttribute("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try{
				String id = centerDeviceManager.createEIC(name, null,
						installLocation, parentId, parentType, description,
						note, company, channelId, organId);
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
	* @Title: deleteEpIntelligentChannel 
	* @Description: 删除智能分析单元
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="删除智能分析单元",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteEIC.json")
	public void deleteEpIntelligentChannel(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			centerDeviceManager.deleteEIC(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listEpIntelligentChannel 
	* @Description: 查询智能单元列表
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据视频服务器ID查询智能分析单元列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEICByParentId.json")
	public void listEpIntelligentChannel(HttpServletRequest request,
			HttpServletResponse response){
		ListEpIntelligentChannelResponse resp = new ListEpIntelligentChannelResponse();
		String parentId = (String) request.getAttribute("parentId");
		try{
			List<EpIntelligentChannel> eic = centerDeviceManager.listEICByParentId(parentId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpIntelligentChannel(eic);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: listEICByOrganId 
	* @Description: 根据机构ID查询智能分析单元列表
	* @param request  
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据机构ID查询智能分析单元列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEICByOrganId.json")
	public void listEICByOrganId(HttpServletRequest request,
			HttpServletResponse response){
		ListEpIntelligentChannelResponse resp = new ListEpIntelligentChannelResponse();
		String organId = (String) request.getAttribute("organId");
		try{
			List<EpIntelligentChannel> eic = centerDeviceManager.listEICByOrganId(organId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setEpIntelligentChannel(eic);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: getEIC 
	* @Description: 根据ID查询智能分析单元 
	* @param request
	* @param response    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@ControllerDescription(description="根据ID查询智能分析单元 ",isLog=false,isCheckSession=true)
	@RequestMapping("/getEIC.json")
	public void getEIC(HttpServletRequest request,
			HttpServletResponse response){
		EpIntelligentChannelResponse resp = new EpIntelligentChannelResponse();
		String id = (String) request.getAttribute("id");
		try{
			EpIntelligentChannel eic = centerDeviceManager.getEIC(id);
			if(eic!=null){
				resp.setCode(ErrorCode.SUCCESS);
				resp.setId(eic.getId());
				resp.setName(eic.getName());
				resp.setNaming(eic.getNaming());
				resp.setNote(eic.getNote());
				resp.setChannelId(eic.getChannelId());
				resp.setCompany(eic.getCompany());
				resp.setDescription(eic.getDescription());
				resp.setInstallLocation(eic.getInstallLocation());
				resp.setOptimisticLock(eic.getOptimisticLock());
				resp.setOrganId(eic.getOrganId());
				resp.setParentId(eic.getParentId());
				resp.setParentType(eic.getParentType());
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	* @Title: updateEIC 
	* @Description: 更新智能分析单元
	* @param request
	* @param response
	* @throws UnsupportedEncodingException    设定文件 
	* @return void    返回类型 
	 */
	@ControllerDescription(description="更新智能分析单元",isLog=false,isCheckSession=true)
	@RequestMapping("/updateEIC.json")
	public void updateEIC(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String naming = (String) request.getAttribute("naming");
		String installLocation = (String) request.getAttribute("installLocation");
		String parentId = (String) request.getAttribute("parentId");
		Short parentType = null;
		String sParentType = (String) request.getAttribute("parentType");
		if (!StringUtils.isBlank(sParentType)) {
			try {
				parentType = Short.parseShort(sParentType);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("parentType");
			}
		}
		String description = (String) request.getAttribute("description");
		String note = (String) request.getAttribute("note");
		String company = (String) request.getAttribute("company");
		Short channelId = null;
		String sChannelId = (String) request.getAttribute("channelId");
		if (!StringUtils.isBlank(sChannelId)) {
			try {
				channelId = Short.parseShort(sChannelId);
			} catch (NumberFormatException e) {
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("channelId");
			}
		}
		String organId = (String) request.getAttribute("organId");
		if (resp.getCode().equals(ErrorCode.SUCCESS)) {
			try{
				centerDeviceManager.updateEIC(id,name, naming,
						installLocation, parentId, parentType, description,
						note, company, channelId, organId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
}
