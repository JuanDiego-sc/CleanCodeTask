package cleancode;

import utils.StringUtils;

/**
 * Represents an order in the system.
 */
public class Order {
  private String description;

  /**
   * Creates a new Order.
   *
   * @param description The description of the order.
   */
  public Order(String description) {
    setDescription(description);
  }

  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the order.
   *
   * @param description The new description.
   * @throws IllegalArgumentException if the description is null or empty.
   */
  public void setDescription(String description) {
    if (StringUtils.isNullOrEmpty(description)) {
      throw new IllegalArgumentException("Order description cannot be empty.");
    }
    this.description = description;
  }

  @Override
  public String toString() {
    return description;
  }
}