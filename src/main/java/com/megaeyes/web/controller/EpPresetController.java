/**   
 * @Title: EpPresetController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-4 下午3:51:40 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpPresetManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.EpPresetResponse;

/**
 * @ClassName: EpPresetController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-4 下午3:51:40
 * 
 */
@Controller
public class EpPresetController extends BaseController {

	@Autowired
	EpPresetManager epPresetManager;

	@ControllerDescription(description = "根据视频ID查询预置点", isLog = false, isCheckSession = true)
	@RequestMapping("/listEpPresetByVicId.json")
	public void listEpPresetByVicId(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		EpPresetResponse resp = new EpPresetResponse();
		String vicId = (String) request.getAttribute("vicId");
		try {
			List<EpPreset> list = epPresetManager.listEpPresetByVicId(vicId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "增加、删除、修改预置点", isLog = false, isCheckSession = true)
	@RequestMapping("/addOrUpdateEpPreset.json")
	public void addOrUpdateEpPreset(HttpServletRequest request,
			HttpServletResponse response) throws JSONException,
			UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.SUCCESS);
		String jsonString = (String) request.getAttribute("jsonString");
		System.out.println(jsonString);
		try {
			epPresetManager.addOrUpdateEpPreset(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "增加预置点", isLog = true, isCheckSession = true)
	@RequestMapping("/addEpPreset.json")
	public void addEpPreset(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();

		String presetName = (String) request.getAttribute("presetName");
		if (StringUtils.isBlank(presetName)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("presetName");
		}

		String presetNumberString = request.getParameter("presetNumber");
		short presetNumber = 0;
		if (StringUtils.isBlank(presetNumberString)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("presetNumber");
		} else {
			try {
				presetNumber = Short.parseShort(presetNumberString);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage(presetNumberString);
			}
		}

		String vicId = request.getParameter("vicId");
		if (StringUtils.isBlank(vicId)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("vicId");
		}

		BigDecimal setFlag = new BigDecimal(0);
		String setFlagString = request.getParameter("setFlag");
		if (StringUtils.isNotBlank(setFlagString)) {
			try {
				setFlag = new BigDecimal(setFlagString);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("setFlag");
			}
		}

		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				String id = epPresetManager.addEpPreset(presetName,
						presetNumber, vicId, setFlag);
				resp.setMessage(id);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage(e.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除预置点", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteEpPreset.json")
	public void deleteEpPreset(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BaseResponse resp = new BaseResponse();

		String id = request.getParameter("id");
		if (StringUtils.isBlank(id)) {
			resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
			resp.setMessage("id");
		}

		if (ErrorCode.SUCCESS.equals(resp.getCode())) {
			try {
				epPresetManager.deleteEpPreset(id);
			} catch (BusinessException e) {
				e.printStackTrace();
				resp.setCode(e.getCode());
				resp.setMessage(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode(ErrorCode.ERROR);
				resp.setMessage(e.getMessage());
			}
		}

		writePageNoZip(response, resp);
	}
}
