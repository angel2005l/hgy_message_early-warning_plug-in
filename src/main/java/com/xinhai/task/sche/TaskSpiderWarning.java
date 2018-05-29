package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.Warning;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.DateUtil;
import com.xinhai.util.HttpClientUtil;
import com.xinhai.util.StrUtil;

public class TaskSpiderWarning {
	private static final Logger log = LoggerFactory.getLogger(TaskSpiderWarning.class);

	public TaskSpiderWarning() {
		String URL = "http://192.168.27.248:8080/XinhaiMes/MesRoot/Produce/NotifyAlert/queryAlertRecord";

		// 1.获得数据报文
		String jsonStr = HttpClientUtil.getPost(URL, new ArrayList<NameValuePair>());
		// 2.解析json
		// 2.1解析jsonStr报文 rows部分
		try {
			String rows = JSONObject.parseObject(jsonStr).getString("rows");
			// 2.2转化数组，遍历集合
			List<JSONObject> rowsList = JSONArray.parseArray(rows, JSONObject.class);
			if (null == rowsList || rowsList.isEmpty())
				return;
			List<Warning> insLists = new ArrayList<Warning>();
			for (JSONObject jsonObj : rowsList) {
				Warning obj = new Warning();// 实例化存储数据
				obj.setEventId(jsonObj.getString("eventid"));
				obj.setEventCode(
						StrUtil.isBlank(jsonObj.getString("eventtype")) ? "0" : jsonObj.getString("eventtype"));
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
			ISpiderService service = new SpiderServiceImpl();
			if (!service.insWarning(insLists)) {
				log.info("调度任务【获取预警信息】执行成功,保存数据失败");
			}
		} catch (NumberFormatException e) {
			log.error("调度任务【获取预警信息】解析数据报文失败,失败原因:" + e.getMessage());
		} catch (Exception e) {
			log.error("调度任务【获取预警信息】异常,异常原因:" + e.getMessage());
		}
	}

	public static void main(String[] arg) {
		new TaskSpiderWarning();
	}
}
