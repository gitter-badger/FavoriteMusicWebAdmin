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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/icheck/skins/all.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/homepage/css/admin.css">
<script
	src="<%=request.getContextPath()%>/resources/jquery/jquery-2.1.4.min.js"></script>
<title>Favorite Music Admin Page</title>
</head>
<!-- login -->
<script type="text/javascript">
	function login() {
		var user_id = document.login3.j_username.value;
		var passwd = document.login3.j_password.value;
		if (user_id == "" || user_id == null) {
			alert("아이디를 다시 입력해 주세요");
			login3.getElementById("userid").focus();
		} else if (passwd == "" || passwd == null) {
			alert("비밀번호 다시 입력해 주세요");
			login3.getElementById("passwd").focus();
		} else {
			alert("완료");
			login3.submit();
		}
	}
</script>
<!--  video/195550.mp4 -->
<!-- Video -->
<% Random r = new Random();
int num = r.nextInt(21); %>
<video id="movie" poster="/movie/music.png" preload="auto" autoplay loop autobuffer muted style="width: 1270px; height: 714px; display: inline; margin-left: 0px;" >
	<source src="/movie/<%=num%>.mp4" type="video/mp4">
</video>

<body>
	<div id ="box">
  <h1>Favorite Music Admin Page</h1>
  <form name="login3" action="j_spring_security_check" method="get">
    <input type="text" name="j_username" id="userid" placeholder="아이디 입력" />
    <input type="password" name="j_password" id="passwd" placeholder="비밀번호 입력" />
    <input type="submit" value="로그인" onclick="login()"  />
    
    <!--
			<div class="id">
				<input type="text" name="j_username" id="userid"
					placeholder="M!Plan 계정 (아이디)">
			</div>
			<div class="pass">
				<input type="password" name="j_password" id="passwd" placeholder="비밀번호">
			</div>
            -->
    
    <div class="pass">
      <label>
        <input type="checkbox" class="flat-red"/>
        로그인 상태 유지 </label>
    </div>
 
      <input type="button" value="계정찾기" onclick="login()"  />
      <input type="button" value="비밀번호찾기" onclick="login()"  />
 
    <div class="copy">
      <p>ⓒ M!Plan Lab! 1997~2015</p>
      <p>ⓒ VM! Media Contents Labs 2009~2015</p>
    </div>
  </form>
</div>
<script src="<%=request.getContextPath()%>/resources/icheck/icheck.min.js"></script> 
<script type="text/javascript">
      $(function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
          checkboxClass: 'icheckbox_minimal-blue',
          radioClass: 'iradio_minimal-blue'
        });
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
          checkboxClass: 'icheckbox_minimal-red',
          radioClass: 'iradio_minimal-red'
        });
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass: 'iradio_flat-green'
        });
      });
    </script>
</body>
</html>