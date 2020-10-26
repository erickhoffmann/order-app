package com.order.orderapp.dto.input;

import com.order.orderapp.model.OrderItem;
import com.order.orderapp.model.OrderStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderInput {

    private long id;
    private Calendar dateTime;
    private double discount;
    private OrderStatus orderStatus;
    private List<Object> items = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}
