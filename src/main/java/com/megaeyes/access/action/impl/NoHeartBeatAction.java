package com.megaeyes.access.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 清除用户回话动作，没有用到，保证接入正确返回就行
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-19 下午02:27:04
 */
public class NoHeartBeatAction extends BaseAction implements Action {

	private static final Log log = LogFactory.getLog(NoHeartBeatAction.class);

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In NoHeartBeatAction...");
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
