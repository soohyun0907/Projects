package fselectbox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ssafy.happyhouse.selectbox.dto.HouseInfoDTO;
import com.ssafy.happyhouse.selectbox.dto.SidoCodeDTO;
import com.ssafy.happyhouse.service.FSelectBoxService;
import com.ssafy.happyhouse.service.FSelectBoxServiceImpl;


@WebServlet("/FSelectBoxController")
public class FSelectBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FSelectBoxService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new FSelectBoxServiceImpl();
	}

	public FSelectBoxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		if(command.equals("sido")) {
			PrintWriter out = response.getWriter();
			ArrayList<SidoCodeDTO> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectSido();
				for(SidoCodeDTO dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("sido_code", dto.getSido_code());
					obj.put("sido_name", dto.getSido_name());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		}//sido
		else if(command.equals("gugun")) {
			String sido = request.getParameter("sido");
			PrintWriter out = response.getWriter();
			ArrayList<SidoCodeDTO> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectGugun(sido);
				for(SidoCodeDTO dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("gugun_code", dto.getGugun_code());
					obj.put("gugun_name", dto.getGugun_name());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		}//gugun
		else if(command.equals("dong")) {
			String gugun = request.getParameter("gugun");
			PrintWriter out = response.getWriter();
			ArrayList<HouseInfoDTO> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectDong(gugun);
				for(HouseInfoDTO dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("code", dto.getCode());
					obj.put("dong", dto.getDong());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		}//dong
		else if(command.equals("apt")) {
			String dong = request.getParameter("dong");
			PrintWriter out = response.getWriter();
			ArrayList<HouseInfoDTO> list = null;
			JSONArray arr = new JSONArray();
			try {
				list = service.selectApt(dong);
				for(HouseInfoDTO dto : list) {
					JSONObject obj = new JSONObject();
					obj.put("no", dto.getNo());
					obj.put("dong", dto.getDong());
					obj.put("AptName", dto.getAptName());
					obj.put("code", dto.getCode());
					obj.put("jibun", dto.getJibun());
					arr.add(obj);
				}
			} catch (Exception e) {
				arr = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("message_code", "-1");
				arr.add(obj);
				e.printStackTrace();
			} finally {
				out.print(arr.toJSONString());
				out.close();
			}
		}//dong
	}//process

}
