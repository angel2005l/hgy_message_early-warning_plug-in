package com.xinhai.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ITaskDao;
import com.xinhai.dao.impl.TaskDaoImpl;
import com.xinhai.entity.Task;
import com.xinhai.service.ITaskService;
import com.xinhai.util.Page;

public class TaskServiceImpl implements ITaskService {
	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	private ITaskDao dao = new TaskDaoImpl();

	@Override
	public Page<Task> selTaskPageWithCount(String taskName, String page) throws Exception {
		try {
			List<Task> selectTask = dao.selectTask(taskName,Integer.parseInt(page));
			int countNum = dao.selectTaskCount(taskName);
			return new Page<Task>(10, countNum, Integer.parseInt(page), selectTask);
		} catch (SQLException e) {
			log.error("查询调度任务信息异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Task> selectDataTaskAll() throws Exception {
		try {
			return dao.selectTaskAll("data");
		} catch (SQLException e) {
			log.error("查询全部启用的数据调度任务信息异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean insTask(Task data) throws Exception {
		try {
			return dao.insertTask(data) > 0 ? true : false;
		} catch (SQLException e) {
			log.error("添加调度任务信息异常,异常原因:" + e.getMessage());
			return false;
		}
	}

	@Override
	public Task selTaskById(String id) throws Exception {
		try {
			return dao.selectTaskById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定调度任务信息异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean uptTask(Task data) throws Exception {
		try {
			return dao.updateTask(data) > -1 ? true : false;
		} catch (SQLException e) {
			log.error("更新调度任务信息异常,异常原因:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delTask(String id) throws Exception {
		try {
			return dao.deleteTask(Integer.parseInt(id)) > 0 ? true : false;
		} catch (SQLException e) {
			log.error("查询调度任务信息异常,异常原因:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean uptTaskLastExecuteTime(Timestamp newLastExecuteTime, String taskCode) throws Exception {
		try {
			return dao.updateTaskLastExecuteTime(newLastExecuteTime, taskCode) > 0 ? true : false;
		} catch (SQLException e) {
			log.error("查询调度任务信息异常,异常原因:" + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Task> seListWorkTaskAll() throws Exception {
		try {
			return dao.selectTaskAll("work");
		} catch (SQLException e) {
			log.error("查询全部启用的业务调度任务信息异常,异常原因:" + e.getMessage());
			return null;
		}
	}

}
