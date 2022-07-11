function elementCreate() {
//	요소(element, 태그)를 만들어서 문서에 추가한다.
//	createElement('태그이름'): 인수로 지정된 태그를 만든다.
	let div = document.createElement('div'); // <div></div>
	
//	태그에 속성과 속성값 추가
	/*
//	createAttribute('속성이름'): 특정 태그에 넣어줄 인수로 지정된 속성을 만든다.
	let attr = document.createAttribute('style'); // style
//	nodeValue로 속성에 속성값을 추가한다.
	attr.nodeValue = 'border: 2px solid blue'; // style='border: 2px solid blue'
//	setAttributeNode(속성): 태그에 속성을 추가한다.
	div.setAttributeNode(attr);
	*/
	
//	setAttribute('속성이름', '속성값'): 태그에 속성을 추가한다.
	div.setAttribute('style', 'border: 2px solid red; background-color: skyblue');
	div.setAttribute('class', 'skyblue');
	
//	appendChild('추가할 태그 또는 문자열'): 인수로 지정된 태그를 맨 뒤에 추가한다.
	document.body.appendChild(div);
	div.innerHTML = '<marquee>div 태그 추가</marquee>';
}





















