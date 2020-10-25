package com.order.orderapp.model;

import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private Date date;
    private double discount;
    private ItemStatus itemStatus;
    private List<OrderItem> items;
}
