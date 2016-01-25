package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.TUserVO;

public class ListUserVOResponse extends BaseResponse {
	private List<TUserVO> user;
	private String code;

	public List<TUserVO> getUser() {
		return user;
	}

	public void setUser(List<TUserVO> user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
