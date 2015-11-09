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
	href="<%=request.getContextPath()%>/resources/css/bootstrap/css/bootstrap-select.min.css"
	rel="stylesheet">
<!-- bootstrapValidator.min -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap/css/bootstrapValidator.min.css"
	rel="stylesheet">
<!-- font-awesome.min -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- ionicons.min -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- adminpage -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/adminpage.css">
<!-- skin-red.min -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/skins/skin-red.min.css">
<link
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"
	rel="Stylesheet"></link>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- JS -->

<!-- jquery.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/jquery/jquery.min.js"></script>
<!-- jquery.form.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/jquery/jquery.form.min.js"></script>
<!-- jQuery.MultiFile.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/jquery/jQuery.MultiFile.min.js"></script>
<!-- bootstrap.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.min.js"></script>
<!-- bootstrap-select.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-select.min.js"></script>
<!-- bootstrap-paginator.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-paginator.min.js"></script>
<!-- bootstrapValidator.min -->
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrapValidator.min.js"></script>
<!-- ckeditor -->

<script
	src="<%=request.getContextPath()%>/resources/editor/ckeditor/ckeditor.js"></script>
	
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>

	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<style>
.ui-autocomplete {
	position: absolute;
	cursor: default;
	height: 200px;
	overflow-y: scroll;
	overflow-x: hidden;
}
</STYLE>
<script type="text/javascript">
$(function() {
			$("#artist").autocomplete({
								source : function(request, response) {
									$.ajax({
										url : "/test/artistname",
										type : "post",
										dataType : "json",
										data : {
											term : request.term,
										},
										//contentType : "application/x-www-form-urlencoded; charset=UTF-8",
										success : function(data) {
											response($.map(data, function(item)
											{
												//alert(item.mp_artist);
												 console.log(data);
												 console.log(item.mp_artist);
												 console.log(item.mp_anum);
												return{
													label: item.mp_artist,
													value : item.mp_anum
													
												}
											}));
										},
										error : function(data) {
												alert("에러가 발생하였습니다.")
										}
										
									});
								},
								focus: function(event, ui) {
									event.preventDefault();
									$("#artist").val(ui.item.label);
								},
								select: function(event, ui) {
									event.preventDefault();
									$("#artist").val(ui.item.label);
									$("#artistnum").val(ui.item.value);
								}
			});
});
</script>
</head>


<body class="skin-red sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a
			href="<%=request.getContextPath()%>/main" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini">MP</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg">Favorite Music</span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <!-- Navbar Right Menu -->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">메뉴숨기기</span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
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
			<li class="treeview active"><a href="#"><i
					class='fa fa-music'></i> <span>콘텐츠등록(Contents)</span> <i
					class="fa fa-angle-left pull-right"></i></a>
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
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Favorite Music <small>앨범관리</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="<%=request.getContextPath()%>/main"><i
						class="fa fa-dashboard"></i> Home</a></li>

				<li class="active">앨범관리</li>

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
								<div class="panel-heading">아티스트 관리</div>
								<div class="panel-body">
									<div class="form-inline">
										<div class="row">
											<div class="col-md-10">
												<select id="searchColumn" class="selectpicker">
													<option value="mp_artist">아티스트</option>
													<option value="mp_label">회사명</option>
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
											<th>아티스트</th>
											<th>앨범명</th>
											<th>레이블회사</th>
											<th>발매일</th>
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
									<h4 class="modal-title" id="myModalLabel">앨범 관리/수정</h4>
								</div>

								<div class="modal-body">

									<input type="hidden" id="mpssnumEncrypt" name="mpssnumEncrypt">
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">앨범타이틀</label>
										<div class="col-sm-10">
											<select id="albumtitle" class="selectpicker" name="albumtitle">
												<option value="mini">미니</option>
												<option value="single">싱글</option>
												<option value="album">앨범</option>

											</select>
										</div>
									</div>

									<div class="form-group">
										<label for="artist" class="col-sm-2 control-label">아티스트
										</label>
										<div class="col-sm-10">
											<input type="text" id="artist" name="artist"
												class="form-control" placeholder="아티스트 입력하세요" > 
												<input
												type="hidden" id="artistnum" name="artistnum"
												class="form-control" >
										</div>
									</div>
									<div class="form-group">
										<label for="album" class="col-sm-2 control-label">앨범명
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="album"
												name="album" placeholder="앨범명  입력하세요">
										</div>
									</div>
									<div class="form-group">
										<label for="content" class="col-sm-2 control-label">내용
										</label>
										<div class="col-sm-10">
											<textarea style="height: 200px; width: 100%;" id="content"
												name="content">
											</textarea>
											<script>
												CKEDITOR.replace('content');
											</script>
										</div>
									</div>
									<div class="form-group">
										<label for="year" class="col-sm-2 control-label">년도 </label>
										<div class="col-sm-10">
											<input type="date" class="form-control" id="year" name="year"
												placeholder="년도 ">
										</div>
									</div>
									<div class="form-group">
										<label for="corp" class="col-sm-2 control-label">유통사 </label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="corp" name="corp"
												placeholder="유통사  ">
										</div>
									</div>

									<div class="form-group">
										<label for="imgupload" class="col-sm-2 control-label">이미지
											: </label>
										<div class="col-sm-10">
											<input type="file" class="imgfile" name="imgupload"
												id="imgupload" />

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

	<script
		src="<%=request.getContextPath()%>/resources/music/albumview.js"></script>
</body>
</html>
