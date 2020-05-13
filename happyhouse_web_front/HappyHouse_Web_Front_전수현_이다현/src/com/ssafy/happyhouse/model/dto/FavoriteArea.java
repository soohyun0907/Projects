package com.ssafy.happyhouse.model.dto;

public class FavoriteArea {
	private String uid;
	private String acode;

	public FavoriteArea() {
	};

	public FavoriteArea(String uid, String acode) {
		this.uid = uid;
		this.acode = acode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAcode() {
		return acode;
	}

	public void setAcode(String acode) {
		this.acode = acode;
	}

	@Override
	public String toString() {
		return "favoritearea [uid=" + uid + ", acode=" + acode + "]";
	}

}
