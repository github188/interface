package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * @Title: UserVideoBillAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: UserVideoBillAction-5072
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-20 上午08:30:11
 * @version V1.0
 */
public class UserVideoBillAction extends BaseAction implements Action {

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		Object obj = this.XMLToObject(doc);
		Document rtn = this.ObjectToXML(obj);
		return rtn;
	}

	public Object XMLToObject(Document doc) {
		return null;

	}

	public Document ObjectToXML(Object inObject) {
		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}
}
