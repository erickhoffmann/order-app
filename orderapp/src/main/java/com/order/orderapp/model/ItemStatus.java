package com.order.orderapp.model;

public enum ItemStatus {
    ENABLE(1),
    DISABLED(2);

    private int id;

    ItemStatus(int id) {}

    public int getId() {return id;}
}
