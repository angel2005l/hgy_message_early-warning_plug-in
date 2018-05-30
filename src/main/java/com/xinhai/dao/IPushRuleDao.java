package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.PushRule;

public interface IPushRuleDao {
	/**
	 * 
	 * @Title: selectPushRule   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: List<PushRule>
	 *
	 */
	public List<PushRule> selectPushRule() throws SQLException;

	/**
	 * 
	 * @Title: selectPushRuleCount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int selectPushRuleCount() throws SQLException;

	/**
	 * 
	 * @Title: selectPushRuleById   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param id
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: PushRule
	 *
	 */
	public PushRule selectPushRuleById(int id) throws SQLException;

	/**
	 * 
	 * @Title: insertPushRule   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int insertPushRule(PushRule data) throws SQLException;

	/**
	 * 
	 * @Title: updatePushRule   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int updatePushRule(PushRule data) throws SQLException;

	/**
	 * 
	 * @Title: deletePushRule   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param id
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int deletePushRule(int id) throws SQLException;

}
