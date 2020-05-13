package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.StoreInfo;
import com.ssafy.util.DBUtil;

public class StoreInfoDaoImpl implements StoreInfoDao {
	
	@Override
	public List<StoreInfo> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM storeinfo WHERE 1 = 1 ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<StoreInfo> list = new LinkedList<StoreInfo>();
			while (rs.next()) {
				StoreInfo storeInfo = new StoreInfo();
				storeInfo.setNo(rs.getInt("no"));
				storeInfo.setShopName(rs.getString("shopname"));
				storeInfo.setLocalName(rs.getString("localname"));
				storeInfo.setCode1(rs.getString("code1"));
				storeInfo.setCodeName1(rs.getString("codename1"));
				storeInfo.setCode2(rs.getString("code2"));
				storeInfo.setCodeName2(rs.getString("codename2"));
				storeInfo.setCode3(rs.getString("code3"));
				storeInfo.setCodeName3(rs.getString("codename3"));
				storeInfo.setCode4(rs.getString("code4"));
				storeInfo.setCodeName4(rs.getString("codename4"));
				storeInfo.setCityCode(rs.getString("citycode"));
				storeInfo.setCity(rs.getString("city"));
				storeInfo.setGuCode(rs.getString("gucode"));
				storeInfo.setGu(rs.getString("gu"));
				storeInfo.setDongCode(rs.getString("dongcode"));
				storeInfo.setDong(rs.getString("dong"));
				storeInfo.setJibuAddress(rs.getString("jibuaddress"));
				storeInfo.setAddress(rs.getString("address"));
				storeInfo.setOldPostCode(rs.getString("oldpostcode"));
				storeInfo.setPostCode(rs.getString("postcode"));
				storeInfo.setLng(rs.getString("lng"));
				storeInfo.setLat(rs.getString("lat"));
				list.add(storeInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public StoreInfo search(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " SELECT * FROM storeinfo WHERE no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				StoreInfo storeInfo = new StoreInfo();
				storeInfo.setNo(rs.getInt("no"));
				storeInfo.setShopName(rs.getString("shopname"));
				storeInfo.setLocalName(rs.getString("localname"));
				storeInfo.setCode1(rs.getString("code1"));
				storeInfo.setCodeName1(rs.getString("codename1"));
				storeInfo.setCode2(rs.getString("code2"));
				storeInfo.setCodeName2(rs.getString("codename2"));
				storeInfo.setCode3(rs.getString("code3"));
				storeInfo.setCodeName3(rs.getString("codename3"));
				storeInfo.setCode4(rs.getString("code4"));
				storeInfo.setCodeName4(rs.getString("codename4"));
				storeInfo.setCityCode(rs.getString("citycode"));
				storeInfo.setCity(rs.getString("city"));
				storeInfo.setGuCode(rs.getString("gucode"));
				storeInfo.setGu(rs.getString("gu"));
				storeInfo.setDongCode(rs.getString("dongcode"));
				storeInfo.setDong(rs.getString("dong"));
				storeInfo.setJibuAddress(rs.getString("jibuaddress"));
				storeInfo.setAddress(rs.getString("address"));
				storeInfo.setOldPostCode(rs.getString("oldpostcode"));
				storeInfo.setPostCode(rs.getString("postcode"));
				storeInfo.setLng(rs.getString("lng"));
				storeInfo.setLat(rs.getString("lat"));
				return storeInfo;
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public List<StoreInfo> searchAllByDong(String dong) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM storeinfo WHERE 1 = 1 ");
			sql.append(" AND dong = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			List<StoreInfo> list = new LinkedList<StoreInfo>();
			while (rs.next()) {
				StoreInfo storeInfo = new StoreInfo();
				storeInfo.setNo(rs.getInt("no"));
				storeInfo.setShopName(rs.getString("shopname"));
				storeInfo.setLocalName(rs.getString("localname"));
				storeInfo.setCode1(rs.getString("code1"));
				storeInfo.setCodeName1(rs.getString("codename1"));
				storeInfo.setCode2(rs.getString("code2"));
				storeInfo.setCodeName2(rs.getString("codename2"));
				storeInfo.setCode3(rs.getString("code3"));
				storeInfo.setCodeName3(rs.getString("codename3"));
				storeInfo.setCode4(rs.getString("code4"));
				storeInfo.setCodeName4(rs.getString("codename4"));
				storeInfo.setCityCode(rs.getString("citycode"));
				storeInfo.setCity(rs.getString("city"));
				storeInfo.setGuCode(rs.getString("gucode"));
				storeInfo.setGu(rs.getString("gu"));
				storeInfo.setDongCode(rs.getString("dongcode"));
				storeInfo.setDong(rs.getString("dong"));
				storeInfo.setJibuAddress(rs.getString("jibuaddress"));
				storeInfo.setAddress(rs.getString("address"));
				storeInfo.setOldPostCode(rs.getString("oldpostcode"));
				storeInfo.setPostCode(rs.getString("postcode"));
				storeInfo.setLng(rs.getString("lng"));
				storeInfo.setLat(rs.getString("lat"));
				list.add(storeInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public List<StoreInfo> searchAllByDongCode(String dongCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM storeinfo WHERE 1 = 1 ");
			sql.append(" AND dongcode = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dongCode);
			rs = pstmt.executeQuery();
			List<StoreInfo> list = new LinkedList<StoreInfo>();
			while (rs.next()) {
				StoreInfo storeInfo = new StoreInfo();
				storeInfo.setNo(rs.getInt("no"));
				storeInfo.setShopName(rs.getString("shopname"));
				storeInfo.setLocalName(rs.getString("localname"));
				storeInfo.setCode1(rs.getString("code1"));
				storeInfo.setCodeName1(rs.getString("codename1"));
				storeInfo.setCode2(rs.getString("code2"));
				storeInfo.setCodeName2(rs.getString("codename2"));
				storeInfo.setCode3(rs.getString("code3"));
				storeInfo.setCodeName3(rs.getString("codename3"));
				storeInfo.setCode4(rs.getString("code4"));
				storeInfo.setCodeName4(rs.getString("codename4"));
				storeInfo.setCityCode(rs.getString("citycode"));
				storeInfo.setCity(rs.getString("city"));
				storeInfo.setGuCode(rs.getString("gucode"));
				storeInfo.setGu(rs.getString("gu"));
				storeInfo.setDongCode(rs.getString("dongcode"));
				storeInfo.setDong(rs.getString("dong"));
				storeInfo.setJibuAddress(rs.getString("jibuaddress"));
				storeInfo.setAddress(rs.getString("address"));
				storeInfo.setOldPostCode(rs.getString("oldpostcode"));
				storeInfo.setPostCode(rs.getString("postcode"));
				storeInfo.setLng(rs.getString("lng"));
				storeInfo.setLat(rs.getString("lat"));
				list.add(storeInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
}
