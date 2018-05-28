package com.xinhai.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.dao.ITaskDao;
import com.xinhai.entity.Task;

public class TaskDao implements ITaskDao {

	@Override
	public List<Task> selectTask() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> selectTasAllk() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTaskCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertTask(Task data) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTask(Task data) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Task selectTaskById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteTask(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
