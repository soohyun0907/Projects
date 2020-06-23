package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class LoginController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	MemberService memberService;
	// For Vue Login Test
	// NO DB
	// Only Check 'ssafy'-'ssafy'
	@PostMapping(value="/api/login")
	@ResponseBody
	public ResponseEntity<Member> login(@RequestBody Member member, HttpSession session) {
		System.out.println("Login");
		if( memberService.login(member) == 1) {
			session.setAttribute("member", member);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
		}else {
			return new ResponseEntity<Member>(member, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/api/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		System.out.println("Logout");
		session.invalidate();
		return new ResponseEntity<String>("logout", HttpStatus.OK);
	}
	
//	// For Vue URL Mapping Test
//	@RequestMapping(value="/vuelogin")
//	public String vueLogin() {
//		return "redirect:/sfc/login/login.html";
//	}
//	
//	// For Vue URL Mapping Test
//	@RequestMapping(value="/vueboard")
//	public String vueBoard() {
//		return "redirect:/sfc/board/index.html";
//	}
}
