
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
				url : '/web/source/corpviewselect',
				error : function() {
					alert("데이터가 에러 났습니다. 에러확인바랍니다.");
				},
				// 성공시 html 뿌려주기
				success : function(jsontotal) {
					if (jsontotal.success) {
						$
								.each(
										jsontotal.items,
										function(i, sscorp) {
											record += '<tr>'
													+ '<td><input type="checkbox" name="mp_corpnums" value="'
													+ sscorp.mpssnumEncrypt
													+ '"/></td>'
													+ '<td>'
													+ sscorp.mp_corpnum
													+ '</td>'
													+ '<td><a href="#" onclick="ViewSelect(\''
													+ sscorp.mpssnumEncrypt
													+ '\')">'
													+ sscorp.mp_corpname
													+ '</a></td>' + '<td>'
													+ sscorp.mp_person
													+ '</td>' + '<td>'
													+ sscorp.mp_useyn + '</td>'
													+ '<td>' + sscorp.mp_date
													+ '</td>'

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
		url : "/web/source/corpviewer/" + mpssnumEncrypt,
		error : function() {
			alert("실패 하셩습니다. ");
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				var sscorp = jsontotal.data;
				$('#mpssnumEncrypt').val(sscorp.mpssnumEncrypt);
				$('#corpname').val(sscorp.mp_corpname);
				$('#number').val(sscorp.mp_number);
				$('#address').val(sscorp.mp_address);
				$('#etc').text(sscorp.mp_contents);
				$('#person').val(sscorp.mp_person);
				$('#phone').val(sscorp.mp_phone);
				$(':radio[name="RadioGroup1"]').filter(
						'[value="' + sscorp.mp_useyn + '"]').prop("checked",
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
						max : 30,
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
	$('#mp_corpnums').val('')
	var bootstrapValidator = $('#' + formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}

/**
 * 모달창이 닫힐때 폼내용을 reset해준다.
 */
$('.modal').on('hidden.bs.modal', function() {
	$('#etc').text('');
	resetForm('mplanform');
});

/**
 * 저장
 */
$('#btnYboardSave').click(function() {
	var mp_corpnums = $('#mpssnumEncrypt').val();
	alert("mpssnumEncrypt : " + mp_corpnums);

	var method = "sscorpinsert";
	alert("sscorpinsert : " + method);
	if (mp_corpnums != "") {
		method = "sscorpupdate";
		alert("sscorpupdate : " + method);
	}
	// 폼입력값 검증
	if (!formValidator()) {
		return;
	}
	// var surveyCode = $("#surveyCodeForm" ).serializeObject();
	var sscorp = {
		mp_corpname : $('#corpname').val(),
		mp_number : $('#number').val(),
		mp_address : $('#address').val(),
		mp_contents : $('#etc').val(),
		mp_person : $('#person').val(),
		mp_phone : $('#phone').val(),
		mp_useyn : $('input[name="RadioGroup1"]:checked').val(),
		mpssnumEncrypt : mp_corpnums
	};

	$.ajax({
		type : "POST",
		dataType : "JSON",
		data : JSON.stringify(sscorp),
		contentType : "application/json; charset=UTF-8",
		url : '/web/source/' + method,
		error : function() {
			alert("Loading failed!");
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				showList(null);
				resetForm('mplanform');

				$('#yboardEditModal').modal('hide');
			} else {
				alert(jsontotal.msg);
			}
		}
	});

});

/**
 * 체크된 게시내용 삭제
 */
$('#btnYboardDelete').click(function() {
		var checknum = $(':checkbox[name="mp_corpnums"]').map(function(){
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
		mp_corpnum : checknum
	};
	$.ajax({
		type : "POST",
		dataType : "JSON",
		data : JSON.stringify(param),
		contentType : "application/json; charset=UTF-8",
		url : "/web/source/sscorpdelete",
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
		$(':checkbox[name="mp_corpnums"]').prop("checked", true);
	} else {
		$(':checkbox[name="mp_corpnums"]').prop("checked", false);
	}
});

// 초기화
(function() {
	$('.selectpicker').selectpicker({
		width : "auto"
	});
	showList(null); // 0부터 1페이지를 출력
})();