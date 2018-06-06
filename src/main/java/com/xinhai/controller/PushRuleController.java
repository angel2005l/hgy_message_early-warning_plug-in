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
import com.xinhai.entity.PushRule;
import com.xinhai.service.IPushRuleService;
import com.xinhai.service.impl.PushRuleServiceImpl;
import com.xinhai.util.Page;
import com.xinhai.util.Result;
import com.xinhai.util.StrUtil;

public class PushRuleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PushRuleController.class);
	private IPushRuleService service = new PushRuleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");
		switch (mod) {
		case "pr_ins":
			insPr(req, resp);
			break;
		case "pr_sel":
			selPr(req, resp);
			break;
		case "pr_sel_id":
			selPrById(req, resp);
			break;
		case "pr_upt":
			uptPr(req, resp);
			break;
		case "pr_del":
			delPr(req, resp);
			break;
		case "pr_sel_kv":
			selPrKV(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	private void selPr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String page = request.getParameter("page");
			String ruleName = request.getParameter("rule_name");
			Page<PushRule> selPushRulePageWithCount = service.selPushRulePageWithCount(ruleName,StrUtil.isBlank(page) ? "1"
					: page);
			request.setAttribute("data", selPushRulePageWithCount);
		} catch (Exception e) {
			log.error("查询推送规则异常,异常原因" + e.toString());
		}
		request.getRequestDispatcher("view/pr/index.jsp").forward(request, response);
	}

	private void selPrById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String id = request.getParameter("id");
		try {
			PushRule selPushRuleById = service.selPushRuleById(id);
			request.setAttribute("data", selPushRuleById);
		} catch (Exception e) {
			log.error("跳转推送规则修改页面异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/pr/editLayer.jsp").forward(request, response);
	}

	private void insPr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ruleCode = request.getParameter("ruleCode");
		String ruleName = request.getParameter("ruleName");
		String ruleFirstTime = request.getParameter("ruleFirstTime");
		String ruleSecondTime = request.getParameter("ruleSecondTime");
		String ruleThirdTime = request.getParameter("ruleThirdTime");
		String ruleFourthTime = request.getParameter("ruleFourthTime");
		String json = "";
		try {
			PushRule data = new PushRule();
			data.setRuleCode(ruleCode);
			data.setRuleName(ruleName);
			data.setRuleFirstTime(Integer.parseInt(ruleFirstTime));
			data.setRuleSecondTime(Integer.parseInt(ruleSecondTime));
			data.setRuleThirdTime(Integer.parseInt(ruleThirdTime));
			data.setRuleFourthTime(Integer.parseInt(ruleFourthTime));

			Result<Object> insPushRule = service.insPushRule(data);
			json = JSON.toJSONString(insPushRule);
		} catch (Exception e) {
			log.error("添加推送规则异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "添加推送规则异常"));
		}
		returnData(json, response);
	}

	private void uptPr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String ruleName = request.getParameter("ruleName");
		String ruleFirstTime = request.getParameter("ruleFirstTime");
		String ruleSecondTime = request.getParameter("ruleSecondTime");
		String ruleThirdTime = request.getParameter("ruleThirdTime");
		String ruleFourthTime = request.getParameter("ruleFourthTime");
		String json = "";
		try {
			PushRule data = new PushRule();
			data.setId(Integer.parseInt(id));
			data.setRuleName(ruleName);
			data.setRuleFirstTime(Integer.parseInt(ruleFirstTime));
			data.setRuleSecondTime(Integer.parseInt(ruleSecondTime));
			data.setRuleThirdTime(Integer.parseInt(ruleThirdTime));
			data.setRuleFourthTime(Integer.parseInt(ruleFourthTime));
			Result<Object> uptPushRule = service.uptPushRule(data);
			json = JSON.toJSONString(uptPushRule);
		} catch (Exception e) {
			log.error("修改推送规则异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "修改推送规则异常"));
		}
		returnData(json, response);

	}

	private void delPr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String json = "";
		try {
			Result<Object> delPusgRule = service.delPusgRule(id);
			json = JSON.toJSONString(delPusgRule);
		} catch (Exception e) {
			log.error("删除推送规则异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "删除推送规则异常"));
		}
		returnData(json, response);
	}

	private void selPrKV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			List<Map<String, String>> selPushRuleKV = service.selPushRuleKV();
			if (null == selPushRuleKV || selPushRuleKV.isEmpty()) {
				json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "查询推送规则键值对数据异常"));
			} else {
				json = JSON.toJSONString(new Result<List<Map<String, String>>>(Result.SUCCESS_0, "", selPushRuleKV));
			}
		} catch (Exception e) {
			log.error("查询推送规则键值对数据异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "查询推送规则键值对数据异常"));
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
