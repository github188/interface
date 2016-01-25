package com.megaeyes.access.action.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;

/**
 * BaseAction(类说明)
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-26 上午09:57:57
 */
public abstract class BaseAction implements Action {

	private static final Log log = LogFactory.getLog(BaseAction.class);

	public Document phaseXML(RequestObject req) throws BusinessException {
		log.info("messageId is : " + req.getMessageId());
		log.info("accessId is : " + req.getAccessId());
		log.info(req.getXml());

		if (StringUtils.isNotBlank(req.getXml())) {
			// 解析xml
			SAXBuilder builder = new SAXBuilder();
			Document doc = null;
			InputStream in;
			try {
				in = new ByteArrayInputStream(req.getXml().getBytes("gbk"));
			} catch (UnsupportedEncodingException e) {
				// 尝试用utf8解析
				try {
					in = new ByteArrayInputStream(req.getXml().getBytes("utf8"));
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
					throw new BusinessException(
							"request xml charset not support !",
							ErrorCode.PARAMETER_VALUE_INVALIDED);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("phase xml encounter error !",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
			try {
				doc = builder.build(in);
				return doc;
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("phase xml encounter error !",
						ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
		} else {
			throw new BusinessException("xml", ErrorCode.PARAMETER_NOT_FOUND);
		}
	}
}
