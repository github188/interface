package com.megaeyes.access.action.impl;


import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.vo.StorageInfoQueryVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.CenterDeviceManager;

public class StorageInfoQueryAction  extends BaseAction implements Action {
	@Autowired
	private CenterDeviceManager centerDeviceManager;
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		String id = XMLToObject(doc);
		
		StorageInfoQueryVO data = centerDeviceManager.getStorageInfoOfCamera(id);
		
		Element rtnRoot = new Element("Message");
		Element success = new Element("Success");
		success.setText("0");
		rtnRoot.addContent(success);
		
		Element encodeElement = new Element("EncodeType");
		encodeElement.addContent(data.getEncodeType());
		rtnRoot.addContent(encodeElement);
		
		if(data.getStoreType() == 0 || data.getStoreType() == 2){
			Element localElement = new Element("LocalStorage");
			localElement.setAttribute("ip", data.getLocalIp()==null?"":data.getLocalIp());
			localElement.setAttribute("id", data.getLocalId());
			rtnRoot.addContent(localElement);
		}
		if(data.getStoreType() == 1 || data.getStoreType() == 2){
			Element remoteElement = new Element("RemoteStorage");
			remoteElement.setAttribute("ip", data.getRemoteIp());
			remoteElement.setAttribute("id", data.getRemoteId());
			remoteElement.setAttribute("hasVod", String.valueOf(data.getHasVOD()== 1?"TRUE":"FALSE"));
			rtnRoot.addContent(remoteElement);
		}
		
		Document rtn = new Document(rtnRoot);
		return rtn;
	}

	public String XMLToObject(Document doc){
		String cameraId = "";
		Element rootElement = doc.getRootElement();
		Element cameraElement = rootElement.getChild("CameraID");
		cameraId = cameraElement.getText();
		return cameraId;
	}
}
