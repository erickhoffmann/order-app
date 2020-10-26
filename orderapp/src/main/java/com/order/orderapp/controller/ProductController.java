package com.order.orderapp.controller;

import com.order.orderapp.service.ProductService;
import com.order.orderapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id")long id){
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
