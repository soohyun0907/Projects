package com.ssafy.happyhouse.model.dto;

public class UserInfo {
	private String uId; // id
	private String uPw; // password
	private String uName;// user name
	private String uAddress;// user address
	private String uPhone;// user phone number

	public UserInfo() {
	}

	public UserInfo(String uId, String uPw, String uName, String uAddress, String uPhone) {
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uAddress = uAddress;
		this.uPhone = uPhone;
	}

	public UserInfo(String uId) {
		this.uId = uId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uAddress=" + uAddress + ", uPhone="
				+ uPhone + "]";
	}
}
