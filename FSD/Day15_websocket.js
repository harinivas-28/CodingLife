const WebSocket = require('ws');

const server = new WebSocket.Server({ port: 8080 });

let clients = new Set();

server.on('connection', (ws) => {
    clients.add(ws);
    console.log('New client connected. Total clients:', clients.size);

    ws.on('message', (data) => {
        const message = data.toString().trim(); 
        console.log('Received:', message);

        clients.forEach(client => {
            if (client.readyState === WebSocket.OPEN) {
                client.send(message);
            }
        });
    });

    ws.on('close', () => {
        clients.delete(ws);
        console.log('Client disconnected. Total clients:', clients.size);
    });
});

console.log('WebSocket server is running on ws://localhost:8080');