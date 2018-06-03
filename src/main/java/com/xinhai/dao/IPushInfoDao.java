package com.xinhai.dao;

import java.sql.SQLException;
import java.util.Map;

import com.xinhai.entity.Warning;

public interface IPushInfoDao {
	public Warning selectWarn(String guid) throws SQLException;

	public Map<String, Object> selectWarnWeek() throws SQLException;

	public Map<String, Object> selectWarnMonth() throws SQLException;
}
