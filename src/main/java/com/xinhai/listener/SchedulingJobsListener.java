package com.xinhai.listener;

import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xinhai.task.TaskEntry;

public class SchedulingJobsListener implements ServletContextListener {
	private Timer timer = null;
	private Timer workTimer = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			timer = new Timer(true);
			sce.getServletContext().log("【初始化----调度任务】");
			// 默认30秒执行一次
			timer.schedule(new TaskEntry(), new Date(), 1000 * 30);
			workTimer.schedule(new TaskEntry(), new Date(), 1000 * 30);

		} catch (Exception e) {
			System.err.println("异常捕获");
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().log("【销毁----调度任务】");
		timer.cancel();
		workTimer.cancel();
	}

}
