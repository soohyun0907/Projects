package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.AreaInfoDao;
import com.ssafy.happyhouse.model.dao.AreaInfoDaoImpl;
import com.ssafy.happyhouse.model.dto.AreaInfo;

public class AreaInfoServiceImpl implements AreaInfoService{
	private AreaInfoDao dao;

	public AreaInfoServiceImpl() {
		 dao = new AreaInfoDaoImpl();
	}

	public List<AreaInfo> searchAll(){
		try {
			List<AreaInfo> res = dao.searchAll();
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("법정동 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	public AreaInfo search(String code) {
		try {
			AreaInfo areaInfo = dao.search(code);
			if (areaInfo == null) throw new HappyHouseException(String.format("법정동 코드 %s에 해당하는 지역 정보가 존재하지 않습니다.", code));
			return areaInfo;
		} catch (SQLException e) {
			throw new HappyHouseException("법정동 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public String searchCodeByDong(String dong) {
		try {
			AreaInfo areaInfo = dao.searchCodeByDong(dong.trim());
			if (areaInfo == null) throw new HappyHouseException(String.format("법정동 %s에 해당하는 법정동 코드가 존재하지 않습니다.", dong));
			return areaInfo.getaCode();
		} catch (SQLException e) {
			throw new HappyHouseException("법정동 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public List<String> searchAllGuNames() {
		try {
			List<String> res = dao.searchAllGuNames();
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("법정동 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	@Override
	public List<String> searchAllDongNames() {
		try {
			List<String> res = dao.searchAllDongNames();
			System.out.println("(총 " + res.size() + "건이 검색되었습니다.)");
			return res;
		} catch (SQLException e) {
			throw new HappyHouseException("법정동 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}
	
	public static void main(String[] args) {
		// TEST
		AreaInfoService service = new AreaInfoServiceImpl();
		int cnt = 5;
		// SearchAll() : 전체 지역 목록 검색
		System.out.println("== searchAll() : 전체 지역 정보 검색 ==");
		for (AreaInfo ai : service.searchAll()) {
			System.out.println(ai);
			if (--cnt == 0) break;
		}
		
		// search() : 법정동 코드로 검색
		System.out.println("\n== search() : 법정동 코드로 검색 ==");
		System.out.println(service.search("1111010900"));
		
		// searchCodeByDong() : 법정동 이름으로 법정동 코드 검색
		System.out.println("\n== searchCodeByDong() : 법정동 이름으로 법정동 코드 검색 ==");
		System.out.println(service.searchCodeByDong("평창동"));
		
		// searchAllGuNames() : 모든 법정구 이름 검색
		System.out.println("\n== searchAllGuNames() : 모든 법정구 이름 검색 ==");
		cnt = 5;
		for (String guName : service.searchAllGuNames()) {
			System.out.println(guName);
			if (--cnt == 0) break;
		}
		
		// searchAllDongNames() : 모든 법정동 이름 검색
		System.out.println("\n== searchAllDongNames() : 모든 법정동 이름 검색 ==");
		cnt = 5;
		for (String dongName : service.searchAllDongNames()) {
			System.out.println(dongName);
			if (--cnt == 0) break;
		}
	}
}




