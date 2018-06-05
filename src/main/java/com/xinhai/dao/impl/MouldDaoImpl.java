package com.xinhai.dao.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.IMouldDao;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.entity.MouldWithRule;
import com.xinhai.util.SqlPoolUtil;
import com.xinhai.util.StrUtil;

public class MouldDaoImpl implements IMouldDao {

	SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<MouldWithRule> selectMouldWithRule() throws SQLException {
		String sql = "SELECT a.`id`,a.`mould_code`,a.`mould_name`,a.`mould_internal_times`,a.`mould_external_times`,a.`mould_remaining_times`,b.`mould_rule_code`,b.`mould_rule_times` ,rule_code,rule_first_time,rule_second_time,rule_third_time,rule_fourth_time FROM mep_mould a INNER JOIN mep_mould_rule b ON a.`mould_rule_code` = b.`mould_rule_code` INNER JOIN mep_push_rule c ON a.push_rule_code = c.rule_code ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<MouldWithRule> result = new ArrayList<MouldWithRule>();
		while (rs.next()) {
			MouldWithRule mr = new MouldWithRule();
			mr.setId(rs.getInt("id"));
			mr.setMouldCode(rs.getString("mould_code"));
			mr.setMouldName(rs.getString("mould_name"));
			mr.setMouldInternalTimes(rs.getInt("mould_internal_times"));
			mr.setMouldExternalTimes(rs.getInt("mould_external_times"));
			mr.setMouldRemainingTimes(rs.getInt("mould_remaining_times"));
			mr.setMouldRuleCode(rs.getString("mould_rule_code"));
			mr.setMouldRuleTimes(rs.getInt("mould_rule_times"));
			mr.setPushRuleCode(rs.getString("rule_code"));
			mr.setRuleTimes(rs.getInt("rule_first_time") + "," + rs.getInt("rule_second_time") + "," + rs.getInt(
					"rule_third_time") + "," + rs.getInt("rule_fourth_time"));
			result.add(mr);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<Mould> selectMould(int page) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"SELECT id,mould_code,mould_name,mould_life_times,mould_internal_times,mould_external_times,mould_remaining_times,mould_rule_code,push_rule_code FROM mep_mould WHERE 1=1");
		sql.append(" limit ").append((page - 1) * 10).append(",10");
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List<Mould> result = new ArrayList<Mould>();
		while (rs.next()) {
			Mould mould = new Mould();
			mould.setId(rs.getInt("id"));
			mould.setMouldCode(rs.getString("mould_code"));
			mould.setMouldName(rs.getString("mould_name"));
			mould.setMouldLifeTimes(rs.getInt("mould_life_times"));
			mould.setMouldInternalTimes(rs.getInt("mould_internal_times"));
			mould.setMouldExternalTimes(rs.getInt("mould_external_times"));
			mould.setMouldRemainingTimes(rs.getInt("mould_remaining_times"));
			mould.setMouldRuleCode(rs.getString("mould_rule_code"));
			mould.setPushRuleCode(rs.getString("push_rule_code"));
			result.add(mould);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectMouldCount() throws SQLException {
		String sql = "SELECT count(1) as num FROM mep_mould WHERE 1=1 ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int index = 1;
		if (rs.next()) {
			index = rs.getInt(1);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return index;
	}

	@Override
	public Mould selectMouldById(int id) throws SQLException {
		String sql = "SELECT id,mould_code,mould_name,mould_life_times,mould_internal_times,mould_external_times,mould_remaining_times,mould_rule_code,push_rule_code FROM mep_mould WHERE 1=1 and id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Mould mould = null;
		if (rs.next()) {
			mould = new Mould();
			mould.setId(rs.getInt("id"));
			mould.setMouldCode(rs.getString("mould_code"));
			mould.setMouldName(rs.getString("mould_name"));
			mould.setMouldLifeTimes(rs.getInt("mould_life_times"));
			mould.setMouldInternalTimes(rs.getInt("mould_internal_times"));
			mould.setMouldExternalTimes(rs.getInt("mould_external_times"));
			mould.setMouldRemainingTimes(rs.getInt("mould_remaining_times"));
			mould.setMouldRuleCode(rs.getString("mould_rule_code"));
			mould.setPushRuleCode(rs.getString("push_rule_code"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return mould;
	}

	@Override
	public int updateMouldPushRuleCodeWithId(int id, String mouldRuleCode, String pushRuleCode) throws SQLException {
		String sql = "UPDATE mep_mould SET mould_rule_code  = ?,push_rule_code = ?  WHERE id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mouldRuleCode);
		ps.setString(2, pushRuleCode);
		ps.setInt(3, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int updateMouldPushRuleCodeWithIds(String[] ids, String mouldRuleCode, String pushRuleCode)
			throws SQLException {
		String sql = "UPDATE mep_mould SET mould_rule_code  = ? ,push_rule_code = ? WHERE id = ?";

		DruidPooledConnection conn = instance.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			for (String id : ids) {
				if (StrUtil.isBlank(id)) {
					continue;
				}
				ps.setString(1, mouldRuleCode);
				ps.setString(2, pushRuleCode);
				ps.setInt(3, Integer.parseInt(id));
				ps.executeUpdate();
			}
			conn.commit();
			return 1;
		} catch (SQLException e) {
			conn.rollback();
			return -1;
		} finally {
			SqlPoolUtil.closeConnection(conn, ps, null);
		}
	}

	@Override
	public List<Map<String, String>> selectMouldKV() throws SQLException {
		String sql = "SELECT  id,mould_name FROM mep_mould ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", rs.getString("id"));
			map.put("text", rs.getString("mould_name"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public List<MouldRule> selectMouldRule(int page) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"SELECT id,mould_rule_code,mould_rule_name,mould_rule_times FROM mep_mould_rule where 1=1");
		sql.append(" limit ").append((page - 1) * 10).append(",10");
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List<MouldRule> result = new ArrayList<MouldRule>();
		while (rs.next()) {
			MouldRule mr = new MouldRule();
			mr.setId(rs.getInt("id"));
			mr.setMouldRuleCode(rs.getString("mould_rule_code"));
			mr.setMouldRuleName(rs.getString("mould_rule_name"));
			result.add(mr);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectMouldRuleCount() throws SQLException {
		String sql = "SELECT count(1) from mep_mould_rule";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int insertMouldRule(MouldRule data) throws SQLException {
		String sql = "INSERT INTO mep_mould_rule(mould_rule_code,mould_rule_name,mould_rule_times) VALUES(?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getMouldRuleCode());
		ps.setString(2, data.getMouldRuleName());
		ps.setInt(3, data.getMouldRuleTimes());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public MouldRule selectMouldRuleById(int id) throws SQLException {
		String sql = "SELECT id,mould_rule_code,mould_rule_name,mould_rule_times FROM mep_mould_rule where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		MouldRule mr = null;
		if (rs.next()) {
			mr = new MouldRule();
			mr.setId(rs.getInt("id"));
			mr.setMouldRuleCode(rs.getString("mould_rule_code"));
			mr.setMouldRuleName(rs.getString("mould_rule_name"));
			mr.setMouldRuleTimes(rs.getInt("mould_rule_times"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return mr;
	}

	@Override
	public int updateMouldRule(MouldRule data) throws SQLException {
		String sql = "UPDATE mep_mould_rule  SET mould_rule_name=?,mould_rule_times=? WHERE id = ? ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getMouldRuleName());
		ps.setInt(2, data.getMouldRuleTimes());
		ps.setInt(3, data.getId());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int deleteMouldRule(int id) throws SQLException {
		String sql = "delete from mep_mould_rule  where id=?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public List<Map<String, String>> selectMouldRuleKV() throws SQLException {
		String sql = "SELECT mould_rule_code,mould_rule_name FROM mep_mould_rule";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (rs.next()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", rs.getString("mould_rule_code"));
			map.put("text", rs.getString("mould_rule_name"));
			result.add(map);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public MouldLog selectMouldLogByMouldId(int mouldId) throws SQLException {
		String sql = "SELECT mould_plan_times,mould_real_times,mould_log_status FROM mep_mould_log a INNER JOIN mep_mould b ON a.`mould_id` =b.`id` WHERE  a.id = (SELECT MAX(id) FROM mep_mould_log WHERE mould_id = ?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, mouldId);
		ResultSet rs = ps.executeQuery();
		MouldLog ml = null;
		if (rs.next()) {
			ml = new MouldLog();
			ml.setMouldId(mouldId);
			ml.setMouldPlanTimes(rs.getInt("mould_plan_times"));
			ml.setMouldRealTimes(rs.getInt("mould_real_times"));
			ml.setMouldLogStatus(rs.getString("mould_log_status"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return ml;
	}

	@Override
	public int insertMouldLog(MouldLog data) throws SQLException {
		String sql = "INSERT INTO mep_molud_log(mould_log_code,mould_log_name,mould_plan_times,mould_log_status,mould_id) VALUE(?,?,?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getMouldLogCode());
		ps.setString(2, data.getMouldLogName());
		ps.setInt(3, data.getMouldPlanTimes());
		ps.setString(4, data.getMouldLogStatus());
		ps.setInt(5, data.getMouldId());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public List<MouldLog> selectMouldLog(int page) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"SELECT id,mould_log_code,mould_log_name,mould_log_context,mould_plan_times,mould_real_times,mould_log_create_time,mould_log_status,mould_id FROM mep_molud_log where 1=1 ");
		sql.append(" limit ").append((page - 1) * 10).append(",10");
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		List<MouldLog> result = new ArrayList<MouldLog>();
		while (rs.next()) {
			MouldLog ml = new MouldLog();
			ml.setId(rs.getInt("id"));
			ml.setMouldLogCode(rs.getString("mould_log_code"));
			ml.setMouldLogName(rs.getString("mould_log_name"));
			ml.setMouldLogContext(rs.getString("mould_log_context"));
			ml.setMouldLogCreateTime(rs.getTimestamp("mould_log_create_time"));
			ml.setMouldLogStatus(rs.getString("mould_log_status"));
			ml.setMouldPlanTimes(rs.getInt("mould_plan_times"));
			ml.setMouldRealTimes(rs.getInt("mould_real_times"));
			ml.setMouldId(rs.getInt("mould_id"));
			result.add(ml);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectMouldLogCount() throws SQLException {
		StringBuffer sql = new StringBuffer("SELECT count(1) from mep_mould_log where 1=1");
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		int index = 1;
		if (rs.next()) {
			index = rs.getInt(1);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return index;
	}

	@Override
	public MouldLog selectMoulodLogById(int id) throws SQLException {
		String sql = "select id,mould_log_code,mould_log_name,mould_log_context,mould_plan_times,mould_real_times,mould_log_create_time,mould_log_status,mould_id FROM mep_molud_log where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		MouldLog ml = null;
		if (rs.next()) {
			ml = new MouldLog();
			ml.setId(rs.getInt("id"));
			ml.setMouldLogCode(rs.getString("mould_log_code"));
			ml.setMouldLogName(rs.getString("mould_log_name"));
			ml.setMouldLogContext(rs.getString("mould_log_context"));
			ml.setMouldLogCreateTime(rs.getTimestamp("mould_log_create_time"));
			ml.setMouldLogStatus(rs.getString("mould_log_status"));
			ml.setMouldPlanTimes(rs.getInt("mould_plan_times"));
			ml.setMouldRealTimes(rs.getInt("mould_real_times"));
			ml.setMouldId(rs.getInt("mould_id"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return ml;
	}

	@Override
	public int updateMouldLog(MouldLog data) throws SQLException {
		String sql = "UPDATE mep_mould_log a INNER JOIN mep_mould b ON a.`mould_id` =b.`id` SET mould_log_context = ? , mould_real_times = (b.`mould_internal_times` +b.`mould_external_times`), mould_log_status = ? WHERE a.id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getMouldLogContext());
		ps.setString(2, data.getMouldLogStatus());
		ps.setInt(3, data.getId());
		int rtn = ps.executeUpdate();
		return rtn;
	}

}
