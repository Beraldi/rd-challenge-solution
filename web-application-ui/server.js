var express = require("express");
var app = express();
var path = require("path");


app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname + '/index.html'));
});

app.listen(process.env.PORT || 3004);

console.log("Running at Port 3004");
