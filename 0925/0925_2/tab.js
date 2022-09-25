var 버튼 = $('.tab-button');
var 콘텐츠 = $('.tab-content');

$('.list').click(function(e){
    parseInt(탭열기(e.target.dataset.id));

});

//dataset 이용하기
console.log(document.querySelector('.tab-button').dataset.id);


function 탭열기(숫자){
        버튼.removeClass('orange');
        버튼.eq(숫자).addClass('orange');
        콘텐츠.removeClass('show');
        콘텐츠.eq(숫자).addClass('show');
}

//html 추가하는 방법 1 (더 빠름)
    var a = document.createElement('p');
    a.innerHTML= 'TEST';
    document.querySelector('#test').appendChild(a);

//html 추가하는 방법 2
    var template = '<p>TEST</p>';
    document.querySelector('#test').insertAdjacentHTML('beforeend', template);
    $('#test').append(template);

$('.form-select').on('input', function() {
   //console.log($('.form-select').val());
   var optionValue = $('.form-select').val();
   var additionalOption = $('.form-select').eq(1);
   var pantsSize = [28, 30, 32, 34, 36, 38];
   var shirtsSize = [95, 100, 105]

    if(optionValue == '바지'){
        //console.log('바지');
        additionalOption.removeClass('form-hide');
        additionalOption.html('');

        /*for (var i = 0 ; i < pantsSize.length ; i++){
            var template = '<option>' + pantsSize[i] + '</option>';
            additionalOption.append(template);
        }*/

        //forEach 반복문 이용
        pantsSize.forEach(function(i){
            additionalOption.append('<option>' + i + '</option>');
        });

    } else if(optionValue == '셔츠'){
        additionalOption.removeClass('form-hide');
        additionalOption.html('');
        /*var template = '<option>100</option><option>105</option>';
        additionalOption.html(template);*/
        shirtsSize.forEach(function(i){
            additionalOption.append('<option>' + i + '</option>');
        });


    } else if(optionValue == '모자'){
        additionalOption.removeClass('form-hide');
        var template = '<option>94</option><option>96</option>';
        additionalOption.html('');
        additionalOption.html(template);
    };

    var obj = {name : 'kim', age : '25'};

    for (var key in obj){
        console.log(obj[key]);
    }
});
