package com.xinhai.entity;

import java.sql.Timestamp;

public class Equipment {
	private String orderChildNo;// 子订单编号
	private String productCode;// 设备编号
	private String useStatedsp;// 运行状态
	private String statedsp;// 状态dsp
	private String code;// 设备序号
	private Timestamp starttime;// 开始时间
	private String usestate;// 使用情况
	private String maintainstate;// 基本状态
	private String crossClass;//
	private String maintainstatedsp;//基本状态dsp
	private String productname;// 产品名称
	private String model;// 模式
	private String state;// 状态
	private int equId;// 设备Id编号
	private String runningstate;//运行状态
	private String repairstatedsp;//
	private String quantity;//计划生产数
	private String datamode;//数据模式
	private String stopreason;//停机原因
	private String deviceordercount;//设备订单数
	private String alarmcount;//报警数
	private String completequantity;//实际生产数
	private String qualifiedquantity;//合格数
	private String repairstate;//维修情况
	private String progress;//生产进度
	private int rn;//排序

	public Equipment() {
	}

	public String getOrderChildNo() {
		return orderChildNo;
	}

	public void setOrderChildNo(String orderChildNo) {
		this.orderChildNo = orderChildNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUseStatedsp() {
		return useStatedsp;
	}

	public void setUseStatedsp(String useStatedsp) {
		this.useStatedsp = useStatedsp;
	}

	public String getStatedsp() {
		return statedsp;
	}

	public void setStatedsp(String statedsp) {
		this.statedsp = statedsp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public String getUsestate() {
		return usestate;
	}

	public void setUsestate(String usestate) {
		this.usestate = usestate;
	}

	public String getMaintainstate() {
		return maintainstate;
	}

	public void setMaintainstate(String maintainstate) {
		this.maintainstate = maintainstate;
	}

	public String getCrossClass() {
		return crossClass;
	}

	public void setCrossClass(String crossClass) {
		this.crossClass = crossClass;
	}

	public String getMaintainstatedsp() {
		return maintainstatedsp;
	}

	public void setMaintainstatedsp(String maintainstatedsp) {
		this.maintainstatedsp = maintainstatedsp;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getEquId() {
		return equId;
	}

	public void setEquId(int equId) {
		this.equId = equId;
	}

	public String getRunningstate() {
		return runningstate;
	}

	public void setRunningstate(String runningstate) {
		this.runningstate = runningstate;
	}

	public String getRepairstatedsp() {
		return repairstatedsp;
	}

	public void setRepairstatedsp(String repairstatedsp) {
		this.repairstatedsp = repairstatedsp;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDatamode() {
		return datamode;
	}

	public void setDatamode(String datamode) {
		this.datamode = datamode;
	}

	public String getStopreason() {
		return stopreason;
	}

	public void setStopreason(String stopreason) {
		this.stopreason = stopreason;
	}

	public String getDeviceordercount() {
		return deviceordercount;
	}

	public void setDeviceordercount(String deviceordercount) {
		this.deviceordercount = deviceordercount;
	}

	public String getAlarmcount() {
		return alarmcount;
	}

	public void setAlarmcount(String alarmcount) {
		this.alarmcount = alarmcount;
	}

	public String getCompletequantity() {
		return completequantity;
	}

	public void setCompletequantity(String completequantity) {
		this.completequantity = completequantity;
	}

	public String getQualifiedquantity() {
		return qualifiedquantity;
	}

	public void setQualifiedquantity(String qualifiedquantity) {
		this.qualifiedquantity = qualifiedquantity;
	}

	public String getRepairstate() {
		return repairstate;
	}

	public void setRepairstate(String repairstate) {
		this.repairstate = repairstate;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "Equipment [orderChildNo=" + orderChildNo + ", productCode=" + productCode + ", useStatedsp="
				+ useStatedsp + ", statedsp=" + statedsp + ", code=" + code + ", starttime=" + starttime + ", usestate="
				+ usestate + ", maintainstate=" + maintainstate + ", crossClass=" + crossClass + ", maintainstatedsp="
				+ maintainstatedsp + ", productname=" + productname + ", model=" + model + ", state=" + state
				+ ", equId=" + equId + ", runningstate=" + runningstate + ", repairstatedsp=" + repairstatedsp
				+ ", quantity=" + quantity + ", datamode=" + datamode + ", stopreason=" + stopreason
				+ ", deviceordercount=" + deviceordercount + ", alarmcount=" + alarmcount + ", completequantity="
				+ completequantity + ", qualifiedquantity=" + qualifiedquantity + ", repairstate=" + repairstate
				+ ", progress=" + progress + ", rn=" + rn + "]";
	}

}
