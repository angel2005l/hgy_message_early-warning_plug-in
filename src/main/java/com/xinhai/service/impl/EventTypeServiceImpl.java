package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.base.BaseResult;
import com.xinhai.dao.IEventTypeDao;
import com.xinhai.dao.impl.EventTypeDaoImpl;
import com.xinhai.entity.Event;
import com.xinhai.service.IEventTypeService;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public class EventTypeServiceImpl extends BaseResult implements IEventTypeService {
	private IEventTypeDao dao = new EventTypeDaoImpl();
	private static final Logger log = LoggerFactory.getLogger(EventTypeServiceImpl.class);

	@Override
	public Page<Event> selWarnTypePageWithCount(String page) throws Exception {
		try {
			List<Event> selectEvent = dao.selectEvent(Integer.parseInt(page));
			int countNum = dao.selectEventCount();
			return new Page<Event>(10, countNum, Integer.parseInt(page), selectEvent);
		} catch (SQLException e) {
			log.error("查询预警类别数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	// 预警类别
	@Override
	public Result<Object> insWarnType(Event data) throws Exception {
		try {
			return dao.insertEvent(data) > 0 ? rtnSuccessResult("添加预警类别成功")
					: rtnFailResult(Result.ERROR_4000, "添加预警类别失败");
		} catch (SQLException e) {
			log.error("添加预警类别数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "添加预警类别数据接口异常");
		}
	}

	@Override
	public Result<Object> uptWarnTypeWithRuleCode(String ruleCode, String id) throws Exception {
		try {
			return dao.updateEventWithRuleCode(ruleCode, Integer.parseInt(id)) >= 0 ? rtnSuccessResult("更新预警类别成功")
					: rtnFailResult(Result.ERROR_4000, "更新预警类别失败");
		} catch (SQLException e) {
			log.error("更新预警类别数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "更新预警类别数据接口异常");
		}
	}

	@Override
	public Result<Object> uptBatchWarnTypeWithRuleCode(String ruleCode, String[] eventCodes) throws Exception {
		try {
			return dao.updateBatchEventWithRuleCode(ruleCode, eventCodes) > 0 ? rtnSuccessResult("更新预警类别成功")
					: rtnFailResult(Result.ERROR_4000, "更新预警类别失败");
		} catch (SQLException e) {
			log.error("更新预警类别数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "更新预警类别数据接口异常");
		}
	}

	@Override
	public Result<Object> updateWarnTypeWithEventStatus(String eventStatus, String id) throws Exception {
		try {
			return dao.updateEventWithEventStatus(eventStatus, Integer.parseInt(id)) >= 0 ? rtnSuccessResult("更新预警类别成功")
					: rtnFailResult(Result.ERROR_4000, "更新预警类别失败");
		} catch (SQLException e) {
			log.error("更新预警类别数据接口异常,异常原因:" + e.toString());
			return rtnErrorResult(Result.ERROR_6000, "更新预警类别数据接口异常");
		}
	}

	@Override
	public List<Map<String, String>> selWarnTypeKV() throws Exception {
		try {
			return dao.selectEventKV();
		} catch (SQLException e) {
			log.error("查询预警类别键值对数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public Event selWarnById(String id) throws Exception {
		try {
			return dao.selectWarnById(Integer.parseInt(id));
		} catch (SQLException e) {
			log.error("查询特定预警类别数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}
}
