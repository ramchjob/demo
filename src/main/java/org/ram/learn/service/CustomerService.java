package org.ram.learn.service;

import java.util.List;
import java.util.Optional;

import org.ram.learn.config.AppConstant;
import org.ram.learn.model.Customer;
import org.ram.learn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    
    public Customer getCustomer(Integer customerId) throws NotFoundException {
        Optional<Customer> customer = repository.findById(customerId);
        if (customer.isPresent()) {
            return repository.findById(customerId).get();
        }
        throw new NotFoundException(AppConstant.RESOURCE_NOT_FOUND);
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
