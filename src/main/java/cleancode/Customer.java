package cleancode;

import java.util.ArrayList;
import java.util.List;
import utils.StringUtils;

/**
 * Represents a customer in the system.
 */
public class Customer {
    private String name;
    private List<Order> orders;

    /**
     * Creates a new Customer.
     *
     * @param name The name of the customer.
     */
    public Customer(String name) {
        this.orders = new ArrayList<>();
        setName(name);
    }

    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name.
     *
     * @param name The new name.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.name = name;
    }

    /**
     * Adds an order to this customer.
     *
     * @param order The order to add.
     */
    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public String toString() {
        return name;
    }
}