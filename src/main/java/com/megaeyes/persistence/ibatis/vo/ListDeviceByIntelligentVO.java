/**   
* @Title: ListDeviceByIntelligentVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午9:37:11 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

/** 
 * @ClassName: ListDeviceByIntelligentVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午9:37:11 
 *  
 */
public class ListDeviceByIntelligentVO {
	private String id;
	private String plcIoType;
	private String organId;
	private String name;
	private Integer minLimit;
	private Integer maxLimit;
	private Integer cycle;
	private Integer isWarn;
	private Integer boolWarn;
	private String gatherName;
	private String gatherServerId;
	private String gatherServerIp;
	private String position;
	public Integer getMinLimit() {
		return minLimit;
	}
	public void setMinLimit(Integer minLimit) {
		this.minLimit = minLimit;
	}
	public Integer getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(Integer maxLimit) {
		this.maxLimit = maxLimit;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public Integer getIsWarn() {
		return isWarn;
	}
	public void setIsWarn(Integer isWarn) {
		this.isWarn = isWarn;
	}
	public Integer getBoolWarn() {
		return boolWarn;
	}
	public void setBoolWarn(Integer boolWarn) {
		this.boolWarn = boolWarn;
	}
	public String getGatherName() {
		return gatherName;
	}
	public void setGatherName(String gatherName) {
		this.gatherName = gatherName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlcIoType() {
		return plcIoType;
	}
	public void setPlcIoType(String plcIoType) {
		this.plcIoType = plcIoType;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGatherServerId() {
		return gatherServerId;
	}
	public void setGatherServerId(String gatherServerId) {
		this.gatherServerId = gatherServerId;
	}
	public String getGatherServerIp() {
		return gatherServerIp;
	}
	public void setGatherServerIp(String gatherServerIp) {
		this.gatherServerIp = gatherServerIp;
	}
}
