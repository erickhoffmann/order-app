package com.order.orderapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_product")
public class Product extends Item implements Serializable{

    @Column(name="quantity")
    private int quantity;
    @Column(name="item_status")
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
