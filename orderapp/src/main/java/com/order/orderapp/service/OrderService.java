package com.order.orderapp.service;

import com.order.orderapp.model.Item;
import com.order.orderapp.model.Order;
import com.order.orderapp.model.OrderItem;
import com.order.orderapp.model.Product;
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

    public Order insertUpdateOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(long id){
        Order orderDelete = getOrder(id);
        orderRepository.delete(orderDelete);
    }

    private void calculateProductDiscount(Order order){

        double totalValue = 0;
        double totalProductValue = 0;

        for(OrderItem orderItem: order.getItems()){

            if(orderItem.getItem() instanceof Product){

            }
        }
    }
}
