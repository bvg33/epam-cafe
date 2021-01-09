package com.epam.web.dao.extractor;

import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.sun.corba.se.spi.ior.Identifiable;

import java.util.Map;

public interface EntityFieldExtractor<T extends Identifiable> {
    Map<String,String> parse(T entity);
}

