package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dao.HouseDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.util.PageNavigation;

public class HouseServiceImpl implements HouseService{
	private HouseDao dao;

	public HouseServiceImpl() {
		 dao =new HouseDaoImpl();
	}
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	@Override
	public List<HouseDeal> searchAll(HousePageBean bean, int currentPage, int sizePerPage, String key, String word){
		try {
			boolean[] types = bean.getSearchType();
			int cnt = 0;
			for (boolean t : types) {
				if (t) ++cnt;
			}
			if (cnt == 0) {
				throw new HappyHouseException("주택 타입은 반드시 하나 이상 선택되어야 합니다.");
			}
			key = key == null ? "" : key;
			word = word == null ? "" : word;
			return dao.searchAll(bean,currentPage, sizePerPage, key, word);
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) {
		try {
			HouseDeal deal = dao.search(no);
			if (deal == null) throw new HappyHouseException(String.format("거래 번호 %d번에 해당하는 주택거래 정보가 존재하지 않습니다.", no));
			return deal;
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage, String key, String word) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		int naviSize = 10; // 페이지 갯수
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = dao.getTotalCount(key, word); // 총 게시글 수
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1; // 전체 페이지 수
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize; // true라면 이전을 누를 수 없다. false면 이전을 누를 수 있다.
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage; // true : 다음 버튼 X, false : 다음 O
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}
}




