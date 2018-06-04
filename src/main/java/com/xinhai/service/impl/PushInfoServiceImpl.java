package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ICoreDao;
import com.xinhai.dao.IPushInfoDao;
import com.xinhai.dao.impl.CoreDaoImpl;
import com.xinhai.dao.impl.PushInfoDaoImpl;
import com.xinhai.entity.Email;
import com.xinhai.entity.Warning;
import com.xinhai.service.IPushInfoService;
import com.xinhai.util.DateUtil;

public class PushInfoServiceImpl implements IPushInfoService {

	private static final Logger log = LoggerFactory.getLogger(PushRuleServiceImpl.class);
	private IPushInfoDao dao = new PushInfoDaoImpl();
	private ICoreDao coreDao = new CoreDaoImpl();

	@Override
	public Warning selWarnInfo(String guid) throws Exception {
		try {
			return dao.selectWarn(guid);
		} catch (SQLException e) {
			log.error("查询预警详情异常 ,异常原因:" + e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Email selWarnInfoWeek() throws Exception {
		try {

			Map<String, Object> resultMap = dao.selectWarnWeek();
			String selectUserEmailByLevel = coreDao.selectUserEmailByLevel(4);

			List<Warning> solveWarn = (List<Warning>) resultMap.get("warnWeekSolveWarn");
			List<Warning> unsolveWarn = (List<Warning>) resultMap.get("warnWeekUnsolveWarn");
			List<Map<String, String>> warnTop5 = (List<Map<String, String>>) resultMap.get("warnWeekTop5");
			Email email = new Email();
			email.setEmail(selectUserEmailByLevel);
			email.seteTitle(DateUtil.curDateYM() + "预警周报");
			email.setSendName("MES预警通知辅助系统");
			email.setHtml(getHtml("MES预警通知辅助系统-" + DateUtil.curDateYM() + "预警周报", solveWarn, unsolveWarn, warnTop5));
			return email;
		} catch (SQLException e) {
			log.error("查询预警周报告异常,异常原因:" + e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Email selWarnInfoMonth() throws Exception {
		try {

			Map<String, Object> resultMap = dao.selectWarnMonth();
			String selectUserEmailByLevel = coreDao.selectUserEmailByLevel(4);
			List<Warning> solveWarn = (List<Warning>) resultMap.get("warnMonthSolveWarn");
			List<Warning> unsolveWarn = (List<Warning>) resultMap.get("warnMonthUnsolveWarn");
			List<Map<String, String>> warnTop5 = (List<Map<String, String>>) resultMap.get("warnMonthTop5");
			Email email = new Email();
			email.setEmail(selectUserEmailByLevel);
			email.seteTitle(DateUtil.curDateYM() + "预警月报");
			email.setSendName("MES预警通知辅助系统");
			email.setHtml(getHtml("MES预警通知辅助系统-" + DateUtil.curDateYM() + "预警月报", solveWarn, unsolveWarn, warnTop5));
			return email;
		} catch (SQLException e) {
			log.error("查询预警周报告异常,异常原因:" + e.toString());
			return null;
		}
	}

	private String getHtml(String title, List<Warning> data1, List<Warning> data2, List<Map<String, String>> data3) {
		StringBuffer html = new StringBuffer();

		html.append("<p style='text-align:left;'><b><b><b><b><span style='font-size:32px;'>").append(title)
				.append("</span></b></b></b></b></p>");
		html.append("<p style='text-align:left;'><span style='font-size:16px;'>预警记录数:")
				.append(data1.size() + data2.size()).append("</span></p>");
		html.append(
				"<p style='text-align:left;'><span style='font-size:16px;'>次数最多预警类型top5：</span></p><p style='text-align:left;'><span style='font-size:16px;'>");
		for (Map<String, String> map : data3) {
			html.append(map.get("name")).append(" : ").append(map.get("value")).append("; ");
		}
		html.append("</span><span style='font-size:16px;'></span></p>");
		html.append("<p style='text-align:left;'><span style='font-size:16px;'>已解决预警数量：").append(data1.size())
				.append(";</span></p>");
		html.append("<p style='text-align:left;'><span style='font-size:16px;'>未解决预警数量：").append(data2.size())
				.append(";</span></p>");
		html.append("<p style='text-align:left;'><span style='font-size:16px;'>未解决预警详细内容：</span></p>");
		for (Warning warning : data2) {
			html.append(
					"<p style='text-align:left;'><span style='font-size:16px;'><span style='white-space:normal;font-size:16px;'>【预警标题】：")
					.append(warning.getTitle())
					.append("</span><span style='white-space:normal;font-size:16px;'>【预警内容】：")
					.append(warning.getMessage())
					.append("</span><span style='white-space:normal;font-size:16px;'>【预警日期】：")
					.append(DateUtil.curDateByStr(warning.getCreateTime().toString(), ""))
					.append("</span></span> </p>");
		}
		return html.toString();
	}

}
