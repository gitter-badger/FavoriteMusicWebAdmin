$(function() {
	$("#artist").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/test/artistname",
				type : "post",
				dataType : "json",
				data : {
					term : request.term,
				},
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data) {
					response($.map(data, function(item) {
						// alert(item.mp_artist);
						console.log(data);
						console.log(item.mp_artist);
						console.log(item.mp_anum);
						return {
							label : item.mp_artist,
							value : item.mp_anum

						}
					}));
				},
				error : function(data) {
					alert("에러가 발생하였습니다.")
				}

			});
		},
		focus : function(event, ui) {
			event.preventDefault();
			$("#artist").val(ui.item.label);
		},
		select : function(event, ui) {
			event.preventDefault();
			$("#artist").val(ui.item.label);
			$("#artistnum").val(ui.item.value);
		}
	});
});
$(function() {
	$("#album").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/test/albumname",
				type : "post",
				dataType : "json",
				data : {
					term : request.term,
				},
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data) {
					response($.map(data, function(item) {
						// alert(item.mp_artist);
						console.log(data);
						console.log(item.mp_album);
						console.log(item.mp_alnum);
						return {
							label : item.mp_album,
							value : item.mp_alnum

						}
					}));
				},
				error : function(data) {
					alert("에러가 발생하였습니다.")
				}

			});
		},
		focus : function(event, ui) {
			event.preventDefault();
			$("#album").val(ui.item.label);
		},
		select : function(event, ui) {
			event.preventDefault();
			$("#album").val(ui.item.label);
			$("#albumnum").val(ui.item.value);
		}
	});
});
$(function() {
	$("#title").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "/test/titlename",
				type : "post",
				dataType : "json",
				data : {
					term : request.term,
				},
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data) {
					response($.map(data, function(item) {
						// alert(item.mp_artist);
						console.log(data);
						console.log(item.mp_title);
						console.log(item.mp_mpnum);
						return {
							label : item.mp_title,
							value : item.mp_mpnum

						}
					}));
				},
				error : function(data) {
					alert("에러가 발생하였습니다.")
				}

			});
		},
		focus : function(event, ui) {
			event.preventDefault();
			$("#title").val(ui.item.label);
		},
		select : function(event, ui) {
			event.preventDefault();
			$("#title").val(ui.item.label);
			$("#titlenum").val(ui.item.value);
		}
	});
});