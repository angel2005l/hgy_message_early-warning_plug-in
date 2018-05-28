package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.Task;

public interface ITaskDao {
	// public List<Task> selectTaskPagewithCount() throws SQLException;
	// 查询task集合（分页）
	public List<Task> selectTask() throws SQLException;

	// 查询task集合
	public List<Task> selectTasAllk() throws SQLException;

	// 查询task总行数
	public int selectTaskCount() throws SQLException;

	// 添加task信息
	public int insertTask(Task data) throws SQLException;

	// 更新task信息
	public int updateTask(Task data) throws SQLException;

	// 根据id查询task
	public Task selectTaskById(String id) throws SQLException;

	// 删除task信息
	public int deleteTask(String id) throws SQLException;

}
