package com.xinhai.entity;

public class MouldWithRule {

	private int id;// 模具编号
	private String mouldCode;// 模具编码
	private String mouldName;// 模具名称
	private int mouldInternalTimes;// 厂内打模次数
	private int mouldExternalTimes;// 外协打模次数
	private int mouldRemainingTimes;// 剩余使用次数
	private String mouldRuleCode;
	private int mouldRuleTimes;
	private String pushRuleCode;
	private String ruleTimes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMouldCode() {
		return mouldCode;
	}

	public void setMouldCode(String mouldCode) {
		this.mouldCode = mouldCode;
	}

	public String getMouldName() {
		return mouldName;
	}

	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}

	public int getMouldInternalTimes() {
		return mouldInternalTimes;
	}

	public void setMouldInternalTimes(int mouldInternalTimes) {
		this.mouldInternalTimes = mouldInternalTimes;
	}

	public int getMouldExternalTimes() {
		return mouldExternalTimes;
	}

	public void setMouldExternalTimes(int mouldExternalTimes) {
		this.mouldExternalTimes = mouldExternalTimes;
	}

	public int getMouldRemainingTimes() {
		return mouldRemainingTimes;
	}

	public void setMouldRemainingTimes(int mouldRemainingTimes) {
		this.mouldRemainingTimes = mouldRemainingTimes;
	}

	public String getMouldRuleCode() {
		return mouldRuleCode;
	}

	public void setMouldRuleCode(String mouldRuleCode) {
		this.mouldRuleCode = mouldRuleCode;
	}

	public int getMouldRuleTimes() {
		return mouldRuleTimes;
	}

	public void setMouldRuleTimes(int mouldRuleTimes) {
		this.mouldRuleTimes = mouldRuleTimes;
	}

	public String getPushRuleCode() {
		return pushRuleCode;
	}

	public void setPushRuleCode(String pushRuleCode) {
		this.pushRuleCode = pushRuleCode;
	}

	public String getRuleTimes() {
		return ruleTimes;
	}

	public void setRuleTimes(String ruleTimes) {
		this.ruleTimes = ruleTimes;
	}

	@Override
	public String toString() {
		return "MouldWithRule [id=" + id + ", mouldCode=" + mouldCode + ", mouldName=" + mouldName
				+ ", mouldInternalTimes=" + mouldInternalTimes + ", mouldExternalTimes=" + mouldExternalTimes
				+ ", mouldRemainingTimes=" + mouldRemainingTimes + ", mouldRuleCode=" + mouldRuleCode
				+ ", mouldRuleTimes=" + mouldRuleTimes + ", pushRuleCode=" + pushRuleCode + ", ruleTimes=" + ruleTimes
				+ "]";
	}

}
