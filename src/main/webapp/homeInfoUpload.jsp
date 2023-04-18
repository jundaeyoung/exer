<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int insertDTO = (int) request.getAttribute("insertDTO");
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
	margin: 20px;
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
			<h1>숙소 등록</h1>
		</div>
	</section>
	<section class=content>
		<form action="/exer/HomeInfoUploadController" method="POST"
			enctype="multipart/form-data">
			<div class="form-group">
				<label>제목</label> <input type="text" placeholder="아쿠아홀릭 이리타하마 B 윙"
					name="title" id="id" class="form-control" required>
			</div>
			<div class="form-group">
				<label>지역</label> <input type="text"
					placeholder=" 시모다, Shizuoka, 일본" name="location" id="password"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>이미지1</label> <input type="file"
					placeholder="images/home1/home1_1.jpg" name="image1" id="tel"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>이미지2</label> <input type="file"
					placeholder="images/home1/home1_2.jpg" name="image2" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>이미지3</label> <input type="file"
					placeholder="images/home1/home1_3.jpg" name="image3" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>이미지4</label> <input type="file"
					placeholder="images/home1/home1_4.jpg" name="image4" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>이미지5</label> <input type="file"
					placeholder="images/home1/home1_5.jpg" name="image5" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>host소개</label> <input type="text"
					placeholder="Onda 님이 호스팅하는 펜션" name="host" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소정보</label> <input type="text"
					placeholder="최대 인원 2명 · 원룸 · 침대 1개 · 욕실 1개" name="info" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소정보이미지1</label> <input type="file"
					placeholder="superhost1.png" name="sideimage1" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의1</label> <input type="text"
					placeholder="그랜드테라스님은 슈퍼호스트입니다" name="sideInfo1" id="email"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의설명1</label> <input type="text"
					placeholder="슈퍼호스트는 풍부한 경험과 높은 평점을 자랑하며 게스트가 숙소에서 편안히 머무를 수 있도록 최선을 다하는 호스트입니다.."
					name="sideInfo1_1" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소정보이미지2</label> <input type="file" placeholder="checkin.png"
					name="sideimage2" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의2</label> <input type="text" placeholder="셀프 체크인"
					name="sideInfo2" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의설명2</label> <input type="text" placeholder="셀프 체크인"
					name="sideInfo2_1" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소정보이미지3</label> <input type="file" placeholder="key.png"
					name="sideimage3" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의3</label> <input type="text" placeholder="순조로운 체크인 과정"
					name="sideInfo3" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label>숙소편의설명3</label> <input type="text"
					placeholder="최근 숙박한 게스트 중 100%가 체크인 과정에 별점 5점을 준 숙소입니다."
					name="sideInfo3_1" id="email" class="form-control" required>
			</div>
			<div class="form-group">
				<label></label> <input type="hidden" value="<%=insertDTO%>"
					name="home_id" id="email" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
		</form>
	</section>
</body>
</html>