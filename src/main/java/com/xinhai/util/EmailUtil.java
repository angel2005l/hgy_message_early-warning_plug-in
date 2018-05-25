package com.xinhai.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.xinhai.entity.Email;

public class EmailUtil {

	public static String sendEmail(Email emailObj, String URL) {
		if (StrUtil.isBlank(URL)) {
			// 默认邮件服务器地址
			URL = "http://wcphp172.xinhaimobile.cn/api/Email/smtp_email.php";
		}
		// 设备邮件数据
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("etitle", emailObj.geteTitle()));
		data.add(new BasicNameValuePair("sendname", emailObj.getSendName()));
		data.add(new BasicNameValuePair("email", emailObj.getEmail()));
		data.add(new BasicNameValuePair("html", emailObj.getHtml()));
		// 请求邮箱服务器
		return HttpClientUtil.getPostDefault(URL, data);
	}

	// 测试方法
	// public static void main(String[] arg) {
	// List<NameValuePair> data = new ArrayList<NameValuePair>();
	// data.add(new BasicNameValuePair("mailfromnane", "测试人员"));
	// data.add(new BasicNameValuePair("mailfrom", "hgy@x.xinhai.com"));
	// data.add(new BasicNameValuePair("to", "hgy@x.xinhai.com"));
	// // data.add(new BasicNameValuePair("sendname", "测试人员"));
	// // data.add(new BasicNameValuePair("email", "hgy@x.xinhai.com"));
	// data.add(new BasicNameValuePair("toname", "测试人员"));
	// data.add(new BasicNameValuePair("subject", "测试交互"));
	// data.add(new BasicNameValuePair("html", "<html><body>HELLO
	// WORlD</br>测试文件</body></html>"));
	// data.add(new BasicNameValuePair("text",
	// "这是一句测试语句包含换行测试1\n2//n3/r/n45</br>6/n5"));
	//
	// String post =
	// EmailUtil.getPost("http://wcphp172.xinhaimobile.cn/api/Email/send_emal.php",
	// data);
	// System.err.println(post);
	// }
}
