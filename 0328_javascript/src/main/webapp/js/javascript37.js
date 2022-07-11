onload = () => {
//	alert('onload 이벤트 실행');
	let a = document.querySelectorAll('a');
	let img = document.querySelectorAll('img')[0];
	let count = 3; // 화면에 보이는 이미지 위치
	
//	'◀'에 onclick 이벤트를 연결한다.
	a[0].onclick = () => {
		// getAttribute('속성이름'): 인수로 지정된 속성의 속성값을 얻어온다.
		let imgAlt = img.getAttribute('alt');
		// console.log(imgAlt);
		if (imgAlt == 'img01') {
			alert('첫 번째 이미지입니다.');
		} else {
			img.setAttribute('src', './images/img0' + --count + '.jpg');
			img.setAttribute('alt', 'img0' + count);
		}
	};

//	'▶'에 onclick 이벤트를 연결한다.
	a[1].onclick = () => {
		let imgAlt = img.getAttribute('alt');
		if (imgAlt == 'img05') {
			alert('마지막 이미지입니다.');
		} else {
			img.setAttribute('src', './images/img0' + ++count + '.jpg');
			img.setAttribute('alt', 'img0' + count);
		}
	}
};





















