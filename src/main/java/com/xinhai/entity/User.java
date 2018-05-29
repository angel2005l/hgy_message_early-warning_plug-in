package com.xinhai.entity;

public class User {

	private int id;
	private String userName;
	private String userToken;
	private String userEmail;
	private String userPhone;
	private String userType;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
		return "User [id=" + id + ", userName=" + userName + ", userToken=" + userToken + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userType=" + userType + ", userLevel=" + userLevel + ", IsWork="
				+ IsWork + ", userStatus=" + userStatus + "]";
	}

}
