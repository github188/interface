package com.megaeyes.access.action.impl;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.action.data.SetDeviceAlarmData;
import com.megaeyes.access.common.CppTypeTranslator;
import com.megaeyes.access.exception.UnknownDeviceTypeException;
import com.megaeyes.persistence.ibatis.model.AlarmScheme;
import com.megaeyes.persistence.ibatis.vo.EpSchemeVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpSchemeManager;

/**
 * 
 * @Title: SetDeviceAlarmAction.java
 * @Package com.megaeyes.service.impl
 * @Description: SetDeviceAlarmAction
 * @author zhuanqi@megaeyes.com-5208
 * @date 2012-9-20 上午09:36:33
 * @version V1.0
 */
public class SetDeviceAlarmAction extends BaseAction implements Action {
	@Autowired
	private EpSchemeManager epSchemeManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = super.phaseXML(req);
		SetDeviceAlarmData data = this.XMLToObject(doc);
		//返回
		Document rtn = ObjectToXML(data);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return Object 
	 * @throws
	 */
	public SetDeviceAlarmData XMLToObject(Document doc) {
		SetDeviceAlarmData data = new SetDeviceAlarmData();
		// XML文档解析
		Element rootElement = doc.getRootElement();
		Element NamingElement = rootElement.getChild("Naming");
		String naming = NamingElement.getText();
		Element DevTypeElement = rootElement.getChild("DevType");
		String devType = null;
		try {
			devType = CppTypeTranslator.getJ2eeDeviceCode(DevTypeElement.getText());
		} catch (UnknownDeviceTypeException e) {
			throw new BusinessException(ErrorCode.RESOURCE_TYPE_UNKNOWN, e.getMessage());
		}
		Element UserNamingElement = rootElement.getChild("UserNaming");
		String userNaming = UserNamingElement.getText();
		Element SchemeElement = rootElement.getChild("Scheme");
		String schemeId = SchemeElement.getAttribute("ID").getValue();
		
		// 获取预案信息
		EpSchemeVO scheme = epSchemeManager.getEpScheme(schemeId);
		AlarmScheme dto = new AlarmScheme();
		dto.setId(scheme.getId());
		dto.setName(scheme.getName());
		dto.setPriority(new Short("9"));
		dto.setNote(scheme.getNote());

		data.setSchemeId(schemeId);
		data.setSourceNaming(naming);
		data.setSourceType(devType);
		data.setUserNaming(userNaming);
		data.setDto(dto);

		return data;
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
	public Document ObjectToXML(Object inObject) {
		SetDeviceAlarmData data = (SetDeviceAlarmData) inObject;
		AlarmScheme dto = data.getDto();

		Element rootElement = new Element("Message");
		Element SchemeAssociateElement = new Element("SchemeAssociateId");
		// 使用预案ID替代以前的device_alarm.ID
		SchemeAssociateElement.setText(dto.getId());
		rootElement.addContent(SchemeAssociateElement);

		Element NamingElement = new Element("Naming");
		NamingElement.setText(data.getSourceNaming());
		rootElement.addContent(NamingElement);

		Element DevTypeElement = new Element("DevType");
		DevTypeElement.setText(data.getSourceType());
		rootElement.addContent(DevTypeElement);

		Element UserNamingElement = new Element("UserNaming");
		UserNamingElement.setText(data.getUserNaming());
		rootElement.addContent(UserNamingElement);

		Element SchemeElement = new Element("Scheme");
		SchemeElement.setAttribute("ID", data.getSchemeId());
		SchemeElement.setAttribute("Name", dto.getName());
		SchemeElement.setAttribute("Priority", dto.getPriority() + "");

		if (dto.getNote() != null) {
			Element NoteElement = new Element("Note");
			NoteElement.setText(dto.getNote());
			SchemeElement.addContent(NoteElement);
		}

		Element ActionListElement = new Element("ActionList");

		SchemeElement.addContent(ActionListElement);
		rootElement.addContent(SchemeElement);
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(0));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}

}
