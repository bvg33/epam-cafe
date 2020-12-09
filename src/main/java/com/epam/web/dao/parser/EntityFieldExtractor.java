package com.epam.web.dao.parser;

import com.sun.corba.se.spi.ior.Identifiable;

import java.util.Map;

public interface EntityFieldExtractor<T extends Identifiable> {
    Map<String,String> parse(T entity);
}

