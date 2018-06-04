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
import com.xinhai.util.StrUtil;

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
				obj.setId(jsonObj.getIntValue("id"));
				obj.setMouldCode(jsonObj.getString("code"));
				obj.setMouldName(jsonObj.getString("name"));
				obj.setMouldType(jsonObj.getString("type"));
				obj.setMouldState(jsonObj.getString("state"));
				obj.setMouldUseState(jsonObj.getString("usestate"));
				obj.setMouldMaintainState(jsonObj.getString("maintainstate"));
				obj.setMouldRepairState(jsonObj.getString("repairstate"));
				obj.setMouldHolesNum(jsonObj.getIntValue("holesnum"));
				obj.setMouldLifeTimes(jsonObj.getIntValue("lifetimes"));
				obj.setMouldInternalTimes(
						StrUtil.isBlank(jsonObj.getString("internaltimes")) ? 0 : jsonObj.getIntValue("internaltimes"));
				obj.setMouldExternalTimes(
						StrUtil.isBlank(jsonObj.getString("externaltimes")) ? 0 : jsonObj.getIntValue("externaltimes"));
				obj.setMouldProduceCycle(jsonObj.getString("producecycle"));
				obj.setMouldQuantityQuota(jsonObj.getString("quantityquota"));
				obj.setMouldChangeOverTime(jsonObj.getString("changeovertime"));
				obj.setMouldWeekCapacity(
						StrUtil.isBlank(jsonObj.getString("weekcapacity")) ? 0 : jsonObj.getIntValue("weekcapacity"));
				obj.setMouldPrimaryMode(
						StrUtil.isBlank(jsonObj.getString("primarymode")) ? 0 : jsonObj.getIntValue("primarymode"));
				obj.setMouldSecondaryMode(
						StrUtil.isBlank(jsonObj.getString("secondarymode")) ? 0 : jsonObj.getIntValue("secondarymode"));
				obj.setMouldThirdMode(
						StrUtil.isBlank(jsonObj.getString("thirdmode")) ? 0 : jsonObj.getIntValue("thirdmode"));
				obj.setMouldAcceptDate(jsonObj.getString("acceptdate"));
				obj.setMouldModelUseStateNew(jsonObj.getString("modelusestatenew"));
				obj.setMouldRemainingTimes(StrUtil.isBlank(jsonObj.getString("remainingtimes")) ? 0
						: jsonObj.getIntValue("remainingtimes"));
				obj.setMouldRuleCode("default_rule");
				obj.setPushRuleCode("default_mould_rule");
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
