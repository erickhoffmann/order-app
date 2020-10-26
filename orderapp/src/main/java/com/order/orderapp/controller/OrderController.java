package com.order.orderapp.controller;

import com.order.orderapp.appcontroller.OrderIO;
import com.order.orderapp.dto.input.OrderInput;
import com.order.orderapp.model.Order;
import com.order.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderIO orderIO;

    @GetMapping("/orders")
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable(value = "id")long id){
        return orderService.getOrder(id);
    }

    @PostMapping("/order")
    public Order insertOrder(@RequestBody OrderInput orderInput){
        Order order = orderIO.mapTo(orderInput);
        return orderService.insertOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable(value = "id")long id){
        orderService.deleteOrder(id);
    }

    @PutMapping("/order")
    public Order updateOrder(@RequestBody OrderInput orderInput){
        Order order = orderIO.mapTo(orderInput);
        return orderService.updateOrder(order);
    }
}
