$(() => {
	
//	$('div b').css({'font-size': '30px', 'color': 'purple'});
	$('div').find('b').css({'font-size': '30px', 'color': 'tomato'});
	
//	$('#chd').text('손오공');
	$('div').children('#chd').html('<i>사오정</i>');
	
//	$('span').css('backgroundColor', 'skyblue');
	$('span').parent().css('backgroundColor', 'hotpink');
	$('span').parents('div').css('backgroundColor', 'yellowgreen');
	
	$('p').eq(2).next().css('backgroundColor', 'lime');
	$('p').eq(2).prev().css('backgroundColor', 'skyblue');
	
});


















