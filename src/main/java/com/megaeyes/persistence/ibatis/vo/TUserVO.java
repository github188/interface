/**   
 * @Title: TUserVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-29 上午9:54:25 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.TUser;

/**
 * @ClassName: TUserVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-29 上午9:54:25
 * 
 */
public class TUserVO extends TUser {

	private String sipCode;
	private String longitude;
	private String latitude;

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
