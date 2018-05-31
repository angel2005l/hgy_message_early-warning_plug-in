package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.IUserDao;
import com.xinhai.entity.User;
import com.xinhai.util.SqlPoolUtil;

public class UserDaoImpl implements IUserDao {

	SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public List<User> selectUser() throws SQLException {
		StringBuffer sql = new StringBuffer(
				"select id,user_code,user_name,user_token,user_email,user_phone,user_level,is_work,user_status from mep_user where 1=1");
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List<User> result = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserCode(rs.getString("user_code"));
			user.setUserName(rs.getString("user_name"));
			user.setUserToken(rs.getString("user_token"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserPhone(rs.getString("user_phone"));
			user.setUserLevel(rs.getInt("user_level"));
			user.setIsWork(rs.getString("is_work"));
			user.setUserStatus(rs.getString("user_status"));
			result.add(user);
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return result;
	}

	@Override
	public int selectUserCount() throws SQLException {
		String sql = "select count(1) from mep_user where 1=1 ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return count;
	}

	@Override
	public User selectUserById(int id) throws SQLException {
		String sql = "select id,user_code,user_name,user_token,user_email,user_phone,user_level,is_work,user_status from mep_user where id =?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUserCode(rs.getString("user_code"));
			user.setUserName(rs.getString("user_name"));
			user.setUserToken(rs.getString("user_token"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserPhone(rs.getString("user_phone"));
			user.setUserLevel(rs.getInt("user_level"));
			user.setIsWork(rs.getString("is_work"));
			user.setUserStatus(rs.getString("user_status"));
		}
		SqlPoolUtil.closeConnection(conn, ps, rs);
		return user;
	}

	@Override
	public int insertUser(User data) throws SQLException {
		String sql = "insert into mep_user(user_code,user_name,user_token,user_email,user_phone,user_level,is_work,user_status) values(?,?,?,?,?,?,?,?)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getUserCode());
		ps.setString(2, data.getUserName());
		ps.setString(3, data.getUserToken());
		ps.setString(4, data.getUserEmail());
		ps.setString(5, data.getUserPhone());
		ps.setInt(6, data.getUserLevel());
		ps.setString(7, data.getIsWork());
		ps.setString(8, data.getUserStatus());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int insertUserBatch(List<User> data) throws SQLException {
		String sql = "insert into mep_user(user_code,user_name,user_token,user_email,user_phone,user_level,is_work,user_status) values(?,?,?,?,?,?,?,?)";
		boolean isSuccess = true;
		DruidPooledConnection conn = instance.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			for (User user : data) {
				ps.setString(1, user.getUserCode());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getUserToken());
				ps.setString(4, user.getUserEmail());
				ps.setString(5, user.getUserPhone());
				ps.setInt(6, user.getUserLevel());
				ps.setString(7, "N");
				ps.setString(8, "1");
				if (ps.executeUpdate() < 1) {
					isSuccess = false;
					break;
				}
			}
			conn.commit();
			if (isSuccess) {
				return 1;
			} else {
				conn.rollback();
				return 0;
			}
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			SqlPoolUtil.closeConnection(conn, ps, null);
		}

	}

	@Override
	public int updateUser(User data) throws SQLException {
		String sql = "update mep_user set user_token=?,user_email=?,user_phone=?,user_level=?,user_status=? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, data.getUserToken());
		ps.setString(2, data.getUserEmail());
		ps.setString(3, data.getUserPhone());
		ps.setInt(4, data.getUserLevel());
		ps.setString(5, data.getUserStatus());
		ps.setInt(6, data.getId());
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int deleteUser(int id) throws SQLException {
		String sql = "delete from mep_user where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

	@Override
	public int updateUserIsWord(String isWork, int id) throws SQLException {
		String sql = "update mep_user set is_work=? where id = ?";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, isWork);
		ps.setInt(2, id);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn;
	}

}
