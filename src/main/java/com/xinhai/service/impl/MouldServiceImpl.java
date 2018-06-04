package com.xinhai.service.impl;

import java.util.List;
import java.util.Map;

import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.entity.MouldWithRule;
import com.xinhai.service.IMouldService;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public class MouldServiceImpl implements IMouldService {

	@Override
	public List<MouldWithRule> selMouldWithRule() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Mould> selMouldPageWithCount(String page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mould selMouldById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptMouldRuleCodeWithId(String id, String mouldRuleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptMouldRuleCodeWithIds(String[] ids, String mouldRuleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Map<String, String>> selMouldKV() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> insMouldRule(MouldRule data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MouldRule> selMouldRule(String page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouldRule selMouldRuleById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptMould(MouldRule data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> delMould(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> selMouldRuleKV() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouldLog selMouldLogByMouldId(String mouldId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> insMouldLog(MouldLog data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MouldLog> selMouldLog(String page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouldLog selMouldLogById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Object> uptMouldLog() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
