package com.xinhai.enums;

public enum EventStatusEnum {
	ENABLED("1", "启用"), DISABLE("2", "未启用");

	private String code;
	private String text;

	private EventStatusEnum(String code, String text) {
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
