package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	public List<QnA> retrieveQnA();
	public QnA detailQnA(int qna_no);
	public boolean writeQnA(QnA qna);
	public boolean updateQnA(QnA qna);
	public boolean deleteQnA(int qna_no);

	// for pagination (page-link)
	public List<QnA> selectQnALimitOffset(int limit, int offset);
	public int selectBoardTotalCount();
	
}
