package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListControlAndVicVO;

/**
 * ListControlAndVicResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-23 上午08:00:24
 */
public class ListControlAndVicResponse extends BaseResponse {
	private List<ListControlAndVicVO> vicAndDoor = new ArrayList<ListControlAndVicVO>();

	public List<ListControlAndVicVO> getVicAndDoor() {
		return vicAndDoor;
	}

	public void setVicAndDoor(List<ListControlAndVicVO> vicAndDoor) {
		this.vicAndDoor = vicAndDoor;
	}


}
