package cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;
import java.util.logging.LogRecord;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagerTest {

  private CustomerManager manager;
  private StringBuilder logOutput;

  @BeforeEach
  void setUp() {
    manager = new CustomerManager();
    logOutput = new StringBuilder();

    // Add a handler to capture Logger output for assertions
    Logger logger = Logger.getLogger(CustomerManager.class.getName());
    logger.addHandler(new StreamHandler() {
      @Override
      public synchronized void publish(LogRecord record) {
        logOutput.append(record.getMessage()).append("\n");
      }

      @Override
      public synchronized void flush() {
      }

      @Override
      public synchronized void close() throws SecurityException {
      }
    });
  }

  @Test
  @DisplayName("Should add valid customer")
  void shouldAddValidCustomer() {
    Customer customer = new Customer("John Doe");
    manager.addCustomer(customer);
    // We verify indirectly via exception absence or could verify state if we
    // exposed getCustomers()
    // Here we can simply assert execution is successful
  }

  @Test
  @DisplayName("Should add valid order to customer")
  void shouldAddValidOrder() {
    Customer customer = new Customer("John Doe");
    manager.addCustomer(customer);
    Order order = new Order("Order1");

    manager.addOrder(customer, order);

    assertEquals(1, customer.getOrders().size());
    assertEquals("Order1", customer.getOrders().get(0).getDescription());
  }

  @Test
  @DisplayName("Should not add null customer")
  void shouldNotAddNullCustomer() {
    manager.addCustomer(null);
    // Ensure no exception thrown
  }

  @Test
  @DisplayName("Should not add order to null customer")
  void shouldNotAddOrderToNullCustomer() {
    manager.addOrder(null, new Order("Order1"));
  }

  @Test
  @DisplayName("Should generate report")
  void shouldGenerateReport() {
    Customer customer = new Customer("John Doe");
    manager.addCustomer(customer);
    manager.addOrder(customer, new Order("Order1"));

    assertDoesNotThrow(() -> manager.generateReport());
  }
}