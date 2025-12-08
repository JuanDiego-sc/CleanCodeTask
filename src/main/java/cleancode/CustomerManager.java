package cleancode;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
  private List<Customer> customers = new ArrayList<>();
  private List<Order> orders = new ArrayList<>();

  public void addCustomer(Customer customer) {
    if (customer == null) {
      System.out.println("Customer cannot be null.");
      return;
    }
    customers.add(customer);
    System.out.println("Added customer: " + customer);
  }

  public void addOrder(Order order) {
    if (order == null) {
      System.out.println("Order cannot be null.");
      return;
    }
    orders.add(order);
    System.out.println("Order added: " + order);
  }

  public void processOrders(Customer customer) {
    if (customer == null) {
      System.out.println("Customer cannot be null.");
      return;
    }
    if (!customers.contains(customer)) {
      System.out.println("Customer not found: " + customer);
      return;
    }
    System.out.println("Processing orders for customer: " + customer);
    for (Order order : orders) {
      System.out.println("Processing order: " + order);
    }
  }

  public void generateReport() {
    printCustomerReport();
    printOrderReport();
  }

  private void printCustomerReport() {
    System.out.println("Customer Report");
    if (customers.isEmpty()) {
      System.out.println("No customers available.");
      return;
    }
    for (Customer customer : customers) {
      System.out.println("Customer: " + customer);
    }
  }

  private void printOrderReport() {
    System.out.println("Order Report");
    if (orders.isEmpty()) {
      System.out.println("No orders available.");
      return;
    }
    for (Order order : orders) {
      System.out.println("Order: " + order);
    }
  }
}