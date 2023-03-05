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

body {
	/* width: 100%; */
	/* height: 100vh; */
	/* display: flex;
	justify-content: center; */
	background-image: url(https://wallpapercave.com/wp/wp5294549.jpg);
	background-size: cover;
}
.title {
	font-weight: 700;
	font-size: 19px;
	margin-right: 10px;
	color: #33b793;
}

.img {
	width: 200px;
	height: 100px;
	border: 1px solid #000;
	border-radius: 8px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><h3 class="title">Gundam Shop</h3></li>
				<li><a href="TrangChuController">Trang chủ</a></li>
				<li class="active"><a href="GioHangController">Giỏ hàng</a></li>
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
		<form method="post" action="XoaSuaGHController">
			<table class="table table-bordered table-striped" style=" background-color: #1b1e1f;">
				<thead>
					<tr style="color: #fff; background-color: #33b793">
						<th></th>
						<th></th>
						<th class="text-center">Tên mô hình</th>
						<th class="text-center">Giá</th>
						<th class="text-center">Số lượng</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${gio!= null}">
						<c:forEach var="s" items="${gioh}">
							<tr>
								<td class="text-center"><input type="checkbox" class="form-check-input"
									name="check" value="${s.getMamohinh()}"></td>
								<td class="text-center"><img class='img' src="${s.getAnh()}" /></td>
								<td class="text-center">${s.getTenmohinh()}</td>
								<td class="text-center">${s.getGia()} VND</td>
								<td class="text-center"><input type="number" name="t${s.getMamohinh()}"
									value="${s.getSoluong()}" min="0"
									style="width: 100px; margin-right: 10px">

									<button type="submit" name="butsua" value="${s.getMamohinh()}"
										class="btn btn-info">Thay đổi</button></td>
								<td class="text-center">${s.getThanhtien()} VND</td>
								<td class="text-center">
									<button type="submit" class="btn btn-warning" name="butxoa"
										value="${s.getMamohinh()}">Xóa</button>

								</td>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td>Bạn chưa mua sản phẩm nào</td>
					</c:otherwise>
				</c:choose>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<c:choose>
						<c:when test="${gio!=null}">
							<td class="text-center">Tổng tiền: ${gio.TongTien()}</td>
						</c:when>
						<c:otherwise>
							<td class="text-center">Tổng tiền: 0</td>
						</c:otherwise>
					</c:choose>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td class="text-center">
						<div style="display: flex;">
							<button type="submit" class="btn btn-danger" name="xoaall">Xóa
								đã chọn</button>
							<button type="submit" class="btn btn-primary" name="xnmua"
								style="margin-left: 20px;">Xác nhận mua</button>
						</div>
					</td>
					<td></td>
				</tr>
			</table>




		</form>
	</div>
</body>
</html>