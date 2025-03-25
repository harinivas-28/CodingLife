const WebSocket = require('ws');

const server = new WebSocket.Server({ port: 8080 });
const employees = []; 

const insertEmp = (name, salary) => {
    const id = employees.length + 1;
    employees.push({ id, name, salary: parseFloat(salary) });
};

const retrieveAll = () => {
    return employees.map(emp => `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`).join('\n');
};

server.on('connection', (ws) => {
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
        console.log('Client disconnected.');
    });
});

console.log('WebSocket server is running on ws://localhost:8080');
