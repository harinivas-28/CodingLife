const WebSocket = require('ws');

const server = new WebSocket.Server({port:8080});

const clients = new Set();

server.on('connection', (ws)=>{
    clients.add(ws);
    console.log('New client connected: '+ws);
    ws.on('message', (msg)=>{
        console.log(`Received: ${msg.toString()}`);
        clients.forEach(c=>{
            if(c.readyState===WebSocket.OPEN){
                c.send(msg);
            }
        });
    });
    ws.on('close', ()=>{
        clients.delete(ws);
        console.log('Client Disconnected: '+ws);
    });
});