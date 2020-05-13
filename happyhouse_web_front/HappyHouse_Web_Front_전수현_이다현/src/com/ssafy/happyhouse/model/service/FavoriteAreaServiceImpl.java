package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.FavoriteAreaDao;
import com.ssafy.happyhouse.model.dao.FavoriteAreaDaoImpl;
import com.ssafy.happyhouse.model.dto.FavoriteArea;

public class FavoriteAreaServiceImpl implements FavoriteAreaService {
	private FavoriteAreaDao dao;

	public FavoriteAreaServiceImpl() {
		dao = new FavoriteAreaDaoImpl();
	}

	@Override
	public List<FavoriteArea> searchall(String id) {
		try {
			return dao.search(id);
		} catch (SQLException e) {
			throw new HappyHouseException("사용자의 관심지역 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public void insertFavoriteArea(String id, String fa) {
		try {
			dao.register(id, fa);
		} catch (SQLIntegrityConstraintViolationException e) { // 중복 키 예외 처리
			throw new HappyHouseException("이미 등록된 관심지역입니다.");
		} catch (SQLException e) {
			throw new HappyHouseException("관심지역 추가 도중에 에러가 발생하였습니다.");
		}
	}

	public static void main(String[] args) {
		// TEST
		FavoriteAreaServiceImpl service = new FavoriteAreaServiceImpl();
		
		// insertFavoriteArea() : 관심 지역 등록
		System.out.println("== 관심 지역 등록 ==");
		service.insertFavoriteArea("junsoodark", "1111012400");
		
		// searchall() : 사용자가 등록한 모든 관심 지역 목록 리턴
		System.out.println("\n== 사용자가 등록한 모든 관심 지역 목록 리턴 ==");
		for (FavoriteArea fa : service.searchall("junsoodark")) {
			System.out.println(fa);
		}
		
		// 관심 지역 중복 등록 시 예외 처리
		System.out.println("\n== 관심 지역 중복 등록 시 예외 처리 ==");
		service.insertFavoriteArea("junsoodark", "1111012400");
	}
}
