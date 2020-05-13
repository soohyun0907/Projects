package com.ssafy.happyhouse.model.dto;

public class StoreInfo {
	private int no;
	private String shopName;
	private String localName;
	private String code1;
	private String codeName1;
	private String code2;
	private String codeName2;
	private String code3;
	private String codeName3;
	private String code4;
	private String codeName4;
	private String cityCode;
	private String city;
	private String guCode;
	private String gu;
	private String dongCode;
	private String dong;
	private String jibuAddress;
	private String address;
	private String oldPostCode;
	private String postCode;
	private String lng;
	private String lat;
	
	public StoreInfo() {}

	public StoreInfo(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCodeName1() {
		return codeName1;
	}

	public void setCodeName1(String codeName1) {
		this.codeName1 = codeName1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCodeName2() {
		return codeName2;
	}

	public void setCodeName2(String codeName2) {
		this.codeName2 = codeName2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public String getCodeName3() {
		return codeName3;
	}

	public void setCodeName3(String codeName3) {
		this.codeName3 = codeName3;
	}

	public String getCode4() {
		return code4;
	}

	public void setCode4(String code4) {
		this.code4 = code4;
	}

	public String getCodeName4() {
		return codeName4;
	}

	public void setCodeName4(String codeName4) {
		this.codeName4 = codeName4;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGuCode() {
		return guCode;
	}

	public void setGuCode(String guCode) {
		this.guCode = guCode;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getJibuAddress() {
		return jibuAddress;
	}

	public void setJibuAddress(String jibuAddress) {
		this.jibuAddress = jibuAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOldPostCode() {
		return oldPostCode;
	}

	public void setOldPostCode(String oldPostCode) {
		this.oldPostCode = oldPostCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "StoreInfo [no=" + no + ", shopName=" + shopName + ", localName=" + localName + ", code1=" + code1
				+ ", codeName1=" + codeName1 + ", code2=" + code2 + ", codeName2=" + codeName2 + ", code3=" + code3
				+ ", codeName3=" + codeName3 + ", code4=" + code4 + ", codeName4=" + codeName4 + ", cityCode="
				+ cityCode + ", city=" + city + ", guCode=" + guCode + ", gu=" + gu + ", dongCode=" + dongCode
				+ ", dong=" + dong + ", jibuAddress=" + jibuAddress + ", address=" + address + ", oldPostCode="
				+ oldPostCode + ", postCode=" + postCode + ", lng=" + lng + ", lat=" + lat + "]";
	}
}
