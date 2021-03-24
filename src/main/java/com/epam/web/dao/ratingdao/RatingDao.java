package com.epam.web.dao.ratingdao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.Rating;
import com.epam.web.entity.User;

public class RatingDao extends AbstractDao<Rating> {
    public RatingDao(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Rating.TABLE), FieldExtractorFactory.createFieldExtractor(Rating.TABLE),Rating.TABLE);
    }
}
