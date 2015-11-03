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
<div id="header">
	<%@ include
		file="inc/header.jsp"%>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div id="mainLeftBar" class="span4">
			<div id="speedReserve">
				<legend>Admin님 VOC 처리 현황</legend>
				<form>
					<div>
						<table border="0">
							<tr>
								<td><label>종류</label></td>
								<td><input type="radio" id="selAirplaneKinds"
									name="selAirplaneKinds"> 편도 <input type="radio"
									id="selAirplaneKinds" name="selAirplaneKinds"> 왕복</td>
							</tr>
							<tr>
								<td><label>출발/도착지</label></td>
								<td><select name="startAirport" id="startAirport"
									class="span5" style="float: left; margin-right: 10px;">
										<option value="">런던공항</option>
										<option value="">히드로공항</option>
										<option value="">인천공항</option>
										<option value="">삿포로공항</option>
										<option value="">뉴욕공항</option>
								</select> <select name="arriveAirport" id="arriveAirport" class="span5">
										<option value="">런던공항</option>
										<option value="">히드로공항</option>
										<option value="">인천공항</option>
										<option value="">삿포로공항</option>
										<option value="">뉴욕공항</option>
								</select></td>
							</tr>
							<tr>
								<td><label>출발일</label></td>
								<td>
									<div class="input-append">
										<input class="span9" id="startDate" name="startDate"
											type="text"> <span class="add-on"> <i
											class="icon-calendar"></i>
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td><label>도착일</label></td>
								<td>
									<div class="input-append">
										<input class="span9" id="arriveDate" name="arriveDate"
											type="text"> <span class="add-on"> <i
											class="icon-calendar"></i>
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td><label>승객수</label></td>
								<td>
									<div class="input-append">
										<input class="span9" id="personNum" name="personNum"
											type="text"> <span class="add-on">명</span>
									</div>
								</td>
							</tr>

							<tr>
								<td colspan="2" align="center"><button type="submit"
										class="btn">예약하기</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
			<br />
			<div id="scheduleSearch">
				<legend>스케쥴검색</legend>
				<div>
					<form class="form-inline">
						<table border="0">
							<tr>
								<td><select class="span12">
										<option>출발일</option>
										<option>도착일</option>
								</select></td>
								<td>
									<div class="input-append">
										<input class="span10" id="arriveDate" name="arriveDate"
											type="text"> <span class="add-on"> <i
											class="icon-calendar"></i>
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td><select class="span12">
										<option>출발지</option>
										<option>도착지</option>
								</select></td>
								<td>
									<div class="input-append">
										<input class="span10" id="arriveDate" name="arriveDate"
											type="text"> <span class="add-on"> <i
											class="icon-search"></i>
										</span>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<!-- 검색결과 -->
				<div>
					<table class="table table-striped">
						<thead>
							<td>출발일</td>
							<td>도착일</td>
							<td>출발지</td>
							<td>도착지</td>
							<td>좌석수</td>
						</thead>
						<tbody>
							<tr>
								<td>2012-10-02 09:00</td>
								<td>2012-10-03 11:00</td>
								<td>인천</td>
								<td>뉴욕</td>
								<td>20석</td>
							</tr>
							<tr>
								<td>2012-10-02 11:00</td>
								<td>2012-10-03 13:00</td>
								<td>인천</td>
								<td>뉴욕</td>
								<td>10석</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="mainBar" class="span8">
			<div id="mainSlide"></div>
			<br />
			<div class="rowfluid">
				<div class="span4">
					<div id="notice">
						<legend>공지사항</legend>
						<table border="0">
							<tr>
								<td>환절기 유의</td>
							</tr>
							<tr>
								<td>뉴욕행 비행기 연착안내</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="span4">
					<div id="event">
						<legend>이벤트</legend>
						<table border="0">
							<tr>
								<td>비행기 50%할인이벤트</td>
							</tr>
							<tr>
								<td>마일리지 적립금 10%이벤트</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	<%@ include file="inc/footer.jsp"%>
</div>


</body>
</html>
