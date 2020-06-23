package com.ssafy.happyhouse.dto;

public class Favorite {
	private String id;
	private String dong_name;
	private String dong_code;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDong_name() {
		return dong_name;
	}
	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}
	public String getDong_code() {
		return dong_code;
	}
	public void setDong_code(String dong_code) {
		this.dong_code = dong_code;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", dong_name=" + dong_name + ", dong_code=" + dong_code + "]";
	}
	
}
