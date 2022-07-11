function numberObject() {
//	Number 객체 생성 방법
	let num1 = new Number(5); // new를 사용해 Number 객체 선언
	console.log('num1: ' + num1);
	console.log(typeof num1);
	let num2 = 5; // 숫자 리터럴을 입력해서 Number 객체 선언
	console.log('num2: ' + num2);
	console.log(typeof num2);
	
	console.log('num 1 + num2 = ' + (num1 + num2));
//	document.write(): 인수로 지정한 내용을 브라우저의 내용을 전부 지우고 출력한다.
//	document.write('<b><i><marquee>num 1 + num2 = ' + (num1 + num2) + '</marquee></i></b>');
//	document.write('메롱');

	const divs = document.querySelectorAll('div');
	divs[0].innerHTML = '<b><i><marquee>num 1 + num2 = ' + (num1 + num2) + '</marquee></i></b>';
//	parseInt(): 문자열이나 실수를 정수를 변환한다.
//	divs[1].innerHTML = '100' + 5; // 1005
	divs[1].innerHTML = parseInt('100') + 5;
//	'100a'와 같이 숫자로 시작하고 정수로 변환할 수 없는 문자열이 뒤에 나오면 변환할 수 있는 위치까지
//	정수로 변환한다.
	divs[2].innerHTML = parseInt('100a') + 5;
//	'a100'과 같이 정수로 변환할 수 없는 문자열이 맨 앞에 나오면 정수로 변환할 수 있는 숫자가 아니므로
//	NaN을 리턴한다.
	divs[3].innerHTML = parseInt('a100') + 5;
	divs[4].innerHTML = parseInt(3.14) + 5;
	divs[5].innerHTML = parseInt('3.14') + 5;
	divs[6].innerHTML = parseInt('3.14a') + 5;
	divs[7].innerHTML = parseInt('a3.14') + 5;
	divs[8].innerHTML = Number.MAX_VALUE + 0.0000001e+308; // Infinity
	divs[9].innerHTML = 10 / 0 + ''; // Infinity
}




















