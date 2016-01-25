package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.vo.ListLogAndEmployeeVO;

/**
 * ListLogAndEmployeeResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-28 上午02:44:18
 */
public class ListLogAndEmployeeResponse extends BaseResponse {
	private List<ListLogAndEmployeeVO> logAndEmployee = new ArrayList<ListLogAndEmployeeVO>();

	public List<ListLogAndEmployeeVO> getLogAndEmployee() {
		return logAndEmployee;
	}

	public void setLogAndEmployee(List<ListLogAndEmployeeVO> logAndEmployee) {
		this.logAndEmployee = logAndEmployee;
	}
}
