package com.xinhai.listener;

import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.task.TaskDataEntry;
import com.xinhai.task.TaskWorkEntry;

public class SchedulingJobsListener implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(SchedulingJobsListener.class);
	private Timer timer = null;
	private Timer workTimer = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			timer = new Timer(true);
			workTimer = new Timer(true);
			sce.getServletContext().log("【初始化----调度任务】");
			// 默认30秒执行一次
			timer.schedule(new TaskDataEntry(),new Date(), 1000 * 30);
			workTimer.schedule(new TaskWorkEntry(),new Date(), 1000 * 30);
		} catch (Exception e) {
			log.error("调度任务监听类异常,异常原因:" + e.toString());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().log("【销毁----调度任务】");
		timer.cancel();
		workTimer.cancel();
	}

}
