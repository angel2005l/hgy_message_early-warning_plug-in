package com.xinhai.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ICoreDao;
import com.xinhai.dao.impl.CoreDaoImpl;
import com.xinhai.entity.WarningWithRule;
import com.xinhai.service.ICoreService;
import com.xinhai.util.DateUtil;
import com.xinhai.util.StrUtil;
import com.xinhai.util.WeiXinUtil;

public class CoreServiceImpl implements ICoreService {
	private static final Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);
	private ICoreDao dao = new CoreDaoImpl();

	@Override
	public void warningPush() throws Exception {
		// 查询预警信息 并且带上类型所绑定的 四级推送规则
		try {
			// 预警信息+ 预警规则
			List<WarningWithRule> selWarningPush = dao.selWarningPush();

			// 获得4级的人员信息
			String firstToken = dao.selUserTokenByLevel(1);
			String secondToken = dao.selUserTokenByLevel(2);
			String thirdToken = dao.selUserTokenByLevel(3);
			String fouredToken = dao.selUserTokenByLevel(4);

			// 经行预警通知
			for (WarningWithRule wr : selWarningPush) {
				String index = wr.getReadStatus();
				long time = wr.getCreateTime().getTime();
				switch (index) {
				case "0":
					if ((wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime()))
							&& StrUtil.notBlank(firstToken)) {
						index = "1";
						WeiXinUtil.sendWarning(wr, firstToken);

					} else {
						break;
					}
				case "1":
					if ((wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime()))
							&& StrUtil.notBlank(secondToken)) {
						index = "2";
						WeiXinUtil.sendWarning(wr, secondToken);
					} else {
						break;
					}
				case "2":
					if ((wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime()))
							&& StrUtil.notBlank(thirdToken)) {
						index = "3";
						WeiXinUtil.sendWarning(wr, thirdToken);
					} else {
						break;
					}
				case "3":
					if ((wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime()))
							&& StrUtil.notBlank(fouredToken)) {
						index = "4";
						WeiXinUtil.sendWarning(wr, fouredToken);
					}
					break;
				default:

					break;
				}
				dao.uptWarningPush(wr.getGuid(), index);
			}
		} catch (SQLException e) {
			log.error("推送预警信息数据库交互异常,异常原因" + e.getMessage());
		}

	}

	private boolean isPush(long creatTime, int pushMinute) {
		return (System.currentTimeMillis() - creatTime) / (1000 * 60) >= pushMinute;
	}

	@Override
	public void mouldPush() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> selOEEInfoALL() throws Exception {
		// IF(产量=0,"",(实际运行时间/工作时间)*((产量-次品)/产量)*(产量*循环时间(DESIGNCYCLE
		// TIME)/3600/型腔数（CAV）/实际运行时间))
		/*
		 * OEE计算公式
		 */
		// IF(AG5=0,"",(AF5/AE5)*((AG5-AH5)/AG5)*(AG5*G5/3600/F5/AF5))
		// AF5=实际运行时间
		// AE5=工作时间
		// 这两个时间会有一点冲突 待解决！QAQ
		// AG5=产量
		// AH5=次品
		// G5=循环时间(DESIGNCYCLE TIME)
		// F5=型腔数（CAV）
		// List<Map<String, Object>> datas = dao.selectOEEDatas(StrUtil.isBlank(coldId)
		// ? 0 : Integer.parseInt(coldId));
		List<Map<String, Object>> datas = null;
		for (Map<String, Object> map : datas) {
			if ("duWork".equals(map.get("use_state"))) {
				// (AF5/AE5)
				// AF5=实际运行时间
				// AE5=工作时间
				// H 0.5向上取整
				// String ACTUAL_RUN_TIME =
				// DateUtil.getDay(map.get("start_time").toString());
				// String WORKING_HOUR =
				// DateUtil.getDay(map.get("start_time").toString());
				BigDecimal art = new BigDecimal(DateUtil.getHour(map.get("start_time").toString()));// AF
				BigDecimal wh = new BigDecimal(DateUtil.getHour(map.get("start_time").toString()));// AE
				BigDecimal timePart = art.divide(wh, 4, BigDecimal.ROUND_HALF_UP);// 获得
				// ((AG5-AH5)/AG5)
				// AG5=产量
				// AH5=次品
				BigDecimal output = new BigDecimal(map.get("com_qty").toString()); // AG

				BigDecimal quaQty = new BigDecimal(map.get("qua_qty").toString());
				// BigDecimal reject = new
				// BigDecimal(map.get("qua_qty").toString()); // AH
				BigDecimal outputPart = quaQty.divide(output, 4, BigDecimal.ROUND_HALF_UP);
				// (AG5*G5/3600/F5/AF5))
				// AG5=产量
				// G5=循环时间(DESIGNCYCLE TIME)
				// F5=型腔数（CAV）
				// AF5=实际运行时间art
				BigDecimal mouldPart = output.multiply(new BigDecimal(map.get("mpc").toString())).divide(
						new BigDecimal("3600").multiply(new BigDecimal(map.get("mhn").toString())).multiply(art), 4,
						BigDecimal.ROUND_HALF_UP);
				// 出招表 x x
				BigDecimal result = timePart.multiply(outputPart).multiply(mouldPart)
						.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
				map.put("oee", result);
			}
		}
		return datas;
	}
}
