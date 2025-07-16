const mysql = require('mysql2');

const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '28704',
    database: 'business_db'
});

db.connect(err => {
    if(err) console.log('Error'+ err);
    else console.log("Connected to MySQL!");
});

module.exports = db;