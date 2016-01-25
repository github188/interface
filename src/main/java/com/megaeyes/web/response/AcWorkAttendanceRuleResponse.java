package com.megaeyes.web.response;

import net.sf.json.JSONObject;

import com.megaeyes.persistence.ibatis.model.AcWorkAttendanceRule;

public class AcWorkAttendanceRuleResponse extends BaseResponse{
	private AcWorkAttendanceRule rule;

	public AcWorkAttendanceRule getRule() {
		return rule;
	}

	public void setRule(AcWorkAttendanceRule rule) {
		this.rule = rule;
	}
	
	public static void main(String args[]){
		AcWorkAttendanceRule rule = new AcWorkAttendanceRule();
		AcWorkAttendanceRuleResponse resp  = new AcWorkAttendanceRuleResponse();
		resp.setRule(rule);
		String jsonRtn = JSONObject.fromObject(resp).toString();
		System.out.println(jsonRtn);
	}
}
