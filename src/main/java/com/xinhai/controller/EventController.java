package com.xinhai.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xinhai.entity.Event;
import com.xinhai.service.IEventTypeService;
import com.xinhai.service.impl.EventTypeServiceImpl;
import com.xinhai.util.Page;
import com.xinhai.util.Result;
import com.xinhai.util.StrUtil;

public class EventController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IEventTypeService service = new EventTypeServiceImpl();

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");
		switch (mod) {
		case "warning_sel":
			selWarn(req, resp);
			break;
		case "warning_ins":
			insWarn(req, resp);
			break;
		case "warning_upt_rule_code":
			uptWarnRuleCode(req, resp);
			break;
		case "warning_upt__batch_rule_code":
			uptBatchWarnRuleCode(req, resp);
			break;
		case "warning_upt_event_status":
			uptWarnEventStatus(req, resp);
			break;
		case "warning_sel_kv":
			selWarnKV(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	private void selWarn(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			String page = request.getParameter("page");

			Page<Event> selWarnTypePageWithCount = service.selWarnTypePageWithCount(StrUtil.isBlank(page) ? "1"
					: page);
			request.setAttribute("data", selWarnTypePageWithCount);
		} catch (Exception e) {
			log.error("查询预警类别异常,异常原因" + e.toString());
		}
		request.getRequestDispatcher("view/warning/index.jsp").forward(request, response);
	}

	// 预警类别
	private void insWarn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String eventId = request.getParameter("eventId");
		String eventCode = request.getParameter("eventCode");
		String eventName = request.getParameter("eventName");
		String ruleCode = request.getParameter("ruleCode");
		String eventStatus = request.getParameter("eventStatus");
		String json = "";
		Event data = new Event();
		data.setEventId(Integer.parseInt(eventId));
		data.setEventCode(eventCode);
		data.setEventName(eventName);
		data.setRuleCode(ruleCode);
		data.setEventStatus(eventStatus);
		try {
			Result<Object> insWarnType = service.insWarnType(data);
			json = JSON.toJSONString(insWarnType);
		} catch (Exception e) {
			log.error("更新预警类别异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "更新预警类别异常"));
		}
		returnData(json, response);
	}

	private void uptWarnRuleCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String ruleCode = request.getParameter("ruleCode");
		String json = "";
		try {
			Result<Object> uptWarnTypeWithRuleCode = service.uptWarnTypeWithRuleCode(ruleCode, id);
			json = JSON.toJSONString(uptWarnTypeWithRuleCode);
		} catch (Exception e) {
			log.error("更新预警类别异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "更新预警类别异常"));
		}
		returnData(json, response);
	}

	private void uptBatchWarnRuleCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//String eventCode = request.getParameter("eventCode");
		String ruleCode = request.getParameter("ruleCode");
		String json = "";
		try {
			Result<Object> insWarnType = service.uptBatchWarnTypeWithRuleCode(ruleCode, new String[10]);
			json = JSON.toJSONString(insWarnType);
		} catch (Exception e) {
			log.error("更新预警类别异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "更新预警类别异常"));
		}
		returnData(json, response);
	}

	private void uptWarnEventStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String eventStatus = request.getParameter("eventStatus");
		String json = "";
		try {
			Result<Object> insWarnType = service.updateWarnTypeWithEventStatus(eventStatus, id);
			json = JSON.toJSONString(insWarnType);
		} catch (Exception e) {
			log.error("更新预警类别异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "更新预警类别异常"));
		}
		returnData(json, response);
	}

	private void selWarnKV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			List<Map<String, String>> selWarnTypeKV = service.selWarnTypeKV();
			if (null == selWarnTypeKV || selWarnTypeKV.isEmpty()) {
				json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "查询预警类别键值对数据异常"));
			} else {
				json = JSON.toJSONString(new Result<List<Map<String, String>>>(Result.SUCCESS_0, "", selWarnTypeKV));
			}
		} catch (Exception e) {
			log.error("查询预警类别键值对异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "查询预警类别键值对数据异常"));
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
