package com.order.orderapp.repository;

import com.order.orderapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findById(long id);
}
