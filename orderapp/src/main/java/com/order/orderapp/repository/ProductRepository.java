package com.order.orderapp.repository;

import com.order.orderapp.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(long id);
}
