package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.Warning;

public interface ISpiderDao {

	// 存储预警信息
	public boolean insertWarning(List<Warning> data) throws SQLException;

	
	
}
