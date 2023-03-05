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
}

.mh-container {
	margin-left: 10px;
	width: 100%;
	display: grid;
	gap: 15px 60px;
	grid-template-columns: repeat(auto-fill, minmax(380px, 1fr));
}

.mohinh-item {
	background-color: #1b1e1f;
	display: flex;
	align-items: center;
	flex-direction: column;
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 0 0 10px 0;
	cursor: pointer;
	width: 360px;
	height: 310px;
}

.hov {
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	width: 100%;
	height: 200px;
	overflow: hidden;
}

.img {
	width: 100%;
	height: 100%;
}

.img:hover {
	transform: scale(1.1);
	transition: all 0.2s linear 0.1s;
}

.buy-btn {
	width: 50%;
	height: 45px;
	border-radius: 10px;
	background-color: #33b793;
	color: #fff !important;
}

.buy-link {
	color: #fff !important;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	text-decoration: none;
}

.num-page {
	margin-top: 40px;
	display: flex;
	width: 100%;
	justify-content: center;
	margin-bottom: 100px;
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

.logout {
	position: relative;
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
		<div class="loai-container">
			<table style="background-color: #1b1e1f;">
				<c:forEach var="l" items="${dsloai}">
					<tr class="list-group">
						<td class="list-group-item"><a
							href="TrangChuController?ml=${l.getMaloai()}">
								${l.getTenloai()} </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="mh-container">
			<c:if test="${dsmohinh!=null}">
				<c:forEach var="s" items="${dsmohinh}">
					<div class="mohinh-item">
						<div class='hov'>
							<c:choose>
								<c:when test="${s.getAnh() != null}">
									<img src=${s.getAnh() } class="img">
								</c:when>
								<c:otherwise>
									<img src="Gshop/er.png" class="img">
								</c:otherwise>
							</c:choose>
						</div>

						<h4>${s.getTenmohinh()}</h3>
							<p style="color: #237234;">${s.getGia()}VND</p>
							<div class="buy-btn">
								<a class="buy-link"
									href="ChTietMoHinhController?mmh=${s.getMamohinh()}"> Chi
									tiết </a>
							</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<div class="num-page">

		<div class="page">
			<a
				href="TrangChuController?page=${Integer.parseInt(currentP)-1}&ml=${mloai}&key=${keyTD}">Prev</a>
		</div>
		<c:forEach begin="1" end="${endP }" var="i">
			<div class="page">
				<a href="TrangChuController?page=${i}&ml=${mloai}&key=${keyTD}">${i}</a>
			</div>
		</c:forEach>
		<div class="page">
			<a
				href="TrangChuController?page=${Integer.parseInt(currentP)+1}&ml=${mloai}&key=${keyTD}">Next</a>
		</div>
	</div>
</body>
</html>