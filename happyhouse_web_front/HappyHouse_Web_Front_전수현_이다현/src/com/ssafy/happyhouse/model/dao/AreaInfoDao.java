package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AreaInfo;

public interface AreaInfoDao {
	/**
	 * 모든 법정동 정보를 검색해 가져옵니다.
	 * @param 
	 * @return 모든 법정동 목록 (서울시 산하)
	 */
	public List<AreaInfo> searchAll() throws SQLException;
	
	/**
	 * 법정동 코드로 지역 정보를 불러옵니다.
	 * @param no	법정동 코드
	 * @return		법정동 코드에 해당되는 지역 정보. ex) 서울특별시 강남구 역삼동
	 */
	public AreaInfo search(String code) throws SQLException;
	
	/**
	 * 법정동 이름으로 법정동 코드를 가져옵니다.
	 * @param no	법정동 이름
	 * @return		법정동 이름에 해당되는 법정동 코드 ex) 1111010900 (누상동)
	 */
	public AreaInfo searchCodeByDong(String dong) throws SQLException;
	
	/**
	 * 서울시 산하 모든 법정구 이름을 가져옵니다.
	 * @param
	 * @return		법정구 이름 리스트
	 */
	public List<String> searchAllGuNames() throws SQLException;
	
	/**
	 * 서울시 산하 모든 법정동 이름을 가져옵니다.
	 * @param
	 * @return		법정동 이름 리스트
	 */
	public List<String> searchAllDongNames() throws SQLException;
}
