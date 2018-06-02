package com.xinhai.service;

import java.util.List;
import java.util.Map;

public interface ICoreService {
	// 主要涉及的推送
	public void warningPush() throws Exception;

	public void mouldPush() throws Exception;

	// OEE
	public List<Object[]> selOEEInfoALL() throws Exception;

	public List<Map<String, Object>> selWarnDay() throws Exception;

	// 主页数据
	public List<String[]> selWarn7Day() throws Exception;

	public List<Map<String,String>> selEquProduceType() throws Exception;

	public List<Map<String,String>> selWarnWeekTop5() throws Exception;

	// 车间面板

}
