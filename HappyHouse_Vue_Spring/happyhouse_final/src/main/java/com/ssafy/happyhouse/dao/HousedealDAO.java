package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.Housedeal;

public interface HousedealDAO {
	public List<Housedeal> selectHouseDealAll();
	public List<Housedeal> selectHouseDeaDong(String dong);
	public List<Housedeal> selectHouseDeaAptName(String AptName);
	public Housedeal selectDetailHousedeal(int no);
	// for pagination (page-link)
	public List<Housedeal> selectHousedealLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
	public int selectHousedealTotalCount();
	public List<Housedeal> selectHouseDeaDongPaging(@Param("dong") String dong, @Param("limit") int limit, @Param("offset") int offset);
	public int selectHousedealTotalCountDong(String dong);
	public List<Housedeal> selectHouseDeaAptNamePaging(@Param("Aptname") String Aptname, @Param("limit") int limit, @Param("offset") int offset);
	public int selectHousedealTotalCountAptname(String Aptname);
}
