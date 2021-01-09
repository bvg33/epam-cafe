package com.epam.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class MenuDto implements Serializable {
    private int id;
    private int price;
    private int count;
    private String name;
    private String photo;

    public MenuDto(int id, int price, String name, String photo) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.photo = photo;
        count=1;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
    public void incrementCount(){
        count++;
    }
    public void decrementCount(){count--;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDto menuDto = (MenuDto) o;
        return id == menuDto.id &&
                price == menuDto.price &&
                Objects.equals(name, menuDto.name) &&
                Objects.equals(photo, menuDto.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, photo);
    }
}
