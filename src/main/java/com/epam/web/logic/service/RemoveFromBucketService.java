package com.epam.web.logic.service;

import com.epam.web.dto.MenuDto;

import java.util.ArrayList;

public class RemoveFromBucketService {
    public void remove(ArrayList<MenuDto> bucket,int intId){
        for (int i = 0; i < bucket.size(); i++) {
            MenuDto dish = bucket.get(i);
            if (dish.getId() == intId) {
                dish.decrementCount();
            }
            if(dish.getCount()==0){
                bucket.remove(dish);
                break;
            }
        }
    }
}
