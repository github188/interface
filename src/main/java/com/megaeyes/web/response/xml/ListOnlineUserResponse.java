package com.megaeyes.web.response.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询用户在线列表返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-16 下午03:08:25
 */
public class ListOnlineUserResponse extends BaseXMLResponse {
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private String ClientGatewayIp;
	private String ClientGatewayPort;

	public String getClientGatewayIp() {
		return ClientGatewayIp;
	}



	public void setClientGatewayIp(String clientGatewayIp) {
		ClientGatewayIp = clientGatewayIp;
	}



	public String getClientGatewayPort() {
		return ClientGatewayPort;
	}



	public void setClientGatewayPort(String clientGatewayPort) {
		ClientGatewayPort = clientGatewayPort;
	}

	public class User {
		private String sessionId;
		private String naming;

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
	}
}
