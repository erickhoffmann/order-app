package com.order.orderapp.controller;

import com.order.orderapp.model.Service;
import com.order.orderapp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("/services")
    public List<Service> listServices(){
        return serviceService.listServices();
    }

    @GetMapping("/service/{id}")
    public Service getService(@PathVariable(value = "id")long id){
        return serviceService.getService(id);
    }

    @PostMapping("/service")
    public Service insertService(@RequestBody Service service){
        return serviceService.insertService(service);
    }

    @DeleteMapping("/service")
    public void deleteService(@RequestBody Service service){
        serviceService.deleteService(service);
    }

    @PutMapping("/service")
    public Service updateService(@RequestBody Service service){
        return serviceService.updateService(service);
    }
}
