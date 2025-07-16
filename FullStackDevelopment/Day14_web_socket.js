/*
<!--

Real-Time Group Chat using WebSockets

You are required to build a real-time group chat application using WebSockets, 
where multiple users (clients) can join a chatroom and exchange messages in 
real-time. The application must consist of a WebSocket server and a browser-based 
client. All messages sent by any client must be visible to all other connected 
clients, including the sender — similar to a WhatsApp group.


Functional Requirements:

1. WebSocket Server (Node.js):
------------------------------
You must implement a WebSocket server with the following behavior:
	- Accept connections from multiple clients.
	- Maintain a list of all connected clients.
	- When a message is received from any client:
		- Broadcast that message to all connected clients.
	- Handle client disconnections and remove them from the active list.

Use the ws npm package to create the server. The server should run on ws://localhost:8080.

2. Web-based Client (HTML + JavaScript):
----------------------------------------
You must create a basic client interface with the following requirements:
	- Connect to the WebSocket server at ws://localhost:8080.
	- The page should have:
		- A <div> with id="chat" that shows all chat messages.
		- An <input> box with id="msg" to type the message.
		- A <button> that, when clicked, sends the message.
	- When a message is received from the server:
		- It must be displayed as a new paragraph <p> inside the #chat area.
	- When the user sends a message:
		- It should be sent to the server using WebSocket.
		- The input box should be cleared after sending.
		
================================================================================		
Example URL value=>   http://192.168.xx.xx:5500/index.html

-->

<config>
    <url value="http://192.168.5.59:5500/FSD/Day15_client.html"></url>
</config>


*/
const WebSocket = require('ws');

const server = new WebSocket.Server({ port: 8080 });
const employees = []; 
let clients = [];
const insertEmp = (name, salary) => {
    const id = employees.length + 1;
    employees.push({ id, name, salary: parseFloat(salary) });
};

const retrieveAll = () => {
    return employees.map(emp => `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`).join('\n');
};

server.on('connection', (ws) => {
    clients.push(ws);
    console.log("New client connected. Total clients:", clients.length);
    console.log('Client connected.');

    ws.on('message', (message) => {
        console.log(`Received: ${message}`);
        const command = message.toString().trim();
        const [action, name, salary] = command.split(' ');

        if (action === 'INSERT' && name && salary) {
            insertEmp(name, salary);
            ws.send('Employee inserted successfully.');
        } else if (action === 'RETRIEVE') {
            const response = retrieveAll();
            ws.send(response || 'No employees found.');
        } else {
            ws.send('Invalid command.');
        }
    });

    ws.on('close', () => {
        clients = clients.filter(client => client!=ws);
        console.log('Client disconnected. Total clients: ',clients.length);
    });
});

console.log('WebSocket server is running on ws://localhost:8080');
