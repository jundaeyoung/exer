package com.airbnb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertReplyController")
public class InsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertReplyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String home_id = request.getParameter("home_id");
		System.out.println(home_id);
		response.sendRedirect("insertReply.jsp?home_id=" + home_id + "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
