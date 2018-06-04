package com.xinhai.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xinhai.entity.Mould;
import com.xinhai.entity.MouldLog;
import com.xinhai.entity.MouldRule;
import com.xinhai.entity.MouldWithRule;

public interface IMouldDao {

	// 模具部分
	public List<MouldWithRule> selectMouldWithRule() throws SQLException;

	public List<Mould> selectMould(int page) throws SQLException;

	public int selectMouldCount() throws SQLException;

	public Mould selectMouldById(int id) throws SQLException;

	public int updateMouldRuleCode(int id, String mouldRuleCode) throws SQLException;

	public int updateMouldRuleCodeWithIds(String[] ids, String mouldRuleCode) throws SQLException;

	public List<Map<String, String>> selMoildKV() throws SQLException;

	// 模具规则部分
	public List<MouldRule> selectMouldRule(int page) throws SQLException;

	public int selectMouldRuleCount() throws SQLException;

	public int insertMouldRule(MouldRule data) throws SQLException;

	public MouldRule selectMouldRuleById(int id) throws SQLException;

	public int updateMouldRule(MouldRule data) throws SQLException;

	public int deleteMouldRule(int id) throws SQLException;

	public List<Map<String, String>> selectMouldRuleKV() throws SQLException;

	// 模具日志部分
	public MouldLog selectMouldLogByMouldId(int mouldId) throws SQLException;

	public int insertMouldLog(MouldLog data) throws SQLException;

	public List<MouldLog> selectMouldLog(int page) throws SQLException;

	public int selectMouldLogCount() throws SQLException;

	public MouldLog selectMoulodLogById(int id) throws SQLException;

	public int updateMouldLog(MouldLog data) throws SQLException;
}
