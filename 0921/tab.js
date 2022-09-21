var 버튼 = $('.tab-button');
var 콘텐츠 = $('.tab-content');



// for (let i = 0; i < 버튼.length; i++) {
//     버튼.eq(i).on('click', function(){
//         탭열기(i);
//     });
// };

$('.list').click(function(e){
    //console.log(e.target);
    //console.log(document.querySelectorAll('.tab-button')[0]);

    // if (e.target == document.querySelectorAll('.tab-button')[0]){
    //     탭열기(0);
    // } else if (e.target == document.querySelectorAll('.tab-button')[1]) {
    //     탭열기(1);
    // } else if (e.target == document.querySelectorAll('.tab-button')[2]) {
    //     탭열기(2);
    // };
    //console.log(e.target.dataset.id);
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

/*
버튼.eq(0).on('click', function(){
    버튼.removeClass('orange');
    버튼.eq(0).addClass('orange');
    콘텐츠.removeClass('show');
    콘텐츠.eq(0).addClass('show');
});

버튼.eq(1).on('click', function(){
    버튼.removeClass('orange');
    버튼.eq(1).addClass('orange');
    콘텐츠.removeClass('show');
    콘텐츠.eq(1).addClass('show');
});

버튼.eq(2).on('click', function(){
    버튼.removeClass('orange');
    버튼.eq(2).addClass('orange');
    콘텐츠.removeClass('show');
    콘텐츠.eq(2).addClass('show');
});
*/