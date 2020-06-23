package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Member;

public interface MemberService {
	public int login(Member dto);
	
	public Member getInfo(String uid);

	public int insert(Member dto);

	public boolean update(Member dto);

	public Integer delete(String uid);

	public List<Member> list();
}
