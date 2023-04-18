 package com.airbnb.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airbnb.dao.HomeInfoDAO;
import com.airbnb.dto.HomeInfoDTO;
import com.airbnb.service.HomeInfoService;

@WebServlet("/homeInfoController")
public class HomeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeInfoService homeInfoService;

	public HomeInfoController() {
		homeInfoService = new HomeInfoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HomeInfoDAO dao = new HomeInfoDAO();
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String home_id = request.getParameter("id");
		System.out.println(home_id);
		if ("delete".equals(action)) {

		} else {

			HomeInfoDTO responseDTO = dao.select(Integer.parseInt(home_id));
			request.setAttribute("action", action);
			request.setAttribute("home_id", home_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeInfo.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
