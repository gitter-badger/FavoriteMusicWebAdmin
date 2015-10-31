<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
<meta name="viewport" content="width=device-width">
<div id="header">
	<%@ include file="../inc/header.jsp"%>
</div>
<div class="container-fluid">
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
</div>
<div id="footer">
	<%@ include file="../inc/footer.jsp"%>
</div>
</body>
</html>
