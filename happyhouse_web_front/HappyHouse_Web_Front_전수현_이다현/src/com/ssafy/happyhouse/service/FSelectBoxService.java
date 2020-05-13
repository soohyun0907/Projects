package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import com.ssafy.happyhouse.selectbox.dto.HouseInfoDTO;
import com.ssafy.happyhouse.selectbox.dto.SidoCodeDTO;

public interface FSelectBoxService {

	ArrayList<SidoCodeDTO> selectSido() throws Exception;

	ArrayList<SidoCodeDTO> selectGugun(String sido) throws Exception;

	ArrayList<HouseInfoDTO> selectDong(String gugun) throws Exception;

	ArrayList<HouseInfoDTO> selectApt(String dong) throws Exception;

}
