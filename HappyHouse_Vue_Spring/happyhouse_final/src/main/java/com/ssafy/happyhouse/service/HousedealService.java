package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Housedeal;

public interface HousedealService {
	public List<Housedeal> retrieveHousedealAll();
	public List<Housedeal> retrieveHousedealDong(String dong);
	public List<Housedeal> retrieveHousedealAptName(String AptName);
	public Housedeal retrieveHousedealDetail(int no);
	// for pagination (page-link)
	public List<Housedeal> selectHousedealLimitOffset(int limit, int offset);
	public int selectHousedealTotalCount();
	public List<Housedeal> selectHouseDeaDongPaging(String dong, int limit, int offset);
	public int selectHousedealTotalCountDong(String dong);
	public List<Housedeal> selectHouseDeaAptNamePaging(String Aptname, int limit, int offset);
	public int selectHousedealTotalCountAptname(String aptname);

}
