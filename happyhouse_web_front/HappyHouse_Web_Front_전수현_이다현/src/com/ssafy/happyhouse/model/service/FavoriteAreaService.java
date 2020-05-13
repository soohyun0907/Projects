package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.FavoriteArea;

public interface FavoriteAreaService {

	// 해당 유저의 모든 관심지역 출력
	public List<FavoriteArea> searchall(String id);

	// 관심지역 추가
	public void insertFavoriteArea(String id, String fa);

}
