package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.util.Objects;

public class Bucket implements Identifiable {
    private int id;
    private int dishId;
    private int orderNumber;
    private int count;
    public static final String TABLE = "epamweb.bucket";

    public Bucket(int id, int dishId, int orderNumber, int count) {
        this.id = id;
        this.dishId = dishId;
        this.orderNumber = orderNumber;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getDishId() {
        return dishId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void write(OutputStream arg0) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return id == bucket.id &&
                dishId == bucket.dishId &&
                orderNumber == bucket.orderNumber &&
                count == bucket.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, orderNumber, count);
    }
}
