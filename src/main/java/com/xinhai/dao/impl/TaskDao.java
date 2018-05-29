package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.ITaskDao;
import com.xinhai.entity.Task;
import com.xinhai.util.SqlPoolUtil;
import com.xinhai.util.StrUtil;

public class TaskDao implements ITaskDao {
	SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<Task> selectTask(String taskName) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select id,task_code,task_name,task_type,task_run_type,task_time,task_timing,task_last_execute_time,status from mpe_task where 1=1 ");
		if (StrUtil.notBlank(taskName)) {
			sql.append(" and task_name = ?");
		}
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int index = 1;
		if (StrUtil.notBlank(taskName)) {
			ps.setString(index++, taskName);
		}
		ResultSet rs = ps.executeQuery();
		List<Task> result = new ArrayList<Task>();
		while (rs.next()) {
			Task obj = new Task();
			obj.setId(rs.getInt("id"));
			obj.setTaskCode(rs.getString("task_code"));
			obj.setTaskName(rs.getString("task_name"));
			obj.setTaskType(rs.getString("task_type"));
			obj.setTaskRunType(rs.getString("task_run_type"));
			obj.setTaskTime(rs.getInt("task_time"));
			obj.setTaskTimming(rs.getString("task_timing"));
			obj.setTaskLastExecuteTime(rs.getTimestamp("task_last_execute_time"));
			result.add(obj);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<Task> selectTaskAll() throws SQLException {
		String sql = "select task_code,task_name,task_type,task_run_type,task_time,task_timing,task_last_execute_time from mpe_task where status ='Y'";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Task> result = new ArrayList<Task>();
		while (rs.next()) {
			Task obj = new Task();
			obj.setTaskCode(rs.getString("task_code"));
			obj.setTaskName(rs.getString("task_name"));
			obj.setTaskType(rs.getString("task_type"));
			obj.setTaskRunType(rs.getString("task_run_type"));
			obj.setTaskTime(rs.getInt("task_time"));
			obj.setTaskTimming(rs.getString("task_timing"));
			obj.setTaskLastExecuteTime(rs.getTimestamp("task_last_execute_time"));
			result.add(obj);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectTaskCount(String taskName) throws SQLException {
		StringBuffer sql = new StringBuffer("select count(1) from mpe_task where 1=1 ");
		if (StrUtil.notBlank(taskName)) {
			sql.append(" and task_name = ?");
		}

		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int index = 1;
		if (StrUtil.notBlank(taskName)) {
			ps.setString(index++, taskName);
		}
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			index = rs.getInt(1);
		} else {
			index = 0;
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return index;
	}

	@Override
	public int insertTask(Task data) throws SQLException {
		String sql = "insert into mpe_task(task_code,task_name,task_type,task_run_type,task_time,task_timing,task_last_execute_time,status) VALUES(?,?,?,?,?,?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getTaskCode());
		ps.setString(2, data.getTaskName());
		ps.setString(3, data.getTaskType());
		ps.setString(4, data.getTaskRunType());
		ps.setInt(5, data.getTaskTime());
		ps.setString(6, data.getTaskTimming());
		ps.setTimestamp(7, data.getTaskLastExecuteTime());
		ps.setString(8, data.getStatus());
		return ps.executeUpdate();
	}

	@Override
	public int updateTask(Task data) throws SQLException {
		String sql = "update set task_name=?,task_type=?,task_run_type=?,task_time=?,task_timing=?,status=? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getTaskName());
		ps.setString(2, data.getTaskType());
		ps.setString(3, data.getTaskRunType());
		ps.setInt(4, data.getTaskTime());
		ps.setString(5, data.getTaskTimming());
		ps.setString(6, data.getStatus());
		ps.setInt(7, data.getId());
		return ps.executeUpdate();
	}

	@Override
	public Task selectTaskById(int id) throws SQLException {
		String sql = "select id,task_code,task_name,task_type,task_run_type,task_time,task_timing,task_last_execute_time,status from mpe_task id=? ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Task obj = new Task();
		if (rs.next()) {
			obj.setId(rs.getInt("id"));
			obj.setTaskCode(rs.getString("task_code"));
			obj.setTaskName(rs.getString("task_name"));
			obj.setTaskType(rs.getString("task_type"));
			obj.setTaskRunType(rs.getString("task_run_type"));
			obj.setTaskTime(rs.getInt("task_time"));
			obj.setTaskTimming(rs.getString("task_timing"));
			obj.setTaskLastExecuteTime(rs.getTimestamp("task_last_execute_time"));
		}
		return obj;
	}

	@Override
	public int deleteTask(int id) throws SQLException {
		String sql = "delete from mpe_task where id =?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

}
