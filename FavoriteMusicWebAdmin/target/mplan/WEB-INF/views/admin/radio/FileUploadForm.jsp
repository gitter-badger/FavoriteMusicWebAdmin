<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>File Upload with Spring 3 MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>File Upload</h1>
	<br />
	<form:form commandName="excel" enctype="multipart/form-data"
		method="POST">
		<table>
			<tr>
				<td colspan="2" style="color: red;"><form:errors path="*"
						cssStyle="color : red;" /> ${errors}</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="file" path="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Upload File" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>