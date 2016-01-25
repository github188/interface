/**   
* @Title: EpIntelligentChannelResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-12 上午8:55:37 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.math.BigDecimal;

/** 
 * @ClassName: EpIntelligentChannelResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-12 上午8:55:37 
 *  
 */
public class EpIntelligentChannelResponse extends BaseResponse {
	 private String id;
	 private String name;
	 private String naming;
	 private String installLocation;
	 private String parentId;
	 private Short parentType;
	 private String description;
	 private String note;
	 private String company;
	 private Short channelId;
	 private String organId;
	 private BigDecimal optimisticLock;
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Short getParentType() {
		return parentType;
	}
	public void setParentType(Short parentType) {
		this.parentType = parentType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Short getChannelId() {
		return channelId;
	}
	public void setChannelId(Short channelId) {
		this.channelId = channelId;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public BigDecimal getOptimisticLock() {
		return optimisticLock;
	}
	public void setOptimisticLock(BigDecimal optimisticLock) {
		this.optimisticLock = optimisticLock;
	}
}
