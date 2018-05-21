package com.xinhai.enums;

public enum EquipmentRunStatus {
	TJ(1, "停机"), XZ(2, "闲置"), ZCYX(3, "正常运行");
	private int code;
	private String name;

	private EquipmentRunStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (EquipmentRunStatus enums : EquipmentRunStatus.values()) {
			if (code == enums.getCode()) {
				return enums.getName();
			}
		}
		return "";
	}

}
