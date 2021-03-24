package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                isActive == menu.isActive &&
                Objects.equals(name, menu.name) &&
                Objects.equals(price, menu.price) &&
                Objects.equals(photo, menu.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, photo, isActive);
    }
}
