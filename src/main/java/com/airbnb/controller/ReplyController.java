package com.airbnb.controller;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airbnb.dao.ReplyDAO;
import com.airbnb.dto.ReplyDTO;
import com.airbnb.utils.DBHelper;


@WebServlet("/replyController")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		DBHelper dbHelper = new DBHelper();
		dbHelper.getConnection(); // DB 연결
	}

	public ReplyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyDAO dao = new ReplyDAO();
		String home_id = request.getParameter("home_id");
		String action = request.getParameter("action");
		request.setAttribute("home_id", home_id);
		System.out.println("home_iddff" + home_id);
		if ("delete".equals(action)) {
			String user_id = request.getParameter("user_id");
			String cid = request.getParameter("cid");
			System.out.println("user_id" + user_id);
			System.out.println("cid"+cid);
			dao.delete(user_id,Integer.parseInt(cid));
			ArrayList<ReplyDTO> resultlist = dao.select(Integer.parseInt(home_id));
			request.setAttribute("list", resultlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("reply.jsp");
			dispatcher.forward(request, response);
		} else{
			ArrayList<ReplyDTO> resultlist = dao.select(Integer.parseInt(home_id));
			request.setAttribute("list", resultlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("reply.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyDAO replyDAO = new ReplyDAO();
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int responseCount = 0;
		String user_id = request.getParameter("user_id");
		String home_id = request.getParameter("home_id");
		System.out.println("여기는 replyController doPost"+home_id);
		
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		String rating = request.getParameter("rating");
		if(action.equals("update")) {
			String id = request.getParameter("id");
			responseCount = replyDAO.update(Integer.parseInt(id),user_id, Integer.parseInt(home_id),content);
		}else if(action.equals("insert")) {
			responseCount = replyDAO.insert(user_id,Integer.parseInt(home_id), content , Integer.parseInt(rating));	
			ArrayList<ReplyDTO> resultlist = replyDAO.select(Integer.parseInt(home_id));
			request.setAttribute("list", resultlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("reply.jsp");
			dispatcher.forward(request, response);
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("저장된 갯수 확인 : " + responseCount);
	
	}

}
