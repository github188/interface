package com.megaeyes.persistence.ibatis.vo;

public class Ip_VIC extends IpVICVO{
	
	private String subdivision_name;
	private String Ep_codeid;
	
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

}
