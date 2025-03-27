const mongoose = require('mongoose');
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 }); // Fixed WebSocket.Server instantiation

mongoose.connect('mongodb://127.0.0.1:27017/tempDB', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
}).then(() => console.log('Connected to MongoDB'))
.catch((err) => console.log('MongoDB Error: ', err));

const tempSchema = new mongoose.Schema({
    name: String,
    age: Number,
    maths: Number,
    physics: Number,
    chemistry: Number,
    date: { type: Date, default: Date.now }, // Added default value for date
});

const Temp = mongoose.model('Temp', tempSchema);

wss.on('connection', (ws) => {
    console.log('New Client Connected');
    ws.on('message', async (data) => {
        try {
            console.log(`Received: ${data}`);
            const parts = data.split(' ');
            const action = parts[0].toUpperCase();
            if (action === 'INSERT') {
                const name = parts[1];
                const age = parseInt(parts[2]);
                const maths = parseFloat(parts[3]); // Fixed variable name from math to maths
                const physics = parseFloat(parts[4]);
                const chemistry = parseFloat(parts[5]); // Fixed variable name from che to chemistry
                const t = new Temp({ name, age, maths, physics, chemistry });
                await t.save();
                ws.send("Data Inserted Successfully");
            } else if (action === 'RETRIEVE') {
                const dbData = await Temp.find({}, { _id: 0 });
                if (dbData.length > 0) { // Fixed condition to check for data
                    const response = dbData.map(t => 
                        `Name: ${t.name}, Age: ${t.age}, Maths: ${t.maths}, Physics: ${t.physics}, Chemistry: ${t.chemistry}, Uploaded Date: ${t.date}`
                    );
                    ws.send(response.join('\n'));
                } else {
                    ws.send("No Data!");
                }
            } else if (action === 'RETRIEVE_BY_NAME') {
                const name = parts[1];
                const dbData = await Temp.find({ name: name }, { _id: 0 });
                if (dbData.length > 0) { // Fixed condition to check for data
                    const response = dbData.map(t => 
                        `Name: ${t.name}, Age: ${t.age}, Maths: ${t.maths}, Physics: ${t.physics}, Chemistry: ${t.chemistry}, Uploaded Date: ${t.date}`
                    );
                    ws.send(response.join('\n'));
                } else {
                    ws.send("No Data!");
                }
            } else {
                console.log("Invalid Command");
                ws.send(JSON.stringify({ status: 'error', message: 'Invalid' }));
            }
        } catch (err) {
            console.log(err);
            ws.send(JSON.stringify({ status: 'error', message: 'Error Occurred' }));
        }
    });
    ws.on('close', () => {
        console.log('Client Disconnected');
    });
});