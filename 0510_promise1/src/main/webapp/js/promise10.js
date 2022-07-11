/*
const job1 = new Promise((resolve, reject) => {
	setTimeout(() => {
		resolve('job1 ok!');
	}, 2000);
});

job1.then(data => {
	console.log('data:', data);
});

const job2 = new Promise((resolve, reject) => {
	setTimeout(() => {
		reject('job2 fail!');
	}, 2000);
});

job2.catch(data => {
	console.log('data:', data);
});
*/

function job1() {
	return new Promise((resolve, reject) => 
		setTimeout(() => {
			// resolve('job1 ok!')
			reject('job1 fail!');
		}, 2000)
	);
}

function job2() {
	return new Promise((resolve, reject) =>
		setTimeout(() => resolve('job2 ok!'), 2000)
	);
}

/*
job1().then(data1 => {
	console.log('data1:', data1);
	job2().then(data2 => {
		console.log('data2:', data2);
	});
});
*/

job1()
	.then(data1 => {
		console.log('data1:', data1);
		return job2();
	})
	.catch(error => {
		console.log('error:', error);
		// promise에서 오류가 발생했을 때 Promise 객체의 reject() 함수를 실행하면 이어지는
		// 작업을 중지시킬 수 있다.
		return Promise.reject(error);
	})
	.then(data2 => {
		console.log('data2:', data2);
	});

















