const express = require('express'); // express layer(web) on the top of node (JSEP)
const bodyParser = require('body-parser'); // To parse the body
const cors = require('cors'); // cross origin resource sharing (cors)
// if there is no cors, then requests are rejected from other origins

const app = express(); // creates express object
const PORT = 5000;

// Middleware
app.use(bodyParser.json()); // parse json request bodies
app.use(cors());

// In-memory data storage
let orders = [
    {id: 1, customerName: "Azar", totalPrice: 150.0},
];

// GET: Fetch all orders
/*
    1st parameter -> URL
    2nd parameter -> Function
*/
app.get('/orders', (req, res)=>{
    res.json(orders);
});

// GET: Fetch single user by Id
app.get('/orders/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    const user = orders.find(u=> u.id === userId);
    if(!user){
        return res.status(404).json({message: "User not found"});
    }
    res.json(user); // By default status will be 200 because there is a response being sent 
});

// POST: Add a new user
app.post('/orders', (req, res)=>{
    const {customerName, totalPrice} = req.body;
    if(!customerName){
        return res.status(400).json({message: "customerName is required"});
    }
    const newUser = {
        id: orders.length + 1,
        customerName: customerName,
        totalPrice: parseFloat(totalPrice) || 0,
    };
    orders.push(newUser);
    res.status(201).json(newUser);
});

// PUT: Update user by Id
app.put('/orders/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    const {customerName, totalPrice} = req.body;
    const user = orders.find(u => u.id===userId);
    if(!user){
        res.status(404).json({message: "User not found"});
    }
    user.customerName = customerName || user.customerName;
    user.totalPrice = parseFloat(totalPrice) || user.totalPrice;
    res.json(user);
});

// DELETE: Remove a user
app.delete('/orders/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    const user = orders.find(u => u.id===userId);
    if(!user){
        return res.status(404).json({message: "User not found"});
    }
    // If User found
    // Filter the user Id's which are not equal to the given id
    orders = orders.filter(u => u.id!==userId);
    res.json({message: "User deleted"});
});

app.listen(PORT, ()=>{
    console.log(`Server is running on http://localhost:${PORT}`);
})