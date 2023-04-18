<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String id = (String) session.getAttribute("id");
String home_id = request.getParameter("home_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-bottom: 80px;
}

div {
	display: flex;
	flex-direction: column;
	align-items: flex-end;
}

h1 {
	display: flex;
	justify-content: flex-start;
	align-items: flex-start;
	margin-bottom: 70px;
}

table {
	width: 900px;
	border: 1px solid #F2F2F2;
	border-radius: 20px;
	border-color: #F2F2F2;
	background-color: #F2F2F2;
	margin-bottom: 30px;
	padding: 10px;
	border: 1px solid #F2F2F2;
}

button {
	background-color: #6690FF;
	border: none;
	padding: 5px;
	border-radius: 10px;
}

tr {
	display: flex;
	justify-content: flex-start;
	align-items: flex-start;
}

th {
	font-size: 20px;
}

td {
	text-align: center;
}

.add, a {
	color: white;
	text-decoration: none;
}

.add {
	width: 100px;
	margin-bottom: 10px;
}

.star-ratings {
	margin-bottom: 40px;
	color: #aaa9a9;
	position: relative;
	unicode-bidi: bidi-override;
	width: max-content;
	-webkit-text-fill-color: transparent;
	-webkit-text-stroke-width: 1.3px;
	-webkit-text-stroke-color: #2b2a29;
	flex-direction: row;
	color: #aaa9a9;
}

.star-ratings-fill {
	color: #fff58c;
	padding: 0;
	position: absolute;
	z-index: 1;
	display: flex;
	flex-direction: row;
	top: 0;
	left: 0;
	overflow: hidden;
	-webkit-text-fill-color: gold;
}

.star-ratings-base {
	z-index: 0;
	padding: 0;
}

.add:hover {
	cursor: pointer;
}
</style>
</head>
<body>

	<h1>후기</h1>
	<div>
		<c:forEach var="reply" items="${list}">
			<table>
				<tr>
					<td>${reply.user_id}</td>
				</tr>
				<tr>
					<td>${reply.date}</td>
				</tr>
				<tr>
					<td><h3>${reply.content}</h3></td>
				</tr>
				<tr>
					<td>
						<div class="star-ratings">
							<div class="star-ratings-fill space-x-2 text-lg"
								:style="{ width: ratingToPercent + '%' }">
								<c:if test="${reply.rating==5}">
									<span>★</span>
									<span>★</span>
									<span>★</span>
									<span>★</span>
									<span>★</span>
								</c:if>
								<c:if test="${reply.rating==4}">
									<span>★</span>
									<span>★</span>
									<span>★</span>
									<span>★</span>
								</c:if>
								<c:if test="${reply.rating==3}">
									<span>★</span>
									<span>★</span>
									<span>★</span>
								</c:if>
								<c:if test="${reply.rating==2}">
									<span>★</span>
									<span>★</span>
								</c:if>
								<c:if test="${reply.rating==1}">
									<span>★</span>
								</c:if>

							</div>
						</div>
					</td>
				</tr>
				<c:if test="${id eq reply.user_id}">
					<tr>
						<td><button>
								<a
									href="/exer/replyController?action=delete&cid=${reply.id}&user_id=${reply.user_id}&home_id=${reply.home_id}">delete</a>
							</button></td>
					</tr>
				</c:if>
			</table>
		</c:forEach>
		<form action="/exer/InsertReplyController" method="get">
			<input type="text" style="display: none" name="home_id"
				value="<%=home_id%>">
			<button type="submit" class=add>추가하기</button>
		</form>
		<button class=add
			onclick="location.href='/exer/homeController?action=select&cid=5'">home</button>
	</div>
</body>
</html>