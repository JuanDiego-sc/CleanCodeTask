package cleancode;

import utils.StringUtils;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("cleancode.Customer name cannot be empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}