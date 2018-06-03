package com.xinhai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.xinhai.util.Result;

public class PushInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");

		switch (mod) {
		case value:

			break;
		case value:

			break;
		case value:

			break;
		case value:

			break;
		case value:

			break;
		case value:

			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	//预警页面
	private void warnInfo(HttpServletRequest request, HttpServletResponse response){
		
		
		
	}

	//统计类型 预警
	//如何去判断周、月的数据 及数据的统计
	//规定每周的周一发送上周的数据|| 每月的月初规定 
	
	
	//
	//
	
	
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
