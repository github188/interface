package com.megaeyes.access.action.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VOCManager;

/**
 * 监视器权限验证
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-16 上午09:40:20
 */
public class MonitorAuthAction extends BaseAction implements Action {

	private static final Log log = LogFactory.getLog(MonitorAuthAction.class);
	@Autowired
	private VOCManager vocManager;

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In MonitorAuthAction...");
		Document doc = phaseXML(req);
		Element root = doc.getRootElement();
		// 得到监视器ID
		Element monitorElement = root.getChild("Monitor");
		String monitorId = monitorElement.getAttributeValue("ID");
		// 得到播放摄像头列表
		Element CameraListElement = root.getChild("CameraList");
		List<Element> cameraList = CameraListElement.getChildren("Camera");
		List<MonitorAuthAction.Camera> cameras = new ArrayList<MonitorAuthAction.Camera>();
		for (Element e : cameraList) {
			Camera camera = this.new Camera();
			camera.setId(e.getAttributeValue("ID"));
			camera.setNaming(e.getAttributeValue("Naming"));
		}

		// 获取监视所属的显示墙ID
		VideoOutputChannel voc = vocManager.getVOC(monitorId);
		if (null == voc) {
			throw new BusinessException(
					"voc id[" + monitorId + "] not found !",
					ErrorCode.RESOURCE_NOT_FOUND);
		}
		String displayId = voc.getVideoDisplayDeviceId();

		// 获取绑定的分发ID
		String dispatchServerId = voc.getDispatchServerId();

		// 返回
		Document rtn = new Document();
		Element rtnRoot = new Element("Message");
		rtn.setRootElement(rtnRoot);

		Element success = new Element("Success");
		success.setText("0");
		rtnRoot.addContent(success);

		Element DisplayElement = new Element("Display");
		DisplayElement.setAttribute("ID", displayId);
		rtnRoot.addContent(DisplayElement);

		if (StringUtils.isNotBlank(dispatchServerId)) {
			Element dispatchElement = new Element("DispatchID");
			dispatchElement.addContent(dispatchServerId);
			rtnRoot.addContent(dispatchElement);
		}

		Element me = new Element("Monitor");
		me.setAttribute("ID", monitorId);
		me.setAttribute("HasRealTimeVideo", "true");
		me.setAttribute("HasHistoryVideo", "true");
		rtnRoot.addContent(me);

		Element camerasElement = new Element("CameraList");
		for (Camera c : cameras) {
			Element cameraElement = new Element("Camera");
			cameraElement.setAttribute("ID", c.getId());
			cameraElement.setAttribute("Naming", c.getNaming());
			cameraElement.setAttribute("HasRealTimeVideo",
					c.getHasRealTimeVideo());
			cameraElement.setAttribute("HasHistoryVideo",
					c.getHasHistoryVideo());
			camerasElement.addContent(cameraElement);
		}
		rtnRoot.addContent(camerasElement);

		return rtn;
	}

	public class Camera {
		private String id;
		private String naming;
		/**
		 * 是否有实时视频权限，默认有
		 */
		private String hasRealTimeVideo = "true";
		/**
		 * 是否有历史视频权限，默认有
		 */
		private String hasHistoryVideo = "true";

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNaming() {
			return naming;
		}

		public void setNaming(String naming) {
			this.naming = naming;
		}

		public String getHasRealTimeVideo() {
			return hasRealTimeVideo;
		}

		public void setHasRealTimeVideo(String hasRealTimeVideo) {
			this.hasRealTimeVideo = hasRealTimeVideo;
		}

		public String getHasHistoryVideo() {
			return hasHistoryVideo;
		}

		public void setHasHistoryVideo(String hasHistoryVideo) {
			this.hasHistoryVideo = hasHistoryVideo;
		}
	}

}
