package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.Warning;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.DateUtil;
import com.xinhai.util.HttpClientUtil;

public class TaskSpiderWarning {

	public TaskSpiderWarning() {
		String URL = "http://192.168.27.248:8080/XinhaiMes/MesRoot/Produce/NotifyAlert/queryAlertRecord";

		ISpiderService service = new SpiderServiceImpl();
		// 1.获得数据报文
		String jsonStr = HttpClientUtil.getPost(URL, new ArrayList<NameValuePair>());
		// 2.解析json
		// 2.1解析jsonStr报文 rows部分
		String rows = JSONObject.parseObject(jsonStr).getString("rows");
		// 2.2转化数组，遍历集合
		List<JSONObject> rowsList = JSONArray.parseArray(rows, JSONObject.class);
		if (null == rowsList || rowsList.isEmpty())
			return;
		List<Warning> insLists = new ArrayList<Warning>();
		for (JSONObject jsonObj : rowsList) {
			Warning obj = new Warning();// 实例化存储数据
			obj.setEventId(jsonObj.getString("eventid"));
			obj.setEventCode(jsonObj.getString("eventtype"));
			obj.setLevelType(jsonObj.getIntValue("leveltype"));
			obj.setMessage(jsonObj.getString("message"));
			obj.setTitle(jsonObj.getString("title"));
			obj.setEventType(obj.getEventTypeForIns());
			obj.setDeviceId(jsonObj.getString("deviceid"));
			obj.setReliever(jsonObj.getString("reliever"));
			obj.setRelieveTime(DateUtil.curTimestampByStr(jsonObj.getString("relievetime").trim()));
			obj.setGuid(jsonObj.getString("guid"));
			obj.setObjectId(jsonObj.getString("objectid"));
			obj.setStatus(jsonObj.getString("status"));
			obj.setCreateTime(DateUtil.curTimestampByStr(jsonObj.getString("createtime").trim()));
			obj.setReadStatus("0");
			insLists.add(obj);
		}
	}

}
