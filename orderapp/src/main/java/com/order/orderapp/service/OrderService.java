package com.order.orderapp.service;

import com.order.orderapp.model.*;
import com.order.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        validateStatusProductItem(order);
        calculateTotalValueOrder(order);
        return orderRepository.save(order);
    }

    public void deleteOrder(long id){
        Order orderDelete = getOrder(id);
        orderRepository.delete(orderDelete);
    }

    public Order apllyDiscount(long idOrder, double discount){

        Order order = getOrder(idOrder);
        if(order == null) return null;

        if(discount < 0 || discount > 100) discount = 0;

        order.setDiscount(discount);
        calculateTotalValueOrder(order);

        return insertUpdateOrder(order);
    }

    private void calculateTotalValueOrder(Order order){

        double otherItemsValue = 0, totalProductValue = 0;

        for (OrderItem orderItem : order.getItems()) {

            if (orderItem.getItem() instanceof Product) {
                totalProductValue += orderItem.getItem().getPrice();

            } else {
                otherItemsValue += orderItem.getItem().getPrice();
            }
        }

        if(order.getDiscount() > 0 && order.getOrderStatus() == OrderStatus.OPEN) {
            totalProductValue = (totalProductValue - (totalProductValue * (order.getDiscount() / 100)));
        }

        order.setTotalValue(otherItemsValue + totalProductValue);
    }
    private void validateStatusProductItem(Order order){

        List<OrderItem> aux = new ArrayList<>();
        aux.addAll(order.getItems());

        for (OrderItem orderItem : aux) {

            if (orderItem.getItem() instanceof Product) {
                if(((Product)orderItem.getItem()).getItemStatus() == ItemStatus.DISABLED){
                    order.removeOrderItem(orderItem);
                }
            }
        }
    }
}
