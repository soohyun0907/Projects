package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.Notice;

public interface NoticeDAO {
	public List<Notice> selectNotice();
	public Notice selectDetailNotice(int notice_no);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int notice_no);
	

	// for pagination (page-link)
	public List<Notice> selectNoticeLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
	public int selectNoticeTotalCount();
}
