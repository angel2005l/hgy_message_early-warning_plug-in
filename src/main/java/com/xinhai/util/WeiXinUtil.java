package com.xinhai.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.entity.WarningWithRule;

public class WeiXinUtil {
	// "http://10.168.20.223:8088/ddapi/wx/templatemes/warn7.jsp?title=1&message=mes&create_time=2018&openid=oVM1v1LYIa38thd9xm6MR0-AoVb0&go_url=http://www.baidu.com";
	private static final Logger log = LoggerFactory.getLogger(WeiXinUtil.class);

	public static void sendWarning(WarningWithRule obj, String openId) throws UnsupportedEncodingException {
		if(StrUtil.isBlank(openId)) {
			log.info("【微信推送接口】推送人token为空");
			return ;
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("dataDic");
		String url = rb.getString("weixin_push_path");
		String rootPath = rb.getString("root_path");
		if (StrUtil.isBlank(url) || StrUtil.isBlank(rootPath)) {
			log.info("【微信推送接口】缺少基础地址配置");
			return;
		}
		StringBuffer goUrl = new StringBuffer(rootPath).append("/myData?warnId=").append(obj.getGuid()).append("&method=mod4");
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("title", new String(obj.getTitle().getBytes(), "utf-8")));
		data.add(new BasicNameValuePair("message", obj.getMessage()));
		data.add(new BasicNameValuePair("create_time",
				DateUtil.curDateByStr(obj.getCreateTime().toString(), DateUtil.YMDHMS).toString()));
		data.add(new BasicNameValuePair("openid", openId));
		data.add(new BasicNameValuePair("go_url", goUrl.toString()));
		HttpClientUtil.getPostDefault(url, data);
	}
}