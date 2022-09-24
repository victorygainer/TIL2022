var 버튼 = $('.tab-button');
var 콘텐츠 = $('.tab-content');

$('.list').click(function(e){
    parseInt(탭열기(e.target.dataset.id));

});

//dataset 이용하기
//console.log(document.querySelector('.tab-button').dataset.id);

function 탭열기(숫자){
        버튼.removeClass('orange');
        버튼.eq(숫자).addClass('orange');
        콘텐츠.removeClass('show');
        콘텐츠.eq(숫자).addClass('show');
}

console.log(document.querySelector('.form-select')[0].value);
$('.form-select').on('input', function() {
    let tagArea = document.querySelector('.form-group');
    let new_selectTag = document.createElement('select');
    //console.log(document.querySelectorAll('.form-select').length);
    if (document.querySelector('.form-select').value == '셔츠'){
        //console.log('셔츠');
        if (document.querySelectorAll('.form-select').length < 2){
            new_selectTag.setAttribute('class', 'form-select mt-2');
            new_selectTag.setAttribute('id', 'size');
            new_selectTag.innerHTML = '<option>' + '100' + '</option>' + '<option>' + '105' + '</option>';
            tagArea.appendChild(new_selectTag);
            console.log(document.querySelectorAll('.form-select').length);
        } else {
            $('#size').css('display','block');
        }
    } else {
        $('#size').css('display','none');
    }
});
