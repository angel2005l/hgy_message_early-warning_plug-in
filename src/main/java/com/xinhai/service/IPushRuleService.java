package com.xinhai.service;

import java.util.List;
import java.util.Map;

import com.xinhai.entity.PushRule;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public interface IPushRuleService {

	public Page<PushRule> selPushRulePageWithCount(String ruleName,String page) throws Exception;

	public PushRule selPushRuleById(String id) throws Exception;

	public Result<Object> insPushRule(PushRule data) throws Exception;

	public Result<Object> uptPushRule(PushRule data) throws Exception;

	public Result<Object> delPusgRule(String id) throws Exception;

	public List<Map<String, String>> selPushRuleKV() throws Exception;

}
