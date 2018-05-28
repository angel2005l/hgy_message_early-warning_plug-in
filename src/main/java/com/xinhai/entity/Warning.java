package com.xinhai.entity;

import java.sql.Timestamp;

import com.xinhai.util.StrUtil;

public class Warning {
	private int id;// 主键id
	private String eventId;// 事件id
	private String eventType;// 事件类型
	private String eventCode;// 事件编码
	private int levelType;// 级别类型
	private String message;// 预警信息
	private String title;// 预警标题
	private String deviceId;// 设备id
	private String guid;// 事件标识码(唯一识别码）依据此值
	private String objectId;// 对象标识码
	private String status;// 状态（预警信息）
	private Timestamp createTime;// 创建时间
	private String reliever;// 处理人签名
	private Timestamp relieveTime;// 处理时间
	private String readStatus; // 上报等级

	public Warning() {
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public int getLevelType() {
		return levelType;
	}

	public String getEventType() {
		return eventType;
	}

	public String getEventTypeForIns() {
		if (StrUtil.notBlank(this.title)) {
			return this.title.substring(this.title.indexOf(")") + 1);
		}
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setLevelType(int levelType) {
		this.levelType = levelType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = StrUtil.replaceAllStr(message, "\\r\\n||\\r||\\n", "");
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

	public String getReliever() {
		return reliever;
	}

	public void setReliever(String reliever) {
		this.reliever = reliever;
	}

	public Timestamp getRelieveTime() {
		return relieveTime;
	}

	public void setRelieveTime(Timestamp timestamp) {
		this.relieveTime = timestamp;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
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

	public void setCreateTime(Timestamp timestamp) {
		this.createTime = timestamp;
	}

	@Override
	public String toString() {
		return "Warning [id=" + id + ", eventId=" + eventId + ", eventType=" + eventType + ", eventCode=" + eventCode
				+ ", levelType=" + levelType + ", message=" + message + ", title=" + title + ", deviceId=" + deviceId
				+ ", reliever=" + reliever + ", relieveTime=" + relieveTime + ", guid=" + guid + ", objectId="
				+ objectId + ", status=" + status + ", createTime=" + createTime + ", readStatus=" + readStatus + "]";
	}

}
