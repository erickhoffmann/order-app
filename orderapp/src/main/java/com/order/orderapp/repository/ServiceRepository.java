package com.order.orderapp.repository;

import com.order.orderapp.model.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Service findById(long id);

    @Query(value = "SELECT COUNT(o) FROM OrderItem as o WHERE o.item.id = ?1")
    long serviceInOrderItem(long idService);
}
