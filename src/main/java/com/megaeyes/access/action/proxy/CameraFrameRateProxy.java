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

public class CameraFrameRateProxy extends DeviceProxy {
	
	public CameraFrameRateProxy(String centerServerIP, int port) {
		super(centerServerIP, port);
	}

	protected void requestConfiguredToPackage(Object inObject) {
		GetVideoParamData cameraDTO = (GetVideoParamData) inObject;
		Document doc = null;
		String cameraId = cameraDTO.getId();
		if (cameraDTO.getAdditionalElement() == null) {

			String terminalId = cameraDTO.getVideoInputServerId();
			// 生成XML文档内容
			Element rootElement = new Element("Message");
			if (cameraDTO.getStreamTypeStr() != null && !cameraDTO.getStreamTypeStr().equals("")) {
				rootElement.setAttribute("Stream", cameraDTO.getStreamTypeStr());
			}

			rootElement.setAttribute("TerminalId", terminalId);
			Element paraElement = new Element("Para");
			paraElement.addContent("1");
			Element recordElement = new Element("Record");
			recordElement.setAttribute("KeyFrameIntervals",	Integer.toString(cameraDTO.getKeyFrameInterval()));
			recordElement.setAttribute("FrameRate", Long.toString(cameraDTO.getFrameRate()));
			rootElement.addContent(paraElement);
			rootElement.addContent(recordElement);
			doc = new Document(rootElement);
		} else {
			cameraDTO.getAdditionalElement().setAttribute("TerminalId",	cameraDTO.getVideoInputServerId());
			doc = new Document(cameraDTO.getAdditionalElement());
		}

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
		paraElement.addContent("1");
		rootElement.addContent(paraElement);
		Document doc = new Document(rootElement);
		// 生成数据包
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

		/**
		 * <Message Stream=”MainStream/SubStream1/SubStream2/SubStream3”>
		 * <Para>１</Para> <Record FrameRate=“帧率（N+）”
		 * KeyFrameIntervals=“I帧间隔（N+）”/> <FrameStruct FrameRate="N+"
		 * KeyFrameIntervals = "N+"/> <Quant Level="N+"/> <BaudRate
		 * MaxBPS="N+"/> <Format PicFormat="N+" SupportFormat = "" />
		 * <Resolution Current=”当前分辨率，如：CIF(352*288)”
		 * Support=”支持的分辨率，用竖线隔开，如QCIF
		 * (176*144)|CIF(352*288)，可选分辨率有：SQCIF(128*96)
		 * 、QCIF(176*144)、CIF(352*288)
		 * 、DCIF(528*384)、2CIF/HD1(704*288)、4CIF/D1(704*576)、FD1
		 * (720*576)、16CIF(
		 * 1408*1152)、D1/480i(720*480)、D2/480P(720*480)、D3/1080i(
		 * 1920*1080)、D4/720p(1280*720)
		 * 、D5/1080p(1920*1080)、QVGA(320*240)、VGA(640
		 * *480)、SVGA(800*600)、XGA(1024*768)、WXGA(1280*800)、XVGA(1280*960)、UXGA
		 * (1600*1200) 、(2048*1536)、(2560*1920)”/> <VideoPara Brightness="N+"
		 * Contrast="N+" Saturation="N+" Hue="N+" /> <Audio>On/Off</Audio> <SDP
		 * Code=”0成功，其错误” Info=”关于Code的描述信息” ><<sdp内容>></SDP> </Message>
		 */
		try {
			Document xmlDoc = xmlBuilder.build(inXMLStream);
			Element rootElement = xmlDoc.getRootElement();
			if (rootElement.getChild("Resolution") != null) {
				cameraDTO.setKeyFrameInterval(new Integer(rootElement.getChild("FrameStruct").getAttributeValue("KeyFrameIntervals")).intValue());
				cameraDTO.setFrameRate(new Long(rootElement.getChild("FrameStruct").getAttributeValue("FrameRate")));

				cameraDTO.setImageFormatStr(rootElement.getChild("Resolution").getAttributeValue("Current"));
				cameraDTO.setSupportFormat(rootElement.getChild("Resolution").getAttributeValue("Support"));

				rootElement.detach();
				cameraDTO.setAdditionalElement(rootElement);
			} else {

				Element recordElement = rootElement.getChild("Record");
				cameraDTO.setKeyFrameInterval(new Integer(recordElement.getAttributeValue("KeyFrameIntervals")).intValue());
				cameraDTO.setFrameRate(new Long(recordElement.getAttributeValue("FrameRate")));
			}
		} catch (IOException ex) {
			ExceptionHandler.throwRuntimeException(ex);
		} catch (JDOMException e) {
			ExceptionHandler.throwRuntimeException(e);
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
