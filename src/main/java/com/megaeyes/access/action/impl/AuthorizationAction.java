package com.megaeyes.access.action.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import test.StringUtil;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.action.data.DeviceInfoDTO;
import com.megaeyes.access.action.data.UserAuthorizationRequestData;
import com.megaeyes.access.common.CppTypeTranslator;
import com.megaeyes.access.common.DeviceType;
import com.megaeyes.access.common.J2eeTypeTranslator;
import com.megaeyes.access.common.Operations;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.access.exception.UnknownDeviceTypeException;
import com.megaeyes.access.exception.UnknownOperationTypeException;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;

/**
 * 接入权限验证，权限方式修改，接口这边暂时不控制权限，有需要在增加
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-7-13 上午09:19:57
 */
public class AuthorizationAction extends BaseAction implements Action {

	private static final Log log = LogFactory.getLog(AuthorizationAction.class);

	@Autowired
	private UserManager userManager;

	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		// 解析xml
		UserAuthorizationRequestData authRequestVO = XMLToObject(doc);
		String userId = "", successFlag = "0", dispatchServerId = "";
		String operationKey = authRequestVO.getOperationKey();
		String userSessionID = authRequestVO.getUserSessionId();
		// 得到用户ID
		try{
			if (StringUtils.isNotBlank(userSessionID)) {
				UserSessionVO user = userManager.getSessionById(userSessionID);
				if (null != user) {
					userId = user.getUserId();
					dispatchServerId = user.getDispatchServerId();
				}
			}
		}catch(BusinessException e){
			e.printStackTrace();
		}
		if (operationKey.equals(Operations.VIC_HISTORY_VIDEO_PLAY)
				|| operationKey.equals(Operations.VIC_PTZ_CONTROL)
				|| operationKey.equals(Operations.VIC_REALTIME_VIDEO_PLAY)) {
			if(StringUtil.isNotBlank(userId)){
				//根据操作类型查询操作项编码
				String operationNumber = J2eeTypeTranslator.getOPerationNumberFromOperationType(operationKey);
				boolean flag = userManager.checkUserPermissionByUserId(userId, operationNumber);
				if (flag) {
					successFlag = "0";
				}else{
					successFlag = ErrorCode.NOT_PRIVILEGE;
				}
			}
		} else if (operationKey.equals(Operations.AIC_CONTROL)) {
			// 报警输入联动不验证权限
			successFlag = "0";
		} else if (operationKey.equals(Operations.MSG_ACCESSAUTH)) {
			if ((userSessionID != null) && (!userSessionID.equals(""))) {
				if ((userId != null) && (!userId.equals(""))) {
					successFlag = "0";
				}
			} else {
				successFlag = ErrorCode.NOT_PRIVILEGE;
			}

		} else {
			// 不验证权限通过
			successFlag = "0";
		}

		// 转换返回需要的资源数据
		DeviceInfoDTO deviceDto = getDeviceInfoVO(authRequestVO.getResourceId(), 
					authRequestVO.getResourceType(), authRequestVO.getResourceNaming());
		deviceDto.setUserId(userId);
		deviceDto.setDispatchServerId(dispatchServerId);
		// 返回
		Document rtn = ObjectToXML(deviceDto, successFlag);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @param @throws UnknownDeviceTypeException
	 * @param @throws UnknownOperationTypeException
	 * @return UserAuthorizationRequestData
	 * @throws
	 */
	private UserAuthorizationRequestData XMLToObject(Document doc){
		UserAuthorizationRequestData authRequestVO = new UserAuthorizationRequestData();
		// 解析XML文档
		Element rootElement = doc.getRootElement();
		Attribute attrUserSessionId = rootElement.getAttribute("UserSessionId");
		Attribute attrResourceId = rootElement.getAttribute("ResourceId");
		Attribute attrResourceType = rootElement.getAttribute("ResourceType");
		Attribute attrOperationKey = rootElement.getAttribute("OperationKey");
		Attribute attrResourceNaming = rootElement.getAttribute("Naming");

		// 得到被操作的Resource Type
		String recourceTypeForCpp = "";
		log.info("attrResourceType:" + attrResourceType.getValue());
		if (attrResourceType.getValue() != null	|| !attrResourceType.getValue().equals("")) {
			recourceTypeForCpp = attrResourceType.getValue();
		}
		String resourceType;
		try {
			resourceType = CppTypeTranslator.getJ2eeResourceCode(recourceTypeForCpp);
		} catch (UnknownDeviceTypeException e) {
			e.printStackTrace();
			throw new BusinessException("RESOURCE_TYPE_UNKNOWN",ErrorCode.RESOURCE_TYPE_UNKNOWN);
		}

		// C++ 操作编号 Operation ID 转换成 J2ee 端的 Operation ID
		String operationKeyForCpp = attrOperationKey.getValue();
		String operationKey;
		try {
			operationKey = CppTypeTranslator.getJ2eeOperationCode(operationKeyForCpp);
		} catch (UnknownOperationTypeException e) {
			e.printStackTrace();
			throw new BusinessException("PARAMETER_VALUE_INVALIDED",ErrorCode.PARAMETER_VALUE_INVALIDED);
		}
		log.info("attrOperationKey:" + attrOperationKey.getValue());
		// 将 C++ 端的 User Session ID 转换成 j2ee 端的 User Session ID
		String userSessionId = attrUserSessionId.getValue();
		// 将 C++ 端的 Resource ID 转换成 j2ee 端的 Resource ID
		String resourceId = "";
		if (!attrResourceId.getValue().equals("")) {
			resourceId = attrResourceId.getValue();
		}
		// 设置权限认证的VO对象
		authRequestVO.setUserSessionId(userSessionId);
		authRequestVO.setResourceId(resourceId);
		authRequestVO.setResourceType(resourceType);
		authRequestVO.setOperationKey(operationKey);
		authRequestVO.setResourceNaming(attrResourceNaming.getValue());
		return authRequestVO;
	}

	/**
	 * 
	 * @Description: 返回xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param deviceInfoVO
	 * @param @param successFlag
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(DeviceInfoDTO deviceInfoVO, String successFlag) {
		// 获得一级设备类型信息
		String deviceType = J2eeTypeTranslator.getCppResourceCodeFromDeviceType(deviceInfoVO.getDeviceType());

		// 获得一级设备ID
		String deviceId = deviceInfoVO.getId();
		Document doc = null;
		// 生成XML文档
		if ((deviceType != null) && (deviceId != null)) {
			Element rootElement = new Element("Message");
			Element successElement = new Element("Success");
			successElement.setText(successFlag);
			Element deviceElement = new Element("Device");

			deviceElement.setAttribute("ID", deviceId);
			deviceElement.setAttribute("Type", deviceType);
			deviceElement.setAttribute("Naming", deviceInfoVO.getNaming());

			Element userElement = new Element("User");
			userElement.setAttribute("ID", deviceInfoVO.getUserId());

			rootElement.addContent(successElement);
			rootElement.addContent(deviceElement);
			rootElement.addContent(userElement);

			if (deviceInfoVO.getDispatchServerId() != null
					&& !deviceInfoVO.getDispatchServerId().equals("")) {
				Element dispatchElement = new Element("DispatchID");
				dispatchElement.addContent(deviceInfoVO.getDispatchServerId());
				rootElement.addContent(dispatchElement);
			}
			doc = new Document(rootElement);
		} else {
			Element rootElement = new Element("Root");
			Element successElement = new Element("Success");
			successElement.setText(successFlag);

			rootElement.addContent(successElement);
			doc = new Document(rootElement);
		}
		return doc;

	}

	// 得到二级设备所属一级设备的值对象
	private DeviceInfoDTO getDeviceInfoVO(String resourceId, String resourceType, String resourceNaming) {
		DeviceInfoDTO deviceInfoVO = new DeviceInfoDTO();
		if (resourceType.equals(ResourceType.CAMERA)) {
			deviceInfoVO.setId(this.getTerminalId(resourceNaming));
			deviceInfoVO.setDeviceType(DeviceType.TERMINAL);
			deviceInfoVO.setNaming(resourceNaming);
		} else if (resourceType.equals(ResourceType.ALARM_IN)) {
			deviceInfoVO.setId(this.getTerminalId(resourceNaming));
			deviceInfoVO.setDeviceType(DeviceType.TERMINAL);
			deviceInfoVO.setNaming(resourceNaming);
		} else if (resourceType.equals(ResourceType.ALARM_OUT)) {
			deviceInfoVO.setId(this.getTerminalId(resourceNaming));
			deviceInfoVO.setDeviceType(DeviceType.TERMINAL);
			deviceInfoVO.setNaming(resourceNaming);
		} else if (resourceType.equals(ResourceType.STORAGE)) {
			deviceInfoVO.setId(resourceId);
			deviceInfoVO.setDeviceType(DeviceType.STORAGE);
			deviceInfoVO.setNaming(resourceNaming);
		} else {
			deviceInfoVO.setId(resourceId);
			deviceInfoVO.setDeviceType(resourceType);
			deviceInfoVO.setNaming(resourceNaming);
		}

		return deviceInfoVO;
	}

	/**
	 * 根据设备Naming获取DVR/DVS的ID
	 * 
	 * @param naming
	 *            设备Naming
	 * @return DVR/DVS的ID
	 */
	private String getTerminalId(String naming) {
		String naming2 = naming.substring(naming.indexOf(":") + 1, naming.length());
		String terminalId = naming2.substring(0, naming2.indexOf(":"));
		return terminalId;
	}
}
