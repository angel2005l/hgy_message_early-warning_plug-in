package com.xinhai.util;

public class EnumUtil {
	/**
	 * 用反射的方法调用类的方法
	 * 
	 * @author 黄官易
	 * @date 2018年5月22日
	 * @version 1.0
	 * @param t
	 * @param methodName
	 * @return
	 */
	private static <T> String getInvokeValue(T t, String methodName) {
		try {
			return (String) t.getClass().getMethod(methodName).invoke(t);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据枚举的Code值得到Text值
	 * 
	 * @author 黄官易
	 * @date 2018年5月22日
	 * @version 1.0
	 * @param ref
	 * @param code
	 * @return
	 */
	public static <T> String getTextFromCode(Class<T> ref, String code) {
		if (ref.isEnum()) {
			T[] ts = ref.getEnumConstants(); // 得到Enum的所有实例
			for (T t : ts) {
			 String c = getInvokeValue(t, "getCode");
				if (code.equals(c))
					return getInvokeValue(t, "getText");
			}
		}
		return "";
	}
}
