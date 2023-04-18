<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>

<%
	// 세션을 꺼내는 방법 확인
	String id = (String)session.getAttribute("id");
	if(id==null){
		response.sendRedirect("signin.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>airbnb</title>
<link rel="shortcut icon" sizes="76x76" type="image/x-icon"
	href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1 {
	flex: 1;
	margin-top: 250px;
	margin-bottom: 50px;
}

form {
	flex: 1;
}

button {
	margin: 10px;
	width: 150px;
}
</style>

</head>
<body>
	<h1>
		반갑습니다 <br>
		<%= id %>
		님
	</h1>
	<form action="/exer/UserEditorController">
		<button type="submit" class="btn btn-primary">정보수정</button>
	</form>
	<form action="/exer/homeUploadController">
		<button type="submit" class="btn btn-primary">숙소등록</button>
	</form>
	<form action="/exer/UserLogoutController">
		<button type="submit" class="btn btn-primary">Logout</button>
	</form>
	<form
		action="/exer/homeController?action=select&cid=5">
		<button type="submit" class="btn btn-primary">Home</button>
	</form>
</body>
</html>