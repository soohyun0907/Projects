package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.service.FavoriteService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	FavoriteService favoriteService;
	
	@ApiOperation(value = "id와 맞는 관심지역을 반환한다.", response = List.class)
	@GetMapping(value="{id}")
	public ResponseEntity<List<Favorite>> listFavorite(@PathVariable String id) throws Exception {
		logger.debug("favoriteService.listFavorite - 호출");
		return new ResponseEntity<List<Favorite>>(favoriteService.listFavorite(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 관심지역을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertFavorite(@RequestBody Favorite favorite) throws Exception {
		logger.debug("favoriteService.insertFavorite - 호출");
		int result = favoriteService.insertFavorite(favorite);
		if(result == 0)
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심지역을 삭제한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping(value="{id}/{dong_name}")
	public ResponseEntity<Integer> delete(@PathVariable String id, @PathVariable String dong_name ) throws Exception {
		logger.debug("deleteFavorite- 호출");
		return new ResponseEntity<Integer>(favoriteService.deleteFavorite(id, dong_name), HttpStatus.OK);
	}
	
	
}
