package com.xinhai.entity;

public class PushRule {

	private int id;// id
	private String ruleCode;// 规则编号
	private String ruleName;// 规则名称
	private int ruleFirstTime;// 第一级推送时间
	private int ruleSecondTime;// 第二级推送时间
	private int ruleThirdTime;// 第三级推送时间
	private int ruleFourthTime;// 第四级推送时间

	public PushRule() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getRuleFirstTime() {
		return ruleFirstTime;
	}

	public void setRuleFirstTime(int ruleFirstTime) {
		this.ruleFirstTime = ruleFirstTime;
	}

	public int getRuleSecondTime() {
		return ruleSecondTime;
	}

	public void setRuleSecondTime(int ruleSecondTime) {
		this.ruleSecondTime = ruleSecondTime;
	}

	public int getRuleThirdTime() {
		return ruleThirdTime;
	}

	public void setRuleThirdTime(int ruleThirdTime) {
		this.ruleThirdTime = ruleThirdTime;
	}

	public int getRuleFourthTime() {
		return ruleFourthTime;
	}

	public void setRuleFourthTime(int ruleFourthTime) {
		this.ruleFourthTime = ruleFourthTime;
	}

	@Override
	public String toString() {
		return "PushRule [id=" + id + ", ruleCode=" + ruleCode + ", ruleName=" + ruleName + ", ruleFirstTime="
				+ ruleFirstTime + ", ruleSecondTime=" + ruleSecondTime + ", ruleThirdTime=" + ruleThirdTime
				+ ", ruleFourthTime=" + ruleFourthTime + "]";
	}

}
