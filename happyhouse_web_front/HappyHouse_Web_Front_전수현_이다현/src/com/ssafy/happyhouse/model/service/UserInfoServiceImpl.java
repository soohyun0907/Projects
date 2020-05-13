package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.UserDao;
import com.ssafy.happyhouse.model.dao.UserDaoImpl;
import com.ssafy.happyhouse.model.dto.UserInfo;

public class UserInfoServiceImpl implements UserInfoService {
	private UserDao dao;

	public UserInfoServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public List<UserInfo> searchAll() {
		try {
			return dao.searchAll();
		} catch (SQLException e) {
			throw new HappyHouseException("전체 사용자 정보 조회 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public UserInfo search(String id) {
		try {
			return dao.search(id);
		} catch (SQLException e) {
			throw new HappyHouseException("사용자 검색 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public void insertUser(UserInfo user) {
		try {
			dao.insertUser(user);
		} catch (SQLException e) {
			throw new HappyHouseException("사용자 추가 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public void deleteUser(String id) {
		try {
			dao.deleteUser(id);
		} catch (SQLException e) {
			throw new HappyHouseException("사용자 삭제 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public void updateUser(String id, UserInfo user) {
		try {
			dao.updateUser(id, user);
		} catch (SQLException e) {
			throw new HappyHouseException("사용자 정보 업데이트 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public boolean loginUser(String id, String pw) {
		try {
			UserInfo user = dao.search(id);
			if (user == null) {
				throw new HappyHouseException("유저 정보가 없습니다.");
			}
			if (user.getuPw().equals(pw)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new HappyHouseException("로그인 도중에 에러가 발생하였습니다.");
		}
	}

	@Override
	public void signUp(UserInfo user) {
		List<UserInfo> list = searchAll();
		for (UserInfo u : list) {
			if (u.getuId().equals(user.getuId())) {
				System.out.println("해당 유저 id는 이미 존재합니다.");
				throw new HappyHouseException("해당 유저 id는 이미 존재합니다.");
			}
		}
		insertUser(user);
	}
}
