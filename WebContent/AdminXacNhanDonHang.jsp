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
	/* padding: 0 200px; */
}

.box {
	background-color: #1b1e1f;
	width: 80%;
	margin: 0 auto;
	padding-top: 20px;
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
				<li><a href="AdminQuanLyLoaiController">Quản lý loại sản phẩm</a></li>
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
			<table class="table table-bordered table-striped">
				<thead>
					<tr style="color: #fff; background-color: #33b793">
						<th class="text-center">Mã hóa đơn</th>
						<th class="text-center">Mã khách hàng</th>
						<th class="text-center">Ngày mua</th>
						<th class="text-center">Chi tiết</th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${dshdcm != null}">
						<c:forEach var="s" items="${dshdcm}">
							<tr style="background-color: #1b1e1f;">
								<td class="text-center">${s.getMahoadon() }</td>
								<td class="text-center">${s.getMakh() }</td>
								<td class="text-center">${s.getNgaymua()}</td>
								<td class="text-center">
									<button type="button" class="btn btn-success">
										<a
											href="AdminXTChiTietDonHangController?mhd=${s.getMahoadon() }">
											<span class="glyphicon glyphicon-th-list"></span>
										</a>
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>

			</table>

		</div>
	</div>

</body>
</html>