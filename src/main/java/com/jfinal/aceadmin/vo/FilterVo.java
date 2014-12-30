package com.jfinal.aceadmin.vo;

import java.util.List;

public class FilterVo {

	private String groupOp;
	private List<RuleVo> rules;
	public String getGroupOp() {
		return groupOp;
	}
	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}
	public List<RuleVo> getRules() {
		return rules;
	}
	public void setRules(List<RuleVo> rules) {
		this.rules = rules;
	}
	
	
}
