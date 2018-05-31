package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.IPushRuleDao;
import com.xinhai.entity.PushRule;
import com.xinhai.util.SqlPoolUtil;

public class PushRuleDaoImpl implements IPushRuleDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<PushRule> selectPushRule() throws SQLException {
		String sql = "select id,rule_code,rule_name,rule_first_time,rule_second_time,rule_third_time,rule_fourth_time from mep_push_rule where 1=1";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<PushRule> result = new ArrayList<PushRule>();
		while (rs.next()) {
			PushRule obj = new PushRule();
			obj.setId(rs.getInt("id"));
			obj.setRuleCode(rs.getString("rule_code"));
			obj.setRuleName(rs.getString("rule_name"));
			obj.setRuleFirstTime(rs.getInt("rule_first_time"));
			obj.setRuleSecondTime(rs.getInt("rule_second_time"));
			obj.setRuleThirdTime(rs.getInt("rule_third_time"));
			obj.setRuleFourthTime(rs.getInt("rule_fourth_time"));
			result.add(obj);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectPushRuleCount() throws SQLException {
		String sql = "select count(1) from mep_push_rule where 1=1";
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
	public PushRule selectPushRuleById(int id) throws SQLException {
		String sql = "select id,rule_code,rule_name,rule_first_time,rule_second_time,rule_third_time,rule_fourth_time from mep_push_rule where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		PushRule obj = null;
		while (rs.next()) {
			obj = new PushRule();
			obj.setId(rs.getInt("id"));
			obj.setRuleCode(rs.getString("rule_code"));
			obj.setRuleName(rs.getString("rule_name"));
			obj.setRuleFirstTime(rs.getInt("rule_first_time"));
			obj.setRuleSecondTime(rs.getInt("rule_second_time"));
			obj.setRuleThirdTime(rs.getInt("rule_third_time"));
			obj.setRuleFourthTime(rs.getInt("rule_fourth_time"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return obj;
	}

	@Override
	public int insertPushRule(PushRule data) throws SQLException {
		String sql = "insert into mep_push_rule(rule_code,rule_name,rule_first_time,rule_second_time,rule_third_time,rule_fourth_time) values(?,?,?,?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getRuleCode());
		ps.setString(2, data.getRuleName());
		ps.setInt(3, data.getRuleFirstTime());
		ps.setInt(4, data.getRuleSecondTime());
		ps.setInt(5, data.getRuleThirdTime());
		ps.setInt(6, data.getRuleFourthTime());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int updatePushRule(PushRule data) throws SQLException {
		String sql = "update mep_push_rule set rule_name=?,rule_first_time=?,rule_second_time=?,rule_third_time=?,rule_fourth_time=? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getRuleName());
		ps.setInt(2, data.getRuleFirstTime());
		ps.setInt(3, data.getRuleSecondTime());
		ps.setInt(4, data.getRuleThirdTime());
		ps.setInt(5, data.getRuleFourthTime());
		ps.setInt(6, data.getId());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int deletePushRule(int id) throws SQLException {
		String sql = "delete from mep_push_rule where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public List<Map<String, String>> selectPushRuleKV() throws SQLException {
		String sql = "select rule_code,rule_name from mep_push_rule";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", rs.getString("rule_code"));
			map.put("text", rs.getString("rule_name"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

}
