package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.QnA;

public interface QnADAO {
	public List<QnA> selectQnA();
	public QnA selectDetailQnA(int qna_no);
	public int insertQnA(QnA qna);
	public int updateQnA(QnA qna);
	public int deleteQnA(int qna_no);

	// for pagination (page-link)
	public List<QnA> selectQnALimitOffset(@Param("limit") int limit, @Param("offset") int offset);
	public int selectQnATotalCount();
	
}
