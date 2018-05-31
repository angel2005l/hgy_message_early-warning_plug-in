package com.xinhai.enums;

public enum CommonEnum {

	DELETE("0", "删除"), NORMAL("1", "正常"), LOCK("2", "其他");

	private String code;
	private String text;

	private CommonEnum(String code, String text) {
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
