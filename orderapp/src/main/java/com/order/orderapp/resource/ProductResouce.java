package com.order.orderapp.resource;

import com.order.orderapp.model.Product;
import com.order.orderapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResouce {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> listProduts(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id")long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product insertProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product){
        productRepository.delete(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
