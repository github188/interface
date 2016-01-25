package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;

/**
 * 历史报警列表查询返回
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-5-4 下午05:16:27
 */
public class ListAlarmEventResponse extends BaseResponse {

	private List<EpAlarmEvent> alarms = new ArrayList<EpAlarmEvent>();

	private String totalCount;

	public List<EpAlarmEvent> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<EpAlarmEvent> alarms) {
		this.alarms = alarms;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}
