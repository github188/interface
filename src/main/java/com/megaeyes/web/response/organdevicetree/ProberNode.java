/**   
* @Title: ProberNode.java 
* @Package com.megaeyes.web.response.organdevicetree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-14 下午1:37:59 
* @version V1.0   
*/ 
package com.megaeyes.web.response.organdevicetree;

/** 
 * @ClassName: ProberNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-14 下午1:37:59 
 *  
 */
public class ProberNode {
		private String id;
		
		private String name;
		
		private String gantherServerIp;
		
		private String gantherServerId;
		
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

		public String getGantherServerIp() {
			return gantherServerIp;
		}

		public void setGantherServerIp(String gantherServerIp) {
			this.gantherServerIp = gantherServerIp;
		}

		public String getGantherServerId() {
			return gantherServerId;
		}

		public void setGantherServerId(String gantherServerId) {
			this.gantherServerId = gantherServerId;
		}
		
		
}
