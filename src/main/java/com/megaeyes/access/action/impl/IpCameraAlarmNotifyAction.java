package com.megaeyes.access.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 
 * IPC报警通知，没有用到，保证接入返回正确就行
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-12 上午10:56:16
 */
public class IpCameraAlarmNotifyAction extends BaseAction implements Action {

	private static final Log log = LogFactory
			.getLog(IpCameraAlarmNotifyAction.class);

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In IpCameraAlarmNotifyAction...");
		// 不需要解析

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
