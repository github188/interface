/**   
* @Title: EpProberVO.java 
* @Package com.megaeyes.persistence.ibatis.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-14 下午1:58:34 
* @version V1.0   
*/ 
package com.megaeyes.persistence.ibatis.vo;

/** 
 * @ClassName: EpProberVO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-14 下午1:58:34 
 *  
 */
public class EpProberVO {
	private String id;
	
	private String name;
	
	private String gatherServerId;
	
	private String gatherServerIp;
	
	private String organId;
	
	private String type;
	
	private String typeId;
	
	private String deviceId;
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
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
