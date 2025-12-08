package cleancode;

import utils.StringUtils;

public class Order {
  private String description;

  public Order(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

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