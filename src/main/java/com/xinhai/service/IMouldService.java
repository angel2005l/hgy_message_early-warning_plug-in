package com.xinhai.service;

import java.util.List;
import java.util.Map;

import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public interface IMouldService {

	// 模具
	// 查询所有的模具信息 及其保养规则
//	public List<MouldWithRule> selMouldWithRule() throws Exception;

	public Page<Mould> selMouldPageWithCount(String mouldName,String page) throws Exception;

	public Mould selMouldById(String id) throws Exception;

	public Result<Object> uptMouldPushRuleCodeWithId(String id, String mouldRuleCode, String pushRuleCode) throws Exception;

	public Result<Object> uptMouldPushRuleCodeWithIds(String[] ids, String mouldRuleCode, String pushRuleCode) throws Exception;

	public List<Map<String, String>> selMouldKV() throws Exception;

	// 模具规则部分
	// 增加规则
	public Result<Object> insMouldRule(MouldRule data) throws Exception;

	// 查询规则
	public Page<MouldRule> selMouldRulePageWithCount(String mouldRuleName,String page) throws Exception;

	// 查询特定规则
	public MouldRule selMouldRuleById(String id) throws Exception;

	// 更新规则
	public Result<Object> uptMouldRule(MouldRule data) throws Exception;

	// 删除规则
	public Result<Object> delMouldRule(String id) throws Exception;

	public List<Map<String, String>> selMouldRuleKV() throws Exception;

	// 模具日志部分
	// 根据mould_id 查询最新的一条日志
	public MouldLog selMouldLogByMouldId(String mouldId) throws Exception;

	// 生成一条记录
	public Result<Object> insMouldLog(MouldLog data) throws Exception;

	// 查询记录 分页
	public Page<MouldLog> selMouldLogPageWithCount(String mouldLogCode,String page) throws Exception;

	// 查询特定记录 byid
	public MouldLog selMouldLogById(String id) throws Exception;

	// 更新记录
	public Result<Object> uptMouldLog(MouldLog data) throws Exception;

}
