package org.ram.learn.repository;

import org.ram.learn.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
