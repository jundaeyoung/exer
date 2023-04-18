<%@page import="com.airbnb.controller.UserController"%>
<%@page import="com.airbnb.dto.UserDTO"%>
<%@page import="com.airbnb.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
String password = (String)session.getAttribute("password");
UserService userService = new UserService();

UserDTO responseDTO = userService.selectByUserId(id, password);
String dbId = responseDTO.getId();
String dbPwd = responseDTO.getPassword();
String dbTel= responseDTO.getTel();
String dbEmail= responseDTO.getEmail();
%>
<%@ page errorPage="errorPage.jsp"%>
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
	margin: 20px;
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
	margin-bottom: 150px;
	margin: 10px;
}
</style>

</head>
<body>
	<section>
		<img alt="" src="images/airbnb.jpg">
	</section>
	<section class="header">
		<div class="icon">
			<h1>회원수정</h1>
		</div>
	</section>
	<section class=content>
		<form action="/exer/userupdatecontroller" method="POST">
			<div class="form-group">
				<label>아이디</label> <input type="text" value=<%= dbId %> name="id"
					id="id" class="form-control" readonly="readonly">
			</div>
			<div class="form-group">
				<label>비밀번호</label> <input type="password" value=<%= dbPwd %>
					name="password" id="password" class="form-control" required>
			</div>
			<div class="form-group">
				<label>전화번호</label> <input type="tel" value=<%= dbTel %> name="tel"
					id="tel" class="form-control" required>
			</div>
			<div class="form-group">
				<label>이메일</label> <input type="email" value=<%= dbEmail %>
					name="email" id="email" class="form-control" required>
			</div>
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
		<form action="/exer/UserInfoController" method="GET">
			<button type="submit" class="btn btn-primary">되돌아가기</button>
		</form>
	</section>
	<%-- 세션 클래스에 사용자 이름이 저장되어 있으면 로그인 상태를 유지합니다. --%>
	<% if(session.getAttribute("id")!=null){ %>


	<%}%>
</body>
</html>