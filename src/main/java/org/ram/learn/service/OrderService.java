package org.ram.learn.service;

import java.util.List;
import java.util.Optional;

import org.ram.learn.config.AppConstant;
import org.ram.learn.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;
    
    public Order getOrder(Integer orderId) throws NotFoundException {
       
        Optional<Order> order =  repository.findById(orderId);
        if (order.isPresent()) {
            return order.get();    
        }

        throw new NotFoundException(AppConstant.RESOURCE_NOT_FOUND);
    }

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order updateOrder(Integer orderId, Order order) throws NotFoundException {
        if (null != repository.findById(orderId)) {
            throw new NotFoundException(AppConstant.RESOURCE_NOT_FOUND);
        }
        return repository.save(order);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public void deleteOrder(Integer orderId) {
        repository.deleteById(orderId);
    }

}
