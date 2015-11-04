<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음원 관리 게시판</title>

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
		<div class="page-header">
			<h1>
				<small>Favorite Music 음원관리</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">음원 관리</div>
					<div class="panel-body">
						<div class="form-inline">
							<div class="row">
								<div class="col-md-10">
									<select id="searchColumn" class="selectpicker">
										<option value="mp_artist">아티스트</option>
										<option value="mp_title">제목</option>
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
								<th>제목명</th>
								<th>앨범명</th>
								<th>날짜</th>
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
		method="POST"
		enctype="multipart/form-data">
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

						<input type="hidden" id="mpssnumEncrypt" name="mpssnumEncrypt">
						<div class="form-group">
							<label for="num" class="col-sm-2 control-label">넘버</label>
							<div class="col-sm-10">
								<select id="num" class="selectpicker" name="num">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
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
							<label for="title" class="col-sm-2 control-label">타이틀 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="타이틀  입력하세요">
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
							<label for="lyric" class="col-sm-2 control-label">가사입력 </label>
							<div class="col-sm-10">
								<textarea style="height: 200px; width: 100%;" id="lyric"
									name="lyric"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="label" class="col-sm-2 control-label">레이블 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="label" name="label"
									placeholder="레이블  ">
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
							<label for="year" class="col-sm-2 control-label">년도 </label>
							<div class="col-sm-10">
								<input type="date" class="form-control" id="year" name="year"
									placeholder="년도 ">
							</div>
						</div>
						<div class="form-group">
							<label for="genre1" class="col-sm-2 control-label">1차
								분류(가요/팝)</label>
							<div class="col-sm-10">
								<select id="genre1" class="selectpicker" name="genre1">
									<option value="gayo">가요</option>
									<option value="pop">팝</option>
									<option value="jpop">일본음악</option>
									<option value="cpop">중국음악</option>
									<option value="worldmusic">월드뮤직</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="genre2" class="col-sm-2 control-label">2차
								분류(장르)</label>
							<div class="col-sm-10">
								<select id="genre2" class="selectpicker" name="genre2">
									<option value="dance">댄스</option>
									<option value="electronic">일렉트로닉</option>
									<option value="rock">락</option>
									<option value="ost">O.S.T</option>
									<option value="balade">발라드</option>
									<option value="rnb">R&amp;B</option>
									<option value="hiphop">힙합</option>
									<option value="trot">트롯트</option>
									<option value="etc">기타</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="etc" class="col-sm-2 control-label">기타 </label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="etc" name="etc"
									placeholder="작성자명을 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="copy" class="col-sm-2 control-label">오픈일 </label>
							<div class="col-sm-10">
								<input type="date" class="form-control" id="copy" name="copy"
									placeholder="오픈일  ">
							</div>
						</div>
						<div class="form-group">
							<label for="age" class="col-sm-2 control-label">연령제한 </label>
							<div class="col-sm-10">
								<select id="age" class="selectpicker" name="age">
									<option value="0">전체이용가</option>
									<option value="7">7세이용가</option>
									<option value="12">12세이용가</option>
									<option value="15">15세이용가</option>
									<option value="19">19세이용가</option>
								</select>
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
							<label for="m320kupload" class="col-sm-2 control-label">음질320K
							</label>
							<div class="col-sm-10">
								<input type="file" class="mp320file" name="m320kupload"
									id="m320kupload" />
							</div>
						</div>
						<div class="form-group">
							<label for="m192kupload" class="col-sm-2 control-label">음질192K
							</label>
							<div class="col-sm-10">
								<input type="file" class="mp192file" name="m192kupload"
									id="m192kupload" />

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
					</div>

				</div>

			</div>

		</div>
	</form>
</body>

<script src="/web/resources/music/soundview.js"></script>
</html>