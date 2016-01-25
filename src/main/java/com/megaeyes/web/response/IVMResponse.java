package com.megaeyes.web.response;

public class IVMResponse extends BaseResponse {
	private String ivmAccount;
	private String ivmAccountPwd;
	private String cmsIp;
	private String cmsPort;
	private String imageUrl;
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIvmAccount() {
		return ivmAccount;
	}

	public void setIvmAccount(String ivmAccount) {
		this.ivmAccount = ivmAccount;
	}

	public String getIvmAccountPwd() {
		return ivmAccountPwd;
	}

	public void setIvmAccountPwd(String ivmAccountPwd) {
		this.ivmAccountPwd = ivmAccountPwd;
	}

	public String getCmsIp() {
		return cmsIp;
	}

	public void setCmsIp(String cmsIp) {
		this.cmsIp = cmsIp;
	}

	public String getCmsPort() {
		return cmsPort;
	}

	public void setCmsPort(String cmsPort) {
		this.cmsPort = cmsPort;
	}
}
