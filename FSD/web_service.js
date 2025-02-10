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
let users = [
    {id: 1, name: "Alice"},
    {id: 2, name: "Bob"},
];

// GET: Fetch all users
/*
    1st parameter -> URL
    2nd parameter -> Function
*/
app.get('/users', (req, res)=>{
    res.json(users);
});

// GET: Fetch single user by Id
app.get('/users/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    const user = users.find(u=> u.id === userId);
    if(!user){
        return res.status(404).json({message: "User not found"});
    }
    res.json(user); // By default status will be 200 because there is a response being sent 
});

// POST: Add a new user
app.post('/users', (req, res)=>{
    const {name} = req.body;
    if(!name){
        return res.status(400).json({message: "Name is required"});
    }
    const newUser = {
        id: users.length + 1,
        name
    };
    users.push(newUser);
    res.status(201).json(newUser);
});

// PUT: Update user by Id
app.put('/users/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    const {name} = req.body;
    const user = users.find(u => u.id===userId);
    if(!user){
        res.status(404).json({message: "User not found"});
    }
    user.name = name || user.name;
    res.json(user);
});

// DELETE: Remove a user
app.delete('/users/:id', (req, res)=>{
    const userId = parseInt(req.params.id);
    // Filter the user Id's which are not equal to the given id
    // const users = users.filter(u => u.id!==userId);
    const user = users.find(u => u.id===userId);
    if(!user){
        return res.status(404).json({message: "User not found"});
    }
    res.json({message: "User deleted"});
});

app.listen(PORT, ()=>{
    console.log(`Server is running on http://localhost:${PORT}`);
})