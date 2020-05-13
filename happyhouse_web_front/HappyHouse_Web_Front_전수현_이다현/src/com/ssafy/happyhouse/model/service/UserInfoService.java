package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.UserInfo;

public interface UserInfoService {
	// 모든 유저 검색
	public List<UserInfo> searchAll();

	// 유저 검색
	public UserInfo search(String id);

	// 유저 추가
	public void insertUser(UserInfo user);

	// 유저 삭제
	public void deleteUser(String id);

	// 유저 수정
	public void updateUser(String id, UserInfo user);

	// 로그인
	public boolean loginUser(String id, String pw) throws SQLException;

	// 회원가입
	public void signUp(UserInfo user);
}
