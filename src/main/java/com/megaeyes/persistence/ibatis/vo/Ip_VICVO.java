package com.megaeyes.persistence.ibatis.vo;

public class Ip_VICVO extends Ip_VIC {

	private boolean isCommunion;
	private String sipCode;
	private String longitude;
	private String latitude;

	public boolean isCommunion() {
		return isCommunion;
	}

	public void setCommunion(boolean isCommunion) {
		this.isCommunion = isCommunion;
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

}
