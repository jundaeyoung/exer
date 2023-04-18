package com.airbnb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airbnb.dao.HomeDAO;
import com.airbnb.dto.HomeDTO;
import com.airbnb.utils.DBHelper;

@WebServlet("/homeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO dao;

	@Override
	public void init() throws ServletException {
		DBHelper dbHelper = new DBHelper();
		dbHelper.getConnection();
	}

	public HomeController() {
		dao = new HomeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HomeDAO dao = new HomeDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String home_id = request.getParameter("id");
		if ("search".equals(action)) {
			ArrayList<HomeDTO> resultlist = dao.select();
//			request.setAttribute("home_id", home_id);
			request.setAttribute("list", resultlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("airbnbHome.jsp");
			dispatcher.forward(request, response);
		} else {
			ArrayList<HomeDTO> resultlist = dao.select();
//			request.setAttribute("home_id", home_id);
			request.setAttribute("list", resultlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("airbnbHomeLogin.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
