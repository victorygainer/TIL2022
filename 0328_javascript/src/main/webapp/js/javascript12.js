//	클래스
class Food {
//	생성자 => 객체가 생성될 때 멤버 변수를 선언하고 초기화 한다.
	constructor(name) {
		this.name = name;
		this.brands = [];
	}
//	멤버 함수(메소드)를 선언한다. => 앞에 function을 붙이지 않는다.
	addBrands(brand) {
		this.brands.push(brand);
	}
	print() {
		console.log(`${this.name}을(를) 파는 음식점들 ` + this.brands.join(', '));
	}
}

const pizza = new Food('피자');
pizza.addBrands('피자헛');
pizza.addBrands('미스터 피자');
pizza.addBrands('도미노 피자');
pizza.addBrands('피자스쿨');
pizza.print();

const chicken = new Food('치킨');
chicken.addBrands('굽네치킨');
chicken.addBrands('네네치킨');
chicken.addBrands('교촌치킨');
chicken.print();
console.log('=================================================');

//	부모 클래스
class Animal {
	constructor(type, name, sound) {
		this.type = type;
		this.name = name;
		this.sound = sound;
	}
//	클래스 멤버 함수를 선언하면 자동으로 클래스의 prototype에 등록된다.
	say() {
		console.log('부모의 say() 함수 실행 ' + this.sound);
	}
}
console.log(Animal.prototype.say);

const dog = new Animal('개', '멍멍이', '멍멍');
const cat = new Animal('고양이', '야옹이', '야옹');

dog.say();
cat.say();
console.log('=================================================');

//	상속 => extends를 사용한다.
class Dog extends Animal {
	constructor(name, sound, age) {
		// Animal.call(this, '개', name, sound);
		// 부모 클래스에서 상속받은 멤버 변수를 호출하기 위해 부모 클래스의 생성자를 호출한다.
		super('개', name, sound);
		this.age = age;
	}
}

class Cat extends Animal {
	constructor(name, sound, age) {
		super('고양이', name, sound);
		this.age = age;
	}
//	오버라이드
	say() {
		console.log(this.age + '살 짜리 고양이가 ' + this.sound + '합니다.');
	}
}

const dog2 = new Dog('멍멍이', '멍멍', 2);
const cat2 = new Cat('야옹이', '야옹', 10);

dog2.say();
cat2.say();













