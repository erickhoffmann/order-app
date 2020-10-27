package com.order.orderapp.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_item")
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @Column(name="description")
    protected String description;
    @Column(name="price")
    protected double price;

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
}
