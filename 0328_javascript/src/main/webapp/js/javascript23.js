//	객체 선언 => function 사용
function Clazz1(name) {
//	객체를 구성하는 멤버를 선언할 때 앞에 this를 붙여주면 객체 외부에서 접근이 가능(public)하다.
	this.name = name;
//	객체를 구성하는 멤버를 선언할 때 앞에 this를 붙이지 않으면 객체 외부에서 접근이 불가능(private)하다.
	age = 20;
//	age에 저장된 데이터를 리턴하는 함수(java의 getter) 익명으로 만든다.
	this.getAge = function () {
		return age;
	}
}

function objectFunction() {
//	function을 사용해서 선언한 객체는 new를 사용해서 만든다.
	const obj1 = new Clazz1('홍길동');
	console.log(obj1);
//	객체의 멤버에 접근은 객체 이름에 '.'을 찍어 접근한다.
	console.log(obj1.name);
	console.log(obj1.age);
	console.log(obj1.getAge());
}

//	객체 선언 => class 사용
class Clazz2 {
	constructor(name) {
		this.name = name;
		this.age = 30;
	}
	getAge() {
		return this.age;
	}
}

function objectClass() {
//	class를 사용해서 선언한 객체도 new를 사용해서 만든다.
	const obj2 = new Clazz2('임꺽정');
	console.log(obj2);
	console.log(obj2.name);
	console.log(obj2.age);
	console.log(obj2.getAge());	
}

//	객체 선언 => json => key 부분을 반드시 큰따옴표로 묶어야 한다.
const Clazz3 = {
	"name": '장길산',
	"age": 55,
	"getAge": function () {
		// 함수 내부에서 json 형식을 사용한 객체의 key를 참조하려면 반드시 객체 이름에 '.'을
		// 찍어서 접근해야 한다.
		return Clazz3.age;
	}
}

function objectJSON() {
//	function이나 class를 사용해서 선언한 객체는 new를 사용해서 객체를 생성하고 사용한다.
	let class1 = new Clazz1('홍길동');
	console.log('class1.name: ' + class1.name);
	console.log('class1.age: ' + class1.age);
	console.log('class1.age: ' + class1.getAge());
	console.log('========================================');
	
	let class2 = new Clazz2('임꺽정');
	console.log('class2.name: ' + class2.name);
	console.log('class2.age: ' + class2.age);
	console.log('class2.age: ' + class2.getAge());
	console.log('========================================');
	
//	json을 사용한 객체는 new를 사용해서 객체를 생성하지 않고 '.'을 찍어서 바로 접근할 수 있다.
	console.log('Clazz3.name: ' + Clazz3.name);
	console.log('Clazz3.age: ' + Clazz3.age);
	console.log('Clazz3.age: ' + Clazz3.getAge());
	console.log('========================================');
	
//	json을 가장한 문자열 => key 부분은 반드시 문자열로 만든다.
	let myJson = '{"name": "일지매", "age": 41}';
	console.log(typeof myJson);
	console.log(myJson);
	console.log('========================================');
	
//	JSON.parse(): 인수로 지정된 json을 가장한 문자열을 json 객체로 변환한다.
	let jsonObj = JSON.parse(myJson);
	console.log(typeof jsonObj);
	console.log(jsonObj);
	console.log(jsonObj.name);
	console.log(jsonObj.age);
	console.log('========================================');
	
//	JSON.stringify(): 인수로 지정된 json 객체를 json을 가장한 문자열로 변환한다.
	let jsonStr = JSON.stringify(jsonObj);
	console.log(typeof jsonStr);
	console.log(jsonStr);
}
















