function foodShow() {
//	alert('foodShow()');
	let food = document.getElementsByName('food')[0];
	console.log(food);
//	food는 select 태그 객체이므로 length는 select 태그의 항목(option 태그)의 개수를 얻어온다.
	console.log(food.length);
//	options는 select 태그 내부의 option 태그들을 모아놓은 객체이다.
	console.log(typeof food.options);
//	selectedIndex는 options 객체에서 몇 번째 option이 선택되었나 얻어온다.
	console.log(food.options.selectedIndex);
	let index = food.options.selectedIndex;
	console.log(food.options[index].value);
}

function foodShow2() {
	let food = document.getElementsByName('food')[1];
//	console.log(food.length);
	let str = '';
	for (let i=0; i<food.length; i++) {
		// value는 특정 option 객체의 값을 얻어온다.
		// console.log(food[i].value);
		// selected는 특정 option 객체가 선택되었나(true) 선택되지 않았나(false)를 알아낼 수 있다.
		// console.log(food[i].selected);
		// console.log(food[i].value + (food[i].selected ? ' 선택됨' : ' 선택안됨'));
		if (food[i].selected) {
			str += food[i].value + ' ';
		}
	}
	console.log(str.length > 0 ? str : '없음');
}


















