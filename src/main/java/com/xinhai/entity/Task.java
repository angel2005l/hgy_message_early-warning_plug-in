package com.xinhai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Task implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String taskCode;
	private String taskName;
	private String taskType;
	private String taskRunType;
	private int taskTime;
	private String taskTimming;
	private Timestamp taskLastExecuteTime;
	private String status;

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

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskRunType() {
		return taskRunType;
	}

	public void setTaskRunType(String taskRunType) {
		this.taskRunType = taskRunType;
	}

	public int getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}

	public String getTaskTimming() {
		return taskTimming;
	}

	public void setTaskTimming(String taskTimming) {
		this.taskTimming = taskTimming;
	}

	public Timestamp getTaskLastExecuteTime() {
		return taskLastExecuteTime;
	}

	public void setTaskLastExecuteTime(Timestamp taskLastExecuteTime) {
		this.taskLastExecuteTime = taskLastExecuteTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskCode=" + taskCode + ", taskName=" + taskName + ", taskType=" + taskType
				+ ", taskRunType=" + taskRunType + ", taskTime=" + taskTime + ", taskTimming=" + taskTimming
				+ ", taskLastExecuteTime=" + taskLastExecuteTime + ", status=" + status + "]";
	}

}
