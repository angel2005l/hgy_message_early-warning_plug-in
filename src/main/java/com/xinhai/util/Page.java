package com.xinhai.util;

import java.util.List;

/**
 * 
 * @project 大数据Api
 * @date 2018.03.21
 * @author 黄官易
 * @version DEMO 0.0.1
 * @param <T>
 * @introduce
 */
public class Page<T> {
	private int showCount; // 每页显示记录数
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	private int page;// 当前页数
	private List<T> list;

	public Page(int showCount, int totalResult, int page, List<T> list) {
		this.showCount = showCount;
		this.totalResult = totalResult;
		this.page = page;
		this.list = list;
		this.setTotalPage(totalResult);
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalResult) {
		if (totalResult % showCount == 0)
			this.totalPage = totalResult / showCount;
		else
			this.totalPage = totalResult / showCount + 1;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
