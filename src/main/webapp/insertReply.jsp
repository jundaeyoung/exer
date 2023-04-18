<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("id");
String home_id = request.getParameter("home_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>airbnb</title>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
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
}

button {
	background-color: #6690FF;
	border: none;
	padding: 5px;
	border-radius: 10px;
	margin-top: 10px;
}

tr {
	display: flex;
	justify-content: center;
	align-items: center;
}

th {
	font-size: 20px;
}

td {
	text-align: center;
}

a {
	color: white;
	text-decoration: none;
}

.add {
	width: 120px;
	height: 40px;
	margin-bottom: 10px;
	color: white;
	font-size: 20px;
}

form {
	display: flex;
}

.coment {
	width: 800px;
	height: 200px;
	border-radius: 9px;
	justify-content: flex-start;
	align-items: flex-start;
}

.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 2.25rem;
	line-height: 2.5rem;
	justify-content: space-around;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
}

.star-rating input {
	display: none;
}

.star-rating label {
	-webkit-text-fill-color: transparent;
	/* Will override color (regardless of order) */
	-webkit-text-stroke-width: 2.3px;
	-webkit-text-stroke-color: #2b2a29;
	cursor: pointer;
}

.star-rating :checked ~ label {
	-webkit-text-fill-color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	-webkit-text-fill-color: #fff58c;
}

.add:hover {
	cursor: pointer;
	background-color: #3350B7;
}
</style>
</head>
<body>
	<h1>후기</h1>
	<div>
		<form action="/exer/replyController?action=insert" method="post">
			<table>
				<tr>
					<td>후기를 작성해주세요</td>
				</tr>
				<tr>
					<td>
						<h3>
							<input type="text" style="display: none" name="user_id"
								value="<%=id%>"> <input type="text"
								style="display: none" name="home_id" value="<%=home_id%>">
							<input type="text" class="coment" name="content"
								required="required"
								style="background: #F2F2F2; border: 1px solid #747474">
						</h3>
					</td>
				</tr>
				<tr>
					<td>
						<div class="star-rating space-x-4 mx-auto">
							<input type="radio" id="5-stars" name="rating" value="5"
								v-model="ratings" /> <label for="5-stars" class="star pr-4">★</label>
							<input type="radio" id="4-stars" name="rating" value="4"
								v-model="ratings" /> <label for="4-stars" class="star">★</label>
							<input type="radio" id="3-stars" name="rating" value="3"
								v-model="ratings" /> <label for="3-stars" class="star">★</label>
							<input type="radio" id="2-stars" name="rating" value="2"
								v-model="ratings" /> <label for="2-stars" class="star">★</label>
							<input type="radio" id="1-star" name="rating" value="1"
								v-model="ratings" /> <label for="1-star" class="star">★</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<button type="submit" class=add>등록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>