package com.megaeyes.access.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

/**
 * 前端设备升级
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-23 上午09:04:53
 */
public class ProtocolDownloadAction extends BaseAction implements Action {

	private static final Log log = LogFactory
			.getLog(ProtocolDownloadAction.class);

	public Document proccess(RequestObject req) throws BusinessException {
		log.info("In ProtocolDownloadAction...");
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
