function addAppend() {
	let fieldset = document.getElementById('addEle');
	let p = document.createElement('p'); // <p></p>
//	p.innerHTML = '<b>fieldset 내부의 div 태그 뒤에 추가된다.</b>';
//	p.innerText = '<b>fieldset 내부의 div 태그 뒤에 추가된다.</b>';

//	createTextNode(): 태그 내부의 문자열을 만든다. 태그는 적용되지 않는다.
	let txt = document.createTextNode('<b>fieldset 내부의 div 태그 뒤에 추가된다.</b>');
	p.appendChild(txt);

	fieldset.appendChild(p);
}

function addBefore() {
	let fieldset = document.getElementById('addEle');
	let p = document.createElement('p');
	
//	let div = document.getElementsByTagName('div')[0];
	let div = document.querySelector('#addEle > div');
	
//	p.innerHTML = '<b>fieldset 내부의 div 태그 앞에 추가된다.</b>';
//	p.innerText = '<b>fieldset 내부의 div 태그 앞에 추가된다.</b>';

//	let txt = document.createTextNode('<b>fieldset 내부의 div 태그 앞에 추가된다.</b>');
//	p.appendChild(txt);
//	textContent: createTextNode() 함수로 문자열을 만들고 appendChild() 함수를 실행한 것 처럼 태그 내부에
//	문자열을 넣어준다.
	p.textContent = '<b>fieldset 내부의 div 태그 앞에 추가된다.</b>';

//	insertBefore(a, b): b 태그 앞에 a 태그를 삽입한다.
	fieldset.insertBefore(p, div);
}

function moveElement() {
//	특정 태그를 선택해서 다른 위치에 넣어주면 기존의 위치에서 제거된다. => 이동된다.
	let fieldset = document.getElementById('addEle');
	
	console.log(fieldset.children);
//	children[index]: 선택된 태그의 index 번째에 해당되는 태그를 얻어온다.
	console.log(fieldset.children[0]);
	console.log(fieldset.children[1]);
	
	let body = document.body;
	body.appendChild(fieldset.children[1]);
}


















