package com.xinhai.entity;

public class User {

	private int id;
	private String userCode;
	private String userName;
	private String userToken;
	private String userEmail;
	private String userPhone;
	private int userLevel;
	private String IsWork;
	private String userStatus;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getIsWork() {
		return IsWork;
	}

	public void setIsWork(String isWork) {
		IsWork = isWork;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userToken=" + userToken
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userLevel=" + userLevel + ", IsWork="
				+ IsWork + ", userStatus=" + userStatus + "]";
	}

}
