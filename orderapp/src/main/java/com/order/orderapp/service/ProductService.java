package com.order.orderapp.service;

import com.order.orderapp.model.Product;
import com.order.orderapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ItemServiceInterface<Product> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product get(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product insertUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(long idItem) {
        Product removeProduct = get(idItem);
        productRepository.delete(removeProduct);
    }
}
