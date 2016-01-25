/**   
* @Title: EpIntelligentDetectionAndDeviceVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-2 上午7:12:47 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/** 
 * @ClassName: EpIntelligentDetectionAndDeviceVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-2 上午7:12:47 
 *  
 */
public class EpIntelligentDetectionAndDeviceVO {
	  private String id;
	  private String name;
	  private String organId;
	  private String parentId;
	  private BigDecimal type;
	  private String note;
	  private String operation;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
