//	onload 이벤트에 익명 함수를 할당한다.
//	현재 페이지의 모든 내용이 브라우저에 loading되고 난 후 onload 이벤트에 할당한 익명 함수가 실행된다.
onload = () => {
//	alert('onload 이벤트 실행');
//	button 태그를 찾아서 onclick 이벤트에 함수를 할당한다.
//	함수를 할당할 때 함수 이름 뒤에 ()를 적으면 자동 실행 함수가 되서 페이지가 loading될 때
//	자동으로 실행되기 때문에 ()를 적으면 안된다.
	document.getElementsByTagName('button')[0].onclick = testDate1;
	document.getElementsByTagName('button')[1].onclick = testDate2;
	document.getElementsByTagName('button')[2].onclick = testDate3;
	document.getElementsByTagName('button')[3].onclick = testDate4;
	document.getElementsByTagName('button')[4].onclick = testDate5;
}

function testDate1() {
	let today = document.getElementById('today');
//	컴퓨터 시스템의 오늘 날짜와 시간을 얻어온다.
	let date = new Date();
	console.log(date);
//	today.innerHTML = date; // Mon Apr 04 2022 12:54:56 GMT+0900 (한국 표준시)
//	today.innerHTML = date.toDateString(); // Mon Apr 04 2022
//	today.innerHTML = date.toLocaleString(); // 2022. 4. 4. 오후 12:57:14
//	today.innerHTML = date.toLocaleDateString(); // 2022. 4. 4.
	today.innerHTML = date.toLocaleTimeString(); // 오후 12:57:40
}

function testDate2() {
	let today = document.getElementById('today');
	console.log(today.innerHTML);
	
	let date = new Date();
	let year = date.getYear() + 1900; // 년, 1900을 더해야 한다.
	let month = date.getMonth() + 1; // 월, 1을 더해야 한다.
	let day = date.getDate(); // 일
	const weekDay = ['일', '월', '화', '수', '목', '금', '토']
	let week = date.getDay(); //요일, 일요일(0), 월요일(1), ..., 토요일(6)
	let hour = date.getHours(); // 시
	let minute = date.getMinutes(); // 분
	let second = date.getSeconds(); // 초
	let milliSecond = date.getMilliseconds(); // 밀리초
	today.innerHTML = year + '.' + month + '.' + day + '(' + weekDay[week] + ') ' +
			hour + ':' + minute + ':' + second + '.' + milliSecond;
			
	console.log(date.getFullYear()); // 1900을 더할 필요 없다.
}

function testDate3() {
	let year = 2022;
	let month = 4;
	let day = 4;
	
//	Date 객체를 만들 때 인수로 년, 월, 일을 넣어주면 특정 날짜 객체를 만들 수 있다.
//	new Date(년, 월, 일)
//	시, 분, 초를 인수로 넣어 날짜 및 시간을 저장한 객체를 만들 수 있다.
//	new Date(년, 월, 일, 시, 분, 초)
	let date = new Date(year, month - 1, day, 14, 36, 10);
	console.log(date);
	
	document.getElementById('specific').innerHTML = date;
	document.getElementById('inputDate').value = date;
}

function testDate4() {
//	지정 날짜
	let date1 = document.getElementById('date1').value;
	console.log(date1);
	console.log(typeof date1);
//	날짜 연산을 하기 위해서 id 속성이 date1로 지정된 객체에 입력된 문자열을 날짜 데이터로 만든다.
	let date = new Date(date1);
	console.log(date);
	console.log(typeof date);
	
//	경과 날짜
	let dateInput = document.getElementById('dateInput').value;
	console.log(dateInput);
	
	console.log(date.getDate() + Number(dateInput));
	console.log(date.getDate() + parseInt(dateInput));
	date.setDate(date.getDate() + parseInt(dateInput))
	console.log(date.toLocaleDateString());
	document.getElementById('result').value = date.toLocaleDateString();
}

function testDate5() {
	let date2 = document.getElementById('date2').value; // 수료 날짜
	let endDate = new Date(date2);
	console.log('수료 날짜: ' + endDate.toLocaleDateString());
	let dateInput2 = document.getElementById('dateInput2').value; // 지정 날짜
	let startDate = new Date(dateInput2);
	console.log('지정 날짜: ' + startDate.toLocaleDateString());
	
	let result2 = endDate - startDate;
//	날짜/시간 데이터를 연산하면 두 시간 차이의 결과릴 밀리초 단위로 계산한다.
	console.log(result2);
	console.log(result2 / (24 * 60 * 60 * 1000));
	document.getElementById('result2').value = result2 / (24 * 60 * 60 * 1000);
}












