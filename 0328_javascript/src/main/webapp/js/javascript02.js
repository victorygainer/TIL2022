// 변수(variable)
'use strict' // 변수가 var, let, const로 선언되지 않으면 에러를 발생시킨다.

// var를 사용해서 선언한 변수는 프로그램 어디어서 선언하던 항상 맨 위로 끌어올려진다.
// age 변수가 hoisting 되서 변수를 선언하는 문장 이전에도 사용이 가능하다.
// 변수가 선언만 되고 값이 할당되지 않았으므로 undefined가 출력된다.
// var age;
console.log('age =  ' + age); // undefined

// var
// variable hoisting => 아래에 var로 선언한 변수를 맨 위로 끌어올린다.
// 어디에 선언했냐에 상관없이 항상 제일 위로 변수 선언을 끌어올리는 것
// var는 block scope를 사용하지 않고 function scope를 사용한다. => 유연성
// block scope => 변수가 선언된 {} 블록 내부에서만 사용할 수 있다. => let, const
// function scope => 변수가 선언된 함수의 {} 블록 내부에서만 사용할 수 있다. => var
// block scope는 변수가 선언된 {} 밖으로 나가면 소멸되고 function scope는 변수가 선언된 함수가 
// 종료되면 소멸된다.
console.log('age =  ' + age);
var age = 100;
console.log('age =  ' + age);
var age = '열살'; // var는 같은 이름의 변수를 선언할 수 있다.
console.log('age =  ' + age);
console.log('=======================================================');

// let => ES6에서 추가
// block scope => {} 내부의 내용은 {} 외부에서 접근할 수 없다.
// 글로벌(전역) 변수는 {} 내부 {} 외부 모두 사용이 가능하다.
let globalName = '장길산';
{
	let name = '홍길동';
	console.log('name =  ' + name);
	// let name = '임꺽정'; // 에러, let은 같은 이름의 변수를 선언할 수 없다.
	name = '임꺽정';
	console.log('name =  ' + name);
	console.log('globalName =  ' + globalName);
}
console.log('name =  ' + name); // 아무런 값도 출력되지 않는다.
console.log('globalName =  ' + globalName);
console.log('=======================================================');

// variable type
// primitive type(기본 자료형, 원시 자료형): number, string, boolean, null, undefined, symbol(ES6)
// object(객체), box container
// function => 변수에 할당가능, 함수의 인수로 전달가능, 리턴가능 => 일급함수

// 상수(constant)
// 값을 할당한 다음 값을 변경할 수 없는 데이터 타입, 보안성
const maxNumber = 10; // 상수는 최초 선언시 값을 할당해야 한다.
// maxNumber = 100; // 에러, 상수로 선언된 변수에 값을 할당하려 했으므로 에러가 발생된다.

const count = 17.5;
const size = true;
// template => `(그레이브)를 사용한다. => ${ ~ } 사이에 출력한다.
// typeof 명령으로 변수의 자료형을 확인할 수 있다.
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);

const infinity = 1 / 0;
console.log(`value: ${infinity}, type: ${typeof infinity}`);
const negativeinfinity = -1 / 0;
console.log(`value: ${negativeinfinity}, type: ${typeof negativeinfinity}`);
const nan = 'Not A Number' / 2;
console.log(`value: ${nan}, type: ${typeof nan}`);
console.log('=======================================================');

// symbol => 고유한 식별자를 만들 때 사용한다.
const symbol1 = Symbol('id')
console.log(`type: ${typeof symbol1}`);
const symbol2 = Symbol('id')
console.log(`type: ${typeof symbol2}`);
console.log(symbol1 == symbol2);
console.log('=======================================================');

// dynamic typing(동적 자료형) => 변수에 저장되는 데이터의 타입에 맞춰 변수의 타입이 결정된다.
let text = 'hello';
console.log(`value: ${text}, type: ${typeof text}`);
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
console.log('=======================================================');

// object(객체)
const obj = {
	name: '홍길동',
	age: 20
};
console.log(obj);
console.log(obj.name);
console.log(obj.age);
obj.age = 21;
console.log(obj);
console.log(typeof obj);

const obj2 = {
	"name": '홍길동',
	"age": 20
};
console.log(obj2);
console.log(typeof obj);

