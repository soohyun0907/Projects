package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.FavoriteArea;
import com.ssafy.util.DBUtil;

public class FavoriteAreaDaoImpl implements FavoriteAreaDao {
	
	@Override
	public List<FavoriteArea> search(String uId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM favoritearea WHERE 1 = 1 ");
			sql.append(" AND uid = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			List<FavoriteArea> list = new LinkedList<FavoriteArea>();
			while (rs.next()) {
				FavoriteArea favoriteArea = new FavoriteArea();
				favoriteArea.setUid(rs.getString("uid"));
				favoriteArea.setAcode(rs.getString("acode"));
				list.add(favoriteArea);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public int register(String uId, String dongCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO favoritearea VALUES (?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, uId);
			pstmt.setString(2, dongCode);
			
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return result; // 정상적으로 INSERT 시 1을 반환
	}
	
	public static void main(String[] args) {
		// TEST
		FavoriteAreaDao dao = new FavoriteAreaDaoImpl();
	}
}
