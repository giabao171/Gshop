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
	/* width: 100%; */
	/* height: 100vh; */
	/* display: flex;
	justify-content: center; */
	background-image: url(https://wallpapercave.com/wp/wp5294549.jpg);
	background-size: cover;
}

.img {
	width: 200px;
	height: 100px;
}

.ss {
	color: #44ad40;
}

.notss {
	color: #d6a339;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><h3 class="title">Gundam Shop</h3></li>
				<li><a href="TrangChuController">Trang chủ</a></li>
				<li><a href="GioHangController">Giỏ hàng</a></li>
				<!-- <li><a href="">Thanh toán</a></li> -->
				<li class="active"><a href="LichSuMuaHangController">Lịch
						sử mua hàng</a></li>
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
		<table class="table table-bordered table-striped">
			<thead>
				<tr style="color: #fff; background-color: #33b793">
					<th></th>
					<th class="text-center">Tên mô hình</th>
					<th class="text-center">Giá</th>
					<th class="text-center">Thành tiền</th>
					<th class="text-center">Ngày mua</th>
					<th class="text-center">Tình trạng</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${dslsmh != null}">
					<c:forEach var="s" items="${dslsmh}">
						<tr style="background-color: #1b1e1f;">
							<td class="text-center"><img class='img'
								src="${s.getAnh() }" /></td>
							<td class="text-center">
								<div style="display: flex; flex-direction: column;">
									${s.getTenmohinh()} x${s.getSoluongmua() }
									<div class="btn btn-success">
										<a style="color:#fff;" href="ChTietMoHinhController?mmh=${s.getMamohinh()}">Mua
											lại sản phẩm</a>
									</div>
								</div>
							</td>
							<td class="text-center">${s.getGia() }</td>
							<td class="text-center">${s.getThanhtien()}</td>
							<td class="text-center">${s.getNgaymua()}</td>

							<c:choose>
								<c:when test="${s.isDamua() == 'true'}">
									<td class='text-center ss'>Đã xác nhận</td>
								</c:when>
								<c:otherwise>
									<td class='text-center notss'>Đang chờ xác nhận</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>

		</table>

	</div>
</body>
</html>