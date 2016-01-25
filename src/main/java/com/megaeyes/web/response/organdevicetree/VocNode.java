/**   
* @Title: VocNode.java 
* @Package com.megaeyes.web.response.organdevicetree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-6-19 上午11:24:13 
* @version V1.0   
*/ 
package com.megaeyes.web.response.organdevicetree;

/** 
 * @ClassName: VocNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-6-19 上午11:24:13 
 *  
 */
public class VocNode {
	
	private String id;
	
	private String name;
	
	private String organId;
	
	private String naming;
	
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

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getNaming() {
		return naming;
	}

	public void setNaming(String naming) {
		this.naming = naming;
	}
	
	

}
