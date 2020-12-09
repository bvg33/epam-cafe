package com.epam.web.dao.parser;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserFieldExtractor implements EntityFieldExtractor<User> {

    @Override
    public Map<String, String> parse(User user) {
        String password=user.getPassword();
        String login= user.getLogin();
        String name= user.getName();
        String cardNumber= user.getCardNumber();
        int id= user.getId();
        int loyality= user.getLoyality();
        String stringId=Integer.toString(id);
        String stringLoyality=Integer.toString(loyality);
        Role role=user.getRole();
        String stringRole=role.name();
        Map<String,String> map=new HashMap<>();
        map.put("password",password);
        map.put("login",login);
        map.put("name",name);
        map.put("cardNumber",cardNumber);
        map.put("id",stringId);
        map.put("loyality",stringLoyality);
        map.put("role",stringRole);
        return map;
    }
}