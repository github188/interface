/**   
 * @Title: UserSessionParameter.java 
 * @Package com.megaeyes.persistence.ibatis.queryParameter 
 * @Description: 在线用户信息查询条件
 * @author huangbuji huangbuji@megaeyes.com   
 * @date 2012-4-16 下午01:25:07 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.queryParameter;

/**
 * @ClassName: UserSessionParameter
 * @Description: 在线用户信息查询条件
 * @author huangbuji huangbuji@megaeyes.com
 * @date 2012-4-16 下午01:25:07
 * 
 */
public class UserSessionParameter extends BaseParameter {

	private String userName;
	private String organName;
	private String ip;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
