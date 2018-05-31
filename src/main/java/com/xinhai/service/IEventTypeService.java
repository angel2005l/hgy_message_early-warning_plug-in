package com.xinhai.service;

import java.util.List;
import java.util.Map;

import com.xinhai.entity.Event;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public interface IEventTypeService {

	public Page<Event> selWarnTypePageWithCount(String page) throws Exception;

	public Result<Object> insWarnType(Event data) throws Exception;

	public Result<Object> uptWarnTypeWithRuleCode(String ruleCode, String id) throws Exception;

	public Result<Object> uptBatchWarnTypeWithRuleCode(String ruleCode, String[] eventCodes) throws Exception;

	public Result<Object> updateWarnTypeWithEventStatus(String eventStatus, String id) throws Exception;

	public List<Map<String, String>> selWarnTypeKV() throws Exception;

}
