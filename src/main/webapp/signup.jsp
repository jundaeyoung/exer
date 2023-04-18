<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>
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
	margin-bottom: 100px;
}
</style>
</head>
<body>
	<section>
		<img alt="" src="images/airbnb.jpg">
	</section>
	<section class="header">
		<div class="icon">
			<h1>회원가입</h1>
		</div>
	</section>
	<section class=content>
		<form action="/exer/usersignupcontroller" method="POST">
			<div class="form-group">
				<label>아이디</label> <input type="text" placeholder=id name="id"
					id="id" class="form-control" required>
			</div>
			<div class="form-group">
				<label>비밀번호</label> <input type="password" placeholder="password"
					name="password" id="password" class="form-control" required>
			</div>
			<div class="form-group">
				<label>전화번호</label> <input type="tel" placeholder="tel" name="tel"
					id="tel" class="form-control" required>
			</div>
			<div class="form-group">
				<label>이메일</label> <input type="email" placeholder=email
					name="email" id="email" class="form-control" required>
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
	</section>
</body>
</html>