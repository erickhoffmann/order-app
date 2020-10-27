package com.order.orderapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_time")
    private Calendar dateTime;
    @Column(name="discount")
    private double discount;
    @Column(name="total_value")
    private double totalValue;
    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private OrderStatus orderStatus;
//    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class, orphanRemoval = true)
    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}

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

    public double getTotalValue() {return totalValue;}

    public void setTotalValue(double totalValue) {this.totalValue = totalValue;}

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addOrderItem(OrderItem orderItem){
        this.items.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        this.items.remove(orderItem);
    }

    public void setItems(List<OrderItem> items) {
        for(OrderItem orderItem: items){
            orderItem.setOrder(this);
        }
        this.items = items;
    }
}
