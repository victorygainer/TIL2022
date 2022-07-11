function fetchAjax(pageName) {
	fetch(pageName).then(response => {
		if (response.status == 200) {
			response.text().then(text => document.querySelector('div').innerHTML = text);
		} else {
			document.querySelector('div').innerHTML = '요청 실패';
		}
	});
}

$(() => {
	if (location.hash) {
		fetchAjax(location.hash.substring(2));
	} else {
		console.log('해시 없음');
		fetchAjax('summary');
	}
	
	// list 파일의 내용을 읽어서 <ol id="list">에 넣어주는 fetch
	/*
	fetch('list').then(function (res) {
		// console.log(res.status);
		if (res.status == 200) {
			// console.log(res.text());
			res.text().then(function (data) {
				// document.querySelector('#list').innerHTML = data;
				$('#list').html(data);
			});
		} else {
			$('div').html('<b>요청실패</b>');
		}
	});
	*/
	
	/*
	// then() 내부에 then()이 나오는 기법을 nested라 한다.
	fetch('list')
		.then(res => res.text()
			.then(data => $('#list').html(data)));
	*/
	
	// then()이 리턴한 결과를 외부에서 다른 then()이 받는 기법을 chaining이라 한다.
	fetch('list')
		.then(res => res.text())
		.then(data => $('#list').html(data));

	// list 파일의 내용을 읽어서 <ol id="list2">에 넣어주는 fetch
	/*
	fetch('list2').then(function (res) {
		res.text().then(function (data) {
			// console.log(data);
			// ','를 경계로 문자열을 분리해서 배열로 리턴한다.
			let obj = data.split(',');
			// console.log(obj);
			
			let items = '';
			for (let i=0; i<obj.length; i++) {
				// <li><a href="#!1" onclick="fetchAjax('1')">1절 가사</a></li> 모양을 만든다.
				let item = '<li><a href="#!' + (i + 1) + '" onclick="fetchAjax(\'' 
					+ (i + 1) + '\')">' + obj[i] + '</a></li>';
				// console.log(item);
				items += item;
			}
			$('#list2').html(items);
		});
	});
	*/
	
	/*
	fetch('list2')
		.then(res => res.text()
			.then(data => {
				let obj = data.split(',');
				let items = '';
				for (let i=0; i<obj.length; i++) {
					let item = '<li><a href="#!' + (i + 1) + '" onclick="fetchAjax(\'' 
						+ (i + 1) + '\')">' + obj[i] + '</a></li>';
					items += item;
				}
				$('#list2').html(items);
			})
	);
	*/
	
	fetch('list2')
		.then(res => res.text())
		.then(data => {
			let obj = data.split(',');
			let items = '';
			for (let i=0; i<obj.length; i++) {
				let item = '<li><a href="#!' + (i + 1) + '" onclick="fetchAjax(\'' 
					+ (i + 1) + '\')">' + obj[i] + '</a></li>';
				items += item;
			}
			$('#list2').html(items);
		});

});









