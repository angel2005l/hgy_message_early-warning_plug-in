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
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldRule;
import com.xinhai.service.IMouldService;
import com.xinhai.service.impl.MouldServiceImpl;
import com.xinhai.util.Page;
import com.xinhai.util.Result;
import com.xinhai.util.StrUtil;

public class MouldController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(MouldController.class);

	private IMouldService service = new MouldServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");
		switch (mod) {
		case "mould_sel":
			selMould(req, resp);
			break;
		case "mould_sel_id":
			selMouldById(req, resp);
			break;
		case "mould_upt_push_rule_code":
			uptMouldPushRuleCodeWithId(req, resp);
			break;
		case "mould_upt_batch_push_rule_code":
			uptMouldPushRuleCodeWithIds(req, resp);
			break;
		case "mould_sel_kv":
			selMouldKV(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	/**
	 * 
	 * @Title: selMould   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
	private void selMould(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			String page = request.getParameter("page");// 当前页数
			Page<Mould> selMouldPageWithCount = service.selMouldPageWithCount(StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selMouldPageWithCount);
		} catch (Exception e) {
			log.error("查询模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mould/index.jsp").forward(request, response);
	}

	private void selMouldById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			String id = request.getParameter("id");
			Mould selMouldById = service.selMouldById(id);
			System.err.println(selMouldById);
			request.setAttribute("data", selMouldById);
		} catch (Exception e) {
			log.error("查询特定模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mould/boundRule.jsp").forward(request, response);
	}

	private void uptMouldPushRuleCodeWithId(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String id = request.getParameter("id");
		String mouldRuleCode = request.getParameter("mouldRuleCode");
		String pushRuleCode = request.getParameter("pushRuleCode");
		String json = "";
		try {

			Result<Object> uptMouldPushRuleCodeWithId = service.uptMouldPushRuleCodeWithId(id, mouldRuleCode,
					pushRuleCode);
			json = JSON.toJSONString(uptMouldPushRuleCodeWithId);
		} catch (Exception e) {
			log.error("模具相关关联规则绑定异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "模具相关关联规则绑定异常"));
		}
		returnData(json, response);

	}

	private void uptMouldPushRuleCodeWithIds(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String[] ids = request.getParameterValues("mouldId");
		String mouldRuleCode = request.getParameter("mouldRuleCode");
		String pushRuleCode = request.getParameter("pushRuleCode");
		String json = "";
		try {
			Result<Object> uptMouldPushRuleCodeWithIds = service.uptMouldPushRuleCodeWithIds(ids, mouldRuleCode,
					pushRuleCode);
			json = JSON.toJSONString(uptMouldPushRuleCodeWithIds);
		} catch (Exception e) {
			log.error("模具相关关联规则批量绑定异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "模具相关关联规则批量绑定异常"));
		}
		returnData(json, response);
	}

	private void selMouldKV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			List<Map<String, String>> selMouldKV = service.selMouldKV();
			Result<List<Map<String, String>>> result = null == selMouldKV || selMouldKV.isEmpty()
					? new Result<List<Map<String, String>>>(Result.ERROR_4000, "无相关模具信息键值对")
					: new Result<List<Map<String, String>>>(Result.SUCCESS_0, "", selMouldKV);

			json = JSON.toJSONString(result);
		} catch (Exception e) {
			log.error("查询模具键值对异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "查询模具键值对异常"));
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
