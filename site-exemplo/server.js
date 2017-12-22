var fs = require('fs.extra');
var path = require('path');
var express = require("express");
var colors = require('colors');
var settings = require('./config/settings');
var environment = require('./config/environment');
var security = require('./config/security');
var routes = require("./config/routes");

module.exports.start = function(done) {
    var app = express();
    var router = express.Router();

    app.use(express.static(__dirname + '/ui'));

    security(app);

    environment(app);

    routes(app, router);

    var server = app.listen(settings.port, function() {
        console.log(("Listening on port ..." + server.address().port).green);

        if (done) {
            return done(null, app, server); // If someone ran: "node server.js" then automatically start the server
            if (path.basename(process.argv[1], '.js') == path.basename(__filename, '.js')) {
                module.exports.start()
            }
        }
    }).on('error', function(e) {
        if (e.code == 'EADDRINUSE') {
            console.log('Address in use. Is the server already running?'.red);
        }
        if (done) {
            return done(e);
        }
    });
}

//If someone ran: "node server.js" then automatically start the server
if (path.basename(process.argv[1], '.js') == path.basename(__filename, '.js')) {
    module.exports.start()
}
