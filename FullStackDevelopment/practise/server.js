const express = require('express');
const cors = require('cors');
const db = require('./db');
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

// getting all customers
app.get('/customers', (req, res)=>{
    const q = "select * from customers";
    db.query(q, (err, results)=>{
        if(err){
            res.json({"ERROR": err});
        } else {
            res.json({'status':201, 'results':results});
        }
    });
});
// get customers by id
app.get('/customers/:id', (req, res)=>{
    const id = req.params.id;
    const q = `select * from customers where id=?`;
    db.query(q, [id],(err, results)=>{
        if(err){
            res.status(500).json({"ERROR": err});
        } else {
            res.json({'status':201, 'results':results});
        }
    });
});
// add customer
app.post('/customers', (req, res)=>{
    const {name, email, phone} = req.body;
    const q = `insert into customers (name, email, phone) values (?, ?, ?);`;
    db.query(q,[name, email, phone], (err, results)=>{
        if(err){
            res.status(500).json({"ERROR": err});
        } else {
            res.status(201).json({'message':'customer added successfully', 'results':results.insertId});
        }
    });
});
// update customer
app.put('/customers/:id', (req, res)=>{
    const id = req.params.id;
    const {name, email, phone} = req.body;
    const q = `update customers set name=?, email=?, phone=? where id=?`;
    db.query(q,[name, email, phone, id], (err, results)=>{
        if(err){
            res.status(500).json({"ERROR":err});
        } else {
            res.status(201).json({"message":"Customer Updated Successfully"});
        }
    });
});
// delete customer
app.delete('/customers/:id', (req, res)=>{
    const id = req.params.id;
    const q = `delete from customers where id=?`;
    db.query(q,[id], (err, results)=>{
        if(err){
            res.status(500).json({"ERROR": err});
        } else if(results.affectedRows===1){
            res.status(200).json({"message":"customer deleted successfully"});
        } else {
            res.status(201).json({"message": "Customer doesnot exist!"});
        }
    });
});

app.listen(port, ()=>{
    console.log(`Server connected to http://localhost:${port}/`);
});