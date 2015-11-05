function showList(ssearch) {
	var record = "";
	if (ssearch === null) {
		var ssearch = {
			start : 0,
			page : 1
		};
	}

	ssearch.limit = 10;
	ssearch.searchColumn = $('#searchColumn').val();
	ssearch.searchText = $('#searchText').val();
	// ajax 설정
	$
			.ajax({
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(ssearch),
				contentType : "application/json; charset=UTF-8",
				url : '/test/contents/abviewselect',
				error : function() {
					alert("데이터가 에러 났습니다. 에러확인바랍니다.");
				},
				// 성공시 html 뿌려주기
				success : function(jsontotal) {
					if (jsontotal.success) {
						$
								.each(
										jsontotal.items,
										function(i, ssalbum) {
											record += '<tr>'
													+ '<td><input type="checkbox" name="mp_alnum" value="'
													+ ssalbum.mpssnumEncrypt
													+ '"/></td>'
													+ '<td>'
													+ ssalbum.mp_alnum
													+ '</td>'
													+ '<td><a href="#" onclick="ViewSelect(\''
													+ ssalbum.mpssnumEncrypt
													+ '\')">'
													+ ssalbum.mp_artist
													+ '</a></td>'
													+ '<td>'
													+ ssalbum.mp_album
													+ '</td>'
													+ '<td>'
													+ ssalbum.mp_corp
													+ '</td>'
													+ '<td>'
													+ ssalbum.mp_year
													+ '</td>'
													+ '<td>'
													+ ssalbum.mp_useyn
													+ '</td>'
													+ '<td>'
													+ ssalbum.mp_date
													+ '</td>'
													+ '</tr>'
										});
						$('#dataTable > tbody').html(record);
						// page
						if (jsontotal.total > 0) {
							goPagination(jsontotal.total, 10, ssearch.page);
							$('#pagination').show();
						} else {
							$('#pagination').hide();
						}
					} else {
						alert('로딩이 안됩니다.');
					}

				}

			});
};

function ViewSelect(mpssnumEncrypt) {
	$.ajax({
		type : "GET",
		dataType : "JSON",
		contentType : "application/json; charset=UTF-8",
		url : "/test/contents/abviewer/" + mpssnumEncrypt,
		error : function() {
			alert("실패 하셩습니다. ");
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				var ssalbum = jsontotal.data;
				$('#mpssnumEncrypt').val(ssalbum.mpssnumEncrypt);
				$('#artist').val(ssalbum.mp_artist);
				$('#album').val(ssalbum.mp_album);
				$('#content').text(ssalbum.mp_content);
				$('#year').val(ssalbum.mp_year);
				$('#corp').val(ssalbum.mp_corp);
				$('#imgupload').load(ssalbum.mp_albumimg);
				$(':radio[name="RadioGroup1"]').filter(
						'[value="' + ssalbum.mp_useyn + '"]').prop("checked",
						true);
				$('#yboardEditModal').modal('show');

			} else {
				alert("Loading failed!");
			}
		}
	});
}

/**
 * 검색버튼 클릭시
 */
$('#searchBtn').click(function() {
	showList(null);
});

function formValidator() {
	$('#mplanform').bootstrapValidator({
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			artist : {
				validators : {
					notEmpty : {
						message : '아티스트 입력 바랍니다.'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '최소 2자에서 30자이내로 입력하세요'
					}
				}
			},

			album : {
				validators : {
					notEmpty : {
						message : '앨범명 입력 바랍니다.'
					},
					stringLength : {
						min : 2,
						max : 200,
						message : '최소 2자에서 10자이내로 입력하세요'
					}
				}
			},

			corp : {
				validators : {
					notEmpty : {
						message : '유통사 입력 바랍니다.'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '최소 2자에서 10자이내로 입력하세요'
					}
				}
			},
			year : {
				validators : {
					notEmpty : {
						message : '년도 입력 바랍니다.'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '최소 2자에서 10자이내로 입력하세요'
					}
				}
			},
			RadioGroup1 : {
				validators : {
					notEmpty : {
						message : "사용여부 선택 바랍니다."
					}
				}
			},
			content : {
				validators : {
					notEmpty : {
						message : '가사 입력 바랍니다.'
					},
					stringLength : {
						min : 2,
						message : '최소 2자 이상은 입력하세요'
					}
				}
			}
		}
	// } fields

	}).bootstrapValidator('validate');
	return $('#mplanform').data('bootstrapValidator').isValid();
};

/**
 * 페이징 처리
 * 
 * @param total
 * @param limit
 * @param page_index
 * 
 */
function goPagination(total, limit, page_index) {
	var options = {
		bootstrapMajorVersion : 3,
		currentPage : page_index,
		totalPages : Math.ceil(total / limit),
		numberOfPages : 10,
		onPageClicked : function(e, originalEvent, type, page) {
			var start = 0;
			// 1페이지라면
			if (page === 1) {
				start = 0;
			} else if (page > 1) {
				// 2페이지이상이면 10 ~ limit 건씩, 3페이지라면 20~limit 건씩 출력
				start = (page - 1) * limit;
			}
			var search = {
				start : start,
				page : page
			};
			showList(search); // 리스트를 새로 조회한다.
		}
	}
	$('#pagination').bootstrapPaginator(options);

}

/**
 * 폼을 리셋한다.
 * 
 * @param formID
 */
function resetForm(formID) {
	$("#" + formID).each(function() {
		this.reset();
	});
	$('#mp_mpnums').val('')
	var bootstrapValidator = $('#' + formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}

/**
 * 모달창이 닫힐때 폼내용을 reset해준다.
 */
$('.modal').on('hidden.bs.modal', function() {
	$('#lyric').text('');
	resetForm('mplanform');
});

/**
 * 저장
 */

$('#btnYboardSave').click(function() {
	// var surveyCode = $("#surveyCodeForm" ).serializeObject();
	var mpssnumEncrypt = $('#mpssnumEncrypt').val();
	alert("mpssnumEncrypt : " + mpssnumEncrypt)
	var method = "ssalbuminsert";
	// alert("ssviewinsert : " + mpssnumEncrypt);
	if (mpssnumEncrypt != "") {
		alert("ssalbumupdate : " + mpssnumEncrypt);
		method = "ssalbumupdate";
	}
	// 폼입력값 검증
	if (!formValidator()) {
		return;
	}
	$('#mplanform').ajaxForm(

	{
		url : '/test/contents/' + method,
		cache : false,
		dataType : "json",
		// 보내기전 validation check가 필요할경우
		beforeSubmit : function(data, frm, opt) {
			// console.log(data);
			alert("전송전!!");
			return true;
		},
		// submit이후의 처리
		success : function(data, statusText) {

			alert("전송성공!!");
			showList(null);
			resetForm('yboardForm');
			$('#yboardEditModal').modal('hide');
		},
		// ajax error
		error : function(e) {
			alert("에러발생!!");
			console.log(e);
		}
	});
});

/**
 * 체크된 게시내용 삭제
 */
$('#btnYboardDelete').click(function() {
	var checknum = $('input[name=mp_alnum]:checked').map(function() {
		if (this.checked) {
			// alert("한개 이상 체크되어야 합니다.");
			return this.value;
		}
	}).get().join(",");

	// 아무것도 체크되어 있지 않다면 에러표시
	if (checknum === "") {
		alert("한개 이상 체크되어야 합니다.");
		return;
	}

	var param = {
		mp_alnum : checknum
	};
	$.ajax({
		type : "POST",
		dataType : "JSON",
		data : JSON.stringify(param),
		contentType : "application/json; charset=UTF-8",
		url : "/test/contents/ssalbumdelete",
		error : function() {
			alert("Loading failed!")
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				showList(null);
			} else {
				alert("Deleting failed!")
			}
		}
	});
});

/**
 * 일괄체크-해제
 */
$('#allCheck').click(function() {
	if (this.checked) {
		$(':checkbox[name="mp_alnum"]').prop("checked", true);
	} else {
		$(':checkbox[name="mp_alnum"]').prop("checked", false);
	}
});

// 초기화
(function() {
	$('.selectpicker').selectpicker({
		width : "auto"
	});
	showList(null); // 0부터 1페이지를 출력
})();