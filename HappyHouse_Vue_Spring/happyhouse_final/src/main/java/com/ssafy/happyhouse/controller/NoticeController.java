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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeService;

    @ApiOperation(value = "모든 공지게시판 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Notice>> retrieveBoard() throws Exception {
		logger.debug("retrieveNotice - 호출");
		return new ResponseEntity<List<Notice>>(noticeService.retrieveNotice(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "글번호에 해당하는 공지글의 정보를 반환한다.", response = Notice.class)    
	@GetMapping("{notice_no}")
	public ResponseEntity<Notice> detailBoard(@PathVariable int notice_no) {
		logger.debug("detailNotice - 호출");
		return new ResponseEntity<Notice>(noticeService.detailNotice(notice_no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 공지 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody Notice notice) {
		logger.debug("writeNotice - 호출");
		if (noticeService.writeNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 공지 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{notice_no}")
	public ResponseEntity<String> updateBoard(@RequestBody Notice notice) {
		logger.debug("updateNotice - 호출");
		logger.debug("" + notice);
		
		if (noticeService.updateNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "공지번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{notice_no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int notice_no) {
		logger.debug("deleteNotice - 호출");
		if (noticeService.deleteNotice(notice_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    //paging
    @ApiOperation(value = "limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink")
    public ResponseEntity<List<Notice>> selectNoticeLimitOffset(int limit, int offset) throws Exception {
        logger.debug("selectBoardLimitOffset - 호출");
        return new ResponseEntity<List<Notice>>(noticeService.selectNoticeLimitOffset(limit, offset), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/count")
    public ResponseEntity<Integer> selectNoticeTotalCount() throws Exception {
        logger.debug("selectBoardTotalCount - 호출");
        return new ResponseEntity<Integer>(noticeService.selectNoticeTotalCount(), HttpStatus.OK);
    }
   
}