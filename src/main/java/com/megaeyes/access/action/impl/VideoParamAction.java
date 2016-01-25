package com.megaeyes.access.action.impl;

import org.apache.commons.lang.StringUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.action.data.GetVideoParamData;
import com.megaeyes.access.action.proxy.DeviceProxy;
import com.megaeyes.access.action.proxy.MegaeyesEJBProxyFactory;
import com.megaeyes.access.common.CommonReturnDoc;
import com.megaeyes.access.common.NamingUtil;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: VideoParamAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: VideoParamAction-5074
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-24 上午06:33:21
 * @version V1.0
 */
public class VideoParamAction extends BaseAction implements Action {

	@Autowired
	private VISManager visManager;

	@Autowired
	private UserManager userManager;

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = this.phaseXML(req);
		GetVideoParamData cameraDTO = this.XMLToObject(doc);
		// 获取设备ID
		String cameraNaming = cameraDTO.getNaming();
		if (cameraNaming != null && cameraDTO.getId() == null) {
			cameraDTO.setId(cameraNaming.split(":")[0]);
		}
		// 跨平台设备暂不支持
		if (StringUtils.isNotBlank(cameraNaming) && !cameraNaming.split(":")[3].equals(ResourceType.CMS_ID)) {
			return CommonReturnDoc.getReturnDoc(0);
		} else {
			cameraDTO.setRequestElement(null);
		}
		// 查询设备信息
		VideoInputChannelVO vic = null;
		if (cameraDTO.getNaming() != null) {
			vic = visManager.getVicById(cameraDTO.getNaming().split(":")[0]);
		} else {
			vic = visManager.getVicById(cameraDTO.getId());
		}
		cameraDTO.setVideoInputServerId(vic.getVideoInputServerId());

		String naming = vic.getNaming();
		if (StringUtils.isBlank(naming)) {
			throw new BusinessException("Access Nameing is null", ErrorCode.DEVICE_NOT_REGISTERED);
		}
		if (naming != null && cameraDTO.getId() == null) {
			cameraDTO.setId(naming.split(":")[0]);
		}

		// 获取接入服务器IP
		String accessSeverIP = NamingUtil.getAccessServerIp(naming);
		String accessSeverIP1 = userManager.getAccessServerIp1(accessSeverIP);
		
		GetVideoParamData dsd = cameraDTO;
		// update parameter 1
		dsd.setType(1);
		this.setVisConfigure(dsd, accessSeverIP1);
		if (cameraDTO.getAdditionalElement() != null) {
			Document rtn = this.ObjectToXML(null);
			return rtn;
		}
		// update parameter 2
		dsd.setType(2);
		this.setVisConfigure(dsd, accessSeverIP1);
		// update parameter 3
		dsd.setType(3);
		this.setVisConfigure(dsd, accessSeverIP1);
		// update parameter 4
		dsd.setType(4);
		this.setVisConfigure(dsd, accessSeverIP1);
		// update parameter 5
		dsd.setType(5);
		this.setVisConfigure(dsd, accessSeverIP1);

		Document rtn = this.ObjectToXML(null);
		return rtn;
	}

	/**
	 * 
	 * @Description: 设置视频服务器配置参数
	 * @author zhuanqi@megaeyes.com
	 * @param @param ds
	 * @param @return
	 * @return GetVideoParamData
	 * @throws
	 */
	private GetVideoParamData setVisConfigure(GetVideoParamData ds,	String accessSeverIP) {
		GetVideoParamData visDTO = ds;
		if (ds.getType() == 1) // dto信息：KeyFrameIntervals FrameRate
		{
			DeviceProxy deviceProxyFrame = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_FRAME_RATE_PROXY,accessSeverIP);
			deviceProxyFrame.configureDevice(visDTO);
		} else if (ds.getType() == 2) // dto信息：MaxBPS
		{
			DeviceProxy deviceProxyBps = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_MAX_BPS_PROXY,accessSeverIP);
			deviceProxyBps.configureDevice(visDTO);
		} else if (ds.getType() == 3) // dto信息：PicFormat SupportFormat
		{
			DeviceProxy deviceProxyFormat = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_PIC_FORMAT_PROXY,accessSeverIP);
			deviceProxyFormat.configureDevice(visDTO);
		} else if (ds.getType() == 4)// dto信息：LevelId
		{
			DeviceProxy deviceProxyQuantity = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_PIC_QUANTITY_PROXY,accessSeverIP);
			deviceProxyQuantity.configureDevice(visDTO);
		} else if (ds.getType() == 5)// dto信息：Brightness Contrast Saturation Hue
		{
			DeviceProxy deviceProxyVideoParam = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_VIDEO_PARA_PROXY,accessSeverIP);
			deviceProxyVideoParam.configureDevice(visDTO);
		}
		return visDTO;
	}

	/**
	 * 
	 * @Description: 解析xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @return GetVideoParamData
	 * @throws
	 */
	private GetVideoParamData XMLToObject(Document doc) {
		/**
		 * <Message> <Para>12347</Para> <Source ID = “（S）” Type = “源类型（N）”/>
		 * <Destination ID = “目标编号（S）” Type = “目标类型（N）”/> <FrameStruct
		 * FrameRate='25' KeyFrameIntervals='65'/> <Quant Level='0' /> <BaudRate
		 * MaxBPS="300" /> <Format PicFormat="" SupportFormat="0123"/>
		 * <VideoPara Brightness = "亮度（0-255）" Contrast = "对比度（0-127）"
		 * Saturation ="饱和度（0-127）" Hue = "色调（0-255）" /> </Message>
		 */
		GetVideoParamData cameraDTO = new GetVideoParamData();
		Element rootElement = doc.getRootElement();

		if (rootElement.getChild("Resolution") != null) {
			Element namingElement = rootElement.getChild("Naming");
			if (namingElement != null) {
				cameraDTO.setNaming(namingElement.getTextTrim());

			}
			Element CameraElement = rootElement.getChild("Destination");
			if (CameraElement != null) {
				cameraDTO.setId(CameraElement.getAttribute("ID").getValue());
			}

			rootElement.detach();
			cameraDTO.setAdditionalElement(rootElement);
			return cameraDTO;
		}

		String streamType = rootElement.getAttributeValue("Stream");
		cameraDTO.setStreamTypeStr(streamType);
		Element namingElement = rootElement.getChild("Naming");
		if (namingElement != null) {
			cameraDTO.setNaming(namingElement.getTextTrim());
		}

		Element ParaElement = rootElement.getChild("Para");
		Element UserSessionIdElement = rootElement.getChild("Source");
		Element CameraElement = rootElement.getChild("Destination");
		Element FrameStructElement = rootElement.getChild("FrameStruct");
		Element BaudRateElement = rootElement.getChild("BaudRate");
		Element FormatElement = rootElement.getChild("Format");
		Element VideoParaElement = rootElement.getChild("VideoPara");
		Element QuantElement = rootElement.getChild("Quant");

		// 将 C++ 端的 User Session ID 转换成 j2ee 端的 User Session ID
		String userSessionId = UserSessionIdElement.getAttribute("ID")
				.getValue();

		// 将 C++ 端的摄象头id转换成 j2ee 端的摄像头id
		String CameraID = CameraElement.getAttribute("ID").getValue();

		// 得到FrameStruct组值
		Attribute FrameRate = FrameStructElement.getAttribute("FrameRate");
		Attribute KeyFrameIntervals = FrameStructElement.getAttribute("KeyFrameIntervals");
		cameraDTO.setFrameRate(new Long(FrameRate.getValue()));
		cameraDTO.setKeyFrameInterval(new Integer(KeyFrameIntervals.getValue())
				.intValue());

		// 得到BaudRate值
		Attribute BaudRateValue = BaudRateElement.getAttribute("MaxBPS");
		cameraDTO.setMaxBps(new Long(BaudRateValue.getValue()));

		// 得到视频格式值
		Attribute PicFormat = FormatElement.getAttribute("PicFormat");
		Attribute SupportFormat = FormatElement.getAttribute("SupportFormat");
		cameraDTO.setImageFormat(new Integer(PicFormat.getValue()).intValue());
		cameraDTO.setSupportFormat(SupportFormat.getValue());

		// 得到VideoPara组值
		Attribute Brightness = VideoParaElement.getAttribute("Brightness");
		Attribute Contrast = VideoParaElement.getAttribute("Contrast");
		Attribute Saturation = VideoParaElement.getAttribute("Saturation");
		Attribute Hue = VideoParaElement.getAttribute("Hue");

		cameraDTO.setBrightness(new Long(Brightness.getValue()));
		cameraDTO.setContrast(new Long(Contrast.getValue()));
		cameraDTO.setSaturation(new Long(Saturation.getValue()));
		cameraDTO.setHue(new Long(Hue.getValue()));

		// 得到Quant组值
		Attribute QuantLevel = QuantElement.getAttribute("Level");
		cameraDTO.setImageQualityLevelId(QuantLevel.getValue());
		cameraDTO.setId(CameraID);
		cameraDTO.setRequestElement(rootElement);
		return cameraDTO;
	}

	/**
	 * 
	 * @Description:返回xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param cameraDTO
	 * @param @return
	 * @return Document
	 * @throws
	 */
	public Document ObjectToXML(GetVideoParamData cameraDTO) {
		/**
		 * <Message> <Para>12347</Para> <Source ID = “（S）” Type = “源类型（N）”/>
		 * <Destination ID = “目标编号（S）” Type = “目标类型（N）”/> <FrameStruct
		 * FrameRate='25' KeyFrameIntervals='65'/> <Quant Level='0' /> <BaudRate
		 * MaxBPS="300" /> <Format PicFormat="" SupportFormat="0123"/>
		 * <VideoPara Brightness = "亮度（0-255）" Contrast = "对比度（0-127）"
		 * Saturation ="饱和度（0-127）" Hue = "色调（0-255）" /> </Message>
		 */
		if (cameraDTO == null) {
			return CommonReturnDoc.getReturnDoc(0);
		}
		if (cameraDTO.getAdditionalElement() != null) {
			return new Document(cameraDTO.getAdditionalElement());
		}
		Element rootElement = new Element("Message");
		String cameraID = cameraDTO.getId();
		Element FrameStructElement = new Element("FrameStruct");
		FrameStructElement.setAttribute("FrameRate",new Long(cameraDTO.getFrameRate()).toString());
		FrameStructElement.setAttribute("KeyFrameIntervals", new Integer(cameraDTO.getKeyFrameInterval()).toString());
		rootElement.addContent(FrameStructElement);

		Element FormatElement = new Element("Format");
		FormatElement.setAttribute("PicFormat",	new Integer(cameraDTO.getImageFormat()).toString());
		FormatElement.setAttribute("SupportFormat",	cameraDTO.getSupportFormat());
		rootElement.addContent(FormatElement);

		Element BaudRateElement = new Element("BaudRate");
		BaudRateElement.setAttribute("MaxBPS", new Long(cameraDTO.getMaxBps()).toString());
		rootElement.addContent(BaudRateElement);

		Element VideoParaElement = new Element("VideoPara");
		VideoParaElement.setAttribute("Brightness",	new Long(cameraDTO.getBrightness()).toString());
		VideoParaElement.setAttribute("Contrast",new Long(cameraDTO.getContrast()).toString());
		VideoParaElement.setAttribute("Saturation",	new Long(cameraDTO.getSaturation()).toString());
		VideoParaElement.setAttribute("Hue",new Long(cameraDTO.getHue()).toString());
		rootElement.addContent(VideoParaElement);

		Element QuantElement = new Element("Quant");
		QuantElement.setAttribute("Level", new Integer(cameraDTO.getImageQualityLevelId()).toString());
		rootElement.addContent(QuantElement);

		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}

}
