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
.title {
	font-weight: 700;
	font-size: 19px;
	margin-right: 10px;
	color: #33b793;
}

body {
	background-image: url(https://wallpapercave.com/wp/wp5294549.jpg);
	background-size: cover;
}

.container {
	display: flex;
	width: 100%;
	justify-content: center;
	align-items: center;
}

.mh-container {
	margin-top: 40px;
	margin-left: 10px;
	padding: 10px;
	border-radius: 10px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 1px solid #ccc;
	background-color: #1b1e1f;
	    margin-bottom: 20px;
}

.overlay {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: #33333396 !important;
	display: flex;
	align-items: center;
	justify-content: center;
}

.er-box {
	width: 300px;
	border: 2px solid #fff;
	border-radius: 10px;
	height: 150px;
	padding: 20px;
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	background-color: #1b1e1f;
}

</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><h3 class="title">Gundam Shop</h3></li>
				<li class="active"><a href="TrangChuController">Trang chủ</a></li>
				<li><a href="GioHangController">Giỏ hàng</a></li>
				<!-- <li><a href="">Thanh toán</a></li> -->
				<li><a href="LichSuMuaHangController">Lịch sử mua hàng</a></li>
				<li>
					<form action="TrangChuController" method="post" class="form-inline"
						style="display: flex; margin-top: 10px;">
						<h5 style="margin-right: 10px; color: #fff;">
							Tìm kiếm
							</h4>
							<input name="txttk" type="text" value="" placeholder="Nhap tt"
								class="form-control"> <br> <input name="butt"
								type="submit" value="Search" class="btn btn-primary">
					</form>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="DangKyControllerG"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><c:choose>
						<c:when test="${dn == null}">
							<a href="KTDangNhapController"> <span
								class="glyphicon glyphicon-log-in"></span> Login
							</a>
						</c:when>
						<c:otherwise>
							<div class="dropdown" style="margin-top: 5px;">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									${dn.getTendn()} <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="KTDangNhapController?lou=tr">Đăng xuất</a></li>
									<li><a href="HoSoController">Xem hồ sơ</a></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="mh-container">
		<c:if test="${dn == null}"></c:if>
			<form class="form-horizontal" action="HoSoController">
				<h2>Thông tin tài khoản</h2>
				<div class="form-group row">
					<label class="col-md-4" for="email">Họ tên:</label>
					<div class="col-md-8">
						<input name='hoten' type="text" class="form-control" id="email"
							placeholder="Enter email" value="${dn.getHoten() }">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4" for="pwd">Địa chỉ:</label>
					<div class="col-md-8">
						<input name='diachi' type="text" class="form-control" id="pwd"
							placeholder="Enter password" value="${dn.getDiachi() }">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-md-4" for="pwd">Số điện thoại:</label>
					<div class="col-md-8">
						<input name='sdt' type="text" class="form-control" id="pwd"
							placeholder="Enter password" value="${dn.getSdt() }">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-md-4" for="pwd">Email:</label>
					<div class="col-md-8">
						<input name='email' type="text" class="form-control" id="pwd"
							placeholder="Enter password" value="${dn.getEmail() }">
					</div>
				</div>
				
				<div style="">
					<div class="form-group row" style="margin-right: 20px;">
					<div class="col-sm-offset-9 col-sm-10">
						<input name="cnbtn" type="submit" class="btn btn-success" value="Cập nhật">
					</div>
				</div>
				
				<h2>Đổi mật khẩu</h2>
				
				<div class="form-group row">
					<label class="col-md-5" for="pwd">Nhập mật khẩu cũ:</label>
					<div class="col-md-7">
						<input name='txtoldpass' type="password" class="form-control" id="pwd"
							placeholder="Enter old password" >
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-md-5" for="pwd">Nhập mật khẩu mới:</label>
					<div class="col-md-7">
						<input name='txtnewpass' type="password" class="form-control" id="pwd"
							placeholder="Enter new password" >
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-md-5" for="pwd">Xác nhận mật khẩu mới:</label>
					<div class="col-md-7">
						<input name='txtcfpass' type="password" class="form-control" id="pwd"
							placeholder="Confirm new password">
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-offset-8 col-md-10">
						<input name="dmkbtn" type="submit" class="btn btn-primary" value="Đổi mật khẩu">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input name="backbtn" type="submit" class="btn btn-primary" value="Quay lại">
					</div>
				</div>
				</div>
				
			</form>
		</div>
	</div>
	<c:if test="${ebox == '1' }">
	<div class="overlay">
		<div class="er-box">
			<h4>Lỗi! Bạn đã nhập sai thông tin</h4>
			<btn class="btn btn-success"> 
				<a href="HoSoController?noterr=1">OK</a>
			</btn>
		</div>
	</div>
	</c:if>
</body>
</html>