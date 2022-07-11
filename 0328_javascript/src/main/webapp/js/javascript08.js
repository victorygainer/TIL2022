superheroes = ['아이언맨', '캡틴 아메리카', '토르', '닥터 스트레인지'];

for (let i=0; i<superheroes.length; i++) {
	console.log(superheroes[i]);
}
console.log('1. ============================================');

function print1(hero) {
	console.log(hero);
}

//	forEach(): 인수로 지정된 함수로 배열 요소를 차례대로 전달하며 함수를 반복해서 실행한다.
superheroes.forEach(print1); // 일반함수
console.log('2. ============================================');

const print2 = (hero) => {
	console.log(hero);
}
superheroes.forEach(print2); // 화살표 익명함수
console.log('3. ============================================');

const print3 = hero => console.log(hero);
superheroes.forEach(print3); // 화살표 익명함수, ()와 {} 생략
console.log('4. ============================================');

superheroes.forEach(function (hero) {
	console.log(hero);
}); // forEach() 함수의 인수로 익명함수 입력
console.log('5. ============================================');

superheroes.forEach((hero) => {
	console.log(hero);
}); // forEach() 함수의 인수로 화살표 익명함수 입력
console.log('6. ============================================');

//	forEach() 함수의 인수로 화살표 익명함수 입력, ()와 {} 생략
superheroes.forEach(hero => console.log(hero));
console.log('7. ============================================');

//	기존 배열(array)에 저장된 값을 제곱해서 새 배열(squared)을 만든다.
const array = [1, 2, 3, 4, 5, 6, 7, 8];
const squared = [];

for (let i=0; i<array.length; i++) {
	// squared.push(array[i] * array[i]);
	// squared.push(array[i] ** 2);
	squared.push(Math.pow(array[i], 2));
}
console.log('squared: ' + squared);

const squared2 = [];
function square(n) {
	squared2.push(Math.pow(n, 2));
}
array.forEach(square);
console.log('squared2: ' + squared2);

const squared3 = [];
array.forEach(function (n) {
	squared3.push(Math.pow(n, 2));
});
console.log('squared3: ' + squared3);

const squared4 = [];
array.forEach(n => squared4.push(Math.pow(n, 2)));
console.log('squared4: ' + squared4);
console.log('8. ============================================');

// map(): 배열안의 요소를 특정 작업을 일괄적으로 실행한 후 배열로 리턴한다.
const squared5 = array.map(n => Math.pow(n, 2));
console.log('squared5: ' + squared5);
console.log('9. ============================================');

// 배열 내부의 객체에서 key가 text인 value 값만 얻어와서 새 배열을 만든다.
const items = [
	{
		id: 1,
		text: 'hello',
	},
	{
		id: 2,
		text: 'bye',
	}
];

const text = [];
function textChoice(item) {
	text.push(item.text);
}
items.forEach(textChoice);
console.log('text: ' + text);

const text2 = [];
items.forEach(function (item) {
	text2.push(item.text);
});
console.log('text2: ' + text2);

const text3 = [];
items.forEach(item => text3.push(item.text));
console.log('text3: ' + text3);

const text4 = items.map(item => item.text);
console.log('text4: ' + text4);
console.log('9. ============================================');

// indexOf(): 배열 전체에서 인수로 지정한 요소를 찾아 index를 리턴한다. 없으면 -1을 리턴한다.
const index = superheroes.indexOf('캡틴 아메리카');
console.log(index);
if (index >= 0) {
	console.log('있음');
} else {
	console.log('없음');
}
console.log(index >= 0 ? '있음' : '없음'); // 삼항 연산자
console.log('10. ============================================');

const todos = [
	{
		id: 1,
		test: '자바스크립트 입문',
		done: true,
	},
	{
		id: 2,
		test: '함수',
		done: true,
	},
	{
		id: 3,
		test: '객체와 배열',
		done: true,
	},
	{
		id: 4,
		test: '배열함수',
		done: false,
	}
];

//	findIndex(): 배열에서 인수로 지정된 조건을 만족하는 요소의 인덱스를 리턴한다.
const index2 = todos.findIndex(todo => todo.id == 3);
console.log(index2);
console.log('11. ============================================');

//	find(): 배열에서 인수로 지정된 조건을 만족하는 첫 번째 요소를 리턴한다. 없으면 undefined를 리턴한다.
const todo1 = todos.find(todo => todo.done == false);
console.log(todo1);
const todo2 = todos.find(todo => todo.done == true);
console.log(todo2);
const todo3 = todos.find(todo => todo.done == 'error');
console.log(todo3);
const todo4 = todos.find(todo => todo.done);
console.log(todo4);
const todo5 = todos.find(todo => !todo.done);
console.log(todo5);
console.log('12. ============================================');

//	filter(): 배열에서 인수로 지정된 조건을 만족하는 모든 요소를 배열로 리턴한다.
const done1 = todos.filter(todo => todo.done);
console.log(done1);
const done2 = todos.filter(todo => !todo.done);
console.log(done2);
