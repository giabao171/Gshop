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
				<li class="active"><a href="AdminTrangChuController">Trang ch???</a></li>
				<li><a href="AdminQuanLySanPhamController">Qu???n l?? s???n ph???m</a></li>
				<li><a href="AdminQuanLyLoaiController">Qu???n l?? lo???i s???n ph???m</a></li>
				<li><a href="AdminXacNhanDonHangController">X??c nh???n ????n h??ng</a></li>
				<li><a href="AdminLichSuGiaoDichController">L???ch s??? giao d???ch ????n h??ng</a></li>
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
									<li><a href="AdminKTDangNhapController?lou=tr">????ng xu???t</a></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</div>
	</nav>
	
</body>
</html>