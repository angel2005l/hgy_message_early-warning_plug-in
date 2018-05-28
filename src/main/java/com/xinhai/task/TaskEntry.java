package com.xinhai.task;

import java.util.TimerTask;

public class TaskEntry extends TimerTask {
	// 提供定时操作接口

//	private ITaskService service = new TaskServiceImpl();
//
//	@Override
//	public void run() {
//		// 防止线程阻塞 加入同步锁
//		// synchronized (this) {
//		//
//		// }
//		System.err.println("调度任务开始");
//		List<Task> selTask;
//		try {
//			selTask = service.selTask();
//
//			for (Task task : selTask) {
//				runningTask(task);
//			}
//		} catch (SQLException e) {
//			System.err.println("获取调度任务列表失败");
//		}
//	}

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
//	private void runningTask(Task task) {
//		Calendar calendar = Calendar.getInstance();
//		// 当前系统时间
//		calendar.setTime(task.getTaskLastExecuteTime());
//		calendar.add(Calendar.SECOND, task.getTaskTime());
//		// 下一次的执行时间
//		long nextExecuteTime = calendar.getTimeInMillis();
//		long nowTime = System.currentTimeMillis();
//		if (nowTime - nextExecuteTime < 0) {
//			return;
//		}
//		System.err.println("调度任务【" + task.getTaskName() + "】---开始执行");
//		try {
//			service.uptLastTimeTask(new Timestamp(nowTime), task.getTaskCode());
//			switch (task.getTaskCode()) {
//			case "task_warning":
//				new TaskWarning();
//				break;
//			case "task_equipment":
//				new TaskEquipment();
//				break;
//			case "task_safe":
//				new TaskSafeWarning();
//				break;
//			case "task_mould":
//				new TaskMould();
//				break;
//			case "task_mould_device":
//				new TaskMouldDevice();
//				break;
//			default:
//				break;
//			}
//		} catch (SQLException e) {
//			System.err.println("调度任务数据库操作失败");
//		} catch (Exception e) {
//			System.err.println("调度任务网络影响 失败");
//		} finally {
//			System.err.println("调度任务结束");
//		}
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
