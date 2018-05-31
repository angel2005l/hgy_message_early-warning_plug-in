package com.xinhai.service;

import java.sql.Timestamp;
import java.util.List;

import com.xinhai.entity.Task;
import com.xinhai.util.Page;

public interface ITaskService {

	// 查询调度任务信息
	public Page<Task> selTaskPageWithCount(String taskName,String page) throws Exception;

	// 查询全部启动的调度任务（数据）
	public List<Task> selectDataTaskAll() throws Exception;
	// 查询全部启动的调度任务（业务）
	public List<Task> seListWorkTaskAll() throws Exception;
	//更新最近执行时间
	public boolean uptTaskLastExecuteTime(Timestamp newLastExecuteTime, String taskCode) throws Exception;

	// 添加调度任务
	public boolean insTask(Task data) throws Exception;

	// 根据id查询特定的task
	public Task selTaskById(String id) throws Exception;

	// 修改调度任务
	public boolean uptTask(Task data) throws Exception;

	// 删除调度任务
	public boolean delTask(String id) throws Exception;

}
