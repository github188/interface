package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.CenterDeviceManager;

public class SDLostReportAction extends BaseAction implements Action {
	@Autowired
	private CenterDeviceManager centerDeviceManager;
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		
		Document doc = phaseXML(req);
		String ipCameraId = doc.getRootElement().getAttributeValue("ID");
		centerDeviceManager.updateIpCameraVIC(ipCameraId, req.getAccessId());
		
		Document rtn = new Document();
		Element rtnRoot = new Element("Info");
		rtn.setRootElement(rtnRoot);

		Element operation = new Element("operation");
		operation.setText("cardLostReport");
		rtnRoot.addContent(operation);
		
		Element type = new Element("type");
		operation.setText("0");
		rtnRoot.addContent(type);
		
		Element description = new Element("description");
		operation.setText("success");
		rtnRoot.addContent(description);
		
		return rtn;
	}

}
