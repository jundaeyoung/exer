package com.airbnb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.airbnb.service.HomeUploadService;

@WebServlet("/homeUploadController")
@MultipartConfig
public class HomeUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeUploadService homeUploadService;

	public HomeUploadController() {
		homeUploadService = new HomeUploadService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/exer/homeUpload.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String price = request.getParameter("price");
		String name = request.getParameter("name");
		String day = request.getParameter("day");
		String view = request.getParameter("view");
		String id = request.getParameter("id");
		String image = null;

		Part filePart = request.getPart("image");

		InputStream fileContent = filePart.getInputStream();

		OutputStream outputStream = null;

		try {
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + "_" + filePart.getSubmittedFileName();
			String saveDirectory = "C:/java_web/exer/src/main/webapp/images";
			File dir = new File(saveDirectory);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 미리 폴더를 만들어 두자 : 1단계
			File file = new File("C:/java_web/exer/src/main/webapp/images", fileName);

			image = "images/" + fileName;

			outputStream = new FileOutputStream(file);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = fileContent.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
				System.out.println("file create complete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileContent.close();
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}
		int insertDTO = homeUploadService.insertByHome(price, name, day, view, image);
		if (insertDTO == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('숙소 등록에 실패하였습니다.'); location.href='/exer/UserInfoController';</script>");
			writer.close();
		} else {
			request.setAttribute("insertDTO", insertDTO);
			System.out.println((int) request.getAttribute("insertDTO"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeInfoUpload.jsp");
			dispatcher.forward(request, response);
		}
	}

}
