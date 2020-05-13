package com.ssafy.happyhouse.selectbox.dao;

import java.util.ArrayList;

import com.ssafy.happyhouse.selectbox.dto.HouseInfoDTO;
import com.ssafy.happyhouse.selectbox.dto.SidoCodeDTO;

public interface FSelectBoxDAO {

	ArrayList<SidoCodeDTO> selectSido() throws Exception;

	ArrayList<SidoCodeDTO> selectGugun(String sido) throws Exception;

	ArrayList<HouseInfoDTO> selectDong(String gugun) throws Exception;

	ArrayList<HouseInfoDTO> selectApt(String dong) throws Exception;

}
