package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.Serializable;

public class User implements Identifiable, Serializable {
    public static final String TABLE = "users";
    private int id;
    private String login;
    private String password;
    private String name;
    private String cardNumber;
    private Role role;
    private int loyality;

    public User(int id, String login, String password, String name, String cardNumber, int loyality,Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.cardNumber = cardNumber;
        this.loyality = loyality;
        this.role=role;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getLoyality() {
        return loyality;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
