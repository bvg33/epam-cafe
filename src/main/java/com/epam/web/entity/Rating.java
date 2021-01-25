package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class Rating implements Identifiable {
    private final int id;
    private final int orderId;
    private final int stars;
    public static final String TABLE="rating";

    public Rating(int id, int orderId, int stars) {
        this.id = id;
        this.orderId = orderId;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
