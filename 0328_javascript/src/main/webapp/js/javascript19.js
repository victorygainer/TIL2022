function openWin() {
//	alert('openWin()');
//	window.open();
//	window.open(url, title, option);
	let url = './javascript_20_윈도우2.html'; // 새로 띄울 창에 표시할 페이지 이름
	let title = '아이디 중복 검사'; // 윈도우 이름
//	새 창이 브라우저에 새 탭으로 열리게 할거면 option을 생략하면 된다.
	let option = 'top=50px, left=100px, width=500px, height=600px'; // 윈도우 옵션
	window.open(url, title, option);
}

function registerForm() {
//	감춰놓은 id 속성이 register로 지정된 div 태그를 화면에 보이게 한다.
	document.getElementById('register').style.display = 'block';
//	윈도우의 배경색을 변경한다.
	document.body.style.backgroundColor = 'gray';
	
//	로그인 버튼을 비활성화 시킨다.
//	비활성화시킬 버튼이 1개일 때
//	document.getElementsByName('btn')[1].disabled = 'disabled';

//	비활성화시킬 버튼이 여러개일 때
	let btns = document.getElementsByName('btn'); // name 속성이 btn인 모든 버튼을 배열로 얻어온다.
	
//	일반 for
//	for (let i=0; i<btns.length; i++) {
//		btns[i].disabled = 'disabled';
//	}

//	향상된 for => of
//	for (let btn of btns) { // 변수 btn에 btns 배열 요소가 차레대로 전달되며 반복된다.
//		btn.disabled = 'disabled';
//	}

//	향상된 for => in
//	in 뒤의 요소가 객체면 객체의 key가 in 앞의 변수에 차례대로 전달되며 반복된다.
//	in 뒤의 요소가 배열이면 배열의 index가 in 앞의 변수에 차례대로 전달되며 반복된다.
//	for (let i in btns) {
//		btns[i].disabled = 'disabled';
//	}
	
//	모든 input 태그를 비활성화 시킨다.
	let inputs = document.getElementsByTagName('input'); // 모든 input 태그를 배열로 얻어온다.
//	console.log(inputs.length);
	for (let i=0; i<6; i++) {
		inputs[i].disabled = 'disabled';
	}
	
}

function closeWin() {
//	id 속성이 register로 지정된 div 태그를 화면에서 사라지게 한다.
	document.getElementById('register').style.display = 'none';
	document.body.style.backgroundColor = 'white';
	let inputs = document.getElementsByTagName('input');
	for (let i=0; i<6; i++) {
		inputs[i].disabled = '';
	}
}

function idChk() {
	alert('중복 체크 버튼을 클릭하고 아이디 중복 체크를 하세요!!!!!');
}

function idCheck() {
	let url = './javascript_21_윈도우3.html';
	let title = '아이디 중복 검사';
	let option = 'top=50px, left=100px, width=500px, height=300px';
	window.open(url, title, option);
}









