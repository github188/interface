/**   
* @Title: VideoOutputChannelResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-26 上午9:23:49 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.math.BigDecimal;

/** 
 * @ClassName: VideoOutputChannelResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-26 上午9:23:49 
 *  
 */
public class VideoOutputChannelResponse extends BaseResponse {
	private String id;
	private BigDecimal optimisticLock;
	private String name;
	private String naming;
	private String installLocation;
	private String note;
	private String videoDisplayDeviceId;
	private String addressNumber;
	private String videoOutputChannelModelId;
	private String organId;
	private String devicePhysicalRelationId;
	private String stdId;
	private Integer isShare;
	private String dispatchServerId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getOptimisticLock() {
		return optimisticLock;
	}
	public void setOptimisticLock(BigDecimal optimisticLock) {
		this.optimisticLock = optimisticLock;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getVideoDisplayDeviceId() {
		return videoDisplayDeviceId;
	}
	public void setVideoDisplayDeviceId(String videoDisplayDeviceId) {
		this.videoDisplayDeviceId = videoDisplayDeviceId;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getVideoOutputChannelModelId() {
		return videoOutputChannelModelId;
	}
	public void setVideoOutputChannelModelId(String videoOutputChannelModelId) {
		this.videoOutputChannelModelId = videoOutputChannelModelId;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public String getDevicePhysicalRelationId() {
		return devicePhysicalRelationId;
	}
	public void setDevicePhysicalRelationId(String devicePhysicalRelationId) {
		this.devicePhysicalRelationId = devicePhysicalRelationId;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public Integer getIsShare() {
		return isShare;
	}
	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}
	public String getDispatchServerId() {
		return dispatchServerId;
	}
	public void setDispatchServerId(String dispatchServerId) {
		this.dispatchServerId = dispatchServerId;
	}
	
}
