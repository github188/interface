/**   
* @Title: EpAssetsResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-6 上午2:08:54 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.math.BigDecimal;

/** 
 * @ClassName: EpAssetsResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-6 上午2:08:54 
 *  
 */
public class EpAssetsResponse extends BaseResponse {
	private String id;
	private String name;
	private BigDecimal type;
	private BigDecimal useTime;
	private BigDecimal expirationTime;
	private BigDecimal significantLevel;
	private String deviceNumber;
	private String organId;
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
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public BigDecimal getUseTime() {
		return useTime;
	}
	public void setUseTime(BigDecimal useTime) {
		this.useTime = useTime;
	}
	public BigDecimal getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(BigDecimal expirationTime) {
		this.expirationTime = expirationTime;
	}
	public BigDecimal getSignificantLevel() {
		return significantLevel;
	}
	public void setSignificantLevel(BigDecimal significantLevel) {
		this.significantLevel = significantLevel;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
}
