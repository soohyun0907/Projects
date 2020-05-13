package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfo;
public interface HouseInfoService {
	/**
	 * 모든 아파트 정보를 검색해 가져옵니다.
	 * @param 
	 * @return 모든 아파트 목록
	 */
	public List<HouseInfo> searchAllHouseInfo();
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseInfo search(int no);
	
	/**
	 * 동 이름으로 아파트를 검색합니다.
	 * @param 동 이름. ex) 평창동, 역삼동 등
	 * @return 검색하고자 하는 동 이름을 포함하는 모든 아파트 목록
	 */
	public List<HouseInfo> searchAllByDong(String dong);
	
}
