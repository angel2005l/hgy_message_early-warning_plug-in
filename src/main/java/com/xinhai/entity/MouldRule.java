package com.xinhai.entity;

public class MouldRule {
	private int id;
	private String mouldRuleCode;
	private String mouldRuleName;
	private int mouldRuleTimes;

	public MouldRule() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMouldRuleCode() {
		return mouldRuleCode;
	}

	public void setMouldRuleCode(String mouldRuleCode) {
		this.mouldRuleCode = mouldRuleCode;
	}

	public String getMouldRuleName() {
		return mouldRuleName;
	}

	public void setMouldRuleName(String mouldRuleName) {
		this.mouldRuleName = mouldRuleName;
	}

	public int getMouldRuleTimes() {
		return mouldRuleTimes;
	}

	public void setMouldRuleTimes(int mouldRuleTimes) {
		this.mouldRuleTimes = mouldRuleTimes;
	}

	@Override
	public String toString() {
		return "MouldRule [id=" + id + ", mouldRuleCode=" + mouldRuleCode + ", mouldRuleName=" + mouldRuleName
				+ ", mouldRuleTimes=" + mouldRuleTimes + "]";
	}

}
