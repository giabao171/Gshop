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
	justify-content: center;
    width: 70%;
    padding: 10px;
    border: 1px solid #fff;
    border-radius: 10px;
}

.box {
	display: flex;
	justify-content: center;
	background-color: #1b1e1f;
	width: 50%;
	margin: 0 auto;
	padding-top: 20px;
	padding-bottom: 20px;
	border-radius: 10px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><h3 class="title">Gundam Shop</h3></li>
				<li><a href="AdminTrangChuController">Trang chủ</a></li>
				<li><a href="AdminQuanLySanPhamController">Quản lý sản phẩm</a></li>
				<li><a href="AdminQuanLyLoaiController">Quản lý loại sản
						phẩm</a></li>
				<li class="active"><a href="AdminXacNhanDonHangController">Xác
						nhận đơn hàng</a></li>
				<li><a href="AdminLichSuGiaoDichController">Lịch sử giao
						dịch đơn hàng</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="AdminDangKyController"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><c:choose>
						<c:when test="${dnad == null}">
							<a href="AdminKTDangNhapController"> <span
								class="glyphicon glyphicon-log-in"></span> Login
							</a>
						</c:when>
						<c:otherwise>
							<div class="dropdown" style="margin-top: 5px;">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									${dnad.getTendn()} <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="AdminKTDangNhapController?lou=tr">Đăng
											xuất</a></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</div>
	</nav>
	<div class="box">
		<div class="container">
			<form class="form-horizontal" action="AdminSuaLoaiController">
				<c:if test="${loaiitem !=null }">
					<h2>Thêm loại sản phẩm</h2>
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Mã loại:</label>
					<div class="col-sm-10">
						<input name='maloai' type="text" class="form-control" id="pwd"
							value="${loaiitem.getMaloai() }" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Tên loại:</label>
					<div class="col-sm-10">
						<input name='tenloai' type="text" class="form-control" id="pwd"
							value="${loaiitem.getTenloai()}">
					</div>
				</div>

				<div style="display: flex; margin-left: 100px;">
					<div class="form-group" style="margin-right: 20px;">
						<div class="col-sm-offset-2 col-sm-10">
							<input name="suabtn" type="submit" class="btn btn-success"
								value="Lưu thông tin">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input name="backbtn" type="submit" class="btn btn-primary"
								value="Quay lại">
						</div>
					</div>
				</div>
				</c:if>
			</form>
		</div>
	</div>

</body>
</html>