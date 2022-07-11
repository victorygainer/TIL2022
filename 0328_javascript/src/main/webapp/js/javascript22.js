function searchID() {
//	alert('searchID()');
//	getElementById() 함수는 인수로 지정된 id 속성의 첫 번째 요소 1개를 선택한다.
	let doc = document.getElementById('test');
	doc.innerHTML = 'getElementById() 함수는 DOM 에서 id 속성을 탐색한다.';
	doc.style.backgroundColor = 'yellow';
}

function searchName() {
//	alert('searchName()');
//	getElementsByName() 함수는 인수로 지정된 name 속성의 모든 요소를 선택한다. => 결과는 배열로 얻어온다.
	let docs = document.getElementsByName('test');
//	console.log(docs);

//	docs[0].value = '홍길동';
//	docs[1].value = '임꺽정';
//	docs[2].value = '장길산';

	const names = ['손오공', '저팔계', '사오정'];
//	for (let i=0; i<docs.length; i++) {
//		docs[i].value = names[i];
//	}

//	let i = 0;
//	for (let name of names) {
//		docs[i++].value = name;
//	}

//	for (let i in docs) {
//		docs[i].value = names[i];
//	}
	
//	let i = 0;
//	docs.forEach(function (doc) {
//		doc.value = names[i++];
//	});
	
	let i = 0;
//	화살표 함수는 익명 함수를 사용할 때 function 예약어를 생략하고 ()안에 인수만 적은 후 화살표(=>)를 입력한다.
//	인수가 1개일 경우 ()를 생략 가능하고 함수가 실행할 문장이 1문장일 경우 {}를 생략할 수 있다.
	docs.forEach(doc => doc.value = names[i++]);
}

function searchTagName() {
//	alert('searchTagName()');
//	getElementsByTagName() 함수는 인수로 지정된 모든 태그를 선택한다. => 결과는 배열로 얻어온다.
//	getElementsByName() 함수와 getElementsByTagName() 함수를 실행하면 인수로 지정된 모든 요소를 얻어온다.
//	getElementsByName()[index], getElementsByTagName()[index] 형태로 실행하면 지정된 index에 해당되는 요소만
//	얻어온다.
	let docs = document.getElementsByTagName('p');
	for (let doc of docs) {
		doc.style.backgroundColor = 'hotpink';
	}
	let doc = document.getElementsByTagName('p')[2];
	doc.style.backgroundColor = 'dodgerblue';
}

function searchClass() {
//	alert('searchClass()');
//	getElementsByClassName() 함수는 인수로 지정된 같은 class 속성 값을 가지는의 모든 요소를 선택한다. 
//	=> 결과는 배열로 얻어온다.
	let docs = document.getElementsByClassName('test');
	for (let doc of docs) {
		doc.style.color = 'tomato';
	}
}

function searchCSSSelector() {
//	alert('searchCSSSelector()');
//	querySelector(): css 선택자를 사용해서 첫 번째 요소 1개를 찾는다. => id 속성 탐색에 주로 사용된다.
//	querySelectorAll(): querySelector() 함수와 똑같이 css 선택자를 찾지만 차이점은 모든 요소를 찾는다는 것이다.
//	querySelector(), querySelectorAll() 함수의 인수로 id는 '#'으로 시작하게 class는 '.'으로 시작하게
//	태그는 아무것도 붙이지 않고 지정한다.

//	id 속성값으로 탐색 
	let doc = document.querySelector('#test');
	doc.innerHTML = 'querySelector() 함수를 이용한 선택';
	doc.style.color = 'red';
	doc.style.backgroundColor = 'skyblue';

//	class 속성값으로 탐색
	let docs = document.querySelectorAll('.test');
	for (doc of docs) {
		doc.style.color = 'yellow';
		doc.style.backgroundColor = 'black';
	}

//	태그 이름으로 탐색
	docs = document.querySelectorAll('p');
	for (doc of docs) {
		doc.style.color = 'hotpink';
		doc.style.backgroundColor = 'dodgerblue';
	}
	
//	id 탐색: getElementById('id'), querySelector('#id')
//	class 탐색: getElementByClassName('class'), querySelectorAll('.class')
//	tag 탐색: getElementByTagName('tag'), querySelectorAll('tag')
//	name 속성 탐색: getElementByName('name')
}



















