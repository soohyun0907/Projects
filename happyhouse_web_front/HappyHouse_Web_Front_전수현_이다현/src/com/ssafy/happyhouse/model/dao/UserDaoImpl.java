package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.UserInfo;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<UserInfo> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM userinfo ");
			System.out.println(sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<UserInfo> list = new LinkedList<UserInfo>();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setuId(rs.getString("uid"));
				user.setuPw(rs.getString("uPW"));
				user.setuName(rs.getString("uName"));
				user.setuAddress(rs.getString("uAddress"));
				user.setuPhone(rs.getString("uPhone"));
				list.add(user);
			}
			System.out.println(list.size());
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public UserInfo search(String id) throws SQLException {
		UserInfo u = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM userinfo WHERE uid = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u = new UserInfo();
				u.setuId(rs.getString("uid"));
				u.setuPw(rs.getString("uPW"));
				u.setuName(rs.getString("uName"));
				u.setuAddress(rs.getString("uAddress"));
				u.setuPhone(rs.getString("uPhone"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		if (u == null) {
			System.out.println("not exist user");
		}
		return u;
	}

	@Override
	public void insertUser(UserInfo user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO userinfo (uid, uPW, uName, uAddress, uPhone) values( ?, ?, ?, ?, ?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user.getuId());
			pstmt.setString(2, user.getuPw());
			pstmt.setString(3, user.getuName());
			pstmt.setString(4, user.getuAddress());
			pstmt.setString(5, user.getuPhone());
			System.out.println(sql.toString());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void deleteUser(String uid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM userinfo WHERE uid = ?");
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public void updateUser(String id, UserInfo user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.setLength(0);
			sql.append(" UPDATE userinfo SET uPw = ?, uName = ?, uAddress = ?, uPhone = ? WHERE uid = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user.getuPw());
			pstmt.setString(2, user.getuName());
			pstmt.setString(3, user.getuAddress());
			pstmt.setString(4, user.getuPhone());
			pstmt.setString(5, user.getuId());
			System.out.println(sql.toString());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public boolean login(String user, String pass) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String q = "Select upw from userinfo where uid=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs.next()) {
				String pw = rs.getString(1);
				if (pw.equals(pass)) {
					return true;
				}
			}

		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return false;

	}

}
