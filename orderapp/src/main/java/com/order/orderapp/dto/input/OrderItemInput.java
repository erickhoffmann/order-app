package com.order.orderapp.dto.input;

public class OrderItemInput {

    private long id;
    private long idOrder;
    private String type;
    private long idItem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
}
