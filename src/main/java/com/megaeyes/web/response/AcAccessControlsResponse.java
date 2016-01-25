package com.megaeyes.web.response;

/**
 * AcAccessControlsResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-15 上午09:48:39
 */
public class AcAccessControlsResponse extends BaseResponse {
	private String id;
	private String name;
	private String organId;
	private String naming;
	private String installLocation;
	private String deviceNumber;
	private Integer channelId;
	private String note;
	private Integer deviceType;
	private String accessServerId;
	private Integer status;
	private String remoteOpen;
	
	public String getRemoteOpen() {
		return remoteOpen;
	}
	public void setRemoteOpen(String remoteOpen) {
		this.remoteOpen = remoteOpen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
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
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getAccessServerId() {
		return accessServerId;
	}
	public void setAccessServerId(String accessServerId) {
		this.accessServerId = accessServerId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
