<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title> logfail</title>

</head>
<body>
<%
out.println("<script>alert('아이디 및 비밀번호가 틀립니다.');</script>"); 
out.println("<script>history.back(-1);</script>"); 
%>
</body>
</html>
