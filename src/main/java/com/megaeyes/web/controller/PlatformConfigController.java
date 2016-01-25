package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.StringUtil;

import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;

/**
 * 
 * @Title: PlatformConfigController.java
 * @Package com.megaeyes.web.controller
 * @Description: 获取平台配置信息
 * @author zhuanqi@megaeyes.com
 * @date 2013-3-4 上午11:13:12
 * @version V2.5
 */
@Controller
public class PlatformConfigController extends BaseController {
	@Autowired
	UserManager userManager;
	
	@ControllerDescription(description = "查询平台配置信息", isLog = true, isCheckSession = true)
	@RequestMapping("/getGisServerConfig.json")
	public void getGisServerConfig(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String url = userManager.getGisServerUrl();
		if(StringUtil.isNotBlank(url)){
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(url);
		}else{
			resp.setCode(ErrorCode.RESOURCE_NOT_FOUND);
			resp.setMessage("未找到地址");
		}
		writePageNoZip(response, resp);
	}
}
