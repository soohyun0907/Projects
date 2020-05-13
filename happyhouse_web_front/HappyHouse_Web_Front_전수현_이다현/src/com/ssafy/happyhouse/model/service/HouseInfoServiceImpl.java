package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.HouseInfoDao;
import com.ssafy.happyhouse.model.dao.HouseInfoDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseInfo;

public class HouseInfoServiceImpl implements HouseInfoService{
	private HouseInfoDao dao;

	public HouseInfoServiceImpl() {
		 dao = new HouseInfoDaoImpl();
	}

	public List<HouseInfo> searchAllHouseInfo(){
		try {
			List<HouseInfo> res = dao.searchAllHouseInfo();
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	public HouseInfo search(int no) {
		try {
			HouseInfo houseInfo = dao.search(no);
			if (houseInfo == null) throw new HappyHouseException(String.format("아파트 번호 %d번에 해당하는 아파트 정보가 존재하지 않습니다.", no));
			return houseInfo;
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public List<HouseInfo> searchAllByDong(String dong) {
		try {
			List<HouseInfo> res = dao.searchAllByDong(dong);
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		// TEST
		HouseInfoService service = new HouseInfoServiceImpl();
		int cnt = 5;
		// searchAllHouseInfo() : 전체 아파트 목록 검색
		System.out.println("== searchAllHouseInfo() : 전체 아파트 목록 검색 ==");
		for (HouseInfo hi : service.searchAllHouseInfo()) {
			System.out.println(hi);
			if (--cnt == 0) break;
		}
		
		// search() : 아파트 식별번호로 검색
		System.out.println("\n== search() : 아파트 식별번호로 검색 ==");
		System.out.println(service.search(1));
		
		
		// searchAllByDong() : 동이름으로 아파트 필터링 검색
		System.out.println("\n== searchAllByDong() : 동이름으로 아파트 필터링 검색 ==");
		cnt = 5;
		for (HouseInfo hi : service.searchAllByDong("평창동")) {
			System.out.println(hi);
			if (--cnt == 0) break;
		}
	}

}




