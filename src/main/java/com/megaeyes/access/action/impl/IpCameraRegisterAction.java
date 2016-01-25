package com.megaeyes.access.action.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.AutoGeneratePassword;
import com.megaeyes.access.common.DeviceLinkType;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.access.common.SecureTool;
import com.megaeyes.access.util.StringUtil;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.IpCameraVic;
import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: IpCameraRegisterAction.java
 * @Package com.megaeyes.access.action.impl
 * @Description: IPC-2020
 * @author zhuanqi@megaeyes.com
 * @date 2012-8-23 上午11:07:44
 * @version V1.0
 */
public class IpCameraRegisterAction extends BaseAction implements Action {
	@Autowired
	private VISManager visManager;

	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		VideoInputServerVO visRegisterVo = XMLToObject(doc);
		//查询视频服务器信息
		VideoInputServer visRecord = visManager.getVisByDeviceNumber(visRegisterVo.getDeviceNumber());
		if(null == visRecord || null == visRecord.getId()) {
			throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}	
		// 是否是第一次注册标记
		boolean bFlag = false;
        if(null == visRecord.getIsRegisterd() || "0".equals(visRecord.getIsRegisterd())){
            bFlag = true;
        }
        // 设置VIS信息
        transformer(visRegisterVo,visRecord);
        // 查询视频服务器型号
        String modelId = visManager.getVideoInputServerModelId(visRegisterVo.getDeviceModel(),
        		"ip_camera_video_server",visRegisterVo.getProtocol());
        visRecord.setVideoInputServerModelId(modelId);
        visRegisterVo.setVisRecord(visRecord);
        
        // 设置IpCameraVis信息
        IpCameraVis ipVis = new IpCameraVis();
        transformerIpVis(visRegisterVo,ipVis);
        visRegisterVo.setIpVisRecord(ipVis);
        
        // 视频服务器注册
        visManager.registerIpCameraVis(visRegisterVo, bFlag);
        // 更新naming
        visManager.updateTernimalNaming(visRecord.getId(), req.getAccessId(), 
        		ResourceType.CMS_ID, Short.valueOf("0"),visRegisterVo.getCompany());
       
        IpCameraVic ipVic = new IpCameraVic();
        transformerIpVic(visRegisterVo,ipVic);
        // 更新IpCameraVic信息
        visManager.updateIpCameraVic(ipVic, visRecord.getId());
		// 获得视频服务器存储参数
        ipVis = visManager.getIpCameraVisByVisId(visRecord.getId());
        visRegisterVo.setIpVisRecord(ipVis);
		// 获得摄像头列表
        List<VideoInputChannelVO> ipCameraList = visManager.getIpVicListByVisId(visRecord.getId());
        visRegisterVo.setCameraList(ipCameraList);
		// 获得报警输入列表
		List<AlarmInputChannelVO> aicList = visManager.listAICByVisId(visRecord.getId());
		visRegisterVo.setAicList(aicList);
		// 获得报警输出列表
		List<AlarmOutputChannel> aocList = visManager.listAOCByVisId(visRecord.getId());
		visRegisterVo.setAocList(aocList);
		 // 返回
		Document rtn = ObjectToXML(visRegisterVo);
		return rtn;
	}

	private void transformer(VideoInputServerVO visRegister,VideoInputServer visRecord){
		visRecord.setIsNat(visRegister.getIsNat());
		visRecord.setSupportCapacity(visRegister.getSupportCapacity());
		// 设置前端值对象 设置普通摄像头视频服务器对象
		visRecord.setDeviceNumber(visRegister.getDeviceNumber());
		visRecord.setIp(visRegister.getIp());
		visRecord.setNatIp(visRegister.getNatIp());
		visRecord.setMaxConnectAmount(visRegister.getMaxConnectAmount());
		visRecord.setLinkType(visRegister.getLinkType());
		visRecord.setIsSupportScheme(visRegister.getIsSupportScheme());
		visRecord.setIsSupportPtzLock(visRegister.getIsSupportPtzLock());
		visRecord.setIsSupportNat(visRegister.getIsSupportNat());
		visRecord.setIsSupportVod2(visRegister.getIsSupportVod2());
	}
	
	private void transformerIpVis(VideoInputServerVO visRegister,IpCameraVis ipVis){
		ipVis.setVideoInputServerId(visRegister.getVisRecord().getId());
		ipVis.setTotalCapacity(visRegister.getTotalCapacity());
		ipVis.setUsedCapacity(visRegister.getUsedCapacity());
		ipVis.setRemainCapacity(visRegister.getRemainCapacity());
		ipVis.setLowCapacityFlag(visRegister.getRemainCapacity() < 50 ? Short.valueOf("1"):Short.valueOf("0"));
	}
	
	private void transformerIpVic(VideoInputServerVO visRegister,IpCameraVic ipVic){
		ipVic.setDeviceType(visRegister.getDeviceType());
		ipVic.setSdSupport(visRegister.getSupportSDFlag());
		ipVic.setPassword(SecureTool.encrypt(AutoGeneratePassword.getInstance().generatePassword(8)));
	}
	
	/**
	 * 
	 * @Description:解析注册信息
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return
	 * @return VideoInputServerVO
	 * @throws
	 */
	public VideoInputServerVO XMLToObject(Document doc) {
		VideoInputServerVO ipCameraRegister = new VideoInputServerVO();
		Element rootElement = doc.getRootElement();
		Element deviceModelElement = rootElement.getChild("DeviceModel");
        Element protocolElement = rootElement.getChild("Protocol");
		Attribute attrDeviceID = rootElement.getAttribute("DeviceID");
		Attribute attrDeviceIP = rootElement.getAttribute("DeviceIP");
		Attribute attrNatIP = rootElement.getAttribute("NatIP");
		Attribute attrDeviceLinkType = rootElement.getAttribute("DeviceLinkType");
		Attribute attrDeviceMaxConnect = rootElement.getAttribute("DeviceMaxConnect");
		ipCameraRegister.setDeviceNumber(attrDeviceID.getValue());
		ipCameraRegister.setIp(attrDeviceIP.getValue());
		ipCameraRegister.setNatIp(attrNatIP == null ? "" : attrNatIP.getValue());
		ipCameraRegister.setMaxConnectAmount(new Long(attrDeviceMaxConnect.getValue()));

		int deviceLinkType = Integer.parseInt(attrDeviceLinkType.getValue());
		if (deviceLinkType == 1) {
			ipCameraRegister.setLinkType(DeviceLinkType.LAN);
		} else if (deviceLinkType == 2) {
			ipCameraRegister.setLinkType(DeviceLinkType.ADSL);
		}

		ipCameraRegister.setTotalCapacity(new Long(rootElement.getChild("TotalCapacity").getTextTrim()));
		ipCameraRegister.setUsedCapacity(new Long(rootElement.getChild("UsedCapacity").getTextTrim()));
		ipCameraRegister.setRemainCapacity(new Long(rootElement.getChild("RemainCapacity").getTextTrim()));
		if (rootElement.getChild("WebPort") != null) {
			ipCameraRegister.setWebPort(new BigDecimal(rootElement.getChild("WebPort").getTextTrim()));
		} else {
			ipCameraRegister.setWebPort(new BigDecimal(80));
		}
		/**
		 * <DeviceType>设备型号（S）</DeviceType> <SDSupport>是否支持SD卡（B）</ SDSupport>
		 */
		Element deviceTypeElement = rootElement.getChild("DeviceType");
		Element sdSupportElement = rootElement.getChild("SDSupport");
		if (deviceTypeElement == null || sdSupportElement == null) {
			ipCameraRegister.setDeviceType("EYE-IPC-200S");
			ipCameraRegister.setSupportSDFlag(new Short("1"));
		} else {
			ipCameraRegister.setDeviceType(deviceTypeElement.getTextTrim());
			ipCameraRegister.setSupportSDFlag(new Short(sdSupportElement.getTextTrim()));
		}
		
		//设置视频服务器类型
        if(deviceModelElement != null) {
            ipCameraRegister.setDeviceModel(deviceModelElement.getText());
        }
        if(protocolElement != null) {
            ipCameraRegister.setProtocol(protocolElement.getText());
        }
		return ipCameraRegister;
	}

	/**
	 * 接受object转换xml包
	 * 
	 * @param inObject
	 * @return
	 * @throws ServiceProxyException
	 */
	public Document ObjectToXML(VideoInputServerVO visRegisterVo) {
		Element rootElement = new Element("Message");
		VideoInputServer visRecord = visRegisterVo.getVisRecord();
		String terminalId = visRecord.getId();
		setIpVisInfo(visRegisterVo);
		// 加入前端数据
		rootElement.setAttribute("ID", StringUtil.toString(terminalId));
		rootElement.setAttribute("Naming", StringUtil.toString(visRecord.getNaming()));
		rootElement.setAttribute("HeartCycle", StringUtil.toString(visRecord.getHeartCycle() == null ? 120:visRecord.getHeartCycle()));
		rootElement.setAttribute("SysRebootTime", StringUtil.toString(visRecord.getRebootTime()));
		rootElement.setAttribute("SysRebootCycle", String.valueOf(visRecord.getRebootCycle()));
		rootElement.setAttribute("CurrentDateTime", dateToStr(new Date()));
		rootElement.setAttribute("Password", String.valueOf(visRecord.getPassword() == null ? "":visRecord.getPassword()));
		// 摄像头信息及存储预案，返回分发ID
		cameraStoreModule(visRegisterVo, rootElement);
		String dispatchId = cameraStoreFlagXMLFile(visRegisterVo, rootElement);
		// 报警输入
		alarmIn(visRegisterVo, rootElement);
		// 报警输出
		alarmOut(visRegisterVo, rootElement);

		// 给视频服务器指定视频分发服务器ID
		rootElement.setAttribute("DispatchId", StringUtil.toString(dispatchId));
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);
		return doc;
	}

	private void setIpVisInfo(VideoInputServerVO visRegisterVo){
		List<?> cameraList = visRegisterVo.getCameraList();
		if (cameraList != null && cameraList.size() >0 ){
			VideoInputChannelVO dto = (VideoInputChannelVO) cameraList.get(0);
			visRegisterVo.getVisRecord().setNaming(dto.getNaming());
			visRegisterVo.getVisRecord().setPassword(dto.getPassword());
			visRegisterVo.setFtpUser(dto.getFtpUser());
			visRegisterVo.setFtpPort(dto.getRemotePort());
			visRegisterVo.setFtpPassword(dto.getFtpPwd());
		}
	}
	
	/**
	 * 摄像头本地SD卡存储信息
	 * 
	 * @param ipCameraDTO
	 * @param rootElement
	 */
	private void cameraStoreModule(VideoInputServerVO visRegisterVo, Element rootElement) {
		/**
		 * <StoreModule ID="业务ID（N+）" FtpUser="S" FtpPwd="S" FtpPort="N+" />
		 */
		Element storeModuleElement = new Element("StoreModule");
		storeModuleElement.setAttribute("ID", visRegisterVo.getVisRecord().getId() + "_T");
		storeModuleElement.setAttribute("FtpUser", visRegisterVo.getFtpUser() == null ? "" : visRegisterVo.getFtpUser());
		storeModuleElement.setAttribute("FtpPwd", visRegisterVo.getFtpPassword() == null ? "" : visRegisterVo.getFtpPassword());
		storeModuleElement.setAttribute("FtpPort", String.valueOf(visRegisterVo.getFtpPort()));
		rootElement.addContent(storeModuleElement);
	}

	/**
	 * 摄像头信息
	 */
	private static String cameraStoreFlagXMLFile(VideoInputServerVO visRegisterVo, Element rootElement) {
		List<?> cameraList = visRegisterVo.getCameraList();
		String dispatchId = "";
		if (cameraList != null) {
			for (int i = 0; i < cameraList.size(); i++) {
				VideoInputChannelVO dto = (VideoInputChannelVO) cameraList.get(i);
				dispatchId = StringUtil.toString(dto.getDispatchServerId());
				Element storeSchemeElement = new Element("StoreScheme");
				storeSchemeElement.setAttribute("StoreSize", visRegisterVo.getIpVisRecord().getStoreSize() == null ? "0":visRegisterVo.getIpVisRecord().getStoreSize());
				storeSchemeElement.setAttribute("StoreCycle", String.valueOf(visRegisterVo.getIpVisRecord().getStoreCycle()));
				Element localeStoreElement = new Element("LocaleStore");

				if ((dto.getStoreType() == 0 || dto.getStoreType() == 2) && dto.getStorePlanHourFlag() != null) {
					localeStoreElement.setAttribute("StorePlanHourFlag",
									dto.getStorePlanHourFlag().substring(0,dto.getStorePlanHourFlag().length() > 168 ? 168 : dto.getStorePlanHourFlag().length()));
				}

				Element alarm1Element = new Element("Alarm1");
				alarm1Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getLocalAlarm1Flag() == 1 ? true:false));
				Element alarm2Element = new Element("Alarm2");
				alarm2Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getLocalAlarm2Flag() == 1 ? true:false));
				Element alarm3Element = new Element("Alarm3");
				alarm3Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getLocalAlarm3Flag() == 1 ? true:false));
				Element timingElement = new Element("Timing");
				timingElement.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getLocalTimingFlag() == 1 ? true:false));
				timingElement.setAttribute("Interval", String.valueOf(visRegisterVo.getIpVisRecord().getLocalTimingInterval()));
				Element shootingElement = new Element("Shooting");
				shootingElement.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getLocalShootingFlag() == 1 ? true:false));
				localeStoreElement.addContent(alarm1Element);
				localeStoreElement.addContent(alarm2Element);
				localeStoreElement.addContent(alarm3Element);
				localeStoreElement.addContent(timingElement);
				localeStoreElement.addContent(shootingElement);

				storeSchemeElement.addContent(localeStoreElement);

				if ((dto.getStoreType() == 1 || dto.getStoreType() == 2) && dto.getRemoteStorageServerId() != null) {
					Element remoteStoreElement = new Element("RemoteStore");
					remoteStoreElement.setAttribute("RemoteIP",	String.valueOf(dto.getRemoteIp()));
					remoteStoreElement.setAttribute("RemotePort", String.valueOf(dto.getRemotePort()));
					remoteStoreElement.setAttribute("FtpUser", String.valueOf(dto.getFtpUser()));
					remoteStoreElement.setAttribute("FtpPwd", dto.getFtpPwd());
					remoteStoreElement.setAttribute("StorePlanHourFlag",dto.getPullMode().intValue() == 0 ? (dto.getRemoteStorePlanHourFlag() == null ? "": dto.getRemoteStorePlanHourFlag().substring(0, dto.getRemoteStorePlanHourFlag().length() > 168 ? 168: dto.getRemoteStorePlanHourFlag().length())): "");
					
					Element remoteAlarm1Element = new Element("Alarm1");
					remoteAlarm1Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getRemoteAlarm1Flag() == 1));
					Element remoteAlarm2Element = new Element("Alarm2"); 
					remoteAlarm2Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getRemoteAlarm2Flag() == 1));
					Element remoteAlarm3Element = new Element("Alarm3");
					remoteAlarm3Element.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getRemoteAlarm3Flag() == 1));
					Element remoteTimingElement = new Element("Timing");
					remoteTimingElement.setAttribute("IsSaved",	String.valueOf(visRegisterVo.getIpVisRecord().getRemoteTimingFlag() == 1));
					remoteTimingElement.setAttribute("Interval", String.valueOf(visRegisterVo.getIpVisRecord().getRemoteTimingInterval()));
					Element remoteShootingElement = new Element("Shooting");
					remoteShootingElement.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getRemoteShootingFlag() == 1));
					Element sDCacheElement = new Element("SDCache");
					sDCacheElement.setAttribute("IsCached", String.valueOf(visRegisterVo.getIpVisRecord().getSdCacheFlag() == 1));
					Element sDRedSaveElement = new Element("SDRedSave");
					sDRedSaveElement.setAttribute("IsSaved", String.valueOf(visRegisterVo.getIpVisRecord().getSdRedSaveFlag() == 1));
					sDRedSaveElement.setAttribute("IsDeleted", String.valueOf(visRegisterVo.getIpVisRecord().getIsDeleted() == 1));

					remoteStoreElement.addContent(remoteAlarm1Element);
					remoteStoreElement.addContent(remoteAlarm2Element);
					remoteStoreElement.addContent(remoteAlarm3Element);
					remoteStoreElement.addContent(remoteTimingElement);
					remoteStoreElement.addContent(remoteShootingElement);
					remoteStoreElement.addContent(sDCacheElement);
					remoteStoreElement.addContent(sDRedSaveElement);
					storeSchemeElement.addContent(remoteStoreElement);

				}

				/**
				 * <StoreCycle OverWrite="满了是否自动覆盖（B+）"/> 
				 * <StoreBackup IsBackup="是否自动备份（B+）" IsClean="备份后是否清空SD卡中照片（B+）">
				 * <BackupPath>备份路径（S）</Backup> 
				 * <BackupTime>备份时间（S）</BackupTime>
				 * </StoreBackup>
				 */
				Element storeCycleElement = new Element("StoreCycle");
				storeCycleElement.setAttribute("OverWrite",	String.valueOf(visRegisterVo.getIpVisRecord().getOverwriteFlag() == 1));
				Element storeBackupElement = new Element("StoreBackup");
				storeBackupElement.setAttribute("IsBackup",	String.valueOf(visRegisterVo.getIpVisRecord().getBackupFlag() == 1));
				storeBackupElement.setAttribute("IsClean",	String.valueOf(visRegisterVo.getIpVisRecord().getCleanFlag() == 1));
				Element backupPathElement = new Element("BackupPath");
				backupPathElement.addContent(visRegisterVo.getIpVisRecord().getBackupPath());
				Element backupTimeElement = new Element("BackupTime");
				backupTimeElement.addContent(visRegisterVo.getIpVisRecord().getBackupTime());
				storeBackupElement.addContent(backupPathElement);
				storeBackupElement.addContent(backupTimeElement);

				rootElement.addContent(storeSchemeElement);
				rootElement.addContent(storeCycleElement);
				rootElement.addContent(storeBackupElement);
			}
		}
		// 因为数据库表设计的问题这个地方返回的是最后一个摄像头设置的分发ID
		return dispatchId;
	}

	// 取得视频服务器下所有报警输入设备
	private static void alarmIn(VideoInputServerVO visRegisterVo, Element rootElement) {
		List<?> aicList = visRegisterVo.getAicList();
		for (int aic = 0; aic < aicList.size(); aic++) {
			AlarmInputChannelVO alarmInDTO = (AlarmInputChannelVO) aicList.get(aic);
			Element alarmInElement = new Element("AlarmIn");
			if (alarmInDTO.getId() != null) {
				alarmInElement.setAttribute("DeviceID",	alarmInDTO.getAddressNumberOnAlarmBox());
				alarmInElement.setAttribute("ID", alarmInDTO.getId());
				alarmInElement.setAttribute("Naming", alarmInDTO.getNaming());
			}
			rootElement.addContent(alarmInElement);
		}
	}

	// 取得视频服务器下所有报警输出设备
	private static void alarmOut(VideoInputServerVO visRegisterVo, Element rootElement) {
		List<?> aocList = visRegisterVo.getAocList();
		for (int aoc = 0; aoc < aocList.size(); aoc++) {
			AlarmOutputChannel alarmOutputChannel = (AlarmOutputChannel) aocList.get(aoc);
			Element alarmOutElement = new Element("AlarmOut");
			if (alarmOutputChannel.getId() != null) {
				alarmOutElement.setAttribute("DeviceID", alarmOutputChannel.getAddressNumberOnAlarmBox());
				alarmOutElement.setAttribute("ID", alarmOutputChannel.getId());
				alarmOutElement.setAttribute("Naming", alarmOutputChannel.getNaming());
			}
			rootElement.addContent(alarmOutElement);
		}
	}

	private String dateToStr(Date date) {
		String timeStr = "";
		SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmyyyy.ss");
		timeStr = formatter.format(date);
		return timeStr;
	}

}
