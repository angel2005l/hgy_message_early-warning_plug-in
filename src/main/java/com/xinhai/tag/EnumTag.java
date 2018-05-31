package com.xinhai.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.xinhai.util.EnumUtil;
import com.xinhai.util.StrUtil;

public class EnumTag extends BodyTagSupport {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int doEndTag() throws JspException {
		String value = this.getBodyContent().getString().toUpperCase();
		if (StrUtil.notBlank(value)) {
			Class clazz = null;
			try {
				clazz = Class.forName("com.xinhai.enums." + className);
				value = EnumUtil.getTextFromCode(clazz, value);
				pageContext.getOut().write(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;

	}
}
