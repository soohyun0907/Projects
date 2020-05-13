package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.StoreInfo;

public interface StoreInfoDao {
	
	/**
	 * 모든 상권 정보를 검색해 가져옵니다.
	 * @param 
	 * @return 모든 상권 목록
	 */
	public List<StoreInfo> searchAll() throws SQLException;
	
	/**
	 * 상권 식별 번호에 해당하는 아파트 정보를 검색해서 반환. 
	 * @param no	검색할 상권 식별 번호
	 * @return		상권 식별 번호에 해당하는 상권 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public StoreInfo search(int no) throws SQLException;
	
	/**
	 * 해당 동에 속한 모든 상권 정보를 검색해서 반환.
	 * @param no	동 이름
	 * @return		해당 동에 속한 상권 목록
	 */
	public List<StoreInfo> searchAllByDong(String dong) throws SQLException;
	
	/**
	 * 해당 동에 속한 모든 상권 정보를 검색해서 반환.
	 * @param no	동 코드
	 * @return		해당 동에 속한 상권 목록
	 */
	public List<StoreInfo> searchAllByDongCode(String dongCode) throws SQLException;
}
