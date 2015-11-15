function showList(b2bsearch) {
	var record = "";
	if (b2bsearch === null) {
		var b2bsearch = {
			start : 0,
			page : 1
		};
	}

	b2bsearch.limit = 10;
	b2bsearch.searchColumn = $('#searchColumn').val();
	b2bsearch.searchText = $('#searchText').val();
	// ajax 설정
	$
			.ajax({
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(b2bsearch),
				contentType : "application/json; charset=UTF-8",
				url : '/test/company/b2bselect',
				error : function() {
					alert("데이터가 에러 났습니다. 에러확인바랍니다.");
				},
				// 성공시 html 뿌려주기
				success : function(jsontotal) {
					if (jsontotal.success) {
						$
								.each(
										jsontotal.items,
										function(i, b2bcompany) {
											record += '<tr>'
													+ '<td><input type="checkbox" name="mp_b2bnum" value="'
													+ b2bcompany.mpssnumEncrypt
													+ '"/></td>'
													+ '<td>'
													+ b2bcompany.mp_b2bnum
													+ '</td>'
													+ '<td><a href="#" onclick="ViewSelect(\''
													+ b2bcompany.mpssnumEncrypt
													+ '\')">'
													+ b2bcompany.mp_b2bname
													+ '</a></td>'
													+ '<td>'
													+ b2bcompany.mp_b2bbn
													+ '</td>'
													+ '<td>'
													+ b2bcompany.mp_bizperson
													+ '</td>'
													+ '<td>'
													+ b2bcompany.mp_bizphone
													+ '</td>'
													+ '<td>'
													+ b2bcompany.mp_useyn
													+ '</td>'
													+ '<td>'
													+ b2bcompany.mp_insertdate
													+ '</td>' + '</tr>'
										});
						$('#dataTable > tbody').html(record);
						// page
						if (jsontotal.total > 0) {
							goPagination(jsontotal.total, 10, b2bsearch.page);
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
		url : "/test/company/b2bviewer/" + mpssnumEncrypt,
		error : function() {
			alert("실패 하셩습니다. ");
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				var b2bcompany = jsontotal.data;
				$('#mpssnumEncrypt').val(b2bcompany.mpssnumEncrypt);
				$('#b2bname').val(b2bcompany.mp_b2bname);
				$('#b2bphone').val(b2bcompany.mp_b2bphone);
				$('#b2baddress').val(b2bcompany.mp_b2baddress);
				$('#b2bbn').val(b2bcompany.mp_b2bbn);
				$('#bizperson').val(b2bcompany.mp_bizperson);
				$('#bizphone').val(b2bcompany.mp_bizphone);
				$(':radio[name="RadioGroup1"]').filter(
						'[value="' + b2bcompany.mp_useyn + '"]').prop(
						"checked", true);
				$('#yboardEditModal').modal('show');
				var b2bcontents = CKEDITOR.instances.b2bcontents
						.setData(b2bcompany.mp_b2bcontents);
				var bizcontents = CKEDITOR.instances.bizcontents
						.setData(b2bcompany.mp_bizcontents);
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
	$('#mp_b2bnum').val('')
	var bootstrapValidator = $('#' + formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}

/**
 * 모달창이 닫힐때 폼내용을 reset해준다.
 */
$('.modal').on('hidden.bs.modal', function() {
	var corpcontents = CKEDITOR.instances.corpcontents
	.setData('');
	var bizcontents = CKEDITOR.instances.bizcontents
	.setData('');
});
$('#resetBtn').click(function() {
	var corpcontents = CKEDITOR.instances.corpcontents
	.setData('');
	var bizcontents = CKEDITOR.instances.bizcontents
	.setData('');
	resetForm('mplanform');
});



/**
 * 저장
 */
$('#btnYboardSave').click(function() {
	var mp_b2bnums = $('#mpssnumEncrypt').val();
	alert("mpssnumEncrypt : " + mp_corpnums);

	var method = "b2binsert";
	alert("b2binsert : " + method);
	if (mp_b2bnums != "") {
		method = "b2bupdate";
		alert("b2bupdate : " + method);
	}
	// 폼입력값 검증
	if (!formValidator()) {
		return;
	}
	// var surveyCode = $("#surveyCodeForm" ).serializeObject();
	var b2bcompany = {
		mp_b2bname : $('#b2bname').val(),
		mp_b2bphone : $('#b2bphone').val(),
		mp_b2baddress : $('#b2baddress').val(),
		mp_b2bbn : $('#b2bbn').val(),
		mp_bizperson : $('#bizperson').val(),
		mp_bizphone : $('#bizphone').val(),
		mp_b2bcontents : CKEDITOR.instances.b2bcontents.getData(),
		mp_bizcontents : CKEDITOR.instances.bizcontents.getData(),
		mp_useyn : $('input[name="RadioGroup1"]:checked').val(),
		mpssnumEncrypt : mp_corpnums
	};

	$.ajax({
		type : "POST",
		dataType : "JSON",
		data : JSON.stringify(corpcompany),
		contentType : "application/json; charset=UTF-8",
		url : '/test/company/' + method,
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
	var checknum = $(':checkbox[name="mp_b2bnum"]').map(function() {
		if (this.checked) {
			// alert("한개 이상 체크되어야 합니다.");
			return this.value;
		}
	}).get().join(",");
	alert(checknum);
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
		url : "/test/company/b2bdelete",
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
		$(':checkbox[name="mp_b2bnum"]').prop("checked", true);
	} else {
		$(':checkbox[name="mp_b2bnum"]').prop("checked", false);
	}
});

// 초기화
(function() {
	$('.selectpicker').selectpicker({
		width : "auto"
	});
	showList(null); // 0부터 1페이지를 출력
})();