function createImg() {
//	선택된 라디오 버튼의 value 속성을 얻어온다.
//	얻어온 속성값을 브라우저에 표시할 이미지의 경로와 이름으로 사용한다.
	let radios = document.getElementsByName('radioBtn');
//	console.log(radios.length);
	
	let radioValue = '';
	for (let radio of radios) {
		// console.log(radio.checked);
		if (radio.checked) {
			// console.log(radio.value);
			radioValue = radio.value;
		}
	}
	console.log(radioValue);
	
//	img 태그를 만들고 src 속성값을 radioValue로 지정하면 된다.
	let img = document.createElement('img'); // <img>
//	img 태그에 이미지를 표시하기 위해서 src 속성과 속성값을 추가한다.
	img.setAttribute('src', radioValue);
	
//	img 태그를 넣어줄 div 태그를 얻어온다.
	let div = document.getElementById('imgView');
	
//	라디오 버튼을 선택하고 이미지 생성하기 버튼을 클릭할 때 마다 이미지가 변경되게 하려면 기존의
//	img 태그를 제거하고 다시만든 img 태그를 넣어주면 된다.
//	div 태그에 들어가있는 첫 번째 노드를 선택해서 제거한다.

//	firstElementChild: 첫 번째 자식 노드
//	lastElementChild: 마지막 자식 노드
	let divImg = div.firstElementChild;
//	console.log(divImg);
//	removeChild(태그): 인수로 지정된 자식 태그를 제거한다.
	div.removeChild(divImg);
	
//	div 태그에 img 태그를 자식으로 넣어준다.
	div.appendChild(img);
}





















