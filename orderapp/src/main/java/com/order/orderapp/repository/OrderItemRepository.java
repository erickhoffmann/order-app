package com.order.orderapp.repository;

import com.order.orderapp.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    OrderItem findById(long id);

    @Query(value = "SELECT o FROM OrderItem as o WHERE o.order.id = ?1")
    List<OrderItem> findAllOrderItems(long idOrder);
}
