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

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	MemberService userService;
	
	@ApiOperation(value = "모든 회원정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Member>> list() throws Exception {
		logger.debug("MemController.list - 호출");
		return new ResponseEntity<List<Member>>(userService.list(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원아이디에 해당하는 회원정보를 반환한다.", response = Member.class)
	@GetMapping(value="{userid}")
	public ResponseEntity<Member> getInfo(@PathVariable String userid) throws Exception {
		logger.debug("MemController.getInfo - 호출");
		return new ResponseEntity<Member>(userService.getInfo(userid),HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 회원정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Member dto) throws Exception {
		logger.debug("MemController.insert - 호출");
		int result = userService.insert(dto);
		if(result == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.OK);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보를 수정한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping(value="{userid}")
	public ResponseEntity<String> update(@RequestBody Member dto) throws Exception {
		logger.debug("MemController.update - 호출");
		if(userService.update(dto))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원정보를 삭제한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping(value="{userid}")
	public ResponseEntity<Integer> delete(String userid) throws Exception {
		logger.debug("MemController.delete - 호출");
		return new ResponseEntity<Integer>(userService.delete(userid), HttpStatus.OK);
	}
}
