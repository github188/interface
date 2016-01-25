/**   
* @Title: ListVicByProberIdResponse.java 
* @Package com.megaeyes.web.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午5:38:14 
* @version V1.0   
*/ 
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListVicIdVO;

/** 
 * @ClassName: ListVicByProberIdResponse 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午5:38:14 
 *  
 */
public class ListVicByProberIdResponse extends BaseResponse {

	private List<ListVicIdVO> vic;

	public List<ListVicIdVO> getVic() {
		return vic;
	}

	public void setVic(List<ListVicIdVO> vic) {
		this.vic = vic;
	}
}
