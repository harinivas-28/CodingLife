/*
<!--
Employee Management WebSocket Application with MongoDB

Objective:
----------
Your task is to develop a WebSocket-based Employee Management System using Node.js and MongoDB. 
The system should allow multiple clients to interact with a database to perform the following operations:
	1. Insert Employee Records (INSERT <name> <salary> <role> <department> <experience>)
	2. Retrieve Employee List (RETRIEVE)
	3. Retrieve Employee List who belongs to a department (RETRIEVE_BY_DEPT <department>)
	
The WebSocket server should be capable of handling multiple concurrent clients and persist employee data in MongoDB.


// MongoDB Employee Schema
const employeeSchema = new mongoose.Schema({
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

Requirements:
-------------
Implement WebSocket Server
	The server should:
		-> Accept multiple client connections. (give a response as "Connected" )
		-> Process incoming commands from clients as discussed above.
		-> Log each received command on the console.
		-> Ensure proper error handling (e.g., invalid salary, missing name, etc.).
		
Expected Behavior
-----------------

============================================================================================
Client Command			                Server Response
============================================================================================
INSERT Alice 50000 Developer IT 5	    "Employee inserted successfully."
INSERT Bob 60000 Manager IT 5	        "Employee inserted successfully."

RETRIEVE				                "ID: 1, Name: Alice, Salary: 50000, Role: Developer, Department: IT, Experience: 5 years"
                                        "ID: 2, Name: Bob, Salary: 60000, Role: Manager, Department: IT, Experience: 5 years"

RETRIEVE_BY_DEPT IT                     "ID: 1, Name: Alice, Salary: 50000, Role: Developer, Department: IT, Experience: 5 years"
                                        "ID: 2, Name: Bob, Salary: 60000, Role: Manager, Department: IT, Experience: 5 years"


INVALID					                "Invalid command."
============================================================================================

Note: 
-> Your implementation must use MongoDB for data persistence.
-> The server should run on port 8080.
-> The system should allow multiple clients to connect.


EXAMPLE URL value=>   ws://10.11.xx.xx:8080

-->
<config>
    <url value=""></url>
</config>

*/
const WebSocket = require('ws');
const mongoose = require('mongoose');

const url = 'mongodb://localhost:27017/employeeDB';

mongoose.connect(url, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log("Connected to MongoDB"))
    .catch(err => console.error("MongoDB Connection Error:", err));

const employeeSchema = new mongoose.Schema({
    id: Number,
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number
});

const Employee = mongoose.model('Employee', employeeSchema);

const server = new WebSocket.Server({ port: 8080 });
console.log("WebSocket server is running on port 8080");

let currentId = 1;
let lastInsertedId = null; // Add this to track last inserted ID

server.on('connection', (ws) => {
    console.log("Client connected");

    ws.on("message", async (message) => {
        try {
            console.log("Received: " + message.toString());
            const parts = message.toString().split(" ");
            const command = parts[0].toUpperCase();

            if (command === 'INSERT' && parts.length === 6) {
                const name = parts[1];
                const salary = parseInt(parts[2]);
                const role = parts[3];
                const department = parts[4];
                const experience = parseInt(parts[5]);

                if (!isNaN(salary) && !isNaN(experience)) {
                    const employee = new Employee({ id: currentId, name, salary, role, department, experience });
                    await employee.save();
                    lastInsertedId = currentId;
                    currentId++;
                    ws.send("Employee inserted successfully.");
                } else {
                    ws.send(JSON.stringify({ status: 'error', message: "Invalid salary or experience." }));
                }
            }
            else if (command === 'RETRIEVE' && parts.length === 1) {
                const employees = await Employee.find();
                if (employees.length === 0) {
                    ws.send(JSON.stringify({ status: 'success', message: "No employees found", data: [] }));
                } else {
                    const response = employees.map(e =>
                        `ID: ${e.id}, Name: ${e.name}, Salary: ${e.salary}, Role: ${e.role}, Department: ${e.department}, Experience: ${e.experience} years`
                    ).join("\n");
                    ws.send(response);
                }
            }
            else if (command === 'RETRIEVE_BY_DEPT' && parts.length === 2) {
                const department = parts[1];
                const employees = await Employee.find({ department });

                if (employees.length === 0) {
                    ws.send(JSON.stringify({ status: 'success', message: `No employees found in ${department} department`, data: [] }));
                } else {
                    const response = employees.map(e =>
                        `ID: ${e.id}, Name: ${e.name}, Salary: ${e.salary}, Role: ${e.role}, Department: ${e.department}, Experience: ${e.experience} years`
                    ).join("\n");
                    ws.send(response);
                }
            }
            else {
                ws.send(JSON.stringify({ status: 'error', message: "Invalid command." }));
            }
        } catch (error) {
            ws.send(JSON.stringify({ status: 'error', message: error.message }));
        }
    });

    ws.on('close', () => {
        console.log("Client disconnected");
    });
});