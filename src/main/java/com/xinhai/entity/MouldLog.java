package com.xinhai.entity;

import java.sql.Timestamp;

public class MouldLog {
	private int id;
	private String mouldLogCode;
	private String mouldLogName;
	private String mouldLogContext;
	private int mouldPlanTimes;
	private int mouldRealTimes;
	private Timestamp mouldLogCreateTime;
	private String mouldLogStatus;
	private int mouldId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMouldLogCode() {
		return mouldLogCode;
	}

	public void setMouldLogCode(String mouldLogCode) {
		this.mouldLogCode = mouldLogCode;
	}

	public String getMouldLogName() {
		return mouldLogName;
	}

	public void setMouldLogName(String mouldLogName) {
		this.mouldLogName = mouldLogName;
	}

	public String getMouldLogContext() {
		return mouldLogContext;
	}

	public void setMouldLogContext(String mouldLogContext) {
		this.mouldLogContext = mouldLogContext;
	}

	public int getMouldPlanTimes() {
		return mouldPlanTimes;
	}

	public void setMouldPlanTimes(int mouldPlanTimes) {
		this.mouldPlanTimes = mouldPlanTimes;
	}

	public int getMouldRealTimes() {
		return mouldRealTimes;
	}

	public void setMouldRealTimes(int mouldRealTimes) {
		this.mouldRealTimes = mouldRealTimes;
	}

	public Timestamp getMouldLogCreateTime() {
		return mouldLogCreateTime;
	}

	public void setMouldLogCreateTime(Timestamp mouldLogCreateTime) {
		this.mouldLogCreateTime = mouldLogCreateTime;
	}

	public String getMouldLogStatus() {
		return mouldLogStatus;
	}

	public void setMouldLogStatus(String mouldLogStatus) {
		this.mouldLogStatus = mouldLogStatus;
	}

	public int getMouldId() {
		return mouldId;
	}

	public void setMouldId(int mouldId) {
		this.mouldId = mouldId;
	}

	@Override
	public String toString() {
		return "MouldLog [id=" + id + ", mouldLogCode=" + mouldLogCode + ", mouldLogName=" + mouldLogName
				+ ", mouldLogContext=" + mouldLogContext + ", mouldPlanTimes=" + mouldPlanTimes + ", mouldRealTimes="
				+ mouldRealTimes + ", mouldLogCreateTime=" + mouldLogCreateTime + ", mouldLogStatus=" + mouldLogStatus
				+ ", mouldId=" + mouldId + "]";
	}

}
