function strTest1() {
	let str1 = 'string ';
	let str2 = 'function';
	let str3 = str1 + str2;
	console.log(str3);
	
//	concat() 함수를 실행한 문자열에 인수로 지정한 문자열을 합칠 수 있다.
	let newStr = str1.concat(str2);
	console.log(newStr);
	
//	join() 함수를 실행한 배열 요소에 인수로 지정한 문자열을 사이사이에 삽입한다.
	let joinStr = ['java', 'script', 'good'].join('\t');
	console.log(joinStr);
}

function strTest2() {
	let num = 12.34;
	let bool = true;
	let str = '문자열';
//	연산자 우선순위에 의해 num + bool를 먼저 연산한다.
//	boolean 타입의 데이터는 숫자와 연산할 때 true는 1로, false는 0으로 취급되어 연산된다.
	console.log(num + bool + str); // 13.34문자열
//	boolean 타입의 데이터는 문자열과 연산하면 true, false가 문자열로 연결된다.	
	console.log(str + num + bool);
	console.log(num + str + bool);
}

function strTest3() {
	let str = prompt('니 이름이 뭐니?', '숫자는 입력하지 마세요');
	console.log(typeof str); // string
//	isNaN() 함수는 인수로 지정된 값이 숫자가 아니면 true, 숫자면 false를 리턴한다.
//	isNaN() 함수는 인수로 지정된 값 숫자로만 구성된 문자열이면 숫자로 바꿔서 처리한다.
	console.log('aaa' + isNaN(str));
	console.log(isNaN('aaa' + isNaN(str)));
	if (!isNaN(str)) {
		alert('숫자는 입력하지 말라니까~~~~~');
	} else if (str == '홍길동') {
		alert(str + '님 어서오세요');
	} else {
		alert(str + '?? 넌 누구냐?')
	}
	console.log('===============================================');
	
//	==, !=는 데이터만 비교한다. 데이터 타입을 구분하지 않는다. '1'와 1는 같은 값으로 취급된다.
//	===, !==는 데이터와 데이터의 자료형까지 비교한다. '1'와 1는 다른 값으로 취급한다.
	let num = 10;
	console.log(typeof num);
	str = '10';
	console.log(typeof str);
	
	if (num == str) {
		console.log('데이터 타입은 비교하지 않고 데이터만 비교해서 같다.');
	} else {
		console.log('데이터 타입은 비교하지 않고 데이터만 비교해서 다르다.');
	}
	
	if (num === str) {
		console.log('데이터 타입과 데이터를 모두 비교해서 같다.');
	} else {
		console.log('데이터 타입과 데이터를 모두 비교해서 다르다.');
	}
	
	let oldStr = '홍길동';
	let newStr = new String('홍길동');
	
	console.log(typeof oldStr);
	console.log(typeof newStr);
	
	if (oldStr == newStr) {
		console.log('같다');
	} else {
		console.log('다르다');
	}
	
	if (oldStr === newStr) {
		console.log('같다');
	} else {
		console.log('다르다');
	}
}

function strTest4() {
//	indexOf() 함수는 문자열의 왼(앞)쪽 부터 인수로 지정된 문자열을 찾아 index를 리턴한다.
//	lastIndexOf() 함수는 문자열의 오른(뒤)쪽 부터 인수로 지정된 문자열을 찾아 index를 리턴한다.
//	indexOf(), lastIndexOf() 모두 인수로 지정한 문자열이 없으면 -1을 리턴한다.
	let name = '홍길동 임꺽정 장길산 일지매 홍길동';
	let str = prompt('검색할 이름을 입력하세요');
	if (name.indexOf(str) == -1) {
		console.log(str + '이라는 이름은 존재하지 않는 이름입니다.');
	} else {
		console.log('indexOf() 함수로 검색한 index: ' + name.indexOf(str));
		console.log('lastIndexOf() 함수로 검색한 index: ' + name.lastIndexOf(str));
	}
}

function strTest5() {
	let today = '2022-04-04 (월) 2022-03-04';
//	substring(a) 함수는 문자열에서 index가 a인 문자부터 끝까지 추출한다.
//	substring(a, b)	함수는 문자열에서 index가 a인 문자부터 b - 1 번째 문자까지 추출한다.
	console.log(today.substring(11)); // (월) 2022-03-04
	console.log(today.substring(11, 14)); // (월)
//	위의 실행 결과는 ()안의 문자열 개수가 변경되면 원하는 결과를 얻어올 수 없다.
	let start = today.indexOf(' ');
	let end = today.lastIndexOf(' ');
	console.log('start: ' + start + ', end: ' + end);
	console.log(today.substring(start + 1, end));
	let sola = today.substring(0, start);
	let lunar = today.substring(end + 1);
	console.log('양력 ' + sola + '는 음력으로 ' + lunar + ' 입니다.');
}

function strTest6() {
	let today = '2022-04-04 (월) 2022-03-04';
//	split() 함수는 인수로 지정된 구분자를 경계로 문자열을 나눠서 배열로 리턴한다.
	let array = today.split(' ');
	console.log(array);
	console.log('양력 ' + array[0] + '는 음력으로 ' + array[2] + ' 입니다.');
}

















