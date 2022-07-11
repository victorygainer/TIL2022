// 동기 방식은 처음부터 끝까지 차례대로 실행되는 방식이다.
// 비동기 방식은 이전 작업이 완료되지 않아도 이전 작업이 실행되는 동안 기다리지 않고
// 다음 작업을 실행하는 방식을 말한다.
console.log('1');
console.log('2');
// console.log('3');
setTimeout(function () {
	console.log('3');
}, 3000);
console.log('4');
console.log('5');


