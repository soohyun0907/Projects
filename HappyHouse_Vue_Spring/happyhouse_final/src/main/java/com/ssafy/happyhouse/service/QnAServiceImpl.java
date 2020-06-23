package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnADAO;
import com.ssafy.happyhouse.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService{

	@Autowired
	private QnADAO dao;

	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}

	@Override
	public QnA detailQnA(int qna_no) {
		return dao.selectDetailQnA(qna_no);
	}

	@Override
	public boolean writeQnA(QnA qna) {
		return dao.insertQnA(qna) ==1;
	}

	@Override
	public boolean updateQnA(QnA qna) {
		return dao.updateQnA(qna) ==1;
	}

	@Override
	public boolean deleteQnA(int qna_no) {
		return dao.deleteQnA(qna_no) ==1;
	}

	@Override
	public List<QnA> selectQnALimitOffset(int limit, int offset) {
		// TODO Auto-generated method stub
		return dao.selectQnALimitOffset(limit, offset);
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return dao.selectQnATotalCount();
	}
	
	
	
}
