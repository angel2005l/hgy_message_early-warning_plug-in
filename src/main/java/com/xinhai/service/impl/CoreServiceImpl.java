package com.xinhai.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinhai.dao.ICoreDao;
import com.xinhai.dao.impl.CoreDaoImpl;
import com.xinhai.entity.WarningWithRule;
import com.xinhai.service.ICoreService;
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
				String index = "0";
				long time = wr.getCreateTime().getTime();
				switch (wr.getReadStatus()) {
				case "0":
					if (wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime())) {
						index = "1";
						WeiXinUtil.sendWarning(wr, firstToken);

					} else {
						break;
					}
				case "1":
					if (wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime())) {
						index = "2";
						WeiXinUtil.sendWarning(wr, secondToken);
					} else {
						break;
					}
				case "2":
					if (wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime())) {
						index = "3";
						WeiXinUtil.sendWarning(wr, thirdToken);
					} else {
						break;
					}
				case "3":
					if (wr.getRuleFirstTime() == 0 || isPush(time, wr.getRuleFirstTime())) {
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
		// TODO Auto-generated method stub
		return null;
	}
}
