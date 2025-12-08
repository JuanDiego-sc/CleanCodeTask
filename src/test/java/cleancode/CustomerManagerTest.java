package cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CustomerManagerTest {

  private CustomerManager manager;
  private ByteArrayOutputStream outputStream;
  private PrintStream originalOut;

  @BeforeEach
  void setUp() {
    manager = new CustomerManager();
    outputStream = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  @DisplayName("Should add valid customer")
  void shouldAddValidCustomer() {
    Customer customer = new Customer("John Doe");
    manager.addCustomer(customer);
    String output = outputStream.toString();
    assertTrue(output.contains("Added customer: John Doe"));
  }

  @Test
  @DisplayName("Should not add null customer")
  void shouldNotAddNullCustomer() {
    manager.addCustomer(null);
    String output = outputStream.toString();
    assertTrue(output.contains("Customer cannot be null."));
  }

  @Test
  @DisplayName("Should add valid order")
  void shouldAddValidOrder() {
    Order order = new Order("Order1");
    manager.addOrder(order);
    String output = outputStream.toString();
    assertTrue(output.contains("Order added: Order1"));
  }

  @Test
  @DisplayName("Should not add null order")
  void shouldNotAddNullOrder() {
    manager.addOrder(null);
    String output = outputStream.toString();
    assertTrue(output.contains("Order cannot be null."));
  }

  @Test
  @DisplayName("Should process orders for existing customer")
  void shouldProcessOrdersForExistingCustomer() {
    Customer customer = new Customer("John Doe");
    Order order = new Order("Order1");
    manager.addCustomer(customer);
    manager.addOrder(order);
    outputStream.reset();

    manager.processOrders(customer);
    String output = outputStream.toString();
    assertTrue(output.contains("Processing orders for customer: John Doe"));
    assertTrue(output.contains("Processing order: Order1"));
  }

  @Test
  @DisplayName("Should not process orders for null customer")
  void shouldNotProcessOrdersForNullCustomer() {
    manager.processOrders(null);
    String output = outputStream.toString();
    assertTrue(output.contains("Customer cannot be null."));
  }

  @Test
  @DisplayName("Should not process orders for non-existing customer")
  void shouldNotProcessOrdersForNonExistingCustomer() {
    Customer customer = new Customer("John Doe");
    manager.processOrders(customer);
    String output = outputStream.toString();
    assertTrue(output.contains("Customer not found: John Doe"));
  }

  @Test
  @DisplayName("Should generate report with empty lists")
  void shouldGenerateReportWithEmptyLists() {
    manager.generateReport();
    String output = outputStream.toString();
    assertTrue(output.contains("Customer Report"));
    assertTrue(output.contains("No customers available."));
    assertTrue(output.contains("Order Report"));
    assertTrue(output.contains("No orders available."));
  }

  @Test
  @DisplayName("Should generate report with customers and orders")
  void shouldGenerateReportWithCustomersAndOrders() {
    Customer customer = new Customer("John Doe");
    Order order = new Order("Order1");
    manager.addCustomer(customer);
    manager.addOrder(order);
    outputStream.reset();

    manager.generateReport();
    String output = outputStream.toString();
    assertTrue(output.contains("Customer Report"));
    assertTrue(output.contains("Customer: John Doe"));
    assertTrue(output.contains("Order Report"));
    assertTrue(output.contains("Order: Order1"));
  }

  @Test
  @DisplayName("Should process orders with no orders in list")
  void shouldProcessOrdersWithNoOrdersInList() {
    Customer customer = new Customer("John Doe");
    manager.addCustomer(customer);
    outputStream.reset();

    manager.processOrders(customer);
    String output = outputStream.toString();
    assertTrue(output.contains("Processing orders for customer: John Doe"));
    assertFalse(output.contains("Processing order:"));
  }
}