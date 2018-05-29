package com.xinhai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Equipment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String equOrderChildNo;// 子订单编号
	private String equProductCode;// 设备编号
	private String equUseStatedsp;// 运行状态
	private String equStatedsp;// 状态dsp
	private String equCode;// 设备序号
	private Timestamp equStartTime;// 开始时间
	private String equUseState;// 使用情况
	private String equMaintainState;// 基本状态
	private String equMaintainStatedsp;// 基本状态dsp
	private String equProductName;// 产品名称
	private String equModel;// 模式
	private String equState;// 状态
	private int equId;// 设备Id编号
	private String equRunningState;// 运行状态
	private String equRepairStatedsp;//
	private String equQuantity;// 计划生产数
	private String equDataMode;// 数据模式
	private String equStopReason;// 停机原因
	private int equDeviceOrderCount;// 设备订单数
	private String equAlarmCount;// 报警数
	private String equCompleteQuantity;// 实际生产数
	private String equQualifiedQuantity;// 合格数
	private String equRepairState;// 维修情况
	private String equProgress;// 生产进度

	public Equipment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquOrderChildNo() {
		return equOrderChildNo;
	}

	public void setEquOrderChildNo(String equOrderChildNo) {
		this.equOrderChildNo = equOrderChildNo;
	}

	public String getEquProductCode() {
		return equProductCode;
	}

	public void setEquProductCode(String equProductCode) {
		this.equProductCode = equProductCode;
	}

	public String getEquUseStatedsp() {
		return equUseStatedsp;
	}

	public void setEquUseStatedsp(String equUseStatedsp) {
		this.equUseStatedsp = equUseStatedsp;
	}

	public String getEquStatedsp() {
		return equStatedsp;
	}

	public void setEquStatedsp(String equStatedsp) {
		this.equStatedsp = equStatedsp;
	}

	public String getEquCode() {
		return equCode;
	}

	public void setEquCode(String equCode) {
		this.equCode = equCode;
	}

	public Timestamp getEquStartTime() {
		return equStartTime;
	}

	public void setEquStartTime(Timestamp equStartTime) {
		this.equStartTime = equStartTime;
	}

	public String getEquUseState() {
		return equUseState;
	}

	public void setEquUseState(String equUseState) {
		this.equUseState = equUseState;
	}

	public String getEquMaintainState() {
		return equMaintainState;
	}

	public void setEquMaintainState(String equMaintainState) {
		this.equMaintainState = equMaintainState;
	}

	public String getEquMaintainStatedsp() {
		return equMaintainStatedsp;
	}

	public void setEquMaintainStatedsp(String equMaintainStatedsp) {
		this.equMaintainStatedsp = equMaintainStatedsp;
	}

	public String getEquProductName() {
		return equProductName;
	}

	public void setEquProductName(String equProductName) {
		this.equProductName = equProductName;
	}

	public String getEquModel() {
		return equModel;
	}

	public void setEquModel(String equModel) {
		this.equModel = equModel;
	}

	public String getEquState() {
		return equState;
	}

	public void setEquState(String equState) {
		this.equState = equState;
	}

	public int getEquId() {
		return equId;
	}

	public void setEquId(int equId) {
		this.equId = equId;
	}

	public String getEquRunningState() {
		return equRunningState;
	}

	public void setEquRunningState(String equRunningState) {
		this.equRunningState = equRunningState;
	}

	public String getEquRepairStatedsp() {
		return equRepairStatedsp;
	}

	public void setEquRepairStatedsp(String equRepairStatedsp) {
		this.equRepairStatedsp = equRepairStatedsp;
	}

	public String getEquQuantity() {
		return equQuantity;
	}

	public void setEquQuantity(String equQuantity) {
		this.equQuantity = equQuantity;
	}

	public String getEquDataMode() {
		return equDataMode;
	}

	public void setEquDataMode(String equDataMode) {
		this.equDataMode = equDataMode;
	}

	public String getEquStopReason() {
		return equStopReason;
	}

	public void setEquStopReason(String equStopReason) {
		this.equStopReason = equStopReason;
	}

	public int getEquDeviceOrderCount() {
		return equDeviceOrderCount;
	}

	public void setEquDeviceOrderCount(int equDeviceOrderCount) {
		this.equDeviceOrderCount = equDeviceOrderCount;
	}

	public String getEquAlarmCount() {
		return equAlarmCount;
	}

	public void setEquAlarmCount(String equAlarmCount) {
		this.equAlarmCount = equAlarmCount;
	}

	public String getEquCompleteQuantity() {
		return equCompleteQuantity;
	}

	public void setEquCompleteQuantity(String equCompleteQuantity) {
		this.equCompleteQuantity = equCompleteQuantity;
	}

	public String getEquQualifiedQuantity() {
		return equQualifiedQuantity;
	}

	public void setEquQualifiedQuantity(String equQualifiedQuantity) {
		this.equQualifiedQuantity = equQualifiedQuantity;
	}

	public String getEquRepairState() {
		return equRepairState;
	}

	public void setEquRepairState(String equRepairState) {
		this.equRepairState = equRepairState;
	}

	public String getEquProgress() {
		return equProgress;
	}

	public void setEquProgress(String equProgress) {
		this.equProgress = equProgress;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", equOrderChildNo=" + equOrderChildNo + ", equProductCode=" + equProductCode
				+ ", equUseStatedsp=" + equUseStatedsp + ", equStatedsp=" + equStatedsp + ", equCode=" + equCode
				+ ", equStartTime=" + equStartTime + ", equUseState=" + equUseState + ", equMaintainState="
				+ equMaintainState + ", equMaintainStatedsp=" + equMaintainStatedsp + ", equProductName="
				+ equProductName + ", equModel=" + equModel + ", equState=" + equState + ", equId=" + equId
				+ ", equRunningState=" + equRunningState + ", equRepairStatedsp=" + equRepairStatedsp + ", equQuantity="
				+ equQuantity + ", equDataMode=" + equDataMode + ", equStopReason=" + equStopReason
				+ ", equDeviceOrderCount=" + equDeviceOrderCount + ", equAlarmCount=" + equAlarmCount
				+ ", equCompleteQuantity=" + equCompleteQuantity + ", equQualifiedQuantity=" + equQualifiedQuantity
				+ ", equRepairState=" + equRepairState + ", equProgress=" + equProgress + "]";
	}

	

}
