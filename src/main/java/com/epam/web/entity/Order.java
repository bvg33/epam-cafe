package com.epam.web.entity;

import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.util.Objects;

public class Order implements Identifiable {
    private int id;
    private String price;
    private OrderTypeEnum type;
    private OrderStateEnum state;
    private String time;
    private int userId;
    public static final String TABLE="epamweb.orders";

    public Order(int id, String price, OrderTypeEnum type, OrderStateEnum state, String time, int userId) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.state = state;
        this.time = time;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public OrderTypeEnum getType() {
        return type;
    }

    public OrderStateEnum getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public void write(OutputStream arg0) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                Objects.equals(price, order.price) &&
                type == order.type &&
                state == order.state &&
                Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, type, state, time, userId);
    }
}
