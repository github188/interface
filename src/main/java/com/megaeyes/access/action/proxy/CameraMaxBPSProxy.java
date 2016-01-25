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

public class CameraMaxBPSProxy extends DeviceProxy {
	public CameraMaxBPSProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	protected void requestConfiguredToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		String cameraId = cameraDTO.getId();
		String terminalId = cameraDTO.getVideoInputServerId();
		// 生成XML文档内容
		Element rootElement = new Element("Message");

		if (cameraDTO.getStreamTypeStr() != null && !cameraDTO.getStreamTypeStr().equals("")) {
			rootElement.setAttribute("Stream", cameraDTO.getStreamTypeStr());
		}
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("3");
		Element recordElement = new Element("Record");
		recordElement.setAttribute("MaxBPS", Long.toString(cameraDTO.getMaxBps()));
		rootElement.addContent(paraElement);
		rootElement.addContent(recordElement);
		Document doc = new Document(rootElement);

		// 生成数据包
		try {
			this.generateRequestDataPackage(MessageType.DEVICE_CONFIGURE, cameraId.getBytes(), doc);
		} catch (IOException ioe) {
			ExceptionHandler.throwRuntimeException(ioe);
		}
	}

	protected void requestQueriedToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		String cameraId = cameraDTO.getId();
		String terminalId = cameraDTO.getVideoInputServerId();
		if (cameraDTO.getNaming() != null && !cameraDTO.getNaming().equals("")) {
			terminalId = cameraDTO.getNaming().split(":")[1];
		}
		// 生成XML文档内容
		Element rootElement = new Element("Message");
		if (cameraDTO.getStreamTypeStr() != null && !cameraDTO.getStreamTypeStr().equals("")) {
			rootElement.setAttribute("Stream", cameraDTO.getStreamTypeStr());
		}
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("3");
		rootElement.addContent(paraElement);
		Document doc = new Document(rootElement);
		// 生成数据包
		try {
			this.generateRequestDataPackage(MessageType.DEVICE_QUERY, cameraId.getBytes(), doc);
		} catch (IOException ioe) {
			ExceptionHandler.throwRuntimeException(ioe);
		}
	}

	/**
	 * 
	 ** @return
	 */
	protected Object responseQueriedToObject() {
		GetVideoParamData cameraDTO = new GetVideoParamData();

		ByteArrayInputStream inXMLStream = new ByteArrayInputStream(_responsePack.getBody());
		SAXBuilder xmlBuilder = new SAXBuilder();
		try {
			Document xmlDoc = xmlBuilder.build(inXMLStream);
			Element rootElement = xmlDoc.getRootElement();
			Element recordElement = rootElement.getChild("Record");
			cameraDTO.setMaxBps(new Long(recordElement.getAttributeValue("MaxBPS")));
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
