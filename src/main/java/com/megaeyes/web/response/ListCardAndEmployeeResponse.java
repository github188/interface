package com.megaeyes.web.response;

import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListCardAndEmployeeVO;

/**
 * ListCardAndEmployeeResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-24 上午02:57:16
 */
public class ListCardAndEmployeeResponse extends BaseResponse {
	private List<ListCardAndEmployeeVO> cardAndEmployee;

	public List<ListCardAndEmployeeVO> getCardAndEmployee() {
		return cardAndEmployee;
	}

	public void setCardAndEmployee(List<ListCardAndEmployeeVO> cardAndEmployee) {
		this.cardAndEmployee = cardAndEmployee;
	}
}
