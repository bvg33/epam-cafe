package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.Serializable;

public class Menu implements Identifiable, Serializable {
    public static final String TABLE="menu";
    private int id;
    private String name;
    private String price;
    private String photo;
    private int isActive;

    public Menu(int id,String name,String price, String photo,int isActive) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.isActive=isActive;
    }

    public int getIsActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
