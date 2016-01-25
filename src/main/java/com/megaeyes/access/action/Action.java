package com.megaeyes.access.action;

import org.jdom.Document;

import com.megaeyes.access.RequestObject;
import com.megaeyes.service.exception.BusinessException;

/**
 * 所有Action实现类的接口
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-6-25 下午01:55:16
 */
public interface Action {

	/**
	 * 接口具体执行方法
	 * 
	 * @param req
	 *            请求参数
	 * @return 返回xml文本
	 * @throws BusinessException
	 */
	public Document proccess(RequestObject req) throws BusinessException;

	/**
	 * 解析xml
	 * 
	 * @param req
	 *            请求参数
	 * @return 解析成功的XML
	 * @throws BusinessException
	 */
	public Document phaseXML(RequestObject req) throws BusinessException;
}
