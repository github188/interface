/**   
 * @Title: listVisByOrganIdRsponse.java 
 * @Package com.megaeyes.web.response 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-3-31 下午4:13:26 
 * @version V1.0   
 */
package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputServer;
import com.megaeyes.persistence.ibatis.vo.VideoInputServerVO;

/**
 * @ClassName: listVisByOrganIdRsponse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-3-31 下午4:13:26
 * 
 */
public class ListVisByOrganIdRsponse extends BaseResponse {
	private List<VideoInputServerVO> visList;
	private String code;

	public List<VideoInputServerVO> getVisList() {
		return visList;
	}

	public void setVisList(List<VideoInputServerVO> visList) {
		this.visList = visList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
