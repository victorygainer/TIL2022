function alertTest() {
//	alert('메시지');
	alert('단순한 메시지를 출력하는 대화창');
}

function confirmTest() {
//	confirm('메시지');
//	확인 버튼을 클릭하면 true, 취소 버튼을 클릭하면 false를 리턴한다.
//	console.log(confirm('메시지'));
	if (confirm('배경색을 바꿀래?')) {
		document.body.style.backgroundColor = 'black';
		document.body.style.color = 'white';
	}
}

function promptTest() {
//	prompt('메시지');
//	prompt('메시지', '안내 메시지');
//	prompt() 함수는 데이터를 입력하고 확인 버튼을 클릭하면 입력한 데이터가 리턴되고 취소 버튼을 클릭하면 null이 리턴된다.
//	리턴되는 데이터 타입은 무조건 string 타입으로 리턴된다.
	let menu = prompt('점심은 뭘 먹을까요?\n(1.짜장면, 2.양장피, 3.팔보채)', '난 짜장면');
//	console.log(menu);
//	console.log(typeof menu);
	
	switch (menu) {
		case '1':
			console.log('짜장면');
			break;
		case '2':
			console.log('양장피');
			break;
		case '3':
			console.log('팔보채');
			break;
		default:
			console.log('짜장면, 양장피, 팔보채 밖에 먹을게 없으니 1, 2, 3 중에 입력하세요');
			break;
	}
	
}












