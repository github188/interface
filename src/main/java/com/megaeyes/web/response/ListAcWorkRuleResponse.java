package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.megaeyes.persistence.ibatis.model.AcWorkRule;

public class ListAcWorkRuleResponse extends BaseResponse{
	public List<AcWorkRule> rules;

	public List<AcWorkRule> getRules() {
		return rules;
	}

	public void setRules(List<AcWorkRule> rules) {
		this.rules = rules;
	}
	
	public static void main(String args[]){
		AcWorkRule vo  = new AcWorkRule();
		ListAcWorkRuleResponse resp = new ListAcWorkRuleResponse();
		List<AcWorkRule> list = new ArrayList<AcWorkRule>();
		list.add(vo);
		resp.setRules(list);
		String jsonRtn = JSONObject.fromObject(resp).toString();
		System.out.println(jsonRtn);
	}
}
