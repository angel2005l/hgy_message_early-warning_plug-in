package com.xinhai.entity;

public class Mould {

	private int moldId; // 模具id
	private String moldCode; // 模具编号
	private String moldName; // 模具名称
	private String moldProduceCycle;// 模具循环时间
	private int moldHolesNum;// 模具型腔数

	public Mould() {
	}

	public int getMoldId() {
		return moldId;
	}

	public void setMoldId(int moldId) {
		this.moldId = moldId;
	}

	public String getMoldCode() {
		return moldCode;
	}

	public void setMoldCode(String moldCode) {
		this.moldCode = moldCode;
	}

	public String getMoldName() {
		return moldName;
	}

	public void setMoldName(String moldName) {
		this.moldName = moldName;
	}

	public String getMoldProduceCycle() {
		return moldProduceCycle;
	}

	public void setMoldProduceCycle(String moldProduceCycle) {
		this.moldProduceCycle = moldProduceCycle;
	}

	public int getMoldHolesNum() {
		return moldHolesNum;
	}

	public void setMoldHolesNum(int moldHolesNum) {
		this.moldHolesNum = moldHolesNum;
	}

	@Override
	public String toString() {
		return "Mould [moldId=" + moldId + ", moldCode=" + moldCode + ", moldName=" + moldName + ", moldProduceCycle="
				+ moldProduceCycle + ", moldHolesNum=" + moldHolesNum + "]";
	}
}
