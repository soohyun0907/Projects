package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Store;

public interface StoreDAO {
	public List<Store> selectStoreDong(String dong);
	public Store detailStore(int no);
}
