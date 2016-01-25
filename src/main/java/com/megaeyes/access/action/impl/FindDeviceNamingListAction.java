package com.megaeyes.access.action.impl;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.action.data.FindDeviceNamingListData;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: FindDeviceNamingListAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description:查询设备Naming-1030
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-18 上午08:41:36
 * @version V1.0
 */
public class FindDeviceNamingListAction extends BaseAction implements Action {

	@Autowired
	private VISManager visManager;

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		FindDeviceNamingListData data = this.XMLToObject(doc);

		// aoc转换
		List<?> aoclist = data.getAoclist();
		List<String> aocNamingList = new ArrayList<String>();
		for (int i = 0; i < aoclist.size(); i++) {
			String aocId = (String) aoclist.get(i);
			AlarmOutputChannel aoc = visManager.getAOC(aocId);
			aocNamingList.add(aoc.getNaming());
		}
		// vic转换
		List<?> cameralist = data.getCameralist();
		List<String> cameraNamingList = new ArrayList<String>();
		for (int i = 0; i < cameralist.size(); i++) {
			String cameraId = (String) cameralist.get(i);
			VideoInputChannel vic = visManager.getVicById(cameraId);
			cameraNamingList.add(vic.getNaming());
		}
		data.setAoclist(aocNamingList);
		data.setCameralist(cameraNamingList);

		Document rtn = this.ObjectToXML(data);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @return FindDeviceNamingListData
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public FindDeviceNamingListData XMLToObject(Document doc) {
		FindDeviceNamingListData data = new FindDeviceNamingListData();
		List<String> aoclist = new ArrayList<String>();
		List<String> cameralist = new ArrayList<String>();

		Element rootElement = doc.getRootElement();
		Element Plan = rootElement.getChild("Plan");
		Element UserList = rootElement.getChild("UserList");
		Element AlarmOutTime = rootElement.getChild("AlarmOutTime");
		Element KinescopeTime = rootElement.getChild("KinescopeTime");
		Element AheadTime = rootElement.getChild("AheadTime");

		Element AlarmOutList = rootElement.getChild("AlarmOutList");
		if (AlarmOutList != null) {
			List<Element> AlarmOut = AlarmOutList.getChildren("AlarmOut");
			for (int len = 0; len < AlarmOut.size(); len++) {
				Element alarmOutElement = AlarmOut.get(len);
				String alarmOutID = alarmOutElement.getText();
				aoclist.add(alarmOutID);
			}
		}

		Element CameraList = rootElement.getChild("CameraList");
		if (CameraList != null) {
			List<Element> Camera = CameraList.getChildren("Camera");
			for (int len = 0; len < Camera.size(); len++) {
				Element cameraElement = Camera.get(len);
				String cameraID = cameraElement.getText();
				cameralist.add(cameraID);
			}
		}

		data.setAheadTime(AheadTime);
		data.setAlarmOutTime(AlarmOutTime);
		data.setAoclist(aoclist);
		data.setCameralist(cameralist);
		data.setKinescopeTime(KinescopeTime);
		data.setUserList(UserList);
		data.setPlan(Plan);

		return data;
	}

	/**
	 * 
	 * @Description:返回
	 * @author zhuanqi@megaeyes.com
	 * @param @param data
	 * @param @return
	 * @return Document
	 * @throws
	 */
	public Document ObjectToXML(FindDeviceNamingListData data) {
		Element rootElement = new Element("Message");

		Element AheadTimeElement = data.getAheadTime();
		Element AlarmOutTimeElement = data.getAlarmOutTime();
		Element KinescopeTimeElement = data.getKinescopeTime();
		Element UserListElement = data.getUserList();
		Element PlanElement = data.getPlan();

		if (AheadTimeElement != null) {
			rootElement.addContent(AheadTimeElement.detach());
		}
		if (AlarmOutTimeElement != null) {
			rootElement.addContent(AlarmOutTimeElement.detach());
		}
		if (KinescopeTimeElement != null) {
			rootElement.addContent(KinescopeTimeElement.detach());
		}
		if (UserListElement != null) {
			rootElement.addContent(UserListElement.detach());
		}
		if (PlanElement != null) {
			rootElement.addContent(PlanElement.detach());
		}

		List<?> AlarmOutList = data.getAoclist();
		List<?> CameraList = data.getCameralist();

		Element AlarmOutListElement = new Element("AlarmOutList");
		for (int i = 0; i < AlarmOutList.size(); i++) {
			Element AlarmOutElement = new Element("AlarmOut");
			AlarmOutElement.setText((String) AlarmOutList.get(i));
			AlarmOutListElement.addContent(AlarmOutElement);
		}
		rootElement.addContent(AlarmOutListElement);

		Element CameraListElement = new Element("CameraList");
		for (int i = 0; i < CameraList.size(); i++) {
			Element CameraElement = new Element("Camera");
			CameraElement.setText((String) CameraList.get(i));
			CameraListElement.addContent(CameraElement);
		}
		rootElement.addContent(CameraListElement);

		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);

		return doc;
	}

}
