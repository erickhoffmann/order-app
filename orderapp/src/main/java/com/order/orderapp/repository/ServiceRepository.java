package com.order.orderapp.repository;

import com.order.orderapp.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Service findById(long id);
}
