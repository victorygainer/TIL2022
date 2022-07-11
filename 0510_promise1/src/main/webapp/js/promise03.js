//	일급 객체(first-class object)
//	컴퓨터 프로그래밍 언어 디자인에서 일급 객체란 다른 객체들에 일반적으로 적용 가능한 연산을 모두 지원하는
//	객체를 의미한다.
//	함수에 인수로 넘기기, 수정하기, 변수에 대입하기와 같은 연산을 지원할 때 일급 객체라고 한다.

//	아래의 3가지 조건을 충족한다면 일급 객체라고 할 수 있다.
//	1. 변수나 데이터에 할당할 수 있어야 한다.
//	2. 객체의 인수로 넘길 수 있어야 한다.
//	3. 객체의 리턴값으로 리턴 할 수 있어야 한다.

//	javascript filter 함수 구현하기
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];

function callback(element) {
	console.log(element);
}
words.filter(callback);
console.log('1. ===============================================================');

function callback2(element) {
	console.log(element);
	if (element.length > 6) {
		// return element;
		return true;
	} else {
		return false;
	}
}
let newWords = words.filter(callback2);
console.log(newWords);
console.log('2. ===============================================================');

function callback3(element) {
	// element.length > 6 실행 결과 자체가 논리값이므로 바로 리턴해도 된다.
	return element.length > 6;
}
newWords = words.filter(callback3);
console.log(newWords);
console.log('3. ===============================================================');

//	익명 함수로 바로 넣어준다.
newWords = words.filter(function (element) {
	return element.length > 6;
});
console.log(newWords);
console.log('4. ===============================================================');

//	익명 함수를 arrow 함수로 변경한다.
newWords = words.filter((element) => {
	return element.length > 6;
});
console.log(newWords);
console.log('5. ===============================================================');

//	arrow 함수를 생략형으로 변경한다.
newWords = words.filter(element => element.length > 6);
console.log(newWords);
console.log('6. ===============================================================');

// words.filter(element => element.length > 6)와 같은 기능 구현하기
function myFilter(origin, callback) {
	let result = [];
	for (let i=0; i<origin.length; i++) {
		let current = origin[i];
		if (callback(current)) {
			result.push(current);
		}
	}
	return result;
}

newWords = myFilter(words, element => element.length > 6);
console.log(newWords);
console.log('7. ===============================================================');









