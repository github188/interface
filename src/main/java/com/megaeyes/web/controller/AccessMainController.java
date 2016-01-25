package com.megaeyes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.access.ActionProvider;
import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.web.aop.annotation.ControllerDescription;

/**
 * 接入中心接口入口类
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午01:43:42
 */
@Controller
public class AccessMainController extends BaseController {

	@Autowired
	private ActionProvider actionProvider;

	@ControllerDescription(description = "接入中心主接口", isLog = false, isCheckSession = false)
	@RequestMapping("/megaeyes_access_support/main")
	public void main(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("gbk");
		// 获取指令号
		String messageId = request.getParameter("messageId");
		// 接入IP
		String accessId = request.getParameter("accessId");
		// xml参数内容
		String xml = request.getParameter("xml");

		RequestObject req = new RequestObject();
		req.setMessageId(messageId);
		req.setAccessId(accessId);
		req.setXml(xml);

		// Action执行返回结果
		Document rtn = null;
		try {
			// 得到具体执行Action
			Action action = actionProvider.get(messageId);

			rtn = action.proccess(req);
		} catch (BusinessException e) {
			e.printStackTrace();
			rtn = generateFailXML(e.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			rtn = generateFailXML(ErrorCode.ERROR);
		}

		writePageWithContentLength(response, rtn);
	}

	/**
	 * 生成失败的xml
	 * 
	 * @param code
	 *            失败的业务异常编码
	 * @return
	 */
	private Document generateFailXML(String code) {
		Document doc = new Document();
		Element root = new Element("Message");
		doc.setRootElement(root);

		Element success = new Element("Success");
		success.setText(code);
		root.addContent(success);

		return doc;
	}
}
