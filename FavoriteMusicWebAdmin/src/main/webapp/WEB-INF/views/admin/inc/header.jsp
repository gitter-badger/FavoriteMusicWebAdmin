<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Favorite Music Admin :: M!Plan Labs</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport" content="width=device-width">

<link
	href="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/bootstrapValidator/dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
	
	
	
	
<script src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery/jquery.form.min.js"></script>
<!-- jQuery MultiFile Plugin import -->
<script src="<%=request.getContextPath()%>/resources/js/jquery/jQuery.MultiFile.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-select/bootstrap-select.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bower_components/bootstrapValidator/dist/js/bootstrapValidator.min.js"></script>



	<script src="<%=request.getContextPath()%>/resources/admin/_Shared/js/lib/jquery-1.7.2.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/js/plugins.js"></script>
	<script src="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/js/script.js"></script>
	<script src="http://code.jquery.com/ui/1.8.22/jquery-ui.min.js"></script>







<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/admin/css/jqueryui/jquery-ui-1.8.22.custom.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-size: 12px;
}
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/css/bootstrap-responsive.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/admin/_Shared/bootstrap/css/style.css">

<!--[if lt IE 9]>
  <script src="js/libs/html5-3.4-respond-1.1.0.min.js"></script>
  <![endif]-->
<!-- login -->
</head>
<body>
	<!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Favorite Music! 관리자 페이지</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="login">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">회원관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="blacklist">블랙리스트</a></li>
								<li><a href="memberlist">회원관리</a></li>
								<li><a href="group">등급수정</a></li>
								<li><a href="memberdel">회원탈퇴</a></li>
								<li><a href="membereup">엑셀회원등록</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">라디오관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="proin">프로그램 등록</a></li>
								<li><a href="propage">프로그램 페이지</a></li>
								<li><a href="qsheet">큐시트</a></li>
								<li><a href="data">자료관리</a></li>
								<li><a href="board">게시판</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">음원관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="musicup">회사 관리(등록,수정,삭제)</a></li>
								<li><a href="musicda">레이블사 관리(등록,수정,삭제)</a></li>
								<li><a href="musicda">아티스트 관리(등록,수정,삭제)</a></li>
								<li><a href="musical">앨범 관리(등록,수정,삭제)</a></li>
								<li><a href="musicin">음원 관리(등록,수정,삭제)</a></li>
								<li><a href="musicmoney">정산관리</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">관리자 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="adnotice">공지사항</a></li>
								<li><a href="adqna">질문 답변</a></li>
								<li><a href="adsns">SNS 등록</a></li>
								<li><a href="adapi">API관리</a></li>
								<li><a href="admail">메일 보내기</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">차트관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="realchart">실시간검색</a></li>
								<li><a href="stchart">스트리밍 차트</a></li>
								<li><a href="downchart">다운로드 차트</a></li>
								<li><a href="allchart">총합 차트</a></li>
								<li><a href="kchart">가요 차트</a></li>
								<li><a href="pchart">팝차트</a></li>
								<li><a href="jchart">일본차트</a></li>
							</ul></li>

					</ul>
					<ul class="nav pull-right">
						<li><a href="j_spring_security_logout">${username}님
								반갑습니다.</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>




</body>
</html>
