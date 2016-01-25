/**   
* @Title: EpAssetsAndDeviceVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-25 上午7:13:55 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/** 
 * @ClassName: EpAssetsAndDeviceVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-25 上午7:13:55 
 *  
 */
public class EpAssetsAndDeviceVO {
	private String id;
	private String name;
	private BigDecimal type;
	private BigDecimal useTime;
	private BigDecimal expirationTime;
	private BigDecimal significantLevel;
	private String deviceNumber;
	private String organId;
	private String note;
	private String parentId;
	private String installLocation;
	public String getInstallLocation() {
		return installLocation;
	}
	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
