package com.xinhai.entity;

import java.sql.Timestamp;

public class WarningWithRule {
	private String title;// 预警标题
	private String message;// 预警信息
	private String deviceId;// 设备id
	private String guid;// 事件标识码(唯一识别码）依据此值
	private String status;// 状态（预警信息）
	private Timestamp createTime;// 创建时间
	private String reliever;// 处理人签名
	private Timestamp relieveTime;// 处理时间
	private String readStatus; // 上报等级
	private int ruleFirstTime;// 第一级推送时间
	private int ruleSecondTime;// 第二级推送时间
	private int ruleThirdTime;// 第三级推送时间
	private int ruleFourthTime;// 第四级推送时间

	public WarningWithRule() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getReliever() {
		return reliever;
	}

	public void setReliever(String reliever) {
		this.reliever = reliever;
	}

	public Timestamp getRelieveTime() {
		return relieveTime;
	}

	public void setRelieveTime(Timestamp relieveTime) {
		this.relieveTime = relieveTime;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public int getRuleFirstTime() {
		return ruleFirstTime;
	}

	public void setRuleFirstTime(int ruleFirstTime) {
		this.ruleFirstTime = ruleFirstTime;
	}

	public int getRuleSecondTime() {
		return ruleSecondTime;
	}

	public void setRuleSecondTime(int ruleSecondTime) {
		this.ruleSecondTime = ruleSecondTime;
	}

	public int getRuleThirdTime() {
		return ruleThirdTime;
	}

	public void setRuleThirdTime(int ruleThirdTime) {
		this.ruleThirdTime = ruleThirdTime;
	}

	public int getRuleFourthTime() {
		return ruleFourthTime;
	}

	public void setRuleFourthTime(int ruleFourthTime) {
		this.ruleFourthTime = ruleFourthTime;
	}

	@Override
	public String toString() {
		return "WarningWithRule [message=" + message + ", title=" + title + ", deviceId=" + deviceId + ", guid=" + guid
				+ ", status=" + status + ", createTime=" + createTime + ", reliever=" + reliever + ", relieveTime="
				+ relieveTime + ", readStatus=" + readStatus + ", ruleFirstTime=" + ruleFirstTime + ", ruleSecondTime="
				+ ruleSecondTime + ", ruleThirdTime=" + ruleThirdTime + ", ruleFourthTime=" + ruleFourthTime + "]";
	}

}
