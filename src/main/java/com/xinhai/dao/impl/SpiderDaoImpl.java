package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.ISpiderDao;
import com.xinhai.entity.Event;
import com.xinhai.entity.Warning;
import com.xinhai.util.DateUtil;
import com.xinhai.util.SqlPoolUtil;

public class SpiderDaoImpl implements ISpiderDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public boolean insertWarning(List<Warning> data, boolean isInit) throws SQLException {
		String sql = "insert into mpe_warning(event_id,event_type,event_code,title,message,device_id,guid,status,create_time,reliever,relieve_time,read_status)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?) on duplicate key update reliever=VALUES(reliever),relieve_time=VALUES(relieve_time),status=VALUES(status)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Warning obj : data) {
			// 进行数据筛选
			if (!isInit && !DateUtil.isThisMonth(obj.getCreateTime().getTime())) {
				continue;
			}
			ps.setString(1, obj.getEventId());
			ps.setString(2, obj.getEventType());
			ps.setString(3, obj.getEventCode());
			ps.setString(4, obj.getTitle());
			ps.setString(5, obj.getMessage());
			ps.setString(6, obj.getDeviceId());
			ps.setString(7, obj.getGuid());
			ps.setString(8, obj.getStatus());
			ps.setTimestamp(9, obj.getCreateTime());
			ps.setString(10, obj.getReliever());
			ps.setTimestamp(11, obj.getRelieveTime());
			ps.setString(12, obj.getReadStatus());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public boolean insertWarnType(List<Event> data) throws SQLException {
		String sql = "insert into mpe_event(event_id,event_code,event_name,event_pid) values(?,?,?,?) on duplicate key update event_code=VALUES(event_code), event_name=VALUES(event_name) ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Event obj : data) {
			ps.setInt(1, obj.getEventId());
			ps.setString(2, obj.getEventCode());
			ps.setString(3, obj.getEventName());
			ps.setInt(4, obj.getpId());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}
}
