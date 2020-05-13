package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.StoreInfoDao;
import com.ssafy.happyhouse.model.dao.StoreInfoDaoImpl;
import com.ssafy.happyhouse.model.dto.StoreInfo;

public class StoreInfoServiceImpl implements StoreInfoService{
	private StoreInfoDao dao;

	public StoreInfoServiceImpl() {
		 dao = new StoreInfoDaoImpl();
	}

	public List<StoreInfo> searchAll(){
		try {
			List<StoreInfo> res = dao.searchAll();
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("상권 정보 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public StoreInfo search(int no) {
		try {
			StoreInfo storeInfo = dao.search(no);
			if (storeInfo == null) throw new HappyHouseException(String.format("해당 no(%d)에 해당되는 상권 정보가 존재하지 않습니다.", no));
			return storeInfo;
		} catch (SQLException e) {
			throw new HappyHouseException("상권 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public List<StoreInfo> searchAllByDong(String dong) {
		try {
			List<StoreInfo> res = dao.searchAllByDong(dong);
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("상권 정보 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public List<StoreInfo> searchAllByDongCode(String dongCode) {
		try {
			List<StoreInfo> res = dao.searchAllByDongCode(dongCode);
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("상권 정보 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		// TEST
		StoreInfoService service = new StoreInfoServiceImpl();
		int cnt = 5;
		// searchAll() : 전체 상권 목록 검색
		System.out.println("== searchAll() : 전체 상권 목록 검색 ==");
		for (StoreInfo si : service.searchAll()) {
			System.out.println(si);
			if (--cnt == 0) break;
		}
		
		// search() : 상권 식별번호(no)로 검색
		System.out.println("\n== search() : 상권 식별번호로 검색 ==");
		System.out.println(service.search(8692952));
		
		
		// searchAllByDong() : 법정동 이름으로 상권 검색
		System.out.println("\n== searchAllByDong() : 법정동 이름으로 상권 검색 ==");
		cnt = 5;
		for (StoreInfo si : service.searchAllByDong("평창동")) {
			System.out.println(si);
			if (--cnt == 0) break;
		}
		
		// searchAllByDong() : 법정동 코드로 상권 검색
		System.out.println("\n== searchAllByDongCode() : 법정동 코드로 상권 검색 ==");
		cnt = 5;
		for (StoreInfo si : service.searchAllByDongCode("1111010900")) {
			System.out.println(si);
			if (--cnt == 0) break;
		}
	}
}




