const WebSocket = require('ws')
const mongoose = require('mongoose');

mongoose.connect("mongodb://localhost:27017/carDB", {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(console.log("Connected to MongoDB"))
.catch(err=>console.log("Mongo Connection Error: "+err));

const carSchema = mongoose.Schema({
    id: Number,
    brand: String,
    model: String,
    year: Number,
    topspeed: Number,
});

const Car = mongoose.model('Car', carSchema);

const server = new WebSocket.Server({port: 8080});
console.log("Websocket is running at ws://localhost:8080");

let currId = 1;
server.on('connection', (ws)=>{
    console.log('New Client Connected!');
    ws.on('message', async (msg)=>{
        try {
            console.log("Received: "+msg.toString());
            const parts = msg.toString().split(" ");
            const command = parts[0].toUpperCase();
            if(command==="INSERT"){
                const [brand, model, year, topspeed] = parts.slice(1);
                if(isNaN(topspeed)){
                    ws.send(JSON.stringify({status:'fail', message:'Top speed is not available'}));
                }
                await new Car({id:currId, brand, model, year:+year, topspeed:+topspeed}).save();
                ws.send("Data Inserted Succesfully!");
            } else if(command.startsWith("RETRIEVE")){
                const query = command == "RETRIEVE_BY_BRAND" ? {brand: parts[1]} : {};
                const cars = Car.find(query);
                if(cars.length==0){
                    ws.send(JSON.stringify({status:'success', message:'No Data found!', data: []}));
                } else {
                    const response = cars.map(c=>`ID: ${c.id}, Brand: ${c.brand}, Model: ${c.model}, Year: ${c.year}, Topspeed: ${c.topspeed}`).join("\n");
                    ws.send(response);
                }
            } else {
                ws.send(JSON.stringify({status:'error',message:'Invalid Command!'}));
            }
        } catch(err) {
            ws.send(JSON.stringify({status:'error', message:err.message}));
        }
    });

    ws.on('close', ()=>{
        console.log("Client Disconnected!");
    })
});
