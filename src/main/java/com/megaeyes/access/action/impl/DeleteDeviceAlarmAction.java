package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * @Title: DeleteDeviceAlarmAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: DeleteDeviceAlarmAction-5210
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午06:07:43
 * @version V1.0
 */
public class DeleteDeviceAlarmAction extends BaseAction implements Action {
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
//		String id = this.XMLToObject(doc);
		//返回
		Document rtn = this.ObjectToXML();
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析 
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String XMLToObject(Document doc) {
		// XML文档解析
		Element rootElement = doc.getRootElement();
		Element IDElement = rootElement.getChild("SchemeAssociateId");
		String id = IDElement.getText();
		return id;
	}

	/**
	 * 
	 * @Description: 返回 
	 * @author zhuanqi@megaeyes.com
	 * @param @param inObject
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML() {
		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}
}
