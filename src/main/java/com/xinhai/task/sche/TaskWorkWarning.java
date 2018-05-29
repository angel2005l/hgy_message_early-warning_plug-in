package com.xinhai.task.sche;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.service.ICoreService;
import com.xinhai.service.impl.CoreServiceImpl;

public class TaskWorkWarning {
	private static final Logger log = LoggerFactory.getLogger(TaskWorkWarning.class);

	public TaskWorkWarning() {
		ICoreService service = new CoreServiceImpl();
		try {
			service.warningPush();
		} catch (Exception e) {
			log.error("预警消息推送异常,异常原因:" + e.getMessage());
		}
	}
}
