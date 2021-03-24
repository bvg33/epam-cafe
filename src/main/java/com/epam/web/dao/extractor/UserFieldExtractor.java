package com.epam.web.dao.extractor;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserFieldExtractor implements EntityFieldExtractor<User> {
    private static final String LOGIN="login";
    private static final String PASSWORD="password";
    private static final String NAME="name";
    private static final String CARD_NUMBER="cardNumber";
    private static final String ID="id";
    private static final String POINTS="points";
    private static final String ROLE="role";
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
        map.put(PASSWORD,password);
        map.put(LOGIN,login);
        map.put(NAME,name);
        map.put(CARD_NUMBER,cardNumber);
        map.put(ID,stringId);
        map.put(POINTS,stringLoyality);
        map.put(ROLE,stringRole);
        return map;
    }
}