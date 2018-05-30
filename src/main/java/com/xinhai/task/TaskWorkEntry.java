package com.xinhai.task;

import java.net.ConnectException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.entity.Task;
import com.xinhai.service.ITaskService;
import com.xinhai.service.impl.TaskServiceImpl;
import com.xinhai.task.sche.TaskWorkWarning;
import com.xinhai.util.DateUtil;

public class TaskWorkEntry extends TimerTask {

	private static final Logger log = LoggerFactory.getLogger(TaskDataEntry.class);
	private ITaskService service = new TaskServiceImpl();

	@Override
	public void run() {
		// 防止线程阻塞 加入同步锁
		// synchronized (this) {
		//
		// }
		log.info("【业务调度任务开始执行】--执行时间【" + DateUtil.curDateYMDHMS() + "】");
		try {
			List<Task> selectTaskAll = service.seListWorkTaskAll();
			for (Task task : selectTaskAll) {
				runningTask(task);
			}
		} catch (Exception e) {
			log.info("【业务调度任务异常】,异常原因:" + e.getMessage());
		} finally {
			log.info("【业务调度任务结束】");
		}
	}

	/**
	 * 
	 * @Title: runningTask
	 * @Description: 执行方法
	 * @param task
	 * @return void
	 * @author 黄官易
	 * @throws Exception
	 * @date 2018.04.24
	 */
	private void runningTask(Task task) {
		long nextExecuteTime = 0;
		long nowTime = System.currentTimeMillis();
		try {
			Calendar calendar = Calendar.getInstance();
			// 分为 每日一次 和每日循环
			switch (task.getTaskRunType()) {
			case "once":
				nextExecuteTime = DateUtil.curTimestampByStr(DateUtil.curDateYMD() + " " + task.getTaskTimming())
						.getTime();
				if (nowTime - nextExecuteTime < 0) {
					return;
				} else {
					if (task.getTaskLastExecuteTime().getTime() - nextExecuteTime >= 0) {
						return;
					}
				}
				break;
			case "cont":
				// 当前系统时间
				calendar.setTime(task.getTaskLastExecuteTime());
				calendar.add(Calendar.SECOND, task.getTaskTime());

				// 下一次的执行时间
				nextExecuteTime = calendar.getTimeInMillis();
				if (nowTime - nextExecuteTime < 0) {
					return;
				}
				break;
			default:
				break;
			}
			service.uptTaskLastExecuteTime(new Timestamp(nowTime), task.getTaskCode());
			log.info("业务调度任务【" + task.getTaskName() + "】---开始执行");
			switch (task.getTaskCode()) {
			case "task_w_warning":
				new TaskWorkWarning();
				break;
			default:
				break;
			}
			log.info("业务调度任务【" + task.getTaskName() + "】---执行结束");
		} catch (ConnectException e) {
			log.error("业务调度任务网络异常,异常原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("业务调度任务异常,异常原因:" + e.getMessage());
		}
	}
}
