/**   
* @Title: ListVicResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangjianyang tangjianyang@megaeyes.com   
* @date 2012-3-26 上午10:32:10 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.ListVideoInputChannelVO;


/** 
 * @ClassName: ListVicResponse 
 * @Description: TODO(普通视频服务器摄像头列表) 
 * @author tangjianyang tangjianyang@megaeyes.com 
 * @date 2012-3-26 上午10:32:10 
 *  
 */
public class ListGenVicResponse extends BaseResponse {
	private List<ListVideoInputChannelVO> vics;
	private String message;

	public List<ListVideoInputChannelVO> getVics() {
		return vics;
	}

	public void setVics(List<ListVideoInputChannelVO> vics) {
		this.vics = vics;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
