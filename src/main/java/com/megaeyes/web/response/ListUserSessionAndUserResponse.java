package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListUserSessionAndUserVO;

/**
 * ListUserSessionAndUserResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-25 上午03:19:41
 */
public class ListUserSessionAndUserResponse extends BaseResponse {
	List<ListUserSessionAndUserVO> user = new ArrayList<ListUserSessionAndUserVO>();

	public List<ListUserSessionAndUserVO> getUser() {
		return user;
	}

	public void setUser(List<ListUserSessionAndUserVO> user) {
		this.user = user;
	}
}
