package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Member;

public interface MemberDAO {
	public int login(Member dto);
	public Member select(String uid);
	public int insert(Member dto);
	public int update(Member dto);
	public Integer delete(String uid);
	public List<Member> list();
}
