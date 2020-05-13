package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	private Map<String, HouseInfo> houseInfo;
	private Map<String, List<HouseDeal>> deals;
	private int size;
	private List<HouseDeal> search;
	private String[] searchType = { HouseDeal.APT_DEAL, HouseDeal.APT_RENT, HouseDeal.HOUSE_DEAL,
			HouseDeal.HOUSE_RENT };

	public HouseDaoImpl() {
	}

	/**
	 * 아파트 정보와 아파트 거래 정보를 xml 파일에서 읽어온다. (현재는 필요 없는 기능)
	 */
	public void loadData() {
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를 검색해서 반환.
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<HouseDeal> searchAll(HousePageBean bean,int currentPage, int sizePerPage, String key, String word) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM housedeal WHERE 1 = 1 ");
			sql.append(" AND type IN (");
			boolean[] type = bean.getSearchType();
			int cnt = 0;
			for (int i = 0, size = type.length; i < size; i++) {
				if (type[i]) {
					if (cnt != 0) {
						sql.append(", ");
					}
					sql.append(i + 1);
					cnt++;
				}
			}
			sql.append(")");

			String dong = bean.getDong();
			String aptName = bean.getAptname();

			if (dong != null && !dong.trim().equals("")) {
				sql.append(" AND dong like ? ");
			} else if (aptName != null && !aptName.trim().equals("")) {
				sql.append(" AND aptname like ? ");
			}
			sql.append(" order by dealamount limit ?, ?");
			pstmt = con.prepareStatement(sql.toString());
			int idx = 0;
			if (dong != null && !dong.trim().equals("")) {
				pstmt.setString(++idx, "%" + dong + "%");
			} else if (aptName != null && !aptName.trim().equals("")) {
				pstmt.setString(++idx, "%" + aptName + "%");
			} 
			pstmt.setInt(++idx, (currentPage -1)*sizePerPage);
			pstmt.setInt(++idx, sizePerPage);
			System.out.println(sql.toString());
			rs = pstmt.executeQuery();
			List<HouseDeal> list = new LinkedList<HouseDeal>();
			while (rs.next()) {
				if (dong != null && !dong.trim().equals("")) {
					if (!KMP(rs.getString("dong"), dong)) {
						continue;
					}
				} else if (aptName != null && !aptName.trim().equals("")) {
					if (!KMP(rs.getString("aptName"), aptName)) {
						continue;
					}
				}
				HouseDeal deal = new HouseDeal();
				deal.setNo(rs.getInt("no"));
				deal.setDong(rs.getString("dong"));
				deal.setAptName(rs.getString("aptName"));
				deal.setCode(rs.getInt("code"));
				deal.setDealAmount(rs.getString("dealAmount"));
				deal.setBuildYear(rs.getInt("buildYear"));
				deal.setDealYear(rs.getInt("dealYear"));
				deal.setDealMonth(rs.getInt("dealMonth"));
				deal.setDealDay(rs.getInt("dealDay"));
				deal.setArea(rs.getDouble("area"));
				deal.setFloor(rs.getInt("floor"));
				deal.setJibun(rs.getString("jibun"));
				deal.setType(rs.getString("type"));
				deal.setRentMoney(rs.getString("rentMoney"));
				list.add(deal);
			}
			System.out.println(list.size());
			list.sort(new Comparator<HouseDeal>() {
				public int compare(HouseDeal o1, HouseDeal o2) {
					if (o1.getDealAmount().length() > o2.getDealAmount().length()) {
						return 1;
					} else if (o1.getDealAmount().length() == o2.getDealAmount().length()) {
						for (int i = 0; i < o1.getDealAmount().length(); i++) {
							if (o1.getDealAmount().charAt(i) == o2.getDealAmount().charAt(i)) {
								continue;
							}
							if (o1.getDealAmount().charAt(i) > o2.getDealAmount().charAt(i)) {
								return 1;
							} else if (o1.getDealAmount().charAt(i) < o2.getDealAmount().charAt(i)) {
								return -1;
							}
						}
					} else {
						return -1;
					}
					return 0;
				}
			});
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	/**
	 * 주택 거래 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환한다.<br/>
	 * (DB로부터)
	 * 
	 * @param no 주택 거래 식별 번호
	 * @return 주택 거래 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " SELECT * FROM housedeal WHERE no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				HouseDeal deal = new HouseDeal();
				deal.setNo(rs.getInt("no"));
				deal.setDong(rs.getString("dong"));
				deal.setAptName(rs.getString("aptName"));
				deal.setCode(rs.getInt("code"));
				deal.setDealAmount(rs.getString("dealAmount"));
				deal.setBuildYear(rs.getInt("buildYear"));
				deal.setDealYear(rs.getInt("dealYear"));
				deal.setDealMonth(rs.getInt("dealMonth"));
				deal.setDealDay(rs.getInt("dealDay"));
				deal.setArea(rs.getDouble("area"));
				deal.setFloor(rs.getInt("floor"));
				deal.setJibun(rs.getString("jibun"));
				deal.setType(rs.getString("type"));
				deal.setRentMoney(rs.getString("rentMoney"));
				return deal;
			}
			return null;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}

	public static void main(String[] args) {
		HouseDao dao = new HouseDaoImpl();

		try {
			HouseDeal deal = dao.search(24);
			System.out.println(deal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int getTotalCount(String key, String word) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(no) \n");
			sql.append("from housedeal \n");
			if(!word.isEmpty()) {
				if("dong".equals(key)) {
					sql.append("where dong like ? \n");
				} else if("apt".equals(key)) {
					sql.append("where aptName like ? \n");
				} else {
					sql.append("where " + key + " = ? \n");
				}
			}
//			sql.append("order by no desc \n");
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			if(!word.isEmpty()) {
				if("dong".equals(key))
					pstmt.setString(1, "%" + word + "%");
				else if("apt".equals(key))
					pstmt.setString(1, "%" + word + "%");
				else
					pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return cnt;
	}
	
	public static int[] getPi(String pattern) {
		// 접두사와 접미사가 일치하는 최대길이를 담을 배열 선언
		int[] pi = new int[pattern.length()];

		// idx
		int j = 0;
		// i,j가 가리키는 값이 일치하면 둘다 증가
		// 불일치하면 i만 증가시켜야 하므로 for문
		for (int i = 1; i < pattern.length(); i++) {

			// pattern 내에서 i와 j가 가리키는 값이 다를때
			// while문안에 넣는 이유는 중간단계를 건너뛰고 최대한으로 점프하려고
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				// j의 값을 한칸 뺀곳의 값으로 j를 바꿈
				j = pi[j - 1];
			}
			// pattern 내에서 i와 j가 가리키는 값이 같으면
			if (pattern.charAt(i) == pattern.charAt(j)) {
				// i번째의 최대길이는 ++j한 값
				pi[i] = ++j;
			}
		}

		return pi;
	}

	public static boolean KMP(String parent, String pattern) {
		int[] table = getPi(pattern);
//		System.out.println("점프테이블");
//		System.out.println(Arrays.toString(table));

		int j = 0;
		for (int i = 0; i < parent.length(); i++) {
			while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			// 부모와 패턴이 일치한다면
			if (parent.charAt(i) == pattern.charAt(j)) {
				// j의 값이 패턴의 길이-1이라면 한번 다찾은거니까
				// 찾아다고 처리
				if (j == pattern.length() - 1) {
					// 패턴을 또 찾기 위해서
					j = table[j];
					return true;
				} else {
					// 다찾은건아니라면 계속 진행해야하므로 j값 증가
					j++;
				}
			}
		}
		return false;
	}
}
