package com.xinhai.entity;

import java.sql.Timestamp;

public class Task {
	private int id;
	private String taskCode;
	private String taskName;
	private int taskTime;
	private Timestamp taskLastExecuteTime;

	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}

	public Timestamp getTaskLastExecuteTime() {
		return taskLastExecuteTime;
	}

	public void setTaskLastExecuteTime(Timestamp taskLastExecuteTime) {
		this.taskLastExecuteTime = taskLastExecuteTime;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskCode=" + taskCode + ", taskName=" + taskName + ", taskTime=" + taskTime
				+ ", taskLastExecuteTime=" + taskLastExecuteTime + "]";
	}

}
