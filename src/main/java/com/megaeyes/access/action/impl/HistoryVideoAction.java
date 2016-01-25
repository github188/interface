package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import test.StringUtil;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.StorageServerManager;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: HistoryVideoAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: HistoryVideoAction-5004
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-20 上午07:05:26
 * @version V1.0
 */
public class HistoryVideoAction extends BaseAction implements Action {

	@Autowired
	private VISManager visManager;

	@Autowired
	private StorageServerManager storageServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		String vicId = this.XMLToObject(doc);
		VideoInputChannelVO vic = visManager.getVicById(vicId);
		VideoInputServer vis = visManager.getVisById(vic.getVideoInputServerId());
		
		if(vic.getStoreType() == 1 && StringUtil.isNotBlank(vic.getRemoteStorageServerId())){
			vic.setLocalStorageServerId(vic.getRemoteStorageServerId());
        }else{
        	if (vis.getVisType().equalsIgnoreCase("ipvis")) {
    			vic.setLocalStorageServerId(vis.getId() + "_T");
    		}else{
    			 // 查询存储服务器信息
		    	StorageServer storageRecord = storageServerManager.getStorageServerByDeviceNumber(vis.getDeviceNumber().trim() + "_T");
		    	vic.setLocalStorageServerId(storageRecord.getId());
    		}
        	if (vic.getRemoteStorageServerId() != null  && vic.getStoreType() == 2)
            {
        		vic.setRemoteStorageServerId(vic.getRemoteStorageServerId());
            }else{
            	vic.setRemoteStorageServerId(null);
            }
        }
		
		// 返回
		Document rtn = this.ObjectToXML(vic);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String XMLToObject(Document doc) {
		String cameraId = null;
		Element rootElement = doc.getRootElement();
		Element CameraIDElement = rootElement.getChild("CameraID");
		cameraId = CameraIDElement.getText();
		return cameraId;
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
	public Document ObjectToXML(VideoInputChannelVO vic) {
		Document doc = null;
		Element rootElement = new Element("Message");
		Element encodeTypeElement = new Element("EncodeType");
		encodeTypeElement.addContent(vic.getVideoFormat());
	    rootElement.addContent(encodeTypeElement);
	    
		// 得到本地存储服务器ID，远程存储模式例外    
		Element storageIdElement = new Element("StoreID");
	    storageIdElement.addContent(vic.getLocalStorageServerId());
	    rootElement.addContent(storageIdElement);
	    
	    // 得到远程存储服务器ID
	    if(vic.getRemoteStorageServerId() != null){
		      Element remoteStorageIdElement = new Element("RemoteStoreID");
		      remoteStorageIdElement.addContent(vic.getRemoteStorageServerId());
		      rootElement.addContent(remoteStorageIdElement);
	    }
	    
	    Element successElement = new Element("Success");
	 	successElement.setText("0");
	 	rootElement.addContent(successElement);
		doc = new Document(rootElement);
		return doc;
	}
}
