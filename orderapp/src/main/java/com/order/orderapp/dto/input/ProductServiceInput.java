package com.order.orderapp.dto.input;

public class ProductServiceInput {
    private String type;
    private Object item;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
