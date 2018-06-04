package com.xinhai.entity;

public class Mould {
	private int id;// 模具编号
	private String mouldCode;// 模具编码
	private String mouldName;// 模具名称
	private String mouldType;// 模具类型
	private String mouldState;// 模具状态
	private String mouldUseState;// 模具使用状态
	private String mouldMaintainState;// 模具维修状态
	private String mouldRepairState;// 模具修复状态
	private int mouldHolesNum;// 型腔数
	private int mouldLifeTimes;// 模具寿命
	private int mouldInternalTimes;// 厂内打模次数
	private int mouldExternalTimes;// 外协打模次数
	private String mouldProduceCycle;// 生产周期
	private String mouldQuantityQuota;// 产量定额
	private String mouldChangeOverTime;// 预警换模时间
	private int mouldWeekCapacity;// 周生产能力
	private int mouldPrimaryMode;// 一级保养模次
	private int mouldSecondaryMode;// 二级保养模次
	private int mouldThirdMode;// 三级保养模次
	private String mouldAcceptDate;// 接受日期
	private String mouldModelUseStateNew;// 模具最新使用状态
	private int mouldRemainingTimes;// 剩余使用次数
	private String mouldRuleCode;
	private String pushRuleCode;

	public Mould() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMouldCode() {
		return mouldCode;
	}

	public void setMouldCode(String mouldCode) {
		this.mouldCode = mouldCode;
	}

	public String getMouldName() {
		return mouldName;
	}

	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}

	public String getMouldType() {
		return mouldType;
	}

	public void setMouldType(String mouldType) {
		this.mouldType = mouldType;
	}

	public String getMouldState() {
		return mouldState;
	}

	public void setMouldState(String mouldState) {
		this.mouldState = mouldState;
	}

	public String getMouldUseState() {
		return mouldUseState;
	}

	public void setMouldUseState(String mouldUseState) {
		this.mouldUseState = mouldUseState;
	}

	public String getMouldMaintainState() {
		return mouldMaintainState;
	}

	public void setMouldMaintainState(String mouldMaintainState) {
		this.mouldMaintainState = mouldMaintainState;
	}

	public String getMouldRepairState() {
		return mouldRepairState;
	}

	public void setMouldRepairState(String mouldRepairState) {
		this.mouldRepairState = mouldRepairState;
	}

	public int getMouldHolesNum() {
		return mouldHolesNum;
	}

	public void setMouldHolesNum(int mouldHolesNum) {
		this.mouldHolesNum = mouldHolesNum;
	}

	public int getMouldLifeTimes() {
		return mouldLifeTimes;
	}

	public void setMouldLifeTimes(int mouldLifeTimes) {
		this.mouldLifeTimes = mouldLifeTimes;
	}

	public int getMouldInternalTimes() {
		return mouldInternalTimes;
	}

	public void setMouldInternalTimes(int mouldInternalTimes) {
		this.mouldInternalTimes = mouldInternalTimes;
	}

	public int getMouldExternalTimes() {
		return mouldExternalTimes;
	}

	public void setMouldExternalTimes(int mouldExternalTimes) {
		this.mouldExternalTimes = mouldExternalTimes;
	}

	public String getMouldProduceCycle() {
		return mouldProduceCycle;
	}

	public void setMouldProduceCycle(String mouldProduceCycle) {
		this.mouldProduceCycle = mouldProduceCycle;
	}

	public String getMouldQuantityQuota() {
		return mouldQuantityQuota;
	}

	public void setMouldQuantityQuota(String mouldQuantityQuota) {
		this.mouldQuantityQuota = mouldQuantityQuota;
	}

	public String getMouldChangeOverTime() {
		return mouldChangeOverTime;
	}

	public void setMouldChangeOverTime(String mouldChangeOverTime) {
		this.mouldChangeOverTime = mouldChangeOverTime;
	}

	public int getMouldWeekCapacity() {
		return mouldWeekCapacity;
	}

	public void setMouldWeekCapacity(int mouldWeekCapacity) {
		this.mouldWeekCapacity = mouldWeekCapacity;
	}

	public int getMouldPrimaryMode() {
		return mouldPrimaryMode;
	}

	public void setMouldPrimaryMode(int mouldPrimaryMode) {
		this.mouldPrimaryMode = mouldPrimaryMode;
	}

	public int getMouldSecondaryMode() {
		return mouldSecondaryMode;
	}

	public void setMouldSecondaryMode(int mouldSecondaryMode) {
		this.mouldSecondaryMode = mouldSecondaryMode;
	}

	public int getMouldThirdMode() {
		return mouldThirdMode;
	}

	public void setMouldThirdMode(int mouldThirdMode) {
		this.mouldThirdMode = mouldThirdMode;
	}

	public String getMouldAcceptDate() {
		return mouldAcceptDate;
	}

	public void setMouldAcceptDate(String mouldAcceptDate) {
		this.mouldAcceptDate = mouldAcceptDate;
	}

	public String getMouldModelUseStateNew() {
		return mouldModelUseStateNew;
	}

	public void setMouldModelUseStateNew(String mouldModelUseStateNew) {
		this.mouldModelUseStateNew = mouldModelUseStateNew;
	}

	public int getMouldRemainingTimes() {
		return mouldRemainingTimes;
	}

	public void setMouldRemainingTimes(int mouldRemainingTimes) {
		this.mouldRemainingTimes = mouldRemainingTimes;
	}

	public String getMouldRuleCode() {
		return mouldRuleCode;
	}

	public void setMouldRuleCode(String mouldRuleCode) {
		this.mouldRuleCode = mouldRuleCode;
	}

	public String getPushRuleCode() {
		return pushRuleCode;
	}

	public void setPushRuleCode(String pushRuleCode) {
		this.pushRuleCode = pushRuleCode;
	}

	@Override
	public String toString() {
		return "Mould [id=" + id + ", mouldCode=" + mouldCode + ", mouldName=" + mouldName + ", mouldType=" + mouldType
				+ ", mouldState=" + mouldState + ", mouldUseState=" + mouldUseState + ", mouldMaintainState="
				+ mouldMaintainState + ", mouldRepairState=" + mouldRepairState + ", mouldHolesNum=" + mouldHolesNum
				+ ", mouldLifeTimes=" + mouldLifeTimes + ", mouldInternalTimes=" + mouldInternalTimes
				+ ", mouldExternalTimes=" + mouldExternalTimes + ", mouldProduceCycle=" + mouldProduceCycle
				+ ", mouldQuantityQuota=" + mouldQuantityQuota + ", mouldChangeOverTime=" + mouldChangeOverTime
				+ ", mouldWeekCapacity=" + mouldWeekCapacity + ", mouldPrimaryMode=" + mouldPrimaryMode
				+ ", mouldSecondaryMode=" + mouldSecondaryMode + ", mouldThirdMode=" + mouldThirdMode
				+ ", mouldAcceptDate=" + mouldAcceptDate + ", mouldModelUseStateNew=" + mouldModelUseStateNew
				+ ", mouldRemainingTimes=" + mouldRemainingTimes + ", mouldRuleCode=" + mouldRuleCode
				+ ", pushRuleCode=" + pushRuleCode + "]";
	}

}
