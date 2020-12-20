package com.epam.web.dao.parser;

import com.epam.web.dao.mapper.MenuRowMapper;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.dao.mapper.UserRowMapper;
import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.sun.corba.se.spi.ior.Identifiable;

import java.util.Map;

public interface EntityFieldExtractor<T extends Identifiable> {
    Map<String,String> parse(T entity);
    static EntityFieldExtractor createFieldExtractor(String tableName){ //todo factory method
        switch (tableName){
            case User.TABLE :return new UserFieldExtractor();
            default:throw new IllegalArgumentException("Unknown table "+tableName);
        }
    }
}

