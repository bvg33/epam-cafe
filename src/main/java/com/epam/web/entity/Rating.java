package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id == rating.id &&
                orderId == rating.orderId &&
                stars == rating.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, stars);
    }
}
