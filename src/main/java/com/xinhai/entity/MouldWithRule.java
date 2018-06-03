package com.xinhai.entity;

public class MouldWithRule {

	private int id;// 模具编号
	private String mouldCode;// 模具编码
	private String mouldName;// 模具名称
	private int mouldInternalTimes;// 厂内打模次数
	private int mouldExternalTimes;// 外协打模次数
	private int mouldRemainingTimes;// 剩余使用次数
	private String mouldRuleCode;
	private int mould_rule_times;

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

	public int getMould_rule_times() {
		return mould_rule_times;
	}

	public void setMould_rule_times(int mould_rule_times) {
		this.mould_rule_times = mould_rule_times;
	}

	@Override
	public String toString() {
		return "MouldWithRule [id=" + id + ", mouldCode=" + mouldCode + ", mouldName=" + mouldName
				+ ", mouldInternalTimes=" + mouldInternalTimes + ", mouldExternalTimes=" + mouldExternalTimes
				+ ", mouldRemainingTimes=" + mouldRemainingTimes + ", mouldRuleCode=" + mouldRuleCode
				+ ", mould_rule_times=" + mould_rule_times + "]";
	}

}
