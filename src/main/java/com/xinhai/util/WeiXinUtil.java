package com.xinhai.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.xinhai.entity.Warning;

public class WeiXinUtil {
	// private static final Logger log = LoggerFactory.getLogger(WeiXinUtil.class);
	// String url =
	// "http://10.168.20.223:8088/ddapi/wx/templatemes/warn7.jsp?title=1&message=mes&create_time=2018&openid=oVM1v1LYIa38thd9xm6MR0-AoVb0&go_url=http://www.baidu.com";

	public static void sendWarning(Warning obj, String openId, String url) throws UnsupportedEncodingException {
		if (StrUtil.isBlank(url)) {
			url = "http://10.168.20.223:8090/ddapi/wx/templatemes/warn7.jsp";
		}
		StringBuffer goUrl = new StringBuffer("192.168.0.100:8088/xh_f7_sprider/myData?warnId=").append(obj.getGuid())
				.append("&method=mod4");
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("title", new String(obj.getTitle().getBytes(), "utf-8")));
		data.add(new BasicNameValuePair("message", obj.getMessage()));
		data.add(new BasicNameValuePair("create_time",
				DateUtil.curDateByStr(obj.getCreateTime().toString(), DateUtil.YMDHMS).toString()));
		data.add(new BasicNameValuePair("openid", openId));
		data.add(new BasicNameValuePair("go_url", goUrl.toString()));
		HttpClientUtil.getPostDefault(url, data);
	}

	// public static void main(String[] arg) throws SQLException,
	// UnsupportedEncodingException {
	// IDataCollectDao dao = new DataCollectDaoImpl();
	// List<Warning> selHandleData = dao.selHandleData(1);
	// System.err.println(selHandleData.size());
	// Warning warning = selHandleData.get(0);
	//
	// WeiXinUtil.sendWarning(warning, "oVM1v1LYIa38thd9xm6MR0-AoVb0", "");
	//
	// }
}
