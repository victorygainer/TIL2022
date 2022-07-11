//	하이퍼링크 클릭시 호출했던 fetch() 함수의 반복되는 부분을 함수로 구현했다.
function fetchAjax(pageName) {
	fetch(pageName).then(response => {
		if (response.status == 200) {
			response.text().then(text => document.querySelector('div').innerHTML = text);
		} else {
			document.querySelector('div').innerHTML = '요청 실패';
		}
	});
}

