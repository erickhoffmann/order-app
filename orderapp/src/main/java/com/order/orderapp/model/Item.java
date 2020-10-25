package com.order.orderapp.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @Column(name="description")
    protected String description;
    @Column(name="price")
    protected double price;
    @Column(name="item_status")
    @Enumerated(EnumType.ORDINAL)
    private ItemStatus itemStatus;
}
