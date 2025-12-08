package cleancode;

public class Application {

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();

        Customer john = new Customer("John Doe");
        Customer jane = new Customer("Jane Smith");

        manager.addCustomer(john);
        manager.addCustomer(jane);

        manager.addOrder(new Order("Order1"));
        manager.addOrder(new Order("Order2"));

        manager.processOrders(john);
        manager.generateReport();
    }
}
