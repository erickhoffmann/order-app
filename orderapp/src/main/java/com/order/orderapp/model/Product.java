package com.order.orderapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
//    @Column(name="item_status")
//    private ItemStatus itemStatus;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public ItemStatus getItemStatus() {
//        return itemStatus;
//    }
//
//    public void setItemStatus(ItemStatus itemStatus) {
//        this.itemStatus = itemStatus;
//    }
}
