//	인수로 받은 시간이 경과된 후 넘겨받은 시간을 리턴하는 promise를 리턴하는 함수
/*
function timer(time) {
	return new Promise(function (resolve) {
		setTimeout(function () {
			// resolve() 함수가 리턴하는 값은 then() 함수로 받는다.
			resolve(time);
		}, time);
	});
}
*/

//	위 함수를 arrow 함수로 변환
function timer(time) {
	return new Promise(resolve => {
		setTimeout(() => resolve(time), time);
	});
}


//	timer() 함수를 실행한다.
/*
timer(1000).then(time => {
	console.log('time:', time);
});
*/

//	timer() 함수 실행 앞, 뒤에 start, end 표시
/*
console.log('start');
timer(1000).then(time => {
	console.log('1. time:', time);
	// then() 함수에서 리턴하는 값은 다음 then() 함수에서 받을 수 있다.
	return timer(time + 1000);
}).then(time => {
	console.log('2. time:', time);
	return timer(time + 1000);
}).then(time => {
	console.log('3. time:', time);
	console.log('end'); // 여기다 코딩해야 모두 완료된 후 출력된다.
});
*/

//	위에서 실행한 것과 동일한 결과를 가지는 async, await를 사용하는 함수로 수정
async function run() {
	console.log('start');
	let time = await timer(1000);
	console.log('1. time:', time);
	time = await timer(time + 1000);
	console.log('2. time:', time);
	time = await timer(time + 1000);
	console.log('3. time:', time);
	console.log('end');
	// async 함수가 결과를 리턴하면 제일 나중에 코딩한다.
	return '끼야오~~~~~';
}

//	run() 함수 앞, 뒤에 parent start, parent end 표시
/*
console.log('parent start');
run();
//	console.log(run());
console.log('parent end');
*/

//	run() 함수를 await를 붙여서 run2() async 함수로 작성
async function run2() {
	console.log('parent start');
	// await run();
	let time = await run(); // async 함수의 리턴 결과를 받는다.
	console.log('4. time:', time);
	console.log('parent end');
}

// run2();

//	run()2 함수 앞, 뒤에 parent parent start, parent parent end 표시
console.log('parent parent start');
run2().then(() => {
	console.log('parent parent end');
});









