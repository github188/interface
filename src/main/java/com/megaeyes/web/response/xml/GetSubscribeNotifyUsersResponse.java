package com.megaeyes.web.response.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取订阅外平台设备报警的需要通知的用户返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 下午04:26:46
 */
public class GetSubscribeNotifyUsersResponse extends BaseXMLResponse {
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public class User {
		private String sessionId;
		private String naming;
		private String code;

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}

		public String getNaming() {
			return naming;
		}

		public void setNaming(String naming) {
			this.naming = naming;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}
}
