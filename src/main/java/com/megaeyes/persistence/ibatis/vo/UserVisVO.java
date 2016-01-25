/**   
 * @Title: UserVisVO.java 
 * @Package com.megaeyes.persistence.ibatis.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-3-23 上午10:19:35 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.vo;

import com.megaeyes.persistence.ibatis.model.VideoInputServer;

/**
 * @ClassName: UserVisVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-3-23 上午10:19:35
 * 
 */
public class UserVisVO extends VideoInputServer {
	private String videoPermission = "1";// 实时视频权限 默认为有

	private String historyPermission = "1";// 历史视频权限 默认为有

	private String panPermission = "1";// 云台权限 默认为有

	public String getVideoPermission() {
		return videoPermission;
	}

	public void setVideoPermission(String videoPermission) {
		this.videoPermission = videoPermission;
	}

	public String getHistoryPermission() {
		return historyPermission;
	}

	public void setHistoryPermission(String historyPermission) {
		this.historyPermission = historyPermission;
	}

	public String getPanPermission() {
		return panPermission;
	}

	public void setPanPermission(String panPermission) {
		this.panPermission = panPermission;
	}
}
