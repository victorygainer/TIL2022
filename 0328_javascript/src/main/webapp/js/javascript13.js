//	falsy: undefiend, null, 0, '', NaN => 무조건 거짓이 되는 값

//	단축 평가(short-circuit evaluation) 논리 계산법
//	"&&" 논리 연산에서 앞의 조건이 true면 "&&" 뒤의 내용이 출력된다.
console.log(true && 'hello');
//	"&&" 논리 연산에서 앞의 조건이 false면 "&&" 뒤의 내용은 아예 안보고 false가 출력된다.
console.log(false && 'hello');
console.log('==================================================');

const dog = {
	name: '멍멍이',
}

/*
function getName(animal) {
	console.log(animal);
	if (animal) {
		return animal.name;
	}
	return undefined;
}
*/

function getName(animal) {
	console.log(animal);
	return animal && animal.name;
}

const name1 = getName(dog);
console.log(name1);
console.log('==================================================');
const name2 = getName();
console.log(name2);
console.log('==================================================');

//	"||" 논리 연산에서 앞의 조건이 true면 "||" 뒤의 내용은 아예 안보고 true가 출력된다.
console.log(true || 'hello');
//	"||" 논리 연산에서 앞의 조건이 false면 "||" 뒤의 값을 출력한다.
console.log(false || 'hello');
console.log('==================================================');

const cat = {
	name: '야옹이',
}

function getName2(animal) {
	const name = animal || animal.name;
	console.log(name);
	if (name) {
		return name.name;
	} else {
		return '너... 누구나...';
	}
}

const name3 = getName2(cat);
console.log(name3);
console.log('==================================================');
const name4 = getName2();
console.log(name4);












