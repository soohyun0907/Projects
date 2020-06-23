package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDAO;
import com.ssafy.happyhouse.dto.Member;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public int login(Member dto) {
		return dao.login(dto);
	}

	@Override
	public Member getInfo(String uid) {
		return dao.select(uid);
	}

	@Override
	public int insert(Member dto) {
		return dao.insert(dto);
	}

	@Override
	public boolean update(Member dto) {
		return dao.update(dto)==1;
	}

	@Override
	public Integer delete(String uid) {
		return dao.delete(uid);
	}

	@Override
	public List<Member> list() {
		return dao.list();
	}

}
