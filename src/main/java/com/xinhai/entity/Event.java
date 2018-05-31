package com.xinhai.entity;

/*
 * 临时只当作预警类型表
 */
public class Event {
	private int id; // 预警类型主键id
	private int eventId;
	private String eventCode;
	private String eventName;
	private int pId;
	private String ruleCode;
	private String eventStatus;

	public Event() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventId=" + eventId + ", eventCode=" + eventCode + ", eventName=" + eventName
				+ ", pId=" + pId + ", ruleCode=" + ruleCode + ", eventStatus=" + eventStatus + "]";
	}

}
