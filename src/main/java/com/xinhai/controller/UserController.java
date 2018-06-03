package com.xinhai.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.xinhai.entity.User;
import com.xinhai.service.IUserService;
import com.xinhai.service.impl.UserServiceImpl;
import com.xinhai.util.IOUtil;
import com.xinhai.util.POIUtil;
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
		case "user_batch_add":
			addBacthUser(req, resp);
			break;
		case "download_file":
			downloadFile(req, resp);
			break;
		case "sign_in_work":
			singInWork(req, resp);
			break;
		case "logout":
			logout(req, resp);
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
		String json = "";
		if ("xinhai".equals(userName) && "123".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "true");
			json = JSON.toJSONString(new Result<Object>(Result.SUCCESS_0, "登录成功"));
		} else {
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_4300, "用户名/密码不正确"));
		}
		returnData(json, response);
	}

	/**
	 * 
	 * @Title: selUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
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
		request.getRequestDispatcher("view/user/editLayer.jsp").forward(request, response);
	}

	/**
	 * 
	 * @Title: addUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
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

	/**
	 * 
	 * @Title: uptUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
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

	/**
	 * 
	 * @Title: delUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
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

	/**
	 * 
	 * @Title: addBacthUser
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author: MR.H
	 * @return: void
	 *
	 */
	private void addBacthUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得文件流对象
		String json = "";
		try {
			List<InputStream> fileStreams = IOUtil.getFileStreams(request);
			if (null == fileStreams || fileStreams.isEmpty()) {
				json = JSON.toJSONString(new Result<Object>(Result.ERROR_4300, "无法识别的文件"));
			} else {
				String[] rowCodes = { "userCode", "userName", "userToken", "userEmail", "userPhone", "userLevel" };
				List<Map<String, String>> resultList = POIUtil.readExcelXlsx(fileStreams.get(0), 6, 1, rowCodes);
				List<User> data = new ArrayList<User>();
				for (Map<String, String> map : resultList) {
					data.add(JSON.parseObject(JSON.toJSONString(map), User.class));
				}
				Result<Object> insBatch = service.insBatch(data);
				json = JSON.toJSONString(insBatch);
			}
		} catch (FileUploadException | IOException e) {
			log.error("批量添加用户信息异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, e.toString()));
		} catch (Exception e) {
			log.error("批量添加用户信息异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<>(Result.ERROR_6000, "批量添加用户信息异常"));
		}
		returnData(json, response);
	}

	@SuppressWarnings("resource")
	private void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String HOME_PATH = UserController.class.getResource("/").getPath();
		String DOWNLOAD_TEMP_FILE = HOME_PATH.subSequence(0, HOME_PATH.indexOf("WEB-INF")) + "warn/download/";
		String fileName = "员工导入模板.xlsx";
		// 处理请求
		// 读取要下载的文件
		DOWNLOAD_TEMP_FILE = URLDecoder.decode(DOWNLOAD_TEMP_FILE, "utf-8");
		File f = new File(DOWNLOAD_TEMP_FILE + fileName);
		response.setCharacterEncoding("utf-8");
		if (f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			String filename = URLEncoder.encode(f.getName(), "utf-8"); // 解决中文文件名下载后乱码的问题
			byte[] b = new byte[fis.available()];
			fis.read(b);
			response.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
			// 获取响应报文输出流对象
			ServletOutputStream out = response.getOutputStream();
			// 输出
			out.write(b);
			out.flush();
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('文件缺失,请联系系统维护人员');window.location.href='view/user/batchLayer.jsp';</script>");
		}
	}

	/**
	 * 
	 * @Title: singInWork   
	 * @Description: 一线员工的上下班签到
	 * @param request
	 * @param response
	 * @author: MR.H
	 * @return: void
	 * @throws IOException 
	 *
	 */
	private void singInWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String workType = request.getParameter("workType");
		String json = "";

		try {
			Result<Object> uptUserIsWork = service.uptUserIsWork(workType, id);
			json = JSON.toJSONString(uptUserIsWork);
		} catch (Exception e) {
			log.error("员工签到异常,异常原因:" + e.toString());
			json = JSON.toJSONString(new Result<Object>(Result.ERROR_6000, "员工签到异常"));
		}
		returnData(json, response);
	}

	/**
	 * 
	 * @Title: logout
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param request
	 * @param response
	 * @author: MR.H
	 * @return: void
	 * @throws IOException
	 *
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("view/login.jsp");
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
