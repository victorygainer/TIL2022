const numbers1 = [10, 20, 30, 40];
const index = numbers1.indexOf(30);
console.log(index);

//	splice(index, 개수): 배열에서 index 번째 위치부터 지정된 개수만큼 추출해서 배열로 리턴한다.
//	splice() 함수가 실행되서 추출되는 데이터는 원본 배열에서 제거된다.
const spliced = numbers1.splice(index, 2);
console.log('spliced: ' + spliced);
console.log('numbers1: ' + numbers1);
console.log('1. ===========================================');

const numbers2 = [10, 20, 30, 40];

//	slice(a, b): 배열에서 a번째 index 부터 b - 1번째 index 까지 추출해 배열로 리턴한다.
//	slice() 함수는 splice() 함수와 다르게 원본 배열의 데이터가 유지된다.
const sliced = numbers2.slice(1, 3);
console.log('sliced: ' + sliced);
console.log('numbers2: ' + numbers2);
console.log('2. ===========================================');

const numbers3 = [10, 20, 30, 40];

//	shift(): 배열에서 맨 앞의 데이터를 추출하고 원본 배열에서 제거한다.
let value = numbers3.shift();
console.log('value: ' + value);
console.log('numbers3: ' + numbers3);

//	pop(): 배열에서 맨 뒤의 데이터를 추출하고 원본 배열에서 제거한다.
value = numbers3.pop();
console.log('value: ' + value);
console.log('numbers3: ' + numbers3);

//	unshift(): 배열의 맨 앞에 인수로 지정한 데이를 추가한다.
numbers3.unshift(777);
console.log('numbers3: ' + numbers3);

//	push(): 배열의 맨 뒤에 인수로 지정한 데이를 추가한다.
numbers3.push(999);
console.log('numbers3: ' + numbers3);
console.log('3. ===========================================');

const array1 = [1, 2, 3];
const array2 = [11, 22, 33];

//	concat(): concat() 함수가 실행된 배열에 인수로 지정한 배열을 연결해서 리턴한다.
const concated1 = array1.concat(array2);
console.log('concated1: ' + concated1);
const concated2 = array2.concat(array1);
console.log('concated2: ' + concated2);
console.log('4. ===========================================');

const array3 = ['홍길동', '임꺽정', '장길산', '일지매'];

//	join(): 배열 요소들 사이에 인수로 지정한 문자열 삽입해서 문자열로 리턴한다.
console.log(array3.join()); // join() 함수의 인수를 생략하면 ","가 기본값으로 사용된다.
console.log(array3.join(' '));
console.log(array3.join('\t'));
console.log(array3.join('/'));
console.log(array3.join('~(^^!)'));
console.log(typeof array3.join('~(^^!)'));









