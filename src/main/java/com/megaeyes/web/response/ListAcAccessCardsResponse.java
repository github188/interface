package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcAccessCards;

/**
 * ListAcAccessCardResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午05:39:04
 */
public class ListAcAccessCardsResponse extends BaseResponse {

	private List<AcAccessCards> acAccessCards = new ArrayList<AcAccessCards>();

	public List<AcAccessCards> getAcAccessCards() {
		return acAccessCards;
	}

	public void setAcAccessCards(List<AcAccessCards> acAccessCards) {
		this.acAccessCards = acAccessCards;
	}
}
