<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Lumino - Dashboard</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/datepicker3.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
		rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#">Admin</a>
				<h1 style="position: absolute;
				right: 0;
				color: red;
				transform: translate(-27px,0);
				padding: 0;
				margin: 8px;">Chào Mừng bạn đến trang quản lý của chúng tôi</h1>
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar" style="width: fit-content;">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%=session.getAttribute("tenDangNhap") %></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
					<em class="fa fa-navicon">&nbsp;</em> Quản lý nhân viên <span data-toggle="collapse"
						href="#sub-item-2" class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="DanhSachNhanVienServlet">Danh Sách Nhân Viên</a></li>
					<li><a class="" href="ThemNhanVien">Thêm nhân viên</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-3">
					<em class="fa fa-navicon">&nbsp;</em> Quản lý danh mục <span data-toggle="collapse"
						href="#sub-item-2" class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li><a class="" href="DanhSachLoaiController">Danh Sách Loại</a></li>
					<li><a class="" href="themloai">Thêm Loại</a></li>
					<li><a class="" href="DanhSachTheLoai">Danh sách thể loại</a></li>
					<li><a class="" href="ThemTheLoai">Thêm thể loại</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-4">
					<em class="fa fa-navicon">&nbsp;</em> Quản lý sách <span data-toggle="collapse" href="#sub-item-4"
						class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-4">
					<li><a class="" href="DanhSachSachservlet">Danh sách sách</a></li>
					<li><a class="" href="ThemSachServlet">Thêm Sách</a></li>
				</ul>
			</li>

			<li class="parent "><a data-toggle="collapse" href="#sub-item-5">
					<em class="fa fa-navicon">&nbsp;</em> Quản lý bạn đọc <span data-toggle="collapse"
						href="#sub-item-5" class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-5">
					<li><a class="" href="DanhSachBanDoc">Danh sách bạn đọc</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-6">
					<em class="fa fa-navicon">&nbsp;</em> Quản lý phiếu mượn <span data-toggle="collapse"
						href="#sub-item-6" class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-6">
					<li><a class="" href="DanhSachPhieuMuon">Danh sách phiếu mượn</a></li>
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-7">
					<em class="fa fa-navicon">&nbsp;</em> Thống kê<span data-toggle="collapse" href="#sub-item-7"
						class="icon pull-right"></span>
				</a>
				<ul class="children collapse" id="sub-item-7">
					<li><a class="" href="ThongKeServlet">Theo Tháng </a></li>
					<li><a class="" href="ThongKeServlet">Theo năm </a></li>
				</ul>
			</li>
			<li class="parent"> <a href="DangXuatServlet"><i class="fa fa-power-off">Đăng Xuất </i></a></li>
		</ul>
	</div>