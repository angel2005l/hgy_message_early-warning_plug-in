package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.Mould;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.HttpClientUtil;

public class TaskSpiderMould {
	private static final Logger log = LoggerFactory.getLogger(TaskSpiderMould.class);

	public TaskSpiderMould() {
		String URL = "http://192.168.27.248:8080/XinhaiMes/MesRoot/Mold/queryMoldBasic";
		String jsonStr = HttpClientUtil.getPost(URL, new ArrayList<NameValuePair>());
		try {
			String rows = JSONObject.parseObject(jsonStr).getString("rows");
			// 2.2转化数组，遍历集合
			List<JSONObject> rowsList = JSONArray.parseArray(rows, JSONObject.class);
			if (null == rowsList || rowsList.isEmpty())
				return;
			List<Mould> insLists = new ArrayList<Mould>();
			for (JSONObject jsonObj : rowsList) {
				Mould obj = new Mould();
				obj.setId(jsonObj.getIntValue(key));
				obj.setMouldFactoryId(jsonObj.getIntValue(key));
				obj.setMouldCode(jsonObj.getString(key));
				obj.setMouldName(jsonObj.getString(rows));
				obj.setMouldType(jsonObj.getString(key));
				obj.setMouldState(jsonObj.getString(key));
				obj.setMouldUseState(jsonObj.getString(key));
				obj.setMouldMaintainState(jsonObj.getString(key));
				obj.setMouldRepairState(jsonObj.getString(key));
				obj.setMouldHolesNum(jsonObj.getIntValue(key));
				obj.setMouldRealHoleUse(jsonObj.getIntValue(key));
				obj.setMouldLifeTimes(jsonObj.getIntValue(key));
				obj.setMouldInternalTimes(jsonObj.getIntValue(key));
				obj.setMouldExternalTimes(jsonObj.getIntValue(key));
				obj.setMouldProduceCycle(jsonObj.getString(key));
				obj.setMouldQuantityQuota(jsonObj.getString(key));
				obj.setMouldWeight(jsonObj.getString(key));
				obj.setMouldDimension(jsonObj.getString(key));
				obj.setMouldChangeOverTime(jsonObj.getString(key));
				obj.setMouldWeekCapacity(jsonObj.getIntValue(key));
				obj.setMouldSupplierNo(jsonObj.getString(key));
				obj.setMouldSupplier(jsonObj.getString(key));
				obj.setMouldPrimaryMode(jsonObj.getIntValue(key));
				obj.setMouldSecondaryMode(jsonObj.getIntValue(key));
				obj.setMouldThirdMode(jsonObj.getIntValue(key));
				obj.setMouldAcceptDate(jsonObj.getString(key));
				obj.setMouldFactory(jsonObj.getString(key));
				obj.setMouldManufacturers(jsonObj.getString(key));
				obj.setMouldStorage(jsonObj.getString(key));
				obj.setMouldCustomerName(jsonObj.getString(key));
				obj.setMouldModelUseStateNew(jsonObj.getString(key));
				obj.setMouldRemainingTimes(jsonObj.getIntValue(key));
				insLists.add(obj);
			}
			ISpiderService service = new SpiderServiceImpl();
			if (!service.insMould(insLists)) {
				log.info("调度任务【获取模具信息】执行成功,保存数据失败");
			}
		} catch (NumberFormatException e) {
			log.error("调度任务【获取模具信息】解析数据报文失败,失败原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("调度任务【获取模具信息】异常,异常原因:" + e.getMessage());
		}
	}
}
