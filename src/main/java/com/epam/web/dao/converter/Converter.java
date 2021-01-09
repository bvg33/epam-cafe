package com.epam.web.dao.converter;

public interface Converter <T,E>  {
    T convert(E entity);
}
