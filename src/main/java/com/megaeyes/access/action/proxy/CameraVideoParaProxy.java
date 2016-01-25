package com.megaeyes.access.action.proxy;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.megaeyes.access.action.data.GetVideoParamData;
import com.megaeyes.access.common.MessageType;
import com.megaeyes.access.exception.ExceptionHandler;

public class CameraVideoParaProxy extends DeviceProxy {
	public CameraVideoParaProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	protected void requestConfiguredToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		String cameraId = cameraDTO.getId();
		String terminalId = cameraDTO.getVideoInputServerId();

		Element rootElement = new Element("Message");
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("7");
		Element recordElement = new Element("Record");
		recordElement.setAttribute("Brightness", Long.toString(cameraDTO.getBrightness()));
		recordElement.setAttribute("Contrast", Long.toString(cameraDTO.getContrast()));
		recordElement.setAttribute("Saturation", Long.toString(cameraDTO.getSaturation()));
		recordElement.setAttribute("Hue", Long.toString(cameraDTO.getHue()));
		rootElement.addContent(paraElement);
		rootElement.addContent(recordElement);
		Document doc = new Document(rootElement);

		try {
			this.generateRequestDataPackage(MessageType.DEVICE_CONFIGURE, cameraId.getBytes(), doc);
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		}
	}

	protected void requestQueriedToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		String cameraId = cameraDTO.getId();
		String terminalId = cameraDTO.getVideoInputServerId();
		if (cameraDTO.getNaming() != null && !cameraDTO.getNaming().equals("")) {
			terminalId = cameraDTO.getNaming().split(":")[1];
		}

		Element rootElement = new Element("Message");
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("7");
		rootElement.addContent(paraElement);
		Document doc = new Document(rootElement);

		try {
			this.generateRequestDataPackage(MessageType.DEVICE_QUERY, cameraId.getBytes(), doc);
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		}
	}

	protected Object responseQueriedToObject() {
		GetVideoParamData cameraDTO = new GetVideoParamData();
		ByteArrayInputStream inXMLStream = new ByteArrayInputStream(_responsePack.getBody());
		SAXBuilder xmlBuilder = new SAXBuilder();
		try {
			Document xmlDoc = xmlBuilder.build(inXMLStream);
			Element rootElement = xmlDoc.getRootElement();
			Element recordElement = rootElement.getChild("Record");
			cameraDTO.setBrightness(new Long(recordElement.getAttributeValue("Brightness")));
			cameraDTO.setSaturation(new Long(recordElement.getAttributeValue("Saturation")));
			cameraDTO.setContrast(new Long(recordElement.getAttributeValue("Contrast")));
			cameraDTO.setHue(new Long(recordElement.getAttributeValue("Hue")));
		} catch (JDOMException e) {
			ExceptionHandler.throwRuntimeException(e);
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		}

		return cameraDTO;

	}

	@Override
	protected void requestCaptionToPackage(Object requestObj) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Object responseCaptionToObject(Object outObject) {
		// TODO Auto-generated method stub
		return null;
	}

}