/**   
* @Title: ListUserResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-13 上午9:37:38 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.TUser;

/** 
 * @ClassName: ListUserResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-13 上午9:37:38 
 *  
 */
public class ListUserResponse extends BaseResponse {
	private List<TUser> user;
	private String code;
	public List<TUser> getUser() {
		return user;
	}
	public void setUser(List<TUser> user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
