package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.vo.ListVisByOrganIdVO;

public class ListVisByOrganIdResponse extends BaseResponse{

	public List<VideoInputChannel> list;

	public List<VideoInputChannel> getList() {
		return list;
	}

	public void setList(List<VideoInputChannel> list) {
		this.list = list;
	}
	
	
	
}
