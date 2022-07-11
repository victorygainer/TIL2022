//	변수 선언 방법
//	var는 변수 선언 방식에 있어서 큰 단점을 가지고 있다.
var name = 'hong'; // 변수 선언
console.log('name: ' + name);

//	같은 이름으로 변소를 다시 선언했음에도 불구하고 에러가 발생되지 않고 각기 다른 값이 출력되는 것을 
//	볼 수 있다.
var name = 'javascript';
console.log('name: ' + name);

//	이 방식은 유연한 변수 선언으로 간단한 테스트에는 편리할 수 있으나 코드의 양이 많아진다면 어디에서
//	어떻게 사용될지 파악하기 힘들고 변수에 저장된 값이 변경될 우려가 있다.
//	그래서 ES6 이후 이를 보완하기 위해서 추가된 변수 선언 방식이 let과 const 이다.

let id = 'lim'; // 변수 선언
console.log('id: ' + id);
//	id라는 변수가 이미 선언된 상태이므로 콘솔에 아래와 같은 에러 메시지가 출력되며 프로그램이 중지된다.
//	Uncaught SyntaxError: Identifier 'id' has already been declared
//	let id = 'jang'; // 이미 선언한 변수를 같은 이름으로 다시 선언하면 에러가 발생된다.
id = 'jang'; // 변수에 값 할당
console.log('id: ' + id);

const test = 'test'; // 상수 선언
console.log('test: ' + test);
//	let 뿐만 아니라 const를 사용해서 변수를 선언해도 같은 이름의 변수를 선언하면 변수가 이미 선언되었다는
//	에러 메시지가 출력된다.
//	const test = 'test'; // 이미 선언한 변수를 같은 이름으로 다시 선언하면 에러가 발생된다.
//	test는 상수이므로 상수에 값을 할당하면 아래와 같은 에러 메시지가 출력되며 프로그램이 중지된다.
//	Uncaught TypeError: Assignment to constant variable.
//	test = 'check'; // 상수에 값을 할당하려 했으므로 에러가 발생된다.

//	let과 const는 변수 재선언이 되지 않는다는 공통점이 있다.
//	차이점은 let은 선언된 변수에 데이터를 재할당이 가능하지만 const는 선언시 할당된 데이터를 프로그램
//	중간에서 재할당 할 수 없다.
console.log('==============================================');

//	전역 변수: 함수 외부에서 선언한 변수로 스크립트의 모든 함수에서 공통적으로 변수에 저장된 데이터를
//	           사용할 수 있다. => var를 붙이지 않고 변수를 선언하면 전역 변수로 인식한다.
//	지역 변수: 함수 내부에서 선언한 변수로 선언된 함수 내부(var) 또는 {} 블록 내부(let, const)에서만
//	           변수에 저장된 값을 사용할 수 있다.
//	전역 변수와 같은 이름의 지역 변수를 사용해야 한다면 지역 변수를 선언할 때 반드시 var를 붙여서
//	선언해야 한다.

var variable = 10; // 전역 변수
function scopeTest() {
//	alert('scopeTest() 함수 실행');
//	console.log('scopeTest() 함수 실행');
	var a = 0; // 지역 변수
	if (true) {
		console.log('scopeTest() 함수 블록 a: ' + a);
		var b = 5; // 지역 변수
		console.log('if 블록 b: ' + b);
		let c = 100; // 지역 변수
		console.log('if 블록 c: ' + c);
		// 호이스팅에 의해서 i라는 변수가 선언은 되었지만 값이 할당되지 않았다.
		console.log('for 블록 외부 i: ' + i); // undefined
		for (var i=0; i<5; i++) {
			console.log('for 블록 내부 i: ' + i);
		}
	}
	console.log('scopeTest() 함수 블록 a: ' + a);
	// var로 선언한 변수는 function scope 이므로 선언된 함수 내부에서 자유롭게 사용할 수 있다.
	console.log('if 블록 b: ' + b);
	// let과 const는 block scope 이므로 변수가 선언된 {} 블록 외부에서 사용할 수 없다.
	// console.log('if 블록 c: ' + c); // 에러
	console.log('scopeTest() 함수 외부 variable 함수가 실행되야 출력: ' + variable);
	variable = 999; // 전역 변수에 값 할당
	console.log('scopeTest() 함수 외부 variable 함수가 실행되야 출력: ' + variable);
	// 아래 주석으로 처리한 문장이 실행되면 전역 변수와 같은 이름의 지역 변수 variable이 생성된다.
	// 함수 내부에서 전역 변수는 사용할 수 없고 variable이라는 지역 변수가 사용된다.
	// var variable = 777;
	console.log(variable);
}
console.log('scopeTest() 함수 외부 variable 자동 출력: ' + variable);

function test1() {
	variable += 5;
//	console.log(variable);
//	getElementById(): html 문서에서 인수로 지정된 id 속성을 가지는 객체(태그)를 얻어온다.
//	alert(window.document.getElementById('var1'));
//	console.log(window.document.getElementById('var1'));

//	innerHTML: getElementById() 함수로 얻어온 태그 내부의 텍스트를 의미한다. html 태그 구현 가능
//	window.document.getElementById('var1').innerHTML = '꺄~~~~~';
//	맨 앞의 자바스크립트의 최상위 객체를 의미하는 window는 생략할 수 있다.
//	document.getElementById('var1').innerHTML = variable;
	document.getElementById('var1').innerHTML = '<b style="color: red; background-color: yellow;">' + variable + '</b>';
	
//	innerText: getElementById() 함수로 얻어온 태그 내부의 텍스트를 의미한다. html 태그 구현 불가능
//	document.getElementById('var1').innerText = '<b style="color: red; background-color: yellow;">' + variable + '</b>';
}

function test2() {
	console.log(variable);
//	함수 내부에서 전역 변수와 같은 이름의 지역 변수를 선언하면 지역 변수에 우선권이 있다.
//	함수 내부에서 아래와 같이 var를 사용해서 전역 변수와 같은 이름의 지역 변수를 선언하면 함수 내부의 variable 이라는
//	이름을 가지는 지역 변수로 되지만 var를 사용하지 않았으면 전역 변수를 의미한다.
//	지역 변수가 선언되기 전에 지역 변수를 사용하면 undefined가 출력된다.
	var variable = 5;
	console.log(variable);
}

function test3() {
	var variable2 = variable + 3;
//	console.log(variable2);
	document.getElementById('var2').innerHTML = '<b style="color: red; background-color: yellow;">' + variable2 + '</b>';
}

function test4() {
	var variable3 = '문자열';
	console.log(typeof variable3); // string
	variable3 = 5;
	console.log(typeof variable3); // number
	variable3 = 5.5;
	console.log(typeof variable3); // number
	variable3 = true;
	console.log(typeof variable3); // boolean
	variable3 = null;
	console.log(typeof variable3); // object, null도 객체로 취급한다.
	variable3 = [1, 2, 3, 4, 5];
	console.log(typeof variable3); // object
	variable3 = {name: '홍길동'};
	console.log(typeof variable3); // object
	
	variable3 = function (name) {
		console.log(name + '님 안녕하세요');
	};
	console.log(typeof variable3); // function
	
	const variable4 = name => name + '님 안녕하세요';
	console.log(typeof variable4); // function
	
//	익명 함수 실행하기 => 함수를 할당한 변수 이름을 함수명 처럼 사용한다.
	variable3('홍길동');
	console.log(variable4('임꺽정'));
}














