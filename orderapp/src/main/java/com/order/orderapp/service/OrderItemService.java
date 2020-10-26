package com.order.orderapp.service;

import com.order.orderapp.model.OrderItem;
import com.order.orderapp.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItem> listOrderItems(long idOrder){
        return (List<OrderItem>) orderItemRepository.findAll();
    }

    public OrderItem getOrderItem(long id){
        return orderItemRepository.findById(id);
    }

    public OrderItem insertUpdateOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(long id){
        OrderItem orderItemDelete = getOrderItem(id);
        orderItemRepository.delete(orderItemDelete);
    }
}
