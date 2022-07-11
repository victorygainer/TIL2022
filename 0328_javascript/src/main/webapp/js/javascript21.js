let ids = ['aaa', 'bbb', 'ccc', 'ddd'];

function confirmChk() {
//	중복 검사할 아이디를 얻어온다.
	let id = document.getElementsByName('id')[0].value.trim();
//	console.log(id);

//	아이디 중복 검사 결과 메시지를 출력할 <div> 태그를 얻어온다.
	let div = document.getElementsByTagName('div')[0];
//	div.innerHTML = id;

//	입력한 아이디가 아이디 목록에 존재하는가 검사한다.
//	indexOf() 함수는 인수로 지정된 데이터가 배열의 몇 번째 index에 위치하나 리턴한다.
//	있으면 데이터의 index를 리턴하고 없으면 -1을 리턴한다.
	if (id.length == 0) {
		div.innerHTML = '<b style="color: red";>중복 검사할 아이디를 입력하세요</b>';
	} else if (ids.indexOf(id) >= 0) {
		div.innerHTML = '<b><span style="color: red";>' + id + '</span>는(은) 사용할 수 없는 아이디 입니다.</b>';
	} else {
		div.innerHTML = '<b><span style="color: blue";>' + id + 
				'</span>는(은) 사용할 수 있는 아이디 입니다.</b>&nbsp;' +
				'<input type="button" value="사용하기" onclick="insertID(\'' + id + '\')"/>';
		// 자바스크립트 함수는 변수에 저장된 문자열을 호출하는 함수의 인수로 전달하려면 변수명만 쓰면 안된다.
		// 변수명만 쓰면 변수에 저장된 데이터를 문자열로 인식하는 것이 아니라 변수로 인식해서 에러가 발생된다.
		// 변수에 저장된 문자열을 함수의 인수로 전달하려면 양쪽에 따옴표를 붙여서 전달해야 한다.
		// 큰따옴표와 작은따옴표가 모두 사용된 상태일 경우 또 따옴표를 찍어야 한다면 \" 또는 \'를 사용한다.
	}
}

function insertID(id) {
//	console.log(id);
	opener.document.getElementsByName('id')[0].value = id;
//	focus(): 특정 컨트롤로 포커스를 이동한다.
	opener.document.getElementsByName('password')[0].focus();
	self.close();
}















