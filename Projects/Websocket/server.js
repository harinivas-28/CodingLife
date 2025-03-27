const WebSocket = require('ws');
const os = require('os');

function getLocalIP() {
    const interfaces = os.networkInterfaces();
    for (const interfaceName of Object.keys(interfaces)) {
        const addresses = interfaces[interfaceName];
        for (const addr of addresses) {
            if (addr.family === 'IPv4' && !addr.internal) {
                return addr.address;
            }
        }
    }
    return '127.0.0.1'; // Fallback to localhost if no IP is found
}

const IP = getLocalIP();
const PORT = 8080;
const wss = new WebSocket.Server({ host: IP, port: PORT });
const clients = new Map();
let messageId = 1; // Add message counter

wss.on('connection', (ws) => {
    console.log('New Client Connected');
    ws.on('message', (message) => {
        const data = JSON.parse(message);
        if (data.type === 'join') {
            clients.set(ws, data.name);
            broadcastUserList();
            broadcast({ type: 'join', name: data.name });
        } else if (data.type === 'typing') {
            broadcast({ type: 'typing', name: data.name, isTyping: data.isTyping });
        } else if (data.type === 'chat') {
            broadcast({ 
                type: 'chat', 
                id: messageId++,
                name: data.name, 
                text: data.text,
                replyTo: data.replyTo
            });
        } else if (data.type === 'file') {
            broadcast({ 
                type: 'file', 
                name: data.name, 
                fileName: data.fileName,
                fileData: data.fileData,
                fileType: data.fileType
            });
        }
    });

    ws.on('close', () => {
        console.log('Client Disconnected!');
        const name = clients.get(ws);
        clients.delete(ws);
        broadcastUserList();
        broadcast({ type: 'leave', name });
    });
});

function broadcast(message) {
    const messageString = JSON.stringify(message);
    for (const client of clients.keys()) {
        if (client.readyState === WebSocket.OPEN) {
            client.send(messageString);
        }
    }
}

function broadcastUserList() {
    const userList = Array.from(clients.values());
    broadcast({ type: 'userList', users: userList });
}

console.log(`Server listening on ws://${IP}:${PORT}`);