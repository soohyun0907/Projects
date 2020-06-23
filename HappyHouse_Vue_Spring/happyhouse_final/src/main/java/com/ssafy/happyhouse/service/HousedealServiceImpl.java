package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HousedealDAO;
import com.ssafy.happyhouse.dto.Housedeal;

@Service
public class HousedealServiceImpl implements HousedealService {
	
	@Autowired
	private HousedealDAO dao;
	
	@Override
	public List<Housedeal> retrieveHousedealAll() {
		return dao.selectHouseDealAll();
	}

	@Override
	public List<Housedeal> retrieveHousedealDong(String dong) {
		return dao.selectHouseDeaDong(dong);
	}

	@Override
	public List<Housedeal> retrieveHousedealAptName(String AptName) {
		return dao.selectHouseDeaAptName(AptName);
	}

	@Override
	public Housedeal retrieveHousedealDetail(int no) {
		return dao.selectDetailHousedeal(no);
	}
	// for pagination (page-link)
	@Override
	public List<Housedeal> selectHousedealLimitOffset(int limit, int offset){
	    return dao.selectHousedealLimitOffset(limit, offset);
	}
	
	@Override
	public int selectHousedealTotalCount() {
	    return dao.selectHousedealTotalCount();
	}
	
	@Override
	public List<Housedeal> selectHouseDeaDongPaging(String dong, int limit, int offset){
	    return dao.selectHouseDeaDongPaging(dong, limit, offset);
	}
	
	@Override
	public int selectHousedealTotalCountDong(String dong) {
		return dao.selectHousedealTotalCountDong(dong);
	}
	
	@Override
	public List<Housedeal> selectHouseDeaAptNamePaging(String Aptname, int limit, int offset){
	    return dao.selectHouseDeaAptNamePaging(Aptname, limit, offset);
	}
	
	@Override
	public int selectHousedealTotalCountAptname(String aptname) {
		return dao.selectHousedealTotalCountAptname(aptname);
	}
}
