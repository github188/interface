package com.megaeyes.persistence.ibatis.vo;

/**
 * VideoInputChannelAndSchemeVO(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com 
 * <p />
 * 2013-3-4 上午01:50:21
 */
public class VideoInputChannelAndSchemeVO {
	private String vicId;
	private String vicName;
	private String installLocation;
	private String schemeId;
	private String schemeName;
	public String getVicId() {
		return vicId;
	}
	public void setVicId(String vicId) {
		this.vicId = vicId;
	}
	public String getVicName() {
		return vicName;
	}
	public void setVicName(String vicName) {
		this.vicName = vicName;
	}
	public String getInstallLocation() {
		return installLocation;
	}
	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
}
