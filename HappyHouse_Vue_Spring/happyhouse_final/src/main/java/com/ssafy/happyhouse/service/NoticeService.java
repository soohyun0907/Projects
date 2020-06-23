package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Notice;

public interface NoticeService {
	public List<Notice> retrieveNotice();
	public Notice detailNotice(int notice_no);
	public boolean writeNotice(Notice notice);
	public boolean updateNotice(Notice notice);
	public boolean deleteNotice(int notice_no);
	

	// for pagination (page-link)
	public List<Notice> selectNoticeLimitOffset(int limit, int offset);
	public int selectNoticeTotalCount();
}
