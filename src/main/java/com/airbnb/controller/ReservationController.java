package com.airbnb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airbnb.dto.UserDTO;
import com.airbnb.service.ReservationService;
import com.airbnb.service.UserService;

@WebServlet("/reservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService homeService;

	public ReservationController() {
		homeService = new ReservationService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		String personNumber = request.getParameter("personNumber");
		String user_id = request.getParameter("id");
		String home_id = request.getParameter("home_id");

		System.out.println("start_date : " + start_date);
		System.out.println("end_date : " + end_date);
		System.out.println("personNumber : " + personNumber);
		System.out.println("user_id : " + user_id);
		System.out.println("home_id : " + home_id);
//		// 다른곳으로 한번 더 돌림
		int insertDTO = homeService.insertByReservation(start_date, end_date, Integer.parseInt(personNumber), user_id,
				Integer.parseInt(home_id));
		System.out.println("insertDTO" + insertDTO);
		if (insertDTO == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('예약에 실패하였습니다.'); location.href='/exer/homeController?action=select&cid=5';</script>");
			writer.close();
		} else {
			response.sendRedirect("/exer/reservation.jsp");
		}
	}
}
