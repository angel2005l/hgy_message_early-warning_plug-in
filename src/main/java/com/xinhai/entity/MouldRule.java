package com.xinhai.entity;

public class MouldRule {
	private int id;
	private String mould_rule_code;
	private String mould_rule_name;
	private int mould_rule_times;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMould_rule_code() {
		return mould_rule_code;
	}

	public void setMould_rule_code(String mould_rule_code) {
		this.mould_rule_code = mould_rule_code;
	}

	public String getMould_rule_name() {
		return mould_rule_name;
	}

	public void setMould_rule_name(String mould_rule_name) {
		this.mould_rule_name = mould_rule_name;
	}

	public int getMould_rule_times() {
		return mould_rule_times;
	}

	public void setMould_rule_times(int mould_rule_times) {
		this.mould_rule_times = mould_rule_times;
	}

	@Override
	public String toString() {
		return "MouldRule [id=" + id + ", mould_rule_code=" + mould_rule_code + ", mould_rule_name=" + mould_rule_name
				+ ", mould_rule_times=" + mould_rule_times + "]";
	}

}
