package com.order.orderapp.service;

import com.order.orderapp.model.Product;
import com.order.orderapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(long id){
        return productRepository.findById(id);
    }

    public Product insertProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
}
