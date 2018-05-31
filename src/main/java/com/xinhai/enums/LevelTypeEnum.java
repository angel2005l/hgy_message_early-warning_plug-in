package com.xinhai.enums;

public enum LevelTypeEnum {
	FIRST("1", "第一通知级"), SECOND("2", "第二通知级"), THIRD("3", "第三通知级"), FOURTH("4", "第四通知级");

	private String code;
	private String text;

	private LevelTypeEnum(String code, String text) {
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
