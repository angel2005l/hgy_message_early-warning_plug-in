package com.xinhai.enums;

public enum MouldLogEnum {

	FINISH("2", "完成"), PROGRESS("1", "进行中");

	private String code;
	private String text;

	private MouldLogEnum(String code, String text) {
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
