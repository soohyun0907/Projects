package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.FavoriteDAO;
import com.ssafy.happyhouse.dto.Favorite;

@Service
public class FavoriteServiceImpl  implements FavoriteService{

	
	@Autowired
	private FavoriteDAO favoriteDao;
	
	@Override
	public int insertFavorite(Favorite favorite) {
		return favoriteDao.insertFavorite(favorite);
	}

	@Override
	public List<Favorite> listFavorite(String id) {
		return favoriteDao.selectFavorite(id);
	}

	@Override
	public Integer deleteFavorite(String id,String dong_name) {
		return favoriteDao.deleteFavorite(id,dong_name);
	}

}
