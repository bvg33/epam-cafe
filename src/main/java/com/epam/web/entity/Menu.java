package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.Serializable;

public class Menu implements Identifiable, Serializable {
    public static final String TABLE="menu";
    private int id;
    private String description;
    private String name;
    private String price;
    private String photo;

    public Menu(int id,String name, String description, String price, String photo) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public String getDescription() {
        return description;
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
