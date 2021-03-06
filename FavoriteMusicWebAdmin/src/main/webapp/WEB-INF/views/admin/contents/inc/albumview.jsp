<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<!-- start head -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	$(document)
			.ready(
					function() {
						$("#artist")
								.autocomplete(
										{
											source : function(request, response) {
												$
														.ajax({
															url : "/test/artistname",
															type : "post",
															dataType : "json",
															data : {
																term : request.term,
															//param1 : "param1 Value",
															//param2 : "param2 Value"
															},
															contentType : "application/x-www-form-urlencoded; charset=UTF-8",
															data : request,
															success : function(
																	data) {
																var result = data;
																response(result);
															},
															error : function(
																	data) {
																alert("에러가 발생하였습니다.")
															}
														});
											}
										});
					});
</script>
</head>
<!-- end head -->
<body>
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
								<th>회사명</th>
								<th>데뷔일</th>
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
								<select id="name" class="selectpicker" name="name">
									<option value="mini">미니</option>
									<option value="single">싱글</option>
									<option value="album">앨범</option>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="artist" class="col-sm-2 control-label">아티스트 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="artist"
									name="artist" placeholder="아티스트 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="album" class="col-sm-2 control-label">앨범명 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="album" name="album"
									placeholder="앨범명  입력하세요">
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
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary" id="btnYboardSave">저장</button>
						<button type="button" class="btn btn-info" id="resetBtn">리셋</button>
					</div>

				</div>

			</div>

		</div>
	</form>
</body>
</html>