function showList(lablesearch) {
	var record = "";
	if (lablesearch === null) {
		var lablesearch = {
			start : 0,
			page : 1
		};
	}

	lablesearch.limit = 10;
	lablesearch.searchColumn = $('#searchColumn').val();
	lablesearch.searchText = $('#searchText').val();
	// ajax 설정
	$
			.ajax({
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(lablesearch),
				contentType : "application/json; charset=UTF-8",
				url : '/test/company/lableselect',
				error : function() {
					alert("데이터가 에러 났습니다. 에러확인바랍니다.");
				},
				// 성공시 html 뿌려주기
				success : function(jsontotal) {
					if (jsontotal.success) {
						$
								.each(
										jsontotal.items,
										function(i, corplable) {
											record += '<tr>'
													+ '<td><input type="checkbox" name="mp_lablenum" value="'
													+ corplable.mpssnumEncrypt
													+ '"/></td>'
													+ '<td>'
													+ corplable.mp_lablenum
													+ '</td>'
													+ '<td><a href="#" onclick="ViewSelect(\''
													+ corplable.mpssnumEncrypt
													+ '\')">'
													+ corplable.mp_lablename
													+ '</a></td>'
													+ '<td>'
													+ corplable.mp_lablebn
													+ '</td>'
													+ '<td>'
													+ corplable.mp_bizperson
													+ '</td>'
													+ '<td>'
													+ corplable.mp_bizphone
													+ '</td>'
													+ '<td>'
													+ corplable.mp_useyn
													+ '</td>'
													+ '<td>'
													+ corplable.mp_insertdate
													+ '</td>' + '</tr>'
										});
						$('#dataTable > tbody').html(record);
						// page
						if (jsontotal.total > 0) {
							goPagination(jsontotal.total, 10, lablesearch.page);
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
		url : "/test/company/lableviewer/" + mpssnumEncrypt,
		error : function() {
			alert("실패 하셩습니다. ");
		},
		success : function(jsontotal) {
			if (jsontotal.success) {
				var corpcompany = jsontotal.data;
				$('#mpssnumEncrypt').val(corplable.mpssnumEncrypt);
				$('#lablename').val(corplable.mp_lablename);
				$('#lablephone').val(corplable.mp_lablephone);
				$('#lableaddress').val(corplable.mp_lableaddress);
				$('#lablebn').val(corplable.mp_lablebn);
				$('#bizperson').val(corplable.mp_bizperson);
				$('#bizphone').val(corplable.mp_bizphone);
				$(':radio[name="RadioGroup1"]').filter(
						'[value="' + corplable.mp_useyn + '"]').prop(
						"checked", true);
				$('#yboardEditModal').modal('show');
				var lablecontents = CKEDITOR.instances.lablecontents
						.setData(corplable.mp_lablecontents);
				var bizcontents = CKEDITOR.instances.bizcontents
						.setData(corplable.mp_bizcontents);
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
	$('#mp_lablenum').val('')
	var bootstrapValidator = $('#' + formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}

/**
 * 모달창이 닫힐때 폼내용을 reset해준다.
 */
$('.modal').on('hidden.bs.modal', function() {
	var lablecontents = CKEDITOR.instances.lablecontents.setData('');
	var bizcontents = CKEDITOR.instances.bizcontents.setData('');
});
$('#resetBtn').click(function() {
	var lablecontents = CKEDITOR.instances.lablecontents.setData('');
	var bizcontents = CKEDITOR.instances.bizcontents.setData('');
	resetForm('mplanform');
});

/**
 * 저장
 */
$('#btnYboardSave').click(function() {
	var mp_corpnums = $('#mpssnumEncrypt').val();
	alert("mpssnumEncrypt : " + mp_corpnums);

	var method = "lableinsert";
	alert("lableinsert : " + method);
	if (mp_corpnums != "") {
		method = "lableupdate";
		alert("lableupdate : " + method);
	}
	// 폼입력값 검증
	if (!formValidator()) {
		return;
	}
	// var surveyCode = $("#surveyCodeForm" ).serializeObject();
	var corplable = {
		mp_lablename : $('#lablename').val(),
		mp_lablephone : $('#lablephone').val(),
		mp_lableaddress : $('#lableaddress').val(),
		mp_lablebn : $('#lablebn').val(),
		mp_bizperson : $('#bizperson').val(),
		mp_bizphone : $('#bizphone').val(),
		mp_lablecontents : CKEDITOR.instances.lablecontents.getData(),
		mp_bizcontents : CKEDITOR.instances.bizcontents.getData(),
		mp_useyn : $('input[name="RadioGroup1"]:checked').val(),
		mpssnumEncrypt : mp_lablenum
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
	var checknum = $(':checkbox[name="mp_lablenum"]').map(function() {
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
		mp_lablenum : checknum
	};
	$.ajax({
		type : "POST",
		dataType : "JSON",
		data : JSON.stringify(param),
		contentType : "application/json; charset=UTF-8",
		url : "/test/company/labledelete",
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
		$(':checkbox[name="mp_lablenum"]').prop("checked", true);
	} else {
		$(':checkbox[name="mp_lablenum"]').prop("checked", false);
	}
});

// 초기화
(function() {
	$('.selectpicker').selectpicker({
		width : "auto"
	});
	showList(null); // 0부터 1페이지를 출력
})();