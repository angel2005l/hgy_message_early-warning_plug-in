package com.xinhai.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xinhai.entity.User;
import com.xinhai.service.IUserService;
import com.xinhai.service.impl.UserServiceImpl;
import com.xinhai.util.IOUtil;
import com.xinhai.util.Page;
import com.xinhai.util.Result;
import com.xinhai.util.StrUtil;

public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mod = req.getParameter("method");
		switch (mod) {
		case "login":
			login(req, resp);
			break;
		case "user_ins":
			addUser(req, resp);
			break;
		case "user_sel":
			selUser(req, resp);
			break;
		case "user_sel_id":
			selUserById(req, resp);
			break;
		case "user_upt":
			uptUser(req, resp);
			break;
		case "user_del":
			delUser(req, resp);
			break;
		default:
			returnData(JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "无相关接口信息")), resp);
			break;
		}
	}

	/**
	 * 
	 * @author 黄官易
	 * @date 2018年5月31日
	 * @version 1.0
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String json = JSON.toJSONString(
				"xinhai".equals(userName) && "123".equals(password) ? new Result<Object>(Result.SUCCESS_0, "登录成功")
						: new Result<Object>(Result.ERROR_4300, "用户名/密码不正确"));
		returnData(json, response);
	}

	private void selUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String page = request.getParameter("page");

			Page<User> selUserpageWithCount = service.selUserpageWithCount(StrUtil.isBlank(page) ? "1" : page);
			request.setAttribute("data", selUserpageWithCount);
		} catch (Exception e) {
			log.error("查询用户信息异常,异常原因" + e.toString());
		}
		request.getRequestDispatcher("view/user/index.jsp").forward(request, response);
	}

	private void selUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			Result<User> selUserById = service.selUserById(id);
			request.setAttribute("data", selUserById);
		} catch (Exception e) {
			log.error("跳转用户信息修改页面异常,异常原因:" + e.toString());
		}
		request.getRequestDispatcher("warn/view/user/editLayer.jsp").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String json = "";
		try {
			String userCode = request.getParameter("userCode");
			String userName = request.getParameter("userName");
			String userToken = request.getParameter("userToken");
			String userEmail = request.getParameter("userEmail");
			String userPhone = request.getParameter("userPhone");
			String userLevel = request.getParameter("userLevel");
			String isWork = request.getParameter("isWork");
			String userStatus = request.getParameter("userStatus");
			User data = new User();
			data.setUserCode(userCode);
			data.setUserName(userName);
			data.setUserToken(userToken);
			data.setUserEmail(userEmail);
			data.setUserPhone(userPhone);
			data.setUserLevel(Integer.parseInt(userLevel));
			data.setIsWork(isWork);
			data.setUserStatus(userStatus);
			Result<Object> insUser = service.insUser(data);
			json = JSON.toJSONString(insUser);

		} catch (Exception e) {
			log.error("添加用户异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "添加用户异常"));
		}
		returnData(json, response);

	}

	private void uptUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String userToken = request.getParameter("userToken");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userLevel = request.getParameter("userLevel");
		String userStatus = request.getParameter("userStatus");
		String json = "";
		User data = new User();
		data.setId(Integer.parseInt(id));
		data.setUserToken(userToken);
		data.setUserEmail(userEmail);
		data.setUserPhone(userPhone);
		data.setUserLevel(Integer.parseInt(userLevel));
		data.setUserStatus(userStatus);
		try {
			Result<Object> uptUser = service.uptUser(data);
			json = JSON.toJSONString(uptUser);
		} catch (Exception e) {
			log.error("更新用户异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "更新用户异常"));
		}
		returnData(json, response);
	}

	private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String json = "";
		try {
			Result<Object> delUser = service.delUser(id);
			json = JSON.toJSONString(delUser);
		} catch (Exception e) {
			log.error("删除用户异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "删除用户异常"));
		}
		returnData(json, response);
	}

	private void addBacthUser(HttpServletRequest request, HttpServletResponse response) {
		// 获得文件流对象
		try {
			List<InputStream> fileStreams = IOUtil.getFileStreams(request);

			// 修改POI工具类 使其兼容输入流

		} catch (FileUploadException | IOException e) {
			e.printStackTrace();
		}

	}

	private void returnData(String json, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
	}
}
