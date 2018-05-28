package com.xinhai.service;

import java.util.List;

import com.xinhai.entity.Task;

public interface ITaskService {

	// 查询调度任务信息
	public List<Task> selTask() throws Exception;

	// 添加调度任务
	public boolean addTask(Task data) throws Exception;

	// 修改调度任务
	public Task selTaskById(String id) throws Exception;
	// 根据id查询特定的task
	public boolean uptTask(Task data) throws Exception;

	// 删除调度任务
	public boolean delTask(String id) throws Exception;

}
