package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.NoticeDAO;
import com.ssafy.happyhouse.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO dao;

	@Override
	public List<Notice> retrieveNotice() {
		return dao.selectNotice();
	}

	@Override
	public Notice detailNotice(int notice_no) {
		return dao.selectDetailNotice(notice_no);
	}

	@Override
	public boolean writeNotice(Notice notice) {
		return dao.insertNotice(notice) ==1;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		return dao.updateNotice(notice) ==1;
	}

	@Override
	public boolean deleteNotice(int notice_no) {
		return dao.deleteNotice(notice_no) ==1;
	}

	@Override
	public List<Notice> selectNoticeLimitOffset(int limit, int offset) {
		// TODO Auto-generated method stub
		return dao.selectNoticeLimitOffset(limit, offset);
	}

	@Override
	public int selectNoticeTotalCount() {
		// TODO Auto-generated method stub
		return dao.selectNoticeTotalCount();
	}
	
	
	
}
