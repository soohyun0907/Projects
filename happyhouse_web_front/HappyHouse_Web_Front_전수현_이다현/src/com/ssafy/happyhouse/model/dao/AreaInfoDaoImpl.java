package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AreaInfo;
import com.ssafy.util.DBUtil;

public class AreaInfoDaoImpl implements AreaInfoDao {
	
	@Override
	public List<AreaInfo> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM areainfo WHERE 1 = 1 ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<AreaInfo> list = new LinkedList<AreaInfo>();
			while (rs.next()) {
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setaCode(rs.getString("acode"));
				areaInfo.setSiName(rs.getString("alocalname1"));
				areaInfo.setGuName(rs.getString("alocalname2"));
				areaInfo.setDongName(rs.getString("alocalname3"));
				areaInfo.setLiName(rs.getString("alocalname4"));
				list.add(areaInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public AreaInfo search(String code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " SELECT * FROM areainfo WHERE acode = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setaCode(rs.getString("acode"));
				areaInfo.setSiName(rs.getString("alocalname1"));
				areaInfo.setGuName(rs.getString("alocalname2"));
				areaInfo.setDongName(rs.getString("alocalname3"));
				areaInfo.setLiName(rs.getString("alocalname4"));
				return areaInfo;
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public AreaInfo searchCodeByDong(String dong) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " SELECT * FROM areainfo WHERE alocalname3 = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setaCode(rs.getString("acode"));
				areaInfo.setSiName(rs.getString("alocalname1"));
				areaInfo.setGuName(rs.getString("alocalname2"));
				areaInfo.setDongName(rs.getString("alocalname3"));
				areaInfo.setLiName(rs.getString("alocalname4"));
				return areaInfo;
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public List<String> searchAllGuNames() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT DISTINCT alocalname2 FROM areainfo WHERE 1 = 1 ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<String> list = new LinkedList<String>();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public List<String> searchAllDongNames() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT DISTINCT alocalname3 FROM areainfo WHERE 1 = 1 ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<String> list = new LinkedList<String>();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
}
