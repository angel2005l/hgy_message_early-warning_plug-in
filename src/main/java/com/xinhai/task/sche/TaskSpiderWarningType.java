package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.Event;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.HttpClientUtil;

public class TaskSpiderWarningType {
	private static final Logger log = LoggerFactory.getLogger(TaskSpiderWarning.class);

	public TaskSpiderWarningType() {

		String URL = "http://192.168.27.248:8080/XinhaiMes/MesRoot/sysadm/DictManager/getDictListByPid?id=1502";
		String jsonStr = HttpClientUtil.getPost(URL, new ArrayList<NameValuePair>());
		// 2.解析json
		// 2.1解析jsonStr报文 rows部分
		try {
			String rows = JSONObject.parseObject(jsonStr).getString("rows");
			// 2.2转化数组，遍历集合
			List<JSONObject> rowsList = JSONArray.parseArray(rows, JSONObject.class);
			if (null == rowsList || rowsList.isEmpty())
				return;
			List<Event> insLists = new ArrayList<Event>();
			for (JSONObject jsonObj : rowsList) {
				Event obj = new Event();
				obj.setEventId(jsonObj.getIntValue("id"));
				obj.setEventCode(jsonObj.getString("code"));
				obj.setEventName(jsonObj.getString("name"));
				obj.setpId(jsonObj.getIntValue("pid"));
				obj.setRuleCode("default_rule");
				obj.setEventStatus("1");
				insLists.add(obj);
			}

			ISpiderService service = new SpiderServiceImpl();
			if (!service.insWarningType(insLists)) {
				log.info("调度任务【获取预警分类信息】执行成功,保存数据失败");
			}
		} catch (NumberFormatException e) {
			log.error("调度任务【获取预警分类信息】解析数据报文失败,失败原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("调度任务【获取预警分类信息】异常,异常原因:" + e.getMessage());
		}
	}
}