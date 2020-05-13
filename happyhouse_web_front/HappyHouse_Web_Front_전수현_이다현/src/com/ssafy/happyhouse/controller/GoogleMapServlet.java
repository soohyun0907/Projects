package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.service.HouseInfoService;
import com.ssafy.happyhouse.model.service.HouseInfoServiceImpl;

@WebServlet("/GoogleMapServlet")
public class GoogleMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		
		HouseInfoService houseInfoService = new HouseInfoServiceImpl();
		List<HouseInfo> houseInfoList = houseInfoService.searchAllHouseInfo();

		Gson gson = new Gson();
		String jsonStr = gson.toJson(houseInfoList);

		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(jsonStr);
	}
}
