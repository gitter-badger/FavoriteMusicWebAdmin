<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Music Admin</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.css">
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/dist/css/adminpage.css">

<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/dist/css/skins/skin-red.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
  BODY TAG OPTIONS:
  =================
  Apply one or more of the following classes to get the
  desired effect
  |---------------------------------------------------------|
  | SKINS         | skin-blue                               |
  |               | skin-black                              |
  |               | skin-purple                             |
  |               | skin-yellow                             |
  |               | skin-red                                |
  |               | skin-green                              |
  |---------------------------------------------------------|
  |LAYOUT OPTIONS | fixed                                   |
  |               | layout-boxed                            |
  |               | layout-top-nav                          |
  |               | sidebar-collapse                        |
  |               | sidebar-mini                            |
  |---------------------------------------------------------|
  -->
<body class="skin-red sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a href="<%=request.getContextPath()%>/main"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini">MP</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg">Favorite Music</span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <!-- Navbar Right Menu -->
			  <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">메뉴숨기기</span> </a> 
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> 
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg"
						class="user-image" alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">M!Plan 대표</span>
				</a>

					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img
							src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image" />
							<p>
								성명 : 김정훈 (대표) <small>입사일 : 1997년 07월 23일</small>
							</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-center">
								<a href="#" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
			</ul>
		</div>
		</nav> </header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg"
					class="img-circle" alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>M!Plan 대표</p>
				<a href="#">일반직원관리자</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
	<ul class="sidebar-menu">
			<li class="header">메뉴</li>
			<!-- Optionally, you can add icons to the links -->
			<li><a href="#"><i class='fa fa-link'></i> <span>메인(Main)</span></a></li>
			<li class="treeview"><a href="#"><i class='fa fa-users'></i>
					<span>회원관리(Member)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">관리자 담당 관리</a></li>
					<li><a href="#">고객사 관리자 관리</a></li>
					<li><a href="#">일반회원 관리</a></li>
					<li><a href="#">블랙리스트 관리</a></li>
					<li><a href="#">일괄회원등록</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-building'></i>
					<span>회사(Company)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">회사등록</a></li>
					<li><a href="<%=request.getContextPath()%>/lable">레이블/제작사관리</a></li>
					<li><a href="#">B2B 관련 관리</a></li>
				</ul></li>
			<li class="treeview active"><a href="#"><i class='fa fa-music'></i>
					<span>콘텐츠등록(Contents)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/artist">아티스트관리</a></li>
					<li><a href="<%=request.getContextPath()%>/album">앨범관리</a></li>
					<li><a href="<%=request.getContextPath()%>/music">음원관리</a></li>
					<li><a href="<%=request.getContextPath()%>/music">음원단체등록관리</a></li>
					<li><a href="<%=request.getContextPath()%>/musicvideo">뮤직비디오관리</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-money'></i>
					<span>정산관리(Call)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">회사별정산 관리</a></li>
					<li><a href="#">아티스트별 정산관리</a></li>
					<li><a href="#">음원단가 등록</a></li>
					<li><a href="#">저작관련 정산</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-bar-chart'></i>
					<span>차트관리(Chart)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">전체차트관리</a></li>
					<li><a href="#">가요차트관리</a></li>
					<li><a href="#">팝차트관리</a></li>
					<li><a href="#">O.S.T차트관리</a></li>
					<li><a href="#">J-Pop차트관리</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i
					class='fa  fa-headphones'></i> <span>라디오관리(Radio)</span> <i
					class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">프로그램 관리</a></li>
					<li><a href="#">라디오콘텐츠 관리</a></li>
					<li><a href="#">큐시트 관리</a></li>
					<li><a href="#">게시판 관리</a></li>
					<li><a href="#">M!Radior관리</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa  fa-archive'></i>
					<span>관리자(Admin)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">공지사항 관리</a></li>
					<li><a href="#">게시판 관리</a></li>
					<li><a href="#">댓글 관리</a></li>
					<li><a href="#">FAQ 관리</a></li>
					<li><a href="#">추천음악 관리</a></li>
					<li><a href="#">VOC 관리</a></li>
					<li><a href="#">이벤트 관리</a></li>
					<li><a href="#">SNS 관리</a></li>
					<li><a href="#">API 관리</a></li>
					<li><a href="#">광고 관리</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-home'></i>
					<span>홈페이지관리(Homepage)</span> <i
					class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">메뉴관리</a></li>
					<li><a href="#">이미지관리</a></li>
					<li><a href="#">홈페이지텍스트관리</a></li>
					<li><a href="#">기타</a></li>
				</ul></li>
			<li><a href="#"><i class='fa fa-link'></i> <span>Favorite
						Music</span></a></li>

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Favorite Music <small>음원관리</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="<%=request.getContextPath()%>/main"><i class="fa fa-dashboard"></i> Home</a></li>
				
        <li class="active">음원관리</li>
       
			</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			<div class="infomation">
				<%@ include file="/WEB-INF/views/admin/contents/inc/musicapi.jsp"%>
			</div>
			</section>
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer"> <!-- To the right -->
		<div class="pull-right hidden-xs">Favorite Music 2015</div>
		<!-- Default to the left --> <strong>&copy; Copyright <a
			href="#">M!Plan</a></strong> All rights reserved. <strong>1997~2015 </strong>
		<br />
		<strong> &copy; Copyright <a href="#">VM! Media Contents
				Labs</a></strong> All rights reserved. <strong>2009~2015 </strong> </footer>

		<!-- Control Sidebar -->

		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/app.min.js"
		type="text/javascript"></script>

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
          Both of these plugins are recommended to enhance the
          user experience. Slimscroll is required when using the
          fixed layout. -->
</body>
</html>
