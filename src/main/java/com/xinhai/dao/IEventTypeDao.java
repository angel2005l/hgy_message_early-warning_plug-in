package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xinhai.entity.Event;

public interface IEventTypeDao {
	public List<Event> selectEvent() throws SQLException;

	public int selectEventCount() throws SQLException;

	public int insertEvent(Event data) throws SQLException;

	// 更改规则
	public int updateEventWithRuleCode(String ruleCode, int id) throws SQLException;

	public int updateBatchEventWithRuleCode(String ruleCode, String[] eventCodes) throws SQLException;

	// 更新状态
	public int updateEventWithEventStatus(String eventStatus, int id) throws SQLException;

	public List<Map<String, String>> selectEventKV() throws SQLException;

	public Event selectWarnById(int id) throws SQLException;
}
