package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.IPushInfoDao;
import com.xinhai.entity.Warning;
import com.xinhai.util.SqlPoolUtil;

public class PushInfoDaoImpl implements IPushInfoDao {
	SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public Warning selectWarn(String guid) throws SQLException {
		String sql = "select title,message,device_id,create_time from mep_warning where guid = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Warning warn = null;
		if (rs.next()) {
			warn = new Warning();
			warn.setTitle(rs.getString("title"));
			warn.setMessage(rs.getString("message"));
			warn.setCreateTime(rs.getTimestamp("create_time"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return warn;
	}

	@Override
	public Map<String, Object> selectWarnWeek() throws SQLException {
		String sqlSolveWarn = "SELECT title,message,device_id,create_time FROM mep_warning WHERE status=1 and YEARWEEK(DATE_FORMAT(create_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1";
		String sqlUnsolveWarn = "SELECT title,message,device_id,create_time FROM mep_warning WHERE status=0 and YEARWEEK(DATE_FORMAT(create_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1";
		String sqlWarnTop5 = "SELECT a.event_name,b.num FROM mep_event a INNER JOIN  (SELECT event_code,COUNT(1) AS num FROM mep_warning WHERE YEARWEEK(DATE_FORMAT(create_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)-1 GROUP BY event_code ORDER BY num LIMIT 0,5) b ON a.event_code = b.event_code";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sqlSolveWarn);
		rs = ps.executeQuery();
		List<Warning> warnWeekSolveWarn = new ArrayList<Warning>();
		while (rs.next()) {
			Warning warn = new Warning();
			warn.setTitle(rs.getString("title"));
			warn.setMessage(rs.getString("message"));
			warn.setCreateTime(rs.getTimestamp("create_time"));
			warnWeekSolveWarn.add(warn);
		}
		ps = conn.prepareStatement(sqlUnsolveWarn);
		rs = ps.executeQuery();
		List<Warning> warnWeekUnsolveWarn = new ArrayList<Warning>();
		while (rs.next()) {
			Warning warn = new Warning();
			warn.setTitle(rs.getString("title"));
			warn.setMessage(rs.getString("message"));
			warn.setCreateTime(rs.getTimestamp("create_time"));
			warnWeekUnsolveWarn.add(warn);
		}

		ps = conn.prepareStatement(sqlWarnTop5);
		rs = ps.executeQuery();
		List<Map<String, String>> warnWeekTop5 = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", rs.getString("event_name"));
			map.put("value", rs.getString("num"));
			warnWeekTop5.add(map);
		}
		SqlPoolUtil.closeConnection(null, ps, rs);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("warnWeekSolveWarn", warnWeekSolveWarn);
		result.put("warnWeekUnsolveWarn", warnWeekUnsolveWarn);
		result.put("warnWeekTop5", warnWeekTop5);
		return result;
	}
	@Override
	public Map<String, Object> selectWarnMonth() throws SQLException {
		String sqlSolveWarn = "SELECT title,message,device_id,create_time FROM mep_warning WHERE status=1 and MONTH(create_time) = MONTH(NOW())-1 AND YEAR(create_time) =YEAR(NOW())";
		String sqlUnsolveWarn = "SELECT title,message,device_id,create_time FROM mep_warning WHERE status=0 and MONTH(create_time) = MONTH(NOW())-1 AND YEAR(create_time) =YEAR(NOW())";
		String sqlWarnTop5 = "SELECT a.event_name,b.num FROM mep_event a INNER JOIN  (SELECT event_code,COUNT(1) AS num FROM mep_warning WHERE MONTH(create_time) = MONTH(NOW())-1 AND YEAR(create_time) =YEAR(NOW()) GROUP BY event_code ORDER BY num LIMIT 0,5) b ON a.event_code = b.event_code";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sqlSolveWarn);
		rs = ps.executeQuery();
		List<Warning> warnMonthSolveWarn = new ArrayList<Warning>();
		while (rs.next()) {
			Warning warn = new Warning();
			warn.setTitle(rs.getString("title"));
			warn.setMessage(rs.getString("message"));
			warn.setCreateTime(rs.getTimestamp("create_time"));
			warnMonthSolveWarn.add(warn);
		}
		ps = conn.prepareStatement(sqlUnsolveWarn);
		rs = ps.executeQuery();
		List<Warning> warnMonthUnsolveWarn = new ArrayList<Warning>();
		while (rs.next()) {
			Warning warn = new Warning();
			warn.setTitle(rs.getString("title"));
			warn.setMessage(rs.getString("message"));
			warn.setCreateTime(rs.getTimestamp("create_time"));
			warnMonthUnsolveWarn.add(warn);
		}

		ps = conn.prepareStatement(sqlWarnTop5);
		rs = ps.executeQuery();
		List<Map<String, String>> warnMonthTop5 = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", rs.getString("event_name"));
			map.put("value", rs.getString("num"));
			warnMonthTop5.add(map);
		}
		SqlPoolUtil.closeConnection(null, ps, rs);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("warnMonthSolveWarn", warnMonthSolveWarn);
		result.put("warnMonthUnsolveWarn", warnMonthUnsolveWarn);
		result.put("warnMonthTop5", warnMonthTop5);
		return result;
	}

}
