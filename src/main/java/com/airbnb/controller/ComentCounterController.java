package com.airbnb.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airbnb.dto.ReplyDTO;
import com.airbnb.dto.UserDTO;
import com.airbnb.service.ReplyService;

@WebServlet("/coment")
public class ComentCounterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyService comentService;

	public ComentCounterController() {
		comentService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String home_id = request.getParameter("home_id");
		ReplyDTO responseDTO = comentService.comentCount(Integer.parseInt(home_id));
		response.sendRedirect("/exer/airbnbHomeLogin.jsp");
	}

}
