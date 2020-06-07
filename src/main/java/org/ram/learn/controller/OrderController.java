package org.ram.learn.controller;

import java.util.List;

import org.ram.learn.model.Customer;
import org.ram.learn.model.Order;
import org.ram.learn.service.CustomerService;
import org.ram.learn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping(produces = "application/json", value = "/order/{orderId}")
    private Order getOrder(@PathVariable Integer orderId) throws NotFoundException {
        return orderService.getOrder(orderId);
    }
    
    @PostMapping(produces = "application/json", value = "/orders")
    private Order createOrder(@RequestBody  Order order) {
        return orderService.createOrder(order);
    }
    
    @PutMapping(produces = "application/json", value = "/order/{orderId}")
    private Order updateOrder(@PathVariable Integer orderId, @RequestBody Order order) throws NotFoundException {
        return orderService.updateOrder(orderId, order);
    }
    
    @GetMapping(produces = "application/json", value = "/orders")
    private List<Order> getOrders() {
        return orderService.getOrders();
    }
    
    @DeleteMapping(produces = "application/json", value = "/order/{orderId}")
    private void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }
    
}
