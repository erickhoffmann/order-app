package com.order.orderapp.controller;

import com.order.orderapp.appcontroller.OrderItemIO;
import com.order.orderapp.dto.input.OrderItemInput;
import com.order.orderapp.model.OrderItem;
import com.order.orderapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderItemIO orderItemIO;

    @GetMapping("/orderitem/list/{idOrder}")
    public List<OrderItem> listServices(@PathVariable(value = "idOrder")long idOrder){
        return orderItemService.listOrderItems(idOrder);
    }

    @GetMapping("/orderitem/{id}")
    public OrderItem getService(@PathVariable(value = "id")long id){
        return orderItemService.getOrderItem(id);
    }

    @PostMapping("/orderitem")
    public OrderItem insertService(@RequestBody OrderItemInput orderItemInput){
        OrderItem orderItem = orderItemIO.mapTo(orderItemInput);
        return orderItemService.insertUpdateOrderItem(orderItem);
    }

    @DeleteMapping("/orderitem/{id}")
    public void deleteOrderItem(@PathVariable(value = "id")long id){
        orderItemService.deleteOrderItem(id);
    }

    @PutMapping("/orderitem")
    public OrderItem updateOrderItem(@RequestBody OrderItemInput orderItemInput){
        OrderItem orderItem = orderItemIO.mapTo(orderItemInput);
        return orderItemService.insertUpdateOrderItem(orderItem);
    }
}
