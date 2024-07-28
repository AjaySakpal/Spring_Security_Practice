package com.ajay.practice.securityconfiglib.beans;

public class UserDetails {
	private String userName;
	private String mobileNo;
	private String emailId;
	public String getUserName() {
		return userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
