package cleancode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Manages customers and their orders.
 */
public class CustomerManager {
  private static final Logger LOGGER = Logger.getLogger(CustomerManager.class.getName());
  private List<Customer> customers = new ArrayList<>();

  /**
   * Adds a customer to the manager.
   *
   * @param customer The customer to add.
   */
  public void addCustomer(Customer customer) {
    if (customer == null) {
      LOGGER.warning("Customer cannot be null.");
      return;
    }
    customers.add(customer);
    LOGGER.info("Added customer: " + customer);
  }

  /**
   * Adds an order to a specific customer.
   *
   * @param customer The customer to add the order to.
   * @param order    The order to add.
   */
  public void addOrder(Customer customer, Order order) {
    if (customer == null) {
      LOGGER.warning("Customer cannot be null.");
      return;
    }
    if (order == null) {
      LOGGER.warning("Order cannot be null.");
      return;
    }
    if (!customers.contains(customer)) {
      LOGGER.warning("Customer not found: " + customer);
      return;
    }
    customer.addOrder(order);
    LOGGER.info("Order added to customer " + customer + ": " + order);
  }

  /**
   * Processes orders for a customer.
   *
   * @param customer The customer.
   */
  public void processOrders(Customer customer) {
    if (customer == null) {
      LOGGER.warning("Customer cannot be null.");
      return;
    }
    if (!customers.contains(customer)) {
      LOGGER.warning("Customer not found: " + customer);
      return;
    }
    LOGGER.info("Processing orders for customer: " + customer);
    for (Order order : customer.getOrders()) {
      LOGGER.info("Processing order: " + order);
    }
  }

  /**
   * Generates a simple report of customers and their orders.
   */
  public void generateReport() {
    LOGGER.info("Generating Customer Report");
    if (customers.isEmpty()) {
      LOGGER.info("No customers available.");
      return;
    }
    for (Customer customer : customers) {
      LOGGER.info("Customer: " + customer);
      for (Order order : customer.getOrders()) {
        LOGGER.info("  Order: " + order);
      }
    }
  }
}