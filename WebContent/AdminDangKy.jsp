
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
	color:#fff;
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

.input{
	background-color: transparent;
	color: #000;
}
</style>
</head>
<body>

	<div class="form-sign-in">
		<form action="AdminDangKyController" method="post" class="form-in">
			<div class="close">
				<a href="AdminTrangChuController"> <span
					class="glyphicon glyphicon-remove"></span>
				</a>
			</div>
			<h3>Admin Sign Up</h3>
			<div class="input-box">
				<span>Tên đăng nhập</span> <input name="tdn" type="text">
			</div>
			<div class="input-box">
				<span>Mật khẩu</span> <input name="mk" type="password">
			</div>
			<div class='btn'>
				<input name="but1" type="submit" value="Sign in">
			</div>
		</form>
	</div>
</body>
</html>
