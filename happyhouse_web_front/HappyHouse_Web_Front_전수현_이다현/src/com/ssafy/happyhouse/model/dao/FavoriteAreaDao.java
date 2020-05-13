package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.FavoriteArea;

public interface FavoriteAreaDao {

	/**
	 * 해당 회원이 등록한 모든 관심지역 목록을 가져옵니다.
	 * @param user id
	 * @return 관심지역 list
	 */
	public List<FavoriteArea> search(String uId) throws SQLException;
	
	/**
	 * 해당 법정동 코드를 이용해 회원의 관심지역에 등록합니다.
	 * @param 회원 ID, 등록하고자 하는 관심지역의 법정동 코드
	 * @return 
	 */
	public int register(String uId, String dongCode) throws SQLException;
}
