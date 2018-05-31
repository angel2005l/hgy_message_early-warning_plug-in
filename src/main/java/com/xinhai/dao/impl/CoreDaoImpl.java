package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.ICoreDao;
import com.xinhai.entity.WarningWithRule;
import com.xinhai.util.SqlPoolUtil;
import com.xinhai.util.StrUtil;

public class CoreDaoImpl implements ICoreDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<WarningWithRule> selWarningPush() throws SQLException {
		String sql = "SELECT a.`title`,a.`message`,a.`device_id`,a.`create_time`,a.`guid`,a.`read_status`,c.`rule_first_time`,c.`rule_second_time`,c.`rule_third_time`,c.`rule_fourth_time` FROM mep_warning a INNER JOIN mep_event b ON a.`event_code` = b.`event_code` INNER JOIN mep_push_rule c ON b.`rule_code`=c.`rule_code` WHERE a.`status`= '0' AND a.`read_status` <>'4' ORDER BY create_time ";
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
	public boolean uptWarningPush(String guid, String readStatus) throws SQLException {
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
	public String selUserTokenByLevel(int level) throws SQLException {
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
			// User obj = new User();
			// obj.setUserName(rs.getString("user_name"));
			// obj.setUserToken(rs.getString("user_token"));
			// obj.setUserEmail(rs.getString("user_email"));
			// obj.setUserPhone(rs.getString("user_phone"));
			// result.add(obj);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return StrUtil.cutStringForLeft(result.toString(), 1);
	}
}
