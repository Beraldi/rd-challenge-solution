/**
 * http://usejsdoc.org/
 */

'use strict';

var path = require('path');

var settings = {
    path: path.normalize(path.join(__dirname, '..')),
    port: process.env.PORT || 8080,
    contentType: "application/json",
    smtpConfig: {
        host: 'smtp.rd.com',
        port: 465,
        secure: true, // use SSL
        auth: {
            user: 'rd@rd.com.br',
            pass: 'rd123'
        }
    },
    emailReceiver: [{
        name: "Bruno Beraldi",
        email: "bruno.beraldi@outlook.com"
    }]
};

module.exports = settings;
