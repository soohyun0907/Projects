package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.StoreDAO;
import com.ssafy.happyhouse.dto.Store;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreDAO storeDao;
	@Override
	public List<Store> retrieveStoreDong(String dong) {
		return storeDao.selectStoreDong(dong);
	}
	@Override
	public Store retrieveStoreDetail(int no) {
		return storeDao.detailStore(no);
	}

}
