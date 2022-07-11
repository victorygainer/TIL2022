const purpleCuteSlime = {
	name: '슬라임',
	attribute: 'cute',
	color: 'purple',
};

//	rest: spread와는 반대로 퍼져있는 것을 모으는 역할을 한다.
//	지정된 속성을 제외한 나머지가 rest에 저장되므로 rest는 반드시 맨 마지막에 딱 1번만 써야한다.
//	객체에 rest를 사용할 때는 뽑아낼 변수 이름이 객체를 구성하는 key 이름과 같아야 한다.
const {color, ...cuteSlime} = purpleCuteSlime;
console.log(color);
console.log(cuteSlime);

const {attribute, ...slime} = cuteSlime;
console.log(attribute);
console.log(slime);
console.log('================================================');

const numbers = [0, 1, 2, 3, 4, 5, 6];

//	배열에 사용할 때도 reat는 맨 마지막에 딱 1번만 써야한다.
//	배열에 rest를 사용할 때는 변수 이름은 뭘 적어도 상관없고 배열의 인덱스 순서대로 뽑혀나온다.
const [one, two, ...rest] = numbers;
console.log(one);
console.log(two);
console.log(rest);

//	spread와 rest를 사용한 함수 실행
function sum(...rest) {
	return rest.reduce((acc, curr) => acc + curr, 0);
}

const spread = [1, 2, 3, 4, 5, 6, 7];
console.log(sum(...spread));
console.log('================================================');

function maxValue(...numbers) {
	// return numbers.reduce((acc, curr) => curr > acc ? curr : acc);
	return numbers.reduce((acc, curr) => curr > acc ? curr : acc, numbers[0]);
}

const result = maxValue(1, 2, 3, 4, 10, 5, 6, 7);
console.log(result);
