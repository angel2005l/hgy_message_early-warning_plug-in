package com.xinhai.service;

import java.util.List;

import com.xinhai.entity.Equipment;
import com.xinhai.entity.Event;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldDevice;
import com.xinhai.entity.Warning;

public interface ISpiderService {

	/*
	 * 爬取数据
	 */

	// 预警爬取
	public boolean insWarning(List<Warning> data) throws Exception;

	// 预警类型
	public boolean insWarningType(List<Event> data) throws Exception;

	/*
	 * OEE部分 及模具保养
	 */

	// 模具数据
	public boolean insMould(List<Mould> data) throws Exception;

	public List<String> selMouleIdAll() throws Exception;

	// 模具设备关联关系
	public boolean insMouldDevice(List<MouldDevice> data, String mouldId) throws Exception;

	// 机台数据
	public boolean insEquipment(List<Equipment> data) throws Exception;

}
