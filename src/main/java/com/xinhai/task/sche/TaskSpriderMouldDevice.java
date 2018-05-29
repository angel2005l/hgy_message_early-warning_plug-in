package com.xinhai.task.sche;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinhai.entity.MouldDevice;
import com.xinhai.service.ISpiderService;
import com.xinhai.service.impl.SpiderServiceImpl;
import com.xinhai.util.HttpClientUtil;

public class TaskSpriderMouldDevice {
	private static final Logger log = LoggerFactory.getLogger(TaskSpriderMouldDevice.class);

	public TaskSpriderMouldDevice() {
		try {
			ISpiderService service = new SpiderServiceImpl();
			List<String> moldIds = service.selMouleIdAll();
			for (String moldId : moldIds) {
				String jsonStr = getMouldDeviceByMoId(moldId);// 获得json报文
				String rows = JSONObject.parseObject(jsonStr).getString("rows");
				List<JSONObject> datas = JSONArray.parseArray(rows, JSONObject.class);
				if (null == datas || datas.isEmpty())
					return;
				List<MouldDevice> insList = new ArrayList<MouldDevice>();
				for (JSONObject obj : datas) {
					MouldDevice md = new MouldDevice();
					md.setDeviceCode(obj.getString("devicecode"));
					md.setMoldId(obj.getIntValue("moldid"));
					md.setMoldCode(obj.getString("model"));
					md.setDeviceId(obj.getIntValue("deviceid"));
					insList.add(md);
				}
				service.insMouldDevice(insList, moldId);
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
	}

	private String getMouldDeviceByMoId(String moldId) {

		List<NameValuePair> datas = new ArrayList<NameValuePair>();
		datas.add(new BasicNameValuePair("moldid", moldId));
		String post = HttpClientUtil.getPost(
				"http://192.168.27.248:8080/XinhaiMes/MesRoot/Mold/MoldDeviceAsso/queryAssoDeviceByMold", datas);
		return post;
	}
}