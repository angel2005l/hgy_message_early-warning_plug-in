package com.xinhai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Task implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private int id;// 编码
	private String taskCode;// 调度任务编码
	private String taskName;// 调度任务名称
	private String taskType;// 调度任务名称（data/work）
	private String taskRunType;// 调度任务执行类型（once/cont）
	private int taskTime;// 执行时间间隔
	private String taskTiming;// 执行时间点
	private Timestamp taskLastExecuteTime;// 最后一次执行时间
	private String status;// 状态

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

	public String getTaskTiming() {
		return taskTiming;
	}

	public void setTaskTiming(String taskTiming) {
		this.taskTiming = taskTiming;
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
				+ ", taskRunType=" + taskRunType + ", taskTime=" + taskTime + ", taskTiming=" + taskTiming
				+ ", taskLastExecuteTime=" + taskLastExecuteTime + ", status=" + status + "]";
	}

}
