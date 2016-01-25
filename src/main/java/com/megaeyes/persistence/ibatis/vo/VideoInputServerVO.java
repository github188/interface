/**   
 * @Title: VideoInputServerVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-21 下午2:07:01 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.VideoInputServer;

/**
 * @ClassName: VideoInputServerVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-21 下午2:07:01
 * 
 */
public class VideoInputServerVO {
	private String id;

	private BigDecimal optimisticLock;

	private String name;

	private String naming;

	private String installLocation;

	private String note;

	private String deviceNumber;

	private String ip;

	private String linkType;

	private Long heartCycle;

	private String rebootTime;

	private Long rebootCycle;

	private Long maxConnectAmount;

	private Long videoIntputAmount;

	private String videoInputServerModelId;

	private String companyId;

	private String stdId;

	private Short isSupportScheme;

	private String organId;

	private BigDecimal maxVideoinputChannel;

	private BigDecimal maxAlarmoutputChannel;

	private BigDecimal maxAlarminputChannel;

	private Short isSuspended;

	private Short isSupportNat;

	private Short isSupportVod2;

	private Short isSupportPtzLock;

	private BigDecimal createtime;

	private BigDecimal startOnlineTime;

	private BigDecimal isRegisterd;

	private BigDecimal webPort;

	private String natIp;

	private Short isNat;

	private String supportCapacity;

	private String visType;

	private String password;

	private Integer sipPort;
	
	private String sipCode;
	
	private String longitude;
	
	private String latitude;
	
	private String company;
	
	private VideoInputServer visRecord;
	//
	private IpCameraVis ipVisRecord;

	//服务器下的摄像头列表
    private List<?> cameraList;
    //服务器下的报警输入列表
    private List<?> aicList;
    //服务器下的报警输出列表
    private List<?> aocList;
    //服务器下的智能分析单元列表
    private List<?> iauList;
    
    //SD卡总容量
    private Long totalCapacity;	
	//SD卡已使用容量
	private Long usedCapacity;	
	//SD卡剩余容量
    private Long remainCapacity;	
    //是否是IpCamera类型
    private String deviceType;
    
	private Short supportSDFlag;
	
	private int ftpPort;
	private String ftpUser;
	private String ftpPassword;
	
	//设备类型
    private String deviceModel, protocol;
    
    private String version;
    
    private int maxVicNumber, maxVocNumber, maxAicNumber, maxAocNumber;
    
    private String failUpdateDesc;
    
    private boolean updated;

    public String getFailUpdateDesc() {
		return failUpdateDesc;
	}

	public void setFailUpdateDesc(String failUpdateDesc) {
		this.failUpdateDesc = failUpdateDesc;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public int getMaxVicNumber() {
		return maxVicNumber;
	}

	public void setMaxVicNumber(int maxVicNumber) {
		this.maxVicNumber = maxVicNumber;
	}

	public int getMaxVocNumber() {
		return maxVocNumber;
	}

	public void setMaxVocNumber(int maxVocNumber) {
		this.maxVocNumber = maxVocNumber;
	}

	public int getMaxAicNumber() {
		return maxAicNumber;
	}

	public void setMaxAicNumber(int maxAicNumber) {
		this.maxAicNumber = maxAicNumber;
	}

	public int getMaxAocNumber() {
		return maxAocNumber;
	}

	public void setMaxAocNumber(int maxAocNumber) {
		this.maxAocNumber = maxAocNumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
	
    
    public Short getSupportSDFlag() {
		return supportSDFlag;
	}

	public void setSupportSDFlag(Short supportSDFlag) {
		this.supportSDFlag = supportSDFlag;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Long getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public Long getUsedCapacity() {
		return usedCapacity;
	}

	public void setUsedCapacity(Long usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	public Long getRemainCapacity() {
		return remainCapacity;
	}

	public void setRemainCapacity(Long remainCapacity) {
		this.remainCapacity = remainCapacity;
	}
	
	public List<?> getIauList() {
		return iauList;
	}

	public void setIauList(List<?> iauList) {
		this.iauList = iauList;
	}

	public List<?> getAicList() {
		return aicList;
	}

	public void setAicList(List<?> aicList) {
		this.aicList = aicList;
	}

	public List<?> getAocList() {
		return aocList;
	}

	public void setAocList(List<?> aocList) {
		this.aocList = aocList;
	}

	public VideoInputServer getVisRecord() {
		return visRecord;
	}

	public void setVisRecord(VideoInputServer visRecord) {
		this.visRecord = visRecord;
	}
	
	public List<?> getCameraList() {
		return cameraList;
	}

	public void setCameraList(List<?> cameraList) {
		this.cameraList = cameraList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getOptimisticLock() {
		return optimisticLock;
	}

	public void setOptimisticLock(BigDecimal optimisticLock) {
		this.optimisticLock = optimisticLock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}

	public String getInstallLocation() {
		return installLocation;
	}

	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public Long getHeartCycle() {
		return heartCycle;
	}

	public void setHeartCycle(Long heartCycle) {
		this.heartCycle = heartCycle;
	}

	public String getRebootTime() {
		return rebootTime;
	}

	public void setRebootTime(String rebootTime) {
		this.rebootTime = rebootTime;
	}

	public Long getRebootCycle() {
		return rebootCycle;
	}

	public void setRebootCycle(Long rebootCycle) {
		this.rebootCycle = rebootCycle;
	}

	public Long getMaxConnectAmount() {
		return maxConnectAmount;
	}

	public void setMaxConnectAmount(Long maxConnectAmount) {
		this.maxConnectAmount = maxConnectAmount;
	}

	public Long getVideoIntputAmount() {
		return videoIntputAmount;
	}

	public void setVideoIntputAmount(Long videoIntputAmount) {
		this.videoIntputAmount = videoIntputAmount;
	}

	public String getVideoInputServerModelId() {
		return videoInputServerModelId;
	}

	public void setVideoInputServerModelId(String videoInputServerModelId) {
		this.videoInputServerModelId = videoInputServerModelId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public Short getIsSupportScheme() {
		return isSupportScheme;
	}

	public void setIsSupportScheme(Short isSupportScheme) {
		this.isSupportScheme = isSupportScheme;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public BigDecimal getMaxVideoinputChannel() {
		return maxVideoinputChannel;
	}

	public void setMaxVideoinputChannel(BigDecimal maxVideoinputChannel) {
		this.maxVideoinputChannel = maxVideoinputChannel;
	}

	public BigDecimal getMaxAlarmoutputChannel() {
		return maxAlarmoutputChannel;
	}

	public void setMaxAlarmoutputChannel(BigDecimal maxAlarmoutputChannel) {
		this.maxAlarmoutputChannel = maxAlarmoutputChannel;
	}

	public BigDecimal getMaxAlarminputChannel() {
		return maxAlarminputChannel;
	}

	public void setMaxAlarminputChannel(BigDecimal maxAlarminputChannel) {
		this.maxAlarminputChannel = maxAlarminputChannel;
	}

	public Short getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Short isSuspended) {
		this.isSuspended = isSuspended;
	}

	public Short getIsSupportNat() {
		return isSupportNat;
	}

	public void setIsSupportNat(Short isSupportNat) {
		this.isSupportNat = isSupportNat;
	}

	public Short getIsSupportVod2() {
		return isSupportVod2;
	}

	public void setIsSupportVod2(Short isSupportVod2) {
		this.isSupportVod2 = isSupportVod2;
	}

	public Short getIsSupportPtzLock() {
		return isSupportPtzLock;
	}

	public void setIsSupportPtzLock(Short isSupportPtzLock) {
		this.isSupportPtzLock = isSupportPtzLock;
	}

	public BigDecimal getCreatetime() {
		return createtime;
	}

	public void setCreatetime(BigDecimal createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getStartOnlineTime() {
		return startOnlineTime;
	}

	public void setStartOnlineTime(BigDecimal startOnlineTime) {
		this.startOnlineTime = startOnlineTime;
	}

	public BigDecimal getIsRegisterd() {
		return isRegisterd;
	}

	public void setIsRegisterd(BigDecimal isRegisterd) {
		this.isRegisterd = isRegisterd;
	}

	public BigDecimal getWebPort() {
		return webPort;
	}

	public void setWebPort(BigDecimal webPort) {
		this.webPort = webPort;
	}

	public String getNatIp() {
		return natIp;
	}

	public void setNatIp(String natIp) {
		this.natIp = natIp;
	}

	public Short getIsNat() {
		return isNat;
	}

	public void setIsNat(Short isNat) {
		this.isNat = isNat;
	}

	public String getSupportCapacity() {
		return supportCapacity;
	}

	public void setSupportCapacity(String supportCapacity) {
		this.supportCapacity = supportCapacity;
	}

	public String getVisType() {
		return visType;
	}

	public void setVisType(String visType) {
		this.visType = visType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSipPort() {
		return sipPort;
	}

	public void setSipPort(Integer sipPort) {
		this.sipPort = sipPort;
	}

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public IpCameraVis getIpVisRecord() {
		return ipVisRecord;
	}

	public void setIpVisRecord(IpCameraVis ipVisRecord) {
		this.ipVisRecord = ipVisRecord;
	}
	
	public int getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}
}
