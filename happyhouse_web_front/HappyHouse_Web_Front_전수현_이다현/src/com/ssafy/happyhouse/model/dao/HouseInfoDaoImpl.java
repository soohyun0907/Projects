package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.util.DBUtil;

public class HouseInfoDaoImpl implements HouseInfoDao {

	@Override
	public List<HouseInfo> searchAllHouseInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM houseinfo WHERE 1 = 1 ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			List<HouseInfo> list = new LinkedList<HouseInfo>();
			while (rs.next()) {
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setNo(rs.getInt("no"));
				houseInfo.setDong(rs.getString("dong"));
				houseInfo.setAptName(rs.getString("aptname"));
				houseInfo.setCode(rs.getInt("code"));
				houseInfo.setBuildYear(rs.getInt("buildYear"));
				houseInfo.setJibun(rs.getString("jibun"));
				houseInfo.setLat(rs.getString("lat"));
				houseInfo.setLng(rs.getString("lng"));
				houseInfo.setImg(rs.getString("img"));
				list.add(houseInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	@Override
	public HouseInfo search(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " SELECT * FROM houseinfo WHERE no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setNo(rs.getInt("no"));
				houseInfo.setDong(rs.getString("dong"));
				houseInfo.setAptName(rs.getString("aptname"));
				houseInfo.setCode(rs.getInt("code"));
				houseInfo.setBuildYear(rs.getInt("buildYear"));
				houseInfo.setJibun(rs.getString("jibun"));
				houseInfo.setLat(rs.getString("lat"));
				houseInfo.setLng(rs.getString("lng"));
				houseInfo.setImg(rs.getString("img"));
				return houseInfo;
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
	
	@Override
	public List<HouseInfo> searchAllByDong(String dong) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM houseinfo WHERE 1 = 1 ");
			sql.append(" AND dong LIKE ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + dong + "%");
			
			rs = pstmt.executeQuery();
			List<HouseInfo> list = new LinkedList<HouseInfo>();
			while (rs.next()) {
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setNo(rs.getInt("no"));
				houseInfo.setDong(rs.getString("dong"));
				houseInfo.setAptName(rs.getString("aptname"));
				houseInfo.setCode(rs.getInt("code"));
				houseInfo.setBuildYear(rs.getInt("buildYear"));
				houseInfo.setJibun(rs.getString("jibun"));
				houseInfo.setLat(rs.getString("lat"));
				houseInfo.setLng(rs.getString("lng"));
				houseInfo.setImg(rs.getString("img"));
				list.add(houseInfo);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
	
	public static void main(String[] args) {
		HouseInfoDaoImpl dao = new HouseInfoDaoImpl();
		/** searchAllHouseInfo 테스트 */
//		try {
//			for (HouseInfo hi : dao.searchAllHouseInfo()) {
//				System.out.println(hi);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/** search 테스트 */
//		try {
//			System.out.println(dao.search(1));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		/** searchAllByDong 테스트 */
		try {
			for (HouseInfo hi : dao.searchAllByDong("평창동")) {
				System.out.println(hi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
