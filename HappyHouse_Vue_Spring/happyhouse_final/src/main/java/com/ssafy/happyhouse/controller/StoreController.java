package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.Store;
import com.ssafy.happyhouse.service.StoreService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/store")
public class StoreController {
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	@Autowired
	private StoreService storeService;
		
	@ApiOperation(value = "동으로 검색한 상권 정보를 반환한다.", response = List.class)
	@GetMapping("/{dong}")
	public ResponseEntity<List<Store>> retrieveStoreDong(@PathVariable String dong) throws Exception {
		logger.debug("retrieveStoreDong - 호출");
		return new ResponseEntity<List<Store>>(storeService.retrieveStoreDong(dong), HttpStatus.OK);
	}

	@ApiOperation(value = "상점번호로 검색한 상권정보 상세정보를 반환한다.", response = Housedeal.class)
	@GetMapping("/no/{no}")
	public ResponseEntity<Store> retrieveStoreDetail(@PathVariable int no) throws Exception {
		logger.debug("retrieveStoreDetail - 호출");  
		return new ResponseEntity<Store>(storeService.retrieveStoreDetail(no), HttpStatus.OK);
	}
}
