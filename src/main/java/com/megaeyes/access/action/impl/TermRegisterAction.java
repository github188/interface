package com.megaeyes.access.action.impl;

import java.math.BigDecimal;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.DeviceLinkType;
import com.megaeyes.access.common.ResourceType;
import com.megaeyes.access.common.StorePlan;
import com.megaeyes.access.common.StreamType;
import com.megaeyes.access.util.StringUtil;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.IntelligentChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.AlarmInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.VISManager;

/**
 * 
 * @Title: TermRegisterAction.java 
 * @Package com.megaeyes.access.action.impl 
 * @Description: DVS/DVR-2002 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-21 下午04:56:11 
 * @version V1.0
 */
public class TermRegisterAction extends BaseAction implements Action {
	
	@Autowired
	private VISManager visManager;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		VideoInputServerVO visRegisterVo = XMLToObject(doc);
		
		// 根据设备编号查询视频服务器信息
		VideoInputServer visRecord = visManager.getVisByDeviceNumber(visRegisterVo.getDeviceNumber());
		if ( null == visRecord || null == visRecord.getId()) {
			throw new BusinessException("deviceNumber",ErrorCode.DEVICE_NUMBER_NOT_FOUND);
		}	
		// 未注册设备，不注册
		if ( visRecord.getIsSuspended() != null && 1 == visRecord.getIsSuspended()){
			throw new BusinessException("Server suspended!",ErrorCode.DEVICE_NOT_REGISTERED);
		}
		// 是否是第一次注册标记
		boolean bFlag = false;
        if(null == visRecord.getIsRegisterd() || "0".equals(visRecord.getIsRegisterd())){
            bFlag = true;
        }
        // 设置视频服务器参数
        transformer(visRegisterVo,visRecord);
        String modelId = visManager.getVideoInputServerModelId(visRegisterVo.getDeviceModel(),
        			"general_camera_video_server",visRegisterVo.getProtocol());
        visRecord.setVideoInputServerModelId(modelId);
		// 更新视频服务器参数配置
        visManager.registerGeneralCameraVis(visRecord, bFlag);
		// 更新视频服务器及二级设备的Naming
        visManager.updateTernimalNaming(visRecord.getId(), req.getAccessId(), ResourceType.CMS_ID,visRegisterVo.getIsSupportScheme(),visRegisterVo.getCompany());
        // 获得视频服务器的参数
        visRecord = visManager.getVisByDeviceNumber(visRegisterVo.getDeviceNumber());
        visRegisterVo.setVisRecord(visRecord);
        // 获得摄像头列表
        List<VideoInputChannelVO> cameraList = visManager.getVicListByVisId(visRecord.getId());
		visRegisterVo.setCameraList(cameraList);
		// 获得报警输入列表
		List<AlarmInputChannelVO> aicList = visManager.listAICByVisId(visRecord.getId());
		visRegisterVo.setAicList(aicList);
		// 获得报警输出列表
		List<AlarmOutputChannel> aocList = visManager.listAOCByVisId(visRecord.getId());
		visRegisterVo.setAocList(aocList);
		// 获得智能分析单元列表
		List<IntelligentChannel> iauList = visManager.getIntelligentChannelListByVisId(visRecord.getId());
		visRegisterVo.setIauList(iauList);
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
		
		visRecord.setMaxAlarminputChannel(BigDecimal.valueOf(visRegister.getMaxAicNumber()));
		visRecord.setMaxAlarmoutputChannel(BigDecimal.valueOf(visRegister.getMaxAocNumber()));
		visRecord.setMaxVideoinputChannel(BigDecimal.valueOf(visRegister.getMaxVicNumber()));
	}
	/**
	 * 
	 * @Description: 解析注册信息 
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return Object 
	 * @throws
	 */
     public VideoInputServerVO XMLToObject(Document doc) {
    	 VideoInputServerVO visRegister = new VideoInputServerVO();
         //	增加能力级兼容的部分
         String sNatSupport = null;
         String sSchemeSupport = null;
         String sPtzLockSupport = null;
         String natSupport = null;
         String schemeSupport = null;
         String ptzLockSupport = null;
         String vod2Support = null;

         // XML文档解析
         Element rootElement = doc.getRootElement();
         Element companyElement = rootElement.getChild("Company");
         Element versionElement = rootElement.getChild("Version");
         Element deviceModelElement = rootElement.getChild("DeviceModel");
         Element protocolElement = rootElement.getChild("Protocol");
         Attribute attrNatIP = rootElement.getAttribute("NatIP");
         Attribute attrDeviceID = rootElement.getAttribute("DeviceID");
         Attribute attrDeviceIP = rootElement.getAttribute("DeviceIP");
         Attribute attrDeviceLinkType = rootElement.getAttribute("DeviceLinkType");
         Attribute attrDeviceMaxConnect = rootElement.getAttribute("DeviceMaxConnect");
         //--获得老的兼容能力部分
         Element schemeElement = rootElement.getChild("SchemeSupport");
         if(schemeElement != null){
        	 sSchemeSupport = schemeElement.getText();
         }
         Element ptzElement = rootElement.getChild("PtzLockRet");
         if(ptzElement != null){
        	 sPtzLockSupport = ptzElement.getText();
         }
         Element natElement = rootElement.getChild("IsSupportNAT");
         if(natElement != null){
        	 sNatSupport = natElement.getText();
         }
         Element isNatElement = rootElement.getChild("IsNAT");
         if(isNatElement!= null && isNatElement.getTextTrim().equalsIgnoreCase("true")){
        	 visRegister.setIsNat(Short.valueOf("1"));
         }else{
        	 visRegister.setIsNat(Short.valueOf("0"));
         }
         
         /**
          * <VideoInNum>视频输入通道数（N）</VideoInNum>
            <VideoOutNum>视频输出通道数（N）</VideoOutNum>
            <AlarmInNum>报警输入通道数（N）</AlarmInNum>
            <AlarmOutNum>报警输出通道数（N）</AlarmOutNum>
          */
         Element VideoInNumElement = rootElement.getChild("VideoInNum");
         Element VideoOutNumElement = rootElement.getChild("VideoOutNum");
         Element AlarmInNumElement = rootElement.getChild("AlarmInNum");
         Element AlarmOutNumElement = rootElement.getChild("AlarmOutNum");
         if(VideoInNumElement != null && !"".equals(VideoInNumElement.getTextTrim())) {
             try {
                 visRegister.setMaxVicNumber(Integer.parseInt(VideoInNumElement.getTextTrim()));
             } catch (Exception e) {
             }
         }
         
         if(VideoOutNumElement != null && !"".equals(VideoOutNumElement.getTextTrim())) {
             try {
                 visRegister.setMaxVocNumber(Integer.parseInt(VideoOutNumElement.getTextTrim()));
             } catch (Exception e) {
             }
         }
         
         if(AlarmInNumElement != null && !"".equals(AlarmInNumElement.getTextTrim())) {
             try {
                 visRegister.setMaxAicNumber(Integer.parseInt(AlarmInNumElement.getTextTrim()));
             } catch (Exception e) {
             }
         }  
         
         if(AlarmOutNumElement != null && !"".equals(AlarmOutNumElement.getTextTrim())) {
             try {
                 visRegister.setMaxAocNumber(Integer.parseInt(AlarmOutNumElement.getTextTrim()));
             } catch (Exception e) {
             }
         }
         
         // 获得新的的能力部分
         /**
          * <Support
				NAT="true/false"<!-- NAT 穿越 (B)-->
				Scheme="true/false"
				PtzLockRet ="true/false"
				Video2= "true/false"
				MainStream="true/false"  <!--缺省码流-->
				SubStream1="true/false" <!--WIFI码流-->
				SubStream2="true/false" <!--EVDO码流-->
				SubStream3="true/false" <!--CDMA1x码流-->
			/>

          */
         String supportCapacity = "11111111111111111111111111111111111111111111111111";
         Element  supportElement = rootElement.getChild("Support");
         if(supportElement != null){
        	 Attribute nat = supportElement.getAttribute("NAT");
        	 Attribute scheme = supportElement.getAttribute("Scheme");
        	 Attribute ptzlock = supportElement.getAttribute("PtzLockRet");
        	 Attribute vod2 = supportElement.getAttribute("Video2");
        	 
        	 Attribute normal = supportElement.getAttribute("MainStream");
        	 Attribute subStream1 = supportElement.getAttribute("SubStream1");
        	 Attribute subStream2 = supportElement.getAttribute("SubStream2");
        	 Attribute subStream3 = supportElement.getAttribute("SubStream3");
        	 if(nat == null || nat.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,0)+"0"+supportCapacity.substring(1,supportCapacity.length());
        	 }
        	 if(scheme == null || scheme.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,1)+"0"+supportCapacity.substring(2,supportCapacity.length());
        	 }
        	 if(ptzlock == null || ptzlock.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,2)+"0"+supportCapacity.substring(3,supportCapacity.length());
        	 }
        	 if(vod2 == null || vod2.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,3)+"0"+supportCapacity.substring(4,supportCapacity.length());
        	 }
        	 if(normal != null && normal.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,4)+"0"+supportCapacity.substring(5,supportCapacity.length());
        	 }
        	 if(subStream1 == null || subStream1.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,5)+"0"+supportCapacity.substring(6,supportCapacity.length());
        	 }
        	 if(subStream2 == null || subStream2.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,6)+"0"+supportCapacity.substring(7,supportCapacity.length());
        	 }
        	 if(subStream3 == null || subStream3.getValue().equalsIgnoreCase("false")){
        		 supportCapacity = supportCapacity.substring(0,7)+"0"+supportCapacity.substring(8,supportCapacity.length());
        	 }
        	 
        	 natSupport = nat.getValue();
        	 schemeSupport = scheme.getValue();
        	 ptzLockSupport = ptzlock.getValue();
        	 vod2Support = vod2.getValue();
         }
         visRegister.setSupportCapacity(supportCapacity);
         
         /**
          * <IsUpdate></IsUpdate>
            <FailuredInfo></FailuredInfo>
          */
         Element isUpdateElement = rootElement.getChild("IsUpdate");
         Element failuredInfoElement = rootElement.getChild("FailuredInfo");
         if(isUpdateElement != null) {
             visRegister.setUpdated(Boolean.parseBoolean(isUpdateElement.getText()));
         }
         if(failuredInfoElement != null) {
             visRegister.setFailUpdateDesc(failuredInfoElement.getText());
         }
         
         // 设置前端值对象 设置普通摄像头视频服务器对象
         visRegister.setDeviceNumber(attrDeviceID.getValue());
         visRegister.setIp(attrDeviceIP.getValue());
    	 visRegister.setNatIp(attrNatIP==null?"":attrNatIP.getValue());
    	 visRegister.setMaxConnectAmount(new Long(attrDeviceMaxConnect.getValue()));
         // 设置连接类型
         int deviceLinkType = Integer.parseInt(attrDeviceLinkType.getValue());
         if(deviceLinkType == 1){
             visRegister.setLinkType(DeviceLinkType.LAN);  
         }else if(deviceLinkType == 2){  
             visRegister.setLinkType(DeviceLinkType.ADSL);  
         }
         
         //设置前端的能力级别
         if(convertStrToBoolean(sSchemeSupport) || convertStrToBoolean(schemeSupport)){
        	 visRegister.setIsSupportScheme(Short.valueOf("1"));
         }else{
        	 visRegister.setIsSupportScheme(Short.valueOf("0"));
         }
         if(convertStrToBoolean(sPtzLockSupport) || convertStrToBoolean(ptzLockSupport)){
        	 visRegister.setIsSupportPtzLock(Short.valueOf("1"));
         }else{
        	 visRegister.setIsSupportPtzLock(Short.valueOf("0"));
         }
         if(convertStrToBoolean(sNatSupport) || convertStrToBoolean(natSupport)){
        	 visRegister.setIsSupportNat(Short.valueOf("1"));
         }else{
        	 visRegister.setIsSupportNat(Short.valueOf("0"));
         }
         if(convertStrToBoolean(vod2Support)){
        	 visRegister.setIsSupportVod2(Short.valueOf("1"));
         }else{
        	 visRegister.setIsSupportVod2(Short.valueOf("0"));
         }
         //设置厂商信息
         if(companyElement != null){
        	 visRegister.setCompany(companyElement.getText() == null? "" : companyElement.getText());
         }
         if(versionElement != null) {
             visRegister.setVersion(versionElement.getText());
         }
         //设置视频服务器类型
         if(deviceModelElement != null) {
             visRegister.setDeviceModel(deviceModelElement.getText());
         }
         if(protocolElement != null) {
             visRegister.setProtocol(protocolElement.getText());
         }
         return visRegister;
     }
     

     /**
      * 接受object转换xml包
      * @param inObject
      * @return
      * @throws ServiceProxyException
      */
     public Document ObjectToXML(VideoInputServerVO visRegisterVo) {
         Element rootElement = new Element("Message");
         VideoInputServer visRecord = visRegisterVo.getVisRecord();
         String terminalId = visRecord.getId();            
         // 加入前端数据
         rootElement.setAttribute("ID", StringUtil.toString(terminalId));        
         rootElement.setAttribute("Naming", StringUtil.toString(visRecord.getNaming()));        
         rootElement.setAttribute("HeartCycle", StringUtil.toString(visRecord.getHeartCycle()));       
         rootElement.setAttribute("SysRebootTime", StringUtil.toString(visRecord.getRebootTime()));        
         rootElement.setAttribute("SysRebootCycle", String.valueOf(visRecord.getRebootCycle()));
         // 摄像头信息及存储预案，返回分发ID
         String dispatchId = cameraXMLFile(visRegisterVo, rootElement);
         // 报警输入
         alarmIn(visRegisterVo, rootElement);
         // 报警输出
         alarmOut(visRegisterVo, rootElement);
         // 智能分析单元
         intelligentChannel(visRegisterVo, rootElement);
         
         //	给视频服务器指定视频分发服务器
         rootElement.setAttribute("DispatchId", StringUtil.toString(dispatchId));
         rootElement.setAttribute("PlatformTel","");
         rootElement.setAttribute("ConfigServer","");
         Element successElement = new Element("Success");
         successElement.setText("0");
         rootElement.addContent(successElement);    
         Document doc = new Document(rootElement);
         return doc;
     }    
     
     
     /**
      * 摄像头信息
      */
     private static String cameraXMLFile(VideoInputServerVO visRegisterVo,Element rootElement ) {
    	 List<?> cameraList = visRegisterVo.getCameraList();  
         String dispatchId = "";
         if (cameraList != null)
         {
             for (int i=0;i<cameraList.size();i++)
             {
                 Element cameraElement = new Element("Camera");
                 VideoInputChannelVO dto = (VideoInputChannelVO) cameraList.get(i);
                 if (dto.getId() != null)
                 {
                     cameraElement.setAttribute("DeviceID", dto.getId());
                 }
                 if (dto.getId() != null)
                 {
                     cameraElement.setAttribute("ID",dto.getId());
                 }
                 if (dto.getNaming() != null)
                 {
                     cameraElement.setAttribute("Naming",dto.getNaming());
                 }
                 cameraElement.setAttribute("HasPan", dto.getHasPan().toString()); 
                 //是否是IPC
                 cameraElement.setAttribute("IsIPCamera", new Boolean(dto.getVicType() == 1 ? true:false).toString()); 
                 //IP摄像头域名
                 cameraElement.setAttribute("DomainName",dto.getHost() == null ? "":dto.getHost());
                 //IP摄像头端口
                 cameraElement.setAttribute("Port", new Integer(dto.getPort() == null ? 80:dto.getPort()).toString());
                 //IP摄像头编号
                 cameraElement.setAttribute("Number",dto.getAddressNumberOnIpvs() == null ? "":dto.getAddressNumberOnIpvs());    
                 //通道号
                 cameraElement.setAttribute("ChannelId", dto.getChannelId() != null ?  dto.getChannelId().toString() : "");
                 //分发服务器ID
                 if(dto.getDispatchServerId()!= null && !dto.getDispatchServerId().equals("") && dispatchId.equals("")){
                 	dispatchId  =  StringUtil.toString(dto.getDispatchServerId());
                 }
                
                 // 生成存储方案数据
                 Element storeSchemeElement = new Element("StoreScheme");
                 
                 /**
                  * 	<StoreScheme
 						IsLocalSaved = “是否本地存储（B+）”
 						LocalDiskFullOption = “StopRecord/Overlay”
 						StorePlanHourFlag=“存储方案（S）” 
 						RemoteIP=“中心存储服务器IP（IP）”
 						RemotePort=“存储服务器的端口（N）”
 						FtpUser=“FTP的用户名”
 						FtpPwd=“ FTP的密码”
 						SchemeCycle="day/week/month"
 						StoreCycle=”天数”
 						StreamType=”码流类型” >
 								<!--Item项数最多不超过32个(1.5K多)-->
 								<Item Day=”DD-DD” Time="HH:MM-HH:MM" />
 								<Item Day=”DD-DD” Time="HH:MM-HH:MM" />
 								……
 					</StoreScheme>

                  * 
                  */
                 if ( dto.getStoreType() == 1 && dto.getPullMode().intValue() == 0 && dto.getRemoteStorageServerId() != null) {
 					storeSchemeElement.setAttribute("IsLocaleSaved", "false");
 					storeSchemeElement.setAttribute("RemoteIP", String.valueOf(dto.getRemoteIp()));
 					storeSchemeElement.setAttribute("RemotePort", String.valueOf(dto.getRemotePort()));
 					storeSchemeElement.setAttribute("FtpUser", String.valueOf(dto.getFtpUser()));
 					storeSchemeElement.setAttribute("FtpPwd", dto.getFtpPwd());
 					storeSchemeElement.setAttribute("StorePlanHourFlag", (dto.getRemoteStorePlanHourFlag()==null || dto.getRemoteStorePlanHourFlag().equals("")) ? "" : dto.getRemoteStorePlanHourFlag().substring(0,dto.getRemoteStorePlanHourFlag().length()>168?168:dto.getRemoteStorePlanHourFlag().length()));
 					storeSchemeElement.setAttribute("SchemeCycle", dto.getSchemeType() != StorePlan.DAY?(dto.getSchemeType()==StorePlan.WEEK?"week":"month"):"day");
 					storeSchemeElement.setAttribute("StoreCycle", String.valueOf(dto.getStoreCycle()));
 					storeSchemeElement.setAttribute("StreamType", StreamType.getStreamType(dto.getStreamType()));
 					StorePlan storePlan = new StorePlan(dto.getRemoteStorePlanHourFlag(),dto.getSchemeType());
 					
 					List<String> planStrList = storePlan.getTimetable();
 					for(String planStr:planStrList){
 						//	00-23@00:00:00-01:59:59
 						String[] itemStrArray = planStr.split("@");
 						if(itemStrArray.length != 2){
 							continue;
 						}
 						Element itemElement = new Element("Item");
 						itemElement.setAttribute("Day",itemStrArray[0]);
 						itemElement.setAttribute("Time",itemStrArray[1]);
 						storeSchemeElement.addContent(itemElement);
 						
 					}
 				} else if ( dto.getStoreType() == 1 ) {
 					// 3.0前端 是远程存储 3.2 时  返回IsLocaleSaved="true"  StorePlanHourFlag 全为0
 				    String storePlanHourFlag = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
 					storeSchemeElement.setAttribute("IsLocaleSaved", "true");
 					storeSchemeElement.setAttribute("LocalDiskFullOption", dto.getOverWriteFlag().intValue() == 1 ? "Overlay":"StopRecord");
 					storeSchemeElement.setAttribute("StorePlanHourFlag", storePlanHourFlag);
 					storeSchemeElement.setAttribute("SchemeCycle", dto.getLocalSchemeType() != StorePlan.DAY?(dto.getLocalSchemeType()==StorePlan.WEEK?"week":"month"):"day");
 					storeSchemeElement.setAttribute("StoreCycle", String.valueOf(dto.getLocalStoreCycle()));
 					storeSchemeElement.setAttribute("StreamType", StreamType.getStreamType(dto.getStreamType()));		
 				} else {
 					storeSchemeElement.setAttribute("IsLocaleSaved", "true");
 					storeSchemeElement.setAttribute("LocalDiskFullOption", dto.getOverWriteFlag().intValue() == 1 ? "Overlay":"StopRecord");
 					storeSchemeElement.setAttribute("StorePlanHourFlag", dto.getStorePlanHourFlag() == null ? "" : dto.getStorePlanHourFlag().substring(0,dto.getStorePlanHourFlag().length()>168?168:dto.getStorePlanHourFlag().length()));
 					storeSchemeElement.setAttribute("SchemeCycle", dto.getLocalSchemeType() != StorePlan.DAY?(dto.getLocalSchemeType()==StorePlan.WEEK?"week":"month"):"day");
 					storeSchemeElement.setAttribute("StoreCycle", String.valueOf(dto.getLocalStoreCycle()));
 					storeSchemeElement.setAttribute("StreamType", StreamType.getStreamType(dto.getStreamType()));
 					StorePlan storePlan = new StorePlan(dto.getStorePlanHourFlag(),dto.getLocalSchemeType());
 					List<String> planStrList = storePlan.getTimetable();
 					for(String planStr:planStrList){
 						//	00-23@00:00:00-01:59:59
 						String[] itemStrArray = planStr.split("@");
 						if(itemStrArray.length != 2){
 							continue;
 						}
 						Element itemElement = new Element("Item");
 						itemElement.setAttribute("Day",itemStrArray[0]);
 						itemElement.setAttribute("Time",itemStrArray[1]);
 						storeSchemeElement.addContent(itemElement);
 						
 					}
 				}
                 cameraElement.addContent(storeSchemeElement);  
                 rootElement.addContent(cameraElement);
             }
         }
         // 因为数据库表设计的问题这个地方返回的是最后一个摄像头设置的分发ID
         return dispatchId;
     }
     
     // 取得视频服务器下所有报警输入设备
     private static void alarmIn(VideoInputServerVO visRegisterVo, Element rootElement) {
    	 List<?> alarmInList = visRegisterVo.getAicList();    
         if(alarmInList == null) {
         	return;
         }
    	 for (int aic =0 ;aic < alarmInList.size();aic++)
         {
    		 AlarmInputChannelVO alarmInDTO = (AlarmInputChannelVO) alarmInList.get(aic);
             Element alarmInElement = new Element("AlarmIn");
             if (alarmInDTO.getId() != null)
             {
                 alarmInElement.setAttribute("DeviceID", alarmInDTO.getAddressNumberOnAlarmBox());
             	 alarmInElement.setAttribute("ID",alarmInDTO.getId());
                 alarmInElement.setAttribute("Naming", alarmInDTO.getNaming());
                 alarmInElement.setAttribute("ChannelId",String.valueOf(alarmInDTO.getChannelId()));
             }
             rootElement.addContent(alarmInElement);          
         }
     }
     
     // 取得视频服务器下所有报警输出设备
     private static void alarmOut(VideoInputServerVO visRegisterVo, Element rootElement) {
    	 List<?> alarmOutList = visRegisterVo.getAocList();
         if(alarmOutList == null) {
         	return;
         }
    	 for (int aoc =0 ;aoc < alarmOutList.size();aoc++)
    	 {           
    		 AlarmOutputChannel alarmOutputChannel = (AlarmOutputChannel)alarmOutList.get(aoc);
    		 Element alarmOutElement = new Element("AlarmOut");
    		 if (alarmOutputChannel.getId() != null)
    		 {
    			 alarmOutElement.setAttribute("DeviceID", alarmOutputChannel.getAddressNumberOnAlarmBox()); 
    			 alarmOutElement.setAttribute("ID",       alarmOutputChannel.getId());
    			 alarmOutElement.setAttribute("Naming",   alarmOutputChannel.getNaming());
    			 alarmOutElement.setAttribute("ChannelId",String.valueOf(alarmOutputChannel.getChannelId()));
    		 }  
    		 rootElement.addContent(alarmOutElement);
    	 }
     }
     
     // 取得视频服务器下所有智能分析单元设备
     private static void intelligentChannel(VideoInputServerVO visRegisterVo, Element rootElement) {
         List<?> iauList = visRegisterVo.getIauList();
         for (int i =0 ;i < iauList.size();i++)
         {           
        	 IntelligentChannel intelligentChannel = (IntelligentChannel) iauList.get(i);
        	 Element analyseElement = new Element("Analyse");
        	 if (intelligentChannel.getId() != null)
        	 {
        		 analyseElement.setAttribute("ID", intelligentChannel.getId());
        		 analyseElement.setAttribute("Naming", intelligentChannel.getNaming());
        		 analyseElement.setAttribute("ChannelId", "");
        	 }  
        	 rootElement.addContent(analyseElement);
         }
     }
     
     /**
 	 * 将字符转换成布尔型
 	 * @param srcStr
 	 * @return
 	 */
 	private boolean convertStrToBoolean(String srcStr){
 		if(srcStr == null){
 			return false;
 		}
 		if(srcStr.equalsIgnoreCase("true")||srcStr.equalsIgnoreCase("1")){
 			return true;
 		}
 		return false;
 	}
}
