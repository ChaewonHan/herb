package com.kh.herb.member.model.vo;

import java.util.Date;

public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userAddress;
	private String userBirth;
	private char userDel;
	private Date userDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public char getUserDel() {
		return userDel;
	}
	public void setUserDel(char userDel) {
		this.userDel = userDel;
	}
	public Date getUserDate() {
		return userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
}
