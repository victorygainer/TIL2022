function searchParent() {
	let child = document.getElementsByTagName('p')[0];
	console.log(child);
	console.log(child.innerHTML); // 텍스트와 html 요소까지 얻어온다.
	console.log(child.innerText); // 텍스트만 얻어온다.
	
//	parentNode는 탐색된 요소(element)의 부모 요소를 탐색한다.
	let parentDiv = child.parentNode;
	console.log(parentDiv);
	parentDiv.style.backgroundColor = 'hotpink';
	
//	nodeName은 탐색된 요소의 태그 이름을 얻어온다.
	console.log(parentDiv.nodeName);
}

function searchChild() {
	let parent = document.getElementsByTagName('div')[0];
	console.log(parent);
	console.log(parent.innerHTML);
	console.log(parent.innerText);
	
//	children은 탐색된 요소의 자식 요소(태그만)를 탐색해서 배열로 리턴한다.
	let childs = parent.children;
	console.log(childs);
//	childNodes는 탐색된 요소의 자식 요소(태그 및 텍스트)를 탐색해서 배열로 리턴한다.
	childs = parent.childNodes;
	console.log(childs);
	
	console.log(childs[0]);
	console.log(childs[1]);
	console.log(childs[2]);
	
	childs[1].style.backgroundColor = 'skyblue';
	childs[3].style.backgroundColor = 'yellowgreen';
	childs[5].style.backgroundColor = 'dodgerblue';
}

function testSearch() {
	let test1 = document.getElementsByTagName('p')[3];
	console.log(test1);
	let div = test1.parentNode;
	console.log(div);
	div.style.backgroundColor = 'hotpink';
	
	let test4 = document.getElementsByTagName('div')[3];
	console.log(test4);
	let childs = test4.childNodes;
	console.log(childs);
	console.log(childs[3]);
	childs[3].style.fontSize = '20pt';
}

















