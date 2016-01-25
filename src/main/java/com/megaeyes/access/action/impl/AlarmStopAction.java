package com.megaeyes.access.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 报警停止，没有用到，保证接入正确返回就行
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-12 上午11:00:59
 */
public class AlarmStopAction extends BaseAction implements Action {

	private static final Log log = LogFactory.getLog(AlarmStopAction.class);

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In AlarmStopAction...");
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
