package com.epam.web.dto;

import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class OrderDto implements Identifiable {
    private int price;
    private OrderStateEnum state;
    private String time;
    private int order_id;
    private OrderTypeEnum cash;
    private String dishes;
    private String login;
    public static final String TABLE="OrderDto";

    public OrderDto(int price, OrderStateEnum state, String time, int order_id,String dishes,OrderTypeEnum cash,String name) {
        this.price = price;
        this.state = state;
        this.time = time;
        this.order_id = order_id;
        this.dishes=dishes;
        this.cash=cash;
        this.login=name;
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


    public int getOrder_id() {
        return order_id;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
