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
import javax.websocket.Session;

import com.airbnb.dao.HomeDAO;
import com.airbnb.dto.HomeDTO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/searchcontroller")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HomeDAO dao = new HomeDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String search = request.getParameter("search");
		System.out.println("search : " + search);
		if("delete".equals(action)) {
		}else {
			
		ArrayList<HomeDTO> resultlist = dao.search(search);
		System.out.println(resultlist+"resultliset");
		request.setAttribute("list", resultlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("airbnbHomeLogin.jsp");
		dispatcher.forward(request, response);
		}
//		if(request.getSession().getAttribute("id").equals("jdy1787") && request.getSession().getAttribute("password").equals("1234")) {
//		}else {
//			response.sendRedirect("airbnbHome.jsp");
//			
//		}
	}

}
