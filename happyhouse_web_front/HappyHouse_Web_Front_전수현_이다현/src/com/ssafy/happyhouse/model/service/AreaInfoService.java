package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.AreaInfo;
public interface AreaInfoService {
	/**
	 * 모든 법정동 정보를 검색해 가져옵니다.
	 * @param 
	 * @return 모든 행정동 목록 (서울시 산하)
	 */
	public List<AreaInfo> searchAll();
	
	/**
	 * 법정동 코드로 지역 정보를 불러옵니다.
	 * @param no	법정동 코드
	 * @return		법정동 코드에 해당되는 지역 정보. ex) 서울특별시 강남구 역삼동
	 */
	public AreaInfo search(String code);
	
	/**
	 * 법정동 이름으로 법정동 코드를 가져옵니다.
	 * @param no	법정동 이름
	 * @return		법정동 이름에 해당되는 법정동 코드 ex) 1111010900 (누상동)
	 */
	public String searchCodeByDong(String dong);
	
	/**
	 * 서울시 산하 모든 법정구 이름을 가져옵니다.
	 * @param
	 * @return		법정구 이름 리스트
	 */
	public List<String> searchAllGuNames();
	
	/**
	 * 서울시 산하 모든 법정동 이름을 가져옵니다.
	 * @param
	 * @return		법정동 이름 리스트
	 */
	public List<String> searchAllDongNames();
	
	/**
	 * 직속 산하 행정구역을 검색합니다.
	 * @param 행정구역명
	 * @return 입력 받은 행정구역 명에 속하는 행정구역 명 리스트 
	 * ex) 서울특별시 입력 시 서울특별시 산하 모든 법정구 목록 리턴
	 * ex) 종로구 입력 시 종로구에 해당되는 모든 법정동 목록 리턴
	 */
//	public List<AreaInfo> searchAllByDong(String dong);
}
