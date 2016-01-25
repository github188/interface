package com.megaeyes.access.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.AlarmManager;

/**
 * 报警确认
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午02:47:48
 */
public class AlarmConfirmAction extends BaseAction implements Action {
	@Autowired
	private AlarmManager alarmManager;

	private static final Log log = LogFactory.getLog(AlarmConfirmAction.class);

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In AlarmConfirmAction...");
		Document doc = phaseXML(req);
		Element root = doc.getRootElement();

		String eventId = root.getAttributeValue("AlarmEventID");
		// String deviceName = root.getAttributeValue("DevName");
		alarmManager.confirmAlarm(eventId);

		// 返回
		Document rtn = new Document();
		Element rtnRoot = new Element("Message");
		rtn.setRootElement(rtnRoot);

		Element success = new Element("Success");
		success.setText("0");
		rtnRoot.addContent(success);
		return rtn;
	}

}
