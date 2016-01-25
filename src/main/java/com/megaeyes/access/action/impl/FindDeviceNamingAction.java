package com.megaeyes.access.action.impl;

import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: FindDeviceNamingAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: 查询设备Naming-1028
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-18 上午08:00:16
 * @version V1.0
 */
public class FindDeviceNamingAction extends BaseAction implements Action {
	@Autowired
	private VISManager visManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		Map<String, Object> param = this.XMLToObject(doc);
		String sourceNaming = "",sourceType = param.get("SourceType").toString() , sourceId = param.get("SourceId").toString();
		if (sourceType.equals("5")) {
			VideoInputChannel vic = visManager.getVicById(sourceId);
			sourceNaming = vic.getNaming();
		} else if (sourceType.equals("6")) {
			AlarmInputChannel aic = visManager.getAIC(sourceId);
			sourceNaming = aic.getNaming();
		} else if (sourceType.equals("8")) {
			AlarmOutputChannel aoc = visManager.getAOC(sourceId);
			sourceNaming = aoc.getNaming();
		}
		//返回
		Document rtn = this.ObjectToXML(sourceNaming);
		return rtn;
	}

	/**
	 * 
	 * @Description:解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return Map<String,Object> 
	 * @throws
	 */
	private Map<String, Object> XMLToObject(Document doc) {
		Map<String, Object> param = new HashMap<String, Object>();
		// XML文档解析
		Element rootElement = doc.getRootElement();
		Element id = rootElement.getChild("SourceId");
		Element type = rootElement.getChild("SourceType");
		param.put("SourceId", id.getText());
		param.put("SourceType", type.getText());
		return param;
	}

	/**
	 * 
	 * @Description: 返回 
	 * @author zhuanqi@megaeyes.com
	 * @param @param naming
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	private Document ObjectToXML(String naming) {
		Element rootElement = new Element("Message");
		Element sourceNaming = new Element("SourceNaming");
		sourceNaming.setText(naming);
		rootElement.addContent(sourceNaming);
		Document doc = new Document(rootElement);
		return doc;
	}
}
