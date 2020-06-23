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
import com.ssafy.happyhouse.service.HousedealService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/housedeal")
public class HousedealController {
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	@Autowired
	private HousedealService housedealService;
	
	@ApiOperation(value = "모든 하우스딜 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Housedeal>> retrieveHousedealAll() throws Exception {
		logger.debug("retrieveHousedealAll - 호출");
		return new ResponseEntity<List<Housedeal>>(housedealService.retrieveHousedealAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "동으로 검색한 하우스딜 정보를 반환한다.", response = List.class)
	@GetMapping("/dong/{dong}")
	public ResponseEntity<List<Housedeal>> retrieveHousedealDong(@PathVariable String dong) throws Exception {
		logger.debug("retrieveHousedealDong - 호출");
		return new ResponseEntity<List<Housedeal>>(housedealService.retrieveHousedealDong(dong), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트이름으로 검색한 하우스딜 정보를 반환한다.", response = List.class)
	@GetMapping("/aptname/{AptName}")
	public ResponseEntity<List<Housedeal>> retrieveHousedealAptName(@PathVariable String AptName) throws Exception {
		logger.debug("retrieveHousedealAptName - 호출");
		return new ResponseEntity<List<Housedeal>>(housedealService.retrieveHousedealAptName(AptName), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트번호으로 검색한 하우스딜 상세정보를 반환한다.", response = Housedeal.class)
	@GetMapping("/no/{no}")
	public ResponseEntity<Housedeal> retrieveHousedealDetail(@PathVariable int no) throws Exception {
		logger.debug("retrieveHousedealDetail - 호출");  
		return new ResponseEntity<Housedeal>(housedealService.retrieveHousedealDetail(no), HttpStatus.OK);
	}
	
	 //paging
    @ApiOperation(value = "limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink")
    public ResponseEntity<List<Housedeal>> selectHousedealLimitOffset(int limit, int offset) throws Exception {
        logger.debug("selectBoardLimitOffset - 호출");
        return new ResponseEntity<List<Housedeal>>(housedealService.selectHousedealLimitOffset(limit, offset), HttpStatus.OK);
    }
    
    @ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/count")
    public ResponseEntity<Integer> selectHousedealTotalCount() throws Exception {
        logger.debug("selectBoardTotalCount - 호출");
        return new ResponseEntity<Integer>(housedealService.selectHousedealTotalCount(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "동 검색 limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/dong")
    public ResponseEntity<List<Housedeal>> selectHousedealLimitOffsetDong(String dong, int limit, int offset) throws Exception {
        logger.debug("selectHouseDeaDongPaging - 호출");
        return new ResponseEntity<List<Housedeal>>(housedealService.selectHouseDeaDongPaging(dong, limit, offset), HttpStatus.OK);
    }
    
    @ApiOperation(value = "게시글의 동검색 건수를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/count/dong/{dong}")
    public ResponseEntity<Integer> selectHousedealTotalCountDong(@PathVariable String dong) throws Exception {
        logger.debug("selectBoardTotalCount - 호출");
        return new ResponseEntity<Integer>(housedealService.selectHousedealTotalCountDong(dong), HttpStatus.OK);
    }
    
    @ApiOperation(value = "아파트 이름 검색 limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/aptname")
    public ResponseEntity<List<Housedeal>> selectHousedealLimitOffsetAptname(String aptname, int limit, int offset) throws Exception {
        logger.debug("selectHouseDeaAptNamePaging - 호출");
        return new ResponseEntity<List<Housedeal>>(housedealService.selectHouseDeaAptNamePaging(aptname, limit, offset), HttpStatus.OK);
    }
    
    @ApiOperation(value = "게시글의 아파트이름 검색 건수를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/count/aptname/{AptName}")
    public ResponseEntity<Integer> selectHousedealTotalCountAptname(@PathVariable String AptName) throws Exception {
        logger.debug("selectBoardTotalCount - 호출");
        return new ResponseEntity<Integer>(housedealService.selectHousedealTotalCountAptname(AptName), HttpStatus.OK);
    }
    
    
}
