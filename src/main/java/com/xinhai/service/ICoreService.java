package com.xinhai.service;

import java.util.List;
import java.util.Map;

public interface ICoreService {
	// 主要涉及的推送
	public void warningPush() throws Exception;

	public void mouldPush() throws Exception;

	// OEE
	public List<Map<String, Object>> selOEEInfoALL() throws Exception;

	// 车间面板

}
