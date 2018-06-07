package com.xinhai.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ICoreDao;
import com.xinhai.dao.IMouldDao;
import com.xinhai.dao.impl.CoreDaoImpl;
import com.xinhai.dao.impl.MouldDaoImpl;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldWithRule;
import com.xinhai.entity.WarningWithRule;
import com.xinhai.service.ICoreService;
import com.xinhai.util.DateUtil;
import com.xinhai.util.StrUtil;
import com.xinhai.util.WeiXinUtil;

public class CoreServiceImpl implements ICoreService {
	private static final Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);
	private ICoreDao dao = new CoreDaoImpl();
	private IMouldDao mouldDao = new MouldDaoImpl();

	@Override
	public void warningPush() throws Exception {
		// 查询预警信息 并且带上类型所绑定的 四级推送规则
		try {
			// 预警信息+ 预警规则
			List<WarningWithRule> selWarningPush = dao.selectWarningPush();

			// 获得4级的人员信息
			String firstToken = dao.selectUserTokenByLevel(1);
			String secondToken = dao.selectUserTokenByLevel(2);
			String thirdToken = dao.selectUserTokenByLevel(3);
			String fouredToken = dao.selectUserTokenByLevel(4);
			// 经行预警通知
			for (WarningWithRule wr : selWarningPush) {
				StringBuffer pushTokens = new StringBuffer();
				String index = wr.getReadStatus();
				long time = wr.getCreateTime().getTime();
				switch (index) {
				case "0":
					if (wr.getRuleFirstTime() == 0 || isPushWarn(time, wr.getRuleFirstTime())) {
						index = "1";
						if (StrUtil.notBlank(firstToken)) {
							pushTokens.append(firstToken).append(",");
						}
					} else {
						break;
					}
				case "1":
					if (wr.getRuleFirstTime() == 0 || isPushWarn(time, wr.getRuleSecondTime())) {
						index = "2";
						if (StrUtil.notBlank(secondToken)) {
							pushTokens.append(secondToken).append(",");
						}
					} else {
						break;
					}
				case "2":
					if (wr.getRuleFirstTime() == 0 || isPushWarn(time, wr.getRuleThirdTime())) {
						index = "3";
						if (StrUtil.notBlank(thirdToken)) {
							pushTokens.append(thirdToken).append(",");
						}
					} else {
						break;
					}
				case "3":
					if (wr.getRuleFirstTime() == 0 || isPushWarn(time, wr.getRuleFourthTime())) {
						index = "4";
						if (StrUtil.notBlank(fouredToken)) {
							pushTokens.append(fouredToken).append(",");
						}
					}
					break;
				default:
					continue;
				}
				// 推送微信并且更新状态
				WeiXinUtil.sendWarning(wr, StrUtil.cutStringForLeft(pushTokens.toString(), 1));
				dao.updateWarningPush(wr.getGuid(), index);
			}
		} catch (SQLException e) {
			log.error("推送预警信息数据库交互异常,异常原因" + e.getMessage());
		}

	}

	private boolean isPushWarn(long creatTime, int pushMinute) {
		return (System.currentTimeMillis() - creatTime) / (1000 * 60) >= pushMinute;
	}

	@Override
	public void mouldPush() throws Exception {
		// 1.查询模具信息及规则
		List<MouldWithRule> mwrList = mouldDao.selectMouldWithRule();
		// 获得4级的人员信息
		String firstToken = dao.selectUserTokenByLevel(1);
		String secondToken = dao.selectUserTokenByLevel(2);
		String thirdToken = dao.selectUserTokenByLevel(3);
		String fouredToken = dao.selectUserTokenByLevel(4);
		String[] tokens = { firstToken, secondToken, thirdToken, fouredToken };
		for (MouldWithRule mouldWithRule : mwrList) {
			// 包含了核心校验数据
			// 查询日志的有无
			MouldLog mouldLog = mouldDao.selectMouldLogByMouldId(mouldWithRule.getId());

			int nowTimes = mouldWithRule.getMouldExternalTimes() + mouldWithRule.getMouldInternalTimes();
			int intervalTimes = mouldWithRule.getMouldRuleTimes();
			String pushMode = "silence";// normal：默认||alert：提醒||silence：静默
			MouldLog data = null;
			if (null == mouldLog) {
				// 那么是第一次进入模具预报管理
				// 判断是否需要模具预警
				if (isPushMould(nowTimes, 0, intervalTimes)) {
					// 创建日志
					data = new MouldLog();
					data.setMouldLogCode("log" + DateUtil.curDateYMDHMSSForService());
					data.setMouldLogName(
							"模具：【" + mouldWithRule.getMouldName() + "】与" + DateUtil.curDateYMD() + "的计划保养日志");
					data.setMouldPlanTimes(nowTimes);
					data.setMouldLogStatus("1");
					data.setMouldId(mouldWithRule.getId());
					// 推送提醒
					pushMode = "normal";
				}
			} else {
				// 有日志
				if ("1".equals(mouldLog.getMouldLogStatus())) {
					// 有最新的未完成的保养记录

					if (isPushMould(nowTimes, mouldLog.getMouldPlanTimes(), intervalTimes)) {
						// 微信预警
						pushMode = "alert";
					}
				} else {
					if (isPushMould(nowTimes, mouldLog.getMouldRealTimes(), intervalTimes)) {
						// 创建日志
						data = new MouldLog();
						data.setMouldLogCode("log" + DateUtil.curDateYMDHMSSForService());
						data.setMouldLogName(
								"模具：【" + mouldWithRule.getMouldName() + "】于" + DateUtil.curDateYMD() + "的计划保养");
						data.setMouldPlanTimes(nowTimes);
						data.setMouldLogStatus("1");
						data.setMouldId(mouldWithRule.getId());
						// 推送提醒
						pushMode = "normal";

					}
				}
			}

			// 进行推送
			if (!"silence".equals(pushMode)) {
				String[] pushTimes = mouldWithRule.getRuleTimes().split(",");
				StringBuffer userTokens = new StringBuffer();
				for (int index = 0; index < 4; index++) {
					if (StrUtil.isBlank(pushTimes[index])) {
						continue;
					} else if (Integer.parseInt(pushTimes[index] ) >= 0 && StrUtil.notBlank(tokens[index])) {
						userTokens.append(tokens[index]).append(",");
					}
				}
				WeiXinUtil.sendMould(StrUtil.cutStringForLeft(userTokens.toString(), 1),
						"alert".equals(pushMode) ? "记录编码:【"+mouldLog.getMouldLogCode()+"】,记录名称【"+mouldLog.getMouldLogName() + "】未完成计划保养" : data.getMouldLogName());
			}
			// 创建文件
			if (null != data) {
				mouldDao.insertMouldLog(data);
			}

		}
	}

	private boolean isPushMould(int nowTimes, int historyTimes, int intervalTimes) {
		if (nowTimes - historyTimes > intervalTimes) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Object[]> selOEEInfoALL() throws Exception {
		List<Object[]> data = new ArrayList<Object[]>();

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

		List<Map<String, Object>> selectOEE = dao.selectOEE();
		for (Map<String, Object> map : selectOEE) {
			Object[] oeeInfo = new Object[2];
			oeeInfo[0] = map.get("equ_code");
			if ("duWork".equals(map.get("equ_use_state"))) {
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
				BigDecimal output = new BigDecimal(map.get("equ_complete_quantity").toString()); // AG

				BigDecimal quaQty = new BigDecimal(map.get("equ_qualified_quantity").toString());
				BigDecimal outputPart = output.compareTo(BigDecimal.ZERO) == 0 && quaQty.compareTo(BigDecimal.ZERO) == 0
						? BigDecimal.ZERO
						: quaQty.divide(output, 4, BigDecimal.ROUND_HALF_UP);
				// (AG5*G5/3600/F5/AF5))
				// AG5=产量
				// G5=循环时间(DESIGNCYCLE TIME)
				// F5=型腔数（CAV）
				// AF5=实际运行时间art
				BigDecimal mouldPart = output.multiply(new BigDecimal(map.get("produce_cycle").toString())).divide(
						new BigDecimal("3600").multiply(new BigDecimal(map.get("holes_num").toString())).multiply(art),
						4, BigDecimal.ROUND_HALF_UP);
				BigDecimal result = timePart.multiply(outputPart).multiply(mouldPart)
						.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
				oeeInfo[1] = result;
			} else {
				oeeInfo[1] = BigDecimal.ZERO;
			}
			data.add(oeeInfo);
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> selWarnDay() throws Exception {
		try {
			List<Map<String, Object>> selectWarnDay = dao.selectWarnDay();
			if (null == selectWarnDay || selectWarnDay.isEmpty()) {
				return null;
			}
			return selectWarnDay;
		} catch (SQLException e) {
			log.error("查询当天预警信息异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public List<String[]> selWarn7Day() throws Exception {
		try {
			List<String[]> selectWarn7Day = dao.selectWarn7Day();
			return null == selectWarn7Day || selectWarn7Day.isEmpty() ? null : selectWarn7Day;
		} catch (SQLException e) {
			log.error("查询近七天预警次数数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public List<Map<String, String>> selEquProduceType() throws Exception {
		try {
			List<Map<String, String>> selectEquProduceType = dao.selectEquProduceType();
			return null == selectEquProduceType || selectEquProduceType.isEmpty() ? null : selectEquProduceType;
		} catch (SQLException e) {
			log.error("查询近七天预警次数数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}

	@Override
	public List<Map<String, String>> selWarnWeekTop5() throws Exception {
		try {
			List<Map<String, String>> selectWarnWeekTop5 = dao.selectWarnWeekTop5();
			return null == selectWarnWeekTop5 || selectWarnWeekTop5.isEmpty() ? null : selectWarnWeekTop5;
		} catch (SQLException e) {
			log.error("查询预警一周最高top5数据接口异常,异常原因:" + e.toString());
			return null;
		}
	}
}
