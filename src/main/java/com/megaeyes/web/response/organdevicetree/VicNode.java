/**   
* @Title: VicNode.java 
* @Package com.megaeyes.web.response.organdevicetree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-3-23 上午11:07:51 
* @version V1.0   
*/ 
package com.megaeyes.web.response.organdevicetree;

/** 
 * @ClassName: VicNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-3-23 上午11:07:51 
 *  
 */
public class VicNode {
	private String name;
	private String id;
	private String naming;
	private String isSupportScheme;
	private String installLocation;
	
	
	
	
	public String getInstallLocation() {
		return installLocation;
	}
	public void setInstallLocation(String installLocation) {
		this.installLocation = installLocation;
	}
	public String getIsSupportScheme() {
		return isSupportScheme;
	}
	public void setIsSupportScheme(String isSupportScheme) {
		this.isSupportScheme = isSupportScheme;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaming() {
		return naming;
	}
	public void setNaming(String naming) {
		this.naming = naming;
	}
	
	
}
