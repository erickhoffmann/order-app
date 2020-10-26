package com.order.orderapp.repository;

import com.order.orderapp.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    OrderItem findById(long id);
}
