package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customerList = new ArrayList<>();

    // CRUD işlemleri
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public Customer getCustomerById(int id) {
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateCustomerEmail(int id, String newEmail) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setEmail(newEmail);
        }
    }

    public void deleteCustomer(int id) {
        customerList.removeIf(customer -> customer.getId() == id);
    }
}
