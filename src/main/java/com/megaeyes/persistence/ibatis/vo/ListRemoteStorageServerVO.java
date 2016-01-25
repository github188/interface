/**   
 * @Title: ListRemoteStorageServerVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-12 上午10:47:56 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * @ClassName: ListRemoteStorageServerVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-12 上午10:47:56
 * 
 */
public class ListRemoteStorageServerVO {

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

	private Long maxOutputAmount;

	private Long maxInputAmount;

	private Long ftpPort;

	private String ftpUserName;

	private String ftpPassword;

	private String ip2;

	private Long messagePort;

	private String stdId;

	private BigDecimal isVirtualIp;

	private String hasVod;

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

	public Long getMaxOutputAmount() {
		return maxOutputAmount;
	}

	public void setMaxOutputAmount(Long maxOutputAmount) {
		this.maxOutputAmount = maxOutputAmount;
	}

	public Long getMaxInputAmount() {
		return maxInputAmount;
	}

	public void setMaxInputAmount(Long maxInputAmount) {
		this.maxInputAmount = maxInputAmount;
	}

	public Long getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(Long ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUserName() {
		return ftpUserName;
	}

	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public Long getMessagePort() {
		return messagePort;
	}

	public void setMessagePort(Long messagePort) {
		this.messagePort = messagePort;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public BigDecimal getIsVirtualIp() {
		return isVirtualIp;
	}

	public void setIsVirtualIp(BigDecimal isVirtualIp) {
		this.isVirtualIp = isVirtualIp;
	}

	public String getHasVod() {
		return hasVod;
	}

	public void setHasVod(String hasVod) {
		this.hasVod = hasVod;
	}

}
