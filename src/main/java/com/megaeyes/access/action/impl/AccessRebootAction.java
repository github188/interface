package com.megaeyes.access.action.impl;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.vo.AccessRebootVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.DispatchServerManager;
import com.megaeyes.service.iface.StorageServerManager;

/**
 * 
 * @Title: AccessRebootAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: 接入服务器注册（重启通知）-1026
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-21 下午05:04:17
 * @version V1.0
 */
public class AccessRebootAction extends BaseAction implements Action {
	
	@Autowired
	private DispatchServerManager dispatchServerManager;
	
	@Autowired
	private StorageServerManager storageServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		AccessRebootVO accessVo = XMLToObject(doc);
		List<DispatchServer> dispatchServerList = dispatchServerManager.selectByExample(null);
		accessVo.setDispatchServerList(dispatchServerList);
		List<StorageServer> remoteServerList = storageServerManager.findAllRemoteStorageServer();
		accessVo.setStorageServerList(remoteServerList);
		 // 返回
		Document rtn = ObjectToXML(accessVo);
		return rtn;
	}
	
	public AccessRebootVO XMLToObject(Document doc) {
		AccessRebootVO accessVo = new AccessRebootVO();
		Element rootElement = doc.getRootElement();
		Element DeviceIPElement = rootElement.getChild("DeviceIP");
		String accessIp = DeviceIPElement.getText();
		accessVo.setIp(accessIp);
		return accessVo;
	}

	public Document ObjectToXML(AccessRebootVO accessVo) {
		
		List<?> dispatchList = accessVo.getDispatchServerList();
		Element rootElement = new Element("Message");
		
		// 事件管理服务器信息返回空置信息
        Element eventServerElement = new Element("EventServer");
        eventServerElement.setAttribute("IP","");
        eventServerElement.setAttribute("Port","");
        // 增加分发服务器信息
		Element dispatchElement = new Element("DispatchList");
		for (int i = 0; i < dispatchList.size(); i++) {
			DispatchServer dispatchServer = (DispatchServer)dispatchList.get(i);
			Element dsElement = new Element("Dispatch");
			dsElement.setAttribute("ID",dispatchServer.getId());
			dsElement.setAttribute("DeviceIP1", dispatchServer.getIp() == null ? ""	: dispatchServer.getIp());

			if (dispatchServer.getIp2() != null && !"".equals(dispatchServer.getIp2())) {
				dsElement.setAttribute("DeviceIP2", dispatchServer.getIp2());
			}

			dsElement.setAttribute("MsgPort", String.valueOf(dispatchServer.getMsgport()));
			dsElement.setAttribute("VideoPort",String.valueOf(dispatchServer.getVideoport()));
			if (dispatchServer.getWeight() != null) {
				dsElement.setAttribute("Weight", dispatchServer.getWeight());
			}

			dsElement.setAttribute("MaxInputNum", String.valueOf(dispatchServer.getMaxInputAmount()));
			dsElement.setAttribute("MaxOutputNum", String.valueOf(dispatchServer.getMaxOutputAmount()));
			dsElement.setAttribute("ResvdOutNum", String.valueOf(dispatchServer.getReservedOutputAmount()));
			if (dispatchServer.getOwnerShip() != null) {
				dsElement.setAttribute("Ownership", dispatchServer.getOwnerShip());
			}
			dispatchElement.addContent(dsElement);
		}

		// 增加中心存储信息
		Element storeListElement = new Element("StoreList");
		List<?> storeList = accessVo.getStorageServerList();
		for (int i = 0; i < storeList.size(); i++) {
			StorageServer remoteServer = (StorageServer) storeList.get(i);
			Element storeElement = new Element("Store");

			storeElement.setAttribute("ID", remoteServer.getId());
			if (remoteServer.getIp() != null) {
				storeElement.setAttribute("DeviceIP1", remoteServer.getIp());
			} else {
				storeElement.setAttribute("DeviceIP1", "");
			}
			if (remoteServer.getIp2() != null) {
				storeElement.setAttribute("DeviceIP2", remoteServer.getIp2());
			} else {
				storeElement.setAttribute("DeviceIP2", "");
			}
			storeElement.setAttribute("MsgPort", String.valueOf(remoteServer.getMessagePort()));
			storeListElement.addContent(storeElement);
		}
		rootElement.addContent(eventServerElement);
		rootElement.addContent(dispatchElement);
		rootElement.addContent(storeListElement);

		// 增加平台编号信息
		Element platformIdElement = new Element("PlatformId");
	    platformIdElement.setText(ResourceType.CMS_ID);
	    rootElement.addContent(platformIdElement);
	        
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);

		Document doc = new Document(rootElement);
		return doc;
	}

	
}
