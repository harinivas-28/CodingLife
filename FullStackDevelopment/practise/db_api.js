const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '28704',
  database: 'test_db'
});

db.connect(err => {
  if (err) throw err;
  console.log('Connected to MySQL');
});

app.post('/query', (req, res) => {
  const { query } = req.body;
  db.query(query, (err, results) => {
    if (err) {
      res.json({ error: err.message });
    } else {
      res.json({ results });
    }
  });
});

app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
