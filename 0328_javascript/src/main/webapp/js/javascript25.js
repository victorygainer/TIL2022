function numTest(num) {
	console.log(num);
	console.log(typeof num); // string
	console.log('123' + num); // 문자열 + 문자열 => 문자열 연결
	console.log(123 + num); // 숫자 + 문자열 => 문자열 연결
	console.log(num + 123); // 문자열 + 숫자 => 문자열 연결
//	덧셈을 제외한 나머지 연산은 문자열과 숫자를 연산해도 결과가 숫자로 처리된다.
	console.log(num - 123);
	console.log(num * 123);
	console.log(num / 123);
	console.log(num % 123);
//	자바스크립트는 문자열과 문자열, 문자열과 숫자, 숫자와 문자열의 덧셈은 모두 문자열로 처리되므로
//	덧셈 연산을 하기 위해서는 숫자로 변환한 후 연산해야 한다.
//	Number() 함수는 인수로 지정된 문자열을 숫자로 바꿔준다. => 정수, 실수는 구분하지 않는다.
	console.log(Number('123') + Number(num));
	console.log(Number('3.14') + Number(num));
}

function intTest(num) {
	console.log(parseInt(num) + 100);
}

function floatTest(num) {
	console.log(parseFloat(num) + 100);
}







