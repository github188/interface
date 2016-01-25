package com.megaeyes.persistence.ibatis.vo;

import java.util.List;

/**
 * ListControlAndUserVO(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-30 上午06:44:33
 */
public class ListControlAndUserVO {
	private String doorId;
	private List users;
	public String getDoorId() {
		return doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public List getUsers() {
		return users;
	}
	public void setUsers(List users) {
		this.users = users;
	} 
}
