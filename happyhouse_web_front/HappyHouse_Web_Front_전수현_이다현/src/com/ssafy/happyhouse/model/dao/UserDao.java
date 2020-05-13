package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.UserInfo;

public interface UserDao {

	// 모든 유저 검색
	public List<UserInfo> searchAll() throws SQLException;

	// 유저 검색
	public UserInfo search(String id) throws SQLException;

	// 유저 추가
	public void insertUser(UserInfo user) throws SQLException;

	// 유저 삭제
	public void deleteUser(String id) throws SQLException;

	// 유저 수정
	public void updateUser(String id, UserInfo user) throws SQLException;
	
	// 유저 로그인
	public boolean login(String user, String pass) throws SQLException;
}
