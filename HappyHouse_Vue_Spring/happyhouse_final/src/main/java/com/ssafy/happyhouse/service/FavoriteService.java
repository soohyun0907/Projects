package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Favorite;

public interface FavoriteService {
	public int insertFavorite(Favorite favorite);
	public List<Favorite> listFavorite(String id);
	public Integer deleteFavorite(String id,String dong_name);
}
