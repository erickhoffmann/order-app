package com.order.orderapp.controller;

import com.order.orderapp.model.Order;
import com.order.orderapp.repository.OrderRepository;
import com.order.orderapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable(value = "id")long id){
        return orderService.getOrder(id);
    }

    @PostMapping("/order")
    public Order insertOrder(@RequestBody Order order){
        return orderService.insertOrder(order);
    }

    @DeleteMapping("/order")
    public void deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
    }

    @PutMapping("/order")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
}
