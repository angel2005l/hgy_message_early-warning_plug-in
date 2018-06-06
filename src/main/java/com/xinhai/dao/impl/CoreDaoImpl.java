package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.ICoreDao;
import com.xinhai.entity.WarningWithRule;
import com.xinhai.util.SqlPoolUtil;
import com.xinhai.util.StrUtil;

public class CoreDaoImpl implements ICoreDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<WarningWithRule> selectWarningPush() throws SQLException {
		String sql = "SELECT a.`title`,a.`message`,a.`device_id`,a.`create_time`,a.`guid`,a.`read_status`,c.`rule_first_time`,c.`rule_second_time`,c.`rule_third_time`,c.`rule_fourth_time` FROM mep_warning a INNER JOIN mep_event b ON a.`event_code` = b.`event_code` and event_status='1' INNER JOIN mep_push_rule c ON b.`rule_code`=c.`rule_code` WHERE a.`status`= '0' AND a.`read_status` <>'4' ORDER BY create_time ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		List<WarningWithRule> result = new ArrayList<WarningWithRule>();
		while (rs.next()) {
			WarningWithRule obj = new WarningWithRule();
			obj.setTitle(rs.getString("title"));
			obj.setMessage(rs.getString("message"));
			obj.setDeviceId(rs.getString("device_id"));
			obj.setCreateTime(rs.getTimestamp("create_time"));
			obj.setGuid(rs.getString("guid"));
			obj.setReadStatus(rs.getString("read_status"));
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
	public boolean updateWarningPush(String guid, String readStatus) throws SQLException {
		String sql = "update mep_warning set read_status = ? where guid = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, readStatus);
		ps.setString(2, guid);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn > 0 ? true : false;
	}

	@Override
	public String selectUserTokenByLevel(int level) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select user_name,user_token,user_email,user_phone from mep_user where user_status='1' and user_level = ?");
		if (level == 1) {
			sql.append(" and is_work= 'Y'");
		}
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ps.setInt(1, level);
		ResultSet rs = ps.executeQuery();
		StringBuffer result = new StringBuffer();
		while (rs.next()) {
			result.append(rs.getString("user_token")).append(",");
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return StrUtil.cutStringForLeft(result.toString(), 1);
	}

	@Override
	public String selectUserEmailByLevel(int level) throws SQLException {
		String sql = "select user_email from mep_user where user_status='1' and user_level = ? ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, level);
		ResultSet rs = ps.executeQuery();
		StringBuffer result = new StringBuffer();
		while (rs.next()) {
			result.append(rs.getString("user_email")).append(";");
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return StrUtil.cutStringForLeft(result.toString(), 1);
	}

	@Override
	public List<Map<String, Object>> selectOEE() throws SQLException {
		String sql = "SELECT aa.equ_code,IFNULL(aa.`equ_start_time`,'') AS equ_start_time,aa.equ_qualified_quantity,aa.equ_complete_quantity,aa.equ_product_code,bb.holes_num,bb.produce_cycle, aa.equ_use_state FROM mep_equipment aa INNER JOIN (SELECT a.`device_id`,SUM(b.`mould_holes_num`) AS holes_num ,SUM(b.mould_produce_cycle) AS produce_cycle FROM mep_mould_device a INNER JOIN mep_mould b ON a.`mold_id` = b.`id` GROUP BY a.`device_id`) bb ON aa.equ_id = bb.device_id";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("equ_code", rs.getString("equ_code"));
			map.put("start_time", rs.getString("equ_start_time"));
			map.put("equ_qualified_quantity", rs.getString("equ_qualified_quantity"));
			map.put("equ_complete_quantity", rs.getString("equ_complete_quantity"));
			map.put("equ_product_code", rs.getString("equ_product_code"));
			map.put("holes_num", rs.getString("holes_num"));
			map.put("produce_cycle", rs.getString("produce_cycle"));
			map.put("equ_use_state", rs.getString("equ_use_state"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<Map<String, Object>> selectWarnDay() throws SQLException {
		String sql = "SELECT title,message  FROM mep_warning WHERE TO_DAYS(create_time) =TO_DAYS(NOW())";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", rs.getString("title"));
			map.put("message", rs.getString("message"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<String[]> selectWarn7Day() throws SQLException {
		String sql = "SELECT DATE_FORMAT(mycreatedate,'%m-%d') AS date_str,IFNULL(COUNT(pv.create_time), 0) AS num FROM ( "
				+ "SELECT CURDATE() AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 1 DAY) AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 2 DAY) AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 3 DAY) AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 4 DAY) AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 5 DAY) AS mycreatedate " + "UNION ALL "
				+ "SELECT DATE_SUB(CURDATE(), INTERVAL 6 DAY) AS mycreatedate " + ") AS total "
				+ "LEFT JOIN mep_warning pv ON DATE_FORMAT(pv.create_time,'%Y-%m-%d')=total.mycreatedate GROUP BY mycreatedate";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<String[]> result = new ArrayList<String[]>();
		while (rs.next()) {
			String[] str = new String[2];
			str[0] = rs.getString("date_str");
			str[1] = rs.getString("num");
			result.add(str);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<Map<String, String>> selectEquProduceType() throws SQLException {
		String sql = "SELECT IF(equ_use_statedsp IS NULL OR equ_use_statedsp = '','状态不明',equ_use_statedsp) AS equ_use_statedsp,COUNT(1) AS num FROM mep_equipment GROUP BY equ_use_statedsp ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", rs.getString("equ_use_statedsp"));
			map.put("value", rs.getString("num"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<Map<String, String>> selectWarnWeekTop5() throws SQLException {
		String sql = "SELECT a.event_name,b.num FROM mep_event a INNER JOIN  (SELECT event_code,COUNT(1) AS num FROM mep_warning WHERE YEARWEEK(DATE_FORMAT(create_time,'%Y-%m-%d')) = YEARWEEK(NOW()) GROUP BY event_code ORDER BY num LIMIT 0,5) b ON a.event_code = b.event_code";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", rs.getString("event_name"));
			map.put("value", rs.getString("num"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(null, ps, rs);
		return result;
	}

}
