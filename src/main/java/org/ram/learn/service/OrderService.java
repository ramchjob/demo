package org.ram.learn.service;

import java.util.List;

import org.ram.learn.model.Customer;
import org.ram.learn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    CustomerRepository repository;
    
    public Customer getCustomer(Integer customerId) {
        return repository.findById(customerId).get();
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(Integer customerId, Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(Integer customerId) {
        repository.deleteById(customerId);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
        
    }

}