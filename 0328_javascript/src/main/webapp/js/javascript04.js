// 함수
// function 함수이름([인수, ...]) {
//     함수가 실행할 문장;
//     ...;
//     [return 값;]	
// }

function printHello() {
	console.log('Hello');
}

printHello();
console.log('==============================================');

// 자바스크립트는 함수의 인수 개수가 달라도 상관없다.
// 함수의 오버로딩을 지원하지 않습니다.
function log(message) {
	console.log(message);
}

log();
log('Hi~~~~~');
log(1, 2);
console.log('==============================================');

// 함수의 인수로 객체를 받을 수 있다.
function setName(obj) {
	obj.name = '임꺽정';
}

const hong = {
	name: '홍길동',
	age: 20
};
console.log(hong);
console.log(hong.name);
console.log(hong.age);
setName(hong);
console.log(hong);
console.log('==============================================');

// 디폴트 인수 => ES6 추가
// 인수가 넘어오면 넘어온 값으로 함수를 실행하지만 인수가 넘어오지 않으면 undefined로 처리된다.
// ES5
/*
function showMessage(message, from) {
	if (from == undefined) {
		from = '수신인 없음';
	}
	console.log(`ES5: ${message} by ${from}`);
}
*/

// ES6
// 디폴트 인수는 기본값을 가지는 인수를 말한다.
// from에 데이터가 넘어오면 넘어온 데이터로 함수를 실행하고 데이터가 넘어오지 않으면 디폴트 인수로
// 지정된 '수신인 없음'으로 처리한다.
function showMessage(message, from = '수신인 없음') {
	console.log(`ES5: ${message} by ${from}`);
}

showMessage('Hi!');
showMessage('Hi!', 'Hong');
console.log('==============================================');

// rest => 가변 인자 => ES6
// 가변 인자는 "..."을 앞에 붙여서 선언하고 배열로 만들어진다.
function printAll(...args) {
	// console.log(typeof args);
	// length는 배열의 크기를 얻어온다.
	console.log('배열의 크기: ' + args.length);
	console.log('배열에 저장된 값: ' + args);
	// 일반 for
	for (let i=0; i<args.length; i++) {
		console.log(args[i]);
	}
	console.log('##############################################');
	
	// 향상된 for
	// 향상된 for는 배열의 첫 번째 인덱스의 값을 변수에 넣고 반복을 시작하고 마지막 값을 변수에
	// 넣고 반복한 후 종료된다.
	// for (변수명 of 배열명) {
	//     반복할 문장;
	//     ...;
	// }
	for (const arg of args) {
		console.log(arg);
	}
}

printAll('홍길동');
printAll('홍길동', '임꺽정');
printAll('홍길동', '임꺽정', '장길산');
printAll('홍길동', '임꺽정', '장길산', '일지매');
console.log('==============================================');

// 익명 함수 => 함수의 이름이 없는 함수
// 자바스크립트는 변수에 함수를 할당할 수 있으므로 익명으로 만든 함수는 변수에 할당해서 사용(실행)한다.
const print = function () {
	console.log('print');
}

print(); // 변수가 함수처럼 사용된다.

const printAgain = print;
printAgain();

// 변수에 꼭 익명 함수만 할당되는게 아니고 일반 함수도 할당할 수 있다.
function sum(a, b) {
	return a + b;
}

console.log(sum(5, 8));
const sumAgain = sum; // 변수에 일반함수 할당
console.log(sumAgain(5, 8));
console.log('==============================================');

// callback 함수
// 콜백 함수는 코드를 통해 명시적으로 호출하는 함수가 아니라, 개발자는 단지 함수를 등록하기만 하고.
// 어떤 이벤트가 발생했거나 특정 시점에 도달했을 때 시스템에서 호출(자동으로 실행)하는 함수를 말한다.
// 익명 함수가 콜백을 구현할 때 주로 사용된다.

// printYes, printNo 함수를 콜백으로 등록한다.
const printYes = function () {
	console.log('Yes!');
}

const printNo = function () {
	console.log('No!');
}

// randomQuiz(답, 정답일 때 실행할 함수, 오답일 때 실행할 함수)
function randomQuiz(answer, printYes, printNo) {
	if (answer == '사랑해') {
		printYes();
	} else {
		printNo();
	}
}

randomQuiz('미워해', printYes, printNo);
randomQuiz('사랑해', printYes, printNo);
console.log('==============================================');

// 화살표(arrow) 함수 => ES6 추가
// 일반 익명 함수
const simplePrint1 = function () {
	console.log('일반 익명 함수 simplePrint1');
}
simplePrint1();

// 화살표 함수
const simplePrint2 = () => {
	console.log('화살표 함수 simplePrint2');
}
simplePrint2();

// 화살표 함수가 실행할 문장이 1줄일 경우 {}를 생략할 수 있다.
const simplePrint3 = () => console.log('화살표 함수 simplePrint3');
simplePrint3();
console.log('==============================================');

const whoAreYou1 = function (name) {
	console.log(name + '님 안녕하세요');
}
whoAreYou1('홍길동');

const whoAreYou2 = (name) => {
	console.log(name + '님 안녕하세요');
}
whoAreYou2('임꺽정');

const whoAreYou3 = (name) => console.log(name + '님 안녕하세요');
whoAreYou3('장길산');

// 함수의 인수가 1개면 ()를 생략할 수 있다.
const whoAreYou4 = name => console.log(name + '님 안녕하세요');
whoAreYou4('일지매');

// 함수가 실행할 문장이 return 1문장만 있을 경우 {}를 생략하면 return도 생략해야 한다.
const whoAreYou5 = name => name + '님 안녕하세요';
console.log('return: ' + whoAreYou5('손오공'));
console.log('==============================================');

function add1(a, b) {
	return a + b;
}
console.log(add1(5, 8));

const add2 = (a, b) => {
	return a + b;
}
console.log(add2(14, 8));

const add3 = (a, b) => a + b;
console.log(add3(7, 8));
console.log('==============================================');

// 자동 실행 함수
// 자동으로 실행할 함수 전체를 ()에 묶고 ')'뒤에 ()를 붙이면 된다.
(function hello() {
	console.log('자동실행');
})();
// hello(); // 에러, 자동 실행 함수는 일반 함수처럼 실행하면 에러가 발생된다. 









