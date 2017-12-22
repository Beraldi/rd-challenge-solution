/**
 * http://usejsdoc.org/
 */

'use strict';

var path = require('path');
var settings = require('./settings');
var bunyan = require('bunyan');
var RotatingFileStream = require('bunyan-rotating-file-stream');
var strformat = require('strformat');
var nodemailer = require('nodemailer');
var logDirectory = path.resolve(__dirname + '/../log/');

var log = bunyan.createLogger({
    name: 'Sidarta log',
    level: 'error',
    streams: [{
        type: 'raw',
        stream: new RotatingFileStream({
            path: logDirectory + '/error-%Y%m%d.log',
            period: '1d', // daily rotation
            totalFiles: 10, // keep up to 10 back copies
            rotateExisting: true, // Give ourselves a clean file when we start up, based on period
            threshold: '5m', // Rotate log files larger than 5 megabytes
            totalSize: '10m', // Don't keep more than 10mb of archived log files
            gzip: true // Compress the archive log files to save space
        })
    }]
});

// Create a SMTP transport object
var transporter = nodemailer.createTransport(settings.smtpConfig);
//var transporter = nodemailer.createTransport(strformat('smtps://{0}%40adtechsidarta.com.br:{1}@smtp.zoho.com', settings.smtpConfig.auth.user, settings.smtpConfig.auth.pass));

function showError(send, err) {
    send["statusCode"] = err.statusCode || 500;
    delete err.statusCode;
    send["error"] = err;
    return send;
}

var appRouter = function(app, router) {

    router.use(function(err, req, res, next) {
        // Do logging and user-friendly error message display
        if (err) {
            console.error(err);
            res.status(500).send('internal server error');
        }

        console.log("/" + req.method);

        log.info("/" + req.method);

        next();
    });

    app.get("/", function(req, res) {
        res.sendFile(path.join(__dirname + '/../ui/coming-soon.html'));
    });

    app.get("/index-default-particles", function(req, res) {
        res.sendFile(path.join(__dirname + '/../ui/index-default-particles.html'));
    });

    app.post("/sendemail", function(req, res) {

        // Message object
        var mailOptions = {

            // sender info
            from: 'contato@adtechsidarta.com.br',

            // Comma separated list of recipients
            to: strformat('{0}, {1}, {2}, {3}', settings.emailReceiver[0].email, settings.emailReceiver[1].email, settings.emailReceiver[2].email, settings.emailReceiver[3].email),

            // Subject of the message
            subject: strformat('Sidarta | New Message Received: {0}', req.body.msg_subject),

            // plaintext body
            // text: req.message

            // HTML body
            html: strformat('Nome: {0} <br/>Email: {1}', req.body.name, req.body.email) + '<br/><br/>Mensagem: ' + req.body.message
        };

        // send mail with defined transport object
        transporter.sendMail(mailOptions, function(error, info) {
            if (error) {
                log.error(error);
                console.log(error);
                //return res.status(500).send('Error occured');
            }
            //console.log('Message sent: ' + info.response);
        });

        res.status(200).send("success");
    });

    app.use("*", function(req, res) {
        res.status(404).send("Oh uh, something went wrong");
    });

}

module.exports = appRouter;
