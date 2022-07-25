const express = require('express');
const app = express();

app.listen(9095, function(){
    console.log('listening on 9095')
});

 app.get('/', function(req,res){
    res.sendFile(__dirname + '/index.html')
 });
