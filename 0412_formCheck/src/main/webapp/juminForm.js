//	이벤트가 실행되는 객체에 최대 글자수 만큼 문자가 입력되면 포커스를 넘겨줄 객체로 포커스를 넘겨주는 함수
//	moveNext(이벤트가 실행되는 객체, 최대 글자수, 포커스를 넘겨줄 객체)
function moveNext(obj, len, nextObj) {
//	console.log(obj.value);
	if (obj.value.length == len) {
		nextObj.focus();
	}
}

//	인수로 넘어온 form의 유효성을 검사하고 정상이면 true를 리턴하고 오류가 발생되면 오류 메시지를 출력하고
//	false를 리턴하는 함수
function formCheck(obj) {
//	alert(obj);
//	obj로 this(form)가 넘어오므로 obj에는 document.juminForm이 저장된다.
	
//	주민등록번호 앞 자리에 아무것도 입력되지 않았나 검사해서 입력되지 않았으면 메시지를 출력하고 flase를
//	리턴시킨다.
//	console.log(obj.j1.value);
//	if (!obj.j1.value || obj.j1.value.trim().length == 0) {
	if (!obj.j1.value.trim()) {
		alert('주민등록번호 앞 자리를 입력하세요!!!');
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}

//	주민등록번호 앞 자리에 6글자가 입력되었나 검사해서 입력되지 않았으면 메시지를 출력하고 flase를
//	리턴시킨다.
	if (obj.j1.value.trim().length != 6) {
		alert('주민등록번호 앞 자리는 6글자를 입력하세요!!!');
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}

//	주민등록번호 앞 자리에 숫자만 입력되었나 검사해서 숫자만 입력되지 않았으면 메시지를 출력하고 false를
//	리턴시킨다.
//	Number(): 인수로 지정된 문자열을 숫자로 변환한다.
//	parseInt(): 인수로 지정된 문자열을 정수로 변환한다.
//	isNaN(): Not a Number, 인수로 지정된 데이터가 숫자가 아니면 true, 숫자면 false를 리턴한다.
//	if (isNaN(Number(obj.j1.value.trim()))) {
	if (isNaN(obj.j1.value.trim())) {
		alert('주민등록번호 앞 자리는 숫자만 입력하세요!!!');
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}

//	주민등록번호 뒷자리를 검사한다.
	if (!obj.j2.value.trim()) {
		alert('주민등록번호 뒷 자리를 입력하세요!!!');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	if (obj.j2.value.trim().length != 7) {
		alert('주민등록번호 뒷 자리는 7글자를 입력하세요!!!');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	if (isNaN(obj.j2.value.trim())) {
		alert('주민등록번호 뒷 자리는 숫자만 입력하세요!!!');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	
//	여기까지 왔다면 주민등록번호가 13자리의 숫자로 입력되었다는 의미이다. => 주민등록번호 유효성 검사
//	주민등록번호 유효성을 검사하기 위해 따로 입력된 주민등록번호를 하나로 이어준다.
	let jumin = obj.j1.value.trim() + obj.j2.value.trim();
//	문자열을 숫자로 덧셈을 하려면 Number() 함수를 사용해서 숫자로 변환한 다음 연산해야 한다.
//	뺄셈, 곱셈, 나눗셈, 나머지 연산은 숫자와 문자를 연산해도 숫자로 바꿔 연산한다.
//	let jumin = Number(obj.j1.value.trim()) + Number(obj.j2.value.trim());
//	console.log(jumin);
	
//	주민등록번호 유효성을 검사한다.
//	가중치 => 234567892345, 둘리 주민등록번호 => 8304221185600 => 가중치와 곱해서 더하면 143
//	const check = '234567892345';
	let sum = 0;
	for (let i=0; i<12; i++) {
		// sum += jumin.charAt(i) * check.charAt(i);
		// sum += jumin.charAt(i) * (i < 8 ? i + 2 : i - 6);
		sum += jumin.charAt(i) * (i % 8 + 2);
	}
//	console.log(sum);

//	sum에 저장된 값을 11로 나눈 나머지를 11에서 뺀 결과가 주민등록번호의 마지막 자리와 같아야 한다.
//	11로 나눈 나머지를 11에서 뺀 결과가 10이상일 경우 10의 자리는 버리고 10으로 나눈 나머지와
//	주민등록번호의 마지막 자리와 비교한다.
	let result = (11 - sum % 11) % 10;
	
	if (result != jumin.charAt(12)) {
		alert('잘못된 주민등록번호 입니다.');
		obj.j1.value = '';
		obj.j2.value = '';
		obj.j1.focus();
		return false;
	}
	
//	모든 유효성 검사를 무사히 통과하면 마지막에 true를 리턴시킨다.
	return true;
}
