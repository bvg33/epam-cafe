package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

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
}
