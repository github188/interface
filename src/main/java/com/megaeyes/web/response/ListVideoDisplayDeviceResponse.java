/**   
 * @Title: ListVideoDisplayDeviceResponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-22 上午9:25:20 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;

/**
 * @ClassName: ListVideoDisplayDeviceResponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-22 上午9:25:20
 * 
 */
public class ListVideoDisplayDeviceResponse extends BaseResponse {
	private List<VideoDisplayDevice> videoDisplayDevice;
	private String code;

	public List<VideoDisplayDevice> getVideoDisplayDevice() {
		return videoDisplayDevice;
	}

	public void setVideoDisplayDevice(
			List<VideoDisplayDevice> videoDisplayDevice) {
		this.videoDisplayDevice = videoDisplayDevice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
