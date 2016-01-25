/**   
* @Title: ListVicByAssetsIdResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-10 上午3:09:08 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.ListVicVO;

/** 
 * @ClassName: ListVicByAssetsIdResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-10 上午3:09:08 
 *  
 */
public class ListVicByAssetsIdResponse extends BaseResponse {
	private List<ListVicVO> vic;
	private String code;
	public List<ListVicVO> getVic() {
		return vic;
	}
	public void setVic(List<ListVicVO> vic) {
		this.vic = vic;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
