package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.util.PageNavigation;
public interface HouseService {
	// 각종 예외처리(SQL)는 서비스단에서 처리
	// 로그인 로직도 서비스단에서 담당
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<HouseDeal> searchAll(HousePageBean bean,int currentPage, int sizePerPage, String key, String word);
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage, String key, String word) throws Exception;
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no);
	
	// .. 더많은 기능을 여기서 구현 (필요한 것들 찾아서 추가)
}
