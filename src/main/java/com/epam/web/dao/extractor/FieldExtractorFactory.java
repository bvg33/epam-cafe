package com.epam.web.dao.extractor;

import com.epam.web.dto.OrderDto;
import com.epam.web.entity.Bucket;
import com.epam.web.entity.Menu;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;

public class FieldExtractorFactory {
    public static EntityFieldExtractor createFieldExtractor(String tableName) {
        switch (tableName) {
            case User.TABLE:
                return new UserFieldExtractor();
            case Menu.TABLE:
                return new MenuFieldExtractor();
            case Order.TABLE:
                return new OrderFieldExtractor();
            case Bucket.TABLE:
                return new BucketFieldExtractor();
            case OrderDto.TABLE:
                return new OrderDtoFieldExtractor();
            default:
                throw new IllegalArgumentException("Unknown table " + tableName);
        }
    }
}
