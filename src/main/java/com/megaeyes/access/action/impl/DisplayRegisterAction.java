package com.megaeyes.access.action.impl;

import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.DeviceLinkType;
import com.megaeyes.access.common.NamingUtil;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.VOCManager;
import com.megaeyes.service.iface.VideoDisplayDeviceManager;

/**
 * 
 * @Title: DisplayRegisterAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: 显示服务器注册-6000
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-21 下午05:03:08
 * @version V1.0
 */
public class DisplayRegisterAction extends BaseAction implements Action {
	
	@Autowired
	private VOCManager vocManager;
	
	@Autowired
	private VideoDisplayDeviceManager displayServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		//获取注册信息
		VideoDisplayDevice displayRegister = XMLToObject(doc);
		//查询显示服务器信息
		VideoDisplayDevice displayRecord = displayServerManager.getVideoDisplayByDeviceNumber(displayRegister.getDeviceNumber());
		//注册显示服务器
		displayRecord.setIp(displayRegister.getIp());
		displayRecord.setLinkType(displayRegister.getLinkType());
		displayRecord.setNaming(displayRecord.getId() + NamingUtil.NAMING_SPLIT + req.getAccessId() + NamingUtil.NAMING_SPLIT + ResourceType.CMS_ID);
		displayServerManager.displayRegister(displayRecord);
		//更新VOC Naming
		List<VideoOutputChannel> vocList = vocManager.listVocByDisplayId(displayRecord.getId());
        Iterator<VideoOutputChannel> its = vocList.iterator();
        while (its.hasNext())
        {
            VideoOutputChannel voc = (VideoOutputChannel) its.next();
            voc.setNaming(voc.getId() + NamingUtil.NAMING_SPLIT + displayRecord.getId() + NamingUtil.NAMING_SPLIT +  req.getAccessId() + NamingUtil.NAMING_SPLIT + ResourceType.CMS_ID);
            vocManager.updateByPrimaryKeySelective(voc);
        }
		// 返回
		Document rtn = ObjectToXML(displayRecord);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析注册xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return VideoDisplayDevice 
	 * @throws
	 */
	public VideoDisplayDevice XMLToObject(Document doc) {
		VideoDisplayDevice displayRegister = new VideoDisplayDevice();
		// XML文档解析
		Element rootElement = doc.getRootElement();
		Element DeviceNumberElement = rootElement.getChild("DeviceNumber");
		Element DeviceIPElement = rootElement.getChild("DeviceIP");
		Element DeviceLinkTypeElement = rootElement.getChild("DeviceLinkType");

		// 得到设备编号
		String DeviceNumber = DeviceNumberElement.getText();
		String DeviceIP = DeviceIPElement.getText();
		displayRegister.setDeviceNumber(DeviceNumber);
		displayRegister.setIp(DeviceIP);
		// 得到设备连接类型
		int deviceLinkType = Integer.parseInt(DeviceLinkTypeElement.getText());
		if (deviceLinkType == 1) {
			displayRegister.setLinkType(DeviceLinkType.LAN);
		} else if (deviceLinkType == 2) {
			displayRegister.setLinkType(DeviceLinkType.ADSL);
		}
		return displayRegister;
	}

	/**
	 * 
	 * @Description: 拼装返回信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param inObject
	 * @param @return
	 * @param @throws ServiceProxyException 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(VideoDisplayDevice displayServer) {
		/**
		 * 信息格式：<br> 
		 * <Message> 
		 * <DisplaySetting ID=1 HeartCycle=1 SysRebootTime=1 SysRebootCycle=1> 
		 * <Monitor ID=1 Name="mingzi"> 
		 * <Monitor ID=n Name="mingzi"> 
		 * </Message>
		 */
		
		Element rootElement = new Element("Message");
		// 得到显示设备ID
		String displayId = displayServer.getId();
		// 加入显示设备设置信息
		Element displayElement = new Element("DisplaySetting");
		displayElement.setAttribute("ID", displayId);
		
		String naming = displayServer.getNaming();
	    displayElement.setAttribute("Naming", naming == null ? "" : naming);
	    
		displayElement.setAttribute("HeartCycle", new Long(displayServer.getHeartCycle()).toString());
		displayElement.setAttribute("SysRebootTime", displayServer.getRebootTime());
		displayElement.setAttribute("SysRebootCycle", new Long(displayServer.getRebootCycle()).toString());
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		rootElement.addContent(displayElement);

		// 获取该显示设备下所有的监视器
		List<VideoOutputChannel> vocList = vocManager.listVocByDisplayId(displayServer.getId());
		// 加入监视器信息
		for (VideoOutputChannel voc:vocList) {
			Element monitorElement = new Element("Monitor");
			monitorElement.setAttribute("ID", voc.getId());
			monitorElement.setAttribute("Name", voc.getName());
			monitorElement.setAttribute("Naming", voc.getNaming() == null ? "" : String.valueOf(voc.getNaming()));
			 monitorElement.setAttribute("ChannelId", "");
			rootElement.addContent(monitorElement);
		}
		Document doc = new Document(rootElement);
		return doc;
	}

}
