package Problems.java;

/*
🎯 Objective
Design and implement a multi-threaded Warehouse Order Fulfillment System using Java.
Your application should simulate how customer orders are received, validated,
and fulfilled by warehouse workers — with results displayed in the same order
as input using interfaces, custom exceptions, and synchronized thread execution.

🧩 System Description
Your application should:
	 - Accept a list of customer orders.
	 - Validate each order using an interface-based validator.
	 - Process orders using multiple worker threads (2).
	 - Use synchronized access to a shared Queue<Order> to ensure no order is processed twice.
	 - Raise custom exceptions for:
		- Invalid products (not in the list)
		- Invalid quantities (≤ 0)

NOTE: Do not change the Main class code.

🛠️ Tasks to Complet:
You are required to implement the following classes and features:

✅ Class: Order
	- Fields: customerName, productName, quantity
	- Constructor to initialize all fields.

✅ Class: IndexedOrder
    - Fields: index, Order order
    - Constructor to initialize all fields (Used to preserve input position)

✅ Interface: OrderValidator
	- Method:
		- void validate(Order order) throws ProductNotFoundException, InvalidQuantityException;

✅ Class: SimpleOrderValidator (implements OrderValidator)
	- Valid Products: "Laptop", "Phone", "Keyboard", "Mouse"
	- Throw:
		- ProductNotFoundException if product is invalid.
		- InvalidQuantityException if quantity is <= 0.

✅ Custom Exceptions:
	- ProductNotFoundException extends Exception
	- InvalidQuantityException extends Exception

✅ Class: OrderProcessor (implements Runnable)
	- Fields: IndexedOrder, OrderValidator, and a shared
	          ConcurrentHashMap<Integer, String> for output
	- Method: run()
		- Validate the order.
		- If valid: add success message to the output map
		- If invalid: add failure message with exception name
		- Simulate work using Thread.sleep()

Sample Input
------------
4
Alice Laptop 3
Bob Phone 2
Charlie Mouse 0
Dana Camera 5

Sample Output
-------------
Order accepted: Alice ordered 3 of Laptop
Order accepted: Bob ordered 2 of Phone
Order failed: Charlie - InvalidQuantityException
Order failed: Dana - ProductNotFoundException

Hints:
------
- Use synchronized access or thread-safe structures to manage concurrency.
- Use Thread.sleep() (1000–2000 ms) to simulate real work.
- Use Set<String> for product validation.
- Use Map<Integer, String> to preserve output order




------------*/


import java.util.*;
import java.util.concurrent.*;

public class Day79P1_Design {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Queue<IndexedOrder> orderQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            Order order = new Order(parts[0], parts[1], Integer.parseInt(parts[2]));
            orderQueue.add(new IndexedOrder(i, order));
        }

        OrderValidator validator = new SimpleOrderValidator();
        Map<Integer, String> outputMap = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(2); // 2 workers
        List<Future<?>> futures = new ArrayList<>();

        while (!orderQueue.isEmpty()) {
            IndexedOrder indexedOrder = orderQueue.poll();
            futures.add(executor.submit(new OrderProcessor(indexedOrder, validator, outputMap)));
        }

        for (Future<?> f : futures) f.get();
        executor.shutdown();

        for (int i = 0; i < n; i++) {
            System.out.println(outputMap.get(i));
        }
    }
}

// ✅ Order POJO
class Order {
    // Fields: customerName, productName, quantity
    // Constructor to initialize all fields.
    String customerName, productName;
    int quant;
    public Order(String cn, String pn, int q){
        this.customerName = cn;
        this.productName = pn;
        this.quant = q;
    }

}

class IndexedOrder {
    int index;
    Order order;

    public IndexedOrder(int index, Order order) {
        this.index = index;
        this.order = order;
    }
}

// ✅ Interface
interface OrderValidator {
    void validate(Order order) throws ProductNotFoundException, InvalidQuantityException;
}

// 🚧 TODO: Implement this class
class SimpleOrderValidator implements OrderValidator {
    private static final Set<String> validProducts = Set.of("Laptop", "Phone", "Keyboard", "Mouse");

    public void validate(Order order) throws ProductNotFoundException, InvalidQuantityException {
        // TODO:
        // 1. If product is not in validProducts, throw ProductNotFoundException
        // 2. If quantity <= 0, throw InvalidQuantityException
        if(!validProducts.contains(order.productName)){
            throw new ProductNotFoundException("Invalid product: " + order.productName);
        }
        if(order.quant<=0){
            throw new InvalidQuantityException("Invalid product: " + order.productName);
        }
    }
}

// 🚧 TODO: Define this custom exception
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg){
        // System.out.println("ProductNotFoundException");
        super(msg);
    }
}

// 🚧 TODO: Define this custom exception
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg){
        // System.out.println("InvalidQuantityException");
        super(msg);
    }
}

// 🚧 TODO: Implement run() with synchronized processing
class OrderProcessor implements Runnable {
    private IndexedOrder indexedOrder;
    private OrderValidator validator;
    private Map<Integer, String> outputMap;

    // Implement Contructor
    public OrderProcessor(IndexedOrder io, OrderValidator ov, Map<Integer, String> map){
        this.indexedOrder = io;
        this.validator = ov;
        this.outputMap = map;
    }
    public void run() {
        String res;
        Order order = indexedOrder.order;
        try {
            // TODO: Validate and process the order
            validator.validate(order);
            Thread.sleep(1000 + new Random().nextInt(1001));
            res = "Order accepted: "+order.customerName+" ordered "+order.quant+" of "+order.productName;
        } catch (Exception e) {
            // TODO: Save failure message
            res = "Order failed: "+order.customerName+" - "+e.getClass().getSimpleName();
        }
        outputMap.put(indexedOrder.index, res);
    }
}