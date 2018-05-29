package com.xinhai.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;

public class IOUtil {

	/**
	 * 
	 * @Title: getFormField
	 * @Description: 根据二进制流提交获得普通表单控件的值
	 * @param request
	 * @return
	 * @throws FileUploadException
	 * @throws UnsupportedEncodingException
	 * @author: MR.H
	 * @return: Map<String,String>
	 *
	 */
	public static Map<String, String> getFormField(HttpServletRequest request)
			throws FileUploadException, UnsupportedEncodingException {
		// 实例化文件上传组件对象
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);

		Map<String, String> map = new HashMap<String, String>();
		// 是否满足二进制表单提交
		if (!ServletFileUpload.isMultipartContent(request)) {
			return map;
		}

		for (FileItem fi : sfu.parseRequest(request)) {
			if (!fi.isFormField()) {
				continue;
			}
			// String key = fi.getFieldName();
			// String value = new
			// String(fi.getString().getBytes("ISO-8859-1"),"UTF-8");
			map.put(fi.getFieldName(), new String(fi.getString().getBytes("ISO-8859-1"), "UTF-8"));
		}
		return map;
	}

	/**
	 * 
	 * @Title: getFormField2Bean
	 * @Description: 根据二进制流表单提交获得普通表单控件的值并转换JavaBean
	 * @param request
	 * @param clazz
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileUploadException
	 * @author: MR.H
	 * @return: T
	 *
	 */
	public static <T> T getFormField2Bean(HttpServletRequest request, Class<T> clazz)
			throws UnsupportedEncodingException, FileUploadException {
		Map<String, String> resultMap = getFormField(request);
		if (null == resultMap || resultMap.isEmpty()) {
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(resultMap), clazz);
	}

	/**
	 * 
	 * @Title: getFilePaths
	 * @Description: 根据二进制流表单提交获得文件上传控件的路径
	 * @param request
	 * @return
	 * @throws FileUploadException
	 * @author: MR.H
	 * @return: List<String>
	 *
	 */
	public static List<String> getFilePaths(HttpServletRequest request) throws FileUploadException {
		// 实例化文件上传组件对象
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		List<String> list = new ArrayList<String>();
		if (!ServletFileUpload.isMultipartContent(request)) {
			return list;
		}
		for (FileItem fi : sfu.parseRequest(request)) {
			if (fi.isFormField()) {
				continue;
			}
			list.add(fi.getName());
		}
		return list;
	}

	/**
	 * 
	 * @Title: getFileStreams
	 * @Description: 根据二进制流表单提交获得文件上传控件的输入流对象
	 * @param request
	 * @return
	 * @throws FileUploadException
	 * @author: MR.H
	 * @return: List<InputStream>
	 * @throws IOException
	 *
	 */
	public static List<InputStream> getFileStreams(HttpServletRequest request) throws FileUploadException, IOException {
		// 实例化文件上传组件对象
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		List<InputStream> list = new ArrayList<InputStream>();
		if (!ServletFileUpload.isMultipartContent(request)) {
			return list;
		}
		for (FileItem fi : sfu.parseRequest(request)) {
			if (fi.isFormField()) {
				continue;
			}
			// FileInputStream in = new FileInputStream(new File(fi.getName()));
			list.add(fi.getInputStream());
		}
		return list;
	}

	/**
	 * 获得二进制流的普通控件数据和文件流数据
	 * 
	 * @author 黄官易
	 * @date 2018年5月18日
	 * @version 1.0
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 */
	public static Map<String, Object> getMultipartData(HttpServletRequest request)
			throws IOException, FileUploadException {
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		List<InputStream> list = new ArrayList<InputStream>();
		Map<String, String> map = new HashMap<String, String>();
		if (!ServletFileUpload.isMultipartContent(request)) {
			return null;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		for (FileItem fi : sfu.parseRequest(request)) {
			if (fi.isFormField()) {
				map.put(fi.getFieldName(), new String(fi.getString().getBytes("ISO-8859-1"), "UTF-8"));
			} else {
				list.add(fi.getInputStream());
			}
		}
		data.put("stream", list);
		data.put("formField", map);
		return data;
	}

	/**
	 * 获得二进制流的普通控件数据和文件流数据并将普通控件转换为javaBean
	 * 
	 * @author 黄官易
	 * @date 2018年5月18日
	 * @version 1.0
	 * @param request
	 * @param clazz
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 */
	public static <T> Map<String, Object> getMultipartData2Bean(HttpServletRequest request, Class<T> clazz)
			throws IOException, FileUploadException {
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		List<InputStream> list = new ArrayList<InputStream>();
		Map<String, String> map = new HashMap<String, String>();
		if (!ServletFileUpload.isMultipartContent(request)) {
			return null;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		for (FileItem fi : sfu.parseRequest(request)) {
			if (fi.isFormField()) {
				map.put(fi.getFieldName(), new String(fi.getString().getBytes("ISO-8859-1"), "UTF-8"));
			} else {
				list.add(fi.getInputStream());
			}
		}
		data.put("stream", list);
		data.put("formField", null == map || map.isEmpty() ? null : JSON.parseObject(JSON.toJSONString(map), clazz));
		return data;
	}

	/**
	 * 
	 * @Title: deepClone
	 * @Description: 深度克隆（禁止抄袭！）
	 * @param obj
	 * @return
	 * @author: 黄官易
	 * @return: T
	 *
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deepClone(Object obj) {
		if (null == obj) {
			return null;
		}
		// 将对象写入流中
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			// 将对象从流中读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (T) oi.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// log.error("IO工具类【deepClone】方法异常,异常原因:" + e.getMessage());
			return null;
		}
	}
}
