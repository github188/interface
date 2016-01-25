package com.megaeyes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.web.aop.annotation.ControllerDescription;

/**
 * 
 * @Title: CrossdomainController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: Flash安全沙箱接口
 * @author zhuanqi@megaeyes.com   
 * @date 2012-11-29 上午08:13:18 
 * @version V1.0
 */
@Controller
public class CrossdomainController  extends BaseController {

	@ControllerDescription(description = "安全沙箱接口", isLog = false, isCheckSession = false)
	@RequestMapping("/crossdomain.xml")
	public void main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 返回策略文件
		Document rtn = generateXML();
		writePageWithContentLength(response, rtn);
	}

	/**
	 * 
	 * @Description:生成策略xml 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	private Document generateXML() {
		/**
		 * 	<cross-domain-policy>
		 *	<allow-access-from domain="*"/>
		 *	</cross-domain-policy>
		 */
		Document doc = new Document();
		Element root = new Element("cross-domain-policy");
		doc.setRootElement(root);

		Element success = new Element("allow-access-from");
		success.setAttribute("domain","*");
		root.addContent(success);
		return doc;
	}
}
