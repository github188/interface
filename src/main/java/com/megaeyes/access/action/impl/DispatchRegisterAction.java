package com.megaeyes.access.action.impl;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.DeviceLinkType;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.DispatchServerManager;

/**
 * 
 * @Title: DispatchRegisterAction.java 
 * @Package com.megaeyes.access.action.impl 
 * @Description: 分发服务器注册-3002
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-21 下午04:59:56 
 * @version V1.0
 */
public class DispatchRegisterAction extends BaseAction implements Action{
	
	@Autowired
	private DispatchServerManager dispatchServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		//获得分发服务器注册信息
		DispatchServer dispatchRegister = XMLToObject(doc);
		//查询分发服务器数据记录
		DispatchServer dispatchRecord = dispatchServerManager.getDispatchServerByDeviceNumber(dispatchRegister.getDeviceNumber());
		//更新分发服务器信息
		dispatchRegister.setId(dispatchRecord.getId());
		dispatchServerManager.dispatchRegister(dispatchRegister);
		
		// 返回
		Document rtn = ObjectToXML(dispatchRecord);
		return rtn;
	}
	
	/**
	 * 
	 * @Title: XMLToObject 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @return DispatchServer    返回类型 
	 * @throws
	 */
	private DispatchServer XMLToObject(Document doc){
		DispatchServer dispatchRegister = new DispatchServer();
		Element rootElement = doc.getRootElement();   
	    Attribute attrDeviceID = rootElement.getAttribute("DeviceID");
	    Attribute attrDeviceIP = rootElement.getAttribute("DeviceIP");
	    Attribute attrDeviceIP2 = rootElement.getAttribute("DeviceIP2");
	    Attribute attrDeviceLinkType = rootElement.getAttribute("DeviceLinkType");
	       
	    String deviceNumber = attrDeviceID.getValue();
	    String deviceIP = attrDeviceIP.getValue();
	    String deviceIp2 = null;
	    if(attrDeviceIP2 != null){
	       deviceIp2 = attrDeviceIP2.getValue();
	    }
	    //连接类型    
	    int deviceLinkType = Integer.parseInt(attrDeviceLinkType.getValue());
        if(deviceLinkType == 1){
        	dispatchRegister.setLinkType(DeviceLinkType.LAN);  
        }
        else if(deviceLinkType == 2){  
        	dispatchRegister.setLinkType(DeviceLinkType.ADSL); 
        }
        
    	Element msgPortElement = rootElement.getChild("MsgPort");
		if(msgPortElement != null){
			dispatchRegister.setMsgport(Long.parseLong(msgPortElement.getTextTrim()));
		}
    	Element videoPortElement = rootElement.getChild("VideoPort");
		if(videoPortElement != null){
			dispatchRegister.setVideoport(Long.parseLong(videoPortElement.getTextTrim()));
		}

		dispatchRegister.setIp(deviceIP);
		dispatchRegister.setIp2(deviceIp2);
		dispatchRegister.setDeviceNumber(deviceNumber);
		
		return dispatchRegister;
	}
	
	/**
	 * 
	 * @Description: 拼装返回xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param dispatchServer
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	private Document ObjectToXML(DispatchServer dispatchServer){
		Element rootElement = new Element("Message");
		rootElement.setAttribute("ID", dispatchServer.getId());
		rootElement.setAttribute("HeartCycle", String.valueOf(dispatchServer.getHeartCycle()));
		rootElement.setAttribute("MaxInputNum",	String.valueOf(dispatchServer.getMaxInputAmount()));
		rootElement.setAttribute("MaxOutputNum", String.valueOf(dispatchServer.getMaxOutputAmount()));
		rootElement.setAttribute("ResvdOutNum", String.valueOf(dispatchServer.getReservedOutputAmount()));
 
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		
		Element platformIdElement = new Element("PlatformId");
	    platformIdElement.setText(ResourceType.CMS_ID);

	    rootElement.addContent(platformIdElement);
	      
		Document doc = new Document(rootElement);
		return doc;
	}

}
