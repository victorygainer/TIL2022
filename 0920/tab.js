var 버튼 = $('.tab-button');
var 콘텐츠 = $('.tab-content');



for (let i = 0; i < 버튼.length; i++) {
    버튼.eq(i).on('click', function(){
        버튼.removeClass('orange');
        버튼.eq(i).addClass('orange');
        콘텐츠.removeClass('show');
        콘텐츠.eq(i).addClass('show');
    });
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