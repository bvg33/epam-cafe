package com.epam.web.logic.service;

import com.epam.web.dto.MenuDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RemoveFromBucketServiceTest {
    @Test
    public void testRemoveShouldRemoveWhenDataIsCorrect(){
        ArrayList<MenuDto> actual =new ArrayList<>();
        MenuDto dto=new MenuDto(0,2.5,"name","photo");
        actual.add(dto);
        RemoveFromBucketService service=new RemoveFromBucketService();
        service.remove(actual,0);
        ArrayList<MenuDto> expected=new ArrayList<>();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testRemoveShouldDecrementCountWhenDataIsCorrect(){
        ArrayList<MenuDto> actual =new ArrayList<>();
        MenuDto dto=new MenuDto(0,2.5,"name","photo");
        dto.incrementCount();
        actual.add(dto);
        RemoveFromBucketService service=new RemoveFromBucketService();
        service.remove(actual,0);
        ArrayList<MenuDto> expected=new ArrayList<>();
        MenuDto newDto=new MenuDto(0,2.5,"name","photo");
        expected.add(newDto);
        Assert.assertEquals(expected,actual);
    }
}
