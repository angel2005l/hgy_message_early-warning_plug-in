package com.xinhai.util;

import java.io.Serializable;

/**
 * 
 * @project 大数据api 统一返回状态
 * @date 2018.03.19
 * @author 黄官易
 * @version DEMO 0.0.1
 * @introduce
 */
public class Result<T> implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	// 编码【code】类型
	public static final int SUCCESS_0 = 0;
	public static final int ERROR_401 = 401;
	public static final int ERROR_503 = 503;
	public static final int ERROR_504 = 504;
	public static final int ERROR_4000 = 4000;
	public static final int ERROR_4100 = 4100;
	public static final int ERROR_4200 = 4200;
	public static final int ERROR_4300 = 4300;
	public static final int ERROR_4400 = 4400;
	public static final int ERROR_4500 = 4500;
	public static final int ERROR_4600 = 4600;
	public static final int ERROR_6000 = 6000;
	public static final int ERROR_6100 = 6100;
	public static final int ERROR_6200 = 6200;
	// 信息【msg】类型
	public static final String SUCCESS_0_MSG = "成功";
	public static final String ERROR_401_MSG = "HTTP请求参数不符合要求";
	public static final String ERROR_503_MSG = "调用额度已超出限制";
	public static final String ERROR_504_MSG = "服务故障";
	public static final String ERROR_4000_MSG = "请求参数非法";
	public static final String ERROR_4100_MSG = "鉴权失败";
	public static final String ERROR_4200_MSG = "请求过期";
	public static final String ERROR_4300_MSG = "拒绝访问";
	public static final String ERROR_4400_MSG = "超过配额";
	public static final String ERROR_4500_MSG = "重放攻击";
	public static final String ERROR_4600_MSG = "协议不支持";
	public static final String ERROR_6000_MSG = "服务器内部错误";
	public static final String ERROR_6100_MSG = "版本暂不支持";
	public static final String ERROR_6200_MSG = "接口暂时无法访问";

	private int code;
	private String msg;
	private T data;

	public Result() {
	}

	public Result(int code) {
		this.code = code;
	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
