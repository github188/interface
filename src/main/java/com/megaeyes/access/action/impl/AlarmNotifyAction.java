package com.megaeyes.access.action.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 报警通知，废弃的动作，保证接入返回正确就行
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午02:54:03
 */
public class AlarmNotifyAction extends BaseAction implements Action {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final Log log = LogFactory.getLog(AlarmNotifyAction.class);

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In AlarmNotifyAction...");
		Document doc = phaseXML(req);
		Element root = doc.getRootElement();
		Element alarm = root.getChild("Alarm");
		String deviceId = alarm.getAttributeValue("DevID");
		String deviceType = alarm.getAttributeValue("DevType");
		String alarmId = alarm.getAttributeValue("ID");
		// 给个假的值
		if (StringUtils.isBlank(alarmId)) {
			alarmId = "0000000000200090070000000010000";
		}

		// 返回
		Document rtn = new Document();
		Element rtnRoot = new Element("Message");
		Element alarmElement = new Element("Alarm");
		alarmElement.setAttribute("AlarmEventID", alarmId);
		alarmElement.setAttribute("TypeId", "0000000000200000000000001200000");
		alarmElement.setAttribute("TypeName", "移动侦测");
		alarmElement.setAttribute("DevType", deviceType);
		// 设备Naming属性去掉
//        alarmElement.setAttribute("DevNaming", dto.getDevNaming());
        alarmElement.setAttribute("DevName", "摄像头");
        alarmElement.setAttribute("BeginDT",sdf.format(new Date()));
		
		rtnRoot.addContent(alarmElement);
		rtn.setRootElement(rtnRoot);

		Element success = new Element("Success");
		success.setText("0");
		rtnRoot.addContent(success);

		return rtn;
	}

}
