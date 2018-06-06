package com.xinhai.service;

import java.util.List;
import java.util.Map;

import com.xinhai.entity.User;
import com.xinhai.util.Page;
import com.xinhai.util.Result;

public interface IUserService {

	public Page<User> selUserpageWithCount(String userName,String page) throws Exception;

	public Result<User> selUserById(String id) throws Exception;

	public Result<Object> insUser(User data) throws Exception;

	public Result<Object> uptUser(User data) throws Exception;

	public Result<Object> delUser(String id) throws Exception;

	public Result<Object> uptUserIsWork(String isWork, String id) throws Exception;

	public Result<Object> insBatch(List<User> data) throws Exception;

	public List<Map<String, String>> selUserKV() throws Exception;

}
