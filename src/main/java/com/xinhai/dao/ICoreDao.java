package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.WarningWithRule;

public interface ICoreDao {
	/*
	 * 预警部分
	 */
	// 获得预警信息（预警推送用）
	public List<WarningWithRule> selWarningPush() throws SQLException;

	// 更新预警信息推送等级
	public boolean uptWarningPush(String guid, String readStatus) throws SQLException;

	// 查询当前等级的所有员工token字符串
	public String selUserTokenByLevel(int level) throws SQLException;

	// ----------------------------------------------------------------------------//

}
