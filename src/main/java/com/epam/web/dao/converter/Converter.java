package com.epam.web.dao.converter;

public interface Converter <T,E>  {
    /**
     * Method to convert one entity to another
     * @param entity entity to convert
     * @return converted entity
     */
    T convert(E entity);
}
