package com.xinhai.entity;

import java.sql.Timestamp;

public class MouldLog {
	private int id;
	private String mould_log_code;
	private String mould_log_name;
	private String mould_log_context;
	private int mould_plan_times;
	private int mould_real_times;
	private Timestamp mould_log_creat_time;
	private String mould_log_status;
	private int mould_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMould_log_code() {
		return mould_log_code;
	}

	public void setMould_log_code(String mould_log_code) {
		this.mould_log_code = mould_log_code;
	}

	public String getMould_log_name() {
		return mould_log_name;
	}

	public void setMould_log_name(String mould_log_name) {
		this.mould_log_name = mould_log_name;
	}

	public String getMould_log_context() {
		return mould_log_context;
	}

	public void setMould_log_context(String mould_log_context) {
		this.mould_log_context = mould_log_context;
	}

	public int getMould_plan_times() {
		return mould_plan_times;
	}

	public void setMould_plan_times(int mould_plan_times) {
		this.mould_plan_times = mould_plan_times;
	}

	public int getMould_real_times() {
		return mould_real_times;
	}

	public void setMould_real_times(int mould_real_times) {
		this.mould_real_times = mould_real_times;
	}

	public Timestamp getMould_log_creat_time() {
		return mould_log_creat_time;
	}

	public void setMould_log_creat_time(Timestamp mould_log_creat_time) {
		this.mould_log_creat_time = mould_log_creat_time;
	}

	public String getMould_log_status() {
		return mould_log_status;
	}

	public void setMould_log_status(String mould_log_status) {
		this.mould_log_status = mould_log_status;
	}

	public int getMould_id() {
		return mould_id;
	}

	public void setMould_id(int mould_id) {
		this.mould_id = mould_id;
	}

	@Override
	public String toString() {
		return "MouldLog [id=" + id + ", mould_log_code=" + mould_log_code + ", mould_log_name=" + mould_log_name
				+ ", mould_log_context=" + mould_log_context + ", mould_plan_times=" + mould_plan_times
				+ ", mould_real_times=" + mould_real_times + ", mould_log_creat_time=" + mould_log_creat_time
				+ ", mould_log_status=" + mould_log_status + ", mould_id=" + mould_id + "]";
	}

}
