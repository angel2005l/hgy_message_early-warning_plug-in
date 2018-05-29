package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.Event;
import com.xinhai.entity.Warning;

public interface ISpiderDao {

	// 存储预警信息
	public boolean insertWarning(List<Warning> data, boolean isInit) throws SQLException;

	//存储预警类型数据
	public boolean insertWarnType(List<Event> data) throws SQLException;
	
	
}
