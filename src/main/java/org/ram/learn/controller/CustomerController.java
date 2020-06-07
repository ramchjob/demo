package org.ram.learn.controller;

import java.util.List;

import org.ram.learn.model.Customer;
import org.ram.learn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping(produces = "application/json", value = "/customer/{customerId}")
    private Customer getCustomer(@PathVariable Integer customerId) {
        return customerService.getCustomer(customerId);
    }
    
    @PostMapping(produces = "application/json", value = "/customers")
    private Customer createCustomer(@RequestBody  Customer customer) {
        return customerService.createCustomer(customer);
    }
    
    @PutMapping(produces = "application/json", value = "/customer/{customerId}")
    private Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
    
    @GetMapping(produces = "application/json", value = "/customers")
    private List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
    
    @DeleteMapping(produces = "application/json", value = "/customer/{customerId}")
    private void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
    
}
