package com.mercatrucho.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping {
    private Date delivery;
    private Boolean received;

    public Shipping(Date delivery,Boolean received) {
        this.delivery = delivery;
        this.received = received;
    }

    public Shipping(String seller, String name, String description, BigDecimal price, String s, boolean b) {
    }


    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}
