<%@page import="java.io.PrintWriter"%>
<%@page import="com.airbnb.service.UserService"%>
<%@page import="com.airbnb.dto.UserDTO"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
UserService userService = new UserService();

UserDTO responseDTO = userService.selectByUserId(id, password);
String dbId = responseDTO.getId();
String dbPwd = responseDTO.getPassword();

if (id != null && password != null) {
	if (id.equals(dbId) && password.equals(dbPwd)) {
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('로그인 되었습니다'); location.href='/exer/homeController?action=select&cid=5';</script>");	
		writer.close();
		response.sendRedirect("airbnbHomeLogin.jsp");
	} else {
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('아이디,비밀번호가 일치하지 않습니다 확인해주세요'); location.href='/exer/UserSignInController';</script>");	
		writer.close();
	}
}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>airbnb</title>
<link rel="shortcut icon" sizes="76x76" type="image/x-icon"
	href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	height: 100vh;
	padding: 10px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.head {
	width: 200px;
}

input {
	flex: 1;
	border-radius: 10px;
}

.form-group {
	width: 250px;
}

button {
	float: right;
	margin: 1px;
	margin-bottom: 150px;
}
</style>

</head>
<body>
	<!-- 
	signin.html 요청을 하면 화면을 그리는 담당
	1.요청
	form 태그중 method 속성, action 속성에 대해 알아보고 
	name 값과 password 값을 보낼 수 있는 화면을 구성하시오. 
	
	2. 버튼을 누르면 연산 처리를 할 서블릿 객체를 만들어 주세요.
		method 방식은 post
		서버 콘솔창에 넘겨받은 데이터를 출력하시오
	-->
	<section>
		<img alt="" src="images/airbnb.jpg">
	</section>
	<section class="header">
		<div class="icon">
			<h1>Login</h1>
		</div>
	</section>
	<section class=content>
		<form action="/exer/signin.jsp" method="POST">
			<div class="form-group">
				<input type="text" placeholder=id name="id" id="id"
					class="form-control" required>
			</div>
			<div class="form-group">
				<input type="password" placeholder=pw name="password" id="password"
					class="form-control" required>
			</div>
			<a href="/exer/usercontroller"><button type="submit"
					class="btn btn-primary">로그인</button></a> <a href="/exer/signup.jsp"><button
					type="button" class="btn btn-primary" style="text-color: white">
					회원가입</button></a>
		</form>
	</section>
	<%-- 세션 클래스에 사용자 이름이 저장되어 있으면 로그인 상태를 유지합니다. --%>
	<% if(session.getAttribute("id")!=null){ %>


	<%}%>
</body>
</html>