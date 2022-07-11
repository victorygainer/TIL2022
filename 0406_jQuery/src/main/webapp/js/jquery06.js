$(() => {
//	class 속성이 error로 지정된 에러 메시지를 숨긴다.
	$('.error').hide();
	
//	id 속성이 single로 지정된 form에서 submit 버튼이 클릭되면 실행할 이벤트를 지정한다.
//	submit(html 이나 javascript는 onsubmit) 이벤트는 input 태그나 button 태그의 type 속성이
//	submit을 지정된 버튼이 클릭되면 발생되는 이벤트이다.
//	submit 이벤트는 폼의 유효성을 검사하는데 사용되며 폼에 입력된 데이터가 이상이 없으면
//	true(기본값)을 리턴시키고 이상이 있으면 에러 메시지를 출력하고 false를 리턴시킨다.
//	submit 이벤트의 리턴값이 true면 action 페이지로 이동하고 false면 현재 페이지를 표시한다.
	$('#single').submit(function () {
		// console.log('submit 버튼이 클릭됨');
		let userID = $('#infoBox').val().trim();
		if (userID == null || userID == '') {
			$('#infoBox').val('');
			$('#infoBox').focus()
			$('.error').show()
			return false;
		}
		return true;
	});
	
//	전체선택 체크 박스가 클릭되면 모든 체크 박스를 선택 또는 해제한다.
	$('input[name=all]').click(() => {
		// console.log('전체선택 체크 박스 클릭');
		let checked = $('input[name=all]').prop('checked');
		// console.log(checked);
		// name 속성이 chk인 체크 상자의 프로퍼티를 name 속성이 all인 체크 상자의 프로퍼티로 바꾼다.
		// 1.
		// $('input[name=chk]').each(index => $('input[name=chk]').eq(index).prop('checked', checked));
		// 2.
		// $('input[name=chk]').each(function () {
		//		$(this).prop('checked', checked);	
		// });
		// 3.
		$('input[name=chk]').prop('checked', checked);
	});
	
//	name 속성이 chk인 체크 박스가 클릭되면 모든 체크 박스가 체크되었나 검사해서 전체선택
//	체크 박스를 선택 또는 해제 한다.
	$('input:checkbox[name=chk]').click(() => {
		// console.log('name 속성이 chk인 체크 박스 클릭');
		// name 속성값이 chk인 요소의 개수와 name 속성값이 chk인 요소 중에서 체크된 요소의 개수를 비교한다.
		// console.log('name 속성이 chk인 요소의 개수: ' + $('input:checkbox[name=chk]').length);
		// console.log('name 속성이 chk인 요소 중에서 체크된 요소의 개수: ' + 
		// 		$('input:checkbox[name=chk]:checked').length);
		if ($('input:checkbox[name=chk]').length == $('input:checkbox[name=chk]:checked').length) {
			// console.log('모두 체크됨');
			$('input:checkbox[name=all]').prop('checked', true);
		} else {
			// console.log('모두 체크되지 않음');
			$('input:checkbox[name=all]').prop('checked', false);
		}
	})
	
//	체크 박스를 선택하고 확인 버튼을 클릭하면 체크 여부를 확인해서 그 결과를 id 속성이 result로 지정된
//	div 태그 내부에 출력한다.
	$('#confirm').click(() => {
		// console.log('확인 버튼 click 이벤트 실행');
		// 선택한 과일 가격이 표시될 div 태그 내부 내용을 지운다.
		// $('#result').html('');
		// $('#result').text('');
		// empty(): 선택된 요소의 내부 내용을 지운다.
		$('#result').empty();
		
		// name 속성에 chk가 지정된 체크 박스의 체크된 항목의 개수를 얻어온다.
		let count = $('input:checkbox[name=chk]:checked').length;
		// console.log(count);
		if (count == 0) {
			// alert('과일을 1개 이상 선택해주세요!!!');
			$('#result').html('<b style="color: red;">과일을 1개 이상 선택해주세요!!!</b>');
			// $('#result').append('<b style="color: red;">과일을 1개 이상 선택해주세요!!!</b>');
		} else {
			$('input:checkbox[name=chk]:checked').each(index => {
				// console.log(index);
				let chk = $('input:checkbox[name=chk]:checked').eq(index);
				// console.log(chk); // input
				// console.log(chk.val()); // 과일 가격
				// console.log(chk.next()); // b
				// console.log(chk.next().html()); // 과일 이름
				// console.log(chk.next().next()); // <br/>
				$('#result').append('과일 이름: ' + chk.next().html() + ', 과일 가격: ' + chk.val() + '<br/>');
			})
		}
	})

//	형제(sibling) 요소 탐색
//	.siblings() : 선택된 요소의 형제 요소 중에서 지정한 선택자에 해당되는 모든 요소를 선택한다.
//	.next() : 선택된 요소 바로 다음에 위치한 형제 요소 1개를 선택한다.
//	.nextAll() : 선택된 요소 바로 다음에 위치한 형제 요소를 모두 선택한다.
//	.nextUntil() : 선택된 요소 바로 다음에 위치한 형제 요소 중에서 지정한 선택자에 해당되는 요소 
//	바로 이전까지의 요소를 모두 선택한다.
//	.prev() : 선택된 요소 바로 이전에 위치한 형제 요소 1개를 선택한다.
//	.prevAll() : 선택된 요소 바로 이전에 위치한 형제 요소를 모두 선택한다.
//	.prevUntil() : 선택된 요소 바로 이전에 위치한 형제 요소 중에서 지정한 선택자에 해당되는 요소 
//	바로 다음까지의 요소를 모두 선택한다.		
	
}); // onload





















