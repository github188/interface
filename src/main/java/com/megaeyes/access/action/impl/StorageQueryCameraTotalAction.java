package com.megaeyes.access.action.impl;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import test.StringUtil;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.vo.StorageServerVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.StorageServerManager;
import com.megaeyes.service.iface.VICManager;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: StorageQueryCameraTotalAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: 中心存储获取摄像头信息总数-4012
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-30 下午05:55:57
 * @version V1.0
 */
public class StorageQueryCameraTotalAction extends BaseAction implements Action {
	// 区分是前端存储还是中心存储
    private static final String TAIL_FALG = "_T";

	@Autowired
	private VICManager vicManager;
	
	@Autowired
	private VISManager visManager;
	
	@Autowired
	private StorageServerManager stroageServerManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		StorageServerVO storageRegister = XMLToObject(doc);
		StorageServer ss = stroageServerManager.getStorageServerById(storageRegister.getId());
		
		int count = 0;
		if (ss.getDeviceNumber().indexOf(TAIL_FALG) > 0){
			String visId = stroageServerManager.getVisIdByLocalStorageServerId(ss.getId());
			List<VideoInputChannelVO> vicList = visManager.getVicListByVisId(visId);
			for(VideoInputChannelVO temp:vicList){
				//计算摄像头存储到本地存储服务器的数量
                if(StringUtil.isNotBlank(temp.getRemoteStorageServerId()) || temp.getStoreType()== 0){
                	count ++;
                }
			}
		}else{
			//计算摄像头存储到该中心存储服务器的数量
			count = vicManager.getVicCountByRemoteStorageId(storageRegister.getId());
		}
		//返回
		Document rtn = ObjectToXML(count);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析注册XML
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return StorageServerVO 
	 * @throws
	 */
	public StorageServerVO XMLToObject(Document doc) {
		StorageServerVO storageRegister = new StorageServerVO();
		Element rootElement = doc.getRootElement();
		Element elemStoreDeviceID = rootElement.getChild("StoreDeviceID");
		String deviceID = elemStoreDeviceID.getText();
		storageRegister.setId(deviceID);
		return storageRegister;
	}

	/**
	 * 
	 * @Description: 返回
	 * @author zhuanqi@megaeyes.com
	 * @param @param count
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(Integer count){
		Element rootElement = new Element("Message");
		Element rowCountElement = new Element("CameraCount");
		rowCountElement.setText(count == null ? "0" : count.toString());
		rootElement.addContent(rowCountElement);

		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;

	}

}
