package com.order.orderapp.dto.input;

public class DiscountInput {

    private long idOrder;
    private double discount;

    public long getIdOrder() {return idOrder;}

    public void setIdOrder(long idOrder) {this.idOrder = idOrder;}

    public double getDiscount() {return discount;}

    public void setDiscount(double discount) {this.discount = discount;}
}
