package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.ssafy.happyhouse.model.dao.UserDao;
import com.ssafy.happyhouse.model.dao.UserDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.UserInfo;
import com.ssafy.happyhouse.model.service.HouseInfoService;
import com.ssafy.happyhouse.model.service.HouseInfoServiceImpl;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;
import com.ssafy.happyhouse.model.service.UserInfoService;
import com.ssafy.happyhouse.model.service.UserInfoServiceImpl;
import com.ssafy.util.PageNavigation;

// 컨트롤러 기능별로 나눠서 사용하기!(권장)
@WebServlet("/membermain.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao dao = new UserDaoImpl();
	private HouseService houseService = new HouseServiceImpl();
	private UserInfoService userInfoService = new UserInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");
		System.out.println("action: " + action);
		if (action == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		if (action.equals("MAP")) {
//			getHouseInfo(request, response);
		} else if (action.equals("VIEW")) {
			view(request, response);
		} else if (action.equals("FINDPWD")) {
			findPwd(request, response);
		} else if (action.equals("SEARCH")) {
			search(request, response);
		} else if (action.equals("SEARCHALL")) {
			searchAll(request, response);
		} else if (action.equals("REGBOOK")) {
			request.getRequestDispatcher("book/Book.jsp").forward(request, response);
		} else if (action.equals("MEMBERREG")) {
			response.sendRedirect("jsp/join.jsp");
		} else if (action.equals("LOGIN")) {
			login(request, response);
		} else if (action.equals("LOGOUT")) {
			HttpSession hs = request.getSession();
			hs.invalidate();
			PrintWriter out = response.getWriter();
			out.print(1);
			out.close();
		} else if (action.equals("MYPAGE")) {
			myPage(request, response);
		} else if (action.equals("DETAIL")) {
			detail(request, response);
		} else if (action.equals("JOIN")) {
			String uName = request.getParameter("uName");
			String uid = request.getParameter("uid");
			String upw = request.getParameter("upw");
			String uaddress = request.getParameter("uaddress");
			String uphone = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
			userInfoService.signUp(new UserInfo(uid, upw, uName, uaddress, uphone));
			request.setAttribute("msg", "회원 가입 완료!!!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("MEMBERUPDATE")) {
			updateMember(request, response);
		} else if (action.equals("DELETEMEMBER")) {
			deleteMember(request, response);
		} else if (action.equals("mvMain")) {
			response.sendRedirect("index.jsp");
		}
	}

	private void findPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uName = request.getParameter("uname");
		String uId = request.getParameter("uid");
		String uPhone = request.getParameter("uphone");
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		try {
			UserInfo userInfo = userInfoService.search(uId);
			if (userInfo.getuName().equals(uName) && userInfo.getuPhone().equals(uPhone)) {
				userInfoService.deleteUser(uId);
				obj.put("message_code", "1");
				// 6자리 숫자의 랜덤 비밀번호 생성
				String newPwd = (int)(Math.random() * (1000000 - 100000) + 100000) + "";
				obj.put("message_code", "1");
				obj.put("newPwd", newPwd);
				userInfo.setuPw(newPwd);
				userInfoService.insertUser(userInfo);
				System.out.println(userInfo.getuPw());
			} else {
				obj.put("message_code", "0");
			}
		} finally {
			arr.add(obj);
			out.print(arr.toJSONString());
			out.close();
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/HouseDeal/dealListMain.jsp";
		boolean[] searchType = { true, true, true, true };
		HousePageBean bean = new HousePageBean();
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		String searchName = request.getParameter("searchName");
		System.out.println(search + " " + searchName);
		int currentPage = Integer.parseInt(request.getParameter("pg")); // 현재 페이지 번호
		String spp = request.getParameter("spp"); // 한 페이지당 글 갯수
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);// sizePerPage
		String key = search;// ""
		String word = searchName;// ""
		if (search.equals("dong")) {
			bean.setDong(searchName);
		} else if (search.equals("apt")) {
			bean.setAptname(searchName);
		}
		bean.setSearchType(searchType);
		try {
			List<HouseDeal> list = houseService.searchAll(bean, currentPage, sizePerPage, key, word);
			PageNavigation pageNavigation = houseService.makePageNavigation(currentPage, sizePerPage, key, word);
			request.setAttribute("key", key);
			request.setAttribute("word", word);
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
			request.setAttribute("deals", list);
			request.setAttribute("navigation", pageNavigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(nextpage).forward(request, response);
	}

	private void searchAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextpage = "/jsp/userList.jsp";
		List<UserInfo> list = userInfoService.searchAll();
		request.setAttribute("users", list);
		request.getRequestDispatcher(nextpage).forward(request, response);
	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String id = (String) hs.getAttribute("uid");
		hs.invalidate();
		System.out.println(id);
		userInfoService.deleteUser(id);
		request.setAttribute("msg", "회원 정보가 수정되었습니다.");
		String uName = request.getParameter("uName");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String uaddress = request.getParameter("uaddress");
		String uphone = request.getParameter("phoneNum");
		userInfoService.insertUser(new UserInfo(uid, upw, uName, uaddress, uphone));
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String uid = (String) hs.getAttribute("uid");
		hs.invalidate();
		System.out.println(uid);
		userInfoService.deleteUser(uid);
		response.sendRedirect("index.jsp");
	}

	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String uid = (String) hs.getAttribute("uid");
		UserInfo user = userInfoService.search(uid);
		request.setAttribute("userInfo", user);
		request.getRequestDispatcher("jsp/myPage.jsp").forward(request, response);

	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/HouseDeal/dealDetail.jsp";
		int no = Integer.parseInt(request.getParameter("dealNo"));
		HouseDeal houseDeal = houseService.search(no);
		request.setAttribute("deal", houseDeal);
		request.getRequestDispatcher(nextpage).forward(request, response);
	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/HouseDeal/dealListMain.jsp";
		boolean[] searchType = { true, true, true, true };
		HousePageBean bean = new HousePageBean();
		bean.setSearchType(searchType);
		int currentPage = Integer.parseInt(request.getParameter("pg")); // 현재 페이지 번호
		String spp = request.getParameter("spp"); // 한 페이지당 글 갯수
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);// sizePerPage
		String key = request.getParameter("key");// ""
		String word = request.getParameter("word");// ""
		try {
			List<HouseDeal> list = houseService.searchAll(bean, currentPage, sizePerPage, key, word);
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
			PageNavigation pageNavigation = houseService.makePageNavigation(currentPage, sizePerPage, key, word);
			request.setAttribute("deals", list);
			request.setAttribute("navigation", pageNavigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(nextpage).forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		// DB 연동해서 체크
		try {
			if (userInfoService.loginUser(uid, upw)) {
				UserInfo user = dao.search(uid);
				if (user.getuId() == null || user.getuId().trim().equals("")) {
					obj.put("message_code", "0");
				} else {
					obj.put("message_code", "1");
					obj.put("userno", user.getuId());
					obj.put("userid", user.getuId());
					obj.put("username", user.getuName());
					obj.put("telephone", user.getuPhone());
					obj.put("address", user.getuAddress());
					HttpSession hs = request.getSession();
					hs.setAttribute("user", user);
					hs.setAttribute("uid", uid);
					hs.setAttribute("upw", upw);
					hs.setAttribute("uName", user.getuName());
					hs.setAttribute("uaddress", user.getuAddress());
					hs.setAttribute("uphone", user.getuPhone());
					hs.setAttribute("user_session", user);
					request.setAttribute("msg", "정상적으로 로그인 되었습니다.");
				}
			} else {
				System.out.println("아이디 또는 패스워드가 틀립니다.");
				String msg = "아이디 또는 패스워드가 틀립니다.";
				request.setAttribute("msg", msg);
			}
		} catch (SQLException e) {
			obj.put("message_code", "-1");
			e.printStackTrace();
			request.setAttribute("msg", "로그인 실패~~ 잠시 후 사용해 주세요");
		} finally {
			arr.add(obj);
			out.print(arr.toJSONString());
			out.close();
		}
	}

}
