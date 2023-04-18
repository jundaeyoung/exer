<%@page import="com.airbnb.dto.HomeDTO"%>
<%@page import="com.airbnb.dao.HomeDAO"%>
<%@page import="com.airbnb.service.HomeUploadService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String id = (String) session.getAttribute("id");
String home_id = (String) session.getAttribute("home_id");
HomeDAO dao = new HomeDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>airbnb</title>
<link rel="shortcut icon" sizes="76x76" type="image/x-icon"
	href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">
<style type="text/css">
* {
	background-color: white;
	margin: 0;
	padding: 0;
}

body {
	margin-bottom: 80px;
}

.header {
	display: flex;
	align-items: center;
	justify-content: center;
}

.header div {
	flex: 1;
	margin: 10px;
	display: flex;
}

.air {
	flex: 2;
}

.serch {
	border-radius: 30px;
	padding: 10px;
	display: flex;
	align-items: center;
	justify-content: center;
}

input {
	height: 40px;
	text-align: center;
	justify-content: center;
}

.list .serch {
	margin-left: 100px;
	display: flex;
}

div {
	flex: 1;
}

.home {
	display: flex;
	align-items: center;
	justify-content: center;
}

.home div {
	max-width: 2000px;
	margin: 10px;
	display: flex;
	flex-wrap: wrap;
	align-items: center;
	justify-content: center;
}

#homeinfo {
	margin: 20px 60px;
	flex-direction: column;
	display: flex;
}

#homeinfo {
	min-width: 450px;
	max-width: 500px;
	display: flex;
	flex-direction: column;
	flex: 0 0 1;
	align-items: flex-start;
	justify-content: flex-start;
}

#homeinfo #id {
	border: none;
}

#homeinfo #id:hover img {
	transform: scale(1.01);
}
</style>

</head>
<body>
	<section class="header">
		<div class="icon">
			<a href="/exer/homeController?action=select&cid=5"><img alt=""
				src="images/airbnb.jpg"></a>
		</div>
		<div class="air"></div>
		<div>
			<form action="/exer/searchcontroller" method="POST" class="serch">
				<input type="text" name="search"
					style="border-radius: 20px; width: 300px;"
					placeholder="어디든지 | 언제든 일주일 | 게스트추가">
				<button type="submit" style="border: none">
					<img alt="" src="images/search.png" style="height: 45px">
				</button>

			</form>
		</div>
		<div>당신의 공간을 에어비엔비하세요</div>
		<div>
			<a href="/exer/UserInfoController"><img alt=""
				src="images/Login.png" class="login"></a>
		</div>
	</section>
	<hr>
	<section class="list">
		<div class="serch">
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list1.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list2.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list3.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list4.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list5.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list6.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list7.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list8.jpg"></a>
			</div>
			<div>
				<a href="/exer/ErrorPageController"><img alt=""
					src="images/list9.jpg"></a>
			</div>
		</div>
	</section>
	<section class="home">
		<div>
			<c:forEach var="home" items="${list}">
				<form action="/exer/homeInfoController" name="home_id" method="GET"
					class="serch " id="homeinfo">
					<button type="submit" name="id" value="${home.id}" id="id">
						<img alt="" src="${home.image}"
							style="border-radius: 20px" width=430 height=430>
					</button>
					<p>${home.name}</p>
					<p>${home.view}</p>
					<p>${home.day}</p>
					<p>${home.price}</p>
				</form>
			</c:forEach>
		</div>
	</section>
</body>
</html>