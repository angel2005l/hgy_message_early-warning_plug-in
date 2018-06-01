package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.IEventTypeDao;
import com.xinhai.entity.Event;
import com.xinhai.util.SqlPoolUtil;
import com.xinhai.util.StrUtil;

public class EventTypeDaoImpl implements IEventTypeDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<Event> selectEvent(int page) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select id,event_id,event_code,event_name,event_pid,rule_code,event_status from mep_event where 1=1 ");
		sql.append("limit ").append((page - 1) * 10).append(",").append(10);
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List<Event> result = new ArrayList<Event>();
		while (rs.next()) {
			Event obj = new Event();
			obj.setId(rs.getInt("id"));
			obj.setEventId(rs.getInt("event_id"));
			obj.setEventCode(rs.getString("event_code"));
			obj.setEventName(rs.getString("event_name"));
			obj.setpId(rs.getInt("event_pid"));
			obj.setRuleCode(rs.getString("rule_code"));
			obj.setEventStatus(rs.getString("event_status"));
			result.add(obj);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectEventCount() throws SQLException {
		String sql = "select count(1) from mep_event where 1=1";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return count;
	}

	@Override
	public int insertEvent(Event data) throws SQLException {
		String sql = "insert into mep_event(event_id,event_code,event_name,event_pid,rule_code,event_status) values(?,?,?,?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, data.getEventId());
		ps.setString(2, data.getEventCode());
		ps.setString(3, data.getEventName());
		ps.setInt(4, data.getpId());
		ps.setString(5, data.getRuleCode());
		ps.setString(6, data.getEventStatus());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int updateEventWithRuleCode(String ruleCode, int id) throws SQLException {
		String sql = "update mep_event set rule_code = ? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ruleCode);
		ps.setInt(2, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int updateEventWithEventStatus(String eventStatus, int id) throws SQLException {
		String sql = "update mep_event set event_status = ? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, eventStatus);
		ps.setInt(2, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;

	}

	@Override
	public List<Map<String, String>> selectEventKV() throws SQLException {
		String sql = "select event_code ,event_name from mep_event ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", rs.getString("event_code"));
			map.put("text", rs.getString("event_name"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int updateBatchEventWithRuleCode(String ruleCode, String[] eventCodes) throws SQLException {
		String sql = "update mep_event set rule_code =? where event_code =?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			for (String eventCode : eventCodes) {
				if (StrUtil.isBlank(eventCode)) {
					continue;
				}
				ps.setString(1, ruleCode);
				ps.setString(2, eventCode);
				int rtn = ps.executeUpdate();
				if (rtn < 1) {
					conn.rollback();
					return 0;
				}
			}
			return 1;
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	@Override
	public Event selectWarnById(int id) throws SQLException {
		String sql = "select id,event_id,event_code,event_name,event_pid,rule_code,event_status from mep_event where id = ? ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Event obj = null;
		while (rs.next()) {
			obj = new Event();
			obj.setId(rs.getInt("id"));
			obj.setEventId(rs.getInt("event_id"));
			obj.setEventCode(rs.getString("event_code"));
			obj.setEventName(rs.getString("event_name"));
			obj.setpId(rs.getInt("event_pid"));
			obj.setRuleCode(rs.getString("rule_code"));
			obj.setEventStatus(rs.getString("event_status"));
		}
		return obj;
	}
}
