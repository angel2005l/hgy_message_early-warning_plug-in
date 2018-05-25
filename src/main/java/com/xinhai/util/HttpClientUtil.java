package com.xinhai.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class HttpClientUtil {

	private static CookieStore cookieStore = null;

	/**
	 * 
	 * @param URL
	 *            //地址
	 * @param urlParameter
	 *            //传参
	 * @return
	 */
	public static String getPost(String URL, List<NameValuePair> urlParameter) {
		try {
			RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
			HttpClientContext context = new HttpClientContext();
			if (cookieStore == null) {
				doPostForCookie();
			}
			context.setCookieStore(cookieStore);
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
					.setDefaultCookieStore(cookieStore).build();
			// post
			HttpPost httpPost = new HttpPost(URL);
			// 设置头部
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 添加参数
			@SuppressWarnings("deprecation")
			HttpEntity postParams = new UrlEncodedFormEntity(urlParameter, HTTP.UTF_8);
			// 执行
			httpPost.setEntity(postParams);
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			// 打印状态
			// System.out.println("POST Response Status:: " +
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			// print result
			httpClient.close();
			return response.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建httpEntity对象
		catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void doPostForCookie() {
		try {
			String userName = "xinhai";
			String password = "123";
			List<NameValuePair> urlParameter = new ArrayList<NameValuePair>();
			urlParameter.add(new BasicNameValuePair("j_username", userName));
			urlParameter.add(new BasicNameValuePair("j_password", password));
			// 接口地址
			// 定义 CloseableHttpClient HttpClient 过时
			cookieStore = new BasicCookieStore();
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			// post
			HttpPost httpPost = new HttpPost("http://192.168.27.248:8080/XinhaiMes/j_spring_security_check");
			// 设置头部
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 添加参数
			@SuppressWarnings("deprecation")
			HttpEntity postParams = new UrlEncodedFormEntity(urlParameter, HTTP.UTF_8);
			// 执行
			httpPost.setEntity(postParams);
			httpClient.execute(httpPost);
			httpClient.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建httpEntity对象
		catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getPostDefault(String URL, List<NameValuePair> urlParameter) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// post
			HttpPost httpPost = new HttpPost(URL);
			// 设置头部
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 添加参数
			@SuppressWarnings("deprecation")
			HttpEntity postParams = new UrlEncodedFormEntity(urlParameter, HTTP.UTF_8);
			// 执行
			httpPost.setEntity(postParams);
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			// 打印状态
			// System.out.println("POST Response Status:: " +
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			// print result
			httpClient.close();
			return response.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建httpEntity对象
		catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
