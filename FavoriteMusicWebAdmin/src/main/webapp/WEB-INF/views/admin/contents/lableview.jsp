<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 관리 게시판</title>

<link
	href="/web/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="/web/resources/bower_components/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet">
<link
	href="/web/resources/bower_components/bootstrapValidator/dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<script src="/web/resources/bower_components/jquery/jquery.min.js"></script>
<script src="/web/resources/js/jquery/jquery.form.min.js"></script>
<!-- jQuery MultiFile Plugin import -->
<script src="/web/resources/js/jquery/jQuery.MultiFile.min.js"></script>
<script
	src="/web/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script
	src="/web/resources/bower_components/bootstrap-select/bootstrap-select.min.js"></script>
<script
	src="/web/resources/bower_components/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
<script
	src="/web/resources/bower_components/bootstrapValidator/dist/js/bootstrapValidator.min.js"></script>





</head>
<body>
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
										<option value="mp_artist">회사이름</option>
										<option value="mp_title">담당자</option>
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
								<th>회사이름</th>
								<th>담당자</th>
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

	<div class="modal fade" id="yboardEditModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">음원 관리/수정</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="mplanform" name="mplanform">
						<input type="hidden" id="mpssnumEncrypt" name="mpssnumEncrypt">

						<div class="form-group">
							<label for="corpname" class="col-sm-2 control-label">회사이름
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="corpname"
									name="corpname" placeholder="아티스트 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="number" class="col-sm-2 control-label">사업자등록번호
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="number"
									name="number" placeholder="타이틀  입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">회사주소
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="address"
									name="address" placeholder="앨범명  입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="etc" class="col-sm-2 control-label">기타사항 </label>
							<div class="col-sm-10">
								<textarea style=" height: 200px; width: 100%;" id="etc"
									name="etc"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="person" class="col-sm-2 control-label">담당자</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="person"
									name="person" placeholder="레이블  ">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">담당자
								전화번호 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phone" name="phone"
									placeholder="유통사  ">
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
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary" id="btnYboardSave">저장</button>
				</div>

			</div>

		</div>

	</div>

</body>

<script src="/web/resources/music/corpview.js"></script>
</html>