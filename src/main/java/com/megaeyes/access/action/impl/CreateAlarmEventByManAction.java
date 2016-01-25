package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * @Title: CreateAlarmEventByManAction.java 
 * @Package com.megaeyes.access.action.impl 
 * @Description:CreateAlarmEventByManAction-5220
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-24 上午06:47:46 
 * @version V1.0
 */
public class CreateAlarmEventByManAction extends BaseAction implements Action{

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}

}
