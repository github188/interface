package com.megaeyes.web.response.xml;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.web.response.xml.GetDoorNotifyUsersResponse.User;

public class ListCenterDeviceInfoResponse extends BaseXMLResponse {
	private List<AccessServerXml> accessServer = new ArrayList<AccessServerXml>();
	private List<AcGatewayXml> acGateway = new ArrayList<AcGatewayXml>();

	public List<AccessServerXml> getAccessServer() {
		return accessServer;
	}

	public void setAccessServer(List<AccessServerXml> accessServer) {
		this.accessServer = accessServer;
	}

	public List<AcGatewayXml> getAcGateway() {
		return acGateway;
	}

	public void setAcGateway(List<AcGatewayXml> acGateway) {
		this.acGateway = acGateway;
	}

	public class AccessServerXml {
		private String id;
		private String port;
		private String ip;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}
	}

	public class AcGatewayXml {
		private String id;
		private String port;
		private String ip;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}
	}
}
