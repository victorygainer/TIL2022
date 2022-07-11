/*
console.log(1);
setTimeout(() => console.log(2), 5000);
console.log(3);
*/

//	jsonplaceholder 검색
//	https://jsonplaceholder.typicode.com/ 사이트 아래쪽으로 이동해서 /posts 클릭
//	https://jsonplaceholder.typicode.com/posts

//	javascript fetch api
//	https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Using_Fetch

/*
fetch('https://jsonplaceholder.typicode.com/posts')
	.then(function (response) { // then()이 promise 이다.
		// console.log(response);
		// console.log(response.json()); // json 타입의 데이터를 javascript 객체로 변환한다.
		return response.json();
	})
	.then(function (data) {
		console.log(data);
	});
*/

console.log(1);
fetch('https://jsonplaceholder.typicode.com/posts')
	.then(response => response.json())
	.then(console.log);
console.log(2);

//	========================================================================================

/*
//	fetch(요청 url) 함수의 리턴값은 promise 이며 response(응답) 객체이다.
let fetched = fetch('https://jsonplaceholder.typicode.com/posts');
//	리턴값이 promise 이면 비동기적으로 실행되는 함수이다.
console.log('fetched:', fetched); // fetched: Promise {<pending>}
//	fetch() 함수가 리턴한 리턴값에는 then()과 catch() 2개의 함수를 사용할 수 있다.
//	then() 함수는 fetch() 함수가 성공적으로 실행되면 호출되고 catch() 함수는 함수가 정상적으로
//	실행되지 않으면 호출된다.
//	fetch() 함수가 실행되면 promise가 리턴되고 then() 함수도 실행되면 promise를 리턴한다.
fetched.then(function (response) {
	console.log('response:', response); // Response 객체가 넘어온다.
});

fetched = fetch('https://jsonplaceholder1.typicode.com/posts'); // 주소 틀림
fetched.catch(function (error) {
	console.log('error:', error); // error: TypeError: Failed to fetch
});
*/

//	========================================================================================

fetch('https://jsonplaceholder.typicode.com/posts')
	.then(function (response) {
		// console.log('response:', response.json()); // response: Promise {<pending>}
		/*
		// then() 함수 내부에 또 then() 함수가 나오는 방식을 nested promise라 한다.
		response.json().then(function (data) {
			console.log('1. data:', data);
		});
		*/
		return response.json(); // promise를 리턴한다.
	})
	.catch(function (error) {
		console.log('error:', error);
	})
	.then(function (data) {
		// then() 함수에서 promise를 리턴시키고 외부에서 then() 함수로 받아서 사용하는
		// 방식을 promise chaining이라 한다. => 일반적으로 이 방식을 많이 사용한다.
		console.log('2. data:', data);
	})
















