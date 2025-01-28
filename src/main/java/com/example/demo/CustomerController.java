package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService = new CustomerService();

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "Customer added successfully!";
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}/updateEmail")
    public String updateCustomerEmail(@PathVariable int id, @RequestParam String email) {
        customerService.updateCustomerEmail(id, email);
        return "Email updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "Customer deleted!";
    }
}
