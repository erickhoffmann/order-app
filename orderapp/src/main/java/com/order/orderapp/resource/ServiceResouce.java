package com.order.orderapp.resource;

import com.order.orderapp.model.Service;
import com.order.orderapp.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ServiceResouce {

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/services")
    public List<Service> listServices(){
        return (List<Service>) serviceRepository.findAll();
    }

    @GetMapping("/service/{id}")
    public Service getService(@PathVariable(value = "id")long id){
        return serviceRepository.findById(id);
    }

    @PostMapping("/service")
    public Service insertService(@RequestBody Service service){
        return serviceRepository.save(service);
    }

    @DeleteMapping("/service")
    public void deleteService(@RequestBody Service service){
        serviceRepository.delete(service);
    }

    @PutMapping("/service")
    public Service updateService(@RequestBody Service service){
        return serviceRepository.save(service);
    }
}
