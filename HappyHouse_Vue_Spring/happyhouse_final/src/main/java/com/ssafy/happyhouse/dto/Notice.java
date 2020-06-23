package com.ssafy.happyhouse.dto;

import java.util.Date;

public class Notice {
	private int notice_no; 
	private String notice_title; 
	private String notice_content; 
	private String notice_userid;
	private Date notice_datetime;
	
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_userid() {
		return notice_userid;
	}
	public void setNotice_userid(String notice_userid) {
		this.notice_userid = notice_userid;
	}
	public Date getNotice_datetime() {
		return notice_datetime;
	}
	public void setNotice_datetime(Date notice_datetime) {
		this.notice_datetime = notice_datetime;
	}

	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_userid=" + notice_userid + ", notice_datetime=" + notice_datetime + "]";
	} 
	
		
}

