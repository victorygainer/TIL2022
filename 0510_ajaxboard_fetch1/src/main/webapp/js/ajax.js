/*
//	javascript ajax를 이용한 검색 요청
const searchRequest = new XMLHttpRequest();

function searchFunction() {
	let url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('username').value);
	searchRequest.open('GET', url, true);
	searchRequest.send(null);
	searchRequest.onreadystatechange = searchProcess;
}

function searchProcess() {
	if (searchRequest.readyState == 4 && searchRequest.status == 200) {
		let object = eval('(' + searchRequest.responseText + ')');
		let result = object.result;
		let table = document.getElementById('ajaxTable');
		table.innerHTML = '';
		for (let i=0; i<result.length; i++) {
			let row = table.insertRow(i);
			for (let j=0; j<result[i].length; j++) {
				let cell = row.insertCell(j);
				cell.innerHTML = result[i][j].value;
			}
		}
	}
}
*/

//	fetch ajax를 이용한 검색 요청
function searchFunction() {
	let url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('username').value);
	fetch(url, {
		method: 'GET'
	}).then(function (response) {
		response.text().then(function (text) {
			// javascript ajax는 searchRequest.responseText를 이용했지만 response.text()로 얻어낸 text를 써준다.
			let result = eval('(' + text + ')').result;
			let table = document.getElementById('ajaxTable');
			table.innerHTML = '';
			for (let i=0; i<result.length; i++) {
				let row = table.insertRow(i);
				for (let j=0; j<result[i].length; j++) {
					let cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				}
			}
		});
	});
}

onload = function () {
	searchFunction();
}

/*
//	javascript ajax를 이용한 입력 요청
const insertRequest = new XMLHttpRequest();

function insertFunction() {
	let url = './AjaxInsert?name=' + encodeURIComponent(document.getElementById('name').value)
				   + '&age=' + encodeURIComponent(document.getElementById('age').value)
				   + '&gender=' + encodeURIComponent($('input[name=gender]:checked').val())
				   + '&email=' + encodeURIComponent(document.getElementById('email').value);
	insertRequest.open('GET', url, true);
	insertRequest.send(null);
	insertRequest.onreadystatechange = insertProcess;
}

function insertProcess() {
	if (insertRequest.readyState == 4 && insertRequest.status == 200) {
		let result = insertRequest.responseText;
		document.getElementById('name').value = '';
		document.getElementById('age').value = '';
		document.getElementById('email').value = '';
		document.getElementById('username').value = '';
		if (result == '1') {
			alert('저장 성공!!!')
			searchFunction();
		} else {
			alert('저장 실패!!!')
		}
	}
}
*/

//	fetch ajax를 이용한 입력 요청
function insertFunction() {
	let url = './AjaxInsert?name=' + encodeURIComponent(document.getElementById('name').value)
			   + '&age=' + encodeURIComponent(document.getElementById('age').value)
			   + '&gender=' + encodeURIComponent($('input[name=gender]:checked').val())
			   + '&email=' + encodeURIComponent(document.getElementById('email').value);
	fetch(url, {
		method: 'GET'
	}).then(function (response) {
		response.text().then(function (result) {
			document.getElementById('name').value = '';
			document.getElementById('age').value = '';
			document.getElementById('email').value = '';
			document.getElementById('username').value = '';
			if (result == '1') {
				alert('저장 성공!!!')
				searchFunction();
			} else {
				alert('저장 실패!!!')
			}
		});
	});
}












