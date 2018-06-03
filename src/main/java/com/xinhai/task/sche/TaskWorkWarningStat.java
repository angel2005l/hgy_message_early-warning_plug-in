package com.xinhai.task.sche;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.entity.Email;
import com.xinhai.service.IPushInfoService;
import com.xinhai.service.impl.PushInfoServiceImpl;
import com.xinhai.util.DateUtil;
import com.xinhai.util.EmailUtil;

public class TaskWorkWarningStat {
	private static Logger log = LoggerFactory.getLogger(TaskWorkWarningStat.class);
	// 每日执行一次

	public TaskWorkWarningStat(String type) {
		IPushInfoService service = new PushInfoServiceImpl();
		try {
			Email email = null;
			switch (type) {
			case "week":
				if (DateUtil.getWeekNum() != 1) {
					return;
				}
				email = service.selWarnInfoWeek();
				break;
			case "month":
				if (DateUtil.getMonthNum() != 1) {
					return;
				}
				email = service.selWarnInfoMonth();
				break;
			default:
				email = service.selWarnInfoWeek();
				break;
			}
			String[] emailUrls = email.getEmail().split(",");
			for (String url : emailUrls) {
				String rtnResult = EmailUtil.sendEmail(email, url);
				log.info("预警统计报告PHP邮件接口调用反馈报文" + rtnResult);
			}

		} catch (Exception e) {
			log.error("预警统计报告任务异常,异常原因:" + e.toString());
		}
	}

}
