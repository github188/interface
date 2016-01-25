package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListEmployeesAndCardVO;
import com.megaeyes.service.impl.BaseManagerImpl;

/**
 * ListEmployeesAndCardResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-22 上午07:15:35
 */
public class ListEmployeesAndCardResponse extends BaseResponse {

	private List<ListEmployeesAndCardVO> card = new ArrayList<ListEmployeesAndCardVO>();

	public List<ListEmployeesAndCardVO> getCard() {
		return card;
	}

	public void setCard(List<ListEmployeesAndCardVO> card) {
		this.card = card;
	}
}
