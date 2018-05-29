package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.Equipment;
import com.xinhai.entity.Event;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldDevice;
import com.xinhai.entity.Warning;

public interface ISpiderDao {

	// 存储预警信息
	public boolean insertWarning(List<Warning> data, boolean isInit) throws SQLException;

	// 存储预警类型数据
	public boolean insertWarnType(List<Event> data) throws SQLException;

	public boolean insertMould(List<Mould> data) throws SQLException;

	public List<String> selectMouldIdAll() throws SQLException;

	public boolean deleteMouldDevice(int mouldId) throws SQLException;

	public boolean insetrtMouldDevice(List<MouldDevice> data) throws SQLException;

	public boolean insertEquipment(List<Equipment> data) throws SQLException;

}
