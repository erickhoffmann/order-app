package com.order.orderapp.service;

import com.order.orderapp.model.Order;
import com.order.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> listOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrder(long id){
        return orderRepository.findById(id);
    }

    public Order insertOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }
}
