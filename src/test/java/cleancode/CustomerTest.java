package cleancode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

  @Test
  @DisplayName("Should create customer with valid name")
  void shouldCreateCustomerWithValidName() {
    Customer customer = new Customer("John Doe");
    assertEquals("John Doe", customer.getName());
  }

  @Test
  @DisplayName("Should return name in toString")
  void shouldReturnNameInToString() {
    Customer customer = new Customer("Jane Smith");
    assertEquals("Jane Smith", customer.toString());
  }

  @Test
  @DisplayName("Should update name with valid value")
  void shouldUpdateNameWithValidValue() {
    Customer customer = new Customer("John Doe");
    customer.setName("Jane Doe");
    assertEquals("Jane Doe", customer.getName());
  }

  @Test
  @DisplayName("Should throw exception when setting null name")
  void shouldThrowExceptionWhenSettingNullName() {
    Customer customer = new Customer("John Doe");
    assertThrows(IllegalArgumentException.class, () -> customer.setName(null));
  }

  @Test
  @DisplayName("Should throw exception when setting empty name")
  void shouldThrowExceptionWhenSettingEmptyName() {
    Customer customer = new Customer("John Doe");
    assertThrows(IllegalArgumentException.class, () -> customer.setName(""));
  }
}