package com.order.orderapp.service;

import com.order.orderapp.model.ItemStatus;
import com.order.orderapp.model.OrderItem;
import com.order.orderapp.model.Product;
import com.order.orderapp.repository.OrderItemRepository;
import com.order.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderService orderService;

    public List<OrderItem> listOrderItems(long idOrder){
        return (List<OrderItem>) orderItemRepository.findAllOrderItems(idOrder);
    }

    public OrderItem getOrderItem(long id){
        return orderItemRepository.findById(id);
    }

    public OrderItem insertUpdateOrderItem(OrderItem orderItem){

        OrderItem orderItemSaved = null;

        if (orderItem.getItem() instanceof Product) {
            if(((Product)orderItem.getItem()).getItemStatus() == ItemStatus.ENABLE){
                orderItemSaved = orderItemRepository.save(orderItem);
            }
        }else{

            orderItemSaved =  orderItemRepository.save(orderItem);
        }

        if(orderItemSaved != null){
            orderService.insertUpdateOrder(orderItemSaved.getOrder());
        }

        return orderItemSaved;
    }

    public void deleteOrderItem(long id){
        OrderItem orderItemDelete = getOrderItem(id);
        orderItemRepository.delete(orderItemDelete);

        orderItemDelete.getOrder().removeOrderItem(orderItemDelete);
        orderService.insertUpdateOrder(orderItemDelete.getOrder());
    }
}
