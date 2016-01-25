package com.megaeyes.access.action.impl;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
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
import com.megaeyes.access.common.PicFormat;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: GetVideoParamAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: GetVideoParamAction-5076
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-24 上午06:44:49
 * @version V1.0
 */
public class GetVideoParamAction extends BaseAction implements Action {

	@Autowired
	private VISManager visManager;
	
	@Autowired
	private UserManager userManager;

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = this.phaseXML(req);
		GetVideoParamData cameraDTO = this.XMLToObject(doc);

		String cameraNaming = cameraDTO.getNaming();
		if (StringUtils.isNotBlank(cameraNaming) && !cameraNaming.split(":")[3].equals(ResourceType.CMS_ID)) {
			// 跨平台设备暂不支持查询
			/*Element rootElement = new Element("Message");
			Element successElement = new Element("Success");
			successElement.setText("0");
			rootElement.addContent(successElement);
			Document rtn = new Document(rootElement);
			return rtn;*/
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

		GetVideoParamData dsd = cameraDTO;
		// 获取接入服务器IP
		String accessSeverIP = NamingUtil.getAccessServerIp(naming);
		String accessSeverIP1 = userManager.getAccessServerIp1(accessSeverIP);
		// get parameter 1 dto信息：KeyFrameIntervals FrameRate
		dsd.setType(1);
		GetVideoParamData dto1 = this.queryVisConfigure(dsd, accessSeverIP1);
		if (dto1.getAdditionalElement() != null) {
			cameraDTO.setAdditionalElement(dto1.getAdditionalElement().detach());
			Document rtn = this.ObjectToXML(cameraDTO);
			return rtn;
		}
		// get parameter 2 dto信息：MaxBPS
		dsd.setType(2);
		GetVideoParamData dto2 = this.queryVisConfigure(dsd, accessSeverIP1);
		// get parameter 3 dto信息：PicFormat SupportFormat
		dsd.setType(3);
		GetVideoParamData dto3 = this.queryVisConfigure(dsd, accessSeverIP1);
		// get parameter 4 dto信息：LevelId
		dsd.setType(4);
		GetVideoParamData dto4 = this.queryVisConfigure(dsd, accessSeverIP1);
		// get parameter 5 dto信息：Brightness Contrast Saturation Hue
		dsd.setType(5);
		GetVideoParamData dto5 = this.queryVisConfigure(dsd, accessSeverIP1);

		cameraDTO.setKeyFrameInterval(dto1.getKeyFrameInterval());
		cameraDTO.setFrameRate(dto1.getFrameRate());
		cameraDTO.setMaxBps(dto2.getMaxBps());
		cameraDTO.setImageFormat(dto3.getImageFormat());
		cameraDTO.setSupportFormat(dto3.getSupportFormat());
		cameraDTO.setImageQualityLevelId(dto4.getImageQualityLevelId());
		cameraDTO.setBrightness(dto5.getBrightness());
		cameraDTO.setContrast(dto5.getContrast());
		cameraDTO.setSaturation(dto5.getSaturation());
		cameraDTO.setHue(dto5.getHue());

		Document rtn = this.ObjectToXML(cameraDTO);
		return rtn;
	}

	/**
	 * 
	 * @Description: 查询视频服务器配置参数
	 * @author zhuanqi@megaeyes.com
	 * @param @param ds
	 * @param @return
	 * @return GetVideoParamData
	 * @throws
	 */
	private GetVideoParamData queryVisConfigure(GetVideoParamData ds, String accessSeverIP) {
		GetVideoParamData visDTO = new GetVideoParamData();
		transformerData4Query(ds,visDTO);
		if (ds.getType() == 1) // dto信息：KeyFrameIntervals FrameRate
		{
			DeviceProxy deviceProxyFrame = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_FRAME_RATE_PROXY, accessSeverIP);
			visDTO = (GetVideoParamData) deviceProxyFrame.queryDevice(visDTO);
		} else if (ds.getType() == 2) // dto信息：MaxBPS
		{
			DeviceProxy deviceProxyBps = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_MAX_BPS_PROXY, accessSeverIP);
			visDTO = (GetVideoParamData) deviceProxyBps.queryDevice(visDTO);
		} else if (ds.getType() == 3) // dto信息：PicFormat SupportFormat
		{
			DeviceProxy deviceProxyFormat = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_PIC_FORMAT_PROXY, accessSeverIP);
			GetVideoParamData tmpVisDTO = (GetVideoParamData) deviceProxyFormat.queryDevice(visDTO);
			if (tmpVisDTO == null) {
				DeviceProxy deviceProxyFrame = (DeviceProxy) MegaeyesEJBProxyFactory
						.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_FRAME_RATE_PROXY,accessSeverIP);
				visDTO = (GetVideoParamData) deviceProxyFrame.queryDevice(visDTO);
				visDTO.setPicSupprotFormat(getPicHDFormatList(visDTO.getSupportFormat()));
			} else {
				visDTO = tmpVisDTO;
				visDTO.setPicSupprotFormat(getPicSupportFormatList(tmpVisDTO.getSupportFormat()));
			}
		} else if (ds.getType() == 4)// dto信息：LevelId
		{
			DeviceProxy deviceProxyQuantity = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_PIC_QUANTITY_PROXY,	accessSeverIP);
			visDTO = (GetVideoParamData) deviceProxyQuantity.queryDevice(visDTO);
		} else if (ds.getType() == 5)// dto信息：Brightness Contrast Saturation Hue
		{
			DeviceProxy deviceProxyVideoParam = (DeviceProxy) MegaeyesEJBProxyFactory
					.getMegaeyesEJBProxy(MegaeyesEJBProxyFactory.CAMERA_VIDEO_PARA_PROXY, accessSeverIP);
			visDTO = (GetVideoParamData) deviceProxyVideoParam.queryDevice(visDTO);
		}
		return visDTO;
	}

	private void transformerData4Query(GetVideoParamData src,GetVideoParamData dest){
		dest.setId(src.getId());
		dest.setNaming(src.getNaming());
		dest.setStreamTypeStr(src.getStreamTypeStr());
		dest.setVideoInputServerId(src.getVideoInputServerId());
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
	public GetVideoParamData XMLToObject(Document doc) {
		GetVideoParamData cameraDTO = new GetVideoParamData();
		Element rootElement = doc.getRootElement();
		Element namingElement = rootElement.getChild("Naming");
		if (namingElement != null) {
			cameraDTO.setNaming(namingElement.getTextTrim());
		}

		String streamType = rootElement.getAttributeValue("Stream");
		cameraDTO.setStreamTypeStr(streamType);
		Element CameraElement = rootElement.getChild("Destination");

		// 将 C++ 端的摄象头id转换成 j2ee 端的摄像头id
		String CameraID = null;
		if (CameraElement != null) {
			CameraID = CameraElement.getAttributeValue("ID");
		}
		cameraDTO.setId(CameraID);
		cameraDTO.setRequestElement(rootElement);

		return cameraDTO;
	}

	/**
	 * 
	 * @Description: 返回xml
	 * @author zhuanqi@megaeyes.com
	 * @param @param cameraDTO
	 * @param @return
	 * @return Document
	 * @throws
	 */
	public Document ObjectToXML(GetVideoParamData cameraDTO) {

		/**
		 * <Message> 
		 * <Destination ID = "目标编号" Type ="目标类型"/> 
		 * <FrameStruct FrameRate='25' KeyFrameIntervals='65'/> 
		 * <Quant Level='0' /> 
		 * <BaudRate MaxBPS="300" /> 
		 * <Format PicFormat="" SupportFormat="0123"/>
		 * <VideoPara Brightness = "亮度" Contrast = "对比度" Saturation = "饱和度" Hue="色调" />
		 * </Message>
		 */

		if (cameraDTO.getAdditionalElement() != null) {
			return new Document(cameraDTO.getAdditionalElement());
		}
		Element rootElement = new Element("Message");
		Element FrameStructElement = new Element("FrameStruct");
		FrameStructElement.setAttribute("FrameRate",String.valueOf(cameraDTO.getFrameRate()));
		FrameStructElement.setAttribute("KeyFrameIntervals",String.valueOf(cameraDTO.getKeyFrameInterval()));
		rootElement.addContent(FrameStructElement);

		Element FormatElement = new Element("Format");
		FormatElement.setAttribute("PicFormat",String.valueOf(cameraDTO.getImageFormat()));
		FormatElement.setAttribute("SupportFormat",cameraDTO.getSupportFormat());
		rootElement.addContent(FormatElement);

		Element BaudRateElement = new Element("BaudRate");
		BaudRateElement.setAttribute("MaxBPS",String.valueOf(cameraDTO.getMaxBps()));
		rootElement.addContent(BaudRateElement);

		Element VideoParaElement = new Element("VideoPara");
		VideoParaElement.setAttribute("Brightness",String.valueOf(cameraDTO.getBrightness()));
		VideoParaElement.setAttribute("Contrast",String.valueOf(cameraDTO.getContrast()));
		VideoParaElement.setAttribute("Saturation",String.valueOf(cameraDTO.getSaturation()));
		VideoParaElement.setAttribute("Hue", String.valueOf(cameraDTO.getHue()));
		rootElement.addContent(VideoParaElement);

		Element QuantElement = new Element("Quant");
		QuantElement.setAttribute("Level",String.valueOf(cameraDTO.getImageQualityLevelId()));
		rootElement.addContent(QuantElement);

		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);

		Document doc = new Document(rootElement);
		return doc;
	}

	private String[][] getPicSupportFormatList(String picformat) {
		ArrayList list = new ArrayList();
		for (int i = 0; i < picformat.length(); i++) {
			char[] cc = { picformat.charAt(i) };
			String code = new String(cc);
			String format = PicFormat.getPicFormat(code);
			if (format != null) {
				String[] picf = { code, format };
				list.add(picf);
			}
		}
		String[][] result = new String[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = (String[]) list.get(i);
		}
		return result;
	}

	private String[][] getPicHDFormatList(String picformat) {
		String[] formatArray = picformat.split("\\|");
		String[][] result = new String[formatArray.length][2];
		for (int i = 0; i < formatArray.length; i++) {
			result[i] = new String[] { formatArray[i], formatArray[i] };
		}
		return result;
	}
}
