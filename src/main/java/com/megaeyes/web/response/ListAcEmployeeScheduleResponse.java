package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.megaeyes.persistence.ibatis.model.AcEmployeeSchedule;

public class ListAcEmployeeScheduleResponse extends BaseResponse{

	private List<AcEmployeeSchedule> schedules;

	public List<AcEmployeeSchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<AcEmployeeSchedule> schedules) {
		this.schedules = schedules;
	}
	
	public static void main(String args[]){
		AcEmployeeSchedule vo  = new AcEmployeeSchedule();
		ListAcEmployeeScheduleResponse resp = new ListAcEmployeeScheduleResponse();
		List<AcEmployeeSchedule> list = new ArrayList<AcEmployeeSchedule>();
		list.add(vo);
		resp.setSchedules(list);
		String jsonRtn = JSONObject.fromObject(resp).toString();
		System.out.println(jsonRtn);
	}
}
