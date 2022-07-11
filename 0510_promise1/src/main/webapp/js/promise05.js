//	promise는 javascript 비동기 처리에 사용되는 객체이다.
//	javascript의 비동기 처리란 특정 코드의 실행이 완료될 때 까지 기다리지 않고 
//	다음 코드를 먼저 수행하는 javascript의 특성을 의미한다.

//	promise state: pending => fulfilled 또는 rejected
//	pending(대기): 이행하지도 않고 거부하지도 않은 상태
//	fulfilled(이행): 연산이 성공적으로 실행됨
//	rejected(거부): 연산이 실패함

//	promise 만들기
//	새로운 promise가 생성되면 promise 객체를 만들때 넘겨주는 executor 함수가 자동으로 실행된다.
const promise = new Promise((resolve, reject) => {
	console.log('promise Promise의 executor 함수가 실행된다.');
	// promise 테스트를 위해서 setTimeout() 함수를 사용한다.
	setTimeout(() => {
		// promise가 정상적으로 실행된 결과는 resolve() 함수의 인수로 리턴시킨다. 
		resolve('홍길동');
		// promise가 실패한 결과는 reject() 함수의 인수로 리턴시킨다.
		// reject(new Error('에러 발생'));
	}, 2000);
});

//	promise 사용하기
//	resolve()로 넘어오는 결과는 then()으로 받고 reject()로 넘어오는 값은 catch()로 받는다.
//	promise의 성공, 실패 여부와 상관없이 실행할 코드는 finally()에 코딩한다.
promise
	.then(value => { // promise가 정상적으로 잘 수행되면 실행할 코드를 입력한다.
		console.log('promise then =>', value);
	})
	.catch(error => { // promise가 실패하면 실행할 코드를 입력한다.
		console.log('promise catch =>', error);
	})
	.finally(() => { // promise 성공, 실패 여부와 상관없이 실행할 코드를 입력한다.
		console.log('promise finally =>', 'promise 성공, 실패 여부와 상관없이 실행된다.')
	});

//	=====================================================================================

//	promise chaining
const fetchNumber = new Promise((resolve, reject) => {
	console.log('fetchNumber Promise의 executor 함수가 실행된다.');
	setTimeout(() => resolve(1), 1000);
});

fetchNumber
	.then(number => {
		console.log('fetchNumber 1. then =>', number);
		return number * 2;
	})
	// 이전 then()에서 리턴하는 값을 다음 then()에서 받아 처리한다.
	.then(number => {
		console.log('fetchNumber 2. then =>', number);
		return number * 3;
	})
	.then(number => {
		console.log('fetchNumber 3. then =>', number);
		return new Promise((resolve, reject) => {
			setTimeout(() => resolve(number - 1), 2000);
		});
	})
	.then(number => console.log('fetchNumber 4. then =>', number));
	
//	=====================================================================================

//	error handling
/*
const getHen = function () {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve('암탉'), 1000);
	});
}
*/

const getHen = () => new Promise((resolve, reject) => 
	setTimeout(() => resolve('암탉'), 1000)
);

/*
const getEgg = function (hen) {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve(`${hen} => 달걀`), 1000);
	});
}
*/

const getEgg = hen => new Promise((resolve, reject) => 
	// setTimeout(() => resolve(`${hen} => 달걀`), 1000)
	setTimeout(() => reject(`error!!! ${hen} => 달걀`), 1000)
);

/*
const getMeal = function (egg) {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve(`${egg} => 후라이`), 1000);
	});
}
*/

const getMeal = egg => new Promise((resolve, reject) =>
	setTimeout(() => resolve(`${egg} => 후라이`), 1000)
);

//	console.log(getHen()); // Promise {<pending>}
/*
getHen()
	.then(function (hen) {
		// console.log('hen:', hen);
		return getEgg(hen);
	})
	.then(function (egg) {
		// console.log('egg:', egg);
		return getMeal(egg);
	})
	.then(function (meal) {
		console.log('meal:', meal);
	});
*/

/*
getHen()
	.then(hen => getEgg(hen))
	.then(egg => getMeal(egg))
	.then(console.log);
*/

getHen()
	.then(hen => getEgg(hen))
	// 코드의 에러가 발생된 시점에서 에러를 처리하려면 발생된 시점에 catch()를 붙여
	// 처리하면 된다.
	.catch(() => '빵')
	.then(egg => getMeal(egg))
	.then(console.log)
	// catch()를 마지막에 사용하면 코드의 임의의 시점에서 발생된 에러 처리가 가능하다. 
	.catch(console.log);













