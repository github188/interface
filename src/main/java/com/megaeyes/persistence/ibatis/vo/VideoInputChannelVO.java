package com.megaeyes.persistence.ibatis.vo;

import org.jdom.Element;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;

public class VideoInputChannelVO extends VideoInputChannel {

	private String subdivision_name;
	private String Ep_codeid;
	private boolean isCommunion;
	private String sipCode;
    // RemoteStorageServer
	private String remoteIp;
	private Integer remotePort;
	private String ftpUser;
	private String ftpPwd;
	private String password;
	// LocalStorageServer
	private String localStorageServerId;

	private String host;
    private Integer port;
    private String ipCameraVisId;    
    private Integer vicType;
    private Integer hasVod;
    
	private boolean type;
	
	private String addressNumberOnIpvs;
	
	private Element additionalElement;
    
    public Element getAdditionalElement() {
		return additionalElement;
	}
	public void setAdditionalElement(Element additionalElement) {
		this.additionalElement = additionalElement;
	}
	public String getAddressNumberOnIpvs() {
        return addressNumberOnIpvs;
    }
    public void setAddressNumberOnIpvs(String addressNumberOnIpvs) {
        this.addressNumberOnIpvs = addressNumberOnIpvs;
    }
    
    public Integer getHasVod() {
		return hasVod;
	}

	public void setHasVod(Integer hasVod) {
		this.hasVod = hasVod;
	}

	public Integer getVicType() {
		return vicType;
	}

	public void setVicType(Integer vicType) {
		this.vicType = vicType;
	}
	
	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public Integer getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(Integer remotePort) {
		this.remotePort = remotePort;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPwd() {
		return ftpPwd;
	}

	public void setFtpPwd(String ftpPwd) {
		this.ftpPwd = ftpPwd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getIpCameraVisId() {
		return ipCameraVisId;
	}

	public void setIpCameraVisId(String ipCameraVisId) {
		this.ipCameraVisId = ipCameraVisId;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public boolean isCommunion() {
		return isCommunion;
	}

	public void setCommunion(boolean isCommunion) {
		this.isCommunion = isCommunion;
	}

	public String getSubdivision_name() {
		return subdivision_name;
	}

	public void setSubdivision_name(String subdivision_name) {
		this.subdivision_name = subdivision_name;
	}

	public String getEp_codeid() {
		return Ep_codeid;
	}

	public void setEp_codeid(String ep_codeid) {
		Ep_codeid = ep_codeid;
	}

	public String getSipCode() {
		return sipCode;
	}

	public void setSipCode(String sipCode) {
		this.sipCode = sipCode;
	}
	
    public String getLocalStorageServerId() {
		return localStorageServerId;
	}
	public void setLocalStorageServerId(String localStorageServerId) {
		this.localStorageServerId = localStorageServerId;
	}
}
