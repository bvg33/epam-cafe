package com.epam.web.dao.extractor;

import com.epam.web.dto.OrderDto;

import java.util.Map;

public class OrderDtoFieldExtractor implements EntityFieldExtractor<OrderDto> {

    @Override
    public Map<String, String> parse(OrderDto entity) {
        return null;
    }
}
