package cleancode;

/**
 * Main application entry point.
 */
public class Application {

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();

        Customer john = new Customer("John Doe");
        Customer jane = new Customer("Jane Smith");

        manager.addCustomer(john);
        manager.addCustomer(jane);

        // Orders now belong to customers
        manager.addOrder(john, new Order("Order1"));
        manager.addOrder(jane, new Order("Order2"));

        manager.processOrders(john);
        manager.generateReport();
    }
}
