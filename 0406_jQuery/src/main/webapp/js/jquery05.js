$(() => {
//	input 태그 중에서 type이 text인 요소를 선택해서 배경색 지정하기
	/*
//	let inputs = document.getElementsByTagName('input');
	let inputs = document.querySelectorAll('input');
	console.log(inputs.length); // 9
	for (let i=0; i<inputs.length; i++) {
		// getAttribute() 함수는 인수로 지정된 속성값을 얻어온다.
		if (inputs[i].getAttribute('type') == 'text') {
			inputs[i].style.backgroundColor = 'yellowgreen';
		}
	}
	*/
	
	/*
	let inputs = document.querySelectorAll('input[type=text]');
	console.log(inputs.length); // 4
	for (let i=0; i<inputs.length; i++) {
			inputs[i].style.backgroundColor = 'dodgerblue';
	}
	*/
	
//	$('input[type=text]').css('backgroundColor', 'tomato');
	$('input:text').css('backgroundColor', 'hotpink');
	
//	select 태그의 name 속성이 email인 요소에서 change 이벤트가 발생되면 선택된 목록의
//	value 값을 name 속성이 addr인 텍스트 상자에 넣는다.
	/*
	let email = document.querySelectorAll('select[name=email]')[0];
	// console.log(email);
	email.onchange = () => {
		let emailValue = email.options[email.selectedIndex].value;
		console.log(emailValue);
		let addr = document.querySelectorAll('input[name=addr]')[0];
		addr.value = emailValue;
	};
	*/
	
	/*
	$('select[name=email]').eq(0).change(() => {
		let emailValue = $('select[name=email]:eq(0) > option:selected').val();
		console.log(emailValue);
		$('input[name=addr]').eq(0).val(emailValue);
	});
	*/
	
	$('select[name=email]').eq(0).change(function () {
//		콤보 상자는 한 번에 한 개만 선택되기 때문에 $('select[name=email]:eq(0) > option:selected')와
//		$(this)는 같은 의미로 사용된다.
//		$(this)는 arrow 함수를 사용할 때는 동작되지 않는다.
		console.log($(this).val());
		$('input[name=addr]').eq(0).val($(this).val());
	});
	
//	체크 박스를 체크(클릭)하면 체크된 목록을 출력한다.
	/*
	let hobby1 = document.getElementsByName('hobbies')[0];
	hobby1.onclick = () => hobbyCheck();
	let hobby2 = document.getElementsByName('hobbies')[1];
	hobby2.onclick = () => hobbyCheck();
	let hobby3 = document.getElementsByName('hobbies')[2];
	hobby3.onclick = () => hobbyCheck();
	*/
	
	/*
	$('input:checkbox[name=hobbies]').click(() => {
		let msg = '';
//		each(): 선택된 요소들의 인덱스와 요소 자체를 리턴하며 인수로 지정한 함수를 반복 실행한다.
//		each() 메소드는 익명 함수로 2개의 데이터를 넘긴다. 1번째는 index이고 2번째 객체이다.
		$('input:checkbox[name=hobbies]:checked').each(index => {
			// console.log('index: ' + index);
			msg += $('input:checkbox[name=hobbies]:checked').eq(index).val() + ' ';
		});
		console.log(msg.length == 0 ? '없음' : msg);
		console.log('========================');
	});
	*/
	
	$('input:checkbox[name=hobbies]').click(() => {
		let msg = '';
		$('input:checkbox[name=hobbies]:checked').each((_, obj) => {
			// console.log('index: ' + index + ', obj.value: ' + obj.value);
			msg += obj.value + ' ';
		});
		console.log(msg.length == 0 ? '없음' : msg);
		console.log('========================');
	});
	
	
}); // onload 끝

function hobbyCheck() {
	let hobbies = document.getElementsByName('hobbies');
	let msg = '';
	for (let hobby of hobbies) {
		if (hobby.checked) {
			msg += hobby.value + ' ';
		}
	}
	console.log(msg.length == 0 ? '없음' : msg);
}




















