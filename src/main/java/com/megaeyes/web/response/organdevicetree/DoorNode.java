package com.megaeyes.web.response.organdevicetree;

/**
 * 门（门禁控制器）对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2013-1-7 下午01:25:22
 */
public class DoorNode {
	private String id;
	private String name;
	private String naming;
	private String installLocation;
	private String accessServerId;
	private String channelId;

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

	public String getAccessServerId() {
		return accessServerId;
	}

	public void setAccessServerId(String accessServerId) {
		this.accessServerId = accessServerId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
