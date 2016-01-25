package com.megaeyes.web.response.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 下级平台上下线接口返回对象
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-8 下午01:33:03
 */
public class LowerPlatformUpdateStatusResponse extends BaseXMLResponse {
	private List<Item> userSubscribeList = new ArrayList<Item>();

	public List<Item> getUserSubscribeList() {
		return userSubscribeList;
	}

	public void setUserSubscribeList(List<Item> userSubscribeList) {
		this.userSubscribeList = userSubscribeList;
	}

	public class Item {
		/**
		 * 用户ID
		 */
		private String userId;
		/**
		 * 订阅平台18位Code
		 */
		private String platformCode;
		/**
		 * 订阅资源18位Code
		 */
		private String code;
		/**
		 * 上次订阅时间
		 */
		private String updateTime;
		/**
		 * 订阅类型"alarm"或"status"
		 */
		private String event;
		/**
		 * 订阅事件具体类型，参见《电网视频监控系统及接口 第1部分：技术要求.pdf》中事件订阅
		 */
		private String type;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPlatformCode() {
			return platformCode;
		}

		public void setPlatformCode(String platformCode) {
			this.platformCode = platformCode;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}

		public String getEvent() {
			return event;
		}

		public void setEvent(String event) {
			this.event = event;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}
}
