package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: StoreSchemaAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: StoreSchemaAction-5014
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午07:26:46
 * @version V1.0
 */
public class StoreSchemaAction extends BaseAction implements Action {

	@Autowired
	private VISManager visManager;
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		String id = this.XMLToObject(doc);
		VideoInputChannelVO vic = visManager.getVicById(id);
		//返回
		Document rtn = this.ObjectToXML(vic);
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
		String cameraId = null;
		// XML文档解析
		Element rootElement = doc.getRootElement();
		Element cameraElement = rootElement.getChild("Camera");
		cameraId = cameraElement.getAttributeValue("ID");
		return cameraId;
	}

	/**
	 * 
	 * @Description: 返回 
	 * @author zhuanqi@megaeyes.com
	 * @param @param vic
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(VideoInputChannelVO vic){
		// 获得一级设备类型信息
		String storeSchema = null;
		if (vic.getRemoteStorageServerId() == null) {
			storeSchema = vic.getStorePlanHourFlag() == null ? "" : vic.getStorePlanHourFlag()
							.substring(0, vic.getStorePlanHourFlag().length() > 168 ? 168 : vic.getStorePlanHourFlag().length());
		} else {
			storeSchema = vic.getRemoteStorePlanHourFlag() == null ? "" : vic.getRemoteStorePlanHourFlag()
							.substring(0, vic.getRemoteStorePlanHourFlag().length() > 168 ? 168 : vic.getRemoteStorePlanHourFlag().length());
		}
		// 生成XML文档
		Element rootElement = new Element("Message");
		Element planElement = new Element("Plan");
		planElement.setText(storeSchema);
		rootElement.addContent(planElement);
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}
}
