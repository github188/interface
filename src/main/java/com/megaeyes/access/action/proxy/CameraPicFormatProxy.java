package com.megaeyes.access.action.proxy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.megaeyes.access.action.data.GetVideoParamData;
import com.megaeyes.access.common.MessageType;
import com.megaeyes.access.exception.ExceptionHandler;


public class CameraPicFormatProxy extends DeviceProxy {
	public CameraPicFormatProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	protected void requestConfiguredToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		String cameraId = cameraDTO.getId();
		String terminalId = cameraDTO.getVideoInputServerId();
		Element rootElement = new Element("Message");

		if (cameraDTO.getStreamTypeStr() != null && !cameraDTO.getStreamTypeStr().equals("")) {
			rootElement.setAttribute("Stream", cameraDTO.getStreamTypeStr());
		}
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("4");
		Element recordElement = new Element("Record");
		recordElement.setAttribute("PicFormat", Integer.toString(cameraDTO.getImageFormat()));
		recordElement.setAttribute("SupportFormat", cameraDTO.getSupportFormat() == null ? "" : cameraDTO.getSupportFormat());
		rootElement.addContent(paraElement);
		rootElement.addContent(recordElement);
		Document doc = new Document(rootElement);
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

		Element rootElement = new Element("Message");
		if (cameraDTO.getStreamTypeStr() != null && !cameraDTO.getStreamTypeStr().equals("")) {
			rootElement.setAttribute("Stream", cameraDTO.getStreamTypeStr());
		}
		rootElement.setAttribute("TerminalId", terminalId);
		Element paraElement = new Element("Para");
		paraElement.addContent("4");
		rootElement.addContent(paraElement);
		Document doc = new Document(rootElement);
		try {
			this.generateRequestDataPackage(MessageType.DEVICE_QUERY, cameraId.getBytes(), doc);
		} catch (IOException ioe) {
			ExceptionHandler.throwRuntimeException(ioe);
		}
	}

	protected Object responseQueriedToObject() {
		GetVideoParamData cameraDTO = new GetVideoParamData();
		ByteArrayInputStream inXMLStream = new ByteArrayInputStream(_responsePack.getBody());
		SAXBuilder xmlBuilder = new SAXBuilder();

		try {
			Document xmlDoc = xmlBuilder.build(inXMLStream);
			Element rootElement = xmlDoc.getRootElement();
			Element resolutionElement = rootElement.getChild("Resolution");
			if (resolutionElement != null) {
				String current = resolutionElement.getAttributeValue("Current");
				String support = resolutionElement.getAttributeValue("Support");
				cameraDTO.setImageFormatStr(current);
				cameraDTO.setSupportFormatStr(support);
			}
			else {
				Element recordElement = rootElement.getChild("Record");
				cameraDTO.setImageFormat(new Integer(recordElement.getAttributeValue("PicFormat")).intValue());
				cameraDTO.setSupportFormat(recordElement.getAttributeValue("SupportFormat"));
			}
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

	public static void main(String[] args) {
		SAXBuilder xmlBuilder = new SAXBuilder();

		try {
			StringReader reader = new StringReader("<Message><Resolution /></Message>") ;
			Document xmlDoc = xmlBuilder.build(reader);

			Element rootElement = xmlDoc.getRootElement();

			Element resolutionElement = rootElement.getChild("Resolution");
			System.out.println(resolutionElement);
			if (resolutionElement != null) {
				String current = resolutionElement.getAttributeValue("Current");
				String support = resolutionElement.getAttributeValue("Support");
				System.out.println(current);
				System.out.println(support);
			}
			
			Element recordElement = rootElement.getChild("Record");
			System.out.println(recordElement);
		} catch (JDOMException e) {
			ExceptionHandler.throwRuntimeException(e);
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		}

	}
	
}