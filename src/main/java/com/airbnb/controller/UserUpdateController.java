package com.airbnb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airbnb.dto.UserDTO;
import com.airbnb.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/userupdatecontroller")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public UserUpdateController() {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		UserDTO responseDTO = userService.selectByUserId((String) request.getSession().getAttribute("id"));
		String targetId = responseDTO.getId();

		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("tel : " + tel);
		System.out.println("email : " + email);
		System.out.println("targetId : " + targetId);
		// 다른곳으로 한번 더 돌림

		int updateDTO = userService.updateByUser(id, password, tel, email,targetId);
			System.out.println("updateDTO : " + updateDTO);
			if(updateDTO == 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('정보수정이 실패하였습니다.'); location.href='/exer/edite.jsp';</script>");
				writer.close();
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('정보수정이 성공하였습니다.'); location.href='/exer/homeController?action=select&cid=5';</script>");
				writer.close();
			}
		}
	}

