package org.ram.learn.controller;

import org.ram.learn.model.Customer;
import org.ram.learn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping(produces = "application/json", value = "/customer")
    private Customer getCustomer(Integer customerId) {
        return customerService.getCustomer(customerId);
    }
    
    @PostMapping(produces = "application/json", value = "/customers")
    private Customer createCustomer(Customer customer) {
        return customerService.createCustomer(customer);
    }
    
    @PutMapping(produces = "application/json", value = "/customers")
    private Customer updateCustomer(Integer customerId, Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
    
    @DeleteMapping(produces = "application/json", value = "/customers")
    private void deleteCustomer(Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
    
}
