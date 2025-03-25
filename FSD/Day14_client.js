const WebSocket = require('ws');

const ws = new WebSocket('ws://localhost:8080');

ws.on('open', () => {
    console.log('Connected to server');
    ws.send('INSERT John 5000');
    ws.send('INSERT Alice 6000');
    ws.send('RETRIEVE');
});

ws.on('message', (data) => {
    console.log(`Received: ${data}`);
});

ws.on('close', () => {
    console.log('Disconnected from server');
});
