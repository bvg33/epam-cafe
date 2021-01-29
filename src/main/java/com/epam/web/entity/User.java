package com.epam.web.entity;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                loyality == user.loyality &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(cardNumber, user.cardNumber) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, cardNumber, role, loyality);
    }
}
