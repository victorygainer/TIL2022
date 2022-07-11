$(() => {
	
	$('#emp_search').click(() => {
		// 조회할 사원 번호를 얻어온다.
		let empid = $('input[name=empid]').val();
		// console.log(empid);
		// 3자리 숫자만 입력받는다.
		if (!isNaN(empid) && empid.length == 3) {
			
//	===== jquery Ajax ==========================================================

			$.ajax({
				url: "emplist.xml", // 호출할 페이지 주소(요청) 또는 읽어올 xml 파일명
				cache: false, // 사용자 캐시 사용 여부
				method: 'get', // 서버에 데이터를 전송하는 방식
				asyn: true, // 비동기 방식을 사용한다.(false는 동기 방식을 사용한다.)
				dataType: 'xml', // 전송받는 데이터 타입(xml, json, html, script)
//				data: { // method가 post일 경우 서버로 전송할 데이터
//					'key': 'value'
//				}
				// success는 Ajax 요청이 성공했을 때 실행할 콜백 함수를 적는다.
				// Ajax 요청이 성공하면 응답받은 데이터가 콜백 함수의 인수로 넘어온다.
//				success: function (data) {
				success: data => {
					// alert('요청 성공');
					// console.log(data);
					
					// 입력한 사원 번호에 해당되는 모든 데이터를 출력해야 하기 때문에 검색한 사원 번호의
					// 부모 요소를 선택한다.
//					let empInfo = $(data).find('EMPLOYEE_ID:contains(' + empid + ')');
					let empInfo = $(data).find('EMPLOYEE_ID:contains(' + empid + ')').parent();
					// console.log(empInfo.html());
					
					// 검색된 사원 번호에 해당되는 데이터가 있으면 화면에 출력한다.
					// 검색된 사원 번호의 부모는 <ROW>이므로 검색된 내용에 'ROW'가 있으면 테이블에
					// 데이터를 출력하고 없으면 에러 메시지를 출력한다. 
					if ($(empInfo).is('ROW')) {
						// console.log('있음');
						
						// table 태그의 자손 input의 개수만큼 반복하며 xml 파일에서 읽어온 데이터를
						// 채워 넣는다.
						$('table input').each(index => {
							// console.log(index);
							let search = $(empInfo).children().eq(index).text();
							// console.log(search);
							$('table input').eq(index).val(search);
						});
						
					} else {
						// console.log('없음');
						alert(empid + ' 번은 존재하지 않는 사원 번호 입니다.');
					}
					$('input[name=empid]').val('');
					$('input[name=empid]').focus();
				},
				// error는 Ajax 요청이 실패했을 때 실행할 콜백 함수를 적는다.
				// Ajax 요청이 실패하면 콜백 함수의 인수로 오류 정보가 넘어온다.
				// status => 에러 코드, statusText => 상태 메시지
//				error: function (e) {
				error: e => {
					// alert('요청 실패');
					console.log(e.status + ': ' + e.statusText);
				}
			});

//	===== jquery Ajax ==========================================================
			
		} else {
			alert('정확한 사원 번호를 입력하세요');
			$('input[name=empid]').val('');
			$('input[name=empid]').focus();
		}
	})
	
});





















