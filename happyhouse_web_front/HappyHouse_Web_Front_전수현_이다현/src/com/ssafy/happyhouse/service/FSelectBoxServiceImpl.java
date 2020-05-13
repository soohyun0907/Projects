package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import com.ssafy.happyhouse.selectbox.dao.FSelectBoxDAO;
import com.ssafy.happyhouse.selectbox.dao.FSelectBoxDAOImpl;
import com.ssafy.happyhouse.selectbox.dto.HouseInfoDTO;
import com.ssafy.happyhouse.selectbox.dto.SidoCodeDTO;

public class FSelectBoxServiceImpl implements FSelectBoxService {

	private FSelectBoxDAO dao;

	public FSelectBoxServiceImpl() {
		dao = new FSelectBoxDAOImpl();
	}

	@Override
	public ArrayList<SidoCodeDTO> selectSido() throws Exception {
		ArrayList<SidoCodeDTO> list = dao.selectSido();
		return list;
	}

	@Override
	public ArrayList<SidoCodeDTO> selectGugun(String sido) throws Exception {
		ArrayList<SidoCodeDTO> list = dao.selectGugun(sido);
		return list;
	}

	@Override
	public ArrayList<HouseInfoDTO> selectDong(String gugun) throws Exception {
		ArrayList<HouseInfoDTO> list = dao.selectDong(gugun);
		return list;
	}

	@Override
	public ArrayList<HouseInfoDTO> selectApt(String dong) throws Exception {
		ArrayList<HouseInfoDTO> list = dao.selectApt(dong);
		return list;
	}

}
