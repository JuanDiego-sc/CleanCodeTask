package cleancode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

  @Test
  @DisplayName("Should create order with valid description")
  void shouldCreateOrderWithValidDescription() {
    Order order = new Order("Order1");
    assertEquals("Order1", order.getDescription());
  }

  @Test
  @DisplayName("Should return description in toString")
  void shouldReturnDescriptionInToString() {
    Order order = new Order("Order1");
    assertEquals("Order1", order.toString());
  }

  @Test
  @DisplayName("Should update description with valid value")
  void shouldUpdateDescriptionWithValidValue() {
    Order order = new Order("Order1");
    order.setDescription("Order2");
    assertEquals("Order2", order.getDescription());
  }

  @Test
  @DisplayName("Should throw exception when setting null description")
  void shouldThrowExceptionWhenSettingNullDescription() {
    Order order = new Order("Order1");
    assertThrows(IllegalArgumentException.class, () -> order.setDescription(null));
  }

  @Test
  @DisplayName("Should throw exception when setting empty description")
  void shouldThrowExceptionWhenSettingEmptyDescription() {
    Order order = new Order("Order1");
    assertThrows(IllegalArgumentException.class, () -> order.setDescription(""));
  }
}