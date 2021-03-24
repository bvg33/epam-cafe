package com.epam.web.dto;

import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class OrderDto implements Identifiable {
    private int id;
    private int price;
    private OrderStateEnum state;
    private String time;
    private OrderTypeEnum cash;
    private String dishes;
    private String login;
    private int rating;
    public static final String  NAME="OrderDto";

    public OrderDto(int id,int price, OrderStateEnum state, String time,String dishes,OrderTypeEnum cash,String name,int rating) {
        this.id=id;
        this.price = price;
        this.state = state;
        this.time = time;
        this.dishes=dishes;
        this.cash=cash;
        this.login=name;
        this.rating=rating;
    }

    public int getRating() {
        return rating;
    }

    public String getLogin() {
        return login;
    }

    public OrderTypeEnum getCash() {
        return cash;
    }

    public String getDishes() {
        return dishes;
    }

    public String getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    public OrderStateEnum getState() {
        return state;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
