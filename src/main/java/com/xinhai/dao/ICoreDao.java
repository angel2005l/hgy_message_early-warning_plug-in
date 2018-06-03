package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xinhai.entity.WarningWithRule;

public interface ICoreDao {
	/*
	 * 预警部分
	 */
	// 获得预警信息（预警推送用）
	public List<WarningWithRule> selectWarningPush() throws SQLException;

	// 更新预警信息推送等级
	public boolean updateWarningPush(String guid, String readStatus) throws SQLException;

	// 查询当前等级的所有员工token字符串
	public String selectUserTokenByLevel(int level) throws SQLException;

	public String selectUserEmailByLevel(int level) throws SQLException;

	// ----------------------------------------------------------------------------//

	/*
	 * OEE总产效率
	 */
	public List<Map<String, Object>> selectOEE() throws SQLException;

	public List<Map<String, Object>> selectWarnDay() throws SQLException;

	/*
	 * 主页面板
	 */
	public List<String[]> selectWarn7Day() throws SQLException;

	public List<Map<String, String>> selectEquProduceType() throws SQLException;

	public List<Map<String, String>> selectWarnWeekTop5() throws SQLException;

}
