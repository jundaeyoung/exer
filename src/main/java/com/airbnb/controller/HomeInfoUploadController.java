package com.airbnb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.airbnb.service.HomeInfoUploadService;
import com.airbnb.service.HomeUploadService;

@WebServlet("/HomeInfoUploadController")
@MultipartConfig
public class HomeInfoUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeInfoUploadService homeInfoUploadService;

	public HomeInfoUploadController() {
		homeInfoUploadService = new HomeInfoUploadService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String host = request.getParameter("host");
		String info = request.getParameter("info");
		String image1 = null;
		String image2 = null;
		String image3 = null;
		String image4 = null;
		String image5 = null;
		String sideimage1 = null;
		String sideimage2 = null;
		String sideimage3 = null;

		String sideInfo1 = request.getParameter("sideInfo1");
		String sideInfo1_1 = request.getParameter("sideInfo1_1");

		String sideInfo2 = request.getParameter("sideInfo2");
		String sideInfo2_1 = request.getParameter("sideInfo2_1");

		String sideInfo3 = request.getParameter("sideInfo3");
		String sideInfo3_1 = request.getParameter("sideInfo3_1");
		String home_id = request.getParameter("home_id");
		System.out.println("title:" + title);
		// 파일 업로드 처리
		Part filePart1 = request.getPart("image1");
		Part filePart2 = request.getPart("image2");
		Part filePart3 = request.getPart("image3");
		Part filePart4 = request.getPart("image4");
		Part filePart5 = request.getPart("image5");
		Part filePart6 = request.getPart("sideimage1");
		Part filePart7 = request.getPart("sideimage2");
		Part filePart8 = request.getPart("sideimage3");

		// 스트림 준비
		InputStream fileContent1 = filePart1.getInputStream();
		InputStream fileContent2 = filePart2.getInputStream();
		InputStream fileContent3 = filePart3.getInputStream();
		InputStream fileContent4 = filePart4.getInputStream();
		InputStream fileContent5 = filePart5.getInputStream();
		InputStream fileContent6 = filePart6.getInputStream();
		InputStream fileContent7 = filePart7.getInputStream();
		InputStream fileContent8 = filePart8.getInputStream();
		// 출력 스트림 준비 ( 우리 서버 컴퓨터에 출력 )
		OutputStream outputStream = null;
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;
		OutputStream outputStream4 = null;
		OutputStream outputStream5 = null;
		OutputStream outputStream6 = null;
		OutputStream outputStream7 = null;
		OutputStream outputStream8 = null;

		try {
			// 사용자 파일명 중복 방지
			UUID uuid = UUID.randomUUID();
			String fileName1 = uuid + "_" + filePart1.getSubmittedFileName();
			String fileName2 = uuid + "_" + filePart2.getSubmittedFileName();
			String fileName3 = uuid + "_" + filePart3.getSubmittedFileName();
			String fileName4 = uuid + "_" + filePart4.getSubmittedFileName();
			String fileName5 = uuid + "_" + filePart5.getSubmittedFileName();
			String fileName6 = uuid + "_" + filePart6.getSubmittedFileName();
			String fileName7 = uuid + "_" + filePart7.getSubmittedFileName();
			String fileName8 = uuid + "_" + filePart8.getSubmittedFileName();

			// 폴더를 코드상으로 직접 생성해보기:2단계
			String saveDirectory = "C:\\java_web\\exer\\src\\main\\webapp\\images/home" + home_id + "";
			File dir = new File(saveDirectory);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 미리 폴더를 만들어 두자 : 1단계
			File file1 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName1);
			File file2 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName2);
			File file3 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName3);
			File file4 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName4);
			File file5 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName5);
			File file6 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName6);
			File file7 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName7);
			File file8 = new File("C:/java_web/exer/src/main/webapp/images/home" + home_id + "", fileName8);

			image1 = "images/home" + home_id + "/" + fileName1;
			image2 = "images/home" + home_id + "/" + fileName2;
			image3 = "images/home" + home_id + "/" + fileName3;
			image4 = "images/home" + home_id + "/" + fileName4;
			image5 = "images/home" + home_id + "/" + fileName5;
			sideimage1 = fileName6;
			sideimage2 = fileName7;
			sideimage3 = fileName8;

			// 출력 스트림 사용
			outputStream1 = new FileOutputStream(file1);
			outputStream2 = new FileOutputStream(file2);
			outputStream3 = new FileOutputStream(file3);
			outputStream4 = new FileOutputStream(file4);
			outputStream5 = new FileOutputStream(file5);
			outputStream6 = new FileOutputStream(file6);
			outputStream7 = new FileOutputStream(file7);
			outputStream8 = new FileOutputStream(file8);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = fileContent1.read(buffer)) != -1) {
				outputStream1.write(buffer, 0, length);
			}
			while ((length = fileContent2.read(buffer)) != -1) {
				outputStream2.write(buffer, 0, length);
			}
			while ((length = fileContent3.read(buffer)) != -1) {
				outputStream3.write(buffer, 0, length);
			}
			while ((length = fileContent4.read(buffer)) != -1) {
				outputStream4.write(buffer, 0, length);
			}
			while ((length = fileContent5.read(buffer)) != -1) {
				outputStream5.write(buffer, 0, length);
			}
			while ((length = fileContent6.read(buffer)) != -1) {
				outputStream6.write(buffer, 0, length);
			}
			while ((length = fileContent7.read(buffer)) != -1) {
				outputStream7.write(buffer, 0, length);
			}
			while ((length = fileContent8.read(buffer)) != -1) {
				outputStream8.write(buffer, 0, length);
			}
			// 파일 생성 완료 !!!
			System.out.println("file create complete");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileContent1.close();
			fileContent2.close();
			fileContent3.close();
			fileContent4.close();
			fileContent5.close();
			fileContent6.close();
			fileContent7.close();
			fileContent8.close();
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
			if (outputStream1 != null) {
				outputStream1.flush();
				outputStream1.close();
			}
			if (outputStream2 != null) {
				outputStream2.flush();
				outputStream2.close();
			}
			if (outputStream3 != null) {
				outputStream3.flush();
				outputStream3.close();
			}
			if (outputStream4 != null) {
				outputStream4.flush();
				outputStream4.close();
			}
			if (outputStream5 != null) {
				outputStream5.flush();
				outputStream5.close();
			}
			if (outputStream6 != null) {
				outputStream6.flush();
				outputStream6.close();
			}
			if (outputStream7 != null) {
				outputStream7.flush();
				outputStream7.close();
			}
			if (outputStream8 != null) {
				outputStream8.flush();
				outputStream8.close();
			}
		}
		int insertDTO = homeInfoUploadService.insertByHomeInfo(title, location, image1, image2, image3, image4, image5,
				host, info, sideimage1, sideInfo1, sideInfo1_1, sideimage2, sideInfo2, sideInfo2_1, sideimage3,
				sideInfo3, sideInfo3_1, Integer.parseInt(home_id));
		System.out.println(insertDTO);
		if (insertDTO == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('숙소 등록에 실패하였습니다.'); location.href='/exer/index.jsp';</script>");
			writer.close();
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println(
					"<script>alert('숙소가 등록되었습니다.'); location.href='/exer/homeController?action=select&cid=5';</script>");
			writer.close();
		}

	}
}
