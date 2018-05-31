package com.xinhai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xinhai.entity.Task;
import com.xinhai.service.ITaskService;
import com.xinhai.service.impl.TaskServiceImpl;
import com.xinhai.util.Page;
import com.xinhai.util.Result;
import com.xinhai.util.StrUtil;

public class TaskController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);

	private ITaskService service = new TaskServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");

		switch (mod) {
		case "task_ins":
			insTask(req, resp);
			break;
		case "task_sel":
			selTask(req, resp);
			break;
		case "task_sel_id":
			selTaskById(req, resp);
			break;
		case "task_upt":
			uptTask(req, resp);
			break;
		case "task_del":
			delTask(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	private void insTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String taskCode = request.getParameter("taskCode");
		String taskName = request.getParameter("taskName");
		String taskType = request.getParameter("taskType");
		String taskRunType = request.getParameter("taskRunType");
		String taskTimeStr = request.getParameter("taskTime");
		int taskTime = StrUtil.isBlank(request.getParameter("taskTimeStr")) && "once".equals(taskRunType) ? 0
				: Integer.parseInt(taskTimeStr);
		String taskTiming = request.getParameter("taskTiming");
		String status = request.getParameter("status");
		String json = "";

		Task data = new Task();
		data.setTaskCode(taskCode);
		data.setTaskName(taskName);
		data.setTaskType(taskType);
		data.setTaskRunType(taskRunType);
		data.setTaskTime(taskTime);
		data.setTaskTiming(taskTiming);
		data.setStatus(status);
		try {
			json = JSON.toJSONString(service.insTask(data) ? new Result<Object>(Result.SUCCESS_0, "添加调度任务成功")
					: new Result<Object>(Result.ERROR_4000, "添加调度任务失败"));
		} catch (Exception e) {
			log.error("添加调度任务异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "添加调度任务异常"));
		}
		returnData(json, response);
	}

	private void selTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String taskName = request.getParameter("taskName");

		String page = request.getParameter("page");

		Page<Task> selTaskPageWithCount;
		try {
			selTaskPageWithCount = service.selTaskPageWithCount(taskName, StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selTaskPageWithCount);
		} catch (Exception e) {
			log.error("查询调度任务异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/task/index.jsp").forward(request, response);
	}

	private void selTaskById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String id = request.getParameter("id");
		try {
			Task selTaskById = service.selTaskById(id);
			request.setAttribute("data", selTaskById);
		} catch (Exception e) {
			log.error("查询特定调度任务异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/task/editLayer.jsp").forward(request, response);
	}

	private void uptTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String taskName = request.getParameter("taskName");
		String taskType = request.getParameter("taskType");
		String taskRunType = request.getParameter("taskRunType");
		String taskTimeStr = request.getParameter("taskTime");
		int taskTime = StrUtil.isBlank(request.getParameter("taskTimeStr")) && "once".equals(taskRunType) ? 0
				: Integer.parseInt(taskTimeStr);
		String taskTiming = request.getParameter("taskTiming");
		String status = request.getParameter("status");
		String json = "";

		Task data = new Task();
		data.setId(Integer.parseInt(id));
		data.setTaskName(taskName);
		data.setTaskType(taskType);
		data.setTaskRunType(taskRunType);
		data.setTaskTime(taskTime);
		data.setTaskTiming(taskTiming);
		data.setStatus(status);

		try {
			json = JSON.toJSONString(service.uptTask(data) ? new Result<Object>(Result.SUCCESS_0, "修改调度任务成功")
					: new Result<Object>(Result.ERROR_4000, "修改调度任务失败"));
		} catch (Exception e) {
			log.error("修改调度任务异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "修改调度任务异常"));
		}
		returnData(json, response);
	}

	private void delTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String json = "";
		try {
			json = JSON.toJSONString(service.delTask(id) ? new Result<Object>(Result.SUCCESS_0, "删除调度任务成功")
					: new Result<Object>(Result.ERROR_4000, "删除调度任务失败"));
		} catch (Exception e) {
			log.error("删除调度任务异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "删除调度任务异常"));
		}
		returnData(json, response);
	}

	/**
	 * 
	 * @Title: returnData   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param json
	 * @param response
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
	private void returnData(String json, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
	}
}
