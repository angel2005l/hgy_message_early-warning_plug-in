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
import com.xinhai.service.ICoreService;
import com.xinhai.service.impl.CoreServiceImpl;
import com.xinhai.util.Result;

public class PanelController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PanelController.class);
	private ICoreService coreService = new CoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");
		switch (mod) {
		case "oee_panel":
			oeePanel(req, resp);
			break;
		case "oee_panel_sel":
			oeePanelSel(req, resp);
			break;
		case "index_panel":
			indexPanel(req, resp);
			break;
		case "warn_day_sel":
			warnDaySel(req, resp);
			break;
		case "warn_7day_sel":
			warn7DaySel(req, resp);
			break;
		case "warn_equ_produce_type_sel":
			equproduceTypeSel(req, resp);
			break;
		case "warn_week_top5_sel":
			warnWeekTop5Sel(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	private void oeePanel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("view/oee/index.jsp");
	}

	private void oeePanelSel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "[]";
		try {
			List<Object[]> selOEEInfoALL = coreService.selOEEInfoALL();
			json = JSON.toJSONString(selOEEInfoALL);
		} catch (Exception e) {
			log.error("OEE面板数据异常,异常原因:" + e.toString());
		}
		returnData(json, response);
	}

	private void indexPanel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("view/index/index.jsp");
	}

	private void warnDaySel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			List<Map<String, Object>> selWarnDay = coreService.selWarnDay();
			Result<List<Map<String, Object>>> result = null != selWarnDay
					? new Result<List<Map<String, Object>>>(Result.SUCCESS_0, "", selWarnDay)
					: new Result<>(Result.ERROR_4000, Result.ERROR_4000_MSG);
			json = JSON.toJSONString(result);
		} catch (Exception e) {
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, Result.ERROR_4600_MSG));
			log.error("查询当日预警信息异常,异常原因:" + e.toString());
		}
		returnData(json, response);
	}

	private void warn7DaySel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			json = JSON.toJSONString(coreService.selWarn7Day());
		} catch (Exception e) {
			log.error("查询近七天预警次数异常,异常原因" + e.toString());
			json = JSON.toJSONString(null);
		}
		returnData(json, response);
	}

	private void equproduceTypeSel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			json = JSON.toJSONString(coreService.selEquProduceType());
		} catch (Exception e) {
			log.error("查询近七天预警次数异常,异常原因:" + e.toString());
			json = JSON.toJSONString(null);
		}
		returnData(json, response);
	}

	private void warnWeekTop5Sel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			json = JSON.toJSONString(coreService.selWarnWeekTop5());
		} catch (Exception e) {
			log.error("查询预警一周最高top5异常,异常原因:" + e.toString());
			json = JSON.toJSONString(null);
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
