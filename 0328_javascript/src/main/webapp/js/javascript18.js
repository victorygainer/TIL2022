function func1() {
	alert('명시적 함수');
}

/*
var func2 = function () {
	alert('익명 함수');
}
*/
var func2 = () => alert('익명 함수');

//	함수 리터럴: 함수의 인수로 익명 함수를 전달하는 함수
function func3() {
//	literalTest() 함수를 호출할 때 함수의 인수로 익명 함수를 전달한다.
	literalTest(
		function (msg) {
			alert(msg);
		}
	);
}

function literalTest(literal) {
	literal('함수 리터럴 입니다.');
}

//	자바스크립트 함수는 실인수와 가인수의 개수가 다르더라도 정상적으로 실행된다. => 함수 오버로딩은 지원하지 않는다.
//	함수가 호출될 때 넘어오는 인수를 저장할 변수가 모자라면 모자라는 대로 남으면 남는대로 실행된다.
//	자바스크립트의 함수가 호출될 때 전달되는 인수는 arguments 객체로 먼저 전달되고 arguments 객체에 저장된 인수
//	목록에서 가인수의 개수만큼 반복하며 arguments 객체에 저장된 데이터를 꺼내서 넣어준다.
function varTest() {
	console.log('함수가 호출될 때 전달되는 데이터 개수: ' + arguments.length);
	for (var i=0; i<arguments.length; i++) {
		console.log('arguments[' + i + '] = ' + arguments[i]);
	}
}

//	클로저: 함수가 생성될 당시 모든 변수를 기억해두었다가 함수가 호출될 때 사용한다.
//	참조할 수 없는 위치에 있어도 사용이 가능하다.
function closureTest(value) {
	console.log('value: ' + value);
	var a = 100;
//	내부 함수
	function addValue(msg) {
		console.log('msg: ' + msg);
		console.log('a: ' + a);
	}
//	반드시 클로저 내부에서 정의한 함수를 리턴시켜 한다.
	return addValue;
}

//	html 페이지가 로딩된 후 closureTest() 함수가 바로 실행된다.
let goodEdu = closureTest('자바스크립트');
//	closureTest() 함수가 실행된 후 내부 함수를 리턴시키므로 closureTest() 함수가 실행된 곳으로 내부 함수
//	addValue()가 리턴되므로 내부적으로 
//	goodEdu = addValue(msg) {
//	    console.log('msg: ' + msg);
//  	console.log('a: ' + a);
//	} 와 같이 된다.
//	리턴된 addValue() 함수가 goodEdu 라는 변수에 할당되고 함수가 할당된 변수를 함수처럼 사용할 수 있으므로
//	goodEdu(msg) 형태로 실행이 가능하다.











