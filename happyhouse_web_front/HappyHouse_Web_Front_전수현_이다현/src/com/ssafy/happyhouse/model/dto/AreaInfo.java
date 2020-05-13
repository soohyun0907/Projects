package com.ssafy.happyhouse.model.dto;

public class AreaInfo {
	private String aCode;
	private String siName; // 시.도 행정명
	private String guName; // 시군구 행정명
	private String dongName; // 읍면동 행정명
	private String liName; // 읍면리 행정명

	public AreaInfo() {
	}

	public AreaInfo(String aCode, String siName, String guName, String dongName, String liName) {
		this.aCode = aCode;
		this.siName = siName;
		this.guName = guName;
		this.dongName = dongName;
		this.liName = liName;
	}

	public AreaInfo(String aCode) {
		super();
		this.aCode = aCode;
	}

	public String getaCode() {
		return aCode;
	}

	public void setaCode(String aCode) {
		this.aCode = aCode;
	}

	public String getSiName() {
		return siName;
	}

	public void setSiName(String siName) {
		this.siName = siName;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getLiName() {
		return liName;
	}

	public void setLiName(String liName) {
		this.liName = liName;
	}

	@Override
	public String toString() {
		return "AreaInfo [aCode=" + aCode + ", siName=" + siName + ", guName=" + guName + ", dongName=" + dongName
				+ ", liName=" + liName + "]";
	}
}
