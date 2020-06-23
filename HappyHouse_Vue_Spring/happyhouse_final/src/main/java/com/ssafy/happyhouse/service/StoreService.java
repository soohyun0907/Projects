package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Store;

public interface StoreService {
	public List<Store> retrieveStoreDong(String dong);
	public Store retrieveStoreDetail(int no);
}
