package com.xinhai.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xinhai.dao.ISpiderDao;
import com.xinhai.entity.Equipment;
import com.xinhai.entity.Event;
import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldDevice;
import com.xinhai.entity.Warning;
import com.xinhai.util.DateUtil;
import com.xinhai.util.SqlPoolUtil;

public class SpiderDaoImpl implements ISpiderDao {
	private SqlPoolUtil instance = SqlPoolUtil.getInstance();

	@Override
	public boolean insertWarning(List<Warning> data, boolean isInit) throws SQLException {
		String sql = "insert into mpe_warning(event_id,event_type,event_code,title,message,device_id,guid,status,create_time,reliever,relieve_time,read_status)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?) on duplicate key update reliever=VALUES(reliever),relieve_time=VALUES(relieve_time),status=VALUES(status)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Warning obj : data) {
			// 进行数据筛选
			if (!isInit && !DateUtil.isThisMonth(obj.getCreateTime().getTime())) {
				continue;
			}
			ps.setString(1, obj.getEventId());
			ps.setString(2, obj.getEventType());
			ps.setString(3, obj.getEventCode());
			ps.setString(4, obj.getTitle());
			ps.setString(5, obj.getMessage());
			ps.setString(6, obj.getDeviceId());
			ps.setString(7, obj.getGuid());
			ps.setString(8, obj.getStatus());
			ps.setTimestamp(9, obj.getCreateTime());
			ps.setString(10, obj.getReliever());
			ps.setTimestamp(11, obj.getRelieveTime());
			ps.setString(12, obj.getReadStatus());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public boolean insertWarnType(List<Event> data) throws SQLException {
		String sql = "insert into mpe_event(event_id,event_code,event_name,event_pid) values(?,?,?,?) on duplicate key update event_code=VALUES(event_code), event_name=VALUES(event_name) ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Event obj : data) {
			ps.setInt(1, obj.getEventId());
			ps.setString(2, obj.getEventCode());
			ps.setString(3, obj.getEventName());
			ps.setInt(4, obj.getpId());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public boolean insertMould(List<Mould> data) throws SQLException {
		String sql = "insert into mpe_mould(mould_factory_id,mould_code,mould_name,mould_type,mould_state,mould_use_state,mould_maintain_state,mould_repair_state,mould_holes_num"
				+ ",mould_real_hole_use,mould_life_times,mould_internal_times,mould_external_times,mould_produce_cycle,mould_quantity_quota,mould_weight,mould_dimension,mould_change_over_time"
				+ ",mould_week_capacity,mould_supplier_no,mould_supplier,mould_primary_mode,mould_secondary_mode,mould_third_mode,mould_accept_date,mould_factory,mould_manufacturers,mould_storage"
				+ ",mould_customer_name,mould_model_use_state_new,mould_remaining_times)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
				+ "on duplicate key update mould_state=VALUES(mould_state),mould_use_state=VALUES(mould_use_state),"
				+ "mould_maintain_state=VALUES(mould_maintain_state),mould_repair_state=VALUES(mould_repair_state),mould_real_hole_use=VALUES(mould_real_hole_use)"
				+ ",mould_life_times=VALUES(mould_life_times),mould_internal_times=VALUES(mould_internal_times),mould_external_times=VALUES(mould_external_times)"
				+ ",mould_primary_mode=VALUES(mould_primary_mode),mould_secondary_mode=VALUES(mould_secondary_mode),mould_third_mode=VALUES(mould_third_mode),"
				+ "mould_model_use_state_new=VALUES(mould_model_use_state_new),mould_remaining_times=VALUES(mould_remaining_times)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Mould mould : data) {
			ps.setInt(1, mould.getMouldFactoryId());
			ps.setString(2, mould.getMouldCode());
			ps.setString(3, mould.getMouldName());
			ps.setString(4, mould.getMouldType());
			ps.setString(5, mould.getMouldState());
			ps.setString(6, mould.getMouldUseState());
			ps.setString(7, mould.getMouldMaintainState());
			ps.setString(8, mould.getMouldRepairState());
			ps.setInt(9, mould.getMouldHolesNum());
			ps.setInt(10, mould.getMouldRealHoleUse());
			ps.setInt(11, mould.getMouldLifeTimes());
			ps.setInt(12, mould.getMouldInternalTimes());
			ps.setInt(13, mould.getMouldExternalTimes());
			ps.setString(14, mould.getMouldProduceCycle());
			ps.setString(15, mould.getMouldQuantityQuota());
			ps.setString(16, mould.getMouldWeight());
			ps.setString(17, mould.getMouldDimension());
			ps.setString(18, mould.getMouldChangeOverTime());
			ps.setInt(19, mould.getMouldWeekCapacity());
			ps.setString(20, mould.getMouldSupplierNo());
			ps.setString(21, mould.getMouldSupplier());
			ps.setInt(22, mould.getMouldPrimaryMode());
			ps.setInt(23, mould.getMouldSecondaryMode());
			ps.setInt(24, mould.getMouldThirdMode());
			ps.setString(25, mould.getMouldAcceptDate());
			ps.setString(26, mould.getMouldFactory());
			ps.setString(27, mould.getMouldManufacturers());
			ps.setString(28, mould.getMouldStorage());
			ps.setString(29, mould.getMouldCustomerName());
			ps.setString(30, mould.getMouldModelUseStateNew());
			ps.setInt(31, mould.getMouldRemainingTimes());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public boolean insetrtMouldDevice(List<MouldDevice> data) throws SQLException {
		String sql = "insert into mpe_mould_device vaules(?,?,?,?) ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (MouldDevice md : data) {
			ps.setInt(1, md.getDeviceId());
			ps.setString(2, md.getDeviceCode());
			ps.setInt(3, md.getMoldId());
			ps.setString(4, md.getMoldCode());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public boolean deleteMouldDevice(int mouldId) throws SQLException {
		String sql = "delete from mpe_moild_device where mold_id=? ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, mouldId);
		int rtn = ps.executeUpdate();
		SqlPoolUtil.closeConnection(conn, ps, null);
		return rtn > -1 ? true : false;
	}

	@Override
	public boolean insertEquipment(List<Equipment> data) throws SQLException {
		String sql = "insert into mpe_equipment(equ_order_child_no,equ_product_code,equ_use_statedsp,equ_statedsp,equ_code,equ_start_time,"
				+ "equ_use_state,equ_maintain_state,equ_maintain_statedsp,equ_product_name,equ_model,equ_state,equ_equid,equ_running_state,equ_repair_statedsp,"
				+ "equ_quantity,equ_data_mode,equ_stop_reason,equ_device_order_count,equ_alarm_count,equ_complete_quantity,equ_qualified_quantity,equ_repair_state,equ_progress)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
				+ " on duplicate key update equ_order_child_no=values(equ_order_child_no),equ_use_statedsp=values(equ_use_statedsp),"
				+ "equ_statedsp=values(equ_statedsp),equ_start_time=values(equ_start_time),equ_use_state=values(equ_use_state),equ_maintain_state=values(equ_maintain_state),"
				+ "equ_maintain_statedsp=values(equ_maintain_statedsp),equ_product_name=values(equ_product_name),equ_model=values(equ_model),equ_state=values(equ_state),"
				+ "equ_running_state=values(equ_running_state),equ_repair_statedsp=values(equ_repair_statedsp),equ_quantity=values(equ_quantity),equ_data_mode=values(equ_data_mode),"
				+ "equ_stop_reason=values(equ_stop_reason),equ_device_order_count=values(equ_device_order_count),equ_alarm_count=values(equ_alarm_count),"
				+ "equ_complete_quantity=values(equ_complete_quantity),equ_qualified_quantity=values(equ_qualified_quantity),equ_repair_state=values(equ_repair_state),equ_progress=values(equ_progress)";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Equipment equ : data) {
			ps.setString(1, equ.getEquOrderChildNo());
			ps.setString(2, equ.getEquProductCode());
			ps.setString(3, equ.getEquUseStatedsp());
			ps.setString(4, equ.getEquStatedsp());
			ps.setString(5, equ.getEquCode());
			ps.setTimestamp(6, equ.getEquStartTime());
			ps.setString(7, equ.getEquUseState());
			ps.setString(8, equ.getEquMaintainState());
			ps.setString(9, equ.getEquMaintainStatedsp());
			ps.setString(10, equ.getEquProductName());
			ps.setString(11, equ.getEquModel());
			ps.setString(12, equ.getEquState());
			ps.setInt(13, equ.getEquId());
			ps.setString(14, equ.getEquRunningState());
			ps.setString(15, equ.getEquRepairStatedsp());
			ps.setString(16, equ.getEquQuantity());
			ps.setString(17, equ.getEquDataMode());
			ps.setString(18, equ.getEquStopReason());
			ps.setInt(19, equ.getEquDeviceOrderCount());
			ps.setString(20, equ.getEquAlarmCount());
			ps.setString(21, equ.getEquCompleteQuantity());
			ps.setString(22, equ.getEquQualifiedQuantity());
			ps.setString(23, equ.getEquRepairState());
			ps.setString(24, equ.getEquProgress());
			ps.executeUpdate();
		}
		SqlPoolUtil.closeConnection(conn, ps, null);
		return true;
	}

	@Override
	public List<String> selectMouldIdAll() throws SQLException {
		String sql = "select id from mpe_mould ";
		DruidPooledConnection conn = instance.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<String> result = new ArrayList<String>();
		while (rs.next()) {
			result.add(rs.getString("id"));
		}
		return result;
	}

}
