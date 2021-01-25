package com.epam.web.logic.service;

import com.epam.web.dto.MenuDto;

import java.util.ArrayList;
import java.util.Objects;

public class RemoveFromBucketService {
    public void remove(ArrayList<MenuDto> bucket, int intId) {
        for (int i = 0; i < bucket.size(); i++) {
            MenuDto dish = bucket.get(i);
            if (dish.getId() == intId) {
                dish.decrementCount();
            }
            if (dish.getCount() == 0) {
                bucket.remove(dish);
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
