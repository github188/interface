/**   
* @Title: ListEpMonitorDeviceAndEpProberVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-8 上午9:02:03 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/** 
 * @ClassName: ListEpMonitorDeviceAndEpProberVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-8 上午9:02:03 
 *  
 */
public class ListEpMonitorDeviceAndEpProberVO {
	private String serverId;
	private String id;
	private String controlServerId;
	private String name;
	private Long cycle;
	private String url;
	private Integer isWarn;
	private Integer plcIoSaveCycle;
	private String plcIoSaveType;
	
	public String getControlServerId() {
		return controlServerId;
	}
	public void setControlServerId(String controlServerId) {
		this.controlServerId = controlServerId;
	}
	public Integer getIsWarn() {
		return isWarn;
	}
	public void setIsWarn(Integer isWarn) {
		this.isWarn = isWarn;
	}
	public Integer getPlcIoSaveCycle() {
		return plcIoSaveCycle;
	}
	public void setPlcIoSaveCycle(Integer plcIoSaveCycle) {
		this.plcIoSaveCycle = plcIoSaveCycle;
	}
	public String getPlcIoSaveType() {
		return plcIoSaveType;
	}
	public void setPlcIoSaveType(String plcIoSaveType) {
		this.plcIoSaveType = plcIoSaveType;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
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
	
	
	public Long getCycle() {
		return cycle;
	}
	public void setCycle(Long cycle) {
		this.cycle = cycle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
