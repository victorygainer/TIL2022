//	콜백 지옥

//	id와 password를 받아서 로그인 처리와 로그인 후 역할을 받아오는 클래스
class UserStorage {
	
	// 로그인 함수
	// loginUser(아이디, 비밀번호, 성공시 callback 함수, 실패시 callback 함수)
	loginUser(id, password, onSuccess, onError) {
		setTimeout(() => {
			if (id == '홍길동' && password == '1111' || id == '임꺽정' && password == '2222') {
				onSuccess(id);
			} else {
				onError(new Error('로그인 실패'));
			}
		}, 2000);
	}
	
	// 로그인 후 역할을 받아오는 함수
	// getRoles(아이디, 성공시 callback 함수, 실패시 callback 함수)
	getRoles(user, onSuccess, onError) {
		setTimeout(() => {
			if (user == '홍길동') {
				onSuccess(
					{
						name: '홍길동',
						role: '관리자'
					}
				);
			} else {
				onError(new Error('권한이 없습니다.'));
			}
		}, 1000);
	}
}

const userStorage = new UserStorage();

//	id와 password를 입력받는다.
const id = prompt('아이디를 입력하세요');
const password = prompt('비밀번호를 입력하세요');

/*
//	로그인 처리를 한다.
userStorage.loginUser(id, password, function (user) {
	console.log('로그인 성공');
	// 로그인에 성공했으므로 id에 따른 역할을 요청해서 받아온다.
	userStorage.getRoles(user, function (userWithRole) {
		// 요청이 성공적으로 받아지면 객체에 저장된 이름과 역할을 출력한다.
		alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role} 입니다.`); 
	}, function (error) {
		console.log(error);
	});
}, function (error) {
	console.log(error);	
});
*/

/*
userStorage.loginUser(id, password, user => {
	console.log('로그인 성공');
	userStorage.getRoles(user, userWithRole => {
		alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role} 입니다.`); 
	}, console.log);
}, console.log);
*/

userStorage.loginUser(
	id, 
	password, 
	user => {
		console.log('로그인 성공');
		userStorage.getRoles(
			user, 
			userWithRole => {
				alert(`안녕하세요 ${userWithRole.name}님 당신의 권한은 ${userWithRole.role} 입니다.`); 
			}, 
			console.log
		);
	}, 
	console.log
);














