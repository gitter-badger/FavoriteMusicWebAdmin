<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="resources/mplan/css/style.css">
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="<%=request.getContextPath()%>/resources/mplan/js/index.js"></script>
<title>Favorite Music Admin Page</title>
</head>
<!-- login -->
<script type="text/javascript">
	function login() {
		var user_id = document.login3.j_username.value;
		var passwd = document.login3.j_password.value;
		if (user_id == "" || user_id == null) {
			alert("���̵� �ٽ� �Է��� �ּ���");
			login3.getElementById("userid").focus();
		} else if (passwd == "" || passwd == null) {
			alert("��й�ȣ �ٽ� �Է��� �ּ���");
			login3.getElementById("passwd").focus();
		} else {
			alert("�Ϸ�");
			login3.submit();
		}
	}
</script>
<!--  video/195550.mp4 -->
<!-- Video -->
<% Random r = new Random();
int num = r.nextInt(13); %>
<video id="movie" poster="/movie/music.png" preload="auto" autoplay loop autobuffer muted style="width: 1270px; height: 714px; display: inline; margin-left: 0px;" >
	<source src="/movie/<%=num%>.mp4" type="video/mp4">
</video>

<body>
	<div id="polina">
		<h1>M!Plan Media Admin Page</h1>
		<form name="login3" action="/test/main" method="get">
			<div class="id">
				<input type="text" name="j_username" id="userid"
					placeholder="M!Plan ���� (���̵�)">
			</div>
			<div class="pass">
				<input type="password" name="j_password" id="passwd" placeholder="��й�ȣ">
			</div>
			<div class="checkbox">
				<input type="checkbox" name="checkbox" id="checkbox"> <label
					for="checkbox">�α��� ���� ���� </label>
			</div>
			<div class="button">
				<div class="button">
					<input type="button" value="�α���" class="button"
						onclick="login()" />
				</div>
			</div>
			<div class="info">
				<a class="idsearch" href="#" target="_blank">M!Plan ����ã��</a> <a
					class="passsearch" href="#" target="_blank">M!Plan ��й�ȣã��</a>
			</div>
			<p>�� M!Plan Lab! 1997~2015</p>
			<p>�� VM! Media Contents Labs 2009~2015</p>
		</form>
	</div>
</body>
</html>
