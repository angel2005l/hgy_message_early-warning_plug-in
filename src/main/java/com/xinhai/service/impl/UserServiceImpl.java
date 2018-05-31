package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.base.BaseResult;
import com.xinhai.dao.IUserDao;
import com.xinhai.dao.impl.UserDaoImpl;
import com.xinhai.entity.User;
import com.xinhai.service.IUserService;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public class UserServiceImpl extends BaseResult implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private IUserDao dao = new UserDaoImpl();

	@Override
	public Page<User> selUserpageWithCount(String page) throws Exception {
		try {
			List<User> userObj = dao.selectUser();
			int countNum = dao.selectUserCount();
			return new Page<User>(10, countNum, Integer.parseInt(page), userObj);
		} catch (SQLException e) {
			log.error("查询用户信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<User> selUserById(String id) throws Exception {

		try {
			User selectUserById = dao.selectUserById(Integer.parseInt(id));
			return null == selectUserById ? rtnSuccessResult("", selectUserById)
					: rtnFailResult(Result.ERROR_4300, "无效的id信息");
		} catch (SQLException e) {
			log.error("查询特定用户信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "查询用户完成数据接口异常");
		}
	}

	@Override
	public Result<Object> insUser(User data) throws Exception {
		try {
			return dao.insertUser(data) > 0 ? rtnSuccessResult("添加用户成功") : rtnFailResult(Result.ERROR_4000, "添加用户失败");
		} catch (SQLException e) {
			log.error("添加用户信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "添加用户信息数据接口异常");
		}
	}

	@Override
	public Result<Object> uptUser(User data) throws Exception {
		try {
			return dao.updateUser(data) >= 0 ? rtnSuccessResult("更新用户信息成功")
					: rtnFailResult(Result.ERROR_4000, "更新用户信息失败");
		} catch (SQLException e) {
			log.error("更新用户信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "更新用户信息数据接口异常");
		}
	}

	@Override
	public Result<Object> delUser(String id) throws Exception {
		try {
			return dao.deleteUser(Integer.parseInt(id)) > 0 ? rtnSuccessResult("删除用户成功")
					: rtnFailResult(Result.ERROR_4000, "删除用户失败");
		} catch (SQLException e) {
			log.error("删除用户信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "删除用户信息数据接口异常");
		}
	}

	@Override
	public Result<Object> uptUserIsWork(String isWork, String id) throws Exception {
		try {
			String msg = ("Y".equals(isWork) ? "上班" : "下班") + "签到成功";

			return dao.updateUserIsWord(isWork, Integer.parseInt(id)) > 0 ? rtnSuccessResult(msg)
					: rtnFailResult(Result.ERROR_4000, msg);
		} catch (SQLException e) {
			log.error("上下班签到数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "上下班签到数据接口异常");
		}
	}

	@Override
	public Result<Object> insBatch(List<User> data) throws Exception {
		try {
			return dao.insertUserBatch(data) > 0 ? rtnSuccessResult("批量添加用户成功,共添加" + data.size() + "条数据")
					: rtnFailResult(Result.ERROR_4000, "批量添加用户失败");
		} catch (SQLException e) {
			log.error("批量添加用户信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "批量添加用户信息数据接口异常");
		}
	}

}
