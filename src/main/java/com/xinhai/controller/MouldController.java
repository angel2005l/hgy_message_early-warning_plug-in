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
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.service.IMouldService;
import com.xinhai.service.impl.MouldServiceImpl;
import com.xinhai.task.sche.TaskSpiderEquipment;
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
		case "mould_synchrodata":
			synchroMouldData(req, resp);
			break;
		case "mould_rule_ins":
			insMouldRule(req, resp);
			break;
		case "mould_rule_sel":
			selMouldRule(req, resp);
			break;
		case "mould_rule_sel_id":
			selMouldRuleById(req, resp);
			break;
		case "mould_rule_upt":
			uptMouldRule(req, resp);
			break;
		case "mould_rule_del":
			delMouldRule(req, resp);
			break;
		case "mould_rule_sel_kv":
			selMouldRuleKV(req, resp);
			break;
		case "mould_log_sel_mould_id":
			selMouldLogByMouldId(req, resp);
			break;
		// case "mould_log_ins":
		// insMouldLog(req, resp);
		// break;
		case "mould_log_sel":
			selMouldLog(req, resp);
			break;
		case "mould_log_sel_id":
			selMouldLogById(req, resp);
			break;
		case "mould_log_upt":
			uptMouldLog(req, resp);
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
	private void selMould(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String page = request.getParameter("page");// 当前页数
			Page<Mould> selMouldPageWithCount = service.selMouldPageWithCount(StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selMouldPageWithCount);
		} catch (Exception e) {
			log.error("查询模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mould/index.jsp").forward(request, response);
	}

	private void selMouldById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Mould selMouldById = service.selMouldById(id);
			request.setAttribute("data", selMouldById);
		} catch (Exception e) {
			log.error("查询特定模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mould/boundRuleLayer.jsp").forward(request, response);
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

	/**
	 * 
	 * @author 黄官易
	 * @date 2018年6月5日
	 * @version 1.0
	 * @param request
	 * @param response
	 * @throws IOException
	 */
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

	private void synchroMouldData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		new TaskSpiderEquipment();
		returnData(JSON.toJSONString(new Result<Object>(Result.SUCCESS_0, "MES机台信息同步成功")), response);
	}

	private void insMouldRule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mouldRuleCode = request.getParameter("mouldRuleCode");
		String mouldRuleName = request.getParameter("mouldRuleName");
		String mouldRuleTimes = request.getParameter("mouldRuleTimes");
		String json = "";

		MouldRule data = new MouldRule();
		data.setMouldRuleCode(mouldRuleCode);
		data.setMouldRuleName(mouldRuleName);
		data.setMouldRuleTimes(Integer.parseInt(mouldRuleTimes));
		try {
			Result<Object> insMouldRule = service.insMouldRule(data);
			json = JSON.toJSONString(insMouldRule);
		} catch (Exception e) {
			log.error("模具保养规则添加异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "模具保养规则添加异常"));
		}
		returnData(json, response);
	}

	private void selMouldRule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String page = request.getParameter("page");// 当前页数
			Page<MouldRule> selMouldRulePageWithCount = service
					.selMouldRulePageWithCount(StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selMouldRulePageWithCount);
		} catch (Exception e) {
			log.error("查询模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mouldRule/index.jsp").forward(request, response);
	}

	private void selMouldRuleById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MouldRule selMouldRuleById = service.selMouldRuleById(id);
			request.setAttribute("data", selMouldRuleById);
		} catch (Exception e) {
			log.error("查询特定模具信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mouldRule/editLayer.jsp").forward(request, response);
	}

	private void uptMouldRule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
//		String mouldRuleCode = request.getParameter("mouldRuleCode");
		String mouldRuleName = request.getParameter("mouldRuleName");
		String mouldRuleTimes = request.getParameter("mouldRuleTimes");
		String json = "";
		MouldRule data = new MouldRule();
		data.setId(Integer.parseInt(id));
//		data.setMouldRuleCode(mouldRuleCode);
		data.setMouldRuleName(mouldRuleName);
		data.setMouldRuleTimes(Integer.parseInt(mouldRuleTimes));
		try {
			Result<Object> uptMouldRule = service.uptMouldRule(data);
			json = JSON.toJSONString(uptMouldRule);
		} catch (Exception e) {
			log.error("修改模具保养规则信息异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "修改模具保养规则信息异常"));
		}
		returnData(json, response);
	}

	private void delMouldRule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String json = "";
		try {
			Result<Object> delMouldRule = service.delMouldRule(id);
			json = JSON.toJSONString(delMouldRule);
		} catch (Exception e) {
			log.error("删除模具保养规则信息异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "删除模具保养规则信息异常"));
		}
		returnData(json, response);
	}

	private void selMouldRuleKV(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";

		try {
			List<Map<String, String>> selMouldRuleKV = service.selMouldRuleKV();
			Result<List<Map<String, String>>> result = null == selMouldRuleKV || selMouldRuleKV.isEmpty()
					? new Result<List<Map<String, String>>>(Result.ERROR_4000, "无相关模具保养规则信息键值对")
					: new Result<List<Map<String, String>>>(Result.SUCCESS_0, "", selMouldRuleKV);

			json = JSON.toJSONString(result);
		} catch (Exception e) {
			log.error("查询模具保养规则键值对异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "查询模具保养规则键值对异常"));
		}
		returnData(json, response);
	}

	private void selMouldLogByMouldId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mouldId = request.getParameter("mouldId");
		String json = "";
		try {
			MouldLog selMouldLogByMouldId = service.selMouldLogByMouldId(mouldId);
			Result<MouldLog> result = null == selMouldLogByMouldId
					? new Result<MouldLog>(Result.ERROR_4000, "无相关模具保养日志信息键值对")
					: new Result<MouldLog>(Result.SUCCESS_0, "", selMouldLogByMouldId);
			json = JSON.toJSONString(result);
		} catch (Exception e) {
			log.error("查询模具保养日志信息异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "查询模具保养日志信息异常"));
		}
		returnData(json, response);
	}

	// private void insMouldLog(HttpServletRequest request, HttpServletResponse
	// response) {
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	// String parameter = request.getParameter("");
	//
	//
	// MouldLog data = new MouldLog();
	// data.setMouldId(mouldId);
	// data.setMouldLogCode(mouldLogCode);
	// data
	//
	// try {
	// service.insMouldLog(data)
	// } catch (Exception e) {
	// log.error("" + e.toString());
	// }
	// }

	private void selMouldLog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String page = request.getParameter("page");// 当前页数
			Page<MouldLog> selMouldLogPageWithCount = service
					.selMouldLogPageWithCount(StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selMouldLogPageWithCount);
		} catch (Exception e) {
			log.error("查询模具保养日志信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mouldLog/index.jsp").forward(request, response);
	}

	private void selMouldLogById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MouldLog selMouldLogById = service.selMouldLogById(id);
			request.setAttribute("data", selMouldLogById);
		} catch (Exception e) {
			log.error("查询模具保养日志信息异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("view/mouldLog/detailLayer.jsp").forward(request, response);
	}

	private void uptMouldLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String mouldLogContext = request.getParameter("mouldLogContext");
		String json = "";
		MouldLog data = new MouldLog();
		data.setId(Integer.parseInt(id));
		data.setMouldLogContext(mouldLogContext);
		data.setMouldLogStatus("2");
		try {
			Result<Object> uptMouldLog = service.uptMouldLog(data);
			json = JSON.toJSONString(uptMouldLog);
		} catch (Exception e) {
			log.error("确认保养日志异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "确认保养日志异"));
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
