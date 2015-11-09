/**
 * 
 */
		/* 예제용 함수 */
		function saveContent() {
			Editor.save(); // 이 함수를 호출하여 글을 등록하면 된다.
		}

		/**
		 * Editor.save()를 호출한 경우 데이터가 유효한지 검사하기 위해 부르는 콜백함수로
		 * 상황에 맞게 수정하여 사용한다.
		 * 모든 데이터가 유효할 경우에 true를 리턴한다.
		 * @function
		 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
		 * @returns {Boolean} 모든 데이터가 유효할 경우에 true
		 */
		function validForm(editor) {
			// Place your validation logic here
			if ($tx('title').value == "") {
				alert('제목을 입력하세요');
				return false;
			}

			// sample : validate that content exists
			var validator = new Trex.Validator();
			var content = editor.getContent();
			if (!validator.exists(content)) {
				alert('내용을 입력하세요');
				return false;
			}

			return true;
		}

		/**
		 * Editor.save()를 호출한 경우 validForm callback 이 수행된 이후
		 * 실제 form submit을 위해 form 필드를 생성, 변경하기 위해 부르는 콜백함수로
		 * 각자 상황에 맞게 적절히 응용하여 사용한다.
		 * @function
		 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
		 * @returns {Boolean} 정상적인 경우에 true
		 */
		function setForm(editor) {
			var i, input;
			var form = editor.getForm();
			var content = editor.getContent();

			// 본문 내용을 필드를 생성하여 값을 할당하는 부분
			var textarea = document.createElement('textarea');
			textarea.name = 'content';
			textarea.value = content;

			// form.createField(textarea);
			form.createField(tx.textarea({
				'name' : "content",
				'style' : {
					'display' : "none"
				}
			}, content));
			//$('textarea[name=content]').attr("style","display:none"); 
			/* 아래의 코드는 첨부된 데이터를 필드를 생성하여 값을 할당하는 부분으로 상황에 맞게 수정하여 사용한다.
			 첨부된 데이터 중에 주어진 종류(image,file..)에 해당하는 것만 배열로 넘겨준다. */
			var images = editor.getAttachments('image');
			for (i = 0; i < images.length; i++) {
				// existStage는 현재 본문에 존재하는지 여부
				if (images[i].existStage) {
					// data는 팝업에서 execAttach 등을 통해 넘긴 데이터
					alert('attachment information - image[' + i + '] \r\n'
							+ JSON.stringify(images[i].data));
					input = document.createElement('input');
					input.type = 'hidden';
					input.name = 'attach_image';
					input.value = images[i].data.imageurl; // 예에서는 이미지경로만 받아서 사용
					alert(input);
					form.createField(input);
				}
			}

			var files = editor.getAttachments('file');
			for (i = 0; i < files.length; i++) {
				input = document.createElement('input');
				input.type = 'hidden';
				input.name = 'attach_file';
				input.value = files[i].data.attachurl;
				alert(input);
				form.createField(input);
			}
			return true;
		}
