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
	margin-bottom: 30px;
}

.content {
	display: flex;
	flex-direction: column;
	margin-left: 10px;
}

.mh-container {
	width: 700px;
	display: flex;
	/* border: 2px solid #fff; */
	padding: 20px;
	background-color: #1b1e1f;
	margin-bottom: 10px;
}

.buy-btn {
	width: 150px;
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

.img {
	width: 400px;
	height: 250px;
}

.info {
	margin-left: 20px;
}

.gia {
	color: #940000;
}

.sl {
	margin-bottom: 10px;
}

.muab {
	width: 100px;
}

.box {
	background-color: #1b1e1f;
	width: 100%;
	/* margin: 0 auto; */
	padding-top: 20px;
	padding-bottom: 20px;
	border-radius: 10px;
	margin-left: 15px;
	display: flex;
	justify-content: space-around;
}

.random-tit {
	text-align: center;
	font-weight: 700;
	font-weight: 700;
    padding-bottom: 5px;
    border-bottom: 2px solid #00806e;
}

.r-img {
	width: 100%;
	height: 150px;
	border-radius: 5px;
	overflow: hidden;
}

.r-img-r {
	width: 100%;
	height:100%;
}

.random-list{
	/* border: 2px solid #fff; */
    border-radius: 10px;
}

.ds-random {
	height: 700px;
	overflow: auto;
	padding: 10px;
}

.random-item{
	margin-bottom: 20px;
    border: 1px solid #fff;
    border-radius: 8px;
    padding: 7px;
    display: flex;
    flex-direction: column;
}

.random-item:hover .r-img-r{
	transform: scale(1.1);
	transition: all 0.2s linear 0.1s;
}

.des {
	display: flex;
    justify-content: space-between;
    margin-top: 10px;
}

.mh-tit {
	margin-right: 10px;
    width: 190px;
	white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-bottom: 5px;
    
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
			<table>
				<c:forEach var="l" items="${dsloai}">
					<tr class="list-group">
						<td class="list-group-item"><a
							href="TrangChuController?ml=${l.getMaloai()}">
								${l.getTenloai()} </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="box">
			<div class='content'>
				<div class="mh-container">
					<c:if test="${ctmh!=null}">
						<img class='img' src="${ctmh.getAnh() }" />
						<div class="info">
							<h3 class='tenmh'>${ctmh.getTenmohinh()}</h2>
								<c:if test="${ctmh.getMaloai() == 'hg'}">
									<p>Loại: Mô hình HG(1/144)</p>
								</c:if>
								<c:if test="${ctmh.getMaloai() == 'rg'}">
									<p>Loại: Mô hình RG(1/144)</p>
								</c:if>
								<c:if test="${ctmh.getMaloai() == 'mg'}">
									<p>Loại: Mô hình MG(1/100)</p>
								</c:if>
								<c:if test="${ctmh.getMaloai() == 'pg'}">
									<p>Loại: Mô hình MG(1/60)</p>
								</c:if>
								<c:if test="${ctmh.getMaloai() == 'fig'}">
									<p>Loại: Mô hình Figure</p>
								</c:if>
								<c:if test="${ctmh.getMaloai() == 'tool'}">
									<p>Loại: Dụng cụ hỗ trợ</p>
								</c:if>
								<p>Nhà sản xuất: ${ctmh.getNhasanxuat()}</p>
								<h4 class='gia'>${ctmh.getGia()}VND</h4>
								<div class="buy-btn">
									<a class="buy-link"
										href="HTGioHangController?mmh=${ctmh.getMamohinh()}&tmh=${ctmh.getTenmohinh()}&gia=${ctmh.getGia()}&anh=${ctmh.getAnh()}">
										Mua sản phẩm </a>
								</div>
								<p>Bạn có thể xem video review tại đây</p>
						</div>
					</c:if>
				</div>
				<c:choose>
					<c:when test="${ctmh.getIdreview()!= null}">
						<iframe width="700" height="415"
							src="https://www.youtube.com/embed/${ctmh.getIdreview()}"
							title="YouTube video player" frameborder="0"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe>
					</c:when>
					<c:otherwise>
						<div
							style="width: 700px; height: 415px; background-color: #1b1e1f;">
							<img src="Gshop/er.png" />
						</div>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="random-list">
				<h4 class="random-tit">Có thể bạn sẽ thích</h4>
				<div class="ds-random">
					<c:if test="${dsrandom != null }">
						<c:forEach var="s" items="${dsrandom }">
							<div class="random-item">
								<div class="r-img">
									<img class="r-img-r" src="${s.getAnh() }"/>
								</div>
								<div class="des">
									<p class="mh-tit">${s.getTenmohinh()}</p>
									<button class="btn btn-success">
										<a style="color: #fff;" href="ChTietMoHinhController?mmh=${s.getMamohinh()}">Chi tiết</a>
									</button>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>