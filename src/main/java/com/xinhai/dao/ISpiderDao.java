package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.Equipment;
import com.xinhai.entity.Event;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldDevice;
import com.xinhai.entity.Warning;

public interface ISpiderDao {

	/**
	 * 存储预警信息
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param data
	 * @param isInit
	 * @return
	 * @throws SQLException
	 */
	public boolean insertWarning(List<Warning> data, boolean isInit) throws SQLException;

	/**
	 * 存储预警类型数据
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public boolean insertWarnType(List<Event> data) throws SQLException;

	/**
	 * 存储模具数据
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public boolean insertMould(List<Mould> data) throws SQLException;

	/**
	 * 查询全部的模具id数据
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @return
	 * @throws SQLException
	 */
	public List<String> selectMouldIdAll() throws SQLException;

	/**
	 * 删除模具信息
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param mouldId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteMouldDevice(int mouldId) throws SQLException;

	/**
	 * 保存模具设备关联信息
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public boolean insetrtMouldDevice(List<MouldDevice> data) throws SQLException;

	/**
	 * 保存机台信息
	 * 
	 * @author 黄官易
	 * @date 2018年5月30日
	 * @version 1.0
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public boolean insertEquipment(List<Equipment> data) throws SQLException;

}
