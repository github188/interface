package com.megaeyes.access.action.impl;

import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.action.data.UserLogData;
import com.megaeyes.access.common.CppTypeTranslator;
import com.megaeyes.access.exception.UnknownDeviceTypeException;
import com.megaeyes.access.exception.UnknownOperationTypeException;
import com.megaeyes.access.util.Utility;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;

/**
 * 
 * @Title: UserOperationLogAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: UserOperationLogAction-1004
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-19 上午08:08:18
 * @version V1.0
 */
public class UserOperationLogAction extends BaseAction implements Action {

	@Override
	public Document proccess(RequestObject req) throws BusinessException {

		Document doc = super.phaseXML(req);
		UserLogData userOperationLogDTO = this.XMLToObject(doc,req.getMessageId());
		// 监视器播放实时视频
		if (("0000000000000000000000000000014").equals(userOperationLogDTO.getOperationId())) {
			return null;
		}
		// 监视器播放历史视频
		if (("0000000000000000000000000000015").equals(userOperationLogDTO.getOperationId())) {
			return null;
		}
		// 监视停止播放视频
		if (("0000000000000000000000000000016").equals(userOperationLogDTO.getOperationId())) {
			return null;
		}
		// 监视器播放方案
		if (("0000000000000000000000000000017").equals(userOperationLogDTO.getOperationId())) {
			return null;
		}

		//返回
		Document rtn = this.ObjectToXML();
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析协议xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return UserLogData 
	 * @throws
	 */
	public UserLogData XMLToObject(Document doc,String ip) {
		UserLogData userOperationLogDTO = new UserLogData();
		// xml文档解析
		Element rootElement = doc.getRootElement();
		Element sourceElement = rootElement.getChild("Source");
		Element destinationElement = rootElement.getChild("Destination");
		Element operationElement = rootElement.getChild("Operation");
		Element resultElement = rootElement.getChild("Result");
		// 得到用户sessionId
		String sessionId = sourceElement.getAttributeValue("ID");
		// 得到操作目标类型
		String deviceTypeForCpp = destinationElement.getAttributeValue("Type");
		String desType = null ;
		try {
			desType = CppTypeTranslator.getJ2eeResourceCode(deviceTypeForCpp);
		} catch (UnknownDeviceTypeException e) {
			throw new BusinessException(ErrorCode.RESOURCE_NOT_FOUND, e.getMessage());
		}
		// 得到操作目标ID
		String desId = destinationElement.getAttributeValue("ID");
		// 得到操作目标Naming
		String desNaming = destinationElement.getAttributeValue("Naming");
		// 得到操作键值,操作key需要转换
		String operationKey = null;
		try {
			operationKey = CppTypeTranslator.getJ2eeUserOperationLogKey(operationElement.getAttributeValue("Key"));
		} catch (UnknownOperationTypeException e) {
			throw new BusinessException(ErrorCode.PARAMETER_VALUE_INVALIDED, e.getMessage());
		}

		// 得到操作时间
		Date date = Utility.cppStringToDate(operationElement.getAttributeValue("DateTime"));
		long nofiyTime = date.getTime();
		// 得到结果名称
		String effectName = resultElement.getAttributeValue("EffectName");
		// 得到结果描述
		String resultDescription = resultElement.getAttributeValue("Description");
		// 设置用户操作日志DTO
		userOperationLogDTO.setId(sessionId);
		userOperationLogDTO.setTargetType(desType);
		userOperationLogDTO.setTargetId(desId);
		userOperationLogDTO.setOperationId(operationKey);
		userOperationLogDTO.setTime(nofiyTime);
		// ip地址
		userOperationLogDTO.setIp(ip);
		userOperationLogDTO.setEffectName(effectName);
		userOperationLogDTO.setNaming(desNaming);
		return userOperationLogDTO;
	}

	/**
	 * 
	 * @Description: 返回
	 * @author zhuanqi@megaeyes.com
	 * @param @param inObject
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML() {
		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}

}
