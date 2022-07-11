$(() => {
	
//	자바스크립트로 주기적인 작업을 실행하기 위해서 setInterval() 함수와 setTimeout() 함수를 사용한다.
//	setInterval() 함수와 setTimeout() 함수는 비슷하게 실행되지만 중요한 차이점을 가진다.
//	setInterval(함수, 시간): 지정된 시간이 마다 함수를 반복해서 실행한다.
//	clearInterval(): setInterval() 함수의 실행을 중지시킨다.
//	setTimeout(함수, 시간): 지정된 시간이 마다 함수를 1번 실행한다.
//	clearTimeout(): setTimeout() 함수의 실행을 중지시킨다.

	// let count = 0;
	setInterval(() => {
		// console.log('setInterval: ' + ++count);
		// 메뉴의 첫번째 이미지를 선택해서 메뉴의 마지막 이미지로 위치를 이동시킨다.
		// appendTo(): 선택된 요소를 인수로 지정된 요소의 마지막에 추가한다.
		$('.active').first().appendTo($('#menu'));
	}, 1);
	
	$('button').click(() => {
		// start 버튼이 클릭되면 버튼위의 문자열을 stop으로 변경하고 stop 버튼이 클릭되면 버튼위의
		// 문자열을 start로 변경한다.
		if ($('button').text() == 'start') {
			$('button').text('stop');
		} else {
			$('button').text('start');
		}
		// start 버튼이 클릭되면 active라는 클래스를 추가하고 이미지 롤링을 시작하고 stop 버튼이
		// 클릭되면 active라는 클래스를 제거하고 이미지 롤링을 중지시킨다.
		$('img').toggleClass('active'); 
	});
	
});




















