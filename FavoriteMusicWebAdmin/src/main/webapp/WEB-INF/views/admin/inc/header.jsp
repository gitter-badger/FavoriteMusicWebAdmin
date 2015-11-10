<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<body class="skin-red sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="<%=request.getContextPath()%>/main.do" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">MP</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg">Favorite Music</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<img
								src="<%=request.getContextPath()%>/resources/appjs/dist/img/user2-160x160.jpg"
								class="user-image" alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${username}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img
									src="<%=request.getContextPath()%>/resources/appjs/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image" />
									<p>
										성명 : ${username}<small>${username}</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-center">
										<input type="button" class="btn btn-default btn-flat"
											value="로그아웃"
											onclick="location.href='j_spring_security_logout'" />
									</div>
								</li>
							</ul>
						</li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>

				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img
							src="<%=request.getContextPath()%>/resources/appjs/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image" />
					</div>
					<div class="pull-left info">
						<p>M!Plan 대표</p>
					</div>
				</div>
				<!-- Sidebar Menu -->
				<aside class="main-sidebar">
					<!-- sidebar: style can be found in sidebar.less -->
					<section class="sidebar">
						<!-- Sidebar user panel (optional) -->
						<div class="user-panel">
							<div class="pull-left image">
								<img
									src="<%=request.getContextPath()%>/resources/appjs/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image" />
							</div>
							<div class="pull-left info">
								<p>${username}</p>
								<a href="#">일반직원관리자</a>
							</div>
						</div>