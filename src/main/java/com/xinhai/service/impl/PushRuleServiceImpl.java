package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.base.BaseResult;
import com.xinhai.dao.IPushRuleDao;
import com.xinhai.dao.impl.PushRuleDaoImpl;
import com.xinhai.entity.PushRule;
import com.xinhai.service.IPushRuleService;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public class PushRuleServiceImpl extends BaseResult implements IPushRuleService {
	private IPushRuleDao dao = new PushRuleDaoImpl();
	private static final Logger log = LoggerFactory.getLogger(PushRuleServiceImpl.class);

	@Override
	public Page<PushRule> selPushRulePageWithCount(String page) throws Exception {
		try {
			List<PushRule> selectPushRule = dao.selectPushRule();
			int countNum = dao.selectPushRuleCount();
			return new Page<PushRule>(10, countNum, Integer.parseInt(page), selectPushRule);
		} catch (SQLException e) {
			log.error("查询推送规则数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public PushRule selPushRuleById(String id) throws Exception {
		try {
			return dao.selectPushRuleById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定推送规则数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> insPushRule(PushRule data) throws Exception {
		try {
			return dao.insertPushRule(data) > 0 ? rtnSuccessResult("添加推送规则成功")
					: rtnFailResult(Result.ERROR_4000, "添加推送规则失败");
		} catch (SQLException e) {
			log.error("添加推送规则数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "添加推送规则数据接口异常");
		}
	}

	@Override
	public Result<Object> uptPushRule(PushRule data) throws Exception {
		try {
			return dao.updatePushRule(data) >= 0 ? rtnSuccessResult("更新推送规则成功")
					: rtnFailResult(Result.ERROR_4000, "更新推送规则失败");
		} catch (SQLException e) {
			log.error("更新推送规则数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "更新推送规则数据接口异常");
		}
	}

	@Override
	public Result<Object> delPusgRule(String id) throws Exception {
		try {
			return dao.deletePushRule(Integer.parseInt(id)) > 0 ? rtnSuccessResult("删除推送规则成功")
					: rtnFailResult(Result.ERROR_4000, "删除推送规则失败");
		} catch (SQLException e) {
			log.error("删除推送规则数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "删除推送规则数据接口异常");
		}
	}

	@Override
	public List<Map<String, String>> selPushRuleKV() throws Exception {
		try {
			return dao.selectPushRuleKV();
		} catch (SQLException e) {
			log.error("查询推送规则键值对数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

}
