package com.order.orderapp.service;

import com.order.orderapp.model.Service;
import com.order.orderapp.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements ItemServiceInterface<Service> {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> list() {
        return (List<Service>) serviceRepository.findAll();
    }

    @Override
    public Service get(long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Service insertUpdate(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void delete(long idItem) {
        Service removeService = get(idItem);
        serviceRepository.delete(removeService);
    }
}
