const express = require('express');
const app = express();

app.listen(9095, function(){
    console.log('listening on 9095')
});

// 누군가가 /pet 으로 방문을 하면..
// pet관련된 안내문을 띄워주자

//app.get('/pet', function(요청, 응답){
//    응답.send('펫 용품 쇼핑가능한 사이트입니다.')
//});

 app.get('/pet', function(req, res){
    res.send('펫 용품을 쇼핑가능한 사이트입니다.')
});

 app.get('/beauty', function(req,res){
    res.send('뷰티용품을 쇼핑가능한 사이트입니다.')
 });

 app.get('/', function(req,res){
    res.sendFile(__dirname + '/index.html')
 });