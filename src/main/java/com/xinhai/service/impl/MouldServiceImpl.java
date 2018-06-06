package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.base.BaseResult;
import com.xinhai.dao.IMouldDao;
import com.xinhai.dao.impl.MouldDaoImpl;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.service.IMouldService;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public class MouldServiceImpl extends BaseResult implements IMouldService {
	private static final Logger log = LoggerFactory.getLogger(MouldServiceImpl.class);
	private IMouldDao dao = new MouldDaoImpl();

	// @Override
	// public List<MouldWithRule> selMouldWithRule() throws Exception {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public Page<Mould> selMouldPageWithCount(String mouldName,String page) throws Exception {
		try {
			List<Mould> selectMould = dao.selectMould(mouldName,Integer.parseInt(page));
			int countNum = dao.selectMouldCount(mouldName);
			return new Page<Mould>(10, countNum, Integer.parseInt(page), selectMould);
		} catch (SQLException e) {
			log.error("查询模具信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Mould selMouldById(String id) throws Exception {
		try {
			return dao.selectMouldById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定模具信息数据接口异常,异常原因:" + e.toString());
			return null;
		}

	}

	@Override
	public Result<Object> uptMouldPushRuleCodeWithId(String id, String mouldRuleCode, String pushRuleCode)
			throws Exception {
		try {
			return dao.updateMouldPushRuleCodeWithId(Integer.parseInt(id), mouldRuleCode, pushRuleCode) >= 0
					? rtnSuccessResult(
							"模具相关关联规则绑定成功") : rtnFailResult(Result.ERROR_4000, "模具相关关联规则绑定失败");
		} catch (SQLException e) {
			log.error("模具相关关联规则绑定数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "模具相关关联规则绑定数据接口异常");
		}
	}

	@Override
	public Result<Object> uptMouldPushRuleCodeWithIds(String[] ids, String mouldRuleCode, String pushRuleCode)
			throws Exception {

		try {
			return dao.updateMouldPushRuleCodeWithIds(ids, mouldRuleCode, pushRuleCode) >= 0
					? rtnSuccessResult(
							"模具相关关联规则批量修改成功") : rtnFailResult(Result.ERROR_4000, "模具相关关联规则批量修改失败");
		} catch (SQLException e) {
			log.error("模具相关关联规则批量修改数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "模具相关关联规则批量修改数据接口异常");
		}
	}

	@Override
	public List<Map<String, String>> selMouldKV() throws Exception {
		try {
			return dao.selectMouldKV();
		} catch (SQLException e) {
			log.error("查询模具键值对数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> insMouldRule(MouldRule data) throws Exception {
		try {
			return dao.insertMouldRule(data) > 0 ? rtnSuccessResult("模具保养规则添加成功")
					: rtnFailResult(Result.ERROR_4000, "模具保养规则添加失败");
		} catch (SQLException e) {
			log.error("模具保养规则添加数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "模具保养规则添加数据接口异常");
		}
	}

	@Override
	public Page<MouldRule> selMouldRulePageWithCount(String mouldRuleName,String page) throws Exception {
		try {
			List<MouldRule> selectMouldRule = dao.selectMouldRule(mouldRuleName ,Integer.parseInt(page));
			int countNum = dao.selectMouldRuleCount(mouldRuleName);
			return new Page<MouldRule>(10, countNum, Integer.parseInt(page), selectMouldRule);
		} catch (SQLException e) {
			log.error("查询模具保养规则信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public MouldRule selMouldRuleById(String id) throws Exception {

		try {
			return dao.selectMouldRuleById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定模具保养规则信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> uptMouldRule(MouldRule data) throws Exception {
		try {
			return dao.updateMouldRule(data) >= 0 ? rtnSuccessResult("修改模具保养规则信息成功")
					: rtnFailResult(Result.ERROR_4000, "修改模具保养规则信息失败");
		} catch (SQLException e) {
			log.error("修改模具保养规则信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> delMouldRule(String id) throws Exception {
		try {
			return dao.deleteMouldRule(Integer.parseInt(id)) > 0 ? rtnSuccessResult("删除模具保养规则信息成功")
					: rtnFailResult(Result.ERROR_4000, "删除模具保养规则信息失败");
		} catch (SQLException e) {
			log.error("删除模具保养规则信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "删除模具保养规则信息数据接口异常");
		}
	}

	@Override
	public List<Map<String, String>> selMouldRuleKV() throws Exception {
		try {
			return dao.selectMouldRuleKV();
		} catch (SQLException e) {
			log.error("模具保养规则键值对数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public MouldLog selMouldLogByMouldId(String mouldId) throws Exception {
		try {
			return dao.selectMouldLogByMouldId(Integer.parseInt(mouldId));
		} catch (SQLException e) {
			log.error("根据模具id查询最新保养日志数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> insMouldLog(MouldLog data) throws Exception {
		try {
			return dao.insertMouldLog(data) > 0 ? rtnSuccessResult("添加保养日志信息成功")
					: rtnFailResult(Result.ERROR_4000, "添加保养日志信息失败");
		} catch (SQLException e) {
			log.error("添加保养日志信息数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "添加保养日志信息数据接口异常");
		}
	}

	@Override
	public Page<MouldLog> selMouldLogPageWithCount(String mouldLogCode,String page) throws Exception {
		try {
			List<MouldLog> selectMouldLog = dao.selectMouldLog(mouldLogCode,Integer.parseInt(page));
			int countNum = dao.selectMouldLogCount(mouldLogCode);
			return new Page<MouldLog>(10, countNum, Integer.parseInt(page), selectMouldLog);
		} catch (SQLException e) {
			log.error("查询保养日志信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public MouldLog selMouldLogById(String id) throws Exception {
		try {
			return dao.selectMoulodLogById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定保养日志信息数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Result<Object> uptMouldLog(MouldLog data) throws Exception {
		try {
			return dao.updateMouldLog(data) >= 0 ? rtnSuccessResult("确认保养日志成功")
					: rtnFailResult(Result.ERROR_4000, "确认保养日志失败");
		} catch (SQLException e) {
			log.error("确认特定保养日志数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "确认保养日志数据接口异常");
		}
	}

}
