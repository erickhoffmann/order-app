package com.order.orderapp.model;

public enum OrderStatus {

    OPEN(1),
    CLOSED(2);

    private int id;

    OrderStatus(int id) {}

    public int getId() {return id;}

}
