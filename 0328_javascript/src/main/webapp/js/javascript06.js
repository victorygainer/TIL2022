const dog = {
	name: '멍멍이',
	sound: '멍멍',
//	객체의 멤버로 함수를 가질 수 있다.
	/*
	say: function say() {
		// 함수에서 객체의 멤버를 참조할 때는 자신을 객체를 의미하는 this를 붙여야 한다. 
		console.log(this.sound);
	}
	*/
	say: function () {
		console.log(this.sound);
	}
	/*
	say() {
		console.log(this.sound);
	}
	*/
	/*
	say: () => {
		// 화살표 함수에서는 this를 사용할 수 없다.
		console.log(this.sound); // undefined
	}
	*/
};

console.log(dog);
dog.say();
console.log('==================================================');

// 객체 외부에서 함수를 주입할 수 있다.
const cat = {
	name: '야옹이',
	sound: '야옹'
}

// dog 객체의 say() 함수가 cat 객체의 say() 함수로 추가(주입)된다.
cat.say = dog.say
console.log(cat);
cat.say();
console.log('==================================================');

//	getter, setter를 사용하면 객체의 값을 얻어오거나 넣어줄 때 일련의 기능을 실행할 수 있다.
const numbers = {
	a: 1,
	b: 2,
//	getter
	get sum() {
		console.log('sum() 함수가 실행됩니다.');
		// getter는 특정 멤버의 값이나 연산 결과를 얻어와야 하므로 값을 return 시켜야 한다.
		// 값을 리턴하지 않으면 undefined가 리턴된다.
		return this.a + this.b;
	}
}

console.log(numbers);
numbers.a = 5;
console.log(numbers);

// numbers.sum(); // TypeError: numbers.sum is not a function 에러가 발생된다.
// getter를 실행할 때는 ()를 붙이지 않는다.
console.log(numbers.sum);
numbers.b = 8;
console.log(numbers.sum);
console.log('==================================================');

const bull = {
	_name: '황소',
//	getter => get으로 선언한다.
	get name() {
		console.log('_name을 조회합니다.');
		return this._name;
	},
//	setter => set으로 선언한다.
	set name(value) {
		console.log('이름이 바뀝니다. => ' + value);
		this._name = value;
	}
}

console.log(bull);
console.log(bull.name);
// getter와 마찬가지로 setter를 실행할 때도 ()를 붙이지 않는다.
// bull.name('암소'); // 에러
bull.name = '암소';
console.log(bull.name);
console.log('==================================================');

const number2 = {
	_a: 1,
	_b: 2,
	sum: 3,
	calculator: function () {
		console.log('calculator');
		this.sum = this._a + this._b;
	},
	get a() {
		return this._a;
	},
	get b() {
		return this._b;
	},
	set a(value) {
		this._a = value;
		this.calculator();
	},
	set b(value) {
		this._b = value;
		this.calculator();
	}
}

console.log(number2);
console.log(number2.sum);
number2.a = 5;
console.log(number2.sum);
number2.b = 7;
console.log(number2.sum);









