package com.xinhai.enums;

public enum TaskEnum {

	ONCE("once", "每日一次"), CONT("cont", "每日循环"), DATA("data", "数据"), WORK("work", "业务"), ENABLED("Y", "启用"), DISABLE("N","未启用");

	private String code;
	private String text;

	private TaskEnum(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
