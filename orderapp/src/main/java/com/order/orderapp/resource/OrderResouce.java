package com.order.orderapp.resource;

import com.order.orderapp.model.Order;
import com.order.orderapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderResouce {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> listOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable(value = "id")long id){
        return orderRepository.findById(id);
    }

    @PostMapping("/order")
    public Order insertOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @DeleteMapping("/order")
    public void deleteOrder(@RequestBody Order order){
        orderRepository.delete(order);
    }

    @PutMapping("/order")
    public Order updateOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
}
