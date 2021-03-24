package com.epam.web.dao.extractor;

import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.sun.corba.se.spi.ior.Identifiable;

import java.util.Map;

public interface EntityFieldExtractor<T extends Identifiable> {
    /**
     * Method to create map from entity's fields
     * @param entity entity to convert to map
     * @return map of entity's fields
     */
    Map<String,String> parse(T entity);
}

