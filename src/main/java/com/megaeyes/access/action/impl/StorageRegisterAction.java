package com.megaeyes.access.action.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.DeviceLinkType;
import com.megaeyes.access.common.NamingUtil;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.model.RemoteStorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.StorageServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.StorageServerManager;
import com.megaeyes.service.iface.VICManager;

/**
 * 
 * @Title: StorageRegisterAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: 存储服务器注册-4002
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-21 下午05:01:11
 * @version V1.0
 */
public class StorageRegisterAction extends BaseAction implements Action {
	
	// 区分是前端存储还是中心存储
    private static final String TAIL_FALG = "_T";
    
    @Autowired
	private VICManager vicManager;
	
    @Autowired
    private StorageServerManager storageServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		//获取存储服务器注册信息
		StorageServerVO storageRegisterVo = XMLToObject(doc);
		if (storageRegisterVo.getStorageServer().getDeviceNumber().indexOf(TAIL_FALG) > 0){
            // 注册前端存储
			registerLocalStorage(storageRegisterVo,req.getAccessId());
			// 返回
			Document rtn = ObjectToXML(storageRegisterVo);
			return rtn;
        } else {
            // 注册中心存储
        	registerRemoteStorage(storageRegisterVo,req.getAccessId());
            if(storageRegisterVo.getRemoteStorageServer().getHasVod() == 0) {
            	//中心存储3.0获取设备列表
            	registerRemoteStorage30(storageRegisterVo, req.getAccessId());
            }
            // 返回
			Document rtn = ObjectToXML(storageRegisterVo);
			return rtn;
        }
	}

	/**
	 * 
	 * @Description: 前端存储注册
	 * @author zhuanqi@megaeyes.com
	 * @param @param storageRegisterVo
	 * @param @param accessId 
	 * @return void 
	 * @throws
	 */
    private void registerLocalStorage(StorageServerVO storageRegisterVo,String accessId) {
    	String cmsId = ResourceType.CMS_ID;
    	StorageServer storageRegister = storageRegisterVo.getStorageServer();
        // 查询存储服务器信息
    	StorageServer storageRecord = storageServerManager.getStorageServerByDeviceNumber(storageRegister.getDeviceNumber());
        // 拼装Naming
    	String naming = storageRecord.getId() + NamingUtil.NAMING_SPLIT + accessId + NamingUtil.NAMING_SPLIT + cmsId ;
        // 更新存储服务器表信息
    	storageRecord.setNaming(naming);
    	storageRecord.setIp(storageRegister.getIp());
    	storageRecord.setIp2(storageRegister.getIp2());
    	storageRecord.setLinkType(storageRegister.getLinkType());
    	storageRecord.setMessagePort(storageRegister.getMessagePort());
        storageServerManager.registerStorageServer(storageRecord);
        // 返回空摄像头列表
        storageRegisterVo.setStorageServer(storageRecord);
        storageRegisterVo.setCameraList(new ArrayList<VideoInputChannel>());
    }
    
    /**
     * 
     * @Description:中心存储注册
     * @author zhuanqi@megaeyes.com
     * @param @param storageRegisterVo
     * @param @param accessId 
     * @return void 
     * @throws
     */
    private void registerRemoteStorage(StorageServerVO storageRegisterVo, String accessId) {
    	StorageServer storageRegister = storageRegisterVo.getStorageServer();
    	RemoteStorageServer remoteStorageRegister = storageRegisterVo.getRemoteStorageServer();
    	// 查询存储服务器信息
    	StorageServer storageRecord = storageServerManager.getStorageServerByDeviceNumber(storageRegister.getDeviceNumber());
    	int hasVod = storageServerManager.hasVod(storageRegister.getDeviceNumber());
        // 中心存储设备的能力的不匹配的说明
        if(remoteStorageRegister.getHasVod() != hasVod){
            throw new BusinessException("store server config is matching!!", ErrorCode.PARAMETER_VALUE_INVALIDED);
        }
        
        String cmsId = ResourceType.CMS_ID;
    	String naming = storageRecord.getId() + NamingUtil.NAMING_SPLIT + accessId + NamingUtil.NAMING_SPLIT + cmsId ;
    	storageRecord.setNaming(naming);
    	storageRecord.setIp(storageRegister.getIp());
    	storageRecord.setIp2(storageRegister.getIp2());
    	storageRecord.setLinkType(storageRegister.getLinkType());
    	storageRecord.setMessagePort(storageRegister.getMessagePort());
    	// 
        storageServerManager.registerStorageServer(storageRecord);
        // 返回空摄像头列表
        storageRegisterVo.setStorageServer(storageRecord);
        storageRegisterVo.setCameraList(new ArrayList<VideoInputChannel>());
    }
    
    
    /**
     * 
     * @Description: 中心存储3.0需要返回摄像头列表 
     * @author zhuanqi@megaeyes.com
     * @param @param storageRegister
     * @param @param accessId
     * @param @return 
     * @return StorageServer 
     * @throws
     */
    private void registerRemoteStorage30(StorageServerVO storageRegisterVo,String accessId){
    	StorageServer storageRegister = storageRegisterVo.getStorageServer();
        List<VideoInputChannel> cameraList = vicManager.getVicListByRemoteStorageServerId(storageRegister.getId());
        storageRegisterVo.setCameraList(cameraList);
    }
    
	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @return Object
	 * @throws
	 */
	private StorageServerVO XMLToObject(Document doc) {
		StorageServerVO storageRegister = new StorageServerVO();
		StorageServer storageServer = new StorageServer();
		Element rootElement = doc.getRootElement();
		Attribute attrDeviceID = rootElement.getAttribute("DeviceID");
		Attribute attrDeviceIP = rootElement.getAttribute("DeviceIP");
		Attribute attrDeviceLinkType = rootElement.getAttribute("DeviceLinkType");
		Attribute attrDeviceIP2 = rootElement.getAttribute("DeviceIP2");
		Attribute attrVirtualIP = rootElement.getAttribute("VirtualIP");
		Element msgPortElement = rootElement.getChild("MsgPort");

		if (attrDeviceIP2 != null) {
			storageServer.setIp2(attrDeviceIP2.getValue());
		}
		int nMsgPort = 4196;
		try {
			if (msgPortElement != null) {
				String sPort = msgPortElement.getText();
				nMsgPort = Integer.parseInt(sPort);
			}
		} catch (Exception ex) {
			nMsgPort = 4196;
		} finally {
			storageServer.setMessagePort(new Long(nMsgPort));
		}
		storageServer.setIp(attrDeviceIP.getValue());
		storageServer.setDeviceNumber(attrDeviceID.getValue());
		int deviceLinkType = new Integer(attrDeviceLinkType.getValue()).intValue();
		if (deviceLinkType == 1) {
			storageServer.setLinkType(DeviceLinkType.LAN);
		} else if (deviceLinkType == 2) {
			storageServer.setLinkType(DeviceLinkType.ADSL);
		}
		storageRegister.setStorageServer(storageServer);
		
		if (storageServer.getDeviceNumber().indexOf(TAIL_FALG) > 0){
			//前端存储
			return storageRegister;
		} else {
			// 3.2中增加VOD的处理
			Element suportElement = rootElement.getChild("Support");
			RemoteStorageServer remoteStorageServer = new RemoteStorageServer();
			if (suportElement == null) {
				remoteStorageServer.setHasVod(new Integer(0).shortValue());
			} else {
				Attribute supportVod = suportElement.getAttribute("VOD");
				String vod = supportVod.getValue();
				if (vod.equalsIgnoreCase("TRUE")) {
					remoteStorageServer.setHasVod(new Integer(1).shortValue());
				} else {
					remoteStorageServer.setHasVod(new Integer(0).shortValue());
				}
			}
			storageRegister.setRemoteStorageServer(remoteStorageServer);
			return storageRegister;
		}

	}

	/**
	 * 
	 * @Description:拼装返回的xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param storageServer
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(StorageServerVO storageRegisterVo) {
		Element rootElement = new Element("Message");
		StorageServer storageServer = storageRegisterVo.getStorageServer();
		// 得到存储服务器ID
		String storageId = storageServer.getId();
		rootElement.setAttribute("ID", storageId);
		rootElement.setAttribute("HeartCycle",	new Long(storageServer.getHeartCycle()).toString());
		rootElement.setAttribute("MaxInputNum",	new Long(storageServer.getMaxInputAmount()).toString());
		rootElement.setAttribute("MaxOutputNum", new Long(storageServer.getMaxOutputAmount()).toString());
		rootElement.setAttribute("FtpUser", storageServer.getFtpUserName());
		rootElement.setAttribute("FtpPwd", storageServer.getFtpPassword());
		rootElement.setAttribute("FtpPort",	new Long(storageServer.getFtpPort()).toString());

		// 3.2去掉返回Camera的信息
		List viclist = storageRegisterVo.getCameraList();
		for (int i = 0; i < viclist.size(); i++) {
			Element cameraElement = new Element("Camera");
			VideoInputChannel cameraVO = (VideoInputChannel) viclist.get(i);
			if (cameraVO.getId() != null) {
				cameraElement.setAttribute("DeviceID", cameraVO.getId());
			}
			if (cameraVO.getId() != null) {
				cameraElement.setAttribute("ID", cameraVO.getId());
			}

			cameraElement.setAttribute("StoreCycle", new Long(cameraVO.getStoreCycle()).toString());
			rootElement.addContent(cameraElement);
		}
		
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;

	}
}
