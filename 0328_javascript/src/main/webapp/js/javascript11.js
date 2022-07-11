//	클래스
function Animal1(type, name, sound) {
//	멤버 변수 초기화
	this.type = type;
	this.name = name;
	this.sound = sound;
//	멤버 함수
//	함수를 클래스 내부에서 선언하면 클래스의 객체가 생성될 때 마다 함수가 만들어진다.
	this.say = function () {
		console.log(this.sound);
	};
}

const dog1 = new Animal1('개', '멍멍이', '멍멍');
const cat1 = new Animal1('고양이', '야옹이', '야옹');

dog1.say();
cat1.say();
console.log('1. ==============================================');

function Animal2(type, name, sound) {
	this.type = type;
	this.name = name;
	this.sound = sound;
//	함수를 클래스 내부에서 선언하면 클래스의 객체가 생성될 때 마다 함수가 만들어진다.
}

//	함수를 클래스 내부에서 선언하면 객체가 생성될 때 마다 같은 함수가 만들어지므로
//	prototype으로 함수를 선언하면 객체가 생성될 때 마다 같음 함수가 반복적으로 생성되지 않는다.
Animal2.prototype.say = function () {
	console.log(this.sound);
};

const dog2 = new Animal2('개', '멍멍이', '멍멍');
const cat2 = new Animal2('고양이', '야옹이', '야옹');

dog2.say();
cat2.say();
console.log('2. ==============================================');

function Animal3(type, name, sound) {
	this.type = type;
	this.name = name;
	this.sound = sound;
}

const dog3 = new Animal3('개', '멍멍이', '멍멍');
const cat3 = new Animal3('고양이', '야옹이', '야옹');

//	prototype으로 함수를 선언하지 않으면 함수를 외부에서 만들어서 각각의 객체에 넣어줘야 한다.
function say() {
	console.log(this.sound);
}

dog3.say = say; // 함수 이름 뒤에 ()를 쓰지 않는다.
cat3.say = say;

dog3.say();
cat3.say();
console.log('3. ==============================================');

//	상속
function Animal4(type, name, sound) { // 부모 클래스
	this.type = type;
	this.name = name;
	this.sound = sound;
}

//	부모 클래스의 protptype에 say() 함수를 추가한다.
Animal4.prototype.say = function () {
	console.log(this.sound);
};

//	Animal4(부모) 클래스를 상속받는 Dog(자식) 클래스를 정의한다.
function Dog(name, sound) {
//	부모 클래스 Animal4를 호출해서 자식 클래스를 초기화 할 데이터를 전달한다.
	Animal4.call(this, '개', name, sound);
}

//	Animal4(부모) 클래스를 상속받는 Cat(자식) 클래스를 정의한다.
function Cat(name, sound) {
//	부모 클래스 Animal4를 호출해서 자식 클래스를 초기화 할 데이터를 전달한다.
	Animal4.call(this, '고양이', name, sound);
}

//	부모 클래스의 protptype을 자식 클래스의 prototype에 넣어준다. => 상속시킨다.
//	자식 클래스를 선언하고 객체를 생성하기 전에 실행해야 한다. 위치가 중요...
Dog.prototype = Animal4.prototype;
Cat.prototype = Animal4.prototype;

const dog4 = new Dog('몽몽이', '몽몽');
console.log(dog4);
console.log(dog4.type);
console.log(dog4.name);
console.log(dog4.sound);
dog4.say();

const cat4 = new Cat('어흥이', '어흥');
console.log(cat4);
console.log(cat4.type);
console.log(cat4.name);
console.log(cat4.sound);
cat4.say();
