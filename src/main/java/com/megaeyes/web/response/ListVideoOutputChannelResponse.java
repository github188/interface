/**   
* @Title: ListVideoOutputChannelResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-26 上午6:46:43 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
/** 
 * @ClassName: ListVideoOutputChannelResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-26 上午6:46:43 
 *  
 */
public class ListVideoOutputChannelResponse extends BaseResponse {
	private List<VideoOutputChannel>  videoOutputChannel;
	
	public List<VideoOutputChannel> getVideoOutputChannel() {
		return videoOutputChannel;
	}
	public void setVideoOutputChannel(List<VideoOutputChannel> videoOutputChannel) {
		this.videoOutputChannel = videoOutputChannel;
	}

}
