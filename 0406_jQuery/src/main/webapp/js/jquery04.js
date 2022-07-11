//	input 요소의 선택
//	:button: type 속성이 'button'인 모든 요소를 선택한다.
//	:checkbox: type 속성이 'checkbox'인 모든 요소를 선택한다.
//	:file: type 속성이 'file'인 모든 요소를 선택한다.
//	:image: type 속성이 'image'인 모든 요소를 선택한다.
//	:password: type 속성이 'password'인 모든 요소를 선택한다.
//	:radio: type 속성이 'radio'인 모든 요소를 선택한다.
//	:reset: type 속성이 'reset'인 모든 요소를 선택한다.
//	:submit: type 속성이 'submit'인 모든 요소를 선택한다.
//	:text: type 속성이 'text'인 모든 요소를 선택한다.
//	:checked: type 속성이 'checkbox' 또는 'radio'인 요소 중에서 체크된 모든 요소들를 선택한다.
//	:selected: option 요소 중에서 선택된 모든 요소들를 선택한다.
//	:focus: 현재 포커스를 가지고 있는 요소를 선택한다.
//	:disabled: 비활성화 되어있는 모든 요소를 선택한다.
//	:enabled: 활성화 되어있는 모든 요소를 선택한다.

function choice() {
	/*
//	let inputs = document.getElementsByTagName('input');
//	let inputs = document.querySelectorAll('input');
//	console.log(inputs.length);
//	console.log(inputs[0]);

//	let input = document.getElementsByTagName('input')[0];
	let input = document.querySelector('input');
	console.log(input.value);
	input.value = '임꺽정';
	*/
	
//	javascript는 value 속성을 사용해서 ~~~~~.value 형태로 값을 얻어오고 ~~~~~.value = '값'
//	형태로 값을 넣어준다.
//	jquery는 value 속성대신 val() 메소드를 사용해서 ~~~~~.val() 형태로 값을 얻어오고
//	~~~~~.val('값') 형태로 값을 저장한다.

//	let inputs = $('input'); // input 태그 전체를 얻어온다.
//	console.log(inputs.length); // 7
//	let inputs = $('input:text'); // input 태그 중에서 type 속성값이 text인 태그 전체를 얻어온다.
//	console.log(inputs.length); // 2

//	아래와 같이 사용하면 input 태그의 type 속성의 값이 text인 요소가 여러개 있다 하더라도 첫 번째
//	요소의 값만 얻어올 수 있다.
//	let doc = $('input:text').val();
//	console.log(doc); // 2

//	let inputs = $('input:text');
//	console.log(inputs.length); // 2
//	console.log(inputs);
//	console.log(inputs.value); // undefined
//	console.log(inputs[0].value);
//	console.log(inputs[1].value);
	
	let text1 = $('input:text').eq(0);
	console.log(text1.value); // undefined
	console.log(text1.val());
	let text2 = $('input:text').eq(1);
	console.log(text2.value); // undefined
	console.log(text2.val());
	$('input:text').eq(1).val('장길산');
}

function choice2() {
	/*
	let input = document.getElementsByTagName('input')[3];
	console.log(input.value);
	document.getElementById('a').innerHTML = '<h1>' + input.value + '</h1>';
//	document.getElementById('a').innerText = '<h1>' + input.value + '</h1>';
//	document.getElementById('a').textContent = '<h1>' + input.value + '</h1>';
	*/
	
//	let text = $('input:radio').val();
//	let text = $('input:radio').eq(0).val();
	let text = $('input:radio:eq(0)').val();
	console.log(text);
	
//	javascript는 innerHTML나 innerText나 textContent를 사용해서 태그 내부에 텍스트를 넣는다.
//	jquery html() 메소드나 text() 메소드를 사용해서 태그 내부에 텍스트를 넣는다.
//	html() 메소드는 innerHTML 처럼 html 태그를 지원하고 text() 메소드는 지원하지 않는다.
	$('#a').html('<h1>' + text + '</h1>');
//	$('#a').text('<h1>' + text + '</h1>');
}

function choice3() {
	let text = $('input:checkbox:eq(0)').val();
	console.log(text);
	$('#a').html('<h1>' + text + '</h1>');
}

//	1.
//	$(document).ready(function () {
//		alert('$(document).ready(function () {\n\n});');
//	});

//	2.
//	$().ready(function () {
//		alert('$().ready(function () {\n\n});');
//	});

//	3.
//	$().ready(() => {
//		alert('$().ready(() => {\n\n});');
//	});

//	4.
//	$(function () {
//		alert('$(function () {\n\n});');
//	});

//	5.
//	$(() => {
//		alert('$(() => {\n\n});');
//	});

$(() => {
	/*
	let select = document.getElementsByTagName('select')[0];
//	select.onchange = function () { };
	select.onchange = () => {
		// console.log(select.selectedIndex);
		// console.log(select.options);
		// console.log(select.options[select.selectedIndex]);
		// console.log(select.options[select.selectedIndex].value);
		let input = document.getElementsByTagName('input')[0];
		input.value = select.options[select.selectedIndex].value;
	};
	*/
	
//	javascript는 onclick, onchange와 같이 이벤트가 'on'으로 시작하지만 jquery는 앞에 'on'을
//	붙이지 않는다.
//	$('select:eq(0)').change(function () { });
	$('select:eq(0)').change(() => {
		// alert('select 태그의 change 이벤트 실행');
		// option:selected는 option 태그 중에서 선택된 태그를 얻어온다.
		let select = $('select:eq(0) > option:selected').val();
		// console.log(select);
		$('input:text').eq(0).val(select);
	});
	
	$('input[name=gender]').click(() => {
		// alert('radio 버튼에서 click 이벤트 실행');
		let check = $('input[name=gender]:checked').val()
		// console.log(check);
		$('input:text').eq(1).val(check);
	});
})



















