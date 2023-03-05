
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.form-sign-in {
	width: 100%;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background-image: url(https://wallpapercave.com/wp/wp5294549.jpg);
	background-size: cover;
}

.form-in {
	background-color: #181a1b;
	border: 1px solid #ccc;
	width: 300px;
	padding: 20px 20px;
	border-radius: 10px;
}

.input-box {
	display: flex;
	flex-direction: column;
	margin-bottom: 15px;
}

.btn {
	width: 100%;
	height: 45px;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #49b733;
	color: #fff;
}

input[name=but1] {
	border: none;
	background-color: transparent;
}

.cap {
	margin-top: 10px;
}

.close {
	width: 50px;
	height: 50px;
	
	display: flex;
	align-items: center;
	justify-content: center;
}

.btn-lg{
	border-radius: 50%;
	width: 30px;
	height: 30px;
}
</style>
</head>
<body>

	<div class="form-sign-in">
		<form action="AdminKTDangNhapController" method="post" class="form-in">
			<div class="close">
				<a href="AdminTrangChuController"> <span
					class="glyphicon glyphicon-remove"></span>
				</a>
			</div>

			<c:if test="${Integer.parseInt(countLogin) < 3}">
				<h3>Admin Login</h3>
				<div class="input-box">
					<span>UserName</span> <input name="un" type="text">
				</div>
				<div class="input-box">
					<span>Password</span> <input name="pass" type="password">
				</div>
				<div class='btn'>
					<input name="but1" type="submit" value="Login">
				</div>
				<%-- <p>${countLogin}</p> --%>
				<c:if test="${kt!=null }">
					<p>Dang nhap sai</p>
				</c:if>
			</c:if>

			<c:if test="${Integer.parseInt(countLogin) >= 3}">
				<h3>Confirm Capcha</h3>
				<img src="simpleCaptcha.jpg" />
				<div class="input-box cap">
					<input type="text" name="answer" /><br> <input type="submit"
						value="Submit" class="btn">
				</div>
				<%-- <p>${countLogin}</p> --%>
			</c:if>
		</form>

	</div>
</body>
</html>
