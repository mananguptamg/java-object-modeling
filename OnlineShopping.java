import java.util.ArrayList;
import java.util.List;

// Product class -> Independent Entity
class Product {
    private final String productName;
    private final double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}

// Order class -> Aggregation of Products
class Order {
    private final int orderId;
    private final List<Product> orderedProducts;
    private final Customer customer;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderedProducts = new ArrayList<>();
    }

    // Method to add a product to the order
    public void addProductToOrder(Product product) {
        orderedProducts.add(product);
    }

    // Method to display order details
    public void printOrderSummary() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Ordered Products:");
        
        if (orderedProducts.isEmpty()) {
            System.out.println("   No products added yet.");
        } else {
            for (Product product : orderedProducts) {
                System.out.println("   - " + product.getProductName() + " "+ product.getProductPrice() );
            }
        }
        System.out.println();
    }
}

// Customer class -> Association with Order
class Customer {
    private final String customerName;
    private final List<Order> orderHistory;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.orderHistory = new ArrayList<>();
    }

    public void placeNewOrder(Order order) {
        orderHistory.add(order);
    }

    public String getCustomerName() {
        return customerName;
    }
}

// Main class -> Simulating an E-Commerce System
public class OnlineShopping {
    public static void main(String[] args) {
        // Creating customer instances
        Customer amit = new Customer("Amit");
        Customer arjun = new Customer("Arjun");

        // Creating product instances
        Product gamingLaptop = new Product("Gaming Laptop", 1500);
        Product wirelessEarbuds = new Product("Wireless Earbuds", 200);
        Product smartwatch = new Product("Smartwatch", 300);

        // Creating order instances & adding products
        Order arjunOrder = new Order(101, arjun);
        arjunOrder.addProductToOrder(gamingLaptop);
        arjunOrder.addProductToOrder(wirelessEarbuds);
        arjun.placeNewOrder(arjunOrder);

        Order amitOrder = new Order(102, amit);
        amitOrder.addProductToOrder(smartwatch);
        amit.placeNewOrder(amitOrder);

        // Displaying order summaries
        arjunOrder.printOrderSummary();
        amitOrder.printOrderSummary();
    }
}


//SampleOutput
// Order ID: 101
// Customer: Arjun
// Ordered Products:
//    - Gaming Laptop 1500.0
//    - Wireless Earbuds 200.0


// Order ID: 102
// Customer: Amit
// Ordered Products:
//    - Smartwatch 300.0