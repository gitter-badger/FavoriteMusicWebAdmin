<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	href="bootstrap/css/bootstrap.css">
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link rel="stylesheet" type="text/css" href="dist/css/adminpage.css">

<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
<link rel="stylesheet" type="text/css"
	href="dist/css/skins/skin-blue.min.css">

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
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a href="#"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini">MP</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg">Favorite Music</span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="dist/img/user2-160x160.jpg" class="user-image"
						alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">M!Plan ��ǥ</span>
				</a>

					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image" />
							<p>
								���� : ������ (��ǥ) <small>�Ի��� : 1997�� 07�� 23��</small>
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
				<img src="dist/img/user2-160x160.jpg" class="img-circle"
					alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>M!Plan ��ǥ</p>
				<a href="#">�Ϲ�����������</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">�޴�</li>
			<!-- Optionally, you can add icons to the links -->
			<li class="treeview"><a href="#"><i class='fa fa-users'></i>
					<span>ȸ������(Member)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">������ ȸ�� ����</a></li>
					<li><a href="#">�Ϲ� ȸ�� ����</a></li>
					<li><a href="#">������Ʈ ȸ�� ����</a></li>
					<li><a href="#">ȸ�� Ư��ȸ��</a></li>
					<li><a href="#">ȸ�����/Ż��</a></li>
					<li><a href="#">ȸ���������</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-building'></i>
					<span>ȸ��(Company)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">ȸ�� ���</a></li>
					<li><a href="#">���ۻ� ���</a></li>
					<li><a href="#">ȸ�� ����</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-music'></i>
					<span>���������(Contents)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">���̺����</a></li>
					<li><a href="#">��Ƽ��Ʈ����</a></li>
					<li><a href="#">�ٹ�����</a></li>
					<li><a href="#">��������</a></li>
					<li><a href="#">������������</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-money'></i>
					<span>�������(Call)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">ȸ�������Ѱ���</a></li>
					<li><a href="#">��Ƽ��Ʈ���������</a></li>
					<li><a href="#">�ٹ�/�̱۰���</a></li>
					<li><a href="#">��Ʈ�����������</a></li>
					<li><a href="#">�ٿ�ε��������</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-bar-chart'></i>
					<span>��Ʈ����(Chart)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">��ü��Ʈ����</a></li>
					<li><a href="#">������Ʈ����</a></li>
					<li><a href="#">����Ʈ����</a></li>
					<li><a href="#">O.S.T��Ʈ����</a></li>
					<li><a href="#">J-Pop��Ʈ����</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i
					class='fa  fa-headphones'></i> <span>��������(Radio)</span> <i
					class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">���α׷� ����</a></li>
					<li><a href="#">���������� ����</a></li>
					<li><a href="#">ť��Ʈ����</a></li>
					<li><a href="#">�Խ��ǰ���</a></li>
					<li><a href="#">M!Radior����</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa  fa-archive'></i>
					<span>������(Admin)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">FAQ</a></li>
					<li><a href="#">VOC</a></li>
					<li><a href="#">�Խ��ǰ���</a></li>
					<li><a href="#">�̺�Ʈ����</a></li>
					<li><a href="#">SNS����</a></li>
					<li><a href="#">API����</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-home'></i>
					<span>Ȩ����������(Homepage)</span> <i
					class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">�޴�����</a></li>
					<li><a href="#">�̹�������</a></li>
					<li><a href="#">Ȩ�������ؽ�Ʈ����</a></li>
					<li><a href="#">��Ÿ</a></li>
				</ul></li>
			<li class="active"><a href="#"><i class='fa fa-link'></i> <span>Favorite
						Music</span></a></li>

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Favorite Music <small>DashBoard Version 0.1</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<!--
        <li class="active"></li>
        -->
			</ol>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="infomation">
				<div class="col-md-3 col-sm-6 col-xs-12">

					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i class="fa fa-music"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">����������</span> <span
								class="info-box-number">${musictotal }��</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-red"><i
							class="fa fa-play-circle"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">���� ä�μ�</span> <span
								class="info-box-number">${radiototal}ä��</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-green"><i
							class="fa fa-cloud-upload"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">���� ��ϵ� ������</span> <span
								class="info-box-number">${todaymusictotal }��</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-yellow"><i
							class="fa  fa-users"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">�� ������</span> <span
								class="info-box-number">${membertotal }��</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<!-- Main Footer -->
	<footer class="main-footer"> <!-- To the right -->
	<div class="pull-right hidden-xs">Favorite Music 2015</div>
	<!-- Default to the left --> <strong>&copy; Copyright <a
		href="#">M!Plan</a></strong> All rights reserved. <strong>1997~2015 </strong> <br />
	<strong> &copy; Copyright <a href="#">VM! Media Contents
			Labs</a></strong> All rights reserved. <strong>2009~2015 </strong> </footer>

	<!-- Control Sidebar -->

	<!-- /.control-sidebar -->
	<!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 2.1.4 -->
	<script src="plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/app.min.js" type="text/javascript"></script>

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
          Both of these plugins are recommended to enhance the
          user experience. Slimscroll is required when using the
          fixed layout. -->
</body>
</html>
