package com.xinhai.task.sche;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.service.ICoreService;
import com.xinhai.service.impl.CoreServiceImpl;

public class TaskWorkMould {
	private static final Logger log = LoggerFactory.getLogger(TaskWorkMould.class);

	public TaskWorkMould() {
		ICoreService service = new CoreServiceImpl();
		try {
			service.mouldPush();
		} catch (Exception e) {
			log.error("模具预警保养核心事务异常,异常原因:" + e.toString());
		}
	}
}
