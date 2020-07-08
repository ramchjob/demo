package org.ram.learn.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.ram.learn.config.AppConstant;
import org.ram.learn.entity.Customer;
import org.ram.learn.exception.CustomerServiceException;
import org.ram.learn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    
    public Customer getCustomer(Integer customerId) throws CustomerServiceException, SQLException {
        log.info("About to retrieve customer from database for customer Id {}", customerId);
        Optional<Customer> customer = repository.findById(customerId);
        throw new SQLException("Database is down");
        /*
         * if (customer.isPresent()) {
         * log.info("retrieved customer from database for customer Id {}", customerId);
         * //return customer.get(); }
         */
        //log.info("customer not found for customer Id {}", customerId);
        //throw new CustomerServiceException(AppConstant.RESOURCE_NOT_FOUND + "Data " + customerId);
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
