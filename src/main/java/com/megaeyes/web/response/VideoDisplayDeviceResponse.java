/**   
* @Title: VideoDisplayDeviceResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-23 上午1:19:26 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.math.BigDecimal;

/** 
 * @ClassName: VideoDisplayDeviceResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-23 上午1:19:26 
 *  
 */
public class VideoDisplayDeviceResponse extends BaseResponse {
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
	private Long videoIntputAmount;
	private Long videoOutputAmount;
	private String companyId;
	private String oOrganId;
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
	public Long getVideoIntputAmount() {
		return videoIntputAmount;
	}
	public void setVideoIntputAmount(Long videoIntputAmount) {
		this.videoIntputAmount = videoIntputAmount;
	}
	public Long getVideoOutputAmount() {
		return videoOutputAmount;
	}
	public void setVideoOutputAmount(Long videoOutputAmount) {
		this.videoOutputAmount = videoOutputAmount;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getoOrganId() {
		return oOrganId;
	}
	public void setoOrganId(String oOrganId) {
		this.oOrganId = oOrganId;
	}
	
}
