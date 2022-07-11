<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한국을 빛낸 100명의 위인들</title>
<link rel="icon" href="./images/logo.png"/>
<link rel="stylesheet" href="./css/fetch.css"/>
</head>
<body>

	<h2><a href="summary.html">한국을 빛낸 100명의 위인들</a></h2>
	
	<ol>
		<li>
			<!-- div 태그에 표시해야 할 내용을 innerHTML에 문자열로 지정한다. 줄 바꾸지 말고 한줄로... -->
			<!-- document.getElementsByTagName('div')[0] -->
			<a href="#" onclick="document.querySelector('div').innerHTML='<h2>한국을 빛낸 100명의 위인들 1절</h2><p>아름다운 이 땅에 금수강산에<br/>단군 할아버지가 터 잡으시고<br/>홍익인간 뜻으로 나라 세우니<br/>대대손손 훌륭한 인물도 많아<br/>고구려 세운 동명왕 백제 온조왕 알에서 나온 혁거세<br/>만주 벌판 달려라 광개토대왕 신라 장군 이사부<br/>백결 선생 떡방아 삼천 궁녀 의자왕<br/>황산벌의 계백 맞서 싸운 관창<br/>역사는 흐른다.</p>'">1절 가사</a>
		</li>
		<li><a href="2.html">2절 가사</a></li>
		<li><a href="3.html">3절 가사</a></li>
		<li><a href="4.html">4절 가사</a></li>
		<li><a href="5.html">5절 가사</a></li>
	</ol>
	
	<div>
		가사가 출력될 영역
	</div>

</body>
</html>