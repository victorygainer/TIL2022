//	'use strict'를 사용하면 선언하지 않은 변수를 사용하면 에러가 발생된다.
'use strict'; // ECMA Script 5에서 추가

console.log('Hello World');

//	자바스크립트는 변수를 선언할 때 앞에 자료형을 쓰지 않는다.
//	변수에 대입되는 데이터의 형태에 따라 자동으로 변수의 자료형이 결정된다.
//	int a = 0; // 에러 발생
// var a = 0; // ECMA Script 5
// let a = 0; // ECMA Script 6에 등장
const a = 0; // ECMA Script 6에 등장
console.log('a: ' + a);

var b = '홍길동';
console.log('b: ' + b);
b = 100;
console.log('b: ' + b);
