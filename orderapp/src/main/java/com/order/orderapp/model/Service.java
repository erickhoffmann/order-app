package com.order.orderapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_service")
public class Service extends Item implements Serializable {

    @Column(name="available_hours")
    private double availableHours;

    public double getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(double availableHours) {
        this.availableHours = availableHours;
    }
}
