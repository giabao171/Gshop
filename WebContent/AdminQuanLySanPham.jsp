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

.img {
	width: 200px;
	height: 100px;
	border: 1px solid #000;
	border-radius: 8px;
}

.box {
	background-color: #1b1e1f;
	width: 80%;
	margin: 0 auto;
	padding-top: 20px;
	border-radius: 10px;
	padding-bottom: 30px;
}

.back-btn {
	float: right;
	margin-right: 100px;
	margin-bottom: 10px;
}

.num-page {
	display: flex;
	width: 100%;
	justify-content: center;
}

.page {
	width: 40px;
	height: 40px;
	border: 1px solid #33b793;
	border-radius: 10px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 5px;
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
				<li><a href="AdminTrangChuController">Trang chủ</a></li>
				<li class="active"><a href="AdminQuanLySanPhamController">Quản
						lý sản phẩm</a></li>
				<li><a href="AdminQuanLyLoaiController">Quản lý loại sản
						phẩm</a></li>
				<li><a href="AdminXacNhanDonHangController">Xác nhận đơn
						hàng</a></li>
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
		<button type="button" class="btn btn-primary back-btn">
			<a href="AdminThemSanPhamController" style="color: #fff;">Thêm sản phẩm</a>
		</button>
		<div class="container">
			<table class="table table-bordered table-striped">
				<thead>
					<tr style="color: #fff; background-color: #33b793">
						<th class="text-center"></th>
						<th class="text-center">Mã mô hình</th>
						<th class="text-center">Tên mô hình</th>
						<th class="text-center">Mã loại</th>
						<th class="text-center">Giá</th>
						<th class="text-center">Nhà sản xuất</th>
						<th class="text-center">Chỉnh sửa</th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${dsmohinh != null}">
						<c:forEach var="s" items="${dsmohinh}">
							<tr style="background-color: #1b1e1f;">
								<td class="text-center">	
									<c:choose>
										<c:when test="${s.getAnh() != null}">
											<img class='img'src="${s.getAnh() }" />
										</c:when>
										<c:otherwise>
											<img class='img'src="Gshop/er.png" />
										</c:otherwise>
									</c:choose>
								</td>
								<td class="text-center">${s.getMamohinh() }</td>
								<td class="text-center">${s.getTenmohinh() }</td>
								<td class="text-center">${s.getMaloai() }</td>
								<td class="text-center">${s.getGia() }</td>
								<td class="text-center">${s.getNhasanxuat() }</td>
								<td class="text-center">
									<button type="button" class="btn btn-success">
										<a style="color: #fff;"
											href="AdminSuaSanPhamController?mmh=${s.getMamohinh() }"> <span
											class="glyphicon glyphicon-th-list"></span>
										</a>
									</button>
									<button type="button" class="btn btn-danger">
										<a style="color: #fff;"
											href="AdminXoaSanPhamController?mmh=${s.getMamohinh() }"> <span
											class="glyphicon glyphicon-remove"></span>
										</a>
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>

			</table>

		</div>
		<div class="num-page">

			<div class="page">
				<a
					href="TrangChuController?page=${Integer.parseInt(currentP)-1}">Prev</a>
			</div>
			<c:forEach begin="1" end="${endP }" var="i">
				<div class="page">
					<a href="AdminQuanLySanPhamController?page=${i}">${i}</a>
				</div>
			</c:forEach>
			<div class="page">
				<a
					href="TrangChuController?page=${Integer.parseInt(currentP)+1}">Next</a>
			</div>
		</div>
	</div>
	<c:if test="${ebox == '1' }">
		<div class="overlay">
			<div class="er-box">
				<h4>Không thể xóa sản phẩm này này</h4>
				<btn class="btn btn-success"> <a
					href="AdminQuanLySanPhamController?noterr=1">OK</a> </btn>
			</div>
		</div>
	</c:if>
</body>
</html>