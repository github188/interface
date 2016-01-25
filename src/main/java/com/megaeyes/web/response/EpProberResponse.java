/**   
* @Title: EpProberResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-10 上午11:29:35 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

/** 
 * @ClassName: EpProberResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-10 上午11:29:35 
 *  
 */
public class EpProberResponse extends BaseResponse {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getControlServerId() {
		return controlServerId;
	}
	public void setControlServerId(String controlServerId) {
		this.controlServerId = controlServerId;
	}
	public String getEpProberTypeId() {
		return epProberTypeId;
	}
	public void setEpProberTypeId(String epProberTypeId) {
		this.epProberTypeId = epProberTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(Integer maxLimit) {
		this.maxLimit = maxLimit;
	}
	public Integer getMinLimit() {
		return minLimit;
	}
	public void setMinLimit(Integer minLimit) {
		this.minLimit = minLimit;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getRegisterReverse() {
		return registerReverse;
	}
	public void setRegisterReverse(Integer registerReverse) {
		this.registerReverse = registerReverse;
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
	private String id;
	 private String controlServerId;
	 private String epProberTypeId;
	 private String name;
	 private Integer maxLimit;
	 private Integer minLimit;
	 private Integer cycle;
	 private String address;
	 private Integer isWarn;
	 private Integer boolWarn;
	 private String dataType;
	 private String position;
	 private Integer registerReverse;
	 private Integer plcIoSaveCycle;
	 private String plcIoSaveType;
	 private String plcIoType;
	 private String organId;

}
