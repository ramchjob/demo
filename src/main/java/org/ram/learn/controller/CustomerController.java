package org.ram.learn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.ram.learn.entity.Customer;
import org.ram.learn.exception.CustomerServiceException;
import org.ram.learn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping(produces = "application/json", value = "/customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@Valid @PathVariable (required = true) Integer customerId) throws CustomerServiceException, SQLException {
        log.info("Get customer for given customer Id {}", customerId);
        Customer customer =  customerService.getCustomer(customerId);
        return ResponseEntity.ok(customer);
    }
    
    @PostMapping(produces = "application/json", value = "/customers")
    public Customer createCustomer(@RequestBody  Customer customer) throws JsonMappingException, JsonProcessingException {
        log.info("Creating custoemr for {}" , customer);
        return customerService.createCustomer(customer);
    }
    
    @PutMapping(produces = "application/json", value = "/customer/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
    
    @GetMapping(produces = "application/json", value = "/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
    
    @DeleteMapping(produces = "application/json", value = "/customer/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
    
    
    
    @ExceptionHandler({ NotFoundException.class, NullPointerException.class })
    public void handleException() {
        log.error("Not found exception");
    }
    
}
