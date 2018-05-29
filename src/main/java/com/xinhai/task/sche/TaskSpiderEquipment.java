package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.Equipment;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.HttpClientUtil;

public class TaskSpiderEquipment {
	private static final Logger log = LoggerFactory.getLogger(TaskSpiderEquipment.class);

	public TaskSpiderEquipment() {
		String URL = "http://192.168.27.248:8080/XinhaiMes/MesRoot/Monitor/getViewInfo";
		String jsonStr = HttpClientUtil.getPost(URL, new ArrayList<NameValuePair>());
		// 2.解析数据结构
		// easyUI的数据结构
		try {
			String rows = JSONObject.parseObject(jsonStr).getString("rows");
			List<JSONObject> datas = JSONArray.parseArray(rows, JSONObject.class);
			if (null == datas || datas.isEmpty())
				return;
			List<Equipment> insLists = new ArrayList<Equipment>();
			// 3.获得数据信息
			for (JSONObject jsonObj : datas) {
				Equipment obj = new Equipment();
				obj.setEquOrderChildNo(jsonObj.getString("orderchildno"));
				obj.setEquProductCode(jsonObj.getString("orderchildno"));
				obj.setEquUseStatedsp(jsonObj.getString("usestatedsp"));
				obj.setEquStatedsp(jsonObj.getString("statedsp"));
				obj.setEquCode(jsonObj.getString("code"));
				obj.setEquStartTime(jsonObj.getTimestamp("starttime"));
				obj.setEquUseState(jsonObj.getString("usestate"));
				obj.setEquMaintainState(jsonObj.getString("maintainstate"));
				obj.setEquMaintainStatedsp(jsonObj.getString("maintainstatedsp"));
				obj.setEquProductName(jsonObj.getString("maintainstatedsp"));
				obj.setEquModel(jsonObj.getString("model"));
				obj.setEquState(jsonObj.getString("state"));
				obj.setEquId(jsonObj.getIntValue("id"));
				obj.setEquRunningState(jsonObj.getString("runningstate"));
				obj.setEquRepairStatedsp(jsonObj.getString("repairstatedsp"));
				obj.setEquQuantity(jsonObj.getString("quantity"));
				obj.setEquDataMode(jsonObj.getString("datamode"));
				obj.setEquStopReason(jsonObj.getString("stopreason"));
				obj.setEquDeviceOrderCount(jsonObj.getIntValue("deviceordercount"));
				obj.setEquAlarmCount(jsonObj.getString("deviceordercount"));
				obj.setEquCompleteQuantity(jsonObj.getString("completequantity"));
				obj.setEquQualifiedQuantity(jsonObj.getString("qualifiedquantity"));
				obj.setEquRepairState(jsonObj.getString("repairstate"));
				obj.setEquProgress(jsonObj.getString("progress"));
				insLists.add(obj);
			}
			ISpiderService service = new SpiderServiceImpl();
			if (!service.insEquipment(insLists)) {
				log.info("调度任务【获取机台信息】执行成功,保存数据失败");
			}
		} catch (NumberFormatException e) {
			log.error("调度任务【获取机台信息】解析数据报文失败,失败原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("调度任务【获取机台信息】异常,异常原因:" + e.getMessage());
		}
	}
}
