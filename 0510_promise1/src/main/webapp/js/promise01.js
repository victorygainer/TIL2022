//	JSON(JavaScript Object Notation)

//	javascript 객체를 json으로 변환하기
//	stringify(객체): 인수로 지정된 객체를 json 객체로 변환한다.
let json = JSON.stringify(true); // JSON 객체는 대문자로 사용해야 한다.
console.log(json);
console.log('1. ===============================================================');

json = JSON.stringify(['apple', 'banana'])
console.log(json);
console.log('2. ===============================================================');

const rabbit = {
	name: '토오끼',
	color: '회색',
	size: '왕큼',
	birthDate: new Date(),
	// javascript 객체나 함수는 stringify() 함수 실행시 json에 포함되지 않는다.
	// symbol: Symbol('id'),
	jump: () => console.log('jump')
};
console.log(rabbit);
json = JSON.stringify(rabbit);
console.log(json);
console.log('3. ===============================================================');

//	stringify() 함수의 2번째 인수로 json으로 변환할 속성을 배열로 지정할 수 있다.
json = JSON.stringify(rabbit, ['name', 'color']);
console.log(json);
console.log('4. ===============================================================');

//	보다 더 세밀한 제어를 하기 위해서 2번째 인수로 콜백 함수를 지정할 수 있다.
json = JSON.stringify(rabbit, (key, value) => {
	console.log(`key: ${key}, value: ${value}`);
	// console.log('key: ' + key + ', value: ' + value);
	// return value;
	return key == 'name' ? '별주부' : value;
});
console.log(json);
console.log('5. +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++');

//	json을 javascript 객체로 변환하기
//	parse(json): 인수로 지정된 json을 javascript 객체로 변환한다.
//	console.clear(); // 콘솔창에 출력한 내용을 지운다.

//	rabbit 객체를 json으로 변경한 후 다시 객체로 변경한다.
json = JSON.stringify(rabbit);
console.log(json);
const obj = JSON.parse(json);
console.log(obj);
console.log('6. ===============================================================');

rabbit.jump();
//	json에 포함된 함수는 javascript 객체로 변환되지 않는다.
//	obj.jump();

console.log(rabbit.birthDate.getDate());
//	json에 포함된 날짜도 문자열 형태이므로 객체로 변환되지 않는다.
//	console.log(obj.birthDate.getDate());
console.log('7. ===============================================================');

//	보다 더 세밀한 제어를 하기 위해서 2번째 인수로 콜백 함수를 지정할 수 있다.
const json2 = JSON.parse(json, function(key, value) {
	console.log(`key: ${key}, value: ${value}`);
	// return value;
	return key == 'birthDate' ? new Date(value) : value;
});
console.log(json2);
console.log(json2.birthDate.getDate());
console.log('8. ===============================================================');

//	json 관련 유용한 사이트
//	1. json diff(http://www.jsondiff.com/): 서버로 요청해 응답받은 데이터를 비교한다.
//	2. json beautifier(https://codebeautify.org/jsonviewer): json 데이터 포맷을 예쁘게 만든다.
//	3. json parser(http://json.parser.online.fr/): json 데이터를 객체 형태로 만든다.
//	4. json validator(https://jsonformatter.curiousconcept.com/#): json 데이터가 유효한지 검사한다.





