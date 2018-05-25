package com.xinhai.entity;

public class MouldDevice {

	private String deviceCode;// 设备编码
	private int moldId;// 模具编号
	private String moldCode;// 模具编码
	private int deviceId;// 设备Id

	public MouldDevice() {
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
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

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "MouldDevice [deviceCode=" + deviceCode + ", moldId=" + moldId + ", moldCode=" + moldCode + ", deviceId="
				+ deviceId + "]";
	}

}
