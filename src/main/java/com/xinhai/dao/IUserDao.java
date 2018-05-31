package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;

import com.xinhai.entity.User;

public interface IUserDao {
	/**
	 * 
	 * @Title: selUser
	 * @Description: 查询通知员工信息
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: List<User>
	 *
	 */
	public List<User> selectUser() throws SQLException;

	/**
	 * 
	 * @Title: selUserCount
	 * @Description: 附带查询数据行数
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int selectUserCount() throws SQLException;

	/**
	 * 
	 * @Title: selUserById
	 * @Description: 根据id查询员工数据
	 * @param id
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: User
	 *
	 */
	public User selectUserById(int id) throws SQLException;

	/**
	 * 
	 * @Title: insertUser
	 * @Description: 插入员工信息
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int insertUser(User data) throws SQLException;

	/**
	 * 
	 * @Title: insertUserBatch
	 * @Description: 批量插入员工信息 配合POI
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int insertUserBatch(List<User> data) throws SQLException;

	/**
	 * 
	 * @Title: updateUser
	 * @Description: 更新员工信息
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int updateUser(User data) throws SQLException;

	/**
	 * 
	 * @Title: deleteUser
	 * @Description: 删除员工信息
	 * @param data
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int deleteUser(int id) throws SQLException;

	/**
	 * 更新is_work状态 上下班
	 * 
	 * @author 黄官易
	 * @date 2018年5月31日
	 * @version 1.0
	 * @param workType
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int updateUserIsWord(String isWork, int id) throws SQLException;
}