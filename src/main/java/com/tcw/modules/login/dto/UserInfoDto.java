package com.tcw.modules.login.dto;

public class UserInfoDto {

	private String loginId;
	private String loginPw;
	
	private int userId;
	private String userName;
	private String bizCode;
	
	public UserInfoDto() {}
	
	public UserInfoDto(String loginId, String loginPw) {
		this.loginId = loginId;
		this.loginPw = loginPw;
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	
}
