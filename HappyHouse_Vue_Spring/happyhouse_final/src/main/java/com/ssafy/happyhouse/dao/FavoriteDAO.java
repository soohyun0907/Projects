package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Favorite;

public interface FavoriteDAO {
	public int insertFavorite(Favorite favorite);
	public List<Favorite> selectFavorite(String id);
	public Integer deleteFavorite(String id,String dong_name);
}
