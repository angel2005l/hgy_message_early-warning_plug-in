package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ISpiderDao;
import com.xinhai.dao.impl.SpiderDaoImpl;
import com.xinhai.entity.Equipment;
import com.xinhai.entity.Event;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldDevice;
import com.xinhai.entity.Warning;
import com.xinhai.service.ISpiderService;
import com.xinhai.util.StrUtil;

public class SpiderServiceImpl implements ISpiderService {
	private static final Logger log = LoggerFactory.getLogger(SpiderDaoImpl.class);
	private ISpiderDao dao = new SpiderDaoImpl();

	@Override
	public boolean insWarning(List<Warning> data) throws Exception {
		if (null == data || data.isEmpty()) {
			log.info("采集的预警信息数据为空.");
			return true;
		}
		try {
			return dao.insertWarning(data, false);
		} catch (SQLException e) {
			log.error("保存预警信息异常,异常原因：" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean insWarningType(List<Event> data) throws Exception {
		if (null == data || data.isEmpty()) {
			log.info("采集的预警类型信息数据为空.");
			return true;
		}
		try {
			return dao.insertWarnType(data);
		} catch (SQLException e) {
			log.error("保存预警分类信息异常,异常原因：" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean insMould(List<Mould> data) throws Exception {
		if (null == data || data.isEmpty()) {
			log.info("采集的模具信息数据为空.");
			return true;
		}
		try {
			return dao.insertMould(data);
		} catch (SQLException e) {
			log.error("保存模具信息异常,异常原因：" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean insMouldDevice(List<MouldDevice> data, String mouldId) throws Exception {
		if (null == data || data.isEmpty() || StrUtil.isBlank(mouldId)) {
			log.info("采集的模具设备关联信息数据为空.");
			return true;
		}
		try {
			// 先删除全部关联
			dao.deleteMouldDevice(Integer.parseInt(mouldId));
			// 插入新的关联信息
			return dao.insetrtMouldDevice(data);
		} catch (SQLException e) {
			log.error("保存模具设备关联信息异常,异常原因：" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean insEquipment(List<Equipment> data) throws Exception {
		if (null == data || data.isEmpty()) {
			log.info("采集的机台信息数据为空.");
			return true;
		}
		try {
			return dao.insertEquipment(data);
		} catch (SQLException e) {
			log.error("保存机台信息异常,异常原因：" + e.getMessage());
			return false;
		}
	}

	@Override
	public List<String> selMouleIdAll() throws Exception {
		try {
			return dao.selectMouldIdAll();
		} catch (SQLException e) {
			log.error("查询模具编号信息异常,异常原因：" + e.getMessage());
		}
		return null;
	}

}
