package com.xinhai.service;

import java.util.List;

import com.xinhai.entity.Event;
import com.xinhai.entity.Warning;

public interface ISpiderService {

	/*
	 * 爬取数据
	 */

	// 预警爬取
	public boolean insWarning(List<Warning> data) throws Exception;

	// 预警类型
	public boolean insWarningType(List<Event> data) throws Exception;

	// 预警规则

	/*
	 * OEE部分
	 */

	// 模具数据

	// 模具

}
