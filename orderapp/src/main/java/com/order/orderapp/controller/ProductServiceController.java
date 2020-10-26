package com.order.orderapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.orderapp.dto.input.ProductServiceInput;
import com.order.orderapp.model.Item;
import com.order.orderapp.model.Product;
import com.order.orderapp.model.Service;
import com.order.orderapp.service.ProductService;
import com.order.orderapp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ProductServiceController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ProductService productService;

    @Autowired
    ServiceService serviceService;

    @PostMapping("/productservice")
    public Item insertProductService(@RequestBody ProductServiceInput productServiceInput){

        String type = productServiceInput.getType();

        switch (type){
            case "product":
                Product product = objectMapper.convertValue(productServiceInput.getItem(), Product.class);
                return productService.insertProduct(product);

            case "service":
                Service service = objectMapper.convertValue(productServiceInput.getItem(), Service.class);
                return serviceService.insertService(service);
        }

        return null;
    }
}
