const objects = [
	{
		name: '멍멍이',
	},
	{
		name: '야옹이',
	}
];

console.log(objects);
console.log(objects.length);
console.log(objects[0]);
console.log(objects[1]);
console.log(objects[2]); // undefined, 배열의 인덱스 범위를 넘어갔다.
console.log(objects[0].name);
console.log(objects[1].name);
console.log('===============================================');

// push(): 배열에 데이터를 추가한다.
const hong = {
	name: '길동이',
};
objects.push(hong);
console.log(objects);

objects.push({
	name: '꺽정이',
});
console.log(objects);
console.log(objects.length);
console.log('===============================================');

const doggy = {
	name: '멍멍이',
	sound: '멍멍',
	age: 2,
}

// Object.values(): 인수로 지정된 객체의 key에 할당된 value 값을 배열로 묶어서 얻어온다.
const values = Object.values(doggy);
console.log('Object.values(doggy): ' + values);

for (let i=0; i<values.length; i++) { // 일반 for
	console.log(values[i]);
}
console.log('===============================================');

// Object.keys(): 인수로 지정된 객체의 key 값을 배열로 묶어서 얻어온다.
const keys = Object.keys(doggy);
console.log('Object.keys(doggy): ' + keys);

for (let key of keys) {
	console.log(key);
}
console.log('===============================================');

// Object.entries(): 인수로 지정된 객체의 key와 value 값을 배열로 묶은 배열로 묶어서 얻어온다.
const entries = Object.entries(doggy);
console.log(entries);

//	in을 사용하는 for는 in 뒤에 배열이 나오면 in 앞의 변수에 배열의 인덱스가 저장되며 반복된다.
for (let entrie in entries) {
	console.log(entries[entrie]);
}
console.log('===============================================');

//	in을 사용하는 for는 in 뒤에 객체가 나오면 in 앞의 변수에 객체의 key가 저장되며 반복된다.
for (let d in doggy) {
	console.log(d);
}
console.log('===============================================');

// 객체의 멤버 변수에 접근하는 방법은 객체 이름에 "."을 찍어서 접근하는 방법과 []안에 key를
// 사용해서 접근하는 방법이 있다.
console.log(doggy.name); // "."으로 접근
console.log(doggy['name']); // "['key']"로 접근

for (let key of keys) {
	console.log(doggy[key]);
}







