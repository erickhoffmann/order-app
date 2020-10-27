package com.order.orderapp.repository;

import com.order.orderapp.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findById(long id);

    @Query(value = "SELECT COUNT(o) FROM OrderItem as o WHERE o.item.id = ?1")
    long productInOrderItem(long idProduct);
}
