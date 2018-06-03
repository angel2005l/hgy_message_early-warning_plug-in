package com.xinhai.service;

import com.xinhai.entity.Email;
import com.xinhai.entity.Warning;

public interface IPushInfoService {

	// 预警详情内容
	public Warning selWarnInfo(String guid) throws Exception;

	// 预警周统计
	public Email selWarnInfoWeek() throws Exception;

	// 预警月统计
	public Email selWarnInfoMonth() throws Exception;

}
