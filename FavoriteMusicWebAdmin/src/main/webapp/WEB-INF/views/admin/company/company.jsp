<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Music Admin</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- CSS -->
<!-- bootstrap.min -->
<link
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- bootstrap-select.min -->
<link
	href="<%=request.getContextPath()%>/resources/bootstrap-select/dist/css/bootstrap-select.min.css"
	rel="stylesheet">
<!-- bootstrapValidator.min -->
<link
	href="<%=request.getContextPath()%>/resources/bootstrapvalidator/dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<!-- Font Awesome Icons -->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="<%=request.getContextPath()%>/resources/ionicons/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link
	href="<%=request.getContextPath()%>/resources/homepage/css/adminpage.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/homepage/css/skins/skin-red.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- ckeditor -->
<script
	src="<%=request.getContextPath()%>/resources/editor/ckeditor/ckeditor.js"></script>

</head>


<body class="skin-red sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a
			href="<%=request.getContextPath()%>/main.do" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini">MP</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg">Favorite Music</span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <a href="#"
			class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span
			class="sr-only">Toggle navigation</span>
		</a> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
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
									value="로그아웃" onclick="location.href='j_spring_security_logout'" />
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>

		</div>
		</nav> </header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel (optional) -->
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
		<!-- Sidebar Menu --> <aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel (optional) -->
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
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">메뉴</li>
			<!-- Optionally, you can add icons to the links -->
			<li><a
				href="<%=request.getContextPath()%>/main.do"><i
					class='fa fa-link'></i> <span>메인(Main)</span></a></li>
			<li class="treeview"><a href="#"><i class='fa fa-users'></i>
					<span>회원관리(Member)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="#">관리자 담당 관리</a></li>
					<li><a href="#">고객사 관리자 관리</a></li>
					<li><a href="#">일반회원 관리</a></li>
					<li><a href="#">블랙리스트 관리</a></li>
					<li><a href="#">일괄회원등록</a></li>
				</ul></li>
			<li class="treeview active"><a href="#"><i class='fa fa-building'></i>
					<span>회사(Company)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/company">제작사관리</a></li>
					<li><a href="<%=request.getContextPath()%>/lable">레이블관리</a></li>
					<li><a href="<%=request.getContextPath()%>/b2b">B2B관리</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class='fa fa-music'></i>
					<span>콘텐츠등록(Contents)</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/artist">아티스트관리</a></li>
					<li><a href="<%=request.getContextPath()%>/album">앨범관리</a></li>
					<li><a href="<%=request.getContextPath()%>/music">음원관리</a></li>
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
					<li><a href="#">M!Radio관리</a></li>
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
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside> <!-- /.sidebar --></aside>
		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				Favorite Music <small>회사관리</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="<%=request.getContextPath()%>/main.do"><i
						class="fa fa-dashboard"></i> Home</a></li>

				<li class="active">회사관리</li>

			</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			
			
			
			
			
			
			
			
			<div class="infomation">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<!-- Default panel contents -->
								<div class="panel-heading">회사 관리</div>
								<div class="panel-body">
									<div class="form-inline">
										<div class="row">
											<div class="col-md-10">
												<select id="searchColumn" class="selectpicker">
													<option value="mp_corpname">회사명</option>
												</select> <input type="text" id="searchText" class="form-control">
												<button class="btn btn-default" id="searchBtn">검색</button>
											</div>
											<div class="col-md-2" style="text-align: right">
												<button class="btn btn-primary" data-toggle="modal"
													data-target="#yboardEditModal">등록</button>
												<button class="btn btn-danger" id="btnYboardDelete">삭제</button>
											</div>
										</div>
									</div>
								</div>
								<!-- Table -->
								<table class="table table-striped" id="dataTable">
									<thead>
										<tr>
											<th><input type="checkbox" id="allCheck" /></th>
											<th>번호</th>
											<th>회사명</th>
											<th>사업번호</th>
											<th>담당자</th>
											<th>전화번호</th>
											<th>사용여부</th>
											<th>등록일</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 페이징처리 부분  -->
						<div class="col-md-8">
							<ul class="pagination" id="pagination">
							</ul>
						</div>
					</div>
				</div>
				<!-- Modal : Yboard Edit -->
				<form class="form-horizontal" id="mplanform" name="mplanform"
					method="POST" enctype="multipart/form-data">
					<div class="modal fade" id="yboardEditModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">

							<div class="modal-content">


								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">회사 관리/수정</h4>
								</div>

								<div class="modal-body">

									<input type="hidden" id="mpssnumEncrypt" name="mpssnumEncrypt">


									<div class="form-group">
										<label for="corpname" class="col-sm-2 control-label">회사명
										</label>
										<div class="col-sm-10">
											<input type="text" id="corpname" name="corpname"
												class="form-control" placeholder="회사명 입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="corpphone" class="col-sm-2 control-label">대표전화번호
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="corpphone"
												name="corpphone" placeholder="전화번호  입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="corpaddress" class="col-sm-2 control-label">주소
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="corpaddress"
												name="corpaddress" placeholder="주소  입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="corpbn" class="col-sm-2 control-label">사업자등록번호
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="corpbn"
												name="corpbn" placeholder="사업자등록번호  입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="corpcontents" class="col-sm-2 control-label">내용
										</label>
										<div class="col-sm-10">
											<textarea style="height: 200px; width: 100%;"
												id="corpcontents" name="corpcontents">
											</textarea>
											<script>
												CKEDITOR
														.replace('corpcontents');
											</script>
										</div>
									</div>
									<div class="form-group">
										<label for="bizperson" class="col-sm-2 control-label">담당자
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="bizperson"
												name="bizperson" placeholder="담당자  입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="bizphone" class="col-sm-2 control-label">담당자
											등록번호 </label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="bizphone"
												name="bizphone" placeholder="담당자 등록번호 입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="bizcontents" class="col-sm-2 control-label">사업관련
											내용 </label>
										<div class="col-sm-10">
											<textarea style="height: 200px; width: 100%;"
												id="bizcontents" name="bizcontents">
											</textarea>
											<script>
												CKEDITOR.replace('bizcontents');
											</script>
										</div>
									</div>
									<div class="form-group">
										<label for="RadioGroup1" class="col-sm-2 control-label">사용여부
											: </label>
										<div class="col-sm-10">
											<label class="radio-inline"> <input type="radio"
												id="RadioGroup1" name="RadioGroup1" value="Y">사용
											</label> <label class="radio-inline"> <input type="radio"
												id="RadioGroup1" name="RadioGroup1" value="N">사용안함
											</label>
										</div>
									</div>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">닫기</button>
									<button type="submit" class="btn btn-primary"
										id="btnYboardSave">저장</button>
									<button type="button" class="btn btn-info" id="resetBtn">리셋</button>
								</div>

							</div>

						</div>

					</div>
				</form>
			</div>
			</section>
		</div>
		<!-- /.content-wrapper --> <!-- Main Footer --> <footer
			class="main-footer"> <!-- To the right -->
		<div class="pull-right hidden-xs">Favorite Music 2015</div>
		<!-- Default to the left --> <strong>&copy; Copyright <a
			href="#">M!Plan</a></strong> All rights reserved. <strong>1997~2015 </strong>
		<br />
		<strong> &copy; Copyright <a href="#">VM! Media Contents
				Labs</a></strong> All rights reserved. <strong>2009~2015 </strong> </footer> <!-- Control Sidebar -->

		<!-- /.control-sidebar --> <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- REQUIRED JS SCRIPTS -->
	<!-- JS -->
	<!-- jquery.min -->
	<script
		src="<%=request.getContextPath()%>/resources/jquery/jquery-2.1.4.min.js"></script>
	<!-- jquery.form.min -->
	<script
		src="<%=request.getContextPath()%>/resources/jqueryform/jquery.form.js"></script>
	<!-- jQuery.MultiFile.min -->
	<script
		src="<%=request.getContextPath()%>/resources/jquerymultifile/jQuery.MultiFile.min.js"></script>
	<!-- bootstrap.min -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- bootstrap-select.min -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
	<!-- bootstrap-paginator.min -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
	<!-- bootstrapValidator.min -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrapvalidator/dist/js/bootstrapValidator.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/appjs/dist/js/app.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/resources/homepage/js/company/corpview.js"></script>
</body>
</html>
