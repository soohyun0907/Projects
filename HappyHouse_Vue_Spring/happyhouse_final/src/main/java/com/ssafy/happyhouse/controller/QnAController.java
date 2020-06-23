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

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.service.QnAService;

import io.swagger.annotations.ApiOperation;
//http://localhost:9999/happyhouse/index.html
//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/qna")
public class QnAController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnAService qnaService;

    @ApiOperation(value = "모든 질문게시판 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> retrieveBoard() throws Exception {
		logger.debug("retrieveQnA - 호출");
		return new ResponseEntity<List<QnA>>(qnaService.retrieveQnA(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "글번호에 해당하는 질문글의 정보를 반환한다.", response = QnA.class)    
	@GetMapping("{qna_no}")
	public ResponseEntity<QnA> detailBoard(@PathVariable int qna_no) {
		logger.debug("detailQnA - 호출");
		return new ResponseEntity<QnA>(qnaService.detailQnA(qna_no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 질문 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody QnA qna) {
		logger.debug("writeQnA - 호출");
		if (qnaService.writeQnA(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 질문 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{qna_no}")
	public ResponseEntity<String> updateBoard(@RequestBody QnA qna) {
		logger.debug("updateQnA - 호출");
		logger.debug("" + qna);
		
		if (qnaService.updateQnA(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "질문번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{qna_no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int qna_no) {
		logger.debug("deleteQnA - 호출");
		if (qnaService.deleteQnA(qna_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    //paging
    @ApiOperation(value = "limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink")
    public ResponseEntity<List<QnA>> selectBoardLimitOffset(int limit, int offset) throws Exception {
        logger.debug("selectBoardLimitOffset - 호출");
        return new ResponseEntity<List<QnA>>(qnaService.selectQnALimitOffset(limit, offset),HttpStatus.OK);
    }

    @ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)
    @GetMapping(value="/pagelink/count")
    public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
        logger.debug("selectBoardTotalCount - 호출");
        return new ResponseEntity<Integer>(qnaService.selectBoardTotalCount(), HttpStatus.OK);
    }
   
}