package com.order.orderapp.service;

import com.order.orderapp.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<com.order.orderapp.model.Service> listServices(){
        return (List<com.order.orderapp.model.Service>) serviceRepository.findAll();
    }

    public com.order.orderapp.model.Service getService(long id){
        return serviceRepository.findById(id);
    }

    public com.order.orderapp.model.Service insertService(com.order.orderapp.model.Service service){
        return serviceRepository.save(service);
    }

    public void deleteService(com.order.orderapp.model.Service service){
        serviceRepository.delete(service);
    }

    public com.order.orderapp.model.Service updateService(com.order.orderapp.model.Service service){
        return serviceRepository.save(service);
    }
}
