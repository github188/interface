package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;

public class AlarmInputChannelVO extends AlarmInputChannel {
	private String subdivision_name;
	private String Ep_codeid;

	private String sipCode;
	private String longitude;
	private String latitude;

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
